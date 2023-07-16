package javaapplication1;

import com.fasterxml.jackson.core.type.TypeReference;
;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Comparator;
import java.util.TreeSet;

/**
 * Clase Sistema, classe responsável por gerenciar as informações entre o Banco
 * de dados e a Interface que é acessada pelo funcionário.Nela está contida as
 * principais funcionalidades do sistema da Pousada Milho Verde.
 *
 * @author rafar
 */


public class Sistema {

    //QUESTAO 05
    //Inicializando os 10 quaros da memória
    public static Quarto[] quartos = new Quarto[]{
        new Quarto("001", 50, "Comun"),
        new Quarto("002", 50, "Comun"),
        new Quarto("003", 50, "Comun"),
        new Quarto("004", 50, "Comun"),
        new Quarto("005", 50, "Comun"),
        new Quarto("006", 100.60, "Luxo"),
        new Quarto("007", 100.60, "Luxo"),
        new Quarto("008", 100.60, "Luxo"),
        new Quarto("009", 100.60, "Luxo"),
        new Quarto("010", 100.60, "Luxo"),};

    //Get e Set para manipular o atributo
    public static Quarto[] getQuartos() {
        return quartos;
    }

    public static void setQuartos(Quarto[] quartos) {
        Sistema.quartos = quartos;
    }

    //Lê a lista de funcionarios do Json para pegar as senhas
    private static TreeSet listaFuncionario() {
        TreeSet<Funcionario> arvoreFuncionarios = new TreeSet<>(Comparator.comparing(Funcionario::getNome));
        List<Funcionario> Colaboradores = new ArrayList<>();
        Colaboradores = Sistema.carregarDados("Funcionarios.json", Funcionario.class);
        for (Funcionario elemento : Colaboradores) {
            arvoreFuncionarios.add(elemento);
        }
        return arvoreFuncionarios;
    }

    /**
     * Este método realiza o login do usuário no Sistema, ele valida e libera o
     * acesso
     *
     * @param user
     * @param pin
     */
    public static boolean FazerLogin(String user, String pin) {
        //Lista de funcionarios;
        TreeSet<Funcionario> arvoreFuncionarios = listaFuncionario();
        //o for percorre a lista dos funcionarios
        for (Funcionario aux : arvoreFuncionarios) {
            if (user.equals(aux.getUsuario()) && pin.equals(aux.getSenha())) {
                //se a senha e usuario bater com algum o login é feito
                System.out.print("Sistema Liberado\n");
//                Sistema.executar(Colaboradores.get(i));
                return true;
                //TALVEZ MUDAR O TIPO DA FUNÇÃO E RETORNAR O FUNCIONARIO DAQUELA
                //SENHA PARA OLHAR PELO CARGO, DEIXAR UMA  LISTA SALVA DOS POSSIVEIS CARGOS E AI LIBERAR DE ACORDO
            } else {
                System.out.print("Sistema negado\n");
                return false;
            }
        }
        //Se ao percorrer o for e não encontrar quer dizer que algum dos campos esta incorreto
        System.out.print("Seção incerrada\n");
        return true;
    }

    /**
     * Esse método editar as informações contida dos clientes na base de dados
     *
     * @param <T>
     * @param lista
     * @param usuario
     * @param listaCliente
     * @param cliente
     * @return
     */
    //IMPORTANTE OLHAR 
    //Esse método vai incluir Cliente,Funcionário,Administrador e Reserva em uma lista
    public static <T> List<T> incluir(List<T> lista, T usuario) {
        if (lista.contains(usuario)) {
            System.out.println("Usuário já existente.");
        } else {
            lista.add(usuario);
            System.out.println("Usuário adicionado.");
        }
        return lista;
    }

    //QUESTÃO 09
    //TUDO PARA ABAIXO TEM A 9
    //Método responsável por editar Cliente,Funcionario ou Administrado na BD
    public static <T> List<T> editar(List<T> lista, T usuario) {
        //Recebendo lista de clientes
        if (lista.isEmpty()) {
            System.out.println("Usuario inexistente.");
            return lista;
        } else {
            for (T item : lista) {
                if (item.equals(usuario)) {
                    //Considerando que já tenha o cliente na base de dados.
                    //Para reposicionar itens, é preciso que o indice seja inteiro
                    lista.set(lista.indexOf(item), usuario);
                    System.out.println("Usuario editado.");
                    return lista;
                }
            }
            System.out.println("Usuario não encontrado.");
            return lista;
        }
    }

