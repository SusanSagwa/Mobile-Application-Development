package com.example.mydroidcaffev1;

import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;


public class DessertRecipeFragment extends Fragment {

    private RecyclerView dessertRecyclerview;
    private ArrayList<Recipe> dessertRecipeData;
    private RecipeAdapter dessertAdapter;

    public DessertRecipeFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView= inflater.inflate(R.layout.fragment_dessert_recipe, container, false);
        dessertRecyclerview= rootView.findViewById(R.id.recycler_dessert);
        dessertRecyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        dessertRecipeData = new ArrayList<>();
        dessertAdapter= new RecipeAdapter(dessertRecipeData,getContext());
        dessertRecyclerview.setAdapter(dessertAdapter);
        initializeData();

        ItemTouchHelper helper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(ItemTouchHelper.RIGHT|ItemTouchHelper.LEFT|ItemTouchHelper.DOWN|ItemTouchHelper.UP, ItemTouchHelper.LEFT|ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
               int from = viewHolder.getAdapterPosition();
               int to = viewHolder.getAdapterPosition();
                Collections.swap(dessertRecipeData,from,to);
                dessertAdapter.notifyItemMoved(from,to);
                return true;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
               dessertRecipeData.remove(viewHolder.getAdapterPosition());
               dessertAdapter.notifyItemRemoved(viewHolder.getAdapterPosition());
            }
        });
        helper.attachToRecyclerView(dessertRecyclerview);

        return rootView;
    }

    private void initializeData() {
        String[] dessertTitles = getResources().getStringArray(R.array.dessert_title);
        String[] dessertDescription = getResources().getStringArray(R.array.dessert_description);
        TypedArray dessertImages=getResources().obtainTypedArray(R.array.desserts_images);

        dessertRecipeData.clear();
        for (int i=0;i<dessertTitles.length;i++){

            dessertRecipeData.add(new Recipe(dessertImages.getResourceId(i,  0), dessertTitles[i], dessertDescription[i]));
        }
        dessertImages.recycle();
        dessertAdapter.notifyDataSetChanged();

    }
}