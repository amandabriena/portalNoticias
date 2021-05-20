package elementos.basicos;

import excessoes.JaCadastrado;
import java.util.ArrayList;
import java.util.Date;

public class ChefeRedacao extends Funcionario {
    private ArrayList<Publicacao> publicacoesAvaliadas;

    public ChefeRedacao(String nome, float salario, String CPF, Date dataNascimento, CarteiraTrabalho carteiraTrabalho, String senha) {
        super(nome, salario, CPF, dataNascimento, carteiraTrabalho, senha);
        publicacoesAvaliadas = new ArrayList<Publicacao>();
    }

    public ArrayList<Publicacao> getPublicacoesAvaliadas() {
        return publicacoesAvaliadas;
    }

    public void setPublicacoesAvaliadas(ArrayList<Publicacao> publicacoesAvaliadas) {
        this.publicacoesAvaliadas = publicacoesAvaliadas;
    }

    public void avaliarPublicacao(Publicacao pub){
        if(!publicacoesAvaliadas.contains(pub)){
            publicacoesAvaliadas.add(pub);
        }
    }
    
    @Override
    public float calcularRemuneracao(){
        float acrescimo = 0;
        for(Publicacao pub: publicacoesAvaliadas){
            if(pub.getSituacao().equals("postada")){
                ArrayList<Anuncio> anuncios = pub.getAnuncios();
                for(Anuncio an: anuncios){
                   acrescimo = acrescimo + an.calcularValor(pub.getPeso());
                }
            }
        }
        acrescimo = acrescimo*0.05f;
        return salario+acrescimo;
    }
}
