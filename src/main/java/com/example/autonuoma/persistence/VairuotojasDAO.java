package com.example.autonuoma.persistence;

import com.example.autonuoma.entities.Aikstele;
import com.example.autonuoma.entities.Automobilis;
import com.example.autonuoma.entities.Vairuotojas;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class VairuotojasDAO {
    @Inject
    private EntityManager em;

    public List<Vairuotojas> loadAll() {
        return em.createNamedQuery("Vairuotojas.findAll", Vairuotojas.class).getResultList();
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public void persist(Vairuotojas vairuotojas){
        this.em.persist(vairuotojas);
    }

    public Vairuotojas findOne(Long id){
        return em.find(Vairuotojas.class, id);
    }

    public Vairuotojas update(Vairuotojas vairuotojas){
        return em.merge(vairuotojas);
    }

}
