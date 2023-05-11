package javaapplication1;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.io.FileReader;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import org.json.simple.parser.ParseException;

//Classe BD que vai armazenar os dadso
public class BancoDeDados {
    
    public void lerArquivo(){
        	JSONObject jsonObject;
		//Cria o parse de tratamento
		JSONParser parser = new JSONParser();
		//Variaveis que irao armazenar os dados do arquivo JSON
		String Nome, CPF , Endereco, Conta,Idade, Telefone;;
          
		try {
			//Salva no objeto JSONObject o que o parse tratou do arquivo
			jsonObject = (JSONObject) parser.parse(new FileReader(
					"Clientes.json"));

			//Salva nas variaveis os dados retirados do arquivo
			Nome = (String) jsonObject.get("Nome");
			CPF = (String) jsonObject.get("CPF");
			Idade = (String) jsonObject.get("Idade");
			Endereco = (String) jsonObject.get("Endereço");
                        Telefone = (String) jsonObject.get("Telefone");
                        Conta = (String) jsonObject.get("Conta");
			System.out.printf(
					"Nome: %s\nCPF: %s\nIdade: %s\nEndereco: %s\n",
					Nome, CPF, Idade, Endereco);
		}
		//Trata as exceptions que podem ser lançadas no decorrer do processo
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    public void inserirCliente(String name, String cpf,String idade,
        String endereco,String telefone,String conta){
                JSONObject cliente = new JSONObject();
    }

    public void inserirCliente(String name, String cpf,int idade,
        String endereco,int telefone,String conta){
        
        JSONObject cliente = new JSONObject();

        cliente.put("Nome", name);
        cliente.put("CPF", cpf);
        cliente.put("Idade", idade);
        cliente.put("Endereço" ,endereco);
        cliente.put("Telefone" , telefone);
        cliente.put("Conta" , conta);
        
        try(FileWriter arquivoJson = new FileWriter("Clientes.json")){
            
            arquivoJson.write(cliente.toJSONString());
            arquivoJson.flush();
            arquivoJson.close();
            
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(BancoDeDados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }


    public void inserirFuncionario(String usuario, String senha, String cargo, String nome, String cpf, String endereco, String telefone, String acesso){
        
  
    }
    //Métodos responsável por inserir os funcionários na base de dados
   public void inserirFuncionario(String usuario, String senha, String cargo, String nome, String cpf, String endereco, String telefone, String acesso){
        JSONObject funcionario = new JSONObject();
        
        funcionario.put("Usuario", usuario);
        funcionario.put("Senha", senha);
        funcionario.put("CPF", cpf);
        funcionario.put("Endereço" ,endereco);
        funcionario.put("Telefone" , telefone);
        funcionario.put("Cargo" , cargo);
        funcionario.put("Acesso", acesso);
        
        try(FileWriter arquivoJson = new FileWriter("Funcionarios.json")){
            arquivoJson.write(funcionario.toJSONString());
            arquivoJson.flush();
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(BancoDeDados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    //Método que é responsável por inserir a data no banco de dados
    public void inserirData(LocalDate data,float preco){
        
        //Criamos um objeto do JSON
        JSONObject reserva = new JSONObject();
        
        //Inserindo os dados na base de dados
        reserva.put("Data da Reserva", data);
        reserva.put("Preço", preco);
        //Usamos um try para caso ocorra alguma erro na inserção.
        try(FileWriter arquivoJson = new FileWriter("Reserva.json")){
            
            //Dado foi escrito na base de dados.
            //Acho que devo chamar o método conferiri data antes de inserir
            arquivoJson.write(reserva.toJSONString());
            arquivoJson.flush();
            arquivoJson.close();
            
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(BancoDeDados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
    //Método que é responsável por conferir a data no banco de dados
      public boolean conferirData(LocalDate data){
        //Nesse arquivo é feito a verificaçao se tem disponibilidade
        JSONObject jsonObject;
        JSONParser reserva = new JSONParser();
        //Código retirado do site da Devmidia
        //Esse código é preciso pegar o retorno dele ou acrescentar em alguam canto
        try{
            jsonObject = (JSONObject) reserva.parse(new FileReader("saida.json"));
            data = (LocalDate) jsonObject.get("Data da Reserva");
            return true;
        
        } catch (FileNotFoundException e) {
                e.printStackTrace();
        } catch (IOException e) {
                e.printStackTrace();
        } catch (ParseException e) {
            // TODO Auto-generated catch block
        e.printStackTrace();
        }
        return false;
     }
}
