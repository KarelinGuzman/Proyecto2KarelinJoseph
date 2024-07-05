/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2karelinjoseph;

/**
 *
 * @author karelin
 */
public class Nodo {
    ArchivoResumen dato;
    Nodo pNext;
    
    public Nodo(ArchivoResumen archivo){
        this.dato = archivo;
        this.pNext = null;
    }
}
