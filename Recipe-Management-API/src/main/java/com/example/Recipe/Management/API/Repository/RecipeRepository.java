package com.example.Recipe.Management.API.Repository;

import com.example.Recipe.Management.API.Model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Indicates that this interface is a repository that handles data access

// The RecipeRepository interface extends the JpaRepository interface
// The JpaRepository provides CRUD (Create, Read, Update, Delete) operations for the Recipe entity
public interface RecipeRepository extends JpaRepository<Recipe, Integer>{




    // The RecipeRepository interface is parameterized with the Recipe entity type and the type of the primary key (Long in this case)
}

