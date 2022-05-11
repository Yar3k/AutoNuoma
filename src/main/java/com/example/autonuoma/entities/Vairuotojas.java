package com.example.autonuoma.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(name = "Vairuotojas.findAll", query = "select a from Vairuotojas as a")
})
public class Vairuotojas {
    private Long id;

    @Id
    @GeneratedValue()
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private String vardas;

    @Basic(optional = false)
    public String getVardas() {
        return vardas;
    }

    public void setVardas(String vardas) {
        this.vardas = vardas;
    }

    private String pavarde;

    @Basic(optional = false)
    public String getPavarde() {
        return pavarde;
    }

    public void setPavarde(String pavarde) {
        this.pavarde = pavarde;
    }

    private String ak;

    @Basic(optional = true)
    public String getAk() {
        return ak;
    }

    public void setAk(String ak) {
        this.ak = ak;
    }

    private List<Automobilis> nuomotiAutomobiliai = new ArrayList<>();;

    @ManyToMany()
    public List<Automobilis> getNuomotiAutomobiliai() {
        return nuomotiAutomobiliai;
    }

    public void setNuomotiAutomobiliai(List<Automobilis> nuomotiAutomobiliai) {
        this.nuomotiAutomobiliai = nuomotiAutomobiliai;
    }
}
