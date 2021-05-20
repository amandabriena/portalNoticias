/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilitario;

import java.util.ArrayList;
import java.util.Random;

public class GeradorCodigos {
    
    private static final String alfabeto = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final int TAM = 26;
    private static ArrayList<String> codigos = new ArrayList<>();
    
    public static String gerarCodigo(){
        String codigoGerado = "";
        Random aleatorio = new Random();
        for(int i = 0 ; i < 6 ; i ++){
            int indice;
            if( i < 2){
             indice = aleatorio.nextInt(TAM);
              codigoGerado = codigoGerado + alfabeto.charAt(indice);
            }
            else{
             indice = aleatorio.nextInt(10);
             codigoGerado = codigoGerado + indice;
            }
        }
        if(codigos.contains(codigoGerado)){
           return  gerarCodigo();
        }
        else{
          codigos.add(codigoGerado);
          return codigoGerado;
        }
   }
    
    
    public static void main(String[] args) {
        System.out.println(GeradorCodigos.gerarCodigo());
    }
    
}
