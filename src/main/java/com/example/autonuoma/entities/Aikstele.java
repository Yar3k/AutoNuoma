package com.example.autonuoma.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(name = "Aikstele.findAll", query = "select t from Aikstele as t")
})
public class Aikstele {
    private Long id;

    @Id
    @GeneratedValue()
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private String adresas;

    @Basic
    public String getAdresas() {
        return adresas;
    }

    public void setAdresas(String adresas) {
        this.adresas = adresas;
    }

    private List<Automobilis> automobilis;

    @OneToMany(mappedBy = "aikstele")
    public List<Automobilis> getAutomobiliai() {
        return automobilis;
    }

    public void setAutomobiliai(List<Automobilis> automobilis) {
        this.automobilis = automobilis;
    }
}
