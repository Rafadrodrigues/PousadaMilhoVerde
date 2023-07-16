/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication1;

import java.util.Comparator;

/**
 * Essa classe vai realizar comparações entre as reservas da pousada, comparando o data inicial de cada uma.
 *
 * @author Getúlio
 */
public class ReservaComparator implements Comparator<Reserva> {

    /**
     *
     * @param reserva1
     * @param reserva2
     * @return
     */
    @Override
    public int compare(Reserva reserva1, Reserva reserva2) {
        //Variavel que compara o Ano da data
        int yearCompare = (reserva1.getDataInicio().getYear()) - (reserva2.getDataInicio().getYear());
        //Se a diferença entre os anos for negativo ou positivo quer dizer que as datas são diferentes
        if (yearCompare != 0) {
            return yearCompare;
        }
        //Caso o ano seja igual, ou seja zero, ele compara os meses
        int monthCompare = (reserva1.getDataInicio().getMonthValue()) - reserva2.getDataInicio().getMonthValue();
        if (monthCompare != 0) {
            return monthCompare;
        }
        //Caso os meses também sejam iguais
        int dayCompare = reserva1.getDataInicio().getDayOfMonth() - reserva2.getDataInicio().getDayOfMonth();
        if (dayCompare != 0) {
            return dayCompare;
        }
        //Caso a data seja igual, compara o cliente da reserva pelo ciente comparator
        clienteComparator compareCliente = new clienteComparator();
        int clientCompare = compareCliente.compare(reserva1.getCliente(), reserva2.getCliente());
        return clientCompare;
    }
}
//  ESSA FUNÇÃO TALVEZ DA PRA MUDAR, ALGO COMO VERIFICAR A DATA FINAL TBM 