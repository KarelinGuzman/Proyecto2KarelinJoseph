/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2karelinjoseph;

/**
 *
 *  Representa una tabla de hash que almacena objetos de tipo ArchivoResumen.
 * @author karelin
 */
public class TablaHash {

    private Lista[] archivosResumen;
    private int size;
    private int count;

    /**
     * Constructor de la clase TablaHash.
     *
     * @param size tamaño de la tabla de hash
     */
    public TablaHash(int size) {
        this.size = size;
        this.count = 0;
        this.archivosResumen = new Lista[this.size];
        for (int i = 0; i < this.size; i++) {
            this.archivosResumen[i] = new Lista();
        }
    }

    /**
     * Devuelve el arreglo de listas que almacena los archivos resumen.
     *
     * @return arreglo de listas que almacena los archivos resumen
     */
    public Lista[] getArchivosResumen() {
        return archivosResumen;
    }

    /**
     * Establece el arreglo de listas que almacena los archivos resumen.
     *
     * @param archivosResumen arreglo de listas que almacena los archivos
     * resumen
     */
    public void setArchivosResumen(Lista[] archivosResumen) {
        this.archivosResumen = archivosResumen;
    }

    /**
     * Devuelve el tamaño de la tabla de hash.
     *
     * @return tamaño de la tabla de hash
     */
    public int getSize() {
        return size;
    }

    /**
     * Establece el tamaño de la tabla de hash.
     *
     * @param size tamaño de la tabla de hash
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * Devuelve el contador de elementos en la tabla de hash.
     *
     * @return contador de elementos en la tabla de hash
     */
    public int getCount() {
        return count;
    }

    /**
     * Establece el contador de elementos en la tabla de hash.
     *
     * @param count contador de elementos en la tabla de hash
     */
    public void setCount(int count) {
        this.count = count;
    }

    /**
     * Calcula el índice de hash para un título de archivo.
     *
     * @param titulo título del archivo
     * @return índice de hash
     */
    public int hash(String titulo) {
        int hash = 0;
        for (int i = 0; i < titulo.length(); i++) {
            hash += titulo.charAt(i) * (i + 1 + this.getSize());
        }
        return hash % this.getSize();
    }

    /**
     * Inserta un archivo resumen en la tabla de hash.
     *
     * @param archivo archivo resumen a insertar
     */
    public void insertar(ArchivoResumen archivo) {
        int hash = this.hash(archivo.getTitulo().toLowerCase());
        //VALIDAMOS QUE EL ARCHIVO NO SE ENCUENTRE YA EN EL HASHTABLE
        if (this.getArchivosResumen()[hash].buscar(archivo.getTitulo().toLowerCase()) != null) {
            return;
        }
        //Que count sea igual al contador no necesariamente significa que todos los espacios del arreglo esten ocupados, pero si deberia. Por ende, para evitar que se produzcan demasiadas colisiones
        //creamos un nuevo arreglo mas grande al haber insertado la misma cantidad de elementos que se supone soporta el arreglo (Evidentemente el arreglo soporta infinitos archivos, ya que estos
        //se insertan dentro de las listas, pero lo ideal seria que cada lista contenga solo un archivo)
        if (this.getCount() == this.getSize()) {
            this.aumentarTabla(archivo);
        } else {
            this.getArchivosResumen()[hash].insertar(archivo);
            this.setCount(this.getCount() + 1);
        }
    }

    /**
     * Aumenta la capacidad de la tabla de hash y rehash los elementos
     * existentes.
     *
     * @param archivo archivo resumen a insertar
     */
    public void aumentarTabla(ArchivoResumen archivo) {
        Lista[] archivosResumenAgrandada = new Lista[this.getSize() * 2];
        for (int i = 0; i < this.getSize(); i++) {
            archivosResumenAgrandada[i] = new Lista();
        }
        int tamaño = this.getSize();
        this.setSize(this.getSize() * 2);
        //Lo que haremos, en vez de copiar tal cual el arreglo viejo, será volver a calcularle un indice a cada uno de los archivos para el nuevo arreglo con mayor capacidad.
        //De esta manera, podremos deshacer algunas colisiones que se hayan producido en el anterior;
        for (int i = 0; i < tamaño; i++) {
            Nodo aux = this.getArchivosResumen()[i].getpFirst();
            while (aux != null) {
                int hash = this.hash(aux.getDato().getTitulo());
                archivosResumenAgrandada[hash].insertar(aux.getDato());
                aux = aux.getpNext();
            }
        }

        int hash = this.hash(archivo.getTitulo().toLowerCase());
        archivosResumenAgrandada[hash].insertar(archivo);
        this.setArchivosResumen(archivosResumenAgrandada);
    }

    /**
     * Busca un archivo resumen en la tabla de hash por su título.
     *
     * @param titulo título del archivo resumen
     * @return archivo resumen encontrado o null si no se encuentra
     */
    public ArchivoResumen buscarPorTitulo(String titulo) {
        int hash = this.hash(titulo.toLowerCase());
        if (this.getArchivosResumen()[hash].getpFirst().getDato().getTitulo().toLowerCase().equals(titulo.toLowerCase())) {
            return this.getArchivosResumen()[hash].getpFirst().getDato();
        } else {
            return this.getArchivosResumen()[hash].buscar(titulo);
        }
    }

}
