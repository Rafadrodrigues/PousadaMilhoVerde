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
import static javaapplication1.Sistema.incluir;
import static javaapplication1.Sistema.realizarReserva;

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

        //testa inicialmente pra mostrar que os valores estão zerados
//        Sistema.numInstancias();
//        Sistema sis = new Sistema();


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
        
        
        listaClientes.add(cliente2);
        listaClientes.add(cliente3);
        incluir(listaClientes,cliente2);
        
        realizarReserva(reserva,cliente2);
        
        System.out.println(reserva);
        
//        Sistema.incluir(funcionarios, func);
//        Sistema.incluir(listaClientes,cliente2);
//        //LEMBRAR QUE PRA EDITAR O CPF TEM QUE ESTAR CORRETO
//        Sistema.editar(listaClientes, cliente3);
//         //Adicinando lista de clientes na base de dados
//
//        Bd.add(listaClientes);
//        Bd.add(funcionarios);
//
//        System.out.println(Bd);
//        //Funcionando corretamente
//        LocalDate data = LocalDate.of(2023, 5, 22);
//        //Mostra o numero das instancias ao fim da execução
//        Sistema.numInstancias();
//    
    }
}
