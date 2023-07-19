package javaapplication1;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javaapplication1.ReservaState.EstadoDefinitivo;
import javaapplication1.ReservaState.ReservaS;

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
    private String estado;
    private String dataPedido;
    private double valor;
    private String dataInicio;//tem que ser no formato AAAA-MM-DD
    private String dataFim;
    private Quarto quarto;
    private Cliente cliente;
    //QUESTÃO 11
    private static int totalReservas = 0;
    //Construtor para iniciar todos os estados da classe 

    /**
     *
     * @param cliente
     * @param dataInicio
     * @param dataFim
     * @param quarto
     */
    public Reserva(Cliente cliente,String dataInicio, String dataFim, Quarto quarto) throws IllegalArgumentException {
        this(dataInicio, dataFim);
        this.cliente=cliente;
        this.quarto = quarto;
        this.valor = gerarValor();
        //Reserva.totalReservas = Reserva.totalReservas + 1;
    }

    public Reserva(String dataInicio, String dataFim) throws IllegalArgumentException {
        dataInicio = verificarFormato(dataInicio);
        dataFim = verificarFormato(dataFim);
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dataInicial = LocalDate.parse(dataInicio, formato);
        LocalDate dataFinal = LocalDate.parse(dataFim, formato);

        if (dataInicial == null || dataFinal == null || !verificarDatas(dataInicial, dataFinal)) {
            throw new IllegalArgumentException("Data inválida");
        }
        this.dataPedido = LocalDate.now().toString();
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.estado = EstadoReserva.PRELIMINAR.getValor();
        Reserva.totalReservas = Reserva.totalReservas + 1;
    }

    public Reserva() {
        Reserva.totalReservas = Reserva.totalReservas + 1;
    }

    public void setEstado(EstadoReserva novoEstado) {
        this.estado = novoEstado.getValor();
    }

    public String getEstado() {
        return this.estado;
    }

    public double getValor() {
        return valor;
    }

    public String getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(String dataPedido) {
        this.dataPedido = dataPedido;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataFim() {
        return dataFim;
    }

    public void setDataFim(String dataFim) {
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
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dataInicial = LocalDate.parse(dataInicio, formato);
        LocalDate dataFinal = LocalDate.parse(dataFim, formato);
        return (diasPeriodo(dataInicial, dataFinal) * quarto.getPreco());
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

    public static String verificarFormato(String data) {
        Scanner scanner = new Scanner(System.in);

        boolean formatoValido = false;
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        while (!formatoValido) {

            try {
                LocalDate dataParse = LocalDate.parse(data, formato);
                formatoValido = true;
            } catch (DateTimeParseException e) {
                System.out.println("Formato inválido! Digite novamente.");
                System.out.print("Digite a data no formato yyyy-MM-dd: ");
                data = scanner.nextLine();
            }
        }
        return data;
    }

    @Override
    public String toString() {
        return "Reserva{" + "data inicio=" + dataInicio + ", data fim=" + dataFim + ", quarto=" + quarto + ", estado=" + estado + ", cliente=" + cliente + '}';
    }
    public void confirma(){
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate data = LocalDate.parse(this.dataPedido, formato);
        if (30 >= ChronoUnit.DAYS.between(data, LocalDate.now())) {
            this.setEstado(EstadoReserva.DEFINITIVA);
        } else {
            System.out.print("Passou do prazo");
        }
    }
    public void cancelar(){
        if(this.getEstado().equals("PRELIMINAR")){
            System.out.print("Reserva cancelada");
        }else{
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate data = LocalDate.parse(this.dataPedido, formato);
            System.out.println("Reserva cancelada\nValor da multa: R$" + Sistema.calcularMulta(data, this.getQuarto().getPreco()));
        }
    }

    public enum EstadoReserva {
        PRELIMINAR("PRELIMINAR"), DEFINITIVA("DEFINITIVA");

        private final String valor;

        EstadoReserva(String valor) {
            this.valor = valor;
        }

        public String getValor() {
            return valor;
        }
    }

}

