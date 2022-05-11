package com.example.autonuoma.usecases;

import com.example.autonuoma.mybatis.dao.AiksteleMapper;
import com.example.autonuoma.mybatis.model.Aikstele;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class AikstelesMyBatis {
    @Inject
    private AiksteleMapper aiksteleMapper;

    @Getter
    private List<Aikstele> allAiksteles;

    @Getter @Setter
    private Aikstele aiksteleToCreate = new Aikstele();

    @PostConstruct
    public void init() {
        this.loadAllTeams();
    }

    private void loadAllTeams() {
        this.allAiksteles = aiksteleMapper.selectAll();
    }

    @Transactional
    public String createAikstele() {
        aiksteleToCreate.setId(20L); //One time use insert, since troubles with MyBatis
        aiksteleMapper.insert(aiksteleToCreate);
        return "/myBatis/aiksteles";
    }
}