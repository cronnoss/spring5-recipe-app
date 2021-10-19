package com.cronnoss.spring5recipeapp.converters;

import com.cronnoss.spring5recipeapp.commands.RecipeCommand;
import com.cronnoss.spring5recipeapp.domain.Recipe;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class RecipeCommandToRecipe implements Converter<RecipeCommand, Recipe> {

    private final com.cronnoss.spring5recipeapp.converters.CategoryCommandToCategory categoryConveter;
    private final com.cronnoss.spring5recipeapp.converters.IngredientCommandToIngredient ingredientConverter;
    private final com.cronnoss.spring5recipeapp.converters.NotesCommandToNotes notesConverter;

    public RecipeCommandToRecipe(com.cronnoss.spring5recipeapp.converters.CategoryCommandToCategory categoryConveter, com.cronnoss.spring5recipeapp.converters.IngredientCommandToIngredient ingredientConverter,
                                 com.cronnoss.spring5recipeapp.converters.NotesCommandToNotes notesConverter) {
        this.categoryConveter = categoryConveter;
        this.ingredientConverter = ingredientConverter;
        this.notesConverter = notesConverter;
    }

    @Synchronized
    @Nullable
    @Override
    public Recipe convert(RecipeCommand source) {
        if (source == null) {
            return null;
        }

        final Recipe recipe = new Recipe();
        recipe.setId(source.getId());
        recipe.setCookTime(source.getCookTime());
        recipe.setPrepTime(source.getPrepTime());
        recipe.setDescription(source.getDescription());
        recipe.setDifficulty(source.getDifficulty());
        recipe.setDirections(source.getDirections());
        recipe.setServings(source.getServings());
        recipe.setSource(source.getSource());
        recipe.setUrl(source.getUrl());
        recipe.setNotes(notesConverter.convert(source.getNotes()));

        if (source.getCategories() != null && source.getCategories().size() > 0) {
            source.getCategories()
                    .forEach(category -> recipe.getCategories().add(categoryConveter.convert(category)));
        }

        if (source.getIngredients() != null && source.getIngredients().size() > 0) {
            source.getIngredients()
                    .forEach(ingredient -> recipe.getIngredients().add(ingredientConverter.convert(ingredient)));
        }

        return recipe;
    }
}
