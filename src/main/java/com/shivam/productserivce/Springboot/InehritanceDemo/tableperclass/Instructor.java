package com.shivam.productserivce.Springboot.InehritanceDemo.tableperclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="instructor_tbc")
public class Instructor extends User {

    private String specialization;
}
