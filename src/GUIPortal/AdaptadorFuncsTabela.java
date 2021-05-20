/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIPortal;
import elementos.basicos.CarteiraTrabalho;
import elementos.basicos.ChefeRedacao;
import elementos.basicos.Editor;
import elementos.basicos.Funcionario;
import elementos.basicos.GerenteGeral;
import elementos.basicos.GerenteRH;
import elementos.basicos.Jornalista;
import elementos.basicos.Mediador;
import elementos.basicos.Revisor;
import excessoes.NumeroCTPSInvalido;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

public class AdaptadorFuncsTabela extends AbstractTableModel{
    private String [] nomesColunas = {"Nome", "Salário", "CPF", "Data de Nascimento", "CTPS", "Cargo"};
    private ArrayList<Funcionario> funcionarios;

    public AdaptadorFuncsTabela(ArrayList<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    
    @Override
    public String getColumnName(int column) {
      if (column >= 0 && column <nomesColunas.length) 
          return nomesColunas[column];
      else 
          return "";
    }
    
    @Override
    public int getRowCount() {
        return funcionarios.size();
    }
    
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Funcionario f = funcionarios.get(rowIndex);
        switch(columnIndex){
            case 0:
                f.setNome(aValue.toString());
                break;
                
            case 1:
                f.setSalario((float) aValue);
                break;
            case 2:
                f.setCPF(aValue.toString());
                break;
            case 3:
                f.setDataNascimento((Date) aValue);
                break;
            case 4:
                CarteiraTrabalho ct;
                try {
                    ct = new CarteiraTrabalho((String) aValue);
                    f.setCarteiraTrabalho(ct);
                } catch (NumeroCTPSInvalido ex) {
                    Logger.getLogger(AdaptadorFuncsTabela.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case 5:
                break;
        }
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
      return true; 
    }
    
    @Override
    public int getColumnCount() {
        return nomesColunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Funcionario f = funcionarios.get(rowIndex);
      switch(columnIndex){
          case 0:
                return f.getNome();
            case 1:
                return Float.toString(f.getSalario());
            case 2:
                return f.getCPF();
            case 3:
                Date dataNascimento = f.getDataNascimento();
                SimpleDateFormat formatador = new SimpleDateFormat("dd/mm/yyyy");
                return formatador.format(dataNascimento);
            case 4:
                return f.getCarteiraTrabalho().getNumero();
            case 5:
                if(f instanceof Jornalista) return "Jornalista";
                else if (f instanceof Editor) return "Editor";
                else if(f instanceof Revisor) return "Revisor";
                else if (f instanceof ChefeRedacao) return "Chefe de Redação";
                else if (f instanceof Mediador) return "Mediador";
                else if(f instanceof GerenteRH) return "Gerente de RH";
                else if (f instanceof GerenteGeral) return "Gerente Geral";
          default:
              return "coluna não definida";
      }
    }
   
}
