package com.example.Recipe.Management.API.Model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Data

public class Recipe extends  BaseEntity{
    // Specifies that the `id` field is the primary key and will be automatically generated
@Id
@GeneratedValue(strategy = GenerationType.AUTO)

    long id;
String name; //name of the recipe
String ingredients; //list of ingredients required for the recipe
String instruction; //instructions for preparing the recipe
Integer CookingTime; //cooking time required
}
