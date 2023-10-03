package com.java.musings.beans;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;

/**
 * @author Hassan Ali
 * @since 3rd October
 */
public class Developer implements Comparable<Developer> {

    private int id;
    private String name;
    private String department;
    private int clientRating;

    private int internalRating;

    public Developer() { }


    public Developer(int id, String name, String department, int internalRating, int clientRating) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.internalRating = internalRating;
        this.clientRating = clientRating;
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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getClientRating() {
        return clientRating;
    }

    public void setClientRating(int clientRating) {
        this.clientRating = clientRating;
    }

    public int getInternalRating() {
        return internalRating;
    }

    public void setInternalRating(int internalRating) {
        this.internalRating = internalRating;
    }

    @Override
    public int compareTo(Developer developer) {
        return Integer.compare(internalRating, developer.internalRating);
    }

    @Override
    public String toString() {
        String developer = "{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", clientRating=" + clientRating +
                ", internalRating=" + internalRating +
                '}';

        Gson gson = new GsonBuilder().setLenient().setPrettyPrinting().create();
        return gson.toJson(JsonParser.parseString(developer));
    }

}