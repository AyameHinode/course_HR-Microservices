package com.repliforce.hrpayroll.entities;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Worker implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private Double dailyIncome;

    public Worker(){
    }

    public Worker(Long id, String name, Double dailyIncome){
        super();
        this.id = id;
        this.name = name;
        this.dailyIncome = dailyIncome;
    }

}
