package javaapplication1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe Reserva, nela estão contidas informações sobre a reservas da Pousada
 * Milho Verde
 *
 * @author rafar
 */
public class Reserva {

    //Atributos da classe agenda, alguns podem ser retirados posteriormente.
    //Occupation inicialmente recebe false para sinalizar que o quarto não esta ocupado
    //Data,quarto e cliente vão ser armazenados no calendario
    private List<LocalDate> periodo;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private Quarto quarto;
    private Cliente cliente;
    //QUESTÃO 11
    private static int totalReservas = 0;
    //Construtor para iniciar todos os estados da classe 

    /**
     *
     * @param dataInicio
     * @param dataFim
     * @param quarto
     */
    public Reserva(LocalDate dataInicio, LocalDate dataFim, Quarto quarto) {
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.quarto = quarto;
        this.periodo = Sistema.gerarPeriodo(dataInicio, dataFim);
        Reserva.totalReservas = Reserva.totalReservas + 1;
    }
     public Reserva(LocalDate dataInicio, LocalDate dataFim){
         this.dataInicio = dataInicio;
        this.dataFim = dataFim;
     }
    public Reserva() {
        Reserva.totalReservas = Reserva.totalReservas + 1;
    }

    //Getters e setters correspondente aos atributos criados nessa classe.
    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public List<LocalDate> getPeriodo() {
        return periodo;
    }

    public void setPeriodo(List<LocalDate> periodo) {
        this.periodo = periodo;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
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
    public void armazenaReserva(List listaReserva) {
        //Sera passado como paramentro o método do sistema que realizaReserva
        List diasReserva = new ArrayList<>();

    }

    @Override
    public String toString() {
        return "Reserva{" + "data inicio=" + dataInicio + ", data fim=" + dataFim + ", quarto=" + quarto + ", cliente=" + cliente + '}';
    }

}
