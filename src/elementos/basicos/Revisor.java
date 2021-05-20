
package elementos.basicos;

import java.util.Date;

public class Revisor extends Funcionario{
    private float adicional;
    private int numErrosEncontrados;

    public Revisor(String nome, float salario, String CPF, Date dataNascimento, CarteiraTrabalho carteiraTrabalho, String senha) {
        super(nome, salario, CPF, dataNascimento, carteiraTrabalho, senha);
    }

    public float getAdicional() {
        return adicional;
    }

    public void setAdicional(float adicional) {
        this.adicional = adicional;
    }

    public int getNumErrosEncontrados() {
        return numErrosEncontrados;
    }

    public void setNumErrosEncontrados(int numErrosEncontrados) {
        this.numErrosEncontrados = numErrosEncontrados;
    }
    
    public void contadorErros(int erros){
        int erro = getNumErrosEncontrados() + erros;
        setNumErrosEncontrados(erro);
    }
    
    @Override
    public float calcularRemuneracao(){
        return salario + adicional;
    }
    public void calcularAdicional(float adicional){
        this.adicional = numErrosEncontrados*10;
    }
}
