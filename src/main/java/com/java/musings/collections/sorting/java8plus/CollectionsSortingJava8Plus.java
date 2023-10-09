package com.java.musings.collections.sorting.java8plus;

import com.java.musings.beans.GymUser;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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

        Collections.sort(list, (GymUser user1, GymUser user2) -> user1.getName().compareTo(user2.getName()));

        assertEquals(list.get(0), new GymUser(4, "Bob", 39, 104, 1, 1800, 500));
    }

}