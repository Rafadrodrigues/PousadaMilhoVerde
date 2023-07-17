package javaapplication1;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
    //   private List<LocalDate> periodo;
    private double valor;
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
    public Reserva(LocalDate dataInicio, LocalDate dataFim, Quarto quarto) throws IllegalArgumentException {
        if (dataInicio == null || dataFim == null || !verificarDatas(dataInicio, dataFim)) {
            throw new IllegalArgumentException("Data inválida");
        }
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.quarto = quarto;
        this.valor = gerarValor();
        Reserva.totalReservas = Reserva.totalReservas + 1;
    }

    public Reserva(LocalDate dataInicio, LocalDate dataFim) throws IllegalArgumentException {
        if (dataInicio == null || dataFim == null || !verificarDatas(dataInicio, dataFim)) {
            throw new IllegalArgumentException("Data inválida");
        }
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        Reserva.totalReservas = Reserva.totalReservas + 1;
    }
   
    public Reserva() {
        Reserva.totalReservas = Reserva.totalReservas + 1;
    }

    //Getters e setters correspondente aos atributos criados nessa classe.
    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
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

    public int diasPeriodo(LocalDate dataInicial, LocalDate dataFinal) {
        int numDias = 0;
        LocalDate dataAtual = dataInicial;
        while (!dataAtual.isAfter(dataFinal)) {
            numDias++;
            dataAtual = dataAtual.plusDays(1);
        }

        return numDias;
    }

    public double gerarValor() {
        //retorna o numero dos dias das reserva multiplicado pelo preco dos quartos
        return (diasPeriodo(dataInicio, dataFim) * quarto.getPreco());
    }

    public String Extrato() {
        DecimalFormat df = new DecimalFormat("#.00");
        return "Hospede: " + cliente.getNome() + "\nQuarto: " + quarto.getId() + "\nCheckin: " + dataInicio
                + "\tCheckout: " + dataFim + "\nValor: R$" + df.format(valor);
    }

    //funçao para verificar se as datas podem ser usada
    public static boolean verificarDatas(LocalDate dataInicial, LocalDate dataFinal) {
        //se as datas são iguais podem ser usada
        if (dataInicial.equals(dataFinal)) {
            return true;
        }
        //verifica se a data final e depois da inicial
        return dataFinal.isAfter(dataInicial);
    }

    @Override
    public String toString() {
        return "Reserva{" + "data inicio=" + dataInicio + ", data fim=" + dataFim + ", quarto=" + quarto + ", cliente=" + cliente + '}';
    }

}
