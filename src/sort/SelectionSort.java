package sort;

import model.Estudante;

public class SelectionSort {

    /**
     * SelectionSort versão simples (não estável)
     */
    public static Estudante[] sortSimple(Estudante[] input) {
        Estudante[] arr = input.clone();
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (arr[j].compareTo(arr[minIndex]) < 0) {
                    minIndex = j;
                }
            }

            // troca direta (quebra estabilidade)
            Estudante temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }

    /**
     * SelectionSort versão estável
     */
    public static Estudante[] sortStable(Estudante[] input) {
        Estudante[] arr = input.clone();
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (arr[j].compareTo(arr[minIndex]) < 0) {
                    minIndex = j;
                }
            }

            // guarda o menor elemento
            Estudante key = arr[minIndex];

            // desloca os elementos para a direita
            while (minIndex > i) {
                arr[minIndex] = arr[minIndex - 1];
                minIndex--;
            }

            // insere mantendo a ordem relativa
            arr[i] = key;
        }
        return arr;
    }
}
