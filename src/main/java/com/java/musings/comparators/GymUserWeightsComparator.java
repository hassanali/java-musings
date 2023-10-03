package com.java.musings.comparators;

import com.java.musings.beans.GymUser;

import java.util.Comparator;

/**
 * @author Hassan Ali
 * @since 3rd October 2023
 */
public class GymUserWeightsComparator implements Comparator<GymUser> {


    @Override
    public int compare(GymUser dev1, GymUser dev2) {
        return Integer.compare(dev1.getWeight(), dev2.getWeight());
    }
}
