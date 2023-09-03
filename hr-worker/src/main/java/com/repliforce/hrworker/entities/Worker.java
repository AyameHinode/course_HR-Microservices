package com.repliforce.hrworker.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "tb_workers")
public class Worker implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
