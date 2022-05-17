package com.example.autonuoma.usecases;

import com.example.autonuoma.entities.Automobilis;
import com.example.autonuoma.inter.LoggedInvocation;
import com.example.autonuoma.persistence.MasinosDAO;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Map;

@ViewScoped
@Named
@Getter @Setter
public class UpdateVIN implements Serializable {

    private Automobilis automobilis;

    @Inject
    private MasinosDAO masinosDAO;

    @PostConstruct
    private void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Long autoID = Long.parseLong(requestParameters.get("autoID"));
        this.automobilis = masinosDAO.findOne(autoID);
    }

    @Transactional
    @LoggedInvocation
    public String updatePlayerJerseyNumber() {
        try{
            masinosDAO.update(this.automobilis);
        } catch (OptimisticLockException e) {
            return "/auto.xhtml?faces-redirect=true&autoID=" + this.automobilis.getId() + "&error=optimistic-lock-exception";
        }
        return "auto.xhtml?autoID=" + this.automobilis.getId() + "&faces-redirect=true";
    }
}
