package com.example.autonuoma.service;

import com.example.autonuoma.inter.LoggedInvocation;
import com.example.autonuoma.usecases.VinGenerator;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import java.util.Random;

@Alternative
@ApplicationScoped
public class AlternativeMaker implements VinMaker {

    @LoggedInvocation
    public String makeVin(String marke, String modelis) {
        String vin = marke.substring(0,2);
        for (int i=0; i<5; i++){
            vin += new Random().nextInt(10);
        }
        vin += modelis.substring(0,1);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return vin;
    }
}
