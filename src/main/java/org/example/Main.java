package org.example;

import org.example.classes.Funcionario;
import org.example.classes.Principal;

import java.util.List;

public class Main {



    public static void main(String[] args) {

        List<Funcionario> base = Principal.inserirFuncionarios();

        System.out.println();
        System.out.println("Listagem inicial de funcionários: ");
        System.out.println();
        Principal.imprimirTodos(base);
        System.out.println("-------------------");
        Principal.removerJoao(base);
        System.out.println("-------------------");
        Principal.imprimirMaisVelho(base);
        System.out.println("-------------------");
        System.out.println("Listagem após exclusão (Joao): ");
        Principal.imprimirTodos(base);
        System.out.println("-------------------");
        System.out.println("Concedendo aumento..");
        Principal.concederAumento(base);
        System.out.println("-------------------");
        System.out.println("Aniversariantes: ");
        Principal.imprimirAniversariantes(base);
        System.out.println("-------------------");
        Principal.agruparMap(base);
        System.out.println("-------------------");
        Principal.imprimirPercentualPorSalarioMinimo(base);
        System.out.println("-------------------");
        Principal.imprimirTotalSalarios(base);
        System.out.println("-------------------");
        Principal.imprimirPorFuncao(base);
        System.out.println("-------------------");
    }
}