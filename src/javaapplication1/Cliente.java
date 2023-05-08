package javaapplication1;

import java.util.ArrayList;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Cliente extends Pessoa {
    
    //Atributos da classe Cliente
    private LocalDate dataDesejada;
    private String horarioDesejado;
    
    //Construtor da classe Cliente
    public Cliente(String nome, String cpf, String endereco, int telefone, 
        LocalDate dataDesejada,String horarioDesejado) {
        super(nome, cpf, endereco, telefone);
        this.dataDesejada = dataDesejada;
        this.horarioDesejado = horarioDesejado;
    }

    public Cliente(String nome, String cpf, String endereco, int telefone) {
        super(nome, cpf, endereco, telefone);
    }
 
    //Getters e setters correspondente aos atributos criados nessa classe.
    public LocalDate getDataDesejada() {
        return dataDesejada;
    }

    public void setDataDesejada(LocalDate dataDesejada) {
        //Acho que vou utilizar o locale para pegar data formatada
        this.dataDesejada = dataDesejada;
    }

    public String getHorarioDesejado() {
        return horarioDesejado;
    }

    public void setHorarioDesejado(String horarioDesejado){
        //Acho que vou utilizar o locale para pegar horario formatado
        this.horarioDesejado = horarioDesejado;
    }
    
    //Métodos correspondente a classe
    //Método responsável por solicitar reserva
    public LocalDate solicitarReserva(LocalDate dataDesejada){
        System.out.print("Olá,gostaria solicitar uma reserva no dia " + this.dataDesejada);
        return dataDesejada = this.dataDesejada;
    }

    //Fornecendo informácões como String
    @Override
    public String toString() {
        return "Cliente{" + super.toString() + "dataDesejada=" + dataDesejada + ", horarioDesejado=" + horarioDesejado + '}';
    }
    
    //Método que fornece solicita outra data caso não tenha disponibilidade
    public LocalDate solicitarOutraData(LocalDate dataDesejada){
        //Vamos alterar a data
        setDataDesejada(dataDesejada);
        System.out.print("Veja se extiste disponibilidade em " + this.dataDesejada);
        return this.dataDesejada;
    }
    //Esse método pode ser melhorado, questão de lógica, mas informa a resposta do cliente quanto ao cancelamento
    public List<String> solicitarCancelamento(String cpf,LocalDate dataDesejada,int horarioDesejado){
        
        System.out.print("Olá, gostaria de realizar o cancelamento no dia " + this.dataDesejada);
        
        //Criando uma lista do tipo string para armazenar os dados para o cancelamento
        List<String> listaCancelamento = new ArrayList<String>();
        listaCancelamento.add("CPF: " + super.getCpf());
        listaCancelamento.add("Data: " + this.dataDesejada);
        listaCancelamento.add("Horário: " + this.horarioDesejado);
        
        return listaCancelamento;
    }
    //Método responsável por confirmar o cancelamento, talvez, trocar o tipo
    public boolean aceitarCancelamento(boolean proposta){
       Scanner sc = new Scanner(System.in);
       String aceitar = sc.next();
       //Condicional para verificar a resposta do cliente e retorna um boolean
       proposta = aceitar.toLowerCase().equals("sim");
       return proposta; 
    }
}
