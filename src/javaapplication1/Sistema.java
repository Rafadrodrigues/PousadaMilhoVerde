package javaapplication1;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;

/**
 * Clase Sistema, classe responsável por gerenciar as informações entre o Banco
 * de dados e a Interface que é acessada pelo funcionário.Nela está contida as
 * principais funcionalidades do sistema da Pousada Milho Verde.
 *
 * @author rafar
 */
public class Sistema {

    private Funcionario funcionarioAtual;
    private List<Cliente> listaCliente;
    private List<Funcionario> listaFuncionario;
    private List<Reserva> listaReserva;

    /**
     * Construtor padrão da classe Sistema
     */
    public Sistema() {
        this.listaCliente = carregarDados("Clientes.json", Cliente.class);
        this.listaFuncionario = carregarDados("Funcionarios.json", Funcionario.class);
        this.listaReserva = carregarDados("Reserva.json", Reserva.class);
    }

    public Funcionario getFuncionarioAtual() {
        return funcionarioAtual;
    }

    public void setFuncionarioAtual(Funcionario funcionarioAtual) {
        this.funcionarioAtual = funcionarioAtual;
    }

    public List<Cliente> getListaCliente() {
        return listaCliente;
    }

    public void setListaCliente(List<Cliente> listaCliente) {
        this.listaCliente = listaCliente;
    }

    public List<Funcionario> getListaFuncionario() {
        return listaFuncionario;
    }

    public void setListaFuncionario(List<Funcionario> listaFuncionario) {
        this.listaFuncionario = listaFuncionario;
    }

    public List<Reserva> getListaReserva() {
        return listaReserva;
    }

    public void setListaReserva(List<Reserva> listaReserva) {
        this.listaReserva = listaReserva;
    }

    //QUESTAO 2-5
    /**
     * Inicializando os 10 quaros da memória que podem ser carregados pelas
     * outras classes
     */
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

    //Get e Set para manipular e recuperar o valor do quarto
    public static Quarto[] getQuartos() {
        return quartos;
    }

    public static void setQuartos(Quarto[] quartos) {
        Sistema.quartos = quartos;
    }

    public static Quarto encontrarQuarto(String idQuarto) {
        for (Quarto quarto : quartos) {
            if (quarto.getId().equals(idQuarto)) {
                return quarto; // Retorna o quarto encontrado
            }
        }
        return null; // Caso não encontre o quarto com o ID correspondente
    }
    
