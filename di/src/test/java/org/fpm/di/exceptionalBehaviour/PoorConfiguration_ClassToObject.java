package org.fpm.di.exceptionalBehaviour;

import org.fpm.di.Binder;
import org.fpm.di.Composertest.C;
import org.fpm.di.Configuration;
import org.fpm.di.example.A;
import org.fpm.di.example.B;

public class PoorConfiguration_ClassToObject implements Configuration {
    @Override
    public void configure(Binder binder) {
        binder.bind(A.class, new A());
        binder.bind(A.class, new B());
    }
}
