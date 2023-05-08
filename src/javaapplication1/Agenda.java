package javaapplication1;

import java.time.LocalDate;

public class Agenda {
    //Atributos da classe agenda, alguns podem ser retirados posteriormente.
    //Acho que o calendario deve ser tipo list,conferir
    private LocalDate data;
    private int horario;
    private String anotacoes;
    
    //Construtor para iniciar todos os estados da classe 
    public Agenda(LocalDate data, int horario, String anotacoes) {
        this.data = data;
        this.horario = horario;
        this.anotacoes = anotacoes;
    }
    //Construtor especifico para verificacoes
    public Agenda(LocalDate data, int horario) {
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

    public int getHorario() {
        return horario;
    }

    public void setHorario(int horario) {
        this.horario = horario;
    }

    public String getAnotacoes() {
        return anotacoes;
    }

    public void setAnotacoes(String anotacoes) {
        this.anotacoes = anotacoes;
    }
    
    //Método responsável por receber data e comparar disponibilidade
    public LocalDate armazenarData(){
        
        LocalDate localDate = LocalDate.now();
        
        //O funcionário vê a data informada pelo cliente e digita no sistema
        //Pegando a data informada pelo cliente
        System.out.println("Informe dia mês e ano." );
        System.out.print("\nDia da semana: " + localDate.getDayOfWeek().ordinal()
        + "\nMes: " + localDate.getMonthValue()+ "\nAno:" + localDate.getYear());

        return localDate;
    }

    void verificarAgenda(LocalDate dataCliente, int horario) {
        //Aqui vai ser preciso solicitar o sistema faça uma verificação no arquivo json
    }
    
}
