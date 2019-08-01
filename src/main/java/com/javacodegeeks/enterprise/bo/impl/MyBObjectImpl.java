package com.javacodegeeks.enterprise.bo.impl;

import com.javacodegeeks.enterprise.bo.MyBObject;
import org.springframework.stereotype.Component;

@Component
public class MyBObjectImpl implements MyBObject {

    @Override
    public String printMessage() {
        return "Hello from Java Code Geeks JAXWS with Spring Tutorial";
    }
}