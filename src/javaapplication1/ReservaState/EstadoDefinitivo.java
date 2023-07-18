/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication1.ReservaState;

import java.util.List;
import javaapplication1.Sistema;


/**
 *
 * @author Getúlio
 */
public class EstadoDefinitivo implements EstadoReserva {

    @Override
    public void confirma(ReservaS reserva) {
        System.out.print("Reserva já esta confirmada ");
    }

    @Override
    public void cancelar(ReservaS reserva) {
        List<ReservaS> listaReserva = Sistema.carregarDados("ReservaState.json",ReservaS.class);
        listaReserva=Sistema.cancelarReservaS(listaReserva, reserva.getPeriodo(),reserva.getQuarto().getId());
        Sistema.salvarDados(listaReserva, "ReservaState.json");
}
}

