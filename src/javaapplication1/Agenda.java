package javaapplication1;

import java.time.LocalDate;

public class Agenda {
    //Atributos da classe agenda, alguns podem ser retirados posteriormente.
    //Acho que o calendario deve ser tipo list,conferir
    private LocalDate data;
<<<<<<< HEAD
    private String anotacoes;
    
    //Construtor para iniciar todos os estados da classe 
    public Agenda(LocalDate data, String anotacoes) {
=======
    private int horario;
    private String anotacoes;
    
    //Construtor para iniciar todos os estados da classe 
    public Agenda(LocalDate data, int horario, String anotacoes) {
>>>>>>> 70797bfbb22ec0028daa09ecd038c6e91cf4b1a2
        this.data = data;
        this.anotacoes = anotacoes;
    }
    //Construtor especifico para verificacoes
<<<<<<< HEAD
    public Agenda(LocalDate data) {
=======
    public Agenda(LocalDate data, int horario) {
>>>>>>> 70797bfbb22ec0028daa09ecd038c6e91cf4b1a2
        this.data = data;
        //talvez eu retire um construtor
    }
    
    //Getters e setters correspondente aos atributos criados nessa classe.
    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

<<<<<<< HEAD
=======
    public int getHorario() {
        return horario;
    }

    public void setHorario(int horario) {
        this.horario = horario;
    }

>>>>>>> 70797bfbb22ec0028daa09ecd038c6e91cf4b1a2
    public String getAnotacoes() {
        return anotacoes;
    }

    public void setAnotacoes(String anotacoes) {
        this.anotacoes = anotacoes;
    }
 
    //Método responsável por receber data e comparar disponibilidade
<<<<<<< HEAD
    public LocalDate armazenarData(LocalDate dataCliente){
        
        //Data informada pelo cliente
        System.out.println("Data: " + dataCliente);
        //O funcionário vê a data informada pelo cliente e digita no sistema
=======
    public LocalDate verificarAgenda(LocalDate clienteData,int horario){
        
>>>>>>> 70797bfbb22ec0028daa09ecd038c6e91cf4b1a2
        LocalDate localDate = LocalDate.now();
        
        //Pegando a data informada pelo cliente
        System.out.println("Dia da semana: " + localDate.getDayOfWeek().ordinal());
        System.out.println("Mes: " + localDate.getMonthValue());
        System.out.println("Ano: " + localDate.getYear());
        System.out.println("A data informada é " + localDate);

        /*Vai ser preciso acessar os dados armazenados no Json para verificação 
        e após isso, uma condicional para realizar a validação das datas */

        return localDate;

    }
<<<<<<< HEAD
    //Métodos responsável por receber a resposta do bd sobre disponibilidade.
    public void verificarAgenda(LocalDate dataCliente) {
        
        //Aqui vai ser preciso solicitar o sistema faça uma verificação no arquivo json
        BancoDeDados bd = new BancoDeDados();
        //Atribuindo a resposta do bd para  uma variável 
        boolean resposta = bd.conferirData(dataCliente);
        
        //Condicional para apresentar a resposta
        if (!resposta){
            System.out.print("\nNão tem disponibilidade nessa data.");
        }else{
            System.out.print("\nTem disponibilidade nessa data.");
        }
    }
=======
    
>>>>>>> 70797bfbb22ec0028daa09ecd038c6e91cf4b1a2
}
