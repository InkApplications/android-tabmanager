package com.inkapplications.tabmanager.support;

class Preconditions {
    private Preconditions() {
        // No instantiation
    }

    static <T> T checkNotNull(T object) {
        if (object == null) {
            throw new NullPointerException();
        }
        return object;
    }
}
