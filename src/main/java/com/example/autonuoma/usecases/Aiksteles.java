package com.example.autonuoma.usecases;

import com.example.autonuoma.entities.Aikstele;
import com.example.autonuoma.persistence.AiksteleDAO;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class Aiksteles {

    @Inject
    private AiksteleDAO aikstelesDAO;

    @Getter @Setter
    private Aikstele aiksteleToCreate = new Aikstele();

    @Getter
    private List<Aikstele> allAiksteles;

    @PostConstruct
    public void init(){
        loadAllAiksteles();
    }

    @Transactional
    public void createAikstele(){
        this.aikstelesDAO.persist(aiksteleToCreate);
    }

    private void loadAllAiksteles(){
        this.allAiksteles = aikstelesDAO.loadAll();
    }
}