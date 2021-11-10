package com.example.mydroidcaffev1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class StoresAdapter extends RecyclerView.Adapter<StoresAdapter.ViewHolder> {
    private ArrayList<Stores> storesData;
    private Context myContext;

    StoresAdapter(ArrayList<Stores> mStoresData, Context context){
        this.myContext = context;
        this.storesData = mStoresData;
    }

    @NonNull
    @Override
    public StoresAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new StoresAdapter.ViewHolder(LayoutInflater.from(myContext).inflate(R.layout.stores_list_item,parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull StoresAdapter.ViewHolder holder, int position) {
        Stores currentStores = storesData.get(position);
        holder.bindTo(currentStores);
    }

    @Override
    public int getItemCount() {
        return storesData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView myStoresImage;
        private TextView myStoresTitle;
        private TextView myStoresDescription;
        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            myStoresImage=itemView.findViewById(R.id.stores_image);
            myStoresTitle=itemView.findViewById(R.id.stores_title);
            myStoresDescription=itemView.findViewById(R.id.stores_description);
        }

        public void bindTo(Stores currentStores) {
            Glide.with(myContext).load(currentStores.getstoresImage()).into(myStoresImage);
            myStoresTitle.setText(currentStores.getstoresTitle());
            myStoresDescription.setText(currentStores.getstoresDescription());
        }
    }
}
