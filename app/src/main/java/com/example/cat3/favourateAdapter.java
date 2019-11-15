package com.example.cat3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class favourateAdapter extends RecyclerView.Adapter<favourateAdapter.FHolder> {
        Context context;
        FavourateCat s =new FavourateCat ();
        ArrayList<Pet> fc = s.getcatlist ();



@Override
public FHolder onCreateViewHolder ( @NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate( R.layout.favourate_layout, parent, false);
        this.context = parent.getContext();
        FHolder holder = new FHolder(view);
        return holder;
        }

@Override
public void onBindViewHolder(@NonNull FHolder holder, final int position){



         holder.MiaoN.setText (  fc.get ( position ).getName ());
        holder.des.setText (  fc.get ( position ).getDescription ());



        }


public int getItemCount(){
return fc.size ();

        }




public class FHolder extends RecyclerView.ViewHolder {
        TextView MiaoN;

        TextView des;


    public FHolder( View view){
        super(view);
            MiaoN = view.findViewById(R.id.title);


            des = view.findViewById(R.id.description);

    }



}
}
