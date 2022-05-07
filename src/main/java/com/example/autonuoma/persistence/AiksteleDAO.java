package com.example.autonuoma.persistence;

import com.example.autonuoma.entities.Aikstele;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class AiksteleDAO {

    @Inject
    private EntityManager em;

    public List<Aikstele> loadAll() {
        return em.createNamedQuery("Aikstele.findAll", Aikstele.class).getResultList();
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public void persist(Aikstele aikstele){
        this.em.persist(aikstele);
    }

    public Aikstele findOne(Long id) {
        return em.find(Aikstele.class, id);
    }
}