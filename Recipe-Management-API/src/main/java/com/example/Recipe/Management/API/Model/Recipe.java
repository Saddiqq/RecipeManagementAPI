package com.example.Recipe.Management.API.Model;

import lombok.Data;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    String name;

    @ElementCollection
    List<String> ingredients;

    String instructions;

    Integer cookingTime;

    Date createdDate;

    Date updatedDate;

    Boolean isActive;
}
