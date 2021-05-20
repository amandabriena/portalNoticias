/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIPortal;

import elementos.basicos.Publicacao;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class AdaptadorPubsTabela extends AbstractTableModel{
    private String [] nomesColunas = {"Título", "Categoria","Tipo", "Identificação"};
    private ArrayList<Publicacao> publicacoes;

    public AdaptadorPubsTabela(ArrayList<Publicacao> publicacoes) {
        this.publicacoes = publicacoes;
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
        Publicacao pub = publicacoes.get(rowIndex);
        switch(columnIndex){
            
        }
    }
    
    
    @Override
    public int getRowCount() {
      return publicacoes.size();
    }

    @Override
    public int getColumnCount() {
      return nomesColunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
      Publicacao pub = publicacoes.get(rowIndex);
      switch(columnIndex){
          case 0:
              return pub.getTitulo();
          case 1:
              return  pub.getCategoria();
          case 2:
              return pub.getTipo();
          case 3:
              return pub.getIdentificacao();
          default:
              return "coluna não definida";
      }
    }
    
}
