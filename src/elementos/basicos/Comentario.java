/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elementos.basicos;


public class Comentario {
    String conteudo;
    ClienteDigital autor;
    PublicacaoDig publicacao;
    private String identificacao;
    

    public Comentario(String conteudo, ClienteDigital autor, PublicacaoDig publicacao) {
        this.conteudo = conteudo;
        this.autor = autor;
        this.publicacao = publicacao;
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

    public ClienteDigital getAutor() {
        return autor;
    }

    public void setAutor(ClienteDigital autor) {
        this.autor = autor;
    }

    public PublicacaoDig getPublicacao() {
        return publicacao;
    }

    public void setPublicacao(PublicacaoDig publicacao) {
        this.publicacao = publicacao;
    }
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Comentario) {
            if (this.getIdentificacao().
                    equals(((Comentario) obj).getIdentificacao())) {
                return true;
            }
        }
        return false;
    }
}