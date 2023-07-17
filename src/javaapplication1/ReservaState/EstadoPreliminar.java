/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication1.ReservaState;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author Getúlio
 */
public class EstadoPreliminar implements EstadoReserva {
    @Override
    public void confirma(ReservaS reserva) {
        if( 30 >= ChronoUnit.DAYS.between(reserva.getDataPedido(), LocalDate.now())){
            System.out.print("Reserva Confirmada");
            reserva.setEstado(new EstadoDefinitivo());
        }else{
            System.out.print("Passou do prazo");
        }
    }

    @Override
    public void cancelar(ReservaS reserva) {
         System.out.print("Reserva Cancelada ");
    }
    
}
