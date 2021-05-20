
package elementos.basicos;

import java.util.Date;

public class AnuncioImpresso extends Anuncio{
    private int numExemplares = 0;
    private static float valorbase = 60.00f;

    public AnuncioImpresso(String conteudo, int tempoExibicao, String identificacao) {
        super(conteudo, tempoExibicao, identificacao);
    }

    public AnuncioImpresso(String conteudo, int tempoExibicao) {
        super(conteudo, tempoExibicao);
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
        AnuncioImpresso.valorbase = valorbase;
    }

    @Override
    public float calcularValor(float peso){
        float valorAnuncio = valorbase*(periodoExibicao/ 5)*(1+peso);
            if (numExemplares!=0) valorAnuncio = valorAnuncio * (1 + (numExemplares * 0.002f));
            return valorAnuncio;
    }
}
