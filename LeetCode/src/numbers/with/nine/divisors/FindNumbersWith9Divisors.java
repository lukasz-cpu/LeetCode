package numbers.with.nine.divisors;

public class FindNumbersWith9Divisors {

    public static void main(String[] args) {
        int N = 36;
        int count = 0;

        for (int i = 1; i <= N; i++) {
            if (hasExactly9Divisors(i)) {
                count++;
            }
        }

        System.out.println("Liczba liczb z dokładnie 9 dzielnikami: " + count);
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

