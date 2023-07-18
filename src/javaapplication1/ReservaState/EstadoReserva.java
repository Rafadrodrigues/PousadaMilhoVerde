/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package javaapplication1.ReservaState;

import java.util.List;

/**
 *
 * @author Getúlio
 */
public interface EstadoReserva {
    public abstract void confirma(ReservaS reserva);
    public abstract void cancelar(List<String> periodo, String IdQuarto);
}
