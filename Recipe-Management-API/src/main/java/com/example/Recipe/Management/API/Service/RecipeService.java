package com.example.Recipe.Management.API.Service;

import com.example.Recipe.Management.API.Model.Recipe;
import com.example.Recipe.Management.API.Repository.RecipeRepository;
import com.example.Recipe.Management.API.RequestObject.RecipeRequest;
import com.example.Recipe.Management.API.ResponseObject.RecipeResponce;
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

    public RecipeResponce getRecipeById(Integer recipeId) {
        return RecipeResponce.convertToResponse(recipeRepository.findById(recipeId).get());
/*/    Find the recipe in the database by its ID using the recipeRepository,
       Convert it to a RecipeResponse object, and return it.
 */
    }
    public void deleteRecipe(Integer recipeId) {
        recipeRepository.deleteById(recipeId); // Delete the recipe from the database using the provided recipeId
    }
    }




