
package elementos.basicos;

import java.util.ArrayList;
import java.util.Date;

public class Mediador extends Funcionario{
    private ArrayList<ClienteDigital> clientes;
    private ArrayList<Comentario> comentariosReprovados;
    
    public Mediador(String nome, float salario, String CPF, Date dataNascimento, CarteiraTrabalho carteiraTrabalho, String senha) {
        super(nome, salario, CPF, dataNascimento, carteiraTrabalho, senha);
        clientes = new ArrayList<ClienteDigital>();
    }

    public ArrayList<ClienteDigital> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<ClienteDigital> clientes) {
        this.clientes = clientes;
    }
    public void adicionarCmReprovado(Comentario cm){
        comentariosReprovados.add(cm);
    }
    public void adicionarClienteBloqueado(ClienteDigital cl){
        clientes.add(cl);
    }
}
