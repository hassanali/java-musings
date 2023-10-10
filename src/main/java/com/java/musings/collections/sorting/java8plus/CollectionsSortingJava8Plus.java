package com.java.musings.collections.sorting.java8plus;

import com.java.musings.beans.GymUser;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

}