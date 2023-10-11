package com.java.musings.collections.sorting.java8plus;

import com.java.musings.beans.GymUser;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Hassan Ali
 */
public class CollectionsSortingJava8Plus {

    @Test
    public void collectionsSortingBeforeJava8() {

        List<GymUser> list = new ArrayList<>();
        list.add(new GymUser(1, "Richard", 32, 99, 10, 2000, 300));
        list.add(new GymUser(2, "Pen Li", 20, 70, 9, 3000, 800));
        list.add(new GymUser(3, "Rana", 34, 110, 9, 2400, 450));
        list.add(new GymUser(4, "Bob", 39, 104, 1, 1800, 500));
        list.add(new GymUser(5, "LaLi", 18, 85, 7, 1700, 600));

        Collections.sort(list, new Comparator<>() {
            @Override
            public int compare(GymUser d1, GymUser d2) {
                return Integer.compare(d1.getWeight(), d2.getWeight());
            }
        });


        assertEquals(list.get(0), new GymUser(2, "Pen Li", 20, 70, 9, 3000, 800));
    }


    @Test
    public void collectionsSortingWithJava8Lambda() {

        List<GymUser> list = new ArrayList<>();
        list.add(new GymUser(1, "Richard", 32, 99, 10, 2000, 300));
        list.add(new GymUser(2, "Pen Li", 20, 70, 9, 3000, 800));
        list.add(new GymUser(3, "Rana", 34, 110, 9, 2400, 450));
        list.add(new GymUser(4, "Bob", 39, 104, 1, 1800, 500));
        list.add(new GymUser(5, "LaLi", 18, 85, 7, 1700, 600));

        Collections.sort(list, (GymUser d1, GymUser d2) -> Integer.compare(d1.getWeight(), d2.getWeight()));

        assertEquals(list.get(0), new GymUser(2, "Pen Li", 20, 70, 9, 3000, 800));
    }


    @Test
    public void collectionsSortingWithJava8Lambda_alphabetic() {

        List<GymUser> list = new ArrayList<>();
        list.add(new GymUser(1, "Richard", 32, 99, 10, 2000, 300));
        list.add(new GymUser(2, "Pen Li", 20, 70, 9, 3000, 800));
        list.add(new GymUser(3, "Rana", 34, 110, 9, 2400, 450));
        list.add(new GymUser(4, "Bob", 39, 104, 1, 1800, 500));
        list.add(new GymUser(5, "LaLi", 18, 85, 7, 1700, 600));

        Collections.sort(list, (final GymUser user1, final GymUser user2) -> user1.getName().compareTo(user2.getName()));

        assertEquals(list.get(0), new GymUser(4, "Bob", 39, 104, 1, 1800, 500));
    }


    @Test
    public void collectionsSortingWithJava8LambdaWithoutTypeDefinitions_alphabetic() {

        List<GymUser> list = new ArrayList<>();
        list.add(new GymUser(1, "Richard", 32, 99, 10, 2000, 300));
        list.add(new GymUser(2, "Pen Li", 20, 70, 9, 3000, 800));
        list.add(new GymUser(3, "Rana", 34, 110, 9, 2400, 450));
        list.add(new GymUser(4, "Bob", 39, 104, 1, 1800, 500));
        list.add(new GymUser(5, "LaLi", 18, 85, 7, 1700, 600));

        Collections.sort(list, (user1, user2) -> user1.getName().compareTo(user2.getName()));

        assertEquals(list.get(0), new GymUser(4, "Bob", 39, 104, 1, 1800, 500));
    }

