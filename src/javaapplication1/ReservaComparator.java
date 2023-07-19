/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;

/**
 * Essa classe vai realizar comparações entre as reservas da pousada, comparando o data inicial de cada uma.
 *
 * @author Getúlio
 */
public class ReservaComparator implements Comparator<Reserva> {

    /**
     * Método que compara duas classes que vão ser passadas como parametro, os resultados 
     * vão ser passado como int
     * @param reserva1 - Primeira reserva a ser comparada
     * @param reserva2 - Segunda reserva a ser comparada
     * @return
     */
    @Override
    public int compare(Reserva reserva1, Reserva reserva2) {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
        LocalDate dataInicial1 = LocalDate.parse(reserva1.getDataInicio(), formato);
        LocalDate dataInicial2 = LocalDate.parse(reserva2.getDataInicio(), formato);
        //Variavel que compara o Ano da data
        int yearCompare = (dataInicial1.getYear()) - (dataInicial2.getYear());
        //Se a diferença entre os anos for negativo ou positivo quer dizer que as datas são diferentes
        if (yearCompare != 0) {
            return yearCompare;
        }
        //Caso o ano seja igual, ou seja zero, ele compara os meses
        int monthCompare = (dataInicial1.getMonthValue()) - dataInicial2.getMonthValue();
        if (monthCompare != 0) {
            return monthCompare;
        }
        //Caso os meses também sejam iguais
        int dayCompare = dataInicial1.getDayOfMonth() - dataInicial2.getDayOfMonth();
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