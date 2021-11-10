package com.example.mydroidcaffev1;

import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class PastriesRecipeFragment extends Fragment {

    private RecyclerView pastriesRecyclerview;
    private ArrayList<Recipe> pastriesRecipeData;
    private RecipeAdapter pastriesAdapter;

    public PastriesRecipeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView= inflater.inflate(R.layout.fragment_pastries_recipe, container, false);
        pastriesRecyclerview= rootView.findViewById(R.id.recycler_pastries);
        pastriesRecyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        pastriesRecipeData = new ArrayList<>();
        pastriesAdapter= new RecipeAdapter(pastriesRecipeData,getContext());
        pastriesRecyclerview.setAdapter(pastriesAdapter);
        initializeData();
        return rootView;
    }

    private void initializeData() {
        String[] pastriesTitles = getResources().getStringArray(R.array.pastries_title);
        String[] pastriesDescription = getResources().getStringArray(R.array.pastries_description);
        TypedArray pastriesImages=getResources().obtainTypedArray(R.array.pastries_images);

        pastriesRecipeData.clear();
        for (int i=0;i<pastriesTitles.length;i++){

            pastriesRecipeData.add(new Recipe(pastriesImages.getResourceId(i,  0), pastriesTitles[i], pastriesDescription[i]));
        }
        pastriesImages.recycle();
        pastriesAdapter.notifyDataSetChanged();

    }

}