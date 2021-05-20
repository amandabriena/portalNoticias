/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIPortal;

import elementos.basicos.Anunciante;
import elementos.basicos.AnunciantePrivado;
import elementos.basicos.AnunciantePublico;
import elementos.basicos.CNPJ;
import excessoes.NumeroCNPJInvalido;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

public class AdaptadorAnuncianteTabela extends AbstractTableModel{
private String [] nomesColunas = {"Nome", "CNPJ","Tipo", "Esfera", "Valor Pagamento"};
    private ArrayList<Anunciante> anunciantes;

    public AdaptadorAnuncianteTabela(ArrayList<Anunciante> anunciantes) {
        this.anunciantes = anunciantes;
    }
    
    @Override
    public String getColumnName(int column) {
      if (column >= 0 && column <nomesColunas.length) 
          return nomesColunas[column];
      else 
          return "";
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
      return true; 
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Anunciante an = anunciantes.get(rowIndex);
        switch(columnIndex){
            case 0:
                an.setNome(aValue.toString());
                break;
            case 1:
                try {
                    CNPJ cnpj = new CNPJ((String) aValue);
                    an.setCNPJ(cnpj);
                } catch (NumeroCNPJInvalido ex) {
                }
                
                break;
            case 3:
                if(an instanceof AnunciantePublico){
                    ((AnunciantePublico)an).setEsfera(aValue.toString());
                }
            case 4:
                an.setValorPagamento((float) aValue);                
        }
    }
    
    
    @Override
    public int getRowCount() {
      return anunciantes.size();
    }

    @Override
    public int getColumnCount() {
      return nomesColunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
      Anunciante an = anunciantes.get(rowIndex);
      switch(columnIndex){
          case 0:
              return an.getNome();
          case 1:
              return  an.getCNPJ().getNumero();
          case 2:
              if(an instanceof AnunciantePublico){
                  return "público";
              }else{
                  return "privado";
              }
          case 3:
              if(an instanceof AnunciantePublico){
                  return ((AnunciantePublico)an).getEsfera();
              }else{
                  return "-";
              }
          case 4:
              return Float.toString(an.getValorPagamento());
          default:
              return "coluna não definida";
      }
    }
    
}
