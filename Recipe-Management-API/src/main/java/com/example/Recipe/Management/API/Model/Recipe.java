package com.example.Recipe.Management.API.Model;

import lombok.Data;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Recipe {
    // Specifies that the `id` field is the primary key and will be automatically generated
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    String name;

    @ElementCollection   // @ElementCollection indicates that ingredients is a collection of simple elements
    List<String> ingredients;

    String instructions;

    Integer cookingTime;

    Date createdDate;

    Date updatedDate;

    Boolean isActive; // Represents the status of the recipe (active or inactive)
}