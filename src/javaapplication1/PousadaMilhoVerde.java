package javaapplication1;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PousadaMilhoVerde {

    public static void main(String[] args) throws FileNotFoundException {
    //Lista encadeada para o banco de dados onde vai ser inserida listas
    ArrayList<Object> Bd = new ArrayList<>();
    Bd = (ArrayList<Object>) Sistema.carregarDados();
    //System.out.print(Bd);
    //    //Lista de clientes
    List<Cliente> listaClientes = new ArrayList<>();
    //Cliente cliente1 = new Cliente("Rafael", "9830123", "Belo Horizonte", "339989021", "rafar@");
    

//    //Lista de funcionarios
//    List<Funcionario> funcionarios = new ArrayList<>();
//    //Lista de Reserva
//    List<Reserva> reserva = new ArrayList<>();

//    Cliente cliente2 = new Cliente("Getulio", "123.456.789-57", "Diamantina", "8021983", "getjose@");
//    Cliente cliente3 = new Cliente("Dudu", "123.456.789-57", "Diamantina", "389982356", "Duduvisitante@");
//    Funcionario func = new Funcionario("@rafa919", "123023","atendente","Rafael","123456789","Diamantina","3399833","RafaDias@");
//    Sistema.incluir(funcionarios, func);
//    Sistema.incluir(listaClientes,cliente2);
//    //LEMBRAR QUE PRA EDITAR O CPF TEM QUE ESTAR CORRETO
//    Sistema.editar(listaClientes, cliente3);
//     //Adicinando lista de clientes na base de dados
//    Bd.add(listaClientes);
//    Bd.add(funcionarios);
//    Sistema.salvarDados(Bd);
    //System.out.println(Bd);
    //Funcionando corretamente
    //LocalDate data = LocalDate.of(2023, 5, 22);

    
    }
}
