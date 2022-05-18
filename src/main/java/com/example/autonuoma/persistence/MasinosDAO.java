package com.example.autonuoma.persistence;

import com.example.autonuoma.entities.Aikstele;
import com.example.autonuoma.entities.Automobilis;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

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
        Automobilis updated = em.merge(player);
        //em.flush();
        return updated;
    }

    public List<Automobilis> loadAll() {
        return em.createNamedQuery("Automobilis.findAll", Automobilis.class).getResultList();
    }
}