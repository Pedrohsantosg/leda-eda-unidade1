package benchmark;

import model.Estudante;
import util.ScenarioGenerator;

import sort.*;

public class SortBenchmark {

    private static final int WARMUP = 5;
    private static final int RUNS = 20;

    public static void run(int size) {

        System.out.println("\n===== SORT BENCHMARK (n = " + size + ") =====");

        // Cenário 1: Vetor Aleatório
        runScenario("Random", ScenarioGenerator.random(size));

        // Cenário 2: Vetor Já Ordenado
        runScenario("Sorted", ScenarioGenerator.sorted(size));

        // Cenário 3: Vetor Inversamente Ordenado
        runScenario("Reversed", ScenarioGenerator.reversed(size));
    }

    /**
     * Executa todos os algoritmos para um mesmo cenário
     */
    private static void runScenario(String scenarioName, Estudante[] base) {

        System.out.println("\n--- Scenario: " + scenarioName + " ---");

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

        benchmark("QuickSort Shuffle",
                () -> QuickSort.sortWithShuffle(base));

        benchmark("QuickSort Java",
                () -> QuickSort.sortJava(base));

        benchmark("CountingSort",
                () -> CountingSort.sortByNota(base));
    }

    /**
     * Mede o tempo médio de execução de um algoritmo
     */
    private static void benchmark(String name, Runnable task) {
        long time = BenchmarkUtils.measure(task, WARMUP, RUNS);

        if (time == -1){
            System.out.printf("%-25s : %s%n",name, "STACK_OVERFLOW");
        } else if(time == -2){
            System.out.printf("%-25s : %s%n",name, "HEAP_OVERFLOW");
        } else{
            System.out.printf("%-25s : %d ns%n", name, time);
        }

    }
}
