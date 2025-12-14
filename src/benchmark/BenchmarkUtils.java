package benchmark;

public class BenchmarkUtils {

    /**
     * Executa um bloco de código e retorna o tempo médio de execução
     *
     * @param task código a ser medido
     * @param warmup número de execuções descartadas (warm-up JVM)
     * @param runs número de execuções válidas
     * @return tempo médio em nanossegundos
     */
    public static long measure(Runnable task, int warmup, int runs) {

        // Warm-up (JVM)
        for (int i = 0; i < warmup; i++) {
            task.run();
        }

        long totalTime = 0;

        for (int i = 0; i < runs; i++) {
            long start = System.nanoTime();
            task.run();
            long end = System.nanoTime();
            totalTime += (end - start);
        }

        return totalTime / runs;
    }
}
