/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exp4_3;

import java.util.Vector;

/**
 *
 * @author ACP134
 */
public class FindPrime implements Runnable {

    int start, end;
    Vector primes;

    public static boolean isPrime(int num) {
        for (int i = 2; i <= (int) Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    FindPrime(int s, int e, Vector p) {
        start = s;
        end = e;
        primes = p;
    }

    @Override
    public void run() {
        for (int i = start; i <= end; i++) {
            if (isPrime(i)) {
                primes.add(i);
            }
        }
    }
}
