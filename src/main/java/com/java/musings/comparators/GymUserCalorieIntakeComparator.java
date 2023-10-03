package com.java.musings.comparators;

import com.java.musings.beans.GymUser;

import java.util.Comparator;

public class GymUserCalorieIntakeComparator implements Comparator<GymUser> {

    @Override
    public int compare(GymUser dev1, GymUser dev2) {
        return Integer.compare(dev1.getCalorieIntakeDaily(), dev2.getCalorieIntakeDaily());
    }

}
