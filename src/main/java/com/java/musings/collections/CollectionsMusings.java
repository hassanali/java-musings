package com.java.musings.collections;

import com.java.musings.beans.GymUser;
import com.java.musings.comparators.GymUserWeightsComparator;
import com.java.musings.comparators.GymUserCalorieIntakeComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author Hassan Ali
 */
public class CollectionsMusings {


    private static final List<GymUser> gymUsersList = new ArrayList<>();
    static {
        gymUsersList.add(new GymUser(1, "Ali", 33, 85, 20, 2000, 400));
        gymUsersList.add(new GymUser(2, "Hassan", 34, 98, 3, 2100, 300));
        gymUsersList.add(new GymUser(3, "Robert J", 37, 110, 5, 3000, 400));
        gymUsersList.add(new GymUser(4, "Lupin", 38, 11, 17, 2000, 200));
    }



    private static void sortWithComparable() {

        System.out.println("\nSort with Comparable");

        System.out.println("Before sorting: " + gymUsersList);

        Collections.sort(gymUsersList);

        System.out.println("After sorting: " + gymUsersList);
    }


    private static void sortWithInternalRatingComparator() {

        System.out.println("\nSort with Comparator by Internal Rating");

        System.out.println("Before sorting: " + gymUsersList);

        Collections.sort(gymUsersList, new GymUserCalorieIntakeComparator());

        System.out.println("After sorting: " + gymUsersList);
    }


    private static void sortWithGymUserWeightsComparator() {
        System.out.println("\nSort with Comparator by Client Rating");

        System.out.println("Before sorting: " + gymUsersList);

        Collections.sort(gymUsersList, new GymUserWeightsComparator());

        System.out.println("After sorting: " + gymUsersList);
    }


    private static void comparatorsWithLambdas() {
        System.out.println("\n\nSort with lambdas by id");

        System.out.println("Before sorting: " + gymUsersList);

        Collections.sort(gymUsersList, (GymUser developer1, GymUser developer2) -> Integer.compare(developer1.getId(), developer2.getId()));

        System.out.println("After sorting: " + gymUsersList);
    }


    private static void comparatorsWithComparingStaticMethod() {
        System.out.println("\n\nSort with Comparator.comparing...() by client rating");

        System.out.println("Before sorting: " + gymUsersList);

        Collections.sort(gymUsersList, Comparator.comparingInt(GymUser::getCaloriesBurntDaily));

        System.out.println("After sorting: " + gymUsersList);
    }

    public static void main(String[] args) {
        sortWithComparable();

        sortWithInternalRatingComparator();

        sortWithGymUserWeightsComparator();

        comparatorsWithLambdas();

        comparatorsWithComparingStaticMethod();
    }
}