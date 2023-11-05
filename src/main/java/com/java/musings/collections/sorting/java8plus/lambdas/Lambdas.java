package com.java.musings.collections.sorting.java8plus.lambdas;

import com.java.musings.collections.sorting.java8plus.functionalinterfaces.MySimpleFunctionalInterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @author Hassan Ali
 * @since 3rd November 2023
 */
public class Lambdas {


    private int behaviorParameterizationExample(MySimpleFunctionalInterface lambda) {
        System.out.println("This is an example of Behavior Parameterization using a functional interface");

        return lambda.performBehaviorParameterizationMiracle(this.getClass().getMethods().toString());

    }


    String predicateData = "Test Data";
    // predicate
    private boolean usePredicate(Predicate<String> predicate) {
        return predicate.test(predicateData);
    }

    List<String> list = Arrays.asList("Hassan", "Ali", "Java", "Software Engineer", "Nostalgia");
    private void useConsumer(Consumer<String> consumer) {
        for (String s : list) {
            consumer.accept(s);
        }
    }


    private void useFunction(Function<String, Integer> function, Consumer<Integer> consumer) {
        for (String s : list) {
            consumer.accept(function.apply(s));
        }
    }


    public static void main(String[] args) {

        Lambdas lambdas = new Lambdas();
        System.out.println(lambdas.behaviorParameterizationExample(arg -> (arg + "ABC").length()));
        System.out.println(lambdas.behaviorParameterizationExample(arg -> (arg + arg).length()));

        System.out.println(lambdas.usePredicate(p -> p.length() > 0));
        System.out.println(lambdas.usePredicate(a -> a == null));

        lambdas.useConsumer(s -> System.out.println(s));
        lambdas.useConsumer(arg -> {});
        lambdas.useConsumer(s -> System.out.println(new StringBuilder(s).reverse()));


        lambdas.useFunction((a) -> a.length(), p -> System.out.println(p));
        lambdas.useFunction((a) -> a.length() + 10, p -> System.out.println(p));

    }
}
