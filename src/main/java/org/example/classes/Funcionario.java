package org.example.classes;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Funcionario extends Pessoa {
    private BigDecimal salario;
    private String funcao;

    public Funcionario(String nome, LocalDate dataNascimento,
                       BigDecimal salario, String funcao) {
        super(nome, dataNascimento);
        this.salario = salario;
        this.funcao = funcao;
    }

    public void concederAumento() {
        this.salario = this.salario.multiply(new BigDecimal("1.1"));
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
                "Salario: " + salario + ", " +
                "funcao: '" + funcao + ".";
    }
}