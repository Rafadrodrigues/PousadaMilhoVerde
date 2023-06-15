package javaapplication1;

import java.util.ArrayList;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import javaapplication1.Pessoa;

/**
 * Classe Cliente é uma subclasse da superclasse Pessoa.Tem o papel de representar
 * um cliente da Pousada Milho verde.
 * @author rafar
 */
public class Cliente extends Pessoa {

    //Atributos da classe Cliente
    private LocalDate dataDesejada;
    private String cartaoCredito;
    protected static int totalClienteProtec = 0;
    private static int totalClientePrivate = 0;
    public Cliente(){
        super ();
    }
    //Construtor da classe Cliente
    public Cliente(String nome, String cpf, String endereco, String telefone, 
        String email, LocalDate dataDesejada,String horarioDesejado,String cartaoCredito) {
        super(nome, cpf, endereco, telefone, email);
        this.dataDesejada = dataDesejada;
        this.cartaoCredito = cartaoCredito;
        //variáveis de classe (static) que irão armazenar quantas instâncias foram criadas dos tipos Cliente
        Cliente.totalClienteProtec = Cliente.totalClienteProtec + 1;
        Cliente.totalClientePrivate = Cliente.totalClientePrivate + 1;
    }
 
    /**
     * Esse construtor foi criado com o intuito de fornecer apenas alguns atributos 
     * específicos para a classe
     * @param nome
     * @param cpf
     * @param endereco
     * @param telefone
     * @param email 
     */
    public Cliente(String nome, String cpf, String endereco, String telefone,String email) {
        super(nome, cpf, endereco, telefone,email);
//        variáveis de classe (static) que irão armazenar quantas instâncias foram criadas dos tipos Cliente
        Cliente.totalClienteProtec = Cliente.totalClienteProtec + 1;
        Cliente.totalClientePrivate = Cliente.totalClientePrivate + 1;
    }
 
    //Getters e setters correspondente aos atributos criados nessa classe.
    public LocalDate getDataDesejada() {
        return dataDesejada;
    }

    public void setDataDesejada(LocalDate dataDesejada) {
        //Acho que vou utilizar o locale para pegar data formatada
        this.dataDesejada = dataDesejada;
    }

    public String getCartaoCredito() {
        return cartaoCredito;
    }

    public void setCartaoCredito(String cartaoCredito) {
        this.cartaoCredito = cartaoCredito;
    }

    public static int gettotalClientePrivate() {
        return Cliente.totalClientePrivate;
    }

    public static void setTotalClientePrivate(int totalClientePrivate) {
        Cliente.totalClientePrivate = totalClientePrivate;
    }
    
    //Fornecendo informácões como String
    @Override
    public String toString() {
        return "Cliente{" + super.toString() + "Data desejada=" + dataDesejada + ", Cartão de Crédito=" + cartaoCredito +'}';
    }
    //Método que fornece os dados do cliente
    //Método responsável por solicitar reserva
    /**
     * Método representa o cliente solicitando uma reserva 
     * @param dataDesejada
     * @return 
     */
    public LocalDate solicitarReserva(LocalDate dataDesejada){
        System.out.print("Olá,gostaria solicitar uma reserva no dia " + this.dataDesejada);
        return dataDesejada = this.dataDesejada;
    }

    public LocalDate solicitarOutraData(LocalDate dataDesejada){
        //Vamos alterar a data
        setDataDesejada(dataDesejada);
        System.out.print("Veja se extiste disponibilidade em " + this.dataDesejada);
        return this.dataDesejada;
    }
    //Esse método pode ser melhorado, questão de lógica, mas informa a resposta do cliente quanto ao cancelamento
    public List<String> solicitarCancelamento(String cpf,LocalDate dataDesejada){
        
        System.out.print("Olá, gostaria de realizar o cancelamento no dia " + this.dataDesejada);
        
        //Criando uma lista do tipo string para armazenar os dados para o cancelamento
        List<String> listaCancelamento = new ArrayList<String>();
        listaCancelamento.add("CPF: " + super.getCpf());
        listaCancelamento.add("Data: " + this.dataDesejada);
        
        return listaCancelamento;
    }
    /**
     * Esse método preenche as informções solicitadas do cliente e retorna 
     * @return 
     */
    public static Cliente criarCliente(){
        Scanner cin = new Scanner(System.in);
        Cliente cliente = new Cliente();
                System.out.println("Nome");
                cliente.setNome(cin.nextLine());
                System.out.println("CPF");
                cliente.setCpf(cin.nextLine());
                System.out.println("endereco");
                cliente.setEndereco(cin.nextLine());
                System.out.println("Telefone");
                cliente.setTelefone(cin.nextLine());
                System.out.println("E-mail");
                cliente.setEmail(cin.nextLine());
        return cliente;
    }
    //Método responsável por confirmar o cancelamento, talvez, trocar o tipo
    public boolean aceitarCancelamento(boolean proposta){
       Scanner sc = new Scanner(System.in);
       String aceitar = sc.next();
       //Condicional para verificar a resposta do cliente e retorna um boolean
       proposta = aceitar.toLowerCase().equals("sim");
       return proposta; 
    }

    int compareTo(Cliente cliente) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
