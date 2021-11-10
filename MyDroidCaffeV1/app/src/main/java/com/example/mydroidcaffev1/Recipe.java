package com.example.mydroidcaffev1;

public class Recipe {
    private final int recipeImage;
    private String recipeTitle;
    private String recipeDescription;

    Recipe(int recipeImage, String recipeTitle, String recipeDescription){
        this.recipeImage = recipeImage;
        this.recipeTitle = recipeTitle;
        this.recipeDescription = recipeDescription;
    }
    public int getRecipeImage(){
        return recipeImage;
    }
    public String getRecipeTitle(){
        return recipeTitle;
    }
    public String getRecipeDescription(){
        return  recipeDescription;
    }
}
