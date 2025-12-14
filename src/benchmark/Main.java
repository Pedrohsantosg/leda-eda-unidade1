package benchmark;

import model.Estudante;
import sort.BubbleSort;
import sort.InsertionSort;
import util.DataGenerator;
import sort.SelectionSort;
import sort.MergeSort;
import sort.QuickSort;
import sort.CountingSort;





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

        System.out.println("\nMERGE SORT:");
        Estudante[] merge = MergeSort.sort(alunos);
        for (Estudante e : merge) {
            System.out.println(e);
        }

        System.out.println("\nQUICK SORT (SIMPLE):");
        Estudante[] qsSimple = QuickSort.sortSimple(alunos);
        for (Estudante e : qsSimple) {
            System.out.println(e);
        }

        System.out.println("\nQUICK SORT (SHUFFLE):");
        Estudante[] qsShuffle = QuickSort.sortWithShuffle(alunos);
        for (Estudante e : qsShuffle) {
            System.out.println(e);
        }

        System.out.println("\nQUICK SORT (JAVA):");
        Estudante[] qsJava = QuickSort.sortJava(alunos);
        for (Estudante e : qsJava) {
            System.out.println(e);
        }

        System.out.println("\nCOUNTING SORT (BY NOTA):");
        Estudante[] counting = CountingSort.sortByNota(alunos);
        for (Estudante e : counting) {
            System.out.println(e);
        }




    }
}
