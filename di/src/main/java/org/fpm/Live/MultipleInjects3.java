package org.fpm.Live;

import javax.inject.Inject;

public class MultipleInjects3 {

    @Inject
    public MultipleInjects3(C c, D d) {
    }

    @Inject
    public MultipleInjects3(C c) {
    }

}
