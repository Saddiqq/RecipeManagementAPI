package com.example.Recipe.Management.API.Service;

import com.example.Recipe.Management.API.Model.Recipe;
import com.example.Recipe.Management.API.Repository.RecipeRepository;
import com.example.Recipe.Management.API.RequestObject.RecipeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class RecipeService {

    @Autowired //Autowired to interact with the database.

    RecipeRepository recipeRepository;

    public String saveRecipe(RecipeRequest recipeRequest) {
        Recipe recipe = new Recipe();
        recipe = RecipeRequest.convertToEntity(recipe, recipeRequest);
        recipe.setCreatedDate(new Date());
        recipe.setIsActive(Boolean.TRUE);
        recipeRepository.save(recipe);
        return "Success";
    }
}