
package elementos.basicos;

import java.util.Date;

public class AnuncioDigital extends Anuncio{
    private int numCliques = 0;
    private int numVisualizacoes =0;
    private static float valorbase = 100.00f;

    public AnuncioDigital(String conteudo, int tempoExibicao, String identificacao) {
        super(conteudo, tempoExibicao, identificacao);
    }

    public AnuncioDigital(String conteudo, int tempoExibicao) {
        super(conteudo, tempoExibicao);
    }

    public static float getValorbase() {
        return valorbase;
    }

    public static void setValorbase(float valorbase) {
        AnuncioDigital.valorbase = valorbase;
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
    @Override
    public float calcularValor(float peso){
        float valorAnuncio = valorbase *(1+periodoExibicao/5)*(1+peso);
        if(numCliques != 0) valorAnuncio = valorAnuncio * (1 + (numCliques * 0.002f));
        if(numVisualizacoes!=0) valorAnuncio = valorAnuncio *(1 + (numVisualizacoes * 0.002f));
        return valorAnuncio;
    }
}
