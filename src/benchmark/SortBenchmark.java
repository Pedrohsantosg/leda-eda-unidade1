package benchmark;

import model.Estudante;
import util.DataGenerator;

import sort.*;

public class SortBenchmark {

    private static final int WARMUP = 5;
    private static final int RUNS = 20;

    public static void run(int size) {

        System.out.println("\n===== SORT BENCHMARK (n = " + size + ") =====");

        Estudante[] base = DataGenerator.gerarEstudantes(size);

        benchmark("BubbleSort Simple",
                () -> BubbleSort.sortSimple(base));

        benchmark("BubbleSort Optimized",
                () -> BubbleSort.sortOptimized(base));

        benchmark("InsertionSort",
                () -> InsertionSort.sort(base));

        benchmark("SelectionSort Simple",
                () -> SelectionSort.sortSimple(base));

        benchmark("SelectionSort Stable",
                () -> SelectionSort.sortStable(base));

        benchmark("MergeSort",
                () -> MergeSort.sort(base));

        benchmark("QuickSort Simple",
                () -> QuickSort.sortSimple(base));

        benchmark("QuickSort Shuffle",
                () -> QuickSort.sortWithShuffle(base));

        benchmark("QuickSort Java",
                () -> QuickSort.sortJava(base));

        benchmark("CountingSort",
                () -> CountingSort.sortByNota(base));
    }

    private static void benchmark(String name, Runnable task) {
        long time = BenchmarkUtils.measure(task, WARMUP, RUNS);
        System.out.printf("%-25s : %d ns%n", name, time);
    }
}
