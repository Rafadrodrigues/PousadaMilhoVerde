package javaapplication1;

import java.time.LocalDate;

public class Agenda {
    //Atributos da classe agenda, alguns podem ser retirados posteriormente.
    //Acho que o calendario deve ser tipo list,conferir
    private LocalDate data;
    private String horario;
    private String anotacoes;
    
    //Construtor para iniciar todos os estados da classe 
    public Agenda(LocalDate data, String horario, String anotacoes) {
        this.data = data;
        this.horario = horario;
        this.anotacoes = anotacoes;
    }
    //Construtor especifico para verificacoes
    public Agenda(LocalDate data, String horario) {
        this.data = data;
        this.horario = horario;
    }
    
    //Getters e setters correspondente aos atributos criados nessa classe.
    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getAnotacoes() {
        return anotacoes;
    }

    public void setAnotacoes(String anotacoes) {
        this.anotacoes = anotacoes;
    }
    
    //Método responsável por receber data e comparar disponibilidade
    public LocalDate armazenarData(LocalDate dataCliente, String horario){
        
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
    public void verificarAgenda(LocalDate dataCliente, String horario) {
        
        //Aqui vai ser preciso solicitar o sistema faça uma verificação no arquivo json
        BancoDeDados bd = new BancoDeDados();
        //Atribuindo a resposta do bd para  uma variável 
        boolean resposta = bd.conferirData(data, horario);
        
        //Condicional para apresentar a resposta
        if (!resposta){
            System.out.print("\nNão tem disponibilidade nessa data.");
        }else{
            System.out.print("\nTem disponibilidade nessa data.");
        }
    }
}
