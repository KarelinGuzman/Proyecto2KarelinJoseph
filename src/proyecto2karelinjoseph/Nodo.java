/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2karelinjoseph;

/**
 * Representa un nodo en una lista enlazada que almacena objetos de tipo ArchivoResumen.
 * @author karelin
 */
public class Nodo {

    private ArchivoResumen dato;
    private Nodo pNext;

    /**
     * Constructor de la clase Nodo.
     * 
     * @param archivo objeto ArchivoResumen a almacenar en el nodo
     */
    public Nodo(ArchivoResumen archivo){
        this.dato = archivo;
        this.pNext = null;
    }

    /**
     * Devuelve el objeto ArchivoResumen almacenado en el nodo.
     * 
     * @return objeto ArchivoResumen almacenado en el nodo
     */
    public ArchivoResumen getDato() {
        return dato;
    }

    /**
     * Establece el objeto ArchivoResumen a almacenar en el nodo.
     * 
     * @param dato objeto ArchivoResumen a almacenar en el nodo
     */
    public void setDato(ArchivoResumen dato) {
        this.dato = dato;
    }

    /**
     * Devuelve el nodo siguiente en la lista enlazada.
     * 
     * @return nodo siguiente en la lista enlazada
     */
    public Nodo getpNext() {
        return pNext;
    }

    /**
     * Establece el nodo siguiente en la lista enlazada.
     * 
     * @param pNext nodo siguiente en la lista enlazada
     */
    public void setpNext(Nodo pNext) {
        this.pNext = pNext;
    }
}
