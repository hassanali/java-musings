package com.java.musings.collections;

import com.java.musings.beans.Developer;
import com.java.musings.comparators.DeveloperClientRatingComparator;
import com.java.musings.comparators.DeveloperRankingComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author Hassan Ali
 */
public class CollectionsMusings {


    private static final List<Developer> developerList = new ArrayList<>();

    static {
        developerList.add(new Developer(1, "Ali", "Java", 4, 20));
        developerList.add(new Developer(2, "Hassan", "Java", 2, 13));
        developerList.add(new Developer(3, "Lupin", "Java", 11, 17));
    }



    private static void sortWithComparable() {

        System.out.println("\nSort with Comparable");

        System.out.println("Before sorting: " + developerList);

        Collections.sort(developerList);

        System.out.println("After sorting: " + developerList);
    }


    private static void sortWithInternalRatingComparator() {

        System.out.println("\nSort with Comparator by Internal Rating");

        System.out.println("Before sorting: " + developerList);

        Collections.sort(developerList, new DeveloperRankingComparator());

        System.out.println("After sorting: " + developerList);
    }


    private static void sortWithClientRatingComparator() {
        System.out.println("\nSort with Comparator by Client Rating");

        System.out.println("Before sorting: " + developerList);

        Collections.sort(developerList, new DeveloperClientRatingComparator());

        System.out.println("After sorting: " + developerList);
    }


    private static void comparatorsWithLambdas() {
        System.out.println("\n\nSort with lambdas by id");

        System.out.println("Before sorting: " + developerList);

        Collections.sort(developerList, (Developer developer1, Developer developer2) -> Integer.compare(developer1.getId(), developer2.getId()));

        System.out.println("After sorting: " + developerList);
    }


    private static void comparatorsWithComparingStaticMethod() {
        System.out.println("\n\nSort with Comparator.comparing...() by client rating");

        System.out.println("Before sorting: " + developerList);

        Collections.sort(developerList, Comparator.comparingInt(Developer::getClientRating));

        System.out.println("After sorting: " + developerList);
    }

    public static void main(String[] args) {
        sortWithComparable();

        sortWithInternalRatingComparator();

        sortWithClientRatingComparator();

        comparatorsWithLambdas();

        comparatorsWithComparingStaticMethod();
    }
}