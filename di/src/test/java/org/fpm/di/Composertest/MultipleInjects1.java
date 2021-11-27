package org.fpm.di.Composertest;

import org.fpm.di.example.A;
import org.fpm.di.example.B;

import javax.inject.Inject;

public class MultipleInjects1 {
    private final A dependencyA;
    private final B dependencyB;

    @Inject
    public MultipleInjects1(A a, B b) {
        this.dependencyA = a;
        this.dependencyB = b;
    }

    @Inject
    public MultipleInjects1(A a) {
        this.dependencyA = a;
        this.dependencyB = null;
    }

    public A getADependency() {
        return dependencyA;
    }

    public B getBDependency() {
        return dependencyB;
    }
}
