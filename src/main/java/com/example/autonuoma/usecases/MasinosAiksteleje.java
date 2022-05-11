package com.example.autonuoma.usecases;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Map;

import com.example.autonuoma.entities.Aikstele;
import com.example.autonuoma.entities.Automobilis;
import com.example.autonuoma.inter.LoggedInvocation;
import com.example.autonuoma.persistence.AiksteleDAO;
import com.example.autonuoma.persistence.MasinosDAO;
import lombok.Getter;
import lombok.Setter;

@Model
public class MasinosAiksteleje implements Serializable {

    @Inject
    private AiksteleDAO aiksteleDAO;

    @Inject
    private MasinosDAO masinosDAO;

    @Getter @Setter
    private Aikstele aikstele;

    @Getter @Setter
    private Automobilis automobilisToCreate = new Automobilis();

    @PostConstruct
    public void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Long aiksteleId = Long.parseLong(requestParameters.get("aiksteleId"));
        this.aikstele = aiksteleDAO.findOne(aiksteleId);
    }

    @Transactional
    @LoggedInvocation
    public void createAuto() {
        automobilisToCreate.setAikstele(this.aikstele);
        masinosDAO.persist(automobilisToCreate);
    }
}