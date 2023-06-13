package javaapplication1;

import com.fasterxml.jackson.core.type.TypeReference;;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
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
        Colaboradores = Sistema.carregarDadosFuncionarios("Funcionarios.json");
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
     * Esse método inseri informações dos clientes na base de dados da pousada
     * @param listaCliente
     * @param cliente
     * @return 
     */
     //Método que inclui um cliente na base de dados
    public static List incluir(List<Cliente> listaCliente, Cliente cliente) {
        //Uma lista que vai ser inserido os clientes
        
        //Considerando que a lista esteja vazia,adicionamos um cliente
        if (listaCliente.isEmpty()) {
            listaCliente.add(cliente);
            System.out.println("Cliente Adicionado.");
            return listaCliente;
        } else {
            //Verificando se o cliente já existe na bd
            for (int i = 0; i < listaCliente.size(); i++) {
                if (listaCliente.get(i).getCpf().equals(cliente.getCpf())) {
                    //Considerando que já tenha o cliente na base de dados.
                    System.out.println("Cliente já existente.");
                    return listaCliente;
                }
            }
            //Caso a lista não esteja vazia e não exista aquele cliente, insira na base de dados
            listaCliente.add(cliente);
            System.out.println("Cliente Adicionado.");
            return listaCliente;
        }
    }
    /**
     * Esse método editar as informações contida dos clientes na base de dados
     * @param listaCliente
     * @param cliente
     * @return 
     */
    //Método responsável por editar Cliente,Funcionario ou Administrado na BD
    public static List editar(List<Cliente> listaCliente, Cliente cliente) {
        //Recebendo lista de clientes
        //Essa linhja está dando erro, porque está inserindo duas vezes, mas está funcionando

        if (listaCliente.isEmpty()) {
            System.out.println("Cliente inexistente.");
            return listaCliente;
        } else {
            for (int i = 0; i < listaCliente.size(); i++) {
                if (listaCliente.get(i).getCpf().equals(cliente.getCpf())) {
                    //Considerando que já tenha o cliente na base de dados.
                    //Preciso verificar o método replace, pode ser mais adequado
                    listaCliente.set(i, cliente);
                    System.out.println("Cliente editado.");
                    return listaCliente;
                }
            }
            System.out.println("Cliente não encontrado.");
            return listaCliente;
        }

    }
