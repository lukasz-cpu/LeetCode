package binary.search;

public class BinarySearch {
    public static void main(String[] args) {
        int[] inputArray = {-1, 0, 3, 5, 9, 12};
        search(inputArray, 9);
    }

    public static int search(int[] nums, int target) {
        int left = 0; // Początkowy wskaźnik (lewa granica tablicy)
        int right = nums.length - 1; // Końcowy wskaźnik (prawa granica tablicy)

        // Pętla działa, dopóki lewy wskaźnik nie przekroczy prawego
        while (left <= right) {
            // Oblicz środkowy indeks, aby uniknąć przepełnienia (ważne dla dużych liczb)
            int mid = left + (right - left) / 2;
            System.out.println(mid);

            // Sprawdź, czy element na środkowym indeksie jest równy szukanemu celowi
            if (nums[mid] == target) {
                return mid; // Jeśli znaleziono, zwróć indeks
            }
            // Jeśli wartość w środku jest większa niż cel
            else if (nums[mid] > target) {
                right = mid - 1; // Przesuń prawą granicę w lewo
            }
            // Jeśli wartość w środku jest mniejsza niż cel
            else {
                left = mid + 1; // Przesuń lewą granicę w prawo
            }
        }

        // Jeśli pętla się zakończy i nie znajdziemy celu, zwróć -1
        return -1;
    }


}
