package com.shivam.productserivce.Springboot.InehritanceDemo.tableperclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="mentor_tbc")
public class Mentor extends User {

   private String company;
    private double rating;
}
