package benchmark;

import model.Estudante;
import util.DataGenerator;

import search.BinarySearch;
import search.LinearSearch;
import search.TwoPointersLinearSearch;
import sort.MergeSort;

public class SearchBenchmark {

    private static final int WARMUP = 5;
    private static final int RUNS = 20;

    public static void run(int size) {

        System.out.println("\n===== SEARCH BENCHMARK (n = " + size + ") =====");

        // Geração e ordenação (pré-requisito da busca binária)
        Estudante[] base = DataGenerator.gerarEstudantes(size);
        Estudante[] ordered = MergeSort.sort(base);

        // Alvo existente (meio do vetor)
        Estudante target = ordered[ordered.length / 2];

        benchmark("Linear Search (Iterative)",
                () -> LinearSearch.iterative(ordered, target));

        benchmark("Linear Search (Recursive)",
                () -> LinearSearch.recursive(ordered, target));

        benchmark("Linear Search (Two Pointers)",
                () -> TwoPointersLinearSearch.search(ordered, target));

        benchmark("Binary Search (Iterative)",
                () -> BinarySearch.iterative(ordered, target));

        benchmark("Binary Search (Recursive)",
                () -> BinarySearch.recursive(ordered, target));
    }

    private static void benchmark(String name, Runnable task) {
        long time = BenchmarkUtils.measure(task, WARMUP, RUNS);
        if (time == -1){
            System.out.printf("%-30s : %s%n", name, "STACK_OVERFLOW");
        } else{
            System.out.printf("%-30s : %d ns%n", name, time);
        }
    }
}
