package com.example.Recipe.Management.API.Controller;

import com.example.Recipe.Management.API.RequestObject.RecipeRequest;
import com.example.Recipe.Management.API.Service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// The `@RestController` annotation indicates that this class handles HTTP requests and returns the response as the body of the response.
@RestController
// The `@RequestMapping` annotation specifies the base URL path for the endpoints in this controller.
@RequestMapping(value = "/recipe")
public class RecipeController {

    @Autowired // The RecipeService is autowired to handle the business logic related to recipes.

    RecipeService recipeService;

    @PostMapping(value = "/api/recipes")

    // The saveRecipe method receives a POST request containing recipe details.
    public String saveRecipe(@RequestBody RecipeRequest recipeRequest) {

        // The recipeService is called to handle recipe saving.
        recipeService.saveRecipe(recipeRequest);
        return "Success";
    }
}