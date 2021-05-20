package elementos.basicos;

import java.util.Date;

public class Funcionario {
    private String nome;
    protected float salario;
    private String CPF;
    private Date dataNascimento;
    private CarteiraTrabalho carteiraTrabalho;
    protected String senha;

    public Funcionario(String nome, float salario, String CPF, Date dataNascimento, CarteiraTrabalho carteiraTrabalho, String senha) {
        this.nome = nome;
        this.salario = salario;
        this.CPF = CPF;
        this.dataNascimento = dataNascimento;
        this.carteiraTrabalho = carteiraTrabalho;
        this.senha = senha;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Funcionario(CarteiraTrabalho carteiraTrabalho) {
        this.carteiraTrabalho = carteiraTrabalho;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public CarteiraTrabalho getCarteiraTrabalho() {
        return carteiraTrabalho;
    }

    public void setCarteiraTrabalho(CarteiraTrabalho carteiraTrabalho) {
        this.carteiraTrabalho = carteiraTrabalho;
    }

    
    public float calcularRemuneracao(){
        return salario;
    }
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Funcionario){
            if(this.getCarteiraTrabalho().getNumero().
               equals(((Funcionario) obj).getCarteiraTrabalho().getNumero()))
            {
                return true;
            }
        }
        return false;
       }
}
