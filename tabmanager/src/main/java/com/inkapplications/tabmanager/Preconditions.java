package com.inkapplications.tabmanager;

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
