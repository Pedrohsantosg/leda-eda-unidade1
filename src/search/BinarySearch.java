package search;

import model.Estudante;

public class BinarySearch {

    /**
     * Busca Binária Iterativa
     */
    public static int iterative(Estudante[] arr, Estudante target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            int cmp = arr[mid].compareTo(target);

            if (cmp == 0) {
                return mid;
            } else if (cmp < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    /**
     * Busca Binária Recursiva
     */
    public static int recursive(Estudante[] arr, Estudante target) {
        return recursiveHelper(arr, target, 0, arr.length - 1);
    }

    private static int recursiveHelper(Estudante[] arr, Estudante target, int left, int right) {
        if (left > right) {
            return -1;
        }

        int mid = left + (right - left) / 2;
        int cmp = arr[mid].compareTo(target);

        if (cmp == 0) {
            return mid;
        } else if (cmp < 0) {
            return recursiveHelper(arr, target, mid + 1, right);
        } else {
            return recursiveHelper(arr, target, left, mid - 1);
        }
    }
}
