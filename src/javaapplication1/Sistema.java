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
                Sistema.executar(Colaboradores.get(i));
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
//    Tem esse exemplo que o Chatgpt forneceu e eu achei interessante também
    public static <T> List<T> incluir(List<T> lista, T usuario) {
    if (lista.contains(usuario)) {
        System.out.println("Usuário já existente.");
    } else {
        lista.add(usuario);
        System.out.println("Usuário adicionado.");
    }
    return lista;
}
    
    //Método responsável por editar Cliente,Funcionario ou Administrado na BD
    public static <T> List<T> editar(List<T> lista, T usuario, Comparator<T> comparator) {
        //Recebendo lista de clientes
        if (lista.isEmpty()) {
            System.out.println("Usuario inexistente.");
            return lista;
        } else {
            for (T item : lista) {
                if (comparator.compare(item, usuario) == 0) {
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
   
/**
 * Esse método inseri funcionários na base de dados
 * @param Colaboradores
 * @param func
 * @return 
 */
    //Método responsável por verificar reserva e entregar quais quartos estão disponiveis
    public static boolean verificarReserva(List<Reserva> listaReserva, LocalDate data, String idQuarto) {
        //Fazer verificacao da data e quarto na reserva.Para verificar a data é preciso da classe reserva
        if (listaReserva.isEmpty()) {
            System.out.println("\nExiste disponibilidade em todos os quartos.");
            //Como a lista está vazia todos os quartos estao livres
            return true;
        } else {
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
        }
        return true;
    }
    /**
     * Método que inclui alguma reserva realizada na base de dados, para que seja realizada
     * corretamente, é preciso que seja feita alguma verificação de disponibilidade.
     * @param listaReserva
     * @param quarto
     * @param cliente
     * @return 
     */
    //Método responsável por receber data e comparar disponibilidade
    public static List realizarReserva(List<Reserva> listaReserva, Quarto quarto, Cliente cliente) {
        // Aqui vai armazenar a reserva na lista de reserva e depois preencher os atributos da classe reserva

        Scanner sc = new Scanner(System.in);
        Reserva reserva = new Reserva();

        //System.out.println("Informe o Id o quarto desejado Preço:Categoria: ");
        //Preenchendo os campos da reserva e do quarto
        quarto.setId(sc.nextLine());
        quarto.setOcupation(true);
        reserva.setCliente(cliente);
        reserva.setQuarto(quartos);
        reserva.setData(cliente.getDataDesejada());
        //Agora acrescentamos tudo da lista de reserva
        listaReserva.add(reserva);
        return listaReserva;
    }

    /**
     * Método que será utilizada para fornecer informações do extrato após a realização
     * da reserva
     */
    //Após a reserva acontecer, esse método vai gerar um extrato.
    public void gerarExtrato() {
        Reserva reserva = new Reserva();
        //Nome do cliente, preco do quarto * quantidade de dias da reserva.
        //Uma data final e uma data inicial.
        System.out.print("Reserva realizada com sucesso. ");
        System.out.println("Nome: " + reserva.getCliente().getNome());
        System.out.println("Data: " + reserva.getData());
        System.out.println("Info Quarto: " + reserva.getQuarto().toString());

    }
    /**
     * Esse método vai buscar informações na base de dados de alguma reserva realizada
     * e apresentada ao usuário
     * @param reserva
     * @param cliente
     * @return 
     */
    //Método responsável por ler dados da reserva 
    public static List<Reserva> lerReserva(List<Reserva> reserva, Cliente cliente) {
        //Eu preciso realizar a reserva primeiro para depois imprimir
        //Conferindo na agenda o cliente desejado e apresentando informaçoes da agenda
        if (reserva.isEmpty()) {
            System.out.println("Nenhuma reserva.");
            return reserva;
        } else {
            //Um for para percorrer a agenda em busca do cpf do cliente com informações
            //Posso está errado, mas dessa forma eu vejo que vai ser impresso todas as reserva do cliente
            for (int i = 0; i < reserva.size(); i++) {
                if (reserva.get(i).equals(cliente.getCpf())) {
                    System.out.print(reserva.get(i));
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

    /**
     * Função que vai ser utilizada apenas caso o login do usuário esteja correto
     * @param usuarioAtual 
     */
    
    /**
     * Método que pode ser utilizado tanto pelo Funcionário quanto pelo Administrador,
     * e te por finalidade, realizar o crud do cliente na base de dados(arquivo JSON)
     */
    private static void crudCliente() {
        Scanner cin = new Scanner(System.in,"ISO-8859-1");
        //Lista de clientes para receber os dados do arquivo e poder mexer
        ArrayList<Cliente> listaClientes = new ArrayList<>();
        listaClientes = (ArrayList<Cliente>) Sistema.carregarDadosClientes("Clientes.json");
        System.out.println("Opção CRUD Cliente.\n Oque deseja fazer?");
        System.out.println("1)Adicionar Cliente\t 2)Remover Cliente \t 3)Editar Cliente");
        int opcao = cin.nextInt();
        switch (opcao) {
            case 1:
                System.out.println("Opção 1 selecionada.");
                Cliente cliente = Cliente.criarCliente();
                Sistema.incluir(listaClientes, cliente);
                break;
            case 2:
                System.out.println("Opção 2 selecionada.");
                System.out.println("Informa o CPF do cliente");
                String cpf = cin.next();
                Cliente cliente2 = new Cliente();
                cliente2.setCpf(cpf);
                listaClientes = (ArrayList<Cliente>) Sistema.remover(listaClientes, cliente2);
                break;
            case 3:
                System.out.println("Opção 3 selecionada.");
                System.out.println("Informe os novos dados do cliente(por favor preencha todos os campos corretamente)");
                Cliente cliente3 = Cliente.criarCliente();
                Sistema.editar(listaClientes, cliente3);
                break;
            default:
                    System.out.println("Opção inválida.");
                    // Ação para opções inválidas
                    break;
        }
        Sistema.salvarDados(listaClientes, "Clientes.json");
    }
    /**
     * Esse é um método exclusivo do Administrador e tem por finalidade gerenciar
     * funcionários, ou seja, adicionar, remover ou editar funcionário
     */
    private static void gerenciarFuncionarios() {
        Scanner cin = new Scanner(System.in,"ISO-8859-1");
        //Lista de clientes para receber os dados do arquivo e poder mexer
        ArrayList<Funcionario> listaFuncionarios= new ArrayList<>();
        listaFuncionarios = (ArrayList<Funcionario>) Sistema.carregarDadosFuncionarios("Funcionarios.json");
        System.out.println("Opção GERENCIAR FUNCIONARIO .\n Oque deseja fazer?");
        System.out.println("1)Adicionar funcionario\t 2)Remover funcionario \t 3)Editar funcionario");
        int opcao = cin.nextInt();
        switch (opcao) {
            case 1:
                System.out.println("Opção 1 selecionada.");
                Funcionario func = Funcionario.criarFuncionario();
                Sistema.incluir(listaFuncionarios, func);
                break;
            case 2:
                System.out.println("Opção 2 selecionada.");
                System.out.println("Informa o CPF do Funcionario");
                String cpf = cin.next();
                Funcionario func2 = new Funcionario();
                func2.setCpf(cpf);
                listaFuncionarios = (ArrayList<Funcionario>) Sistema.remover(listaFuncionarios, func2);
                break;
            case 3:
                System.out.println("Opção 3 selecionada.");
                System.out.println("Informe os novos dados do Funcionario(por favor preencha todos os campos corretamente)");
                Funcionario func3 = Funcionario.criarFuncionario();
                Sistema.editar(listaFuncionarios, func3);
                break;
            default:
                    System.out.println("Opção inválida.");
                    // Ação para opções inválidas
                    break;
        }
        Sistema.salvarDados(listaFuncionarios, "Funcionarios.json");
        
    }
}
