package elementos.basicos;

public class AnunciantePublico extends Anunciante{
    private String esfera;

    
    public AnunciantePublico(String esfera, String nome, CNPJ CNPJ, String senha) {
        super(nome, CNPJ, senha);
        this.esfera = esfera;
    }

    public String getEsfera() {
        return esfera;
    }

    public void setEsfera(String esfera) {
        this.esfera = esfera;
    }

    
}
