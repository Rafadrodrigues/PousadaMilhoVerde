package javaapplication1;

import java.time.LocalDate;

public class Sistema {
    
    public void cadastraCliente(String nome, String cpf, String endereco, int telefone,
    int idCliente){
        //chamaria o construtor da classe cliente com esses dados
    }
    //Método responsável por verificar disponibilidade na agenda
    
    public void verificarVaga(LocalDate dataCliente, String horario){
        
        //Primeiro,instânciamos a classe agenda(depois trocar o tipo)
        Agenda agenda = new Agenda(dataCliente,horario);
        agenda.verificarAgenda(dataCliente, horario);
        
    }
    
}
