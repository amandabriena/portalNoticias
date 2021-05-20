
package elementos.basicos;

import java.util.ArrayList;

public class PublicacaoDig extends Publicacao{
    private ArrayList<Comentario> comentarios;
    // estado será true, se a publicação for paga, caso contrário, será false
    private boolean estado = false;
    private int numVisualizacoes;

    public PublicacaoDig(String titulo, String conteudo, String categoria, String identificacao, String CTPSJornalista, String situacao, String tipo) {
        super(titulo, conteudo, categoria, identificacao, CTPSJornalista, situacao, tipo);
        comentarios = new ArrayList<Comentario>();
    }

    

    public int getNumVisualizacoes() {
        return numVisualizacoes;
    }

    public void setNumVisualizacoes(int numVisualizacoes) {
        this.numVisualizacoes = numVisualizacoes;
    }

    public PublicacaoDig(String identificacao) {
        super(identificacao);
    }

    
    public ArrayList<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(ArrayList<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    public void adicionarComentario(Comentario comentario){
        comentarios.add(comentario);
    }
    public void removerComentario(Comentario c){
        if(comentarios.contains(c)){
            comentarios.remove(c);
        }
    }
    public String listarComentarios(){
        String resultado = "";
        if(comentarios.size()!=0){
            for (Comentario coment : comentarios) {
            resultado = resultado + coment.getAutor().getLogin()+":" + "\n"+
                    coment.getConteudo() + "\n\n-------------------------------------------------------------------------------------------------\n";
        }return resultado;
        }else return resultado;
    }
}