    @Test
    public void collectionsSortingWithJava8Lambda_with_Comparator_comparing_alphabetic() {

        List<GymUser> list = new ArrayList<>();
        list.add(new GymUser(1, "Richard", 32, 99, 10, 2000, 300));
        list.add(new GymUser(2, "Pen Li", 20, 70, 9, 3000, 800));
        list.add(new GymUser(3, "Rana", 34, 110, 9, 2400, 450));
        list.add(new GymUser(4, "Bob", 39, 104, 1, 1800, 500));
        list.add(new GymUser(5, "LaLi", 18, 85, 7, 1700, 600));

        Collections.sort(list, Comparator.comparing(GymUser::getName));
        list.sort(Comparator.comparing(GymUser::getName));

        assertEquals(list.get(0), new GymUser(4, "Bob", 39, 104, 1, 1800, 500));
    }

    @Test
    public void collectionsSortingWithJava8Lambda_with_Comparator_comparing_alphabetic_reversed() {

        List<GymUser> list = new ArrayList<>();
        list.add(new GymUser(1, "Richard", 32, 99, 10, 2000, 300));
        list.add(new GymUser(2, "Pen Li", 20, 70, 9, 3000, 800));
        list.add(new GymUser(3, "Rana", 34, 110, 9, 2400, 450));
        list.add(new GymUser(4, "Bob", 39, 104, 1, 1800, 500));
        list.add(new GymUser(5, "LaLi", 18, 85, 7, 1700, 600));

        list.sort(Comparator.comparing(GymUser::getName).reversed());

        assertEquals(list.get(0), new GymUser(1, "Richard", 32, 99, 10, 2000, 300));
    }


    @Test
    public void collectionsSortingWithJava8Lambda_with_Comparator_comparing_multi_conditions() {

        List<GymUser> list = new ArrayList<>();
        list.add(new GymUser(1, "Richard", 32, 99, 10, 2000, 300));
        list.add(new GymUser(2, "Pen Li", 20, 70, 9, 3000, 800));
        list.add(new GymUser(3, "Rana", 34, 110, 9, 2400, 450));
        list.add(new GymUser(4, "Bob", 39, 104, 1, 1800, 500));
        list.add(new GymUser(5, "LaLi", 18, 85, 7, 1700, 600));
        list.add(new GymUser(6, "LaLi", 19, 90, 9, 1000, 690));

        Collections.sort(list, (user1, user2) -> {
            if (user1.getName().equals(user2.getName())) {
                return Integer.compare(user1.getAge(), user2.getAge());
            }
            else {
                return user1.getName().compareTo(user2.getName());
            }
        });

        assertEquals(list.get(0), new GymUser(4, "Bob", 39, 104, 1, 1800, 500));
    }


    @Test
    public void collectionsSortingWithJava8Lambda_with_Comparator_comparing_multi_conditions_composition() {

        List<GymUser> list = new ArrayList<>();
        list.add(new GymUser(1, "Richard", 32, 99, 10, 2000, 300));
        list.add(new GymUser(2, "Pen Li", 20, 70, 9, 3000, 800));
        list.add(new GymUser(3, "Rana", 34, 110, 9, 2400, 450));
        list.add(new GymUser(4, "Bob", 39, 104, 1, 1800, 500));
        list.add(new GymUser(5, "LaLi", 18, 85, 7, 1700, 600));
        list.add(new GymUser(6, "LaLi", 19, 90, 9, 1000, 690));

        Collections.sort(list, Comparator.comparing(GymUser::getName).thenComparing(GymUser::getAge));

        assertEquals(list.get(0), new GymUser(4, "Bob", 39, 104, 1, 1800, 500));
    }


    @Test
    public void collectionsSortingWithJava8StreamAPI_sorted_natural_ordering_uses_Comparable() {

        List<GymUser> list = new ArrayList<>();
        list.add(new GymUser(1, "Richard", 32, 99, 10, 2000, 300));
        list.add(new GymUser(2, "Pen Li", 20, 70, 9, 3000, 800));
        list.add(new GymUser(3, "Rana", 34, 110, 9, 2400, 450));
        list.add(new GymUser(4, "Bob", 39, 104, 1, 1800, 500));
        list.add(new GymUser(5, "LaLi", 18, 85, 7, 1700, 600));
        list.add(new GymUser(6, "LaLi", 19, 90, 9, 1000, 690));

        list = list.stream().sorted().collect(Collectors.toList());

        assertEquals(list.get(0), new GymUser(5, "LaLi", 18, 85, 7, 1700, 600));
    }


