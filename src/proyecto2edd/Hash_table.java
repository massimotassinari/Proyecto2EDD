/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2edd;

/**
 *
 * @author massimo
 */
public class Hash_table {

    Nodo_hash tabla[];
    int tamano_tabla; //10111(numero primo)

    public Hash_table(int tamaño) {
        this.tamano_tabla = tamaño;
        this.tabla = new Nodo_hash[tamano_tabla];
        for (int i = 0; i < tamano_tabla; i++) {
            this.tabla[i] = null;
        }
    }

    public int hashing(String clave) {
        int valor = 0;
        int posicion = 1;
        for (int i = 0; i < clave.length(); i++) {
            if (clave.codePointAt(i) == 32) {
                valor += 0;
            } else if (clave.codePointAt(i) >= 48 && clave.codePointAt(i) <= 57) {
                valor += ((clave.codePointAt(i) - 47) * posicion);
            } else if (clave.codePointAt(i) >= 65 && clave.codePointAt(i) <= 90) {
                valor += ((clave.codePointAt(i) - 54) * posicion);
            } else if (clave.codePointAt(i) >= 97 && clave.codePointAt(i) <= 122) {
                valor += ((clave.codePointAt(i) - 60) * posicion);
            }
            posicion++;
        }
        return (valor % tamano_tabla);
    }

    public void insertar(String nombre) {
        int posicion = hashing(nombre);
        boolean existe = false;
        if (this.tabla[posicion] != null) {
            Nodo_hash temp = this.tabla[posicion];
            if (temp.getName().equals(nombre)) {
                existe = true;
                
                //incrementa el contador de palabra
                int x=this.tabla[posicion].getContador();
                this.tabla[posicion].setContador(x+1);
            }
            while (temp.getNext() != null) {
                temp = temp.getNext();
                if (temp.getName().equals(nombre)) {
                    existe = true;
                }
            }
            if (!existe) {
                Nodo_hash nuevo2 = new Nodo_hash(nombre);
                temp.setNext(nuevo2);
            }
        } else {
            Nodo_hash nuevo2 = new Nodo_hash(nombre);
            this.tabla[posicion] = nuevo2;
        }
    }

    public Nodo_hash buscar(String nombre) {
        int posicion = hashing(nombre);
        Nodo_hash temp = this.tabla[posicion];
        boolean existe = false;
        if (temp != null) {
            if (temp.getNext() == null) {
                existe = true;

            } else {
                while (temp.getNext() != null && !existe) {
                    if (temp.getName().equals(nombre)) {
                        existe = true;
                    } else {
                        temp = temp.getNext();
                    }
                }
            }
        }
        if (existe) {
            return temp;
        } else {
            return null;
        }
    }
    
    public void vaciado(){
        for (int i = 0; i < tamano_tabla; i++) {
            this.tabla[i] = null;
            
            
        }
    }
    
    public void imprimir(){
        
        for (int i = 0; i < tamano_tabla; i++) {
            if(this.tabla[i]!=null){
                System.out.println(this.tabla[i].getName());
                
                if (this.tabla[i].getNext() != null) {
                    Nodo_hash temp = this.tabla[i].getNext();
                    while(temp != null){
                        System.out.println(temp.getName());
                        temp = temp.getNext();
                    }
                    
                }
            }
            
        }
        
        
        
    }
    
    

}
