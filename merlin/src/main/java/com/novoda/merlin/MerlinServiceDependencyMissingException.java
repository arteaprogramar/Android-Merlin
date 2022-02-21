package com.novoda.merlin;

import java.util.Locale;

class MerlinServiceDependencyMissingException extends IllegalStateException {

    private static final String DEPENDENCY_ASSERT_FORMAT = "%s must be bound to %s.";

    private MerlinServiceDependencyMissingException(String message) {
        super(message);
    }

    static MerlinServiceDependencyMissingException missing(Class dependency) {
        String message = String.format(
                Locale.ENGLISH,
                DEPENDENCY_ASSERT_FORMAT,
                dependency,
                MerlinService.class
        );
        return new MerlinServiceDependencyMissingException(message);
    }
}
