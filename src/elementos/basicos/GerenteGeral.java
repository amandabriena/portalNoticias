/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elementos.basicos;

import java.util.Date;

public class GerenteGeral extends Funcionario{
    
    public GerenteGeral(String nome, float salario, String CPF, Date dataNascimento, CarteiraTrabalho carteiraTrabalho, String senha) {
        super(nome, salario, CPF, dataNascimento, carteiraTrabalho, senha);
    }
    
}
