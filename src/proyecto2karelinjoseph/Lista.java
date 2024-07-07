/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2karelinjoseph;

/**
 * Representa una lista enlazada que almacena objetos de tipo ArchivoResumen.
 * @author karelin
 */
public class Lista {

    private Nodo pFirst;
    private Nodo pLast;
    private int size;
    private String key;

    /**
     * Constructor de la clase Lista.
     */
    public Lista(){
        this.pFirst = this.pLast = null;
        this.size = 0;
        this.key = "";
    }

    /**
     * Devuelve el primer nodo de la lista.
     * 
     * @return primer nodo de la lista
     */
    public Nodo getpFirst() {
        return pFirst;
    }

    /**
     * Establece el primer nodo de la lista.
     * 
     * @param pFirst primer nodo de la lista
     */
    public void setpFirst(Nodo pFirst) {
        this.pFirst = pFirst;
    }

    /**
     * Devuelve el último nodo de la lista.
     * 
     * @return último nodo de la lista
     */
    public Nodo getpLast() {
        return pLast;
    }

    /**
     * Establece el último nodo de la lista.
     * 
     * @param pLast último nodo de la lista
     */
    public void setpLast(Nodo pLast) {
        this.pLast = pLast;
    }

    /**
     * Devuelve el tamaño de la lista.
     * 
     * @return tamaño de la lista
     */
    public int getSize() {
        return size;
    }

    /**
     * Establece el tamaño de la lista.
     * 
     * @param size tamaño de la lista
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * Devuelve la clave de la lista.
     * 
     * @return clave de la lista
     */
    public String getKey() {
        return key;
    }

    /**
     * Establece la clave de la lista.
     * 
     * @param key clave de la lista
     */
    public void setKey(String key) {
        this.key = key;
    }

    /**
     * Inserta un objeto ArchivoResumen en la lista.
     * 
     * @param archivo objeto ArchivoResumen a insertar
     */
    public void insertar(ArchivoResumen archivo){
        Nodo newNodo = new Nodo(archivo);
        if(this.isEmpty()){
            this.setpFirst(this.pLast = newNodo);
        }else{
            this.pLast.setpNext(newNodo);
        }
        this.setSize(this.getSize() + 1);
    }

    /**
     * Devuelve un arreglo de strings con los títulos de los archivos resumen en la lista.
     * 
     * @return arreglo de strings con los títulos de los archivos resumen
     */
    public String[] mostrar(){
        String[] titulos = new String[this.getSize()];
        Nodo aux = this.getpFirst();
        int index = 0;
        while(aux!= null){
            if(aux.getDato().getTitulo().equals("")){
                continue;
            }
            titulos[index] = aux.getDato().getTitulo();
            aux = aux.getpNext();
            index+=1;
        }
        return titulos;
    }

    /**
     * Verifica si la lista está vacía.
     * 
     * @return true si la lista está vacía, false en caso contrario
     */
    public boolean isEmpty(){
        return this.getpFirst() == null;
    }

    /**
     * Busca un objeto ArchivoResumen en la lista por título.
     * 
     * @param titulo título del archivo resumen a buscar
     * @return objeto ArchivoResumen encontrado, null si no se encuentra
     */
    public ArchivoResumen buscar(String titulo){
        if(this.isEmpty()){
            return null;
        }else{
             Nodo aux = this.getpFirst();
             while(aux!= null &&!aux.getDato().getTitulo().toLowerCase().equals(titulo.toLowerCase())){
                aux = aux.getpNext();
             }
             return aux.getDato();
        }
    }
}
