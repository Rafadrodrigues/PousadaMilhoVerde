package javaapplication1;

import java.util.ArrayList;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Cliente extends Pessoa {
    
    //Atributos da classe Cliente
    private LocalDate dataDesejada;
    private String cartaoCredito;
    
    //Construtor da classe Cliente
    public Cliente(String nome, String cpf, String endereco, int telefone, 
        String email, LocalDate dataDesejada,String horarioDesejado,String cartaoCredito) {
        super(nome, cpf, endereco, telefone, email);
    // Caracteristica da classe conta. numero cartao, cvv, data, nome.
    //Saldo talvez pode ser retirado depois
    }
    
    //Construtor da classe Cliente
    public Cliente(String nome, String cpf, String endereco, int telefone, 
        LocalDate dataDesejada,String email,String cartaoCredito) {
        super(nome, cpf, endereco, telefone,email);
        this.dataDesejada = dataDesejada;
        this.cartaoCredito = cartaoCredito;
    }

    public Cliente(String nome, String cpf, String endereco, int telefone,String email) {
        super(nome, cpf, endereco, telefone,email);
    }
 
    //Getters e setters correspondente aos atributos criados nessa classe.
    public LocalDate getDataDesejada() {
        return dataDesejada;
    }

    public void setDataDesejada(LocalDate dataDesejada) {
        this.dataDesejada = dataDesejada;
    }
    public String getCartaoCredito() {
        return cartaoCredito;
    }

    public void setCartaoCredito(String cartaoCredito) {
        this.cartaoCredito = cartaoCredito;
    }
    
    //Fornecendo informácões como String
    @Override
    public String toString() {
        return "Cliente{" + super.toString() + "Data desejada=" + dataDesejada + ", Cartão de Crédito=" + cartaoCredito +'}';
    }
    //Método que fornece os dados do cliente
    //Método responsável por solicitar reserva
    public LocalDate solicitarReserva(LocalDate dataDesejada){
        System.out.print("Olá,gostaria solicitar uma reserva no dia " + this.dataDesejada);
        return dataDesejada = this.dataDesejada;
    }

    public LocalDate solicitarOutraData(LocalDate dataDesejada){
        System.out.print("Veja se extiste disponibilidade em " + this.dataDesejada);
        return dataDesejada = this.dataDesejada;
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
    public boolean aceitarCancelamento(boolean proposta){
       Scanner sc = new Scanner(System.in);
       String aceitar = sc.next();
       //Condicional para verificar a resposta do cliente e retorna um boolean
       proposta = aceitar.toLowerCase().equals("sim");
       return proposta; 
    }
}
