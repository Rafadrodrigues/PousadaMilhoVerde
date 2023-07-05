package javaapplication1;

import com.fasterxml.jackson.core.type.TypeReference;;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Clase Sistema, classe responsável por gerenciar as informações entre o Banco de
 * dados e a Interface que é acessada pelo funcionário.Nela está contida as principais
 * funcionalidades do sistema da Pousada Milho Verde.
 * @author rafar
 */
public class Sistema {
    //QUESTAO 05
    //Inicializando os 10 quaros da memória
    private static Quarto[] quartos = new Quarto[]{
        new Quarto("001", 50, "Comun", false),
        new Quarto("002", 50, "Comun", false),
        new Quarto("003", 50, "Comun", false),
        new Quarto("004", 50, "Comun", false),
        new Quarto("005", 50, "Comun", false),
        new Quarto("006", 100.60, "Luxo", false),
        new Quarto("007", 100.60, "Luxo", false),
        new Quarto("008", 100.60, "Luxo", false),
        new Quarto("009", 100.60, "Luxo", false),
        new Quarto("010", 100.60, "Luxo", false),};

    //Get e Set para manipular o atributo
    public static Quarto[] getQuartos() {
        return quartos;
    }

    public static void setQuartos(Quarto[] quartos) {
        Sistema.quartos = quartos;
    }

