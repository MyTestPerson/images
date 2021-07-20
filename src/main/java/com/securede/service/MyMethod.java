package com.securede.service;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class MyMethod {

    @PreAuthorize("hasRole('ADMIN')")
    public String myMsg() {
        return "Hello ";
    }

}
