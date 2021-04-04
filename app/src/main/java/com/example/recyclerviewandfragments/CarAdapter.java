package com.example.recyclerviewandfragments;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CarAdapter extends RecyclerView.Adapter<CarAdapter.ViewHolder>
{

    private ArrayList<Car> cars;

    ItemClicked activity;

    public interface ItemClicked
    {
        void onItemClicked(int index);
    }

    public CarAdapter (Context context, ArrayList<Car> list)
    {
        cars = list;
        activity = (ItemClicked) context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {

        ImageView ivModel;
        TextView tvModelName, tvOwner;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            ivModel = itemView.findViewById(R.id.ivModel);
            tvModelName = itemView.findViewById(R.id.tvModelName);
            tvOwner = itemView.findViewById(R.id.tvOwner);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    activity.onItemClicked(cars.indexOf((Car) view.getTag()));

                }
            });

        }
    }

    @NonNull
    @Override
    public CarAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_layout, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CarAdapter.ViewHolder viewHolder, int i) {

        viewHolder.itemView.setTag(cars.get(i));

        viewHolder.tvOwner.setText(cars.get(i).getOwnerName());
        viewHolder.tvModelName.setText(cars.get(i).getModel());

        if (cars.get(i).getMake().equals("Volkswagen"))
        {
            viewHolder.ivModel.setImageResource(R.drawable.volkswagen);
        }
        else if (cars.get(i).getMake().equals("Nissan"))
        {
            viewHolder.ivModel.setImageResource(R.drawable.nissan);
        }
        else
        {
            viewHolder.ivModel.setImageResource(R.drawable.mercedes);
        }

    }

    @Override
    public int getItemCount() {
        return cars.size();
    }
}
