package com.example.autonuoma.rest.contracts;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AutomobiliaiDto {
    private Long id;
    private String marke;
    private String modelis;
    private String vin;
}