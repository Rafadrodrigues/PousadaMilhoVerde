package javaapplication1;

import java.util.ArrayList;
import java.util.List;
import static javaapplication1.Sistema.ListaFuncionario;

public class PousadaMilhoVerde {

    public static void main(String[] args) {

//        BancoDeDados BD = new BancoDeDados();
//        BD.inserirCliente("Getulio", "123456789", "21", "Diamantina", "38998", "202020");
//        BD.lerArquivo();
          //Cria um array list para salvar os funcionarios
          //List<Funcionario> Colaboradores = new ArrayList<Funcionario>();
        /*List<Funcionario> Colaboradores = new ArrayList<>();
        Funcionario func = new Funcionario("@rafa919", "123023", "Atendente",
                "Rafael", "9830123", "Diamantina", "339989021", "rafar@");
        //Precisa fazer o mesmo para a classe adm que vai ser criada
        Administrador adm = new Administrador("@getulio123", "312083", "Adm",
                "Getulio", "2113123", "Diamantina", "8021983", "getjose@");

        //salvar os objetos na lista;
        Colaboradores.add(func);
        Colaboradores.add(adm);
        
       */
        Sistema sis = new Sistema();
        sis.FazerLogin("@rafa919", "123023");
            ArrayList<Object> Bd = new ArrayList<>();
    List<Cliente> clientes = new ArrayList<>();
    Cliente cliente1 = new Cliente("Rafael", "9830123", "Diamantina", "339989021", "rafar@");
    Cliente cliente2 = new Cliente("Getulio", "2113123", "Diamantina", "8021983", "getjose@");
    Cliente cliente3 = new Cliente("Dudu", "123.456.789-57", "Diamantina", "389982356", "Duduvisitante@");
    
    clientes.add(cliente3);
     clientes.add(cliente2);
      clientes.add(cliente1);
      
    Bd.add(clientes);
    //Bd.add(Colaboradores);

    ListaFuncionario();


    }
}
