package com.example.autonuoma.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(name = "Automobilis.findAll", query = "select a from Automobilis as a")
})
public class Automobilis implements Serializable {
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

    private List<Vairuotojas> vairuotojai = new ArrayList<>();;

    @ManyToMany(mappedBy = "nuomotiAutomobiliai")
    public List<Vairuotojas> getVairuotojai() {
        return vairuotojai;
    }

    public void setVairuotojai(List<Vairuotojas> vairuotojai) {
        this.vairuotojai = vairuotojai;
    }


    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (getClass() != obj.getClass())
            return false;

        final Automobilis other = (Automobilis) obj;

        if ((this.vin == null) ? other.vin != null : !this.vin.equals(other.vin)) {
            return false;

        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash +
                (this.vin != null
                        ? this.vin.hashCode()
                        : 0);
        return hash;
    }

    private Integer version;

    @Version
    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
