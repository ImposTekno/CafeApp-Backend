package com.ImposTekno.CafeApp.CustomExceptions;

import javassist.NotFoundException;

public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException(String msg) {
        super(msg);
    }
}
