/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIPortal;

import elementos.basicos.ClienteDigital;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class AdaptadorClienteDigitalTabela extends AbstractTableModel{

    private String [] nomesColunas = {"Nome", "Login","Email", "Situação da Conta", "Tipo"};
    private ArrayList<ClienteDigital> clientes;

    public AdaptadorClienteDigitalTabela(ArrayList<ClienteDigital> clientes) {
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
        ClienteDigital cl = clientes.get(rowIndex);
        switch(columnIndex){
            case 0:
                cl.setNome(aValue.toString());
                break;
            case 1:
                cl.setLogin(aValue.toString());
                break;
            case 2:
                cl.setEmail(aValue.toString());
            case 3:
                if((aValue.toString()).equals("ativa")){
                    cl.setEstado(true);
                }else if((aValue.toString()).equals("bloqueada")){
                    cl.setEstado(false);
                }
            case 4:
                if((aValue.toString()).equals("pagante")){
                    cl.setSituacao(true);
                }else if((aValue.toString()).equals("não pagante")){
                    cl.setSituacao(false);
                }
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
      ClienteDigital cl = clientes.get(rowIndex);
      switch(columnIndex){
          case 0:
              return cl.getNome();
          case 1:
              return  cl.getLogin();
          case 2:
              return cl.getEmail();
          case 3:
                if(cl.isEstado()){
                    return "ativa";
                }else {
                    return "bloqueada";
                }
          case 4:
              if(cl.isSituacao()){
                    return "pagante";
                }else {
                    return "não pagante";
                }
          default:
              return "coluna não definida";
      }
    }
    
}
