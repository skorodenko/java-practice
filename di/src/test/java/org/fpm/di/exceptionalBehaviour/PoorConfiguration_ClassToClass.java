package org.fpm.di.exceptionalBehaviour;

import org.fpm.di.Binder;
import org.fpm.di.Composertest.*;
import org.fpm.di.Configuration;
import org.fpm.di.example.*;

public class PoorConfiguration_ClassToClass implements Configuration {
    @Override
    public void configure(Binder binder) {
        binder.bind(A.class, B.class);
        binder.bind(A.class, C.class);
        binder.bind(B.class, new B());
    }
}
