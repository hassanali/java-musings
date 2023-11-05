package com.java.musings.collections.sorting.java8plus.lambdas;

import com.java.musings.beans.GymUser;
import com.java.musings.collections.sorting.java8plus.functionalinterfaces.MySimpleFunctionalInterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;

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

    private void useSupplier(Supplier<String> supplier) {
        System.out.println(supplier.get());
    }


    private void useUnaryOperator(UnaryOperator<GymUser> unaryOperator, GymUser gymUser) {
        unaryOperator.apply(gymUser);
    }

    private void useBinaryOperator(BinaryOperator<GymUser> binaryOperator, GymUser gymUser1, GymUser gymUser2) {
        GymUser apply = binaryOperator.apply(gymUser1, gymUser2);
        System.out.println(apply);
    }


    private void useBiPredicate(BiPredicate<GymUser, GymUser> biPredicate, GymUser gymUser1, GymUser gymUser2) {
        System.out.println(biPredicate.test(gymUser1, gymUser2));
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

        lambdas.useSupplier(() -> "This is a sample supplier lambda");

        GymUser user = new GymUser(34, "Hassan", 34, 98, 500, 2000, 700);
        lambdas.useUnaryOperator((arg) -> {
            arg.setAge(35);
            System.out.println(arg);
            return arg;
        }, user );


        GymUser user2 = new GymUser(34, "Ali", 35, 90, 600, 2000, 700);
        lambdas.useBinaryOperator((arg1, arg2) -> {
            if (arg1.getCaloriesBurntDaily() > arg2.getCaloriesBurntDaily()) {
                return arg1;
            }
            else {
                return arg2;
            }
        }, user, user2);


        lambdas.useBiPredicate((arg1, arg2) -> arg1.getName().length() > arg2.getName().length(), user, user2);
        lambdas.useBiPredicate((arg1, arg2) -> arg1.getWeight() > arg2.getWeight(), user, user2);

    }
}
