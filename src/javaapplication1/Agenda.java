package javaapplication1;

import java.time.LocalDate;

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


    public LocalDate armazenarData(LocalDate clienteData){
        
        //Data informada pelo cliente
        System.out.println("Data: " + dataCliente + "Horário: " + horario);
        //O funcionário vê a data informada pelo cliente e digita no sistema
        LocalDate localDate = LocalDate.now();
        
        System.out.println("Informe dia mês e ano." );
        //Inserindo a data informada pelo cliente em uma variável
        System.out.print("\nDia da semana: " + localDate.getDayOfWeek().ordinal()
        + "\nMes: " + localDate.getMonthValue()+ "\nAno:" + localDate.getYear());

        return localDate;
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
