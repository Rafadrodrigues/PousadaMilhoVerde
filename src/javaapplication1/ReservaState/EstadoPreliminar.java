/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication1.ReservaState;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import java.util.List;
import javaapplication1.Sistema;

/**
 *
 * @author Getúlio
 */
public class EstadoPreliminar implements EstadoReserva {

    @Override
    public void confirma(ReservaS reserva) {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dataPedido = LocalDate.parse(reserva.getDataPedido(), formato);
        if (30 >= ChronoUnit.DAYS.between(dataPedido, LocalDate.now())) {
            System.out.print("Reserva Confirmada\n");
            reserva.setEstado(new EstadoDefinitivo());
            List<ReservaS> listaReserva = Sistema.carregarDados("ReservaState.json", ReservaS.class);
            listaReserva.add(reserva);
            Sistema.salvarDados(listaReserva, "ReservaState.json");
        } else {
            System.out.print("Passou do prazo");
        }
    }

    @Override
    public void cancelar(List<String> periodo, String IdQuarto) {
        List<ReservaS> listaReserva = Sistema.carregarDados("ReservaState.json", ReservaS.class);
        listaReserva = Sistema.cancelarReservaS(listaReserva, periodo, IdQuarto);
        Sistema.salvarDados(listaReserva, "ReservaState.json");
    }

}
