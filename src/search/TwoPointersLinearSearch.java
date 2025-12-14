package search;

import model.Estudante;

public class TwoPointersLinearSearch {

    /**
     * Busca Linear Iterativa Duas Pontas
     * Verifica simultaneamente o início e o fim do vetor
     */
    public static int search(Estudante[] arr, Estudante target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {

            if (arr[left].compareTo(target) == 0) {
                return left;
            }

            if (arr[right].compareTo(target) == 0) {
                return right;
            }

            left++;
            right--;
        }
        return -1;
    }
}
