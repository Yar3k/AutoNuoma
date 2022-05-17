package com.example.autonuoma.service;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;
import java.util.Random;

@Default
@ApplicationScoped
public class DefaultMaker implements VinMaker {
    @Override
    public String makeVin(String marke, String modelis) {
        String vin = marke.substring(0,2);
        for (int i=0; i<10; i++){
            vin += new Random().nextInt(10);
        }
        return vin;
    }
}
