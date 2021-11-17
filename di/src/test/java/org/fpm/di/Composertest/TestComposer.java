package org.fpm.di.Composertest;

import org.fpm.di.Container;
import org.fpm.di.DependencyEnvironment;
import org.fpm.di.Environment;
import org.fpm.di.example.*;
import org.fpm.di.example.UseAB;

public class TestComposer {
    public static void main(String[] args) {

        Environment env = new DependencyEnvironment();
        Container container = env.configure(new MyConfiguration());

        System.out.println(container.getComponent(A.class));
        System.out.println(container.getComponent(B.class));
        System.out.println(container.getComponent(MySingleton.class));
        System.out.println(container.getComponent(MySingleton.class));
        System.out.println(container.getComponent(MyPrototype.class));
        System.out.println(container.getComponent(MyPrototype.class));
        // C class - some non-existent in configuration class (to test runtime behaviour)
        //System.out.println(container.getComponent(C.class));
        System.out.println(container.getComponent(UseA.class));
        // Next 2 instances are different, though composed of same A,B dependency
        System.out.println(container.getComponent(UseAB.class).getADependency());
        System.out.println(container.getComponent(UseAB.class).getBDependency());
    }
}
