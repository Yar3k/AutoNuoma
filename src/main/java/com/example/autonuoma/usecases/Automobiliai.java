package com.example.autonuoma.usecases;

import com.example.autonuoma.entities.Aikstele;
import com.example.autonuoma.entities.Automobilis;
import com.example.autonuoma.inter.LoggedInvocation;
import com.example.autonuoma.persistence.AiksteleDAO;
import com.example.autonuoma.persistence.MasinosDAO;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class Automobiliai {
    @Inject
    private MasinosDAO masinosDAO;

    @Getter
    private List<Automobilis> allAutomobiliai;

    @PostConstruct
    public void init(){
        loadAllAutomobiliai();
    }

    private void loadAllAutomobiliai(){
        this.allAutomobiliai = masinosDAO.loadAll();
    }
}
