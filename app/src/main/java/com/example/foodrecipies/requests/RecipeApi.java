package com.example.foodrecipies.requests;

import com.example.foodrecipies.models.Recipe;
import com.example.foodrecipies.requests.responses.RecipeResponse;
import com.example.foodrecipies.requests.responses.RecipeSearchResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RecipeApi {
    //SEARCH
    @GET("api/search")  //https://recipesapi.herokuapp.com/api/search?q={query}&page={page}
    Call<RecipeSearchResponse> searchRecipe(
      @Query("q") String query,
      @Query("page") String page
    );

    //GET RECIPE REQUEST
    @GET("api/get")
    Call<RecipeResponse> getRecipe(
            @Query("rId") String recipe_id
    );

}
