package com.cronnoss.spring5recipeapp.services;

import com.cronnoss.spring5recipeapp.commands.IngredientCommand;

public interface IngredientService {

    IngredientCommand findByRecipeIdAndIngredientId(Long recipeID, Long ingredientId);

}
