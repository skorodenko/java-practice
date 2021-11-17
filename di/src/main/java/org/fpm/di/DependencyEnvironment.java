package org.fpm.di;


public class DependencyEnvironment implements Environment {

    @Override
    public Container configure(Configuration configuration) {
        DependencyContainer container = new DependencyContainer();
        Binder binder = new DependencyBinder(container.getDiMap(), container.getResolvedScope());

        configuration.configure(binder);

        return container;
    }
}
