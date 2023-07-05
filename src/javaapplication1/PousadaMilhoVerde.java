package javaapplication1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import static javaapplication1.Sistema.editar;
import static javaapplication1.Sistema.gerarExtrato;
import static javaapplication1.Sistema.incluir;
import static javaapplication1.Sistema.realizarReserva;
import static javaapplication1.Sistema.remover;
import static javaapplication1.Sistema.salvarDados;

//import org.json.simple.JSONArray;;
//import org.json.simple.parser.ParseException;;

/**
 * Classe Pousada Milho Verde e vai ser responsável por executar nossos arquivos,
 * ela é o arquivo main do nosso programa.
 * @author rafar
 */
public class PousadaMilhoVerde {

    public static void main(String[] args) throws IOException, ParseException {
//        Administrador adm = new Administrador("Getulio","123456","gerente","Getulio Santos","123.456.789-57","Diamantina","389985756","getuliosantos@email");
//        
//        List<Administrador> Colaboradores = new ArrayList<>();
//        Colaboradores.add(adm);
//        Sistema.salvarDados(Colaboradores, "Funcionarios.json");
        
       // Funcionario func = new Funcionario();

        //Lista encadeada para o banco de dados onde vai ser inserida listas
        ArrayList<Object> Bd = new ArrayList<>();
        //Lista de clientes
        List<Cliente> listaClientes = new ArrayList<>();
        //Lista de funcionarios
        List<Funcionario> funcionarios = new ArrayList<>();
        //Lista de Reserva
        List<Reserva> reserva = new ArrayList<>();
        
        //Cliente cliente1 = new Cliente("Rafael", "9830123", "Belo Horizonte", "339989021", "rafar@");
        Cliente cliente2 = new Cliente("Getulio", "123.456.789-57", "Diamantina", "8021983", "getjose@");
        Cliente cliente3 = new Cliente("Dudu", "123.456.789-57", "Diamantina", "389982356", "Duduvisitante@");
        Funcionario func = new Funcionario("@rafa919", "123023","atendente","Rafael","123456789","Diamantina","3399833","RafaDias@");
        Reserva reserva1 = new Reserva();
        Reserva reserva2 = new Reserva();
        
        clienteComparator comparator = new clienteComparator();
        ReservaComparator comparatorReserva = new ReservaComparator();
        listaClientes.add(cliente2);
        listaClientes.add(cliente3);
        
        //QUESTÃO 06
        incluir(funcionarios,func);
        editar(funcionarios,func);
        remover(funcionarios,func);
        
        //QUESTÃO 07
        incluir(listaClientes,cliente2);
        editar(listaClientes,cliente3);
        remover(listaClientes,cliente2);
        
        //QUESTÃO 08
        reserva1.toString();
        
        realizarReserva(reserva,cliente2);
        
        System.out.println(reserva);

        //QUESTÃO 10
        gerarExtrato(reserva1);

        //QUESTÃO 12
        Sistema.numInstancias();
        
        //QUESTÃO 13
        comparator.compare(cliente2,cliente3);
        comparatorReserva.compare(reserva1, reserva2);
    
       //QUESTÃO 14
       salvarDados(funcionarios,"Funcionarios.json");
       
       //QUESTÃO 15
       //Está em todas as classes.
       
    }
}
