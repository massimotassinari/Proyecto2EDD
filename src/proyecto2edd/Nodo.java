/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2edd;

/**
 *
 * @author massimo
 */
public class Nodo {
    
    private Nodo_hash valor;

    private Nodo siguiente;

    public void Nodo_lista() {
        this.setSiguiente(null);
        this.setValor(null);

    }

    /**
     * @return the valor
     */
    public Nodo_hash getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(Nodo_hash valor) {
        this.valor = valor;
    }

    /**
     * @return the siguiente
     */
    public Nodo getSiguiente() {
        return siguiente;
    }

    /**
     * @param siguiente the siguiente to set
     */
    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }



    

    
}
