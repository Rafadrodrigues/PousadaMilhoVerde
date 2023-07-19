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
    private String cartaoCredito;
    //QUESTÃO 11
    protected static int totalClienteProtec = 0;
    private static int totalClientePrivate = 0;
    
    public Cliente(){
        super ();
    }
    //Construtor da classe Cliente
    public Cliente(String nome, String cpf, String endereco, String telefone, 
        String email,String cartaoCredito) {
        //Questao 04
        super(nome, cpf, endereco, telefone, email);
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

    int compareTo(Cliente cliente) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
