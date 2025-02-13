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
        for (Funcionario funcionario : lista) {
            if (funcionario.getNome() == "Joao") {

                System.out.println("Removendo Joao...");
                lista.remove(funcionario);
            }
        }
    }

    public static void imprimirTodos(List<Funcionario> lista) {
        for (Funcionario funcionario : lista) {
            System.out.println(funcionario);
        }
    }

    public static void concederAumento() {}

    public static void agruparMap() {}

    public static void imprimirPorFuncao() {}

    public static void imprimirAniversariantes() {}

    public static void imprimirMaisVelho() {}

    public static void imprimirListaOrdenada() {}

    public static void imprimirTotalSalarios() {}

    public static void imprimirPercentualPorSalarioMinimo() {}
}
