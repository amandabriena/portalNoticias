
package elementos.basicos;

import java.util.Date;

public class AnuncioImpDig extends Anuncio{
    private int numCliques = 0;
    private int numVisualizacoes = 0;
    private int numExemplares = 0;
    private static float valorbase = 130.00f;

    public AnuncioImpDig(String conteudo, int tempoExibicao, String identificacao) {
        super(conteudo, tempoExibicao, identificacao);
        
    }

    public AnuncioImpDig(String conteudo, int tempoExibicao) {
        super(conteudo, tempoExibicao);
    }

    public int getNumCliques() {
        return numCliques;
    }

    public void setNumCliques(int numCliques) {
        this.numCliques = numCliques;
    }

    public int getNumVisualizacoes() {
        return numVisualizacoes;
    }

    public void setNumVisualizacoes(int numVisualizacoes) {
        this.numVisualizacoes = numVisualizacoes;
    }

    public int getNumExemplares() {
        return numExemplares;
    }

    public void setNumExemplares(int numExemplares) {
        this.numExemplares = numExemplares;
    }

    public static float getValorbase() {
        return valorbase;
    }

    public static void setValorbase(float valorbase) {
        AnuncioImpDig.valorbase = valorbase;
    }

    
    @Override
    public float calcularValor(float peso){
        float valorAnuncio = valorbase *(periodoExibicao/ 5)*(1+peso);
        if(numCliques != 0) valorAnuncio = valorAnuncio * (1 + (numCliques * 0.002f));
        if(numVisualizacoes!=0) valorAnuncio = valorAnuncio *(1 + (numVisualizacoes * 0.002f));
        if (numExemplares!=0) valorAnuncio = valorAnuncio * (1 + (numExemplares * 0.002f));
        return valorAnuncio;
            
    }
}
