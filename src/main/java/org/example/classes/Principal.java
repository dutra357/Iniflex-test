package org.example.classes;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

public class Principal {

    //METODS DE APOIO SETADOS PARA PRIVATE, DE USO APENAS NA CLASSE

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

        boolean remover = false;
        Funcionario obj = null;

        for (Funcionario funcionario : lista) {
            if (funcionario.getNome().equals("Joao")) {

                System.out.println("Removendo Joao...");
                remover = true;
                obj = funcionario;
            }
        }
        //Método alternativo para não gerar erro ao remover durante a iteração do laço
        //Sem usar removeIf ou criar um Iterator
        if (remover) {
            removeJoao(lista, obj);
        }
    }

    private static void removeJoao(List<Funcionario> lista, Funcionario obj) {
        lista.remove(obj);
        System.out.println("Joao removido da lista!");
    }

    public static void imprimirTodos(List<Funcionario> lista) {
        for (Funcionario funcionario : lista) {
            System.out.println(funcionario);
        }
    }

    public static void concederAumento(List<Funcionario> lista) {

        for (Funcionario funcionario : lista) {
            funcionario.setSalario(
                    funcionario.getSalario().multiply(new BigDecimal("1.1"))
            );
        }
    }

    public static void agruparMap(List<Funcionario> lista) {

        //Solução sem utilizar stream
        System.out.println("Agrupando funcionários em um MAP..");
        Map<String, List<Funcionario>> meuMap = new HashMap<>();

        //Set para  segregar 'funcoes' nao repetidas
        Set<String> funcoes = criaSetString(lista);

        //Inicializqando um array para cada 'funçao' dentro do map
        funcoes.forEach(funcao -> meuMap.put(funcao, new ArrayList<>()));

        //Busca o array de cada 'funcao' e insere o funcionario classificado
        for (Funcionario funcionario : lista) {
            List<Funcionario> listaPropria = meuMap.get(funcionario.getFuncao());
            listaPropria.add(funcionario);
        }
    }

    public static void imprimirPorFuncao(List<Funcionario> lista) {

        //Item 3.6 nao especifica se é para usar o MAP anterior ou criar um novo método
        //Para diversificar, crio um novo método para não imprimir o MAP anterior
        Set<String> funcoes = criaSetString(lista);

        for (String funcao : funcoes) {

            System.out.println("########################");
            System.out.println("Listando funcionarios: " + funcao);
            for (Funcionario funcionario : lista) {
                if (funcionario.getFuncao().equals(funcao)) {
                    System.out.println(funcionario);
                }
            }
        }
    }

    private static Set<String> criaSetString(List<Funcionario> lista) {

        //Método de apoio para não repetir código
        Set<String> funcoes = new HashSet<>();

        for (Funcionario funcionario : lista) {
            funcoes.add(funcionario.getFuncao());
        }

        return funcoes;
    }

    public static void imprimirAniversariantes(List<Funcionario> lista) {

        //Utiliza lista para poder notificar a ausência de aniversariantes - sem usar stream
        List<Funcionario> aniversariantes = new ArrayList<>();

        for (Funcionario funcionario : lista) {
            if(verificaDia(funcionario.getDataNascimento())) {
                aniversariantes.add(funcionario);
            }
        }

        if (aniversariantes.isEmpty()) {
            System.out.println("Não há aniversariantes para os dias 10 ou 12.");
        } else {
            aniversariantes.forEach(aniversariante -> System.out.println(aniversariante));
        }
    }

    private static boolean verificaDia(LocalDate date) {

        //Método de apoio para aniversariante
        //Com a exclusao de JOAO deve retornar 'false', pois nao ha cadastro com o dia 10
        String data = date.toString();
        String dia = data.substring(8,10);

        if (dia.equals("10") || dia.equals("12")) {
            return true;
        }

        return false;
    }

    public static void imprimirMaisVelho(List<Funcionario> lista) {
        Funcionario maisVelho = null;
        Integer idade = 0;

        //Laço for para nao usar stream.max
        for (Funcionario funcionario : lista) {
            if (funcionario.getIdade() > idade) {
                maisVelho = funcionario;
                idade = funcionario.getIdade();
            }
        }
        System.out.println("O funcionário mais velho é: "
                + maisVelho.getNome()
                + ", com " + maisVelho.getIdade()
                + " anos completos.");
    }

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

        System.out.println("O total de salários é: " + formataSalario(total));
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

    public static String formataSalario(BigDecimal salarioBase) {

        //Lógica sem utilizar lib ou regex
        //Sem ponto para milhão (nao cobrado)
        String sal = salarioBase.toString().replace('.', ',');
        int base = sal.length();

        if (sal.length() > 6) {
            String inicio = sal.substring(0, base - 6);
            String fim = sal.substring(base - 6, base);

            return inicio + "." + fim;
        } else {
            return sal;
        }
    }

    public static String formataData(LocalDate date) {

        //Lógica sem utilizar lib ou regex
        String data = date.toString();

        String ano = data.substring(0,4);
        String mes = data.substring(5,7);
        String dia = data.substring(8,10);

        return dia + "/" + mes + "/" + ano;
    }
}
