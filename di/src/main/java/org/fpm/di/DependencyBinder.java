package org.fpm.di;


import java.util.Map;

public class DependencyBinder implements Binder {

    private final Map<Class<?>, Class<?>> diMap;
    private final Map<Class<?>, Object> resolvedScope;

    public DependencyBinder(Map<Class<?>, Class<?>> diMap, Map<Class<?>, Object> resolvedScope) {
        this.diMap = diMap;
        this.resolvedScope = resolvedScope;
    }

    @Override
    public <T> void bind(Class<T> clazz) throws VerifyError {
        if(diMap.containsKey(clazz) || resolvedScope.containsKey(clazz)) {
            throw new VerifyError("More than one implementation detected for " +
                    clazz.toString());
        }
        diMap.put(clazz, clazz);
    }

    @Override
    public <T> void bind(Class<T> clazz, Class<? extends T> implementation) throws VerifyError {
        if(diMap.containsKey(clazz) || resolvedScope.containsKey(clazz)) {
            throw new VerifyError("More than one implementation detected for " +
                    clazz.toString());
        }
        diMap.put(clazz, implementation);
    }

    @Override
    public <T> void bind(Class<T> clazz, T instance) throws VerifyError {
        if(diMap.containsKey(clazz) || resolvedScope.containsKey(clazz)) {
            throw new VerifyError("More than one implementation detected for " +
                    clazz.toString());
        }
        resolvedScope.put(clazz, instance);
    }
}
