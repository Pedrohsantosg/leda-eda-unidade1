package benchmark;

import model.Estudante;
import util.DataGenerator;

import sort.*;
import search.*;

public class Main {

    public static void main(String[] args) {

        // =============================
        // 1. GERAÇÃO DOS DADOS
        // =============================
        Estudante[] alunos = DataGenerator.gerarEstudantes(10);

        System.out.println("=== VETOR ORIGINAL ===");
        printArray(alunos);

        // =============================
        // 2. ORDENAÇÕES
        // =============================
        runSort("Bubble Sort (Simple)", BubbleSort.sortSimple(alunos));
        runSort("Bubble Sort (Optimized)", BubbleSort.sortOptimized(alunos));
        runSort("Insertion Sort", InsertionSort.sort(alunos));
        runSort("Selection Sort (Simple)", SelectionSort.sortSimple(alunos));
        runSort("Selection Sort (Stable)", SelectionSort.sortStable(alunos));
        runSort("Merge Sort", MergeSort.sort(alunos));
        runSort("Quick Sort (Simple)", QuickSort.sortSimple(alunos));
        runSort("Quick Sort (Shuffle)", QuickSort.sortWithShuffle(alunos));
        runSort("Quick Sort (Java)", QuickSort.sortJava(alunos));
        runSort("Counting Sort (By Nota)", CountingSort.sortByNota(alunos));

        // =============================
        // 3. BUSCAS (vetor ordenado)
        // =============================
        Estudante[] ordenado = MergeSort.sort(alunos);
        Estudante alvo = ordenado[ordenado.length / 2];

        System.out.println("\n=== BUSCAS (ALVO: " + alvo + ") ===");

        runSearch("Linear Search (Iterative)",
                LinearSearch.iterative(ordenado, alvo));

        runSearch("Linear Search (Recursive)",
                LinearSearch.recursive(ordenado, alvo));

        runSearch("Binary Search (Iterative)",
                BinarySearch.iterative(ordenado, alvo));

        runSearch("Binary Search (Recursive)",
                BinarySearch.recursive(ordenado, alvo));
    }

    // =============================
    // MÉTODOS AUXILIARES
    // =============================

    private static void runSort(String name, Estudante[] result) {
        System.out.println("\n--- " + name + " ---");
        printArray(result);
    }

    private static void runSearch(String name, int index) {
        System.out.println(name + " -> índice: " + index);
    }

    private static void printArray(Estudante[] arr) {
        for (Estudante e : arr) {
            System.out.println(e);
        }
    }
}
