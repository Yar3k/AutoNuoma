package com.example.autonuoma.usecases;

import com.example.autonuoma.entities.Vairuotojas;
import com.example.autonuoma.entities.Automobilis;
import com.example.autonuoma.inter.LoggedInvocation;
import com.example.autonuoma.persistence.MasinosDAO;
import com.example.autonuoma.persistence.VairuotojasDAO;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Model
public class Details implements Serializable {

    @Inject
    private VairuotojasDAO vairuotojasDAO;

    @Getter
    private Vairuotojas vairuotojas;

    @Inject
    private MasinosDAO masinosDAO;

    @Getter @Setter
    private int selectedID = 0;

    @PostConstruct
    public void init(){
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Long driverID = Long.parseLong(requestParameters.get("driverID"));
        this.vairuotojas = vairuotojasDAO.findOne(driverID);
    }

    @Transactional
    @LoggedInvocation
    public void assignCar() {
        Long autoid = new Long(selectedID);
        Automobilis auto = masinosDAO.findOne(autoid);
        List<Automobilis> temp = vairuotojas.getNuomotiAutomobiliai();
        temp.add(auto);
        vairuotojas.setNuomotiAutomobiliai(temp);
        vairuotojasDAO.update(vairuotojas);
    }
}