    //Esse método vai remover Cliente,Funcionário e Administrador em uma lista
    public static <T> List<T> remover(List<T> lista, T usuario) {
        if (lista.contains(usuario)) {
            lista.remove(usuario);
            System.out.println("Usuário removido.");
        } else {
            System.out.println("Usuário adicionado.");
        }
        return lista;
    }
    /**
     * Esse método verifica disponibilidade de reserva na base de dados
     *
     * @param listaReserva
     * @param dataInicio
     * @param dataFim
     * @param idQuarto
     */
    //Método que faz a verificação se na data selecionada o quarto esta disponível, apresentando apenas uma mensagem
    public static void verificarReserva(List<Reserva> listaReserva, String idQuarto, LocalDate dataInicio, LocalDate dataFim){
        //Caso a lista não contenha nada, tem disponibilidade em todos os quartos
        if (listaReserva.isEmpty()) {
            System.out.println("\nExiste disponibilidade em todos os quartos.");
        }else{
            //Loop que percorre a lista 
            for (Reserva reserva : listaReserva) {
                //Verificando na lista de reserva se o quarto está disponível naquela data. As condicoes devem ser satisfeitas
                if (reserva.getDataInicio().equals(dataInicio) && reserva.getDataFim().equals(dataFim) && reserva.getQuarto().getId().equals(idQuarto)) {
                    System.out.println("\nNão possível realizar reserva, data indisponível.");
                } else {
                    System.out.println("\nReserva realizada com sucesso.");
                }
            }
        } 
    }
    /**
     * Esse método cria uma reserva na base de dados
     *
     * @param listaReserva
     * @param cliente
     * @param dataInicio
     * @param dataFim
     * @param idQuarto
     * @return
     */
    //Método responsável por realizar reserva 
    public static List criarReserva(List<Reserva> listaReserva, Cliente cliente, String idQuarto, LocalDate dataInicio, LocalDate dataFim) {
        
            Reserva reserva = new Reserva(dataInicio, dataFim);
            Quarto quarto = new Quarto();
            //Preenchendo os campos da reserva e do quarto
            quarto.setId(idQuarto);
            reserva.setCliente(cliente);
            //Essa estrutura é para identificar qual quarto que foi selecionado
            for (Quarto quarto1 : quartos) {
                if (quarto1.getId().equals(idQuarto)) {
                    reserva.setQuarto(quarto1);
                    // Sai do loop após encontrar o quarto desejado
                    break;
                }
            }
            reserva.setValor(reserva.gerarValor());
            //Agora acrescentamos tudo da lista de reserva
            listaReserva.add(reserva);
            System.out.println("Reserva realizada com sucesso.");
            return listaReserva;
    }
    /**
     * Método que inclui alguma reserva realizada na base de dados, para que
     * seja realizada corretamente, é preciso que seja feita alguma verificação
     * de disponibilidade.
     *
     * @param listaReserva
     * @param reserva
     * @param idQuarto
     * @return
     */
    //Método responsável por realizar o cancelamento de Reserva
    public static List cancelarReserva(List<Reserva> listaReserva, Reserva reserva,String idQuarto) {
        //Loop que verifica a lista de reserva
        for (Reserva item : listaReserva) {
            if (item.equals(reserva) && item.getQuarto().getId().equals(idQuarto)) {
                //Para reposicionar itens, é preciso que o indice seja inteiro
                System.out.println("Reserva cancelada.\nValor da multa: R$" + Sistema.calcularMulta(item.getDataInicio(), item.getQuarto().getPreco()));
                listaReserva.remove(item);
                return listaReserva;
            }
        }
        //Caso a reserva não seja encontra na base de dados.
        System.out.println("Reserva não encontrada.");
        return listaReserva;
    }

    //metodo responsalvel por calular o valor da multa ao cancelar uma reserva
    //entre como paramentro a data para poder comparar com a atual e também o valor de uma diraria 
    public static double calcularMulta(LocalDate data, double diaria) {

        //pega a data atual do sistema
        LocalDate dataAtual = LocalDate.now();
        //Calcula a diferença entre as datas 
        long diferenca = ChronoUnit.DAYS.between(dataAtual, data);
        double multa = 0;
        //se a diferença for mais do que uma semana 
        if (diferenca >= 7) {
            //Retorna o valor de medade de uma diaria pra multa
            return multa = diaria * 0.5;
        } else {
            //Caso contrario retorna o preço de uma diaria completa 
            return multa = diaria;
        }

    }

    /**
     * Método que será utilizada para fornecer informações do extrato após a
     * realização da reserva
     *
     * @param reserva
     */
    //Após a reserva acontecer, esse método vai gerar um extrato.
    //Método está errado ou incompleto
//    public static void gerarExtrato(Reserva reserva) {
//        //Nome do cliente, preco do quarto * quantidade de dias da reserva.
//        //Uma data final e uma data inicial.
//        System.out.println("Reserva realizada com sucesso. ");
//        System.out.println(reserva.toString());
//    }
    /**
     * Esse método vai buscar informações na base de dados de alguma reserva
     * realizada e apresentada ao usuário
     *
     * @param reserva
     * @param cliente
     * @return
     */
    //Método responsável por ler dados da(s) reserva(s) de determinado cliente 
    public static List<Reserva> lerReserva(List<Reserva> reserva, Cliente cliente) {
        //Eu preciso realizar a reserva primeiro para depois imprimir
        //Conferindo na agenda o cliente desejado e apresentando informaçoes da agenda
        if (reserva.isEmpty()) {
            System.out.println("Nenhuma reserva.");
            return reserva;
        } else {
            //Um for para percorrer a agenda em busca do cpf do cliente com informações
            //Posso está errado, mas dessa forma eu vejo que vai ser impresso todas as reserva do cliente
            for (Reserva reservas : reserva) {
                if (reservas.getCliente().equals(cliente)) {
                    System.out.print(reservas);
                    System.out.println("Dados da reserva do cliente.");
                    return reserva;
                }
            }
            //De toda forma não encontrar, mostrar que o cliente não tem reserva naquele dia
            System.out.println("Cliente sem reserva.");
            return reserva;
        }
    }

