package com.cronnoss.spring5recipeapp.services;

import com.cronnoss.spring5recipeapp.domain.Recipe;

import java.util.Set;

public interface RecipeService {

    Set<Recipe> getRecipes();
}
