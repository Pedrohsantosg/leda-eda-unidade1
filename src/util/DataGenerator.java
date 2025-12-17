package util;

import model.Estudante;

import java.util.Random;

public class DataGenerator {

    private static final String[] NOMES = {
            "Ana", "Bruno", "Carlos", "Daniel", "Eduardo",
            "Fernanda", "Gabriel", "Helena", "Igor", "Julia",
            "Lucas", "Mariana", "Nicolas", "Paula", "Rafael"
    };

    private static final Random random = new Random();

    public static Estudante[] gerarEstudantes(int tamanho) {
        Estudante[] alunos = new Estudante[tamanho];

        for (int i = 0; i < tamanho; i++) {
            int matricula = 100000 + i;
            String nome = NOMES[random.nextInt(NOMES.length)];
            int nota = random.nextInt(11); // 0 a 10

            alunos[i] = new Estudante(matricula, nome, nota);
        }
        return alunos;
    }

    public static int[] genereteintegers(int tamanho){
        int[] array = new int[tamanho];
        for (int i = 0; i < tamanho; i++){
            array[i] = random.nextInt(100000);
        }
        return array;
    }
}
