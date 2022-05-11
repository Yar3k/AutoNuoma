package com.example.autonuoma.usecases;

import com.example.autonuoma.entities.Vairuotojas;
import com.example.autonuoma.entities.Automobilis;
import com.example.autonuoma.persistence.VairuotojasDAO;
import lombok.Getter;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Model
public class Details implements Serializable {

    @Inject
    private VairuotojasDAO vairuotojasDAO;

    @Getter
    private Vairuotojas vairuotojas;

    @PostConstruct
    public void init(){
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Long driverID = Long.parseLong(requestParameters.get("driverID"));
        this.vairuotojas = vairuotojasDAO.findOne(driverID);
    }
}
