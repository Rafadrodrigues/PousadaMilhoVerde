/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication1;

import java.util.Comparator;

/**
 * A classe clienteComparator que implementa o comparator, permitindo que objetos sejam comparados por diferentes atributos 
 * @author Getúlio
 */
public class clienteComparator implements Comparator<Cliente>{

    /**
     *
     * @param cliente1
     * @param cliente2
     * @return
     */
    @Override
    public int compare(Cliente cliente1,Cliente cliente2){
        int nameCompare = cliente1.getNome().compareTo(cliente2.getNome());
        return nameCompare;
        //É nescessario colocar mais comparações
    }
}
