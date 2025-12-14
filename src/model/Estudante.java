package model;

public class Estudante implements Comparable<Estudante> {

    private int matricula;
    private String nome;
    private int nota;

    public Estudante(int matricula, String nome, int nota) {
        this.matricula = matricula;
        this.nome = nome;
        this.nota = nota;
    }

    public int getMatricula() {
        return matricula;
    }

    public String getNome() {
        return nome;
    }

    public int getNota() {
        return nota;
    }

    @Override
    public int compareTo(Estudante outro) {
        // 1) Nota decrescente
        int cmpNota = Integer.compare(outro.nota, this.nota);
        if (cmpNota != 0) return cmpNota;

        // 2) Nome crescente
        int cmpNome = this.nome.compareTo(outro.nome);
        if (cmpNome != 0) return cmpNome;

        // 3) Matrícula crescente
        return Integer.compare(this.matricula, outro.matricula);
    }

    @Override
    public String toString() {
        return String.format("%s (mat=%d, nota=%d)", nome, matricula, nota);
    }
}
