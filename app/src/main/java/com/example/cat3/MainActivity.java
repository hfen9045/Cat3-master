package com.example.cat3;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bvn;


    FragmentManager fmg;
    FragmentTransaction fts;

    Wikicat sfg;
    Myfavorate ffgm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
                    super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_main);

        bvn = findViewById(R.id.atbot );

                sfg = new Wikicat ();
        ffgm = new Myfavorate ();

       fmg = getSupportFragmentManager();
                 fts = fmg.beginTransaction();
        fts.replace(R.id.fmain, sfg );
           fts.commit();

        bvn.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
  case R.id.googles:
          FragmentTransaction fragmentTransaction = fmg.beginTransaction();
                            fragmentTransaction.replace(R.id.fmain, sfg );
                   fragmentTransaction.commit();
                                return true;
                    case R.id.favoratem:
                                FragmentTransaction fragmentTransaction1 = fmg.beginTransaction();
                   fragmentTransaction1.replace(R.id.fmain, ffgm );
                          fragmentTransaction1.commit();
                                return true;           }
                  return false;
                    }
                });
    }
}
