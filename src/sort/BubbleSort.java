package sort;

import model.Estudante;

public class BubbleSort {

    /**
     * BubbleSort versão simples (do slide)
     */
    public static Estudante[] sortSimple(Estudante[] input) {
        Estudante[] arr = input.clone();
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    Estudante temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }

    /**
     * BubbleSort versão otimizada (com flag de troca)
     */
    public static Estudante[] sortOptimized(Estudante[] input) {
        Estudante[] arr = input.clone();
        int n = arr.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    Estudante temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            // Se não houve troca, o vetor já está ordenado
            if (!swapped) {
                break;
            }
        }
        return arr;
    }
}
