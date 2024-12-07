package matrix.multiplication;

public class MatrixMultiplication {
    public static void main(String[] args) {
        // Definiowanie dwóch macierzy 3x3 i 3x5
        int[][] matrix1 = {
                {4, 55, 22},
                {5, 6, 7},
                {9, 10, 11}
        };

        int[][] matrix2 = {
                {1, 2, 3},
                {6, 7, 8},
                {11, 12, 13},
                {14, 15, 16},
                {17, 18, 19}
        };

        // Wynikowa macierz (3x5)
        int[][] result = new int[matrix1.length][matrix2[0].length];

        // Mnożenie macierzy
        for (int i = 0; i < matrix1.length; i++) { // Iteracja po wierszach matrix1
            for (int j = 0; j < matrix2[0].length; j++) { // Iteracja po kolumnach matrix2
                result[i][j] = 0; // Inicjalizowanie elementu
                for (int k = 0; k < matrix1[0].length; k++) { // Iteracja po wspólnych wymiarach
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }

        // Wyświetlanie wynikowej macierzy
        System.out.println("Wynikowa macierz:");
        for (int[] row : result) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}