package javaapplication1;
import java.util.Scanner;


/**
 * Classe Cliente é uma subclasse da superclasse Pessoa.Tem o papel de representar
 * um cliente da Pousada Milho verde.
 * @author Rafael e Getúlio
 */
public class Cliente extends Pessoa {

    private String cartaoCredito;
    //QUESTÃO 11
    protected static int totalClienteProtec = 0;
    private static int totalClientePrivate = 0;
    
    public Cliente(){
        super ();
    }
    /**
     * 
     * @param nome - Nome do cliente
     * @param cpf - Cpf do cliente
     * @param endereco - Endereco do cliente
     * @param telefone - Telefone do cliente
     * @param email - E-mail do cliente
     * @param cartaoCredito - Cartão de Crédito do cliente
     */
    public Cliente(String nome, String cpf, String endereco, String telefone, 
        String email,String cartaoCredito) {
        //Questao 04
        super(nome, cpf, endereco, telefone, email);
        this.cartaoCredito = cartaoCredito;
        //Variáveis de classe (static) que irão armazenar quantas instâncias foram criadas dos tipos Cliente
        Cliente.totalClienteProtec = Cliente.totalClienteProtec + 1;
        Cliente.totalClientePrivate = Cliente.totalClientePrivate + 1;
    }
 
    /**
     * Esse construtor foi criado com o intuito de fornecer apenas alguns atributos 
     * específicos para a classe
     * @param nome - Nome do cliente
     * @param cpf - Cpf do cliente
     * @param endereco - Endereco do cliente
     * @param telefone - Telefone do cliente
     * @param email - E-mail do cliente
     */
    public Cliente(String nome, String cpf, String endereco, String telefone,String email) {
        super(nome, cpf, endereco, telefone,email);
//        variáveis de classe (static) que irão armazenar quantas instâncias foram criadas dos tipos Cliente
        Cliente.totalClienteProtec = Cliente.totalClienteProtec + 1;
        Cliente.totalClientePrivate = Cliente.totalClientePrivate + 1;
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
        return "Cliente{" + super.toString() +", Cartão de Crédito=" + cartaoCredito +'}';
    }
   
    /**
     * Esse método preenche as informções solicitadas do cliente e retorna 
     * @param proposta - Retorna a proposta pelo cancelamento
     * @return 
     */
  
    //Método responsável por confirmar o cancelamento, talvez, trocar o tipo
    public boolean aceitarCancelamento(boolean proposta){
       Scanner sc = new Scanner(System.in);
       String aceitar = sc.next();
       //Condicional para verificar a resposta do cliente e retorna um boolean
       proposta = aceitar.toLowerCase().equals("sim");
       return proposta; 
    }

    /**
     * Método que vai comparar os clientes por meio da classe comparator
     * @param cliente - Cliente que vai ser verificado 
     * @return 
     */
    int compareTo(Cliente cliente) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
