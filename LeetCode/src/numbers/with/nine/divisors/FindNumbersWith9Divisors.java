package numbers.with.nine.divisors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.ArrayList;
import java.util.List;

public class FindNumbersWith9Divisors {

    public static void main(String[] args) throws Exception {
        int N = 1_000_000_0; // Zakres
        long startTime = System.nanoTime();

        int count = countNumbersWith9DivisorsOptimized(N);

        long endTime = System.nanoTime();
        double durationInSeconds = (endTime - startTime) / 1_000_000_000.0;

        System.out.printf("Liczba liczb z dokładnie 9 dzielnikami: %d%n", count);
        System.out.printf("Czas wykonania: %.3f sekundy%n", durationInSeconds);
    }

    public static boolean[] sieveOfEratosthenes(int limit) {
        boolean[] isPrime = new boolean[limit + 1];
        for (int i = 2; i <= limit; i++) {
            isPrime[i] = true;
        }
        for (int i = 2; i * i <= limit; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= limit; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        return isPrime;
    }

    public static int countNumbersWith9DivisorsOptimized(int N) {
        int count = 0;
        int limit = (int) Math.sqrt(N);
        boolean[] isPrime = sieveOfEratosthenes(limit);

        // Liczby w formie p^8
        for (int i = 2; i * i * i * i * i * i * i * i <= N; i++) {
            if (isPrime[i]) {
                count++;
            }
        }

        // Liczby w formie p^2 * q^2
        for (int i = 2; i <= limit; i++) {
            if (isPrime[i]) {
                for (int j = i + 1; j <= limit; j++) {
                    if (isPrime[j] && (long) i * i * j * j <= N) {
                        count++;
                    }
                }
            }
        }

        return count;
    }
}
