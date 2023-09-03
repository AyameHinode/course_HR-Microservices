package com.repliforce.hrpayroll.entities;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Payment implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private Double dailyIncome;
    private Integer days;

    public Payment(){

    }

    public Payment(String name, Double dailyIncome, Integer days){
        super();
        this.name = name;
        this.dailyIncome = dailyIncome;
        this.days = days;
    }

    public double getTotal(){
        return days * dailyIncome;
    }

}
