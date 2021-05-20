/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIPortal;

import elementos.basicos.ClienteDigital;
import elementos.basicos.Comentario;
import elementos.basicos.Publicacao;
import elementos.basicos.PublicacaoDig;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class AdaptadorComentariosTabela extends AbstractTableModel{
    private String [] nomesColunas = {"Autor do Comentário", "Publicação","Comentário", "Identificação Comentário"};
    private ArrayList<Comentario> comentarios;

    public AdaptadorComentariosTabela(ArrayList<Comentario> comentarios) {
        this.comentarios = comentarios;
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
        Comentario cm = comentarios.get(rowIndex);
        switch(columnIndex){
            case 0:
                cm.setAutor((ClienteDigital)aValue);
                break;
            case 1:
                cm.setPublicacao((PublicacaoDig)aValue);
                break;
            case 2:
                cm.setConteudo(aValue.toString());
                break;
            case 3:
                cm.setIdentificacao(aValue.toString());
                break;
        }
    }
    
    
    @Override
    public int getRowCount() {
      return comentarios.size();
    }

    @Override
    public int getColumnCount() {
      return nomesColunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
      Comentario cm = comentarios.get(rowIndex);
      switch(columnIndex){
          case 0:
              return cm.getAutor().getLogin();
          case 1:
              return  cm.getPublicacao().getTitulo();
          case 2:
              return cm.getConteudo();
          case 3:
              return cm.getIdentificacao();
          default:
              return "coluna não definida";
      }
    }
}
