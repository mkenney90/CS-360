package com.snhu.weight_tracker;

public class WeightRecord {
    private long id;
    private float weight;
    private String date;

    public WeightRecord(long id, float weight, String date) {
        this.id = id;
        this.weight = weight;
        this.date = date;
    }

    public float getWeight() {
        return weight;
    }

    public String getDate() {
        return date;
    }
}
