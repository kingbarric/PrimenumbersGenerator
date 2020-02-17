/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.primenumbers.primenumbersgen.facadeimplementation;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.stream.IntStream;
import org.springframework.stereotype.Service;

/**
 *
 * @author mac Class for finding prime numbers . A prime number is a natural
 * number greater than 1 that cannot be formed by multiplying two smaller
 * natural numbers (Wikipedia)
 */
@Service
public class PrimeNumbers {

    /**
     *
     *
     * @param start starting point of the prime numbers
     * @param end ending with this number
     * @return LinkListHelper containing list of prime numbers Brute force logic
     * with time complexity of O(n^2). this will perform slowly as it is not
     * linear
     */
    public static LinkListHelper bruteForceMethod(int start, int end) {
//    if(start <2){
//        throw  new IllegalArgumentException("Prime numbers cannot be less than 2");
//    }

        LinkListHelper listHelper = new LinkListHelper();
        for (int i = start; i <= end; i++) {
            if (bruteLogic(i)) {
                listHelper.insert(i);
            }
        }
        return listHelper;
    }

    /**
     *
     * @param number
     * @return This method checks each numbers divisibility by the numbers in a
     * range from 2 till number-1
     */
    public static boolean bruteLogic(int number) {

        if (number < 2) {
            return false;
        }
        for (int div = 2; div < number; div++) {
            if (number % div == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     *
     * @param start starting point of the prime numbers
     * @param end ending with this number
     * @return LinkListHelper containing list of prime numbers Sieve of
     * Eratosthenes : time efficiency is O(n logn).
     */
    public static LinkListHelper theSieveEratosthenesMethod(int start, int end) {
        if (start < 2) {
            throw new IllegalArgumentException("Prime number cannot be less than 2");
        }
        LinkListHelper listHelper = new LinkListHelper();
        for (int i = start; i <= end; i++) {
            //check if the number coming is prime or not then add to listHelper LinkedList
            if (sieveLogic(i)[i]) {
                //   System.err.println("LOG: "+sieveLogic(i)[i]+" i is: "+i);
                listHelper.insert(i);
            }
        }
        return listHelper;
    }

    /**
     *
     * @param n number to check
     * @return array of boolean value if is true or not
     */
    public static boolean[] sieveLogic(int n) {

        boolean isPrime[] = new boolean[n + 1];
        if (n <= 1) {
            isPrime = new boolean[1];
            isPrime[0] = false;
            return isPrime;
        }

        Arrays.fill(isPrime, true);
        for (int num = 2; num * num <= n; num++) {
            if (isPrime[num]) {
                for (int i = num * 2; i <= n; i += num) {
                    isPrime[i] = false;
                }
            }
        }
        return isPrime;
    }

    public static LinkListHelper java8Method(int start, int end) {
        LinkListHelper listHelper = new LinkListHelper();
        for (int i = start; i <= end; i++) {
            //check if the number coming is prime or not then add to listHelper LinkedList
            if (java8Logic(i)) {
                listHelper.insert(i);
            }
        }
        return listHelper;

        /**
         * IntStream.rangeClosed(2, n) .filter(x -> isPrime(x)).boxed()
         * .collect(Collectors.toList());
         *
         * NOTE: The above code could be optimized using this java 8 api stream,
         * if I decided to use inbuilt java List
         */
    }

    /**
     *
     * @param number number to check
     * @return true or false if the number is prime or not Using stream to check
     * if is prime or not
     */
    public static boolean java8Logic(int number) {

        if (number <= 1) {
            return false; // 1 is not prime and also not composite
        }
        return !IntStream.rangeClosed(2, number / 2).anyMatch(i -> number % i == 0);
    }

    public static void main(String[] args) {
        Instant start = Instant.now();
        LinkListHelper l = java8Method(3, 10000);
    //    l.show();
        Instant end = Instant.now();
        System.out.println(Duration.between(start, end));

    }

}
