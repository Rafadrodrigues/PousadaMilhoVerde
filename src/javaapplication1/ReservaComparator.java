/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication1;

import java.util.Comparator;

/**
 *  Essa classe vai realizar comparações entre as reservas da pousada.
 * @author Getúlio
 */
public class ReservaComparator implements Comparator<Reserva>{
    
    /**
     *
     * @param reserva1
     * @param reserva2
     * @return
     */
    @Override
    public int compare(Reserva reserva1,Reserva reserva2){
        //Variavel que compara o Ano da data
        int yearCompare = (reserva1.getData().getYear()) - (reserva2.getData().getYear());
        //Se a diferença entre os anos for negativo ou positivo quer dizer que as datas são diferentes
        if(yearCompare !=0)
            return yearCompare;
        //Caso o ano seja igual, ou seja zero, ele compara os meses
        int monthCompare = (reserva1.getData().getMonthValue())-reserva2.getData().getMonthValue();
        if(monthCompare !=0)
            return monthCompare;
        //Caso os meses também sejam iguais
        int dayCompare = reserva1.getData().getDayOfMonth()-reserva2.getData().getDayOfMonth();
        if(dayCompare !=0)
            return dayCompare;
        //Caso a data seja igual, compara o quarto (Poderia ser o cliente olhar essa opção]
        return reserva1.getData().getDayOfMonth() - reserva2.getData().getDayOfMonth();

    }
}
