/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication1.ReservaState;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javaapplication1.Cliente;
import javaapplication1.Quarto;
import javaapplication1.Reserva;
import static javaapplication1.Reserva.verificarFormato;
import javaapplication1.Sistema;

/**
 *
 * @author Getúlio
 */
public class ReservaS {

    private EstadoReserva estado;
    private double valor;
    private String dataPedido;
    private List<String> periodo;
    private Quarto quarto;
    private Cliente cliente;

    //QUESTÃO 11
    private static int totalReservas = 0;

    //Construtor para iniciar todos os estados da classe 
    public ReservaS() {
        this.estado = new EstadoPreliminar();
        this.dataPedido = LocalDate.now().toString();
        ReservaS.totalReservas = ReservaS.totalReservas + 1;
    }

    public ReservaS(String dataInicio, String dataFim, Quarto quarto, Cliente cliente) throws IllegalArgumentException {

        this(dataInicio,dataFim,quarto);
        this.cliente=cliente;
    }
    public ReservaS(String dataInicio, String dataFim, Quarto quarto) throws IllegalArgumentException {

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        dataInicio = verificarFormato(dataInicio);
        dataFim = verificarFormato(dataFim);
        LocalDate dataInicial = LocalDate.parse(dataInicio, formato);
        LocalDate dataFinal = LocalDate.parse(dataFim, formato);

        if (dataInicial == null || dataFinal == null || !verificarDatas(dataInicial, dataFinal)) {
            throw new IllegalArgumentException("Data inválida");
        }

        this.estado = new EstadoPreliminar();
        this.dataPedido = LocalDate.now().toString();
        this.periodo = ReservaS.gerarPeriodo(dataInicial, dataFinal);
        this.quarto = quarto;
        this.valor = gerarValor(this.periodo);
        
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

    public String getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(String dataPedido) {
        this.dataPedido = dataPedido;
    }

    public List<String> getPeriodo() {
        return periodo;
    }

    public void setPeriodo(List<String> periodo) {
        this.periodo = periodo;
    }

    public void setEstado(EstadoReserva estado) {
        this.estado = estado;
    }

    public void confirmar() {
        estado.confirma(this);
    }

    public void cancelar() {
        estado.cancelar(this.periodo, this.quarto.getId());
    }

    public EstadoReserva getEstado() {
        return estado;
    }
    
    public double gerarValor(List<String> periodo) {
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

    public static List<String> gerarPeriodo(LocalDate dataInicio, LocalDate dataFim) {
        List<String> periodo = new ArrayList<>();
        LocalDate dataAtual = dataInicio;

        while (!dataAtual.isAfter(dataFim)) {
            periodo.add(dataAtual.toString());
            dataAtual = dataAtual.plusDays(1);
        }

        return periodo;
    }

    public static boolean verificarAgenda(List<String> periodo, String idQuarto) {
        //Loop que percorre a lista 
        List<ReservaS> listaReserva = Sistema.carregarDados("ReservaState.json", ReservaS.class);
        for (ReservaS item : listaReserva) {

            if (item.getPeriodo().equals(periodo) && item.getQuarto().getId().equals(idQuarto)) {
                System.out.println("\nNão possível realizar reserva, data " + periodo.get(0) + " esta indisponível.");
                return false;
            }
        }
        System.out.println("\nData " + periodo.get(0) + " esta disponivel.");
        return true;
    }

    @Override
    public String toString() {
        return "Reserva{" + "data do pedido =" + dataPedido + ", periodo=" + periodo + ", quarto=" + quarto + ", cliente=" + cliente + '}';
    }
}