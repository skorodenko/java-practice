package org.fpm.di.example;

import org.fpm.di.Binder;
import org.fpm.di.Composertest.*;
import org.fpm.di.Configuration;

public class MyConfiguration implements Configuration {
    @Override
    public void configure(Binder binder) {
        binder.bind(MySingleton.class);
        binder.bind(MyPrototype.class);

        binder.bind(UseASingleton.class);
        binder.bind(MultipleInjects1.class);
        binder.bind(MultipleInjects2.class);
        binder.bind(MultipleInjects3.class);


        binder.bind(UseA.class);
        binder.bind(UseAB.class);

        binder.bind(A.class, B.class);
        binder.bind(B.class, new B());
    }
}
