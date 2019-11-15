package com.example.cat3;

import java.util.ArrayList;

public class FavourateCat {

 static ArrayList<Pet> favourCat=new ArrayList<Pet>();
  static  ArrayList<String> numCat;
  static boolean check;
    static  String url;
    public void setUrl ( String url ) {
        FavourateCat.url = url;
    }

    public String getUrl () {
        return url;
    }



    public FavourateCat () {
        numCat =new ArrayList<String>();

    }


    public ArrayList<Pet>  getcatlist(){
        return favourCat;
    }

    public void addCat(String f){


      numCat.add ( f );
      System.out.println ( numCat);

    }

    public void addCat( Pet cat){
      check =fliter ( cat );
   if (check ==true){favourCat.add ( cat )  ;}
        System.out.println ( favourCat.size ());
    }

 public boolean fliter( Pet n){
        boolean a =true ;
        for(int i =0 ;i< favourCat.size ();i++){
            if(n.getId ().equals ( favourCat.get ( i ).getId ())){
                a =false;
            }

        }
        return  a;




 }

}
