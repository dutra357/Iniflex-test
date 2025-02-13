package org.example.classes;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;

public class Funcionario extends Pessoa {
    private BigDecimal salario;
    private String funcao;

    public Funcionario(String nome, LocalDate dataNascimento,
                       BigDecimal salario, String funcao) {
        super(nome, dataNascimento);
        this.salario = salario;
        this.funcao = funcao;
    }

    public Integer getIdade() {
        Integer idade = Period.between(this.getDataNascimento(), LocalDate.now()).getYears();
        return idade;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    @Override
    public String toString() {
        return "Nome: " + getNome() + ", " +
                "Nascimento: " + Principal.formataData(getDataNascimento()) + ", " +
                "Salario: " + Principal.formataSalario(salario) + ", " +
                "funcao: " + funcao + ".";
    }
}