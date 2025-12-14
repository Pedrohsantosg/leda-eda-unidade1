package benchmark;

import model.Estudante;
import sort.InsertionSort;
import util.DataGenerator;

public class Main {

    public static void main(String[] args) {

        Estudante[] alunos = DataGenerator.gerarEstudantes(10);

        System.out.println("ANTES:");
        for (Estudante e : alunos) {
            System.out.println(e);
        }

        Estudante[] ordenado = InsertionSort.sort(alunos);

        System.out.println("\nDEPOIS:");
        for (Estudante e : ordenado) {
            System.out.println(e);
        }
    }
}
