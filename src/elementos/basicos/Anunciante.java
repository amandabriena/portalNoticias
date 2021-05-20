package elementos.basicos;

import Utilitario.GeradorCodigos;
import excessoes.JaCadastrado;
import excessoes.NaoExiste;
import java.util.ArrayList;

public class Anunciante {

    private String nome;
    protected ArrayList<Anuncio> anuncios;
    private CNPJ CNPJ;
    private float valorPagamento;
    private String senha;

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Anunciante(String nome, CNPJ CNPJ, String senha) {
        this.nome = nome;
        this.CNPJ = CNPJ;
        this.senha = senha;
        anuncios = new ArrayList<Anuncio>();
    }

    public float getValorPagamento() {
        return valorPagamento;
    }

    public void setValorPagamento(float valorPagamento) {
        this.valorPagamento = valorPagamento;
    }


    public Anunciante(CNPJ CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Anuncio> getAnuncios() {
        return anuncios;
    }

    public void setAnuncios(ArrayList<Anuncio> anuncios) {
        this.anuncios = anuncios;
    }

    public CNPJ getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(CNPJ CNPJ) {
        this.CNPJ = CNPJ;
    }

    public void cadastrarAnuncio(Anuncio anuncioNovo) throws JaCadastrado {
        if (!anuncios.contains(anuncioNovo)) {
            String identificacao = GeradorCodigos.gerarCodigo();
            anuncioNovo.setIdentificacao(identificacao);
            anuncios.add(anuncioNovo);
        } else {
            throw new JaCadastrado();
        }
    }

    public void removerAnuncio(Anuncio anuncio) throws NaoExiste {
        if (anuncios.contains(anuncio)) {
            anuncios.remove(anuncio);
        } else {
            throw new NaoExiste();
        }
    }

    public Anuncio buscarAnuncio(String identificacao) throws NaoExiste {
        Anuncio anuncioBuscado = new Anuncio(identificacao);
        int indice = anuncios.indexOf(anuncioBuscado);
        if (indice >= 0) {
            return anuncios.get(indice);
        } else throw new NaoExiste();
    }
    
    public void atualizarAnuncio(Anuncio anuncioAtu) throws NaoExiste, JaCadastrado{
        Anuncio an = buscarAnuncio(anuncioAtu.getIdentificacao());
        removerAnuncio(an);
        cadastrarAnuncio(anuncioAtu);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Anunciante) {
            if (this.getCNPJ().getNumero().
                    equals(((Anunciante) obj).getCNPJ().getNumero())) {
                return true;
            }
        }
        return false;
    }
}
