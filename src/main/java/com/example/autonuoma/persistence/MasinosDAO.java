package com.example.autonuoma.persistence;

import com.example.autonuoma.entities.Automobilis;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@ApplicationScoped
public class MasinosDAO {

    @Inject
    private EntityManager em;

    public void persist(Automobilis automobilis){
        this.em.persist(automobilis);
    }

    public Automobilis findOne(Long id){
        return em.find(Automobilis.class, id);
    }

    public Automobilis update(Automobilis player){
        return em.merge(player);
    }
}