    @Test
    public void collectionsSortingWithJava8StreamAPI_sorted_natural_ordering_uses_Comparable_reversed() {

        List<GymUser> list = new ArrayList<>();
        list.add(new GymUser(1, "Richard", 32, 99, 10, 2000, 300));
        list.add(new GymUser(2, "Pen Li", 20, 70, 9, 3000, 800));
        list.add(new GymUser(3, "Rana", 34, 110, 9, 2400, 450));
        list.add(new GymUser(4, "Bob", 39, 104, 1, 1800, 500));
        list.add(new GymUser(5, "LaLi", 18, 85, 7, 1700, 600));
        list.add(new GymUser(6, "LaLi", 19, 90, 9, 1000, 690));

        list = list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());

        assertEquals(list.get(0), new GymUser(4, "Bob", 39, 104, 1, 1800, 500));
    }

    @Test
    public void collectionsSortingWithJava8StreamAPI_sorted_uses_Comparator() {

        List<GymUser> list = new ArrayList<>();
        list.add(new GymUser(1, "Richard", 32, 99, 10, 2000, 300));
        list.add(new GymUser(2, "Pen Li", 20, 70, 9, 3000, 800));
        list.add(new GymUser(3, "Rana", 34, 110, 9, 2400, 450));
        list.add(new GymUser(4, "Bob", 39, 104, 1, 1800, 500));
        list.add(new GymUser(5, "LaLi", 18, 85, 7, 1700, 600));
        list.add(new GymUser(6, "LaLi", 19, 90, 9, 1000, 690));


        list = list.stream().sorted((lhs, rhs) -> {
            return lhs.getName().compareTo(rhs.getName());
        }).collect(Collectors.toList());

        assertEquals(list.get(0), new GymUser(4, "Bob", 39, 104, 1, 1800, 500));
    }



    @Test
    public void collectionsSortingWithJava8StreamAPI_sorted_uses_Comparator_reversed() {

        List<GymUser> list = new ArrayList<>();
        list.add(new GymUser(1, "Richard", 32, 99, 10, 2000, 300));
        list.add(new GymUser(2, "Pen Li", 20, 70, 9, 3000, 800));
        list.add(new GymUser(3, "Rana", 34, 110, 9, 2400, 450));
        list.add(new GymUser(4, "Bob", 39, 104, 1, 1800, 500));
        list.add(new GymUser(5, "LaLi", 18, 85, 7, 1700, 600));
        list.add(new GymUser(6, "LaLi", 19, 90, 9, 1000, 690));


        list = list.stream().sorted(Comparator.comparing(GymUser::getName).reversed()).collect(Collectors.toList());

        assertEquals(list.get(0), new GymUser(1, "Richard", 32, 99, 10, 2000, 300));
    }

    @Test
    public void collectionsSortingWithJava8StreamAPI_sorted_uses_Comparator_reversed_another_style() {

        List<GymUser> list = new ArrayList<>();
        list.add(new GymUser(1, "Richard", 32, 99, 10, 2000, 300));
        list.add(new GymUser(2, "Pen Li", 20, 70, 9, 3000, 800));
        list.add(new GymUser(3, "Rana", 34, 110, 9, 2400, 450));
        list.add(new GymUser(4, "Bob", 39, 104, 1, 1800, 500));
        list.add(new GymUser(5, "LaLi", 18, 85, 7, 1700, 600));
        list.add(new GymUser(6, "LaLi", 19, 90, 9, 1000, 690));


        list = list.stream().sorted(Comparator.comparing(GymUser::getName, Comparator.reverseOrder())).collect(Collectors.toList());

        assertEquals(list.get(0), new GymUser(1, "Richard", 32, 99, 10, 2000, 300));
    }

    @Test
    public void collectionsSortingWithJava8StreamAPI_sorted_uses_Comparator_comparing() {

        List<GymUser> list = new ArrayList<>();
        list.add(new GymUser(1, "Richard", 32, 99, 10, 2000, 300));
        list.add(new GymUser(2, "Pen Li", 20, 70, 9, 3000, 800));
        list.add(new GymUser(3, "Rana", 34, 110, 9, 2400, 450));
        list.add(new GymUser(4, "Bob", 39, 104, 1, 1800, 500));
        list.add(new GymUser(5, "LaLi", 18, 85, 7, 1700, 600));
        list.add(new GymUser(6, "LaLi", 19, 90, 9, 1000, 690));


        list = list.stream().sorted(Comparator.comparing(GymUser::getName)).collect(Collectors.toList());

        assertEquals(list.get(0), new GymUser(4, "Bob", 39, 104, 1, 1800, 500));
    }


    @Test
    public void collectionsSortingWithJava8StreamAPI_sorted_uses_Comparator_comparing_null_last() {

        List<GymUser> list = new ArrayList<>();
        list.add(new GymUser(1, "Richard", 32, 99, 10, 2000, 300));
        list.add(new GymUser(2, "Pen Li", 20, 70, 9, 3000, 800));
        list.add(new GymUser(3, "Rana", 34, 110, 9, 2400, 450));
        list.add(new GymUser(4, "Bob", 39, 104, 1, 1800, 500));
        list.add(new GymUser(5, "LaLi", 18, 85, 7, 1700, 600));
        list.add(null);


        list = list.stream().sorted(Comparator.nullsLast(Comparator.comparing(GymUser::getName))).collect(Collectors.toList());

        assertEquals(list.get(0), new GymUser(4, "Bob", 39, 104, 1, 1800, 500));
    }


    @Test
    public void collectionsSortingWithJava8StreamAPI_sorted_uses_Comparator_comparing_null_first() {

        List<GymUser> list = new ArrayList<>();
        list.add(new GymUser(1, "Richard", 32, 99, 10, 2000, 300));
        list.add(new GymUser(2, "Pen Li", 20, 70, 9, 3000, 800));
        list.add(new GymUser(3, "Rana", 34, 110, 9, 2400, 450));
        list.add(new GymUser(4, "Bob", 39, 104, 1, 1800, 500));
        list.add(new GymUser(5, "LaLi", 18, 85, 7, 1700, 600));
        list.add(null);


        list = list.stream().sorted(Comparator.nullsFirst(Comparator.comparing(GymUser::getName))).collect(Collectors.toList());

        assertEquals(list.get(1), new GymUser(4, "Bob", 39, 104, 1, 1800, 500));
    }



    // primitive Array sorting

    @Test
    public void primitiveArraySorting() {

        int[] unsorted = new int[] {9, 1, 3, 5, 4, 99, 88, 0, 22, 1857};
        int[] sorted = new int[] {0, 1, 3, 4, 5, 9, 22, 88, 99, 1857};


        Arrays.sort(unsorted);

        assertTrue(Arrays.equals(unsorted, sorted));
    }

    @Test
    public void primitiveArraySorting_with_Range() {

        int[] unsorted = new int[] {9, 1, 3, 5, 4, 99, 88, 0, 22, 1857};
        int[] sortedRanged = new int[] {9, 1, 3, 4, 5, 88, 99, 0, 22, 1857};


        Arrays.sort(unsorted, 2, 7);

        assertTrue(Arrays.equals(unsorted, sortedRanged));
    }

    @Test
    public void primitiveArraySorting_with_Range_ParallelSort() {

        int[] unsorted = new int[] {9, 1, 3, 5, 4, 99, 88, 0, 22, 1857};
        int[] sortedRanged = new int[] {9, 1, 3, 4, 5, 88, 99, 0, 22, 1857};


        Arrays.parallelSort(unsorted, 2, 7);

        assertTrue(Arrays.equals(unsorted, sortedRanged));
    }


}