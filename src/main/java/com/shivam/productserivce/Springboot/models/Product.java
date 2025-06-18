package com.shivam.productserivce.Springboot.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product extends BaseModel{
 private String title;
 private double price;
 private String description;

 @ManyToOne
 private Category category;

 /*product : category
  1 -> 1
 m<-1
*/
 private String imageurl;

}
