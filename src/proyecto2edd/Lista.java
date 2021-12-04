/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2edd;

/**
 *
 * @author massimo
 */
public class Lista {

    //Inicio lista
    private Nodo inicio;
    // Tamaño lista
    private int tamanio;

    //COnstructor
    public void Lista() {
        setInicio(null);
        setTamanio(0);
    }

    //Metodo lista vacia o no
    public boolean esVacia() {
        return getInicio() == null;
    }

    //Metodo taaño lista
    public int getTamanio() {
        return tamanio;
    }
    
    public void vaciar(){
        setInicio(null);
        setTamanio(0);
    }
    
   
    public Nodo getInicio() {
        return inicio;
    }

    /**
     * @param inicio the inicio to set
     */
    public void setInicio(Nodo inicio) {
        this.inicio = inicio;
    }

    /**
     * @param tamanio the tamanio to set
     */
    public void setTamanio(int tamanio) {
        this.tamanio = tamanio;
    }

    //Agrega nodo al final de la lista
    public void agregarFinal(Nodo_hash valor) {

        Nodo nuevo = new Nodo();

        nuevo.setValor(valor);

        if (esVacia()) {

            setInicio(nuevo);

        } else {

            Nodo aux = getInicio();

            while (aux.getSiguiente() != null) {
                aux = aux.getSiguiente();
            }

            aux.setSiguiente(nuevo);
        }

        tamanio++;
    }


    public boolean buscar(int referencia) {

        Nodo aux = inicio;

        boolean encontrado = false;

        while (aux != null && encontrado != true) {

            if (referencia == aux.getValor().getContador()) {

                encontrado = true;
            } else {

                aux = aux.getSiguiente();
            }
        }

        return encontrado;
    }
        //Busca
    public Nodo buscarRet(int referencia) {

        Nodo aux = inicio;
        Nodo node = new Nodo();

        boolean encontrado = false;

        while (aux != null && encontrado != true) {

            if (referencia == aux.getValor().getContador()) {
                
                node = aux;
                

                encontrado = true;
            } else {

                aux = aux.getSiguiente();
            }
        }

        return node;
    }
 
    public void removerPorReferencia(int referencia) {

        if (buscar(referencia)) {

            if (inicio.getValor().getContador() == referencia) {

                inicio = inicio.getSiguiente();
            } else {

                Nodo aux = inicio;

                while (aux.getSiguiente().getValor().getContador() != referencia) {
                    aux = aux.getSiguiente();
                }

                Nodo siguiente = aux.getSiguiente().getSiguiente();

                aux.setSiguiente(siguiente);
            }

            tamanio--;
        }
    }

    public int getValor(int posicion) throws Exception {

        if (posicion >= 0 && posicion < tamanio) {

            if (posicion == 0) {

                return inicio.getValor().getContador();
            } else {

                Nodo aux = inicio;

                for (int i = 0; i < posicion; i++) {
                    aux = aux.getSiguiente();
                }

                return aux.getValor().getContador();
            }

        } else {
            throw new Exception("Posicion inexistente en la lista.");
        }
    }
    
        public Nodo getValor2(int posicion) throws Exception {

        if (posicion >= 0 && posicion < tamanio) {

            if (posicion == 0) {

                return inicio;
            } else {

                Nodo aux = inicio;

                for (int i = 0; i < posicion; i++) {
                    aux = aux.getSiguiente();
                }

                return aux;
            }

        } else {
            throw new Exception("Posicion inexistente en la lista.");
        }
    }

    public void Ordena() throws Exception {

        int Size = this.tamanio;
        int cont = 0;
        Nodo nodito = new Nodo();
        nodito = this.inicio;
        

        if (Size != cont) {
            

            

            int mayor = this.getValor(0);
            

            for (int i = 0; i < this.tamanio; i++) {
//                System.out.println(this.getValor(i));

                
                int x = this.getValor(i);
                System.out.println(x);

                if (nodito.getValor().getContador() > x) {
                    nodito = this.getValor2(i);
                } else {
                }

            }

            this.removerPorReferencia(nodito.getValor().getContador());
            
            Ordena();

            this.agregarFinal(nodito.getValor());

        }
    }

    public String getName(int posicion) throws Exception {

        if (posicion >= 0 && posicion < tamanio) {

            if (posicion == 0) {

                return getInicio().getValor().getName();
            } else {

                Nodo aux = getInicio();

                for (int i = 0; i < posicion; i++) {
                    aux = aux.getSiguiente();
                }
                //RETORNA EL CONTADOR

                return aux.getValor().getName();
            }

        } else {
            throw new Exception("Posicion inexistente en la lista.");
        }
    }
    



    //Imprime la lista
    public void imprimir() {

        if (!esVacia()) {

            Nodo aux = inicio;

            int i = 0;

            while (aux != null) {

                System.out.print("[" + i + "]" + ".( " + aux.getValor().getName() + aux.getValor().getContador() + " )" + " =>  ");

                aux = aux.getSiguiente();

                i++;
            }
        }
    }
    

}
