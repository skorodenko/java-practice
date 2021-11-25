package org.fpm.Live;

import org.fpm.di.Container;
import org.fpm.di.DependencyEnvironment;
import org.fpm.di.Environment;

public class Live {

    public static void main(String[] args) {
        Environment env = new DependencyEnvironment();
        Container container = env.configure(new LiveConfiguration());

    }
}
