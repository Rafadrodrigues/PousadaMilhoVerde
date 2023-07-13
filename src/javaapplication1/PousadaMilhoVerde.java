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
import static javaapplication1.Sistema.cancelarReserva;
import static javaapplication1.Sistema.carregarDados;
import static javaapplication1.Sistema.editar;
import static javaapplication1.Sistema.gerarExtrato;
import static javaapplication1.Sistema.incluir;
import static javaapplication1.Sistema.remover;
import static javaapplication1.Sistema.salvarDados;
import static javaapplication1.Sistema.criarReserva;
//import org.json.simple.JSONArray;;
//import org.json.simple.parser.ParseException;;

/**
 * Classe Pousada Milho Verde e vai ser responsável por executar nossos arquivos,
 * ela é o arquivo main do nosso programa.
 * @author rafar
 */
public class PousadaMilhoVerde {

    public static void main(String[] args) throws IOException, ParseException {
//        //Lista de clientes
//        List<Cliente> listaClientes = new ArrayList<>();
//        //Lista de funcionarios
//        List<Funcionario> funcionarios = new ArrayList<>();
//        //Lista de Reserva
//        List<Reserva> reserva = new ArrayList<>();
//        
//        //Cliente cliente1 = new Cliente("Rafael", "9830123", "Belo Horizonte", "339989021", "rafar@");
//        Cliente cliente2 = new Cliente("Getulio", "123.456.789-57", "Diamantina", "8021983", "getjose@");
//        Cliente cliente3 = new Cliente("Dudu", "123.456.789-57", "Diamantina", "389982356", "Duduvisitante@");
//        Funcionario func = new Funcionario("@rafa919", "123023","atendente","Rafael","123456789","Diamantina","3399833","RafaDias@");
//        Reserva reserva1 = new Reserva();
//        Reserva reserva2 = new Reserva();
//        
//        clienteComparator comparator = new clienteComparator();
//        ReservaComparator comparatorReserva = new ReservaComparator();
//        listaClientes.add(cliente2);
//        listaClientes.add(cliente3);
//        
//        //QUESTÃO 06
//        incluir(funcionarios,func);
//        editar(funcionarios,func);
//        remover(funcionarios,func);
//        
//        //QUESTÃO 07
//        incluir(listaClientes,cliente2);
//        editar(listaClientes,cliente3);
//        remover(listaClientes,cliente2);
//        
//        //QUESTÃO 08
//        reserva1.toString();
//        
//        realizarReserva(reserva,cliente2);
//        
//        System.out.println(reserva);
//
//        //QUESTÃO 10
//        gerarExtrato(reserva1);
//
//        //QUESTÃO 12
//        Sistema.numInstancias();
//        
//        //QUESTÃO 13
//        comparator.compare(cliente2,cliente3);
//        comparatorReserva.compare(reserva1, reserva2);
//    
//       //QUESTÃO 14
//       salvarDados(funcionarios,"Funcionarios.json");
//       
//       //QUESTÃO 15
//       //Está em todas as classes.
        Quarto[] quartos = Sistema.quartos;
        List<Reserva> listaReserva = new ArrayList<>();
        List<Cliente> listaClientes = new ArrayList<>();
        
        Cliente cliente1 = new Cliente("Getulio Santos","123.456.789-10","Diamantina","3899910234","getulio.santos@email");
        Cliente cliente3 = new Cliente("Dudu", "123.456.789-57", "Diamantina", "389982356", "Duduvisitante@");
        
        LocalDate data = LocalDate.of(2023, 7, 13);
        
        criarReserva(listaReserva,cliente1,"002",data);
        criarReserva(listaReserva,cliente1,"002",data);
        criarReserva(listaReserva,cliente1,"009",data);
        
        cancelarReserva(listaReserva,cliente1, "002");
        
        System.out.println(listaReserva);
        
        Sistema.FazerLogin("Getulio", "123456");
        
//        listaClientes = incluir(listaClientes,cliente1);
//        listaClientes = incluir(listaClientes,cliente3);
//        List<Funcionario> funcionarios = new ArrayList<>();
//        
//        funcionarios=carregarDados("Funcionarios.json", Funcionario.class);
//        LocalDate data = LocalDate.of(2023, 7, 13);
//        LocalDate data2 = LocalDate.of(2023, 7, 22);
//        
//        Reserva reserva1= new Reserva(data,quartos[0]);
//        Reserva reserva2= new Reserva(data2,quartos[1]);
//        listaReserva.add(reserva2);
//        listaReserva.add(reserva1);
//        
//        listaReserva=Sistema.excluirReserva(listaReserva,reserva1);
//        listaReserva= Sistema.excluirReserva(listaReserva,reserva2);
//        for (Reserva item : listaReserva) {
//        System.out.println(item);}

    }
}
    