/**
 * Esse método remove o cliente da base de dados de acordo o identificador fornecido
 * @param listaCliente
 * @param cliente
 * @return 
 */
    //Método responsável por editar Cliente,Funcionario ou Administrado na BD
    public static List remover(List<Cliente> listaCliente, Cliente cliente) {

        //Eu poderia criar um método listaCliente e atribuir no lugar de incluir
        if (listaCliente.isEmpty()) {
            System.out.println("Cliente inexistente.");
            return listaCliente;
        } else {
            //Verificando se o cliente já existe na bd
            for (int i = 0; i < listaCliente.size(); i++) {
                if (listaCliente.get(i).getCpf().equals(cliente.getCpf())) {
                    //Considerando que já tenha o cliente na base de dados.
                    listaCliente.remove(i);
                    System.out.println("Cliente removido.");
                    return listaCliente;
                }
            }
            System.out.println("Cliente inexistente.");
            return listaCliente;
        }
    }
    /**
     * Esse método inseri funcionários na base de dados
     * @param Colaboradores
     * @param func
     * @return 
     */
    //Métodos responsável por inserir funcionários na base de dados
    public static List incluir(List<Funcionario> Colaboradores, Funcionario func) {
        //A classe vai ser instanciada no main e inserida como parametro.
        //Considerando que a lista esteja vazia,adicionamos um cliente
        if (Colaboradores.isEmpty()) {
            Colaboradores.add(func);
            System.out.println("Funcionário Adicionado.");
            return Colaboradores;
        } else {
            //Verificando se o cliente já existe na bd
            for (int i = 0; i < Colaboradores.size(); i++) {
                if (Colaboradores.get(i).getCpf().equals(func.getCpf())) {
                    //Considerando que já tenha o cliente na base de dados.
                    System.out.println("Funcionário já existente.");
                    return Colaboradores;
                }
            }
            //Caso a lista não esteja vazia e não exista aquele cliente, insira na base de dados
            Colaboradores.add(func);
            System.out.println("Funcionário Adicionado.");
            return Colaboradores;
        }
    }
    //Método que vai editar dado de algum funcionáro na base de dados
    //Método responsável por editar Cliente,Funcionario ou Administrado na BD
    public static List editar(List<Funcionario> Colaboradores, Funcionario func) {
        //Recebendo lista de funcionarios e editando
        //Essa linhja está dando erro, porque está inserindo duas vezes, mas está funcionando

        if (Colaboradores.isEmpty()) {
            System.out.println("Funcionário inexistente.");
            return Colaboradores;
        } else {
            for (int i = 0; i < Colaboradores.size(); i++) {
                if (Colaboradores.get(i).getCpf().equals(func.getCpf())) {
                    //Considerando que já tenha o cliente na base de dados.
                    //Preciso verificar o método replace, pode ser mais adequado
                    Colaboradores.set(i, func);
                    System.out.println("Funcionário editado.");
                    return Colaboradores;
                }
            }
        }
        return Colaboradores;
    }
    
    /**
     * Esse método remove algum funcionário na base de dados de acordo o identificador
     * fornecido
     * @param Colaboradores
     * @param func
     * @return 
     */
    //Método responsável por editar Cliente,Funcionario ou Administrado na BD
    public static List remover(List<Funcionario> Colaboradores, Funcionario func) {

        //Eu poderia criar um método listaCliente e atribuir no lugar de incluir
        if (Colaboradores.isEmpty()) {
            System.out.println("Funcionário inexistente.");
            return Colaboradores;
        } else {
            //Verificando se o cliente já existe na bd
            for (int i = 0; i < Colaboradores.size(); i++) {
                if (Colaboradores.get(i).getCpf().equals(func.getCpf())) {
                    //Considerando que já tenha o cliente na base de dados.
                    Colaboradores.remove(i);
                    System.out.println("Funcionário removido.");
                    return Colaboradores;
                }
            }
        }
        return Colaboradores;
    }
    /**
     * Método que vai realizar a verificação da reserva na base de dados, ela antecede
     * a realização de alguma reserva que vai ser realizada
     * @param listaReserva
     * @param data
     * @param idQuarto
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
    public static List<Cliente> carregarDadosClientes(String nomeArquivo) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Ler o arquivo JSON e converter para uma lista de objetos da classe Cliente
            //List<Cliente> listaClientes = objectMapper.readValue(new File("C:\\Users\\rafar\\OneDrive\\Documentos\\GitHub\\PousadaMilhoVerde\\" + nomeArquivo),
            List<Cliente> listaClientes = objectMapper.readValue(new File("C:\\Users\\Getúlio\\OneDrive\\Documentos\\GitHub\\PousadaMilhoVerde\\" + nomeArquivo),
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
     * Método que vai ser a base de dados(arquivo JSON) e retorna uma lista de funcionários
     * que estão presentes na base de dados
     * @param nomeArquivo
     * @return 
     */
    //FUNÇÃO RESPONSAVEL POR LER O ARQUIVO JSON E RETORNA UMA LISTA COM OS VALORES CONTIDOS NELE
    public static List<Funcionario> carregarDadosFuncionarios(String nomeArquivo) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Ler o arquivo JSON e converter para uma lista de objetos da classe Cliente
           // List<Funcionario> listaFuncionario = objectMapper.readValue(new File("C:\\Users\\rafar\\OneDrive\\Documentos\\GitHub\\PousadaMilhoVerde\\" + nomeArquivo),
           List<Funcionario> listaFuncionario = objectMapper.readValue(new File("C:\\Users\\Getúlio\\OneDrive\\Documentos\\GitHub\\PousadaMilhoVerde\\" + nomeArquivo),
           new TypeReference<List<Funcionario>>() {
            });

            // Retorna a lista com os dados do arquivo
            return listaFuncionario;
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Caso não consiga ler, retorna null
        return null;
    }
    /**
     * Esse método vai ler a base de dados(arquivo JSON) e retorna uma lista com os 
     * dados da reserva contidos nele
     * @param nomeArquivo
     * @return 
     */
    //FUNÇÃO RESPONSAVEL POR LER O ARQUIVO JSON E RETORNA UMA LISTA COM OS VALORES CONTIDOS NELE
    public static List<Reserva> carregarDadosReserva(String nomeArquivo) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Ler o arquivo JSON e converter para uma lista de objetos da classe Cliente
            //List<Reserva> listaReserva = objectMapper.readValue(new File("C:\\Users\\rafar\\OneDrive\\Documentos\\GitHub\\PousadaMilhoVerde\\" + nomeArquivo),
            List<Reserva> listaReserva = objectMapper.readValue(new File("C:\\Users\\Getúlio\\OneDrive\\Documentos\\GitHub\\PousadaMilhoVerde\\" + nomeArquivo),
                    new TypeReference<List<Reserva>>() {
            });

            // Retorna a lista com os dados do arquivo
            return listaReserva;
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
    //uma função privada para ser chamada apenas se o login for certo;
    public static void executar(Object usuarioAtual) {
        Scanner cin = new Scanner(System.in,"ISO-8859-1");
        int opcao;
        System.out.println("Seja bem vindo ao sistema da pousada Milho Verde.\n Oque deseja fazer?");
        do {
            System.out.println("1)CRUD Cliente\t 2)Gerenciar Funcionarios\t 3)Agenda\t 4)Reserva \t 5)Despesas \t -1 para sair");
            opcao = cin.nextInt();
            switch (opcao) {
                case 1:
                    System.out.println("Opção 1 selecionada.");
                    Sistema.crudCliente();
                    break;
                case 2:
                    System.out.println("Opção 2 selecionada.");
                   // if(usuarioAtual instanceof Administrador){
                         Sistema.gerenciarFuncionarios();
                   // }else{ System.out.println("voce não tem acesso para essa opção");}
                    break;
                case 3:
                    System.out.println("Opção 3 selecionada.");
                    // Ação para a opção 3
                    break;
                case 4:
                    System.out.println("Opção 4 selecionada.");
                    // Ação para a opção 3
                    break;
                case 5:
                    System.out.println("Opção 5 selecionada.");
                    System.out.println("Ainda nao fiz nada aqui :(");
                    break;
                case -1:
                    System.out.println("Opção de sair selecionada.");
                    break;
                default:
                    System.out.println("Opção inválida.");
                    // Ação para opções inválidas
                    break;

            }
            System.out.println("-------------Oque deseja fazer agora?-----------------------");
        } while (opcao != -1);
    }

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