    //Lê a lista de funcionarios do Json para pegar as senhas
    private static List listaFuncionario() {
        List<Funcionario> Colaboradores = new ArrayList<>();
        Colaboradores = Sistema.carregarDados("Funcionarios.json");
        return Colaboradores;
    }
    /**
     * Este método realiza o login do usuário no Sistema, ele valida e libera o acesso
     * @param user
     * @param pin 
     */
    public static boolean FazerLogin(String user, String pin) {
        //Lista de funcionarios;
        List<Funcionario> Colaboradores = listaFuncionario();
        //o for percorre a lista dos funcionarios
        for (int i = 0; i < Colaboradores.size(); i++) {
            if (user.equals(Colaboradores.get(i).getUsuario()) && pin.equals(Colaboradores.get(i).getSenha())) {
                //se a senha e usuario bater com algum o login é feito
                System.out.print("Sistema Liberado\n");
//                Sistema.executar(Colaboradores.get(i));
                return true;
            }
            else{
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
 * Esse método inseri funcionários na base de dados
     * @param listaReserva
     * @param data
     * @param idQuarto
    * @param Colaboradores
    * @return 
 */
    //Método responsável por verificar reserva e entregar quais quartos estão disponiveis
    public static boolean verificarReserva(List<Reserva> listaReserva, LocalDate data, String idQuarto) {
        //Fazer verificacao da data e quarto na reserva.Para verificar a data é preciso da classe reserva
        if (listaReserva.isEmpty()) {
            System.out.println("\nExiste disponibilidade em todos os quartos.");
            //Como a lista está vazia todos os quartos estao livres
            return true;
        }
        //ALTERAR SÓ PARA TOSTRING(TALVEZ)
        //Loop que percorre a lista 
        for (Reserva reserva : listaReserva) {
            //Verificando na lista de reserva se o quarto está disponível naquela data. As duas condicoes devem ser satisfeitas
            if (reserva.getData().equals(reserva.getData()) && reserva.equals(reserva.getQuarto())) {
                System.out.println("O quarto " + reserva.getQuarto() + " não esta disponível na data " + reserva.getData());
                return false;
            } else {
                System.out.println("O quarto tem disponibilidade nessa data ");
                return true;
            }
        }
        return true;
    }
    /**
     * Método que inclui alguma reserva realizada na base de dados, para que seja realizada
     * corretamente, é preciso que seja feita alguma verificação de disponibilidade.
     * @param listaReserva
     * @param cliente
     * @return 
     */
    
    //Método responsável por receber data e comparar disponibilidade
    public static List realizarReserva(List<Reserva> listaReserva, Cliente cliente) {
        // Aqui vai armazenar a reserva na lista de reserva e depois preencher os atributos da classe reserva

        Scanner sc = new Scanner(System.in);
        
        Reserva reserva = new Reserva();
        Quarto quarto = new Quarto();
        
        //Preenchendo os campos da reserva e do quarto
        quarto.setId(sc.nextLine());
        quarto.setOcupation(true);
        reserva.setCliente(cliente);
        String idSelecionado = sc.nextLine(); // ID a ser procurado
        //Essa estrutura é para identificar qual quarto que foi selecionado
        for(int i=0;i<quartos.length;i++) {
            if (quarto.getId().equals(idSelecionado)) {
                reserva.setQuarto(quartos[i]);
                // Saia do loop após encontrar o quarto desejado
                break; 
            }
        }
        reserva.setData(cliente.getDataDesejada());
        //Agora acrescentamos tudo da lista de reserva
        listaReserva.add(reserva);
        return listaReserva;
    }

    //Método responsável por realizar o cancelamento de Reserva
    public static List<Reserva> cancelarReserva(List<Reserva> listaReserva, Reserva reserva){  
       //Verificar se esta correto
        for (Reserva item : listaReserva) {
            if (item.getQuarto().equals(reserva.getQuarto())&&(item.getCliente().equals(reserva.getCliente()))) {
                //Considerando que já tenha um quarto na base de dados.
                //Para reposicionar itens, é preciso que o indice seja inteiro
                listaReserva.remove(item);
                System.out.println("Reserva cancelada.");
                return listaReserva;
            }
        }
        System.out.println("Reserva não encontrada.");
        return listaReserva;
    }

    /**
     * Método que será utilizada para fornecer informações do extrato após a realização
     * da reserva
     * @param reserva
     */
    //Após a reserva acontecer, esse método vai gerar um extrato.
    //Método está errado ou incompleto
    public static void gerarExtrato(Reserva reserva) {
        //Nome do cliente, preco do quarto * quantidade de dias da reserva.
        //Uma data final e uma data inicial.
        System.out.println("Reserva realizada com sucesso. ");
        System.out.println(reserva.toString());
    }
    
    /**
     * Esse método vai buscar informações na base de dados de alguma reserva realizada
     * e apresentada ao usuário
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
            objectMapper.writeValue(new File("C:\\Users\\rafar\\OneDrive\\Documentos\\GitHub\\PousadaMilhoVerde\\" + nomeArquivo), dados);
            System.out.println("Arquivo JSON criado com sucesso.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Método que vai carregar dados dos clientes da base de dados(arquivo JSON)
     * @param nomeArquivo
     * @return 
     */
    //FUNÇÃO RESPONSAVEL POR LER O ARQUIVO JSON E RETORNA UMA LISTA COM OS VALORES CONTIDOS NELE
    // OS DADOS QUE VAO SER COLETADOS SERÃO OS DO FUNCIONARIO, CLIENTE E RESERVA
    public static <T> List<T> carregarDados(String nomeArquivo) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Ler o arquivo JSON e converter para uma lista de objetos da classe Cliente
            //List<Cliente> listaClientes = objectMapper.readValue(new File("C:\\Users\\rafar\\OneDrive\\Documentos\\GitHub\\PousadaMilhoVerde\\" + nomeArquivo),
            List<T> listaClientes = (List<T>) objectMapper.readValue(new File("C:\\Users\\Getúlio\\OneDrive\\Documentos\\GitHub\\PousadaMilhoVerde\\" + nomeArquivo),
                    new TypeReference<List<Cliente>>() {
            });

            // Retorna a lista com os dados do arquivo
            return listaClientes;
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Caso não consiga ler, retorna null
        return null;
    }
    /**
     * Esse métoddo vai servir como um contador para saber quantas vezes as classe 
     * Reserva e a classe Cliente foram instanciadas em nosso código.
     */
    //Metodo responsavel por retornar o numero de Instancias das classes Cliente e reserva
    public static void numInstancias() {
        int numClienteProtec = Cliente.totalClienteProtec;
        int numClientePrivate = Cliente.gettotalClientePrivate();
        int numReserva = Reserva.getTotalReservas();
        System.out.print("Numeros de instancias da classe pessoa " + numClientePrivate + " ,e da classe reserva sao " + numReserva + "\n");
    }
}
