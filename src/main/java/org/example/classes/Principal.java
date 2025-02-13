package org.example.classes;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Principal {

    public static List<Funcionario> inserirFuncionarios() {
        Funcionario maria = new Funcionario("Maria", LocalDate.of(2000, 10,18), new BigDecimal("2009.44"), "Operador");
        Funcionario joao = new Funcionario("Joao", LocalDate.of(1990, 5,12), new BigDecimal("2284.38"), "Operador");
        Funcionario caio = new Funcionario("Caio", LocalDate.of(1961, 5,2), new BigDecimal("9836.14"), "Coordenador");
        Funcionario miguel = new Funcionario("Miguel", LocalDate.of(1988, 10,14), new BigDecimal("19119.88"), "Diretor");
        Funcionario alice = new Funcionario("Alice", LocalDate.of(1995, 1,5), new BigDecimal("2234.68"), "Recepcionista");
        Funcionario heitor = new Funcionario("Heitor", LocalDate.of(1999, 11,19), new BigDecimal("1582.72"), "Operador");
        Funcionario arthur = new Funcionario("Arthur", LocalDate.of(1993, 3,31), new BigDecimal("4071.84"), "Contador");
        Funcionario laura = new Funcionario("Laura", LocalDate.of(1994, 7,8), new BigDecimal("3017.45"), "Gerente");
        Funcionario heloisa = new Funcionario("Heloísa", LocalDate.of(2003, 5,24), new BigDecimal("1606.85"), "Eletricista");
        Funcionario helena = new Funcionario("Helena", LocalDate.of(1996, 9,2), new BigDecimal("2799.93"), "Gerente");

        List<Funcionario> funcionarios = new ArrayList<>(Arrays.asList(maria, joao, caio, miguel,
                alice, heitor, arthur, laura, heloisa, helena));

        return funcionarios;
    }

    public static void removerJoao(List<Funcionario> lista) {

        boolean flag = false;
        Funcionario obj = null;

        for (Funcionario funcionario : lista) {
            if (funcionario.getNome() == "Joao") {

                System.out.println("Removendo Joao...");
                flag = true;
                obj = funcionario;
            }
        }
        //Método alternativo para não gerar erro durante a iteração do laço
        //Remove sem usar removeIf ou Iterator
        //Laço for costuma ser mais rápido para longas listas
        if (flag) {
            removeJoao(lista, obj);
        }
    }

    private static void removeJoao(List<Funcionario> lista, Funcionario obj) {
        lista.remove(obj);
    }

    public static void imprimirTodos(List<Funcionario> lista) {
        for (Funcionario funcionario : lista) {
            System.out.println(funcionario);
        }
    }

    public static void concederAumento(List<Funcionario> lista) {

        //Método de aumento na própria classe, sendo próprio da instância
        lista.forEach(funcionario -> funcionario.concederAumento());
    }

    public static void agruparMap(List<Funcionario> lista) {}

    public static void imprimirPorFuncao(List<Funcionario> lista) {}

    public static void imprimirAniversariantes(List<Funcionario> lista) {}

    public static void imprimirMaisVelho(List<Funcionario> lista) {}

    public static void imprimirListaOrdenada(List<Funcionario> lista) {
        List<Funcionario> ordenada = lista.stream().sorted().toList();

        for (Funcionario funcionario : ordenada) {
            System.out.println(funcionario);
        }
    }

    public static void imprimirTotalSalarios(List<Funcionario> lista) {
        BigDecimal total = BigDecimal.ZERO;

        for (Funcionario funcionario : lista) {

            total = total.add(funcionario.getSalario());
        }

        System.out.println("O total de salários é: " + total);
    }

    public static void imprimirPercentualPorSalarioMinimo(List<Funcionario> lista) {
        BigDecimal baseMinimo = new BigDecimal("1212.00");

        for (Funcionario funcionario : lista) {
            BigDecimal salariosMinimos = funcionario.getSalario().divide(baseMinimo);

            System.out.println("O funcionário " +
                    funcionario.getNome() + " " +
            "recebe " + salariosMinimos + ", tendo a função de: " +
                    funcionario.getFuncao());
        }
    }

    private static void formataSalario(BigDecimal salarioBase) {
        String salarioString = salarioBase.toString();


    }

    public static String formataData(LocalDate date) {
        //Lógica para não utilizar lib
        String data = date.toString();

        String ano = data.substring(0,4);
        String mes = data.substring(5,7);
        String dia = data.substring(8,10);

        return dia + "/" + mes + "/" + ano;
    }
}
