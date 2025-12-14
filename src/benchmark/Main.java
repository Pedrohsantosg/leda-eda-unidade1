package benchmark;

public class Main {

    public static void main(String[] args) {

        // Benchmark de ordenação
        SortBenchmark.run(20_000);
        SortBenchmark.run(100_000);

        // Benchmark de buscas
        SearchBenchmark.run(20_000);
        SearchBenchmark.run(100_000);
    }
}
