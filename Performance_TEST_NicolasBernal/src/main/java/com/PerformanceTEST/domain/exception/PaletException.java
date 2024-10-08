package com.PerformanceTEST.domain.exception;

public class PaletException {
    public static class PaletCapacityExceededException extends Exception {
        public PaletCapacityExceededException(String message) {
            super(message);
        }
    }
}
