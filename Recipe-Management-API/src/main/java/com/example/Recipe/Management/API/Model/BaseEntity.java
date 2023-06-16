package com.example.Recipe.Management.API.Model;


import java.util.Date;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

// The `lombok` library annotations simplify the creation of getter, setter, and other boilerplate code
@Getter
@Setter

// `@Data` is a convenient shortcut annotation that includes Getter,Setter and other abbrievations
@Data

// The BaseEntity class represents a base entity with common attributes that other entities can inherit from
public class BaseEntity {
    // Represents the date and time when the entity was created
    Date createdDate;

    // Represents the date and time when the entity was last updated
    Date updatedDate;

    // Represents the status of the entity (active or inactive)
    Boolean isActive;
}
