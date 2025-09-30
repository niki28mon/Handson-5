import java.util.Arrays;

public class ArraysDeepDivePractice {
    public static void main(String[] args) {
        /*
         * PRAKTIK HANDS-ON: Arrays Deep Dive
         */

        // ===== ARRAY MULTIDIMENSI DASAR =====
        System.out.println("=== ARRAY MULTIDIMENSI DASAR ===");

        // Latihan 1
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        displayMatrix(matrix);

        // Latihan 2
        String[][] papan = {
                {".", ".", "O"},
                {"O", "X", "."},
                {".", "O", "X"}
        };
        for (int i = 0; i < papan.length; i++){
            for (int j = 0; j < papan[i].length; j++){
                System.out.print(papan[i][j] + " ");
            }
            System.out.println();
        }

        // ===== ARRAY JAGGED (IRREGULAR) =====
        System.out.println("\\n=== ARRAY JAGGED (IRREGULAR) ===");

        // Latihan 3
        int[][] jagged = new int[4][];
        jagged[0] = new int[2];
        jagged[1] = new int[4];
        jagged[2] = new int[3];
        jagged[3] = new int[5];

        int num = 1;
        for (int i = 0; i < jagged.length; i++){
            for (int j = 0; j < jagged[i].length; j++) {
                jagged[i][j] = num++;
            }
        }
        for (int i = 0; i < jagged.length; i++) {
            System.out.println("Row " + i + " (" + jagged[i].length + "): " + Arrays.toString(jagged[i]));
        }

        // ===== OPERASI LANJUTAN =====
        System.out.println("\\n=== OPERASI LANJUTAN PADA ARRAY ===");

        // Latihan 4
        int[][] m1 = {{1, 2, 3}, {4, 5, 6}};
        int[][] m2 = {{6, 5, 4}, {3, 2, 1}};

        int[][] hasilTambah = addMatrices(m1, m2);
        System.out.println("Penjumlahan Matriks:");
        displayMatrix(hasilTambah);

        int[][] hasilKali = multiplyByScalar(m1, 2);
        System.out.println("Perkalian dengan scalar 2:");
        displayMatrix(hasilKali);


        // ===== ARRAY SEBAGAI PARAMETER DAN RETURN VALUE =====
        System.out.println("\\n=== ARRAY SEBAGAI PARAMETER DAN RETURN VALUE ===");

        // Latihan 5
        int[] numbers = {64, 34, 25, 12, 22, 11, 90};

        int[] sorted = sortArray(numbers);
        System.out.println("Sorted: " + Arrays.toString(sorted));

        int[] reversed = sortArray(numbers);
        System.out.println("Sorted: " + Arrays.toString(reversed));

        int[] minmax = findMinMax(numbers);
        System.out.println("Min: " + minmax[0] + ",Max:" + minmax[1]);

        // ===== UTILITY METHODS JAVA.UTIL.ARRAYS =====
        System.out.println("\\n=== UTILITY METHODS JAVA.UTIL.ARRAYS ===");

        // Latihan 6
        int[] data = {5, 2, 8, 1, 9, 3};
        System.out.println("toString:" + Arrays.toString(data));
        Arrays.sort(data);
        System.out.println("Sorted: " + Arrays.toString(data));
        System.out.println("BinarySearch 8: " + Arrays.binarySearch(data, 8));
        Arrays.fill(data, 7);
        System.out.println("Fill: " + Arrays.toString(data));
        int[] copy = Arrays.copyOf(data, 10);
        System.out.println("Copy: " + Arrays.toString(copy));


        // ===== ARRAY 3D DAN KOMPLEKS =====
        System.out.println("\\n=== ARRAY 3D DAN KOMPLEKS ===");

        // Latihan 7
        int[][][] array3D = new int[2][3][4];
        int val = 1;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 4; k++) {
                    array3D[i][j][k] = val++;
                }
            }
        }
        for (int i = 0; i < 2; i++) {
            System.out.println("Matrix ke-" + (i + 1));
            for (int j = 0; j < 3; j++) {
                System.out.println(Arrays.toString(array3D[i][j]));
            }
        }

        // ===== SKENARIO APLIKASI NYATA =====
        System.out.println("\\n=== SKENARIO APLIKASI NYATA ===");

        // Latihan 8
        String[] namaMahasiswa = {"Alice", "Bob", "Charlie", "Diana", "Eva"};
        String[] mataKuliah = {"Math", "Physics", "Chemistry", "Biology"};
        int[][] nilai = new int[namaMahasiswa.length][mataKuliah.length];
        fillRandomGrades(nilai, 60, 100);

        for (int i = 0; i < namaMahasiswa.length; i++) {
            System.out.print(namaMahasiswa[i] + ": ");
            System.out.println(Arrays.toString(nilai[i]) +
                    " | Rata-rata: " + calculateAverage(nilai[i]));
        }
    }

    public static int[][] addMatrices(int[][] matrix1, int[][] matrix2) {
        int rows = matrix1.length;
        int cols = matrix1[0].length;
        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        return result;
    }

    public static int[][] multiplyByScalar(int[][] matrix, int scalar) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrix[i][j] * scalar;
            }
        }
        return result;
    }
    public static int[] sortArray(int[] arr) {
        int[] copy = Arrays.copyOf(arr, arr.length);
        Arrays.sort(copy);
        return copy;
    }

    public static int[] reverseArray(int[] arr) {
        int[] reversed = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            reversed[i] = arr[arr.length - 1 - i];
        }
        return reversed;
    }

    public static int[] findMinMax(int[] arr) {
        int min = arr[0], max = arr[0];
        for (int v : arr) {
            if (v < min) min = v;
            if (v > max) max = v;
        }
        return new int[]{min, max};
    }

    public static void displayMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }
    public static void fillRandomGrades(int[][] grades, int min, int max) {
        for (int i = 0; i < grades.length; i++) {
            for (int j = 0; j < grades[i].length; j++) {
                grades[i][j] = (int)(Math.random() * (max - min + 1)) + min;
            }
        }
    }

    public static double calculateAverage(int[] values) {
        int sum = 0;
        for (int v : values) sum += v;
        return (double) sum / values.length;
    }
}