package search;

import model.Estudante;

public class LinearSearch {

    /**
     * Busca Linear Iterativa
     */
    public static int iterative(Estudante[] arr, Estudante target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].compareTo(target) == 0) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Busca Linear Recursiva
     */
    public static int recursive(Estudante[] arr, Estudante target) {
        return recursiveHelper(arr, target, 0);
    }

    private static int recursiveHelper(Estudante[] arr, Estudante target, int index) {
        if (index >= arr.length) {
            return -1;
        }
        if (arr[index].compareTo(target) == 0) {
            return index;
        }
        return recursiveHelper(arr, target, index + 1);
    }
}