    /**
     * Construtor padrão da classe Sistema
     */
    private <T extends Pessoa> boolean verificar(List<T> lista, String cpf) {
        for (T pessoa : lista) {
            if (pessoa.getCpf().equals(cpf)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Método que criar o clientes 
     * @param nome - Nome do cliente
     * @param cpf - cpf do cliente
     * @param endereco - endereco do cliente
     * @param telefone - telefone do cliente
     * @param email - email do cliente
     * @param cartaoCredito - cartao de credito do cliente
     */
    public void criarCliente(String nome, String cpf, String endereco, String telefone, String email, String cartaoCredito) {
        Cliente cliente = new Cliente(nome, cpf, endereco, telefone, email, cartaoCredito);
        if (verificar(this.listaCliente, cpf)) {
            this.listaCliente.add(cliente);
            System.out.print("\nCliente: " + cliente.toString() + "\n foi adicionado com suscesso");
            salvar(cliente, "Clientes.json", Cliente.class);
        } else {
            System.out.print("\nCliente: " + cliente.toString() + "\n ja existe");
        }
    }

    /**
     * Método que criar funcionario
     * @param usuario - usuario do Funcionario
     * @param senha - Senha do Funcionario
     * @param nome - Nome do Funcionario
     * @param cpf - cpf do Funcionario
     * @param endereco - endereco do Funcionario
     * @param telefone - telefone do Funcionario
     * @param email - email do Funcionario
     * @param salario  - Salario do Funcionario
     */
    public void criarFuncionario(String usuario, String senha,
            String nome, String cpf, String endereco, String telefone, String email, float salario) {
        if (this.getFuncionarioAtual().getCargo().equals("ADMINISTRADOR")) {
            Funcionario funcionario = new Funcionario(usuario, senha, nome, cpf, endereco, telefone, email, salario);
            if (verificar(this.listaFuncionario, cpf)) {
                this.listaFuncionario.add(funcionario);
                System.out.print("\nFuncionario: " + funcionario.toString() + "\n foi adicionado com suscesso");
                salvar(funcionario, "Funcionarios.json", Funcionario.class);
            } else {
                System.out.print("\nFuncionario: " + funcionario.toString() + "\n ja existe");
            }
        } else {
            System.out.print("\nvoce não tem acesso");
        }
    }

    /**
     * Método que criar Administrador
     * @param usuario - usuario do Administrador
     * @param senha - Senha do Administrador
     * @param nome - Nome do Administrador
     * @param cpf - cpf do Administrador
     * @param endereco - endereco do Administrador
     * @param telefone - telefone do Administrador
     * @param email - email do Administrador
     * @param salario  - Salario do Administrador
     */
    public void criarAdministrador(String usuario, String senha,
            String nome, String cpf, String endereco, String telefone, String email, float salario) {
        if (this.getFuncionarioAtual().getCargo().equals("ADMINISTRADOR")) {
            Administrador funcionario = new Administrador(usuario, senha, nome, cpf, endereco, telefone, email, salario);
            if (verificar(this.listaFuncionario, cpf)) {
                System.out.print("\nFuncionario: " + funcionario.toString() + "\n foi adicionado com suscesso");
                this.listaFuncionario.add(funcionario);
                salvar(funcionario, "Funcionarios.json", Funcionario.class);
            } else {
                System.out.print("\nFuncionario: " + funcionario.toString() + "\n ja existe");
            }
        } else {
            System.out.print("\nvoce não tem acesso");
        }

    }

    /** 
     * Método que cria a reserva
     * @param cpf passa o CPF do cliente que já esta no arquivo Json
     * @param dataInicio a data do chekin
     * @param dataFim a data do chekout
     * @param idQuarto e o quarto desejado
     */
    public void criarReserva(String cpf, String dataInicio, String dataFim, String idQuarto) {
        if (Sistema.verificarReserva(this.listaReserva, dataInicio, dataFim, idQuarto)) {
            for (Cliente aux : this.listaCliente) {
                if (aux.getCpf().equals(cpf)) {
                    Reserva reserva = new Reserva(aux, dataInicio, dataFim, encontrarQuarto(idQuarto));
                    System.out.print("\nReserva: " + reserva.toString() + "\n foi adicionado com suscesso");
                    this.listaReserva.add(reserva);
                    salvar(reserva, "Reserva.json", Reserva.class);
                }
            }
        } else {
            System.out.print("\nReserva ja existe");
        }
    }

    /**
     * Método que confirma a reserva
     * @param chekin
     * @param chekaut
     * @param idQuarto
     */
    public void confirmarReserva(String chekin, String chekaut, String idQuarto) {
        Iterator<Reserva> iterator = this.listaReserva.iterator();

        while (iterator.hasNext()) {
            Reserva aux = iterator.next();
            if (aux.getDataInicio().equals(chekin)
                    && aux.getDataFim().equals(chekaut)
                    && aux.getQuarto().getId().equals(idQuarto)) {
                aux.confirma();
                salvarDados(this.listaReserva, "Reserva.json");
            }
        }
    }

    /**
     * Método que cancela a reserva
     * @param chekin
     * @param chekaut
     * @param idQuarto
     */
    public void cancelarReserva(String chekin, String chekaut, String idQuarto) {
        Iterator<Reserva> iterator = this.listaReserva.iterator();

        while (iterator.hasNext()) {
            Reserva aux = iterator.next();
            if (aux.getDataInicio().equals(chekin)
                    && aux.getDataFim().equals(chekaut)
                    && aux.getQuarto().getId().equals(idQuarto)) {
                aux.cancelar();
                iterator.remove();
                salvarDados(this.listaReserva, "Reserva.json");
            }
        }

    }

    /**
     * Método que edita Funcionario
     * @param Func - Objeto Funcionario
     */
    public void editarFuncionario(Funcionario Func) {
        if (this.getFuncionarioAtual().getCargo().equals("ADMINISTRADOR")) {
            this.listaFuncionario = editar(this.listaFuncionario, Func);
            salvarDados(this.listaFuncionario, "Funcionarios.json");

        } else {
            System.out.print("\nvoce não tem acesso");
        }
    }
    /**
     * Método que remove Funcionario
     * @param func - Objeto Funcionario
     */
    public void removerFuncionario(Funcionario func) {
        if (this.getFuncionarioAtual().getCargo().equals("ADMINISTRADOR")) {
            // Remove o funcionário da lista de funcionários com base na igualdade de CPF
            this.listaFuncionario.removeIf(f -> f.getCpf().equals(func.getCpf()));
            salvarDados(this.listaFuncionario, "Funcionarios.json");
        } else {
            System.out.print("\nVocê não tem acesso para remover funcionários.");
        }
    }
    /**
     * Método que edita apenas o cliente
     * @param cliente - Cliente passado como parametro
     */
    public void editarCliente(Cliente cliente) {
        if (this.getFuncionarioAtual().getCargo().equals("ADMINISTRADOR")) {
            this.listaCliente = editar(this.listaCliente, cliente);
            salvarDados(this.listaCliente, "Clientes.json");

        } else {
            System.out.print("\nvoce não tem acesso");
        }
    }

    public void removerCliente(Cliente cliente) {
        if (this.getFuncionarioAtual().getCargo().equals("ADMINISTRADOR")) {
            // Remove o funcionário da lista de funcionários com base na igualdade de CPF
            this.listaCliente.removeIf(f -> f.getCpf().equals(cliente.getCpf()));
            salvarDados(this.listaCliente, "Clientes.json");
        } else {
            System.out.print("\nVocê não tem acesso para remover funcionários.");
        }
    }

    /**
     * Este método realiza o login do usuário no Sistema, ele valida e libera o
     * acesso
     *
     * @param user é o usuario do sistema
     * @param pin a senha do usuario
     * @return
     */
    public void FazerLogin(String user, String pin) {
        //o for percorre a arvore dos funcionarios
        for (Funcionario aux : this.listaFuncionario) {
            if (user.equals(aux.getUsuario()) && pin.equals(aux.getSenha())) {
                //se a senha e usuario bater com algum o login é feito
                System.out.print("Sistema Liberado\n");
                this.funcionarioAtual = aux;
                break;
            }

        }
    }

    /**
     * Esse método editar as informações contida dos clientes na base de dados
     *
     * @param <T> - Tipo da lista e de usuario
     * @param lista - Lista passadd
     * @param usuario - Usuario que vai ser incluida
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
    //
    /**
     * Método responsável por editar Cliente,Funcionario ou Administrado na BD
     *
     * @param <T> - Tipo da lista e de usuario
     * @param lista - Lista passada
     * @param usuario - Usuario que vai ser editada
     * @return
     */
    public static <T> List<T> editar(List<T> lista, T usuario) {
        //Recebendo lista de clientes
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

    /**
     * Método que remove algum argumento da lista
     * @param <T> - Tipo da lista e de usuario
     * @param lista - Lista passadd
     * @param usuario - Usuario que vai ser removida
     * @return 
     */
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
     * @param listaReserva a base de dados para verificar a disponibilidade
     * @param dataInicio - Data de inicio 
     * @param dataFim - data de fim 
     * @param idQuarto - quarto selecionado 
     * @return
     */
    public static boolean verificarReserva(List<Reserva> listaReserva, String dataInicio, String dataFim, String idQuarto) {
        //Loop que percorre a lista 
        List<LocalDate> periodo = gerarPeriodo(dataInicio, dataFim);
        for (Reserva item : listaReserva) {
            List<LocalDate> periodoAux = gerarPeriodo(item.getDataInicio(), item.getDataFim());

            if (Sistema.verificarPeriodo(periodoAux, periodo) && idQuarto.equals(item.getQuarto().getId())) {
                System.out.println("\nNão possível realizar reserva, data "+dataInicio+" esta indisponível.");
                return false;
            }
        }
          System.out.println("\nData "+dataInicio+" esta disponivel.");
        return true;
    }

    /**
     * Esse método cria uma reserva na base de dados
     *
     * @param listaReserva - Lista que vai ser percorrida
     * @param cliente - Cliente que ser utilizado na reserva
     * @param dataInicio - data de inicio da reserva
     * @param dataFim - data final da reserva
     * @param idQuarto - quarto selecionado
     * @return
     */
    //Método responsável por realizar reserva 
    public static List criarReserva(List<Reserva> listaReserva, Cliente cliente, String idQuarto, String dataInicio, String dataFim) {

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
        if (!Sistema.verificarReserva(listaReserva, reserva.getDataInicio(), reserva.getDataFim(), reserva.getQuarto().getId())) {
            return listaReserva;
        }
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
     * @param listaReserva - Lista que vai ser percorrida
     * @param dataInicial - Data que começa 
     * @param idQuarto - Quarto selecionado
     * @return
     */
    //Método responsável por realizar o cancelamento de Reserva
    public static List cancelarReserva(List<Reserva> listaReserva, String dataInicial, String idQuarto) {
        //Loop que verifica a lista de reserva
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        for (Reserva item : listaReserva) {
            if (item.getDataInicio().equals(dataInicial) && item.getQuarto().getId().equals(idQuarto)) {
                //Para reposicionar itens, é preciso que o indice seja inteiro
                LocalDate data = LocalDate.parse(item.getDataInicio(), formato);
                System.out.println("Reserva cancelada" + item.Extrato() + ".\nValor da multa: R$" + Sistema.calcularMulta(data, item.getQuarto().getPreco()));
                listaReserva.remove(item);
                return listaReserva;
            }
        }
        //Caso a reserva não seja encontra na base de dados.
        System.out.println("Reserva não encontrada.");
        return listaReserva;
    }

    /**
     * Métodoq que calcula a multa caso ocorra cancelamento de reserva
     * @param data - data da reserva
     * @param diaria - diaria
     * @return 
     */
    //Metodo responsalvel por calular o valor da multa ao cancelar uma reserva
    //entre como paramentro a data para poder comparar com a atual e também o valor de uma diraria 
    public static double calcularMulta(LocalDate data, double diaria) {

        //pega a data atual do sistema
        LocalDate dataAtual = LocalDate.now();
        //Calcula a diferença entre as datas 
        long diferenca = ChronoUnit.DAYS.between(dataAtual, data);
        //se a diferença for mais do que uma semana 
        if (diferenca >= 7) {
            //Retorna o valor de medade de uma diaria pra multa
            return diaria * 0.5;
        } else {
            //Caso contrario retorna o preço de uma diaria completa 
            return diaria;
        }

    }


    /**
     * Esse método vai buscar informações na base de dados de alguma reserva
     * realizada e apresentada ao usuário
     *
     * @param reserva - Reserva que vai ser lida
     * @param cliente - Cliente que vai ser verificado na reserva
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
     * @param dados - Dados que va ser salvo
     * @param nomeArquivo - nome do arquivo que vai salvar os dados
     */
    //FUNÇÃO QUE SALVA OS DADOS DE UMA LISTA EM ARQUIVO JSON
    public static void salvarDados(List<?> dados, String nomeArquivo) {
        // Criar um ObjectMapper do Jackson
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        try {
            // Serializar a lista de objetos em um arquivo JSON
            objectMapper.writeValue(new File(nomeArquivo), dados);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo que realiza o salvamento de informações
     * @param <T> - Tipo generico de dados
     * @param dados - Dados que va ser salvo
     * @param nomeArquivo - nome do arquivo que vai salvar os dados
     * @param tipoClasse - Tipo da classe
     */
    public static <T> void salvar(T dados, String nomeArquivo, Class<T> tipoClasse) {
        List<T> listaDadosExistentes = carregarDados(nomeArquivo, tipoClasse);
        if (listaDadosExistentes == null) {
            listaDadosExistentes = new ArrayList<>();
        }

        // Verificar se o objeto já não está presente na lista
        if (!listaDadosExistentes.contains(dados)) {
            listaDadosExistentes.add(dados);
        }
    }

    /**
     * Método que vai carregar dados dos clientes da base de dados(arquivo JSON)
     *
     * @param <T> - Tipo generico de dado
     * @param nomeArquivo - Nome do arquivo passado como parametro
     * @param tipoClasse  Tipo da classe passada como parametro
     * @return
     */
    public static <T> List<T> carregarDados(String nomeArquivo, Class<T> tipoClasse) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        try {
            return objectMapper.readValue(new File(nomeArquivo), objectMapper.getTypeFactory().constructCollectionType(List.class, tipoClasse));
        } catch (IOException e) {
            e.printStackTrace();
        }
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

    /**
     * Método que calcula o faturamento da empresa 
     * @return 
     */
    public static double calcularFaturamento() {
        double faturamento = 0, receita = 0, despesa = 0;
        List<Reserva> listaReserva = new ArrayList<>();
        listaReserva = Sistema.carregarDados("Reserva.json", Reserva.class);
        List<Funcionario> listaFuncionario = Sistema.carregarDados("Funcionarios.json", Funcionario.class);
        for (Reserva aux : listaReserva) {
            //receita recebe o valor dos quartos na reserva
            receita += aux.getValor();
        }

        for (Funcionario aux : listaFuncionario) {
            //despesa recebe o gasto com os salarios do funcionarios
            despesa += aux.getSalario();
        }
        return faturamento = receita - despesa;
    }

    /**
     * Data que verifica o periodo gerado, ou seja, diferença entre as datas
     * @param periodo1 - data inicial
     * @param periodo2 - data final
     * @return 
     */
    public static boolean verificarPeriodo(List<LocalDate> periodo1, List<LocalDate> periodo2) {
        for (LocalDate data : periodo1) {
            if (periodo2.contains(data)) {
                return true; // Encontrou uma data coincidente
            }
        }
        return false; // Não encontrou datas coincidentes
    }

    /**
     * Metodo que gerar um periodo, ou seja, a diferenca entre a data inicial e a 
     * data final
     * @param dataInicio - Data inicial
     * @param dataFim - Data final 
     * @return 
     */
    public static List<LocalDate> gerarPeriodo(String dataInicio, String dataFim) {
        List<LocalDate> periodo = new ArrayList<>();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dataInicial = LocalDate.parse(dataInicio, formato);
        LocalDate dataFinal = LocalDate.parse(dataFim, formato);
        LocalDate dataAtual = dataInicial;

        while (!dataAtual.isAfter(dataFinal)) {
            periodo.add(dataAtual);
            dataAtual = dataAtual.plusDays(1);
        }

        return periodo;
    }
    
    /**
     * Método find que vai fazer uma procura utilizando comparator e iteretor
     * @param <T> - Tipo generico de dado
     * @param iterator - Iterator
     * @param comparator - comparator
     * @return 
     */
    public static <T> T find(Iterator<T> iterator, Comparator<T> comparator) {
        if (iterator.hasNext()) {
            T smallest = iterator.next();
            while (iterator.hasNext()) {
                T current = iterator.next();
                if (comparator.compare(current, smallest) < 0) {
                    smallest = current;
                }
            }
            return smallest;
        }
        return null;
    }
}