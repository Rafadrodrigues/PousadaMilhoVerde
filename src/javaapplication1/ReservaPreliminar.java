package javaapplication1;

import java.time.LocalDate;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Getúlio
 */
public class ReservaPreliminar {
    private double valor;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private LocalDate dataCriacao;
    private Quarto quarto;
    private Cliente cliente;
    
    public ReservaPreliminar(LocalDate dataInicio, LocalDate dataFim) throws IllegalArgumentException {
        if (dataInicio == null || dataFim == null || !Reserva.verificarDatas(dataInicio, dataFim)) {
            throw new IllegalArgumentException("Data inválida");
        }
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.dataCriacao = LocalDate.now();
    }

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
     public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
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
    
}
