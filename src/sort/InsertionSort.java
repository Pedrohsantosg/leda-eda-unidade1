package sort;

import model.Estudante;

public class InsertionSort {

    public static Estudante[] sort(Estudante[] input) {
        Estudante[] arr = input.clone();

        for (int i = 1; i < arr.length; i++) {
            Estudante key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j].compareTo(key) > 0) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
        return arr;
    }
}
