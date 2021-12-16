package ca.brocku.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.imageview.ShapeableImageView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.Holder>{
    Context c;
    //arraylist of Business objects
    ArrayList<Business> businessArrayList;

    public Adapter(Context c, ArrayList<Business> businessArrayList) {
        this.c = c;
        this.businessArrayList = businessArrayList;
    }

    @NonNull
    @Override
    public Adapter.Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View ve = LayoutInflater.from(c).inflate(R.layout.list_restaurants,parent,false);







        return new Holder(ve);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {

        Business restaurant = businessArrayList.get(position);
        holder.restaurantHeading.setText(restaurant.RestaurantHeading);
        holder.restaurantImg.setImageResource(restaurant.titleImage);

    }

    @Override
    public int getItemCount() {
        return businessArrayList.size();
    }


    public static class Holder extends RecyclerView.ViewHolder{

        TextView restaurantHeading;
        ShapeableImageView restaurantImg;



        public Holder(@NonNull View itemView) {
            super(itemView);
            restaurantHeading = itemView.findViewById(R.id.restaurantHeading);
            restaurantImg = itemView.findViewById(R.id.restaurant_img);
        }
    }
}
