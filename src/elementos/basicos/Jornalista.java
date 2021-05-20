
package elementos.basicos;

import excessoes.JaCadastrado;
import java.util.ArrayList;
import java.util.Date;

public class Jornalista extends Funcionario{
    private float adicional;
    private ArrayList<Publicacao> publicacoes;

    public Jornalista(String nome, float salario, String CPF, Date dataNascimento, CarteiraTrabalho carteiraTrabalho, String senha) {
        super(nome, salario, CPF, dataNascimento, carteiraTrabalho, senha);
        publicacoes = new ArrayList<Publicacao>();
    }
    
    @Override
    public float calcularRemuneracao(){
        return salario * (1 + adicional);
    }
    public void calcularAdicional(float adicional){
        float pesoTotal=0;
        for(Publicacao pub : publicacoes){
            pesoTotal = pesoTotal + pub.getPeso();
        }
        this.adicional = pesoTotal/publicacoes.size();
    }
    
    public void cadastrarPublicacao(Publicacao pub) throws JaCadastrado{
        if (!publicacoes.contains(pub)) {
                publicacoes.add(pub);
            }else throw new JaCadastrado();
    }
}
