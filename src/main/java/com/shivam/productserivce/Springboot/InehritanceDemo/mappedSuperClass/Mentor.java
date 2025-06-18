package com.shivam.productserivce.Springboot.InehritanceDemo.mappedSuperClass;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="ms_mentor")
public class Mentor extends User {

   private String company;
    private double rating;
}
