package com.example.cat3;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class WikiAdapter extends RecyclerView.Adapter<WikiAdapter.CatViewHolder> implements Filterable {

    ArrayList<Pet> cl;
    ArrayList<Pet> mFilteredList;
    Context context;

    public WikiAdapter ( ArrayList<Pet> catsList) {
        this.cl = catsList;
        this.mFilteredList = new ArrayList<>();
    }

    @Override
    public CatViewHolder onCreateViewHolder (@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate( R.layout.miao, parent, false);
        this.context = parent.getContext();
        CatViewHolder catViewHolder = new CatViewHolder(view);
        return catViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CatViewHolder holder, final int position){
        if (mFilteredList.isEmpty()){
            mFilteredList = cl;
        }
        final Pet catAtPosition = mFilteredList.get(position);
        System.out.println("Filtered Cat List: "  +catAtPosition.getName()+" "+ catAtPosition.getId());

        holder.catName.setText(catAtPosition.getName());
        holder.catName.setTextColor (Color.BLACK);
        System.out.println(catAtPosition.getId());
        holder.catLinear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ContentLogic.class);
                System.out.println(catAtPosition.getId());
                intent.putExtra("catID",catAtPosition.getId());
                v.getContext().startActivity(intent);
            }
        });


    }


    public int getItemCount(){
        if (mFilteredList.isEmpty()){
            return cl.size();
        } else {
            return mFilteredList.size();
        }

    }

    public void setData(ArrayList<Pet> cats) {
        this.cl = cats;
    }

    @Override
    public Filter getFilter() {

        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {

                String charString = charSequence.toString();

                if (charString.isEmpty()) {
                    mFilteredList = cl;
                } else {
                          ArrayList<Pet> filteredList = new ArrayList<>();
                    for (Pet cat : cl) {
                        if (cat.getName().toLowerCase().contains(charString)) {
                            filteredList.add(cat);
                        }
                    }

                    mFilteredList = filteredList;
                }

                     FilterResults filterResults = new FilterResults();
                filterResults.values = mFilteredList;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                mFilteredList = (ArrayList<Pet>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }


    public class CatViewHolder extends RecyclerView.ViewHolder {
        LinearLayout catLinear;
        TextView catName;

        public CatViewHolder(View view){
            super(view);
            catName =view.findViewById(R.id.pn );
            catLinear = view.findViewById(R.id.ppl1 );
        }

        @Override
        public String toString() {
            return super.toString() + " '" + catName.getText() + "'";
        }

    }
}
