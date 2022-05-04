package com.microservice.product.exception;

public class RecordAlreadyExistsException extends RuntimeException {
        public RecordAlreadyExistsException(String s) {
            super(s);
        }

    }
