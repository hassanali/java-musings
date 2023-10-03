package com.java.musings.comparators;

import com.java.musings.beans.Developer;

import java.util.Comparator;

/**
 * @author Hassan Ali
 * @since 3rd October 2023
 */
public class DeveloperClientRatingComparator implements Comparator<Developer> {


    @Override
    public int compare(Developer dev1, Developer dev2) {
        return Integer.compare(dev1.getClientRating(), dev2.getClientRating());
    }
}
