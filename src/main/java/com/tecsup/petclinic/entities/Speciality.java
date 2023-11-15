package com.tecsup.petclinic.entities;

import lombok.Data;

import javax.persistence.*;

@Table(name="specialties")
@Entity
@Data
public class Speciality {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    private String office;
    private Integer h_open;
    private Integer h_close;

    public Speciality (String name,String office,Integer h_open,Integer h_close){
        this.name = name;
        this.office=office;
        this.h_open=h_open;
        this.h_close=h_close;
    }

    public Speciality() {

    }
}
