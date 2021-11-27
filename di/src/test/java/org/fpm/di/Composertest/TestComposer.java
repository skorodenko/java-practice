package org.fpm.di.Composertest;

import org.fpm.di.Container;
import org.fpm.di.DependencyEnvironment;
import org.fpm.di.Environment;
import org.fpm.di.example.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestComposer {

    private Container container;

    @Before
    public void setUp() {
        Environment env = new DependencyEnvironment();
        container = env.configure(new MyConfiguration());
    }

    @Test(expected = RuntimeException.class)
    public void shouldThrowRuntimeException() {
        // C class isn't mentioned in configuration,
        // so the object cannot be created.
        container.getComponent(C.class);
    }

    @Test
    public void compoundInjection() {
        // binder.bind(A.class, B.class);
        // binder.bind(B.class, new B());
        Assert.assertSame(container.getComponent(UseAB.class).getADependency(),
                          container.getComponent(UseAB.class).getBDependency());
    }

    @Test
    public void shouldReturnNotSame() {
        // Previous class should be different object
        // with same A,B dependencies
        Assert.assertNotSame(container.getComponent(UseAB.class),
                             container.getComponent(UseAB.class));
    }

    @Test
    public void singletonInjection() {
        // Singleton is Singleton, even though UseASingleton is injected
        // with A dependency.
        Assert.assertSame(container.getComponent(UseASingleton.class),
                          container.getComponent(UseASingleton.class));
    }

    @Test
    public void multipleInjectors1() {
        // Should use constructor with 2 dependencies
        // binder.bind(A.class, B.class);
        // binder.bind(B.class, new B());
        Assert.assertSame(container.getComponent(MultipleInjects1.class).getADependency(),
                          container.getComponent(MultipleInjects1.class).getBDependency());
    }

    @Test(expected = RuntimeException.class)
    public  void multipleInjectors2() {
        // Should use constructor with one dependency
        // C.class (see MultipleInjects2) cannot be created within this config.
        // binder.bind(A.class, B.class);
        // binder.bind(B.class, new B());
        MultipleInjects2 obj = container.getComponent(MultipleInjects2.class);

        Assert.assertSame(obj.getADependency(),
                          container.getComponent(A.class));
        Assert.assertSame(obj.getBDependency(),
                          null);
    }

    @Test(expected = RuntimeException.class)
    public void multipleInjectors3() {
        // Should throw RuntimeException,
        // because all constructors of this object
        // have unmet dependencies.
        container.getComponent(MultipleInjects3.class);
    }

}
