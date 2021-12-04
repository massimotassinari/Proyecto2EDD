/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2edd;

/**
 *
 * @author massimo
 */
public class Nodo_hash {
    
    private Nodo_hash next;
    private String name;
    private int contador;
    
    public Nodo_hash(String nombre){
        
        this.next = null;
        this.name = nombre;
        this.contador = 1;
        
    }

    /**
     * @return the next
     */
    public Nodo_hash getNext() {
        return next;
    }

    /**
     * @param next the next to set
     */
    public void setNext(Nodo_hash next) {
        this.next = next;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the contador
     */
    public int getContador() {
        return contador;
    }

    /**
     * @param contador the contador to set
     */
    public void setContador(int contador) {
        this.contador = contador;
    }
    
}
