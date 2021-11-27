package org.fpm.di.exceptionalBehaviour;

import org.fpm.di.Binder;
import org.fpm.di.Composertest.C;
import org.fpm.di.Configuration;
import org.fpm.di.example.A;
import org.fpm.di.example.B;

public class PoorConfiguration_Class implements Configuration {
    @Override
    public void configure(Binder binder) {
        binder.bind(A.class);
        binder.bind(A.class);
    }
}
