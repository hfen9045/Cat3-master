package com.example.cat3;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;

public class ContentLogic extends AppCompatActivity {

    Context ct;

    TextView MiaoN;
    ImageView Miaoi;
    ImageButton fav;
    TextView des;
    TextView pw1;
    TextView org;
    TextView temper;
    TextView ls;
    TextView df;
    TextView weight;
    TextView wikiLink;
    FavourateCat listc = new FavourateCat ();
    String m;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.thecontent );

        ct = this;


        MiaoN = findViewById(R.id.pn );
        Miaoi = findViewById(R.id.ciiim );
        fav = findViewById(R.id.favou );
        des = findViewById(R.id.cppp );
        org = findViewById(R.id.orror );
        temper = findViewById(R.id.tempp );
        ls = findViewById(R.id.lipp );
        df = findViewById(R.id.dgF );
        weight = findViewById(R.id.wght );
        wikiLink = findViewById(R.id.wikiLink);
        pw1 = findViewById ( R.id.fa1 );

        Intent intent = getIntent();
       String intentDetails = intent.getStringExtra("catID");

        String apikey = "b1ebc0a1-3f90-429f-a940-b2f80ab773ad&";
        String url = "https://api.thecatapi.com/v1/images/search?api_key="+apikey+"breed_id="+intentDetails;
        final RequestQueue requestQueue = Volley.newRequestQueue(this);


        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                System.out.println(response);


                Gson gson = new Gson();
                Type collectionType = new TypeToken<Collection<Cc>>(){}.getType();
                final ArrayList<Cc> catAPI =gson.fromJson(response, collectionType);
                requestQueue.stop();

                final Cc currentApi = catAPI.get(0);

          final Pet currentCat = currentApi.fbred ().get ( 0 );
          m =currentCat.getId ();

                MiaoN.setText(currentCat.getName());
                MiaoN.setTextColor ( Color.BLACK);
                Glide.with( ct ).load(currentApi.gur ()).into( Miaoi );
                des.setText(currentCat.getDescription());
                org.setText("The org would be: "+currentCat.getOrigin());
                ls.setText("Lifespan: "+currentCat.getLifeSpan());
                weight.setText("The weight: "+currentCat.getWeight().getMetric());
                temper.setText("Temperament of miao: \n"+currentCat.getTemperament());
                df.setText(" Dog Friendliness: "+currentCat.getFriendly ());
                wikiLink.setText("Link for more information: \n"+currentCat.getWikiUrl());

                fav.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                   listc.addCat ( currentCat );
                    listc.setUrl ( currentApi.gur () );

                    pw1.setText ( "Successfully" );
                    }
                });


            }
        };

        Response.ErrorListener errorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("gg");
            }
        };


        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, responseListener, errorListener);
        requestQueue.add(stringRequest);

    }
}
