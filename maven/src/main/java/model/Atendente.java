package model;

import javax.persistence.*;

@Entity
public class Atendente extends Funcionario {
    private int horasTrabalhadas;

    public Atendente(String nome, double salario, int horasTrabalhadas) {
        super(nome, salario);
        this.horasTrabalhadas = horasTrabalhadas;
    }

    public int getHorasTrabalhadas() {
        return horasTrabalhadas;
    }

    public void setHorasTrabalhadas(int horasTrabalhadas) {
        this.horasTrabalhadas = horasTrabalhadas;
    }
    
    @Override
    public int reporEstoque(Filmes filme) {
        filme.setEstoque(filme.getEstoque() + 1);
        return filme.getEstoque();
    }

    public int reporEstoque(int quantidade, Filmes filme){
        filme.setEstoque(filme.getEstoque() - quantidade);
        return filme.getEstoque();
    }
}
