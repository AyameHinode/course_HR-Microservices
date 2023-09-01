package com.repliforce.hrworker.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Table(name = "tb_workers")
@Data
public class Worker implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
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
