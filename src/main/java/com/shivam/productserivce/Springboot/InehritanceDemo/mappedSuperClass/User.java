package com.shivam.productserivce.Springboot.InehritanceDemo.mappedSuperClass;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public class User {


    @Id
    private long id;
    private String name;
    private String email;
}
