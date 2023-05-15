package javaapplication1;

import java.util.ArrayList;
import java.util.List;
import static javaapplication1.Sistema.editar;
import static javaapplication1.Sistema.listaFuncionario;
import static javaapplication1.Sistema.incluir;
import static javaapplication1.Sistema.remover;

public class PousadaMilhoVerde {

    public static void main(String[] args) {

    Sistema sis = new Sistema();
    sis.FazerLogin("@rafa919", "123023");
    
    //Lista encadeada para o banco de dados onde vai ser inserida listas
    ArrayList<Object> Bd = new ArrayList<>();
    //Lista de clientes
    List<Cliente> listaClientes = new ArrayList<>();
    //Lista de funcionarios
    List<Funcionario> funcionario = new ArrayList<>();
    //Lista de Reserva
    List<Reserva> reserva = new ArrayList<>();
    
    //Pelo enunciado, talvez criar uma para os quartos
    Quarto quarto = new Quarto("001", 50, "Comum",false);
    Cliente cliente1 = new Cliente("Rafael", "9830123", "Belo Horizonte", "339989021", "rafar@");
    Cliente cliente2 = new Cliente("Getulio", "9830123", "Diamantina", "8021983", "getjose@");
    Cliente cliente3 = new Cliente("Dudu", "123.456.789-57", "Diamantina", "389982356", "Duduvisitante@");

  
    incluir(listaClientes,cliente1);
    editar(listaClientes,cliente2);
    //remover(listaClientes,cliente2);
    
     //Adicinando lista de clientes na base de dados
    Bd.add(listaClientes);
    Bd.add(listaFuncionario());
    
    System.out.println(Bd);
    //Funcionando corretamente
    }
}
