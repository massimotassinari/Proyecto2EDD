/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2edd;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 *
 * @author massimo
 */
class funciones {
        String texto = "";
    
    public String leerTxt(String direccion){
        try {
            BufferedReader bf = new BufferedReader(new FileReader(direccion));
            String temp="";
            String bfRead;
            
            while((bfRead = bf.readLine())!=null){
                temp = temp + bfRead;
                
            
        }
            
            texto = temp;
            
        }catch(Exception e){System.out.println("No se encontro");
            
        }
        return texto;
        
    }
    
    
}
