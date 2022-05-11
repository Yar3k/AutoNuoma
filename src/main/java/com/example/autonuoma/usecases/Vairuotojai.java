package com.example.autonuoma.usecases;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.example.autonuoma.entities.Automobilis;
import com.example.autonuoma.entities.Vairuotojas;
import com.example.autonuoma.inter.LoggedInvocation;
import com.example.autonuoma.persistence.MasinosDAO;
import com.example.autonuoma.persistence.VairuotojasDAO;
import lombok.Getter;
import lombok.Setter;

@Model
public class Vairuotojai implements Serializable {

    @Inject
    private VairuotojasDAO vairuotojasDAO;

    @Inject
    private MasinosDAO masinosDAO;

    @Getter @Setter
    private Automobilis auto;

    @Getter @Setter
    private Vairuotojas vairuotojasToAssign = new Vairuotojas();

    @PostConstruct
    public void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Long autoId = Long.parseLong(requestParameters.get("autoID"));
        this.auto = masinosDAO.findOne(autoId);
    }

    @Transactional
    @LoggedInvocation
    public void assignDriver() {
        List<Automobilis> temp = vairuotojasToAssign.getNuomotiAutomobiliai();
        temp.add(this.auto);
        vairuotojasToAssign.setNuomotiAutomobiliai(temp);
        vairuotojasToAssign.setAk("");
        vairuotojasDAO.persist(vairuotojasToAssign);
    }
}