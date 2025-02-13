package org.example;

import org.example.classes.Funcionario;
import org.example.classes.Principal;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<Funcionario> base = Principal.inserirFuncionarios();
        System.out.println();
        System.out.println("#############################");
        System.out.println("Lista carregada com sucesso!");
        System.out.println("#############################");

        boolean flag = true;

        while (flag) {
            System.out.println();
                        System.out.println("1 - Remover Joao");
            System.out.println("2 - Imprimir todos");
            System.out.println("3 - Conceder aumento");
            System.out.println("4 - Agrupar em MAP");
            System.out.println("5 - Imprimir por função");
            System.out.println("6 - Imprimir mais velho (idade)");
            System.out.println("7 - Imprimir lista ordenada");
            System.out.println("8 - Imprimir total de salarios");
            System.out.println("9 - Imprimir salarios/salario-minimo");
            System.out.println("0 - SAIR");

            int opcao = sc.nextInt();

            switch (opcao) {
                case 1: Principal.removerJoao(base); break;
                case 2: Principal.imprimirTodos(base); break;
                case 3: Principal.concederAumento(base); break;
                case 4: Principal.agruparMap(base); break;
                case 5: Principal.imprimirPorFuncao(base); break;
                case 6: Principal.imprimirMaisVelho(base); break;
                case 7: Principal.imprimirListaOrdenada(base); break;
                case 8: Principal.imprimirTotalSalarios(base); break;
                case 9: Principal.imprimirPercentualPorSalarioMinimo(base); break;

                case 0: flag = false;
            }
        }
    }
}