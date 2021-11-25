package org.fpm.di;


import javax.inject.Inject;
import javax.inject.Singleton;
import javax.management.RuntimeErrorException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.stream.Collectors;



public class DependencyContainer implements Container{

    // Map with
    // Key: class
    // Value: implementation
    private final Map<Class<?>, Class<?>> diMap;

    // Scope of resolved objects
    // Class binds to Object in two cases:
    //  * Class binds to instance in configuration
    //  * Singleton class (when it is first created)
    private final Map<Class<?>, Object> resolvedScope;

    public DependencyContainer() {
        this.diMap = new HashMap<>();
        this.resolvedScope = new HashMap<>();
    }

    public Map<Class<?>, Class<?>> getDiMap() {
        return diMap;
    }

    public Map<Class<?>, Object> getResolvedScope() {
        return resolvedScope;
    }

    @Override
    public <T> T getComponent(Class<T> clazz) {
        return getInstance(clazz);
    }

    @SuppressWarnings("unchecked")
    private <T> T getInstance(Class<T> interfaceClass) {

        // Added Synchronized statement to ensure safe multithreading,
        // so that resolvedScope couldn't be changed simultaneously.
        synchronized (resolvedScope) {
            Class<?> implementationClass = getImplementationClass(interfaceClass);

            // Checks if implementation is bound to Object, or Singleton (which was created before)
            if (resolvedScope.containsKey(implementationClass)) {
                return (T) resolvedScope.get(implementationClass);
            }

            Object service = null;
            Constructor<?>[] ctors = implementationClass.getConstructors();

            // Searching for constructors with @Inject annotation
            List<Constructor<?>> constructorInjection = Arrays.stream(ctors)
                    .filter(ctor -> ctor.getAnnotation(Inject.class) != null)
                    .collect(Collectors.toList());

            // Class (implementation) is created following by next rules:
            //  * If object has no constructor (no injection) -> create instance
            //  * If object has constructor with Injection -> create instance(dependencies)
            //  * If object has >=1 constructors with Injection:
            //      - They are sorted by the number of dependencies
            //      - Then trying to create at least one
            //      - If one is created it is returned
            //      - If one cannot be created -> RuntimeException
            if(!constructorInjection.isEmpty()) {
                for(Constructor<?> ctor: constructorInjection) {
                    try {
                        Class<?>[] ctorArguments = ctor.getParameterTypes();
                        List<Object> objects = new ArrayList<>();
                        for(Class<?> arg: ctorArguments) {
                            objects.add(getInstance(arg));
                        }
                        service = ctor.newInstance(objects.toArray());
                    }
                    // RuntimeException is ignored, because it just indicates
                    // that some dependency cannot be created for this constructor.
                    // And if this constructor has unmet dependencies, then we can
                    // try the next one.
                    catch (RuntimeErrorException ignore) {
                        // Just to clarify things ;)
                        continue;
                    } catch (InvocationTargetException | InstantiationException | IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
                // If all constructors have unmet dependencies -> RuntimeException.
                if(service == null) {
                    throw new RuntimeException("Cannot create " + implementationClass.toString() +
                            " from any constructor");
                }
            } else {
                try {
                    service = implementationClass.newInstance();
                } catch (InstantiationException | IllegalAccessException e) {
                    e.printStackTrace();
                }
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
        if (implementationClasses.size() == 0) {
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
        }
        throw new RuntimeException(errorMessage);
    }
}
