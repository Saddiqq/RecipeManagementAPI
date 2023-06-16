package com.example.Recipe.Management.API.ResponseObject;

import com.example.Recipe.Management.API.Model.Recipe;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class RecipeResponce {
    Integer id;
    String recipeName;
    List<String> recipeIngredients;
    String recipeInstructions;
    Integer recipeCookingTime;


    // The convertToResponse method is a static method used to convert a Recipe entity object to a RecipeResponse object.
    public static RecipeResponce convertToResponse(Recipe entity) {

         /*/
builder:provides an alternative way to construct complex objects. It allows you to specify only the required attributes and provides a fluent interface to set optional attributes.
         */
        return RecipeResponce.builder()
                .id(entity.getId())
                .recipeIngredients(entity.getIngredients())
                .recipeCookingTime(entity.getCookingTime())
                .recipeInstructions(entity.getInstructions())
                .build(); // Builds and returns the RecipeResponse object.

    }
}
