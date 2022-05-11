package com.example.autonuoma.usecases;

import com.example.autonuoma.entities.Vairuotojas;
import com.example.autonuoma.persistence.VairuotojasDAO;
import lombok.Getter;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;

@Model
public class VairuotojuManage implements Serializable {

    @Inject
    private VairuotojasDAO vairuotojasDAO;

    @Getter
    private List<Vairuotojas> allVairuotojai;

    @PostConstruct
    public void init(){
        loadAllVairuotojai();
    }

    private void loadAllVairuotojai(){
        this.allVairuotojai = vairuotojasDAO.loadAll();
    }
}
