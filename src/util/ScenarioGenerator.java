package util;

import model.Estudante;
import sort.MergeSort;

public class ScenarioGenerator {

    public static Estudante[] random(int size) {
        return DataGenerator.gerarEstudantes(size);
    }

    public static Estudante[] sorted(int size) {
        return MergeSort.sort(DataGenerator.gerarEstudantes(size));
    }

    public static Estudante[] reversed(int size) {
        Estudante[] sorted = sorted(size);
        for (int i = 0; i < sorted.length / 2; i++) {
            Estudante temp = sorted[i];
            sorted[i] = sorted[sorted.length - 1 - i];
            sorted[sorted.length - 1 - i] = temp;
        }
        return sorted;
    }
}
