package com.tecsup.petclinic.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "specialties")
public class Specialty {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;
   @Column(length = 80)
   private String name;
   @Column(length = 40)
   private String office;
   private Integer h_open;
   private Integer h_close;

   public Specialty(String name, String office, Integer h_open, Integer h_close) {
      this.name = name;
      this.office = office;
      this.h_open = h_open;
      this.h_close = h_close;
   }
}
