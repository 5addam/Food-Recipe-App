package com.example.foodrecipies;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.foodrecipies.models.Recipe;
import com.example.foodrecipies.requests.RecipeApi;
import com.example.foodrecipies.requests.ServiceGenerator;
import com.example.foodrecipies.requests.responses.RecipeResponse;
import com.example.foodrecipies.requests.responses.RecipeSearchResponse;
import com.example.foodrecipies.viewmodels.RecipeListViewModel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecipeListActivity extends BaseActivity {

    private static final String TAG = "RecipeListActivity";

    private RecipeListViewModel recipeListViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_list);

        recipeListViewModel = new ViewModelProvider(this,
                ViewModelProvider.AndroidViewModelFactory.getInstance(this.getApplication())).get(RecipeListViewModel.class);


        subscribeObserver();
    }

    private void subscribeObserver() {
        recipeListViewModel.getRecipes().observe(this, new Observer<List<Recipe>>() {
            @Override
            public void onChanged(List<Recipe> recipes) {

            }
        });
    }

    private void testRetrofitRequest() {
        RecipeApi recipeApi = ServiceGenerator.getRecipeApi();

//        Call<RecipeSearchResponse> responseCall = recipeApi
//                .searchRecipe("chicken breast",
//                        "1"
//                );
//
//        responseCall.enqueue(new Callback<RecipeSearchResponse>() {
//            @Override
//            public void onResponse(Call<RecipeSearchResponse> call, Response<RecipeSearchResponse> response) {
//                Log.d(TAG,"onResponse: server response" + response.toString());
//                if(response.isSuccessful()){
//                    Log.d(TAG,"onResponse: " + response.body().toString());
//                    List<Recipe> recipeList =  new ArrayList<>(response.body().getRecipes());
//                    for(Recipe recipe: recipeList){
//                        Log.d(TAG,"onResponse: "+recipe.getTitle());
//                    }
//
//                }
//                else {
//                    Log.d(TAG,"onResponse: server response" + response.errorBody().toString());
//                }
//            }
//
//            @Override
//            public void onFailure(Call<RecipeSearchResponse> call, Throwable t) {
//
//            }
//        });

        Call<RecipeResponse> responseCall = recipeApi
                .getRecipe("41470");

        responseCall.enqueue(new Callback<RecipeResponse>() {
            @Override
            public void onResponse(Call<RecipeResponse> call, Response<RecipeResponse> response) {
                Log.d(TAG, "onResponse: server response" + response.toString());
                if (response.isSuccessful()) {
                    Log.d(TAG, "onResponse: " + response.body().toString());
                    String recipe = response.body().getRecipe().toString();
                    Log.d(TAG, "onResponse: " + recipe);

                } else {
                    Log.d(TAG, "onResponse: server response" + response.errorBody().toString());
                }
            }

            @Override
            public void onFailure(Call<RecipeResponse> call, Throwable t) {

            }
        });
    }
}