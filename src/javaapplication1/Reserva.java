package javaapplication1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe Reserva, nela estão contidas informações sobre a reservas da Pousada
 * Milho Verde
 * @author rafar
 */
public class Reserva {
    
    //Atributos da classe agenda, alguns podem ser retirados posteriormente.
    //Occupation inicialmente recebe false para sinalizar que o quarto não esta ocupado
    //Data,quarto e cliente vão ser armazenados no calendario
    private LocalDate data;
    private Quarto quarto ;
    private Cliente cliente;
    private static int totalReservas = 0;
    //Construtor para iniciar todos os estados da classe 
    public Reserva(LocalDate data,Quarto quarto) {
        this.data = data;
        this.quarto = quarto;
        Reserva.totalReservas = Reserva.totalReservas+1;
    }
    public Reserva() {
      Reserva.totalReservas = Reserva.totalReservas+1;
    }
    //Getters e setters correspondente aos atributos criados nessa classe.
    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
    public Quarto getQuarto() {
        return quarto;
    }

    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public static int getTotalReservas() {
        return totalReservas;
    }

    public static void setTotalReservas(int totalReservas) {
        Reserva.totalReservas = totalReservas;
    }
    
    //Método que salva a data no calendario
    public void armazenaReserva(List listaReserva){
        //Sera passado como paramentro o método do sistema que realizaReserva
        List diasReserva = new ArrayList<>();
        
    }
    @Override
    public String toString() {
        return "Reserva{" + "data=" + data + ", quarto=" + quarto + ", cliente=" + cliente + '}';
    }
    
}
