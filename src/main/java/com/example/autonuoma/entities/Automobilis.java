package com.example.autonuoma.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(name = "Automobilis.findAll", query = "select a from Automobilis as a")
})
public class Automobilis {
    private Long id;

    @Id
    @GeneratedValue()
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private String marke;

    @Basic(optional = false)
    public String getMarke() {
        return marke;
    }

    public void setMarke(String marke) {
        this.marke = marke;
    }

    private String modelis;

    @Basic(optional = false)
    public String getModelis() {
        return modelis;
    }

    public void setModelis(String modelis) {
        this.modelis = modelis;
    }

    private Aikstele aikstele;

    @ManyToOne
    public Aikstele getAikstele() {
        return aikstele;
    }

    public void setAikstele(Aikstele aikstele) {
        this.aikstele = aikstele;
    }

    private String vin;

    @Basic(optional = false)
    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    private List<Vairuotojas> vairuotojai;

    @ManyToMany(mappedBy = "ak")
    public List<Vairuotojas> getVairuotojai() {
        return vairuotojai;
    }

    public void setVairuotojai(List<Vairuotojas> vairuotojai) {
        this.vairuotojai = vairuotojai;
    }
}
