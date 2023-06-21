package com.example.Recipe.Management.API.Controller;

import com.example.Recipe.Management.API.Model.Recipe;
import com.example.Recipe.Management.API.Repository.RecipeRepository;
import com.example.Recipe.Management.API.RequestObject.RecipeRequest;
import com.example.Recipe.Management.API.ResponseObject.RecipeResponce;
import com.example.Recipe.Management.API.Service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


// The `@RestController` annotation indicates that this class handles HTTP requests and returns the response as the body of the response.
@RestController
// The `@RequestMapping` annotation specifies the base URL path for the endpoints in this controller.
@RequestMapping(value = "/recipe")
public class RecipeController {

    @Autowired // The RecipeService is autowired to handle the business logic related to recipes.
    RecipeService recipeService;
    @Autowired
    RecipeRepository recipeRepository;

    @PostMapping(value = "/api/recipes")
    // The saveRecipe method receives a POST request containing recipe details.
    public String saveRecipe(@RequestBody RecipeRequest recipeRequest) {

        // The recipeService is called to handle recipe saving.
        recipeService.saveRecipe(recipeRequest);
        return "Success";
    }

    @GetMapping(value = "/api/recipes")
    // The getRecipeById method receives a GET request specifying the recipe ID.
    public RecipeResponce getRecipeById(@RequestParam Integer recipeId) {
        return recipeService.getRecipeById(recipeId);
    }

    @DeleteMapping("/api/recipes/{recipeId}")
    public ResponseEntity<Void> deleteRecipe(@PathVariable Integer recipeId) {
        recipeRepository.deleteById(recipeId); // Delete the recipe from the database using the provided recipeId
        return ResponseEntity.noContent().build();  // Return a ResponseEntity with a No Content (204) status code indicating successful deletion
    }
    @GetMapping("/api/recipes/search")
    public ResponseEntity<List<RecipeResponce>> searchRecipes(@RequestParam("keywords") String keywords) {
        List<Recipe> recipes = recipeService.searchRecipes(keywords);
        List<RecipeResponce> recipeResponses = recipes.stream()
                .map(RecipeResponce::convertToResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(recipeResponses);
    }
    @PutMapping("/api/recipes/{recipeId}")
    public ResponseEntity<Void> updateRecipe(@PathVariable Integer recipeId, @RequestBody RecipeRequest recipeRequest) {
        recipeService.updateRecipe(recipeId, recipeRequest);
        return ResponseEntity.ok().build();
    }


}