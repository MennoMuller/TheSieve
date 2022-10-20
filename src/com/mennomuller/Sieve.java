package com.mennomuller;

import java.util.Scanner;
import java.util.function.Predicate;

public class Sieve {
    private final Predicate<Integer> filter;

    public Sieve(Predicate<Integer> filter) {
        this.filter = filter;
    }

    public boolean isGood(int number) {
        return filter.test(number);
    }

    enum FilterType {
        EVEN(i -> i % 2 == 0),
        POSITIVE(i -> i >= 0),
        TENS(i -> i % 10 == 0);
        public final Predicate<Integer> filter;

        FilterType(Predicate<Integer> filter) {
            this.filter = filter;
        }
    }

    public static Sieve askSieve() {
        Scanner input = new Scanner(System.in);
        FilterType answer = null;
        do {
            try {
                System.out.print("What type of filter do you want? ");
                answer = FilterType.valueOf(input.nextLine().toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("We don't have those.");
            }
        } while (answer == null);
        return new Sieve(answer.filter);
    }
}

