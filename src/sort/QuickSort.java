package sort;

import model.Estudante;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class QuickSort {

    /**
     * QuickSort versão simples (slide)
     */
    public static Estudante[] sortSimple(Estudante[] input) {
        Estudante[] arr = input.clone();
        quickSort(arr, 0, arr.length - 1);
        return arr;
    }

    private static void quickSort(Estudante[] arr, int low, int high) {
        if (low < high) {
            int p = partition(arr, low, high);
            quickSort(arr, low, p - 1);
            quickSort(arr, p + 1, high);
        }
    }

    private static int partition(Estudante[] arr, int low, int high) {
        Estudante pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j].compareTo(pivot) <= 0) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    /**
     * QuickSort com shuffle (evita pior caso)
     */
    public static Estudante[] sortWithShuffle(Estudante[] input) {
        Estudante[] arr = input.clone();

        // shuffle antes de ordenar
        List<Estudante> list = Arrays.asList(arr);
        Collections.shuffle(list);
        list.toArray(arr);

        quickSort(arr, 0, arr.length - 1);
        return arr;
    }

    /**
     * QuickSort do Java (TimSort para objetos)
     */
    public static Estudante[] sortJava(Estudante[] input) {
        Estudante[] arr = input.clone();
        Arrays.sort(arr);
        return arr;
    }

    private static void swap(Estudante[] arr, int i, int j) {
        Estudante temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    /**
     * Versão simples para int[]
     */
    public static int[] sortSimple(int[] input){
        int arr[] = input.clone();
        quickSort(arr,0,arr.length - 1);
        return arr;
    }

    /**
     * versão com shuffle para int[]
     */
    public static int[] sortWithShuffle(int[] input){
        int[] arr = input.clone();

        shuffleArray(arr);

        quickSort(arr,0,arr.length -1);
        return arr;
    }

    /**
     * Versão java
     */
    public static int[] sortJava(int[] input){
        int[] arr = input.clone();
        Arrays.sort(arr);
        return arr;
    }
    private static void quickSort(int arr[], int low, int high){
        if(low < high){
            int p = partition(arr,low,high);
            quickSort(arr, low, p -1);
            quickSort(arr, p + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void shuffleArray(int[] array) {
        java.util.Random rnd = new java.util.Random();
        for (int i = array.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            swap(array, index, i);
        }
    }
}
