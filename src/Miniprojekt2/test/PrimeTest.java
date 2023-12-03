package Miniprojekt2.test;


import Miniprojekt2.main.Prime;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PrimeTest {

    @Test
    @DisplayName("Testing range without primes")
    void testWithoutPrimes() {
        Prime prime = new Prime(24, 25);
        assertTrue(prime.getPrimes().isEmpty());
    }

    @Test
    @DisplayName("Testing a single prime")
    public void testSinglePrime() {
        Prime prime = new Prime(7, 7);
        assertNotNull(prime.getPrimes());
        assertEquals(1, prime.getCount());
        assertEquals(7, prime.getSumOfPrimes());
    }


    @Test
    @DisplayName("Initializing of the constructor test")
    void testConstructor() {
        Prime prime = new Prime(0, 1000);
        assertNotNull(prime.getPrimes());
        assertFalse(prime.getPrimes().isEmpty());
    }

    @Test
    @DisplayName("Initializing of the constructor, test for a small valid range")
    void testPrimeSmallRange() {
        Prime prime = new Prime(0, 10);

        int[] expectedPrimes = {2, 3, 5, 7};
        for (int expectedPrime : expectedPrimes) {
            assertTrue(prime.getPrimes().contains(expectedPrime));
        }

        assertEquals(expectedPrimes.length, prime.getPrimes().size());
    }

    @Test
    @DisplayName("getPrimes for valid range test")
    void testGetPrimes() {
        Prime prime = new Prime(10, 20);
        List<Integer> expectedPrimes = Arrays.asList(11, 13, 17, 19);
        assertEquals(expectedPrimes, prime.getPrimes());
    }

    @Test
    @DisplayName("Test for a very high upper limit")
    void testUpperLimit() {
        Prime prime = new Prime(998, 1000);
        assertTrue(prime.getPrimes().isEmpty());
    }

    @Test
    @DisplayName("Test for a very low lower limit")
    void testLowerLimit() {
        Prime prime = new Prime(0, 2);
        assertEquals(List.of(2), prime.getPrimes());
    }

    @Test
    @DisplayName("Initializing of the constructor, test for the boundary values")
    void testConstructorBoundries() {
        Prime primeAtZero = new Prime(0, 0);
        assertTrue(primeAtZero.getPrimes().isEmpty());

        Prime primeAtMax = new Prime(1000, 1000);
        assertEquals(0, primeAtMax.getPrimes().size());
    }

    @Test
    @DisplayName("getPrimes for valid lower bound range test")
    void testPrimeLowerInterval() {
        Prime prime = new Prime(0, 100);
        List<Integer> expectedPrimes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37,
                41, 43,47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97);
        assertEquals(expectedPrimes, prime.getPrimes());
    }

    @Test
    @DisplayName("getPrimes for valid upper bound range test")
    void testPrimeUpperInterval() {
        Prime prime = new Prime(900, 1000);
        List<Integer> expectedPrimes = Arrays.asList(907, 911, 919, 929, 937, 941, 947, 953, 967, 971, 977, 983, 991, 997);
        assertEquals(expectedPrimes, prime.getPrimes());
    }

    @Test
    @DisplayName("Count primes for a known range test")
    void testCountPrimes() {
        Prime prime = new Prime(0, 10);
        assertEquals(4, prime.getCount());
    }

    @Test
    @DisplayName("The sum of primes for known range test")
    void testSumPrimes() {
        Prime prime = new Prime(0, 10);
        int expectedSum = 2 + 3 + 5 + 7;
        assertEquals(expectedSum, prime.getSumOfPrimes());
    }

    @Test
    @DisplayName("Specific exception test with a message for invalid ranges")
    void testExceptionInvalidRange() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Prime(-1, 1000));
        assertEquals("Hoppsan, fel intervall angivet!", exception.getMessage());
    }

    @Test
    @DisplayName("Another specific exception test with a message for inverted ranges")
    void testExceptionInvertedRange() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Prime(1000, 0));
        assertEquals("Hoppsan, fel intervall angivet!", exception.getMessage());
    }

}
