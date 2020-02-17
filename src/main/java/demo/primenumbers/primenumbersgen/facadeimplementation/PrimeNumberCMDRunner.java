/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.primenumbers.primenumbersgen.facadeimplementation;

import java.util.Scanner;

/**
 *
 * @author mac
 */
public class PrimeNumberCMDRunner {

    static Scanner s = new Scanner(System.in);
    static int choice = 0;

    static void choices() {
        System.out.print("Enter 1 for BruteForce Generator   Enter 2 for Java8 Stream "
                + " Generator  , Enter 3 for Sieve Algo Generator ,  Enter 4 to quit  \n Input:  ");
        choice = s.nextInt();
    }

    public static void main(String[] args) {
        System.out.println("Welcome to prime number generator:");

        choices();

        for (;;) {

            switch (choice) {
                case 1:
                    System.out.println("  BruteForce Selected.");
                    System.out.print("Enter the start number : ");
                    int start = s.nextInt();
                    System.out.print("Enter the end number : ");
                    int end = s.nextInt();
                    LinkListHelper ls = PrimeNumbers.bruteForceMethod(start, end);
                    ls.show();
                    choices();
                    break;

                case 2:
                    System.out.println("  Java8Stream Selected.");
                    System.out.print("Enter the start number : ");
                    start = s.nextInt();
                    System.out.print("Enter the end number : ");
                    end = s.nextInt();
                    ls = PrimeNumbers.java8Method(start, end);
                    ls.show();
                    choices();
                    break;

                case 3:
                    System.out.println("Sieve Eratoshenes Selected.");
                    System.out.print("Enter the start number : ");
                    start = s.nextInt();
                    System.out.print("Enter the end number : ");
                    end = s.nextInt();
                    ls = PrimeNumbers.theSieveEratosthenesMethod(start, end);
                    ls.show();
                    choices();
                    break;

                case 4:
                    System.out.println("Bye...");
                    System.exit(0);
                default:
                    System.out.println("Invilid option selection try 1,2,3, or 4");
                    choices();
                    break;

            }
        }

    }

}
