package javaapplication1;

import java.time.LocalDate;
import java.util.List;

public class Agenda {
    
    //Atributos da classe agenda, alguns podem ser retirados posteriormente.
    //Acho que o calendario deve ser tipo list,conferir
    private LocalDate data;
    private String anotacoes;
    
    //Construtor para iniciar todos os estados da classe 

    public Agenda(LocalDate data, String anotacoes) {

        this.data = data;
        this.anotacoes = anotacoes;
    }
    //Construtor especifico para verificacoes


    public Agenda(LocalDate data) {
        this.data = data;
        //talvez eu retire um construtor
    }
    
    //Getters e setters correspondente aos atributos criados nessa classe.
    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }


    public String getAnotacoes() {
        return anotacoes;
    }

    public void setAnotacoes(String anotacoes) {
        this.anotacoes = anotacoes;
    }
    
    //Método responsável por receber data e comparar disponibilidade
    public static List<Agenda> armazenarReserva(List<Agenda> agenda,Quarto quarto,Cliente cliente ){
        //Lista que vai armazenar a reserva com dados do cliente e quarto
        
        return agenda;
    }


    //Métodos responsável por receber a resposta do bd sobre disponibilidade.
    public void verificarAgenda(LocalDate dataCliente) {
      
        //Aqui vai ser preciso solicitar o sistema faça uma verificação no arquivo json
        BancoDeDados bd = new BancoDeDados();
        //Atribuindo a resposta do bd para  uma variável 

        boolean resposta = bd.conferirData(dataCliente);
        
        //Condicional para apresentar a resposta
        if (!resposta){
            System.out.print("\nNão tem disponibilidade nessa data.");
        }else{
            System.out.print("\nTem disponibilidade nessa data.");
        }
    }
}
