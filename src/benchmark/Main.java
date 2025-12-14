package benchmark;

import model.Estudante;
import util.DataGenerator;

import sort.*;
import search.*;

import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        showWelcome();

        boolean running = true;
        while (running) {
            showMainMenu();
            int option = readInt("Digite a opção desejada: ");

            switch (option) {
                case 1 -> explainProject();
                case 2 -> sortingTutorial();
                case 3 -> searchingTutorial();
                case 4 -> runSortBenchmark();
                case 5 -> runSearchBenchmark();
                case 6 -> showCredits();
                case 0 -> {
                    System.out.println("\nEncerrando o sistema. Obrigado por utilizar o projeto!");
                    running = false;
                }
                default -> System.out.println("\nOpção inválida. Tente novamente.");
            }
        }
        scanner.close();
    }

    // =====================================================
    // APRESENTAÇÃO
    // =====================================================
    private static void showWelcome() {
        System.out.println("=================================================");
        System.out.println("   PROJETO LEDA / EDA - ANÁLISE DE ALGORITMOS");
        System.out.println("=================================================");
        System.out.println("Disciplina: Estrutura de Dados (LEDA/EDA)");
        System.out.println("Universidade Estadual da Paraíba (UEPB)");
        System.out.println("\nProjeto desenvolvido por:");
        System.out.println("• Pedro.hs0311");
        System.out.println("• Julio_pedrw");
        System.out.println("• Livia_denner");
        System.out.println("• BeaMatss");
        System.out.println("\nObjetivo:");
        System.out.println("Ensinar e comparar algoritmos de ordenação e busca");
        System.out.println("utilizando análise prática de desempenho.");
        pause();
    }


    // =====================================================
    // MENU PRINCIPAL
    // =====================================================
    private static void showMainMenu() {
        System.out.println("\n================ MENU PRINCIPAL ================");
        System.out.println("1 - O que é este projeto?");
        System.out.println("2 - Aprender sobre algoritmos de ORDENAÇÃO");
        System.out.println("3 - Aprender sobre algoritmos de BUSCA");
        System.out.println("4 - Executar testes de desempenho (ORDENAÇÃO)");
        System.out.println("5 - Executar testes de desempenho (BUSCA)");
        System.out.println("6 - Créditos do projeto");
        System.out.println("0 - Sair");
    }

    // =====================================================
    // OPÇÃO 1 — EXPLICAÇÃO DO PROJETO
    // =====================================================
    private static void explainProject() {
        System.out.println("\n📘 SOBRE O PROJETO");
        System.out.println("Este projeto compara diferentes algoritmos para:");
        System.out.println("- Organizar dados (ORDENAÇÃO)");
        System.out.println("- Encontrar dados (BUSCA)");
        System.out.println("\nUtilizamos uma classe chamada Estudante,");
        System.out.println("que possui nome, matrícula e nota.");
        System.out.println("\nOs algoritmos são comparados em:");
        System.out.println("- Correção");
        System.out.println("- Tempo de execução");
        System.out.println("- Comportamento em diferentes cenários");
        pause();
    }

    // =====================================================
    // OPÇÃO 2 — TUTORIAL DE ORDENAÇÃO
    // =====================================================
    private static void sortingTutorial() {

        System.out.println("\n📚 TUTORIAL: ALGORITMOS DE ORDENAÇÃO");
        System.out.println("Ordenar significa ORGANIZAR dados.");
        System.out.println("Neste projeto, os estudantes são ordenados por:");
        System.out.println("1) Nota (decrescente)");
        System.out.println("2) Nome (crescente)");
        System.out.println("3) Matrícula (crescente)");

        Estudante[] alunos = DataGenerator.gerarEstudantes(10);

        System.out.println("\n🔹 Vetor original:");
        printArray(alunos);

        explain("Bubble Sort", "Algoritmo simples, compara vizinhos.");
        runSort("Bubble Sort Simple", BubbleSort.sortSimple(alunos));

        explain("Insertion Sort", "Insere elementos na posição correta.");
        runSort("Insertion Sort", InsertionSort.sort(alunos));

        explain("Merge Sort", "Divide o vetor e depois intercala.");
        runSort("Merge Sort", MergeSort.sort(alunos));

        explain("Quick Sort", "Divide o vetor usando um pivô.");
        runSort("Quick Sort (Java)", QuickSort.sortJava(alunos));

        explain("Counting Sort", "Conta ocorrências (usa a nota).");
        runSort("Counting Sort", CountingSort.sortByNota(alunos));

        pause();
    }

    // =====================================================
    // OPÇÃO 3 — TUTORIAL DE BUSCA
    // =====================================================
    private static void searchingTutorial() {

        System.out.println("\n📚 TUTORIAL: ALGORITMOS DE BUSCA");
        System.out.println("Buscar significa ENCONTRAR um elemento.");

        Estudante[] alunos = DataGenerator.gerarEstudantes(15);
        Estudante[] ordenado = MergeSort.sort(alunos);
        Estudante alvo = ordenado[ordenado.length / 2];

        System.out.println("\n🔹 Vetor ordenado:");
        printArray(ordenado);

        System.out.println("\n🎯 Elemento procurado:");
        System.out.println(alvo);

        explain("Busca Linear", "Percorre o vetor do início ao fim.");
        runSearch("Linear Iterativa",
                LinearSearch.iterative(ordenado, alvo));

        explain("Busca Binária", "Divide o vetor ao meio.");
        runSearch("Binária Iterativa",
                BinarySearch.iterative(ordenado, alvo));

        explain("Busca Duas Pontas", "Começa do início e do fim.");
        runSearch("Duas Pontas",
                TwoPointersLinearSearch.search(ordenado, alvo));

        pause();
    }

    // =====================================================
    // OPÇÃO 4 — BENCHMARK ORDENAÇÃO
    // =====================================================
    private static void runSortBenchmark() {
        System.out.println("\n⏱ TESTE DE DESEMPENHO - ORDENAÇÃO");
        System.out.println("Aqui medimos QUAL algoritmo é mais rápido.");
        int size = readInt("Informe o tamanho do vetor (ex: 20000): ");
        SortBenchmark.run(size);
        pause();
    }

    // =====================================================
    // OPÇÃO 5 — BENCHMARK BUSCA
    // =====================================================
    private static void runSearchBenchmark() {
        System.out.println("\n⏱ TESTE DE DESEMPENHO - BUSCA");
        System.out.println("Aqui comparamos busca linear x binária.");
        int size = readInt("Informe o tamanho do vetor (ex: 20000): ");
        SearchBenchmark.run(size);
        pause();
    }

    // =====================================================
    // MÉTODOS AUXILIARES
    // =====================================================
    private static void explain(String title, String text) {
        System.out.println("\n➡ " + title);
        System.out.println("   " + text);
    }

    private static void runSort(String name, Estudante[] result) {
        System.out.println("\n--- " + name + " ---");
        printArray(result);
    }

    private static void runSearch(String name, int index) {
        System.out.println(name + " → índice encontrado: " + index);
    }

    private static void printArray(Estudante[] arr) {
        for (Estudante e : arr) {
            System.out.println(e);
        }
    }

    private static int readInt(String message) {
        System.out.print(message);
        return scanner.nextInt();
    }

    private static void pause() {
        System.out.println("\nPressione ENTER para continuar...");
        try {
            System.in.read();
        } catch (Exception ignored) {}
    }

    private static void showCredits() {
        System.out.println("\n🎓 CRÉDITOS DO PROJETO");
        System.out.println("-----------------------------------------------");
        System.out.println("Pedro.hs0311  - Desenvolvimento do código,");
        System.out.println("                 arquitetura do projeto e GitHub");
        System.out.println("Julio_pedrw   - Organização do projeto e apoio");
        System.out.println("Livia_denner  - Metodologia e análise");
        System.out.println("BeaMatss      - Análise e interpretação dos resultados");
        System.out.println("-----------------------------------------------");
        System.out.println("Projeto acadêmico - LEDA/EDA 2025.2 (UEPB)");
        pause();
    }

}
