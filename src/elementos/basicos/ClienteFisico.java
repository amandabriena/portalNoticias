
package elementos.basicos;

import java.util.Date;


public class ClienteFisico extends Cliente{
    private static float valorMensal = 15.99f;
    private String endereco;
    private String CPF;
    //assinatura será true se estiver ativa, caso contrário, será false
    private boolean assinatura;

    public ClienteFisico(String CPF, String nome, String senha) {
        super(nome, senha);
        this.CPF = CPF;
    }

    public ClienteFisico(String endereco, String CPF, String nome, String senha) {
        super(nome, senha);
        this.endereco = endereco;
        this.CPF = CPF;
    }

    public boolean isAssinatura() {
        return assinatura;
    }

    public void setAssinatura(boolean assinatura) {
        this.assinatura = assinatura;
    }
    

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public static float getValorMensal() {
        return valorMensal;
    }

    public static void setValorMensal(float valorMensal) {
        ClienteFisico.valorMensal = valorMensal;
    }

    

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof ClienteFisico){
            if(this.getCPF().
               equals(((ClienteFisico) obj).getCPF()))
            {
                return true;
            }
        }
        return false;
       }
    }
