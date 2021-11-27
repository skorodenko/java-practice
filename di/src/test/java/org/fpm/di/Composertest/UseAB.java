package org.fpm.di.Composertest;


import org.fpm.di.example.A;
import org.fpm.di.example.B;

import javax.inject.Inject;

public class UseAB {
    private final A dependencyA;
    private final B dependencyB;

    @Inject
    public UseAB(A a, B b) {
        this.dependencyA = a;
        this.dependencyB = b;
    }

    public A getADependency() {
        return dependencyA;
    }

    public B getBDependency() {
        return dependencyB;
    }

}
