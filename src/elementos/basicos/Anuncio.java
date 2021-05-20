
package elementos.basicos;

import java.util.Calendar;
import java.util.Date;

public class Anuncio {
    private String conteudo;
    protected int periodoExibicao;
    private String identificacao;

    public Anuncio(String conteudo, int tempoExibicao, String identificacao) {
        this.conteudo = conteudo;
        this.periodoExibicao = tempoExibicao;
        this.identificacao = identificacao;
    }

    public Anuncio(String conteudo, int tempoExibicao) {
        this.conteudo = conteudo;
        this.periodoExibicao = tempoExibicao;
        identificacao = "";
    }

    public int getPeriodoExibicao() {
        return periodoExibicao;
    }

    public void setPeriodoExibicao(int periodoExibicao) {
        this.periodoExibicao = periodoExibicao;
    }

    

    public Anuncio(String identificacao) {
        this.identificacao = identificacao;
    }

    public String getIdentificacao() {
        return identificacao;
    }

    public void setIdentificacao(String identificacao) {
        this.identificacao = identificacao;
    }

    
    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }
    public float calcularValor(float peso){
        return 0;
    }
    public boolean equals(Object obj) {
        if (obj instanceof Anuncio) {
            if (this.getIdentificacao().
                    equals(((Anuncio) obj).getIdentificacao())) {
                return true;
            }
        }
        return false;
    }
}
