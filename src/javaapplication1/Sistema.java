package javaapplication1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Sistema {
    //Inicializando os 10 quaros da memória

    private static Quarto[] quartos = new Quarto[]{
            new Quarto("001",50,"Comun",false),
            new Quarto("002",50,"Comun",false),
            new Quarto("003",50,"Comun",false),
            new Quarto("004",50,"Comun",false),
            new Quarto("005",50,"Comun",false),
            new Quarto("006",100.60,"Luxo",false),
            new Quarto("007",100.60,"Luxo",false),
            new Quarto("008",100.60,"Luxo",false),
            new Quarto("009",100.60,"Luxo",false),
            new Quarto("010",100.60,"Luxo",false),
    };
    //Get e Set para manipular o atributo
    public static Quarto[] getQuartos() {
        return quartos;
    }

    public static void setQuartos(Quarto[] quartos) {
        Sistema.quartos = quartos;
    }
    
    //cria lista de funcionarios
    //Se a lista de cliente estiver funcionando correto, dá para fazer a de funcionário igual
    public static List listaFuncionario(){
        List<Funcionario> Colaboradores = new ArrayList<>();
        Funcionario func = new Funcionario("@rafa919", "123023", "Atendente",
                "Rafael", "9830123", "Diamantina", "339989021", "rafar@");
        //Precisa fazer o mesmo para a classe adm que vai ser criada
        Administrador adm = new Administrador("@getulio123", "312083", "Adm",
                "Getulio", "2113123", "Diamantina", "8021983", "getjose@");

        //salvar os objetos na lista;
        Colaboradores.add(func);
        Colaboradores.add(adm);
        return Colaboradores;
        
    } 
    public boolean FazerLogin(String user, String pin ) {
        //Lista de funcionarios;
        List<Funcionario> Colaboradores = listaFuncionario();
        //o for percorre a lista dos funcionarios
        for (int i = 0; i < Colaboradores.size(); i++) {
            if (user.equals(Colaboradores.get(i).getUsuario()) && pin.equals(Colaboradores.get(i).getSenha())) {
                //se a senha e usuario bater com algum o login é feito
                System.out.print("Sistema Liberado\n");
                return true;
            }  
        }
        //Se ao percorrer o for e não encontrar quer dizer que algum dos campos esta incorreto
        System.out.print("Acesso negado\n");
        //assim o sistema retorna falso
        return false;
    }
    //Os métodos eu optei por ser estático, pelo fato que é um método que é utilizado apenas no Sistema
    //Método responsável por incluir Cliente,Funcionario ou Administrado na BD
    
    public static List<Cliente> incluir(List<Cliente> listaCliente, Cliente cliente){
        //Uma lista que vai ser inserido os clientes
        //A classe vai ser instanciada no main e inserida como parametro.
        //Considerando que a lista esteja vazia,adicionamos um cliente
        if (listaCliente.isEmpty()) {
            listaCliente.add(cliente);
            System.out.println("Cliente Adicionado.");
            return listaCliente;
        }
        //Verificando se o cliente já existe na bd
        for(int i=0;i<listaCliente.size();i++){
            if(listaCliente.get(i).getCpf().equals(cliente.getCpf())){
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

    //Método responsável por editar Cliente,Funcionario ou Administrado na BD
    public static List<Cliente> editar(List<Cliente> listaCliente, Cliente cliente) {
        //Recebendo lista de clientes
        //Essa linhja está dando erro, porque está inserindo duas vezes, mas está funcionando
        
        if (listaCliente.isEmpty()) {
            System.out.println("Cliente inexistente.");
            return listaCliente;
        }
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

    //Método responsável por editar Cliente,Funcionario ou Administrado na BD
    public static List<Cliente> remover(List<Cliente> listaCliente, Cliente cliente) {
        
        //Eu poderia criar um método listaCliente e atribuir no lugar de incluir
        
        if (listaCliente.isEmpty()) {
            System.out.println("Cliente inexistente.");
            return listaCliente;
        }
        //Verificando se o cliente já existe na bd
        for(int i=0;i<listaCliente.size();i++){
            if(listaCliente.get(i).getCpf().equals(cliente.getCpf())){
                //Considerando que já tenha o cliente na base de dados.
                listaCliente.remove(i);
                System.out.println("Cliente removido.");
                return listaCliente;
            }
        }
        System.out.println("Cliente inexistente.");
        return listaCliente;
    } 

    //Métodos responsável por inserir funcionários na base de dados
    public static List incluir(List<Funcionario> Colaboradores,Funcionario func){
        //A classe vai ser instanciada no main e inserida como parametro.
        //Considerando que a lista esteja vazia,adicionamos um cliente
        if (Colaboradores.isEmpty()) {
            Colaboradores.add(func);
            System.out.println("Funcionário Adicionado.");
            return Colaboradores;
        }
        //Verificando se o cliente já existe na bd
        for(int i=0;i<Colaboradores.size();i++){
            if(Colaboradores.get(i).getCpf().equals(func.getCpf())){
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

    //Método responsável por editar Cliente,Funcionario ou Administrado na BD
    public static List editar(List<Funcionario> Colaboradores,Funcionario func) {
        //Recebendo lista de funcionarios e editando
        //Essa linhja está dando erro, porque está inserindo duas vezes, mas está funcionando
        
        if (Colaboradores.isEmpty()) {
            System.out.println("Funcionário inexistente.");
            return Colaboradores;
        }
        for(int i=0;i<Colaboradores.size();i++){
            if(Colaboradores.get(i).getCpf().equals(func.getCpf())){
                //Considerando que já tenha o cliente na base de dados.
                //Preciso verificar o método replace, pode ser mais adequado
                Colaboradores.set(i, func);
                System.out.println("Funcionário editado.");
                return Colaboradores;
            }
        }
        return Colaboradores;
    }

    //Método responsável por editar Cliente,Funcionario ou Administrado na BD
    public static List remover(List<Funcionario> Colaboradores,Funcionario func) {
        
        //Eu poderia criar um método listaCliente e atribuir no lugar de incluir
        
        if (Colaboradores.isEmpty()) {
            System.out.println("Funcionário inexistente.");
            return Colaboradores;
        }
        //Verificando se o cliente já existe na bd
        for(int i=0;i<Colaboradores.size();i++){
            if(Colaboradores.get(i).getCpf().equals(func.getCpf())){
                //Considerando que já tenha o cliente na base de dados.
                Colaboradores.remove(i);
                System.out.println("Funcionário removido.");
                return Colaboradores;
            }
        }
        return Colaboradores;
    } 
    //Método responsável por verificar reserva e entregar quais quartos estão disponiveis
    public static List verificarReserva(List<Reserva> listaReserva, LocalDate data){
        //Para verificar a data é preciso da classe reserva
        //Uma lista que vai armazenar a disponibilidade dos quartos e as datas
  
        List quartoDisponivel = new ArrayList<>();
        List diasReserva = new ArrayList<>();
        
        if(listaReserva.isEmpty()){
                System.out.println("\nExiste disponibilidade em todos os quartos.");
                quartoDisponivel.add(quartos);
                diasReserva.add(quartoDisponivel);
                //Como a lista está vazia todos os quartos estao livres
                return diasReserva;
        }else{
        //Loop que percorre a lista 
        for(int i=0;i<listaReserva.size();i++){
            //Imprimindo apenas os quartos que estão disponível
            if(listaReserva.get(i).getData().equals(data)){
                for(Quarto quarto:quartos){
                    //Condicão que verifica se o quarto ta livre, se for true, está ocupado
                    if(quarto.isOcupation() != false){
                        System.out.println("\nExiste disponibilidade no quarto: " + quartos[i]);
                        //Quartos disponíveis estão sendo armazenados na lista quartoDisponivel
                        quartoDisponivel.add(quartos[i]);   
                        diasReserva.add(quartoDisponivel);
                        //No diasReserva, está contido os quartos disponíveis para aquela data
                        return diasReserva;
                    }      
                }
            }
        }
    }
        return diasReserva;
}
    //Método responsável por receber data e comparar disponibilidade
    public static List realizarReserva(List listaReserva,List diasReserva, Quarto quarto,Cliente cliente){
        // Aqui vai armazenar a reserva na lista de reserva e depois preencher os atributos da classe reserva
        
        Scanner sc = new Scanner(System.in);
        Reserva reserva = new Reserva();
        
//        System.out.println("Informe o Id o quarto desejado Preço:Categoria: ");
        //Preenchendo os campos da reserva e do quarto
        quarto.setId(sc.nextLine());
        quarto.setOcupation(true);
        reserva.setQuarto(quarto);
        reserva.setCliente(cliente);
        reserva.setData(cliente.getDataDesejada());
        //Agora acrescentamos tudo da lista de reserva
        listaReserva.add(reserva);
        return listaReserva;
    }
    //Após a reserva acontecer, esse método vai gerar um extrato.
    public void gerarExtrato(){
        //Nome do cliente, preco do quarto * quantidade de dias da reserva.
        //Uma data final e uma data inicial.
    }
      //Método responsável por ler dados da reserva 
    public static List<Reserva> lerReserva(List<Reserva> reserva,Cliente cliente) {
        //Eu preciso realizar a reserva primeiro para depois imprimir
        //Conferindo na agenda o cliente desejado e apresentando informaçoes da agenda
        if(reserva.isEmpty()){
            System.out.println("Nenhuma reserva.");
            return reserva;
        }else{
        //Um for para percorrer a agenda em busca do cpf do cliente com informações
        for (int i=0;i<reserva.size();i++){
            if(reserva.get(i).equals(cliente.getDataDesejada())){
                System.out.print( reserva.get(i));
                return reserva;
            }
        }   
        //De toda forma não encontrar, mostrar que o cliente não tem reserva naquele dia
        System.out.println("Cliente sem reserva nessa data.");
        return reserva;
        }
    } 
}
