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
}
