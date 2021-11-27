package org.fpm.di.Composertest;

import org.fpm.di.example.A;
import org.fpm.di.example.B;

import javax.inject.Inject;

public class MultipleInjects2 {
    private final A dependencyA;
    private final B dependencyB;

    @Inject
    public MultipleInjects2(A a, C c) {
        this.dependencyA = a;
        this.dependencyB = null;
    }

    @Inject
    public MultipleInjects2(A a) {
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
