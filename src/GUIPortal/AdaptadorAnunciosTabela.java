/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIPortal;

import elementos.basicos.Anuncio;
import elementos.basicos.AnuncioDigital;
import elementos.basicos.AnuncioImpresso;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class AdaptadorAnunciosTabela extends AbstractTableModel{
    private String [] nomesColunas = { "Tempo de Exibição", "Tipo","Identificação"};
    private ArrayList<Anuncio> anuncios;

    public AdaptadorAnunciosTabela(ArrayList<Anuncio> anuncios) {
        this.anuncios = anuncios;
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
        Anuncio an = anuncios.get(rowIndex);
        switch(columnIndex){
            case 2:
                an.setIdentificacao(aValue.toString());
                break;
            case 0:
                an.setPeriodoExibicao((int) aValue);
                
        }
    }
    
    
    @Override
    public int getRowCount() {
      return anuncios.size();
    }

    @Override
    public int getColumnCount() {
      return nomesColunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
      Anuncio an = anuncios.get(rowIndex);
      switch(columnIndex){
          case 2:
              return an.getIdentificacao();
          case 0:
                return (an.getPeriodoExibicao())+"";
          case 1:
              if(an instanceof AnuncioDigital){
                  return "Digital";
              }else if(an instanceof AnuncioImpresso){
                  return "Impresso";
              }else{
              return "Impresso e Digital";
          }
          default:
              return "coluna não definida";
      }
    }
}
