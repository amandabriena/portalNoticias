
package elementos.basicos;

import java.util.ArrayList;

public class ClienteDigital extends Cliente{
   private String email;
   private String login;
   //situacao será true se o cliente for pagante, caso contrário, será false;
   private boolean situacao = false;
   //estado será false se o cliente estiver bloqueado;
   private boolean estado = true;
    //Atributo contabiliza a quantidade de comentários não permitidos feitos pelo cliente;
    //Após 3 comentários irregulares, o cliente é bloqueado;
    private int numComentarioIrregulares = 0;
    private ArrayList<Comentario> comentarios;
    private static float valorMensal = 19.99f;

    public ClienteDigital(String email, String login, String nome, String senha) {
        super(nome, senha);
        this.email = email;
        this.login = login;
        comentarios = new ArrayList<Comentario>();
    }

    public ClienteDigital(String login, String nome, String senha) {
        super(nome, senha);
        this.login = login;
    }

    public static float getValorAssinatura() {
        return valorMensal;
    }

    public static void setValorAssinatura(float valorAssinatura) {
        ClienteDigital.valorMensal = valorAssinatura;
    }

    public ArrayList<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(ArrayList<Comentario> comentarios) {
        this.comentarios = comentarios;
    }
    
    public void adicionarComentario(Comentario comentario){
        comentarios.add(comentario);
    }
    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public int getNumComentarioIrregulares() {
        return numComentarioIrregulares;
    }

    public void setNumComentarioIrregulares(int numComentarioIrregulares) {
        this.numComentarioIrregulares = numComentarioIrregulares;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    

    public boolean isSituacao() {
        return situacao;
    }

    public void setSituacao(boolean situacao) {
        this.situacao = situacao;
    }
    
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof ClienteDigital){
            if(this.getLogin().
               equals(((ClienteDigital) obj).getLogin()))
            {
                return true;
            }
        }
        return false;
       }
}
