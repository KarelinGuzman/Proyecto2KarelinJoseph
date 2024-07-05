/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2karelinjoseph;

/**
 *
 * @author karelin
 */
public class Lista {
    public Nodo pFirst;
    public Nodo pLast;
    public int size;
    public String key;

    public Lista(){
        this.pFirst = this.pLast = null;
        this.size = 0;
        this.key = "";
    }

    public void insertar(ArchivoResumen archivo){
        Nodo newNodo = new Nodo(archivo);
        if(this.isEmpty()){
            this.pFirst = this.pLast = newNodo;
        }else{
            this.pLast.pNext = newNodo;
        }
        this.size ++;
    }

    public String[] mostrar(){
        String[] titulos = new String[this.size];
        Nodo aux = this.pFirst;
        int index = 0;
        while(aux!= null){
            titulos[index] = aux.dato.titulo;
            aux = aux.pNext;
            index+=1;
        }
        return titulos;
    }

    public boolean isEmpty(){
        return this.pFirst == null;
    }
    
    public ArchivoResumen buscar(String titulo){
        if(this.isEmpty()){
            return null;
        }else{
             Nodo aux = this.pFirst;
             while(aux!= null && !aux.dato.titulo.equals(titulo)){
                aux = aux.pNext;
             }
             return aux.dato;
        }
    }
}
