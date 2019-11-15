package com.example.cat3;

import com.google.gson.annotations.SerializedName;

public class Pet {
    String id;
    String name;


    @SerializedName("life_span")
    String lifeSpan;
    @SerializedName("dog_friendly")
    String friendly;




    String imageUrl;
    String description;
    Weight weight;



    String temperament;
    String origin;




    @SerializedName("wikipedia_url")
    String wikiUrl;

    public Pet ( String id, String name, String description, Weight weight, String temperament, String origin, String lifeSpan, String dogfriend, String wikiUrl) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.weight = weight;
        this.temperament = temperament;
        this.origin = origin;
        this.lifeSpan = lifeSpan;
        this.friendly = dogfriend;
        this.wikiUrl = wikiUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }













       public String getImageUrl() {
        return imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public String getTemperament() {
        return temperament;
    }

    public String getOrigin() {
        return origin;
    }

    public String getLifeSpan() {
        return lifeSpan;
    }





    public String getFriendly () {
        return friendly;
    }

    public String getWikiUrl() {
        return wikiUrl;
    }

    public Weight getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                '}';
    }

    public class Weight{
        String metric;

        public Weight(String metric) {
            this.metric = metric;
        }

        public String getMetric() {
            return metric;
        }
    }
}
