package com.SocialMediaAnalystics.demo.model;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Mercury {
    @Id
    private String planet;
    private int distance;

    public String getPlanet() {
        return planet;
    }

    public void setPlanet(String planet) {
        this.planet = planet;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
}

