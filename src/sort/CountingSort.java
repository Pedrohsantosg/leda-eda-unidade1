package sort;

import model.Estudante;

import java.util.ArrayList;
import java.util.List;

public class CountingSort {

    private static final int MAX_NOTA = 10;

    public static Estudante[] sortByNota(Estudante[] input) {

        // buckets por nota (0 a 10)
        List<Estudante>[] buckets = new ArrayList[MAX_NOTA + 1];

        for (int i = 0; i <= MAX_NOTA; i++) {
            buckets[i] = new ArrayList<>();
        }

        // distribui os estudantes nos buckets
        for (Estudante e : input) {
            buckets[e.getNota()].add(e);
        }

        // reconstrói o array (nota decrescente)
        Estudante[] result = new Estudante[input.length];
        int index = 0;

        for (int nota = MAX_NOTA; nota >= 0; nota--) {
            for (Estudante e : buckets[nota]) {
                result[index++] = e;
            }
        }

        return result;
    }
}
