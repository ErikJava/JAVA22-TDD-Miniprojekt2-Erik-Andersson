package Miniprojekt2.main;

import java.util.ArrayList;
import java.util.List;

/**
 * This program counts the sum and the number of prime (int) numbers in interval 0-1000
 */
public class Prime {

    private final List<Integer> primes;
    private final int firstNumber;
    private final int lastNumber;
    private int count = 0;
    private int sumOfPrimes = 0;

    public Prime(int firstNumber, int lastNumber) {
        this.firstNumber = firstNumber;
        this.lastNumber = lastNumber;

        if (firstNumber < 0 || lastNumber < 0 || lastNumber > 1000 || firstNumber > lastNumber) {
            throw new IllegalArgumentException("Hoppsan, fel intervall angivet!");
        }

        primes = new ArrayList<>();
        calculatePrimes(firstNumber, lastNumber);
    }

    private boolean numIsPrime(int number) {
        if (number <= 1) {
            return false;
        }
        if (number % 2 == 0) {
            return number == 2;
        }
        for (int i = 3; i <= Math.sqrt(number); i += 2) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    private void calculatePrimes(int current, int stop) {
        if (current > stop) {
            return;
        }

        if (numIsPrime(current)) {
            primes.add(current);
            count++;
            sumOfPrimes += current;
        }

        calculatePrimes(++current, stop);
    }


    public List<Integer> getPrimes() {
        return primes;
    }

    public int getCount() {
        return count;
    }

    public int getSumOfPrimes() {
        return sumOfPrimes;
    }

    public void printCount() {
        System.out.println("Hej, det finns " + getCount() + " primtal mellan " + firstNumber + " och " + lastNumber + "!");
    }

    public void printSum() {
        System.out.println("Och den totala summan av dessa primtal är " + getSumOfPrimes());
    }
}
