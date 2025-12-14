package benchmark;

import model.Estudante;
import sort.BubbleSort;
import sort.InsertionSort;
import util.DataGenerator;
import sort.SelectionSort;


public class Main {

    public static void main(String[] args) {

        Estudante[] alunos = DataGenerator.gerarEstudantes(10);

        System.out.println("ANTES:");
        for (Estudante e : alunos) {
            System.out.println(e);
        }

        System.out.println("\nBUBBLE SORT (SIMPLE):");
        Estudante[] bubbleSimple = BubbleSort.sortSimple(alunos);
        for (Estudante e : bubbleSimple) {
            System.out.println(e);
        }

        System.out.println("\nBUBBLE SORT (OPTIMIZED):");
        Estudante[] bubbleOptimized = BubbleSort.sortOptimized(alunos);
        for (Estudante e : bubbleOptimized) {
            System.out.println(e);
        }

        System.out.println("\nINSERTION SORT:");
        Estudante[] insertion = InsertionSort.sort(alunos);
        for (Estudante e : insertion) {
            System.out.println(e);
        }

        System.out.println("\nSELECTION SORT (SIMPLE):");
        Estudante[] selSimple = SelectionSort.sortSimple(alunos);
        for (Estudante e : selSimple) {
            System.out.println(e);
        }

        System.out.println("\nSELECTION SORT (STABLE):");
        Estudante[] selStable = SelectionSort.sortStable(alunos);
        for (Estudante e : selStable) {
            System.out.println(e);
        }

    }
}
