package com.example.autonuoma.service;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;

@Decorator
public abstract class DecoratorMaker implements VinMaker {

    @Inject
    @Delegate
    @Any
    VinMaker vinMaker;

    public String makeVin(String marke, String modelis) {
        String vin = vinMaker.makeVin(marke, modelis);
        vin = "TEST" + vin;
        return vin;
    }
}