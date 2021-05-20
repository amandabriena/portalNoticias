/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIPortal;

import elementos.basicos.ClienteFisico;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class AdaptadorClienteFisicoTabela extends AbstractTableModel{
    private String [] nomesColunas = {"Nome", "CPF","Endereço"};
    private ArrayList<ClienteFisico> clientes;

    public AdaptadorClienteFisicoTabela(ArrayList<ClienteFisico> clientes) {
        this.clientes = clientes;
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
        ClienteFisico cl = clientes.get(rowIndex);
        switch(columnIndex){
            case 0:
                cl.setNome(aValue.toString());
                break;
            case 1:
                cl.setCPF(aValue.toString());
                break;
            case 2:
                cl.setEndereco(aValue.toString());
        }
    }
    
    
    @Override
    public int getRowCount() {
      return clientes.size();
    }

    @Override
    public int getColumnCount() {
      return nomesColunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
      ClienteFisico cl = clientes.get(rowIndex);
      switch(columnIndex){
          case 0:
              return cl.getNome();
          case 1:
              return  cl.getCPF();
          case 2:
              return cl.getEndereco();
          default:
              return "coluna não definida";
      }
    }
}
