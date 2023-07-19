package javaapplication1;

import java.io.IOException;
import java.text.ParseException;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Classe Pousada Milho Verde e vai ser responsável por executar nossos
 * arquivos, ela é o arquivo main do nosso programa.
 *
 * @author Rafael Dias Rodrigues
 * @author Getulio José Lima dos Santos
 */
public class PousadaMilhoVerde {

    public static void main(String[] args) throws IOException, ParseException {
        Sistema sistema = new Sistema();

        //QUESTÃO 1
        //IMPLEMENTAMOS TODOS AS CLASSES E METODOS QUE PLANEJAVAMOS
        //REMODELAMOS DE ACORDO COM AS ALTERAÇÕES
        //E CRIAMOS OS NOVOS FLUXOS
        //E ATUALIZAMOS NOSSO DIAGRAMA DE CLASSE, TUDO ESTA PRESENTE NO LATEX
        //QUESTÃO 2
        //1- CRIAMOS NOSSSAS CLASSES DE ACORDO COM O LATEX MAS NOVAS ALTERAÇÕES FORAM NECESSÁRIAS
        //2- POR MEIO DO MÉTODO LOGIN APENAS OS FUNCIONARIOS CADASTRADOS PODEM ACESSAR O SISTEMA
        sistema.FazerLogin("getulio", "123456");
        //3-TODOS OS METODOS TO STRING ESTÃO SOBRECARREGADO
        Cliente cliente = new Cliente("Rafa", "1245678900", "Diamantina", "134567890", "rafa@email");
        Funcionario func = new Funcionario("Rafa", "1243023", "Rafael", "14612312399",
                 "Diamantina", "3198198182", "rafa@email");
        cliente.toString();
        //4- AS SUBCLASSES JÁ ESTÃO COM O SUPER IMPLANTADOS
        sistema.criarAdministrador("getulio", "123456", "getulio santos", "14612312399",
                 "diamantina", "389980385", "getulio.santos@email", 3000);
        //5-NA CLASSE DO SISTEMA JA ESTA SALVO OS 10 QUARTOS
        //6-É POSSIVEL ADICIONAR,EDITAR E REMOVER OS FUNCIONARIOS NO SISTEMA
        sistema.criarFuncionario("Rafael", "123231", "Rafael Dias", "14612313341", "diamantina",
                 "389980385", "rafael.dias@email", 1200);
        sistema.editarFuncionario(func);
        sistema.removerFuncionario(func);
        //7-DA MESMA FORMA QUE COM O CLIENTE
        sistema.criarCliente("Getulio", "134567890", "Diamantina", "389980181", "getulio@email", "256512537");
        sistema.editarCliente(cliente);
        sistema.removerCliente(cliente);
        //8-as reserva podem ser imprimidas pelo extrato
        sistema.criarReserva("123.456.789-57", "2023-07-19", "2023-07-19", "008");
        sistema.confirmarReserva("2023-07-19", "2023-07-19", "008");
        sistema.cancelarReserva("2023-07-19", "2023-07-19", "008");
        System.out.print("\n" + sistema.getListaReserva().get(0).Extrato());
        //9- ESTÃO SENDO SALVA EM ARRAY LIST
        //10 - AS RESERVAS JÁ SÃO SALVAS COM OS CLIENTES
        //11- NAS CLASSES DA CLIENTE E RESERVA JA POSSUEM OS ATRIBUTOS PROTECT E STATIC PARA SABER O NUMERO DE INSTANCIAS
        //12- PODE SER OBTER OS NUMEROS DE INSTANCIAS NA EXECUÇÃO
        Sistema.numInstancias();
        //13- AS CLASSES CLIENTE E RESERVA COMPARATOR
        //14- A TRAVEZ DOS METODOS DE SALVAR E CARREGAR OS DADOS PODEM SER LIDOS DOS ARQUIVOS JSON
        List<Cliente> listaClientes = Sistema.carregarDados("Clientes.json", Cliente.class);
        //15- OS METODOS JA POSSUEM O COMENTARIO PARA DOCUMENTAÇÃO
        //QUESTÃO 3
        //15-INTERATOR PARA PERCORRER OS ARRAYLIST
        Iterator<Cliente> iterator = listaClientes.iterator();
        Iterator<Cliente> iterator2 = listaClientes.iterator();
        clienteComparator comparator = new clienteComparator();
        //16- METODO FIND PARA ENCONTRAR O MENOR VALOR DA LISTA
        System.out.print("\nMenor valor na lista"+Sistema.find(iterator2, comparator).toString());
        System.out.print("\nLista inicial");
        
        while (iterator.hasNext()) {
            Cliente aux = iterator.next();
            System.out.print("\n" + aux.toString());
        }
        //16-METDODO SORT DA COLLECTION
        Collections.sort(listaClientes,comparator );
        System.out.print("\nEla ordenada\n"+listaClientes);
        Collections.sort(listaClientes,comparator.reversed() );
        System.out.print("\nOrdenadaInversa\n"+listaClientes);
        System.out.print("\nO financeiro: "+Sistema.calcularFaturamento());
 
    }
}