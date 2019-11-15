package com.example.cat3;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;


/**
 * A simple {@link Fragment} subclass.
 */
public class Wikicat extends Fragment {

    SearchView cs1;
    RecyclerView.LayoutManager lm11
            ;
    RecyclerView rRew;
    WikiAdapter adpter1;

    public Wikicat () {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View nv1 = inflater.inflate( R.layout.wikipage, container, false);





        final RequestQueue requestQueue = Volley.newRequestQueue(nv1.getContext());


        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                     System.out.println(response);


                Gson goson = new Gson();
                Type collectionType = new TypeToken<Collection<Pet>>(){}.getType();
                   Collection<Pet> catAPI =goson.fromJson(response, collectionType);
                requestQueue.stop();

                ArrayList<Pet> catsList = new ArrayList<>(catAPI);

                rRew = nv1.findViewById(R.id.searchRecycler);
                  lm11 = new LinearLayoutManager(nv1.getContext());
                rRew.setLayoutManager( lm11 );
                adpter1 = new WikiAdapter (catsList);
                        rRew.setAdapter( adpter1 );
                cs1 = nv1.findViewById(R.id.wikibar );
                checkit ( cs1 );


            }
        };

        Response.ErrorListener errorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("gg");
            }
        };
        String url = "https://api.thecatapi.com/v1/breeds?api_key=b1ebc0a1-3f90-429f-a940-b2f80ab773ad";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, responseListener, errorListener);
                 requestQueue.add(stringRequest);



        return nv1;
    }

    private void checkit( SearchView searchView) {

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                       adpter1.getFilter().filter(query);
                System.out.println("ok");
           return true;
    }

            @Override
            public boolean onQueryTextChange(String newText) {
                adpter1.getFilter().filter(newText);
                System.out.println("gg");
                return true;
            }
        });
    }
}
