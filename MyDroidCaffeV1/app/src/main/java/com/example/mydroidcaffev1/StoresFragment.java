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


public class StoresFragment extends Fragment {

    private RecyclerView storesRecyclerview;
    private ArrayList<Stores> storesData;
    private StoresAdapter storesAdapter;


    public StoresFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView= inflater.inflate(R.layout.fragment_stores, container, false);
        storesRecyclerview= rootView.findViewById(R.id.recycler_stores);
        storesRecyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        storesData = new ArrayList<>();
        storesAdapter= new StoresAdapter(storesData,getContext());
        storesRecyclerview.setAdapter(storesAdapter);
        initializeData();
        return rootView;
    }

    private void initializeData() {
        String[] storesTitles = getResources().getStringArray(R.array.stores_title);
        String[] storesDescription = getResources().getStringArray(R.array.stores_description);
        TypedArray storesImages=getResources().obtainTypedArray(R.array.stores_images);

        storesData.clear();
        for (int i=0;i<storesTitles.length;i++){

            storesData.add(new Stores(storesImages.getResourceId(i,  0), storesTitles[i], storesDescription[i]));
        }
        storesImages.recycle();
        storesAdapter.notifyDataSetChanged();

    }


}