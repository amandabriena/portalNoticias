package elementos.basicos;
import excessoes.JaCadastrado;
import excessoes.NaoExiste;
import java.util.ArrayList;
import java.util.Collections;

public class Publicacao {
    protected String titulo;
    protected String conteudo;
    private String categoria;
    private int peso;
    private float valor;
    private String identificacao;
    private String CTPSJornalista;
    //situacao será "escrita" se apenas tiver sido escrita pelo jornalista, "editada" se tiver passado pelo editor,
    //"revisada" se tiver passado pelo revisor e "publicada", "aprovada", "reprovada" ou "arquivada", após a decisão do Chefe de Redação
    private String situacao;
    private ArrayList<Anuncio> anuncios;
    private float qtErros;
    //O tipo pode ser matéria ou notícia
    private String tipo;

    public Publicacao(String identificacao) {
        this.identificacao = identificacao;
    }

    public Publicacao(String titulo, String conteudo, String categoria, String CTPSJornalista, String situacao, String tipo) {
        this.titulo = titulo;
        this.conteudo = conteudo;
        this.categoria = categoria;
        this.CTPSJornalista = CTPSJornalista;
        this.situacao = situacao;
        this.tipo = tipo;
        peso = 0;
        anuncios = new ArrayList<Anuncio>();
    }


    public Publicacao(String titulo, String conteudo, String categoria, String identificacao, String CTPSJornalista, String situacao, String tipo) {
        this.titulo = titulo;
        this.conteudo = conteudo;
        this.categoria = categoria;
        this.identificacao = identificacao;
        this.CTPSJornalista = CTPSJornalista;
        this.situacao = situacao;
        this.tipo = tipo;
        peso =0;
        anuncios = new ArrayList<Anuncio>();
    }

    public float getQtErros() {
        return qtErros;
    }

    public void setQtErros(float qtErros) {
        this.qtErros = qtErros;
    }
   
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    

    public ArrayList<Anuncio> getAnuncios() {
        return anuncios;
    }

    public void setAnuncios(ArrayList<Anuncio> anuncios) {
        this.anuncios = anuncios;
    }

    
    public String getCTPSJornalista() {
        return CTPSJornalista;
    }

    public void setCTPSJornalista(String CTPSJornalista) {
        this.CTPSJornalista = CTPSJornalista;
    }

    public String getSituacao() {
        return situacao;
    }

    
    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
        
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }


    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    
    
    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getIdentificacao() {
        return identificacao;
    }

    public void setIdentificacao(String identificacao) {
        this.identificacao = identificacao;
    }
    public void adicionarAnuncio(Anuncio anuncio) throws JaCadastrado{
        if(!anuncios.contains(anuncio)){
            anuncios.add(anuncio);
        }else throw new JaCadastrado();
    }
    public Anuncio buscarAnuncio(String identificacao) throws NaoExiste {
            Anuncio anuncioBuscado = new Anuncio(identificacao);
        int indice = anuncios.indexOf(anuncioBuscado);
        if (indice >= 0) {
            return anuncios.get(indice);
        } else throw new NaoExiste();
        }
    public void removerAnuncio(String CNPJ) throws NaoExiste{
           Anuncio anuncio = new Anuncio(identificacao);
        if (anuncios.contains(anuncio)) {
            anuncios.remove(anuncio);
        } else throw new NaoExiste();
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Publicacao) {
            if (this.getIdentificacao().
                    equals(((Publicacao) obj).getIdentificacao())) {
                return true;
            }
        }
        return false;
    }
    public String retornarAnuncios(){
        String resultado = "";
        for(Anuncio a : anuncios){
            resultado = resultado + a.getConteudo()+ "\n\n";
        }
        return resultado;
    }
    public Anuncio retornarAnuncioAleatorio(){
        ArrayList<Anuncio> anunciosP = anuncios;
            Collections.shuffle(anunciosP);
            for(Anuncio a: anunciosP){
                return a;
            }
            return null;
    }
}
