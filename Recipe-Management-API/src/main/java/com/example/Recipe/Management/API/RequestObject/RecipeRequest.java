package com.example.Recipe.Management.API.RequestObject;

import com.example.Recipe.Management.API.Model.Recipe;
import lombok.Data;

import java.util.List;

@Data
public class RecipeRequest {
    String recipeName;
    List<String> recipeIngredients;
    String recipeInstructions;
    Integer recipeCookingTime;


    public static Recipe convertToEntity(Recipe entity, RecipeRequest request){
        entity.setCookingTime(request.getRecipeCookingTime());
        entity.setName(request.getRecipeName());
        entity.setInstructions(request.getRecipeInstructions());
        entity.setIngredients(request.getRecipeIngredients());
        return entity;
    }
}
