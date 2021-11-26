package com.ImposTekno.CafeApp.CustomExceptions;

import javassist.NotFoundException;

public class ModelNotFoundException extends RuntimeException {

    public ModelNotFoundException(String msg) {
        super(msg);
    }
}
