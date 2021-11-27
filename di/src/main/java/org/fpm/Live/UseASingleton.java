package org.fpm.Live;


import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class UseASingleton {
    private final A dependencyA;

    @Inject
    public UseASingleton(A a) {
        this.dependencyA = a;
    }

    public A getADependency() {
        return dependencyA;
    }

}
