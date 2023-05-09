package javaapplication1;

import java.time.LocalDate;

public class Sistema {
    
    public void cadastraCliente(String nome, String cpf, String endereco, int telefone,
    int idCliente){
        //chamaria o construtor da classe cliente com esses dados
    }
    //Método responsável por verificar disponibilidade na agenda
    
<<<<<<< HEAD
    public void verificarVaga(LocalDate dataCliente){
=======
    public void verificarVaga(LocalDate dataCliente, int horario){
>>>>>>> 70797bfbb22ec0028daa09ecd038c6e91cf4b1a2
        
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
