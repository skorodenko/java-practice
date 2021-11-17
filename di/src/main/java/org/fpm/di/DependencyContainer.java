package org.fpm.di;


import javax.inject.Inject;
import javax.inject.Singleton;
import javax.management.RuntimeErrorException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.stream.Collectors;



public class DependencyContainer implements Container{

    // Map with
    // Key: class
    // Value: implementation
    private Map<Class<?>, Class<?>> diMap;

    // Scope of resolved objects
    // Class binds to Object in two cases:
    //  * Class binds to instance in configuration
    //  * Singleton class (when it is first created)
    private final Map<Class<?>, Object> resolvedScope;

    public DependencyContainer() {
        this.diMap = new HashMap<>();
        this.resolvedScope = new HashMap<>();
    }

    public Map getDiMap() {
        return diMap;
    }

    public Map<Class<?>, Object> getResolvedScope() {
        return resolvedScope;
    }

    @Override
    public <T> T getComponent(Class<T> clazz) {
        try {
            return getInstance(clazz);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    public <T> T getInstance(Class<T> interfaceClass)
            throws InstantiationException, IllegalAccessException {
        Class<?> implementationClass = getImplementationClass(interfaceClass);

        // Added Synchronized statement to ensure safe multithreading,
        // so that resolvedScope couldn't be changed simultaneously.
        synchronized (resolvedScope) {

            // Checks if implementation is bound to Object, or Singleton (which was created before)
            if (resolvedScope.containsKey(implementationClass)) {
                return (T) resolvedScope.get(implementationClass);
            }

            Object service = null;
            Constructor<?>[] ctors = implementationClass.getConstructors();

            // Searching for constructors with @Inject annotation
            Optional<Constructor<?>> constructorInjection = Arrays.stream(ctors)
                    .filter(ctor -> ctor.getAnnotation(Inject.class) != null)
                    .findFirst();

            // Class (implementation) is created following by two rules:
            //  * If object has no constructor (no injection) -> create instance
            //  * If object has constructor with Injection -> create instance(dependencies)
            //  # If there is more than one constructor 1 is chosen randomly
            if(constructorInjection.isPresent()) {
                // This block should probably be simplified, though I haven't found any simple solution
                Constructor<?> ctor = constructorInjection.get();
                try {
                    Class<?>[] ctorArguments = ctor.getParameterTypes();
                    service = ctor.newInstance(
                            Arrays.stream(ctorArguments).map(x -> {
                                try {
                                    return getInstance(x);
                                } catch (InstantiationException e) {
                                    e.printStackTrace();
                                } catch (IllegalAccessException e) {
                                    e.printStackTrace();
                                }
                                return null;
                            }).toArray()
                    );
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }

            } else {
                service = implementationClass.newInstance();
            }

            // If implementationClass is singleton put it into scope
            // (for further usage)
            if(implementationClass.getAnnotation(Singleton.class) != null) {
                resolvedScope.put(implementationClass, service);
                return (T) service;
            }

            return (T) service;
        }
    }

    private Class<?> getImplementationClass(Class<?> interfaceClass) {
        // Search for class implementation in diMap keys
        Set<Map.Entry<Class<?>, Class<?>>> implementationClasses = diMap.entrySet().stream()
                .filter(entry -> entry.getKey() == interfaceClass).collect(Collectors.toSet());
        String errorMessage = "";
        if (implementationClasses == null || implementationClasses.size() == 0) {
            // No implementation in diMap means that there may be implementation in resolvedScope
            // (Class bound to Object)
            // Otherwise throw no implementation exception
            if (resolvedScope.containsKey(interfaceClass)) {
                return interfaceClass;
            }
            errorMessage = "No implementation found for interface " + interfaceClass.getName();
        } else if (implementationClasses.size() == 1) {
            // One implementation in diMap -> return its class name
            Optional<Map.Entry<Class<?>, Class<?>>> optional = implementationClasses.stream().findFirst();
            return optional.get().getValue();
        } else if (implementationClasses.size() > 1) {
            // Dependency conflict -> throw exception
            errorMessage = "There are " + implementationClasses.size() +
                    " implementations of interface " + interfaceClass.getName();
        }
        throw new RuntimeErrorException(new Error(errorMessage));
    }
}
