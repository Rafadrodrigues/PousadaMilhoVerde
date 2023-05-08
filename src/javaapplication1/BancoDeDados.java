package javaapplication1;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

import org.json.simple.JSONObject;

public class BancoDeDados {

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
            
            arquivoJson.write(cliente.toJSONString()+ "\n");
            arquivoJson.flush();
            arquivoJson.close();
            
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(BancoDeDados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
    public void inserirFuncionario(String usuario, String senha, String cargo, String nome, String cpf, String endereco, int telefone, String acesso){
        
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
//    public boolean procurarCliente(){
//
//    }

    //Método que é responsável por inserir a data no banco de dados
    public void inserirData(LocalDate data,String horario){
        
        JSONObject reserva = new JSONObject();
        
        reserva.put("Data da Reserva", data);
        reserva.put("Horário", horario);

        
        try(FileWriter arquivoJson = new FileWriter("Reserva.json")){
            
            arquivoJson.write(reserva.toJSONString()+ "\n");
            arquivoJson.flush();
            arquivoJson.close();
            
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(BancoDeDados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
}
