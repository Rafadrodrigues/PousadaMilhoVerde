/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication1.ReservaState;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javaapplication1.Cliente;
import javaapplication1.Quarto;

/**
 *
 * @author Getúlio
 */
public class ReservaS {

    private EstadoReserva estado;
    private double valor;
    private LocalDate dataPedido;
    private List<LocalDate> periodo;
    private Quarto quarto;
    private Cliente cliente;

    //QUESTÃO 11
    private static int totalReservas = 0;

    //Construtor para iniciar todos os estados da classe 
    public ReservaS() {
        this.estado = new EstadoPreliminar();
        this.dataPedido = LocalDate.now();
        ReservaS.totalReservas = ReservaS.totalReservas + 1;
    }

    public ReservaS(LocalDate dataInicio, LocalDate dataFim, Quarto quarto) throws IllegalArgumentException {
        if (dataInicio == null || dataFim == null || !verificarDatas(dataInicio, dataFim)) {
            throw new IllegalArgumentException("Data inválida");
        }
        this.estado = new EstadoPreliminar();
        this.dataPedido = LocalDate.now();
        this.periodo = ReservaS.gerarPeriodo(dataInicio, dataFim);
        this.quarto = quarto;
        this.valor = gerarValor(this.periodo);
        ReservaS.totalReservas = ReservaS.totalReservas + 1;
    }

    public ReservaS(LocalDate dataInicio, LocalDate dataFim) throws IllegalArgumentException {
        if (dataInicio == null || dataFim == null || !verificarDatas(dataInicio, dataFim)) {
            throw new IllegalArgumentException("Data inválida");
        }
        this.estado = new EstadoPreliminar();
        this.dataPedido = LocalDate.now();
        this.periodo = ReservaS.gerarPeriodo(dataInicio, dataFim);
        ReservaS.totalReservas = ReservaS.totalReservas + 1;
    }

    //Getters e setters correspondente aos atributos criados nessa classe.
    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
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
        ReservaS.totalReservas = totalReservas;
    }

    public LocalDate getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(LocalDate dataPedido) {
        this.dataPedido = dataPedido;
    }

    public List<LocalDate> getPeriodo() {
        return periodo;
    }

    public void setPeriodo(List<LocalDate> periodo) {
        this.periodo = periodo;
    }

    public void setEstado(EstadoReserva estado) {
        this.estado = estado;
    }

    public void confirmar(ReservaS reserva) {
        estado.confirma(reserva);
    }

    public void cancelar(ReservaS reserva) {
        estado.cancelar(reserva);
    }

    public double gerarValor(List<LocalDate> periodo) {
        //retorna o numero dos dias das reserva multiplicado pelo preco dos quartos
        return ((periodo.size()) * quarto.getPreco());
    }

    public String Extrato() {
        DecimalFormat df = new DecimalFormat("#.00");
        return "Hospede: " + cliente.getNome() + "\nQuarto: " + quarto.getId() + "\nCheckin: " + periodo.get(0)
                + "\tCheckout: " + periodo.get(periodo.size() - 1) + "\nValor: R$" + df.format(valor);
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

    public static List<LocalDate> gerarPeriodo(LocalDate dataInicio, LocalDate dataFim) {
        List<LocalDate> periodo = new ArrayList<>();
        LocalDate dataAtual = dataInicio;

        while (!dataAtual.isAfter(dataFim)) {
            periodo.add(dataAtual);
            dataAtual = dataAtual.plusDays(1);
        }

        return periodo;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
