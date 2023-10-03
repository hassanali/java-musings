package com.java.musings.comparators;

import com.java.musings.beans.Developer;

import java.util.Comparator;

public class DeveloperRankingComparator implements Comparator<Developer> {

    @Override
    public int compare(Developer dev1, Developer dev2) {
        return Integer.compare(dev1.getInternalRating(), dev2.getInternalRating());
    }

}