    /**
     * Esse método salva informações da reserva na base de dados(arquivo JSON)
     *
     * @param dados
     * @param nomeArquivo
     */
    //FUNÇÃO QUE SALVA OS DADOS DE UMA LISTA EM ARQUIVO JSON
    public static void salvarDados(List<?> dados, String nomeArquivo) {
        // Criar um ObjectMapper do Jackson
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        try {
            // Serializar a lista de objetos em um arquivo JSON
            objectMapper.writeValue(new File(nomeArquivo), dados);
            //objectMapper.writeValue(new File("C:\\Users\\rafar\\OneDrive\\Documentos\\GitHub\\PousadaMilhoVerde\\" + nomeArquivo), dados);
            System.out.println("Arquivo JSON criado com sucesso.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Método que vai carregar dados dos clientes da base de dados(arquivo JSON)
     *
     * @param <T>
     * @param nomeArquivo
     * @param tipoClasse
     * @return
     */

    public static <T> List<T> carregarDados(String nomeArquivo, Class<T> tipoClasse) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Ler o arquivo JSON e converter para uma lista de objetos da classe
            //E retorna a lista com os dados do arquivo
            return objectMapper.readValue(new File(nomeArquivo), objectMapper.getTypeFactory().constructCollectionType(List.class, tipoClasse));
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Caso não consiga ler, retorna null
        return null;
    }

    /**
     * Esse métoddo vai servir como um contador para saber quantas vezes as
     * classe Reserva e a classe Cliente foram instanciadas em nosso código.
     */
    //Metodo responsavel por retornar o numero de Instancias das classes Cliente e reserva
    public static void numInstancias() {
        int numClienteProtec = Cliente.totalClienteProtec;
        int numClientePrivate = Cliente.gettotalClientePrivate();
        int numReserva = Reserva.getTotalReservas();
        System.out.print("Numeros de instancias da classe pessoa " + numClientePrivate + " ,e da classe reserva sao " + numReserva + "\n");
    }

    //da pra melhorar esse código com um parametro de periodo para retornar o valor apenas daquele mês por exemplo
    public static double calcularFaturamento() {
        //essa função ainda não esta funcionado pq não é possivel carregar os dados do json
        double faturamento = 0, receita = 0, despesa = 0;
        List<Reserva> listaReserva = Sistema.carregarDados("Reserva.json", Reserva.class);
        List<Funcionario> listaFuncionario = Sistema.carregarDados("Funcionario.json", Funcionario.class);
        for (Reserva aux : listaReserva) {
            //receita recebe o valor dos quartos na reserva
            receita += aux.getValor();
        }

        for (Funcionario aux : listaFuncionario) {
            //despesa recebe o gasto com os salarios do funcionarios
            despesa += aux.getSalario();
        }
// A IDEIA E BUSCAR AS RESERVAS DAQUELE MÊS QUE SERIA A RECEITA E O CUSTO COM OS FUNCIONARIOS SERIA A DESPESA, AI FAXER R-D PRA ACHAR O FATURAMENTO

        return faturamento = receita - despesa;
    }

    public static <T> List<T> find(List<T> lista, T usuario) {

        ReservaComparator reserva = new ReservaComparator();
        Iterator<T> iterator = lista.iterator();

        while (iterator.hasNext()) {
            usuario = iterator.next();
            System.out.println(usuario);
        }
        return null;
    }

    public static boolean verificarPeriodo(Reserva reserva1, Reserva reserva2) {
        List<LocalDate> periodo1 = gerarPeriodo(reserva1.getDataInicio(), reserva1.getDataFim());
        List<LocalDate> periodo2 = gerarPeriodo(reserva2.getDataInicio(), reserva2.getDataFim());
        for (LocalDate data : periodo1) {
            if (periodo2.contains(data)) {
                return true; // Encontrou uma data coincidente
            }
        }
        return false; // Não encontrou datas coincidentes
    }

    public static List<LocalDate> gerarPeriodo(LocalDate dataInicio, LocalDate dataFim) {
        List<LocalDate> periodo = new ArrayList<>();
        LocalDate dataAtual = dataInicio;

        while (!dataAtual.isAfter(dataFim)) {
            periodo.add(dataAtual);
            dataAtual = dataAtual.plusDays(1);
        }

        return periodo;
    }
}
