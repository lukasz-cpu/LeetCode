package numbers.with.nine.divisors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.ArrayList;
import java.util.List;

public class FindNumbersWith9Divisors {

    public static void main(String[] args) throws Exception {
        int N = 10000000;
        int numThreads = 120;
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);

        long startTime = System.nanoTime();

        List<Future<Integer>> futures = new ArrayList<>();
        int range = N / numThreads;

        for (int i = 0; i < numThreads; i++) {
            int start = i * range + 1;
            int end = (i == numThreads - 1) ? N : (i + 1) * range;

            futures.add(executor.submit(() -> countNumbersWith9Divisors(start, end)));
        }

        int totalCount = 0;
        for (Future<Integer> future : futures) {
            totalCount += future.get(); // Czekaj na wynik wątku i dodaj do sumy
        }

        executor.shutdown();

        long endTime = System.nanoTime(); // Zmierz czas zakończenia
        long duration = endTime - startTime;

        System.out.println("Liczba liczb z dokładnie 9 dzielnikami: " + totalCount);
        System.out.println("Czas wykonania (ms): " + (duration / 1_000_000)); // Wyświetl czas w milisekundach
    }

    public static int countNumbersWith9Divisors(int start, int end) {
        int count = 0;
        for (int i = start; i <= end; i++) {
            if (hasExactly9Divisors(i)) {
                count++;
            }
        }
        return count;
    }

    public static int countDivisors(int n) {
        int count = 0;

        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                count++;
                if (i != n / i) {
                    count++;
                }
            }
        }

        return count;
    }

    public static boolean hasExactly9Divisors(int n) {
        return countDivisors(n) == 9;
    }
}
