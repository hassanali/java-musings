package com.java.musings.beans;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;

import java.util.Objects;

/**
 * @author Hassan Ali
 * @since 3rd October
 */
public class GymUser implements Comparable<GymUser> {

    private int id;
    private String name;
    private int age;
    private int weight;
    private int cardioDurationWeekly;
    private int calorieIntakeDaily;
    private int caloriesBurntDaily;

    public GymUser(int id, String name, int age, int weight, int cardioDurationWeekly, int calorieIntakeDaily, int caloriesBurntDaily) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.cardioDurationWeekly = cardioDurationWeekly;
        this.calorieIntakeDaily = calorieIntakeDaily;
        this.caloriesBurntDaily = caloriesBurntDaily;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getCardioDurationWeekly() {
        return cardioDurationWeekly;
    }

    public void setCardioDurationWeekly(int cardioDurationWeekly) {
        this.cardioDurationWeekly = cardioDurationWeekly;
    }

    public int getCalorieIntakeDaily() {
        return calorieIntakeDaily;
    }

    public void setCalorieIntakeDaily(int calorieIntakeDaily) {
        this.calorieIntakeDaily = calorieIntakeDaily;
    }

    public int getCaloriesBurntDaily() {
        return caloriesBurntDaily;
    }

    public void setCaloriesBurntDaily(int caloriesBurntDaily) {
        this.caloriesBurntDaily = caloriesBurntDaily;
    }


    @Override
    public String toString() {
        String gymUser = "{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                ", cardioDurationWeekly=" + cardioDurationWeekly +
                ", calorieIntakeDaily=" + calorieIntakeDaily +
                ", caloriesBurntDaily=" + caloriesBurntDaily +
                '}';

        Gson gson = new GsonBuilder().setLenient().setPrettyPrinting().create();
        return gson.toJson(JsonParser.parseString(gymUser));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GymUser gymUser)) return false;
        return getId() == gymUser.getId() && getAge() == gymUser.getAge() && getWeight() == gymUser.getWeight() && getCardioDurationWeekly() == gymUser.getCardioDurationWeekly() && getCalorieIntakeDaily() == gymUser.getCalorieIntakeDaily() && getCaloriesBurntDaily() == gymUser.getCaloriesBurntDaily() && getName().equals(gymUser.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getAge(), getWeight(), getCardioDurationWeekly(), getCalorieIntakeDaily(), getCaloriesBurntDaily());
    }

    /**
     * @param gymUser 
     * @return
     */
    @Override
    public int compareTo(GymUser gymUser) {
        return Integer.compare(getAge(), gymUser.getAge());
    }
}