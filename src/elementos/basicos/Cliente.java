package elementos.basicos;

import java.util.Objects;

public class Cliente {
    protected String nome;
    private String senha;
    //Se o cliente, seja ele digital ou físico, estiver com o pagamento da assinatura em dia, pagamentoEmDia será true
    //Caso contrário, é modificado para false;
    private boolean pagamentoEmDia = true;
    public Cliente(String nome) {
        this.nome = nome;
    }

    public Cliente(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isPagamentoEmDia() {
        return pagamentoEmDia;
    }

    public void setPagamentoEmDia(boolean pagamentoEmDia) {
        this.pagamentoEmDia = pagamentoEmDia;
    }

    

}
