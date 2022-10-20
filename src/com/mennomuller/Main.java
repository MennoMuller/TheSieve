package com.mennomuller;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Sieve sieve = Sieve.askSieve();
        Scanner input = new Scanner(System.in);
        int number;
        while (true) {
            try {
                System.out.print("Input a number: ");
                number = input.nextInt();
                if (sieve.isGood(number)) {
                    System.out.println(number + " is good!");
                } else {
                    System.out.println(number + " is bad!");
                }
            } catch (InputMismatchException e) {
                System.out.println("That's not even a number.");
                input.next();
            }
        }
    }
}
