package com.example.cat3;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Myfavorate extends Fragment {

    RecyclerView.LayoutManager layoutManager;
    RecyclerView recyclerView;
    favourateAdapter searchAdapter;

public Myfavorate () { }


    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container,

                             Bundle savedInstanceState) {
        final View v2= inflater.inflate( R.layout.main_favorat, container, false);

        recyclerView = v2.findViewById(R.id.fr);
        layoutManager = new LinearLayoutManager (v2.getContext());
        recyclerView.setLayoutManager(layoutManager);
        searchAdapter = new favourateAdapter ();
        recyclerView.setAdapter(searchAdapter);

        return v2;

    }

}
