package javaapplication1;

import java.time.LocalDate;

public class Sistema {
    
    public void cadastraCliente(String nome, String cpf, String endereco, int telefone,
    int idCliente){
        //chamaria o construtor da classe cliente com esses dados
    }
    //Método responsável por verificar disponibilidade na agenda
    
    public void verificarVaga(LocalDate dataCliente){
        //Primeiro,instânciamos a classe agenda(depois trocar o tipo)
        Agenda agenda = new Agenda(dataCliente);
        agenda.verificarAgenda(dataCliente);
        
    }
    
    public void realizarReserva(LocalDate dataCliente,String cartao){
        Agenda agenda = new Agenda(dataCliente);
        agenda.armazenarData(dataCliente);
        //Após armazenar a data vem a cobrança da diária 
    }
}
