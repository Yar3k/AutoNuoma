package com.example.autonuoma.service;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Specializes;
import java.util.Random;

@Specializes
@ApplicationScoped
public class SpecialGenerator extends DefaultMaker {
    public String makeVin(String marke, String modelis) {
        String vin = marke.substring(0,1);
        vin += modelis.substring(0,1);
        for (int i=0; i<10; i++){
            vin += new Random().nextInt(5);
        }
        return vin;
    }
}