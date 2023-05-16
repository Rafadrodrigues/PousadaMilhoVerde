package javaapplication1;

import java.time.LocalDate;
import java.util.List;

public class Reserva {
    
    //Atributos da classe agenda, alguns podem ser retirados posteriormente.
    //Occupation inicialmente recebe false para sinalizar que o quarto não esta ocupado
    private LocalDate data;
    private String anotacoes;
    private Quarto[] quarto ;
    private Cliente cliente;
    
    //Construtor para iniciar todos os estados da classe 

    public Reserva(LocalDate data,Quarto[] quarto) {
        this.data = data;
        this.quarto = quarto;
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

//    public boolean isOcupation() {
//        return ocupation;
//    }
//
//    public void setOcupation(boolean ocupation) {
//        this.ocupation = ocupation;
//    }  

    public Quarto[] getQuarto() {
        return quarto;
    }

    public void setQuarto(Quarto[] quarto) {
        this.quarto = quarto;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
}
