package com.example.foodrecipies.util;

import android.util.Log;

import com.example.foodrecipies.models.Recipe;

import java.util.List;

public class Testing {
    public static void printRecipes(List<Recipe> recipeList, String tag){
        for(Recipe recipe: recipeList){
            Log.d(tag, "onChanged: "+recipe.getTitle());
        }

    }
}
