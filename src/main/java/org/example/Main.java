package org.example;

import org.example.classes.Funcionario;
import org.example.classes.Principal;

import java.util.List;

public class Main {



    public static void main(String[] args) {

        List<Funcionario> base = Principal.inserirFuncionarios();

        Principal.imprimirTotalSalarios(base);
    }
}