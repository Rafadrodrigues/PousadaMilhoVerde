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
    public LocalDate verificarAgenda(LocalDate clienteData,int horario){
        
        LocalDate localDate = LocalDate.now();
        
        //Pegando a data informada pelo cliente
        System.out.println("Dia da semana: " + localDate.getDayOfWeek().ordinal());
        System.out.println("Mes: " + localDate.getMonthValue());
        System.out.println("Ano: " + localDate.getYear());
        System.out.println("A data informada é " + localDate);

        /*Vai ser preciso acessar os dados armazenados no Json para verificação 
        e após isso, uma condicional para realizar a validação das datas */

        return localDate;

    }
    
}
