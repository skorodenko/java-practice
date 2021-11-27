package org.fpm.di.exceptionalBehaviour;

import org.fpm.di.DependencyEnvironment;
import org.fpm.di.Environment;
import org.fpm.di.example.A;
import org.fpm.di.example.B;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;

public class ExceptionalExample {

    private Environment env;

    @Before
    public void setUp() {
        env = new DependencyEnvironment();
        //container = env.configure(new PoorConfiguration());
    }

    @Test(expected = VerifyError.class)
    public void sholdThrowError1() {
        /*
        binder.bind(org.fpm.Live.A.class, org.fpm.Live.B.class);
        binder.bind(org.fpm.Live.A.class, org.fpm.Live.C.class);
         */
        env.configure(new PoorConfiguration_ClassToClass());
    }

    @Test(expected = VerifyError.class)
    public void shouldThrowError2() {
        /*
        binder.bind(A.class);
        binder.bind(A.class);
         */
        env.configure(new PoorConfiguration_Class());
    }

    @Test(expected = VerifyError.class)
    public void shouldThrowError3() {
        /*
        binder.bind(A.class, new A());
        binder.bind(A.class, new B());
         */
        env.configure(new PoorConfiguration_ClassToObject());
    }
}
