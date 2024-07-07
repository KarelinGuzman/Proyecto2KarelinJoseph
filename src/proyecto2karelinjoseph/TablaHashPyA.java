/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2karelinjoseph;

import javax.swing.JOptionPane;

/**
 * Representa una tabla de hash que almacena objetos de tipo ArchivoResumen.
 * @author karelin
 */
public class TablaHashPyA {

    /**
     * Arreglo de listas que almacena los archivos resumen.
     */
    public Lista[] archivosResumen;

    /**
     * Tamaño de la tabla de hash.
     */
    public int size;

    /**
     * Contador de elementos en la tabla de hash.
     */
    public int count;

    /**
     * Constructor de la clase TablaHashPyA.
     *
     * @param size tamaño de la tabla de hash
     */
    public TablaHashPyA(int size) {
        this.size = size;
        this.count = 0;
        this.archivosResumen = new Lista[this.size];
        for (int i = 0; i < this.size; i++) {
            this.archivosResumen[i] = new Lista();
        }
    }

    /**
     * Calcula el índice de hash para una palabra clave.
     *
     * @param palabra palabra clave
     * @return índice de hash
     */
    public int hash(String palabra) {
        int hash = 0;
        for (int i = 0; i < palabra.length(); i++) {
            hash += palabra.charAt(i) * (i + 1 + this.size);
        }

        return hash % this.size;
    }

    /**
     * Inserta un archivo resumen en la tabla de hash con una palabra clave
     * asociada.
     *
     * @param archivo archivo resumen a insertar
     * @param palabra palabra clave asociada
     */
    public void insertar(ArchivoResumen archivo, String palabra) {
        if (this.count == this.size) {
            this.aumentarTabla();
        }
        int hash = this.hash(palabra.toLowerCase());

        if (this.archivosResumen[hash].getKey().toLowerCase().equals(palabra.toLowerCase()) || this.archivosResumen[hash].getKey().equals("")) {
            this.archivosResumen[hash].insertar(archivo);
            this.archivosResumen[hash].setKey(palabra);

        } else {
            while (!this.archivosResumen[hash].getKey().equals("")) {
                hash += 1;
                if (hash >= this.size) {
                    hash = 0;
                }
            }
            this.archivosResumen[hash].insertar(archivo);
            this.archivosResumen[hash].setKey(palabra);

        }
        if (this.archivosResumen[hash].getKey().equals("")) {
            this.count += 1;
        }
    }

    /**
     * Aumenta la capacidad de la tabla de hash y rehash los elementos
     * existentes.
     */
    public void aumentarTabla() {
        Lista[] archivosResumenAgrandada = new Lista[this.size * 2];
        this.size *= 2;
        for (int i = 0; i < this.size; i++) {
            archivosResumenAgrandada[i] = null;
        }
        for (int i = 0; i < this.size; i++) {
            if (!this.archivosResumen[i].getKey().equals("")) {
                int hash = this.hash(this.archivosResumen[i].getKey().toLowerCase());
                if (archivosResumenAgrandada[hash] == null) {
                    archivosResumenAgrandada[hash] = this.archivosResumen[i];
                } else {
                    while (archivosResumenAgrandada[hash] != null) {
                        hash += 1;
                        if (hash >= this.size) {
                            hash = 0;
                        }
                    }
                    archivosResumenAgrandada[hash] = this.archivosResumen[i];
                }
            }
        }
    }

    /**
     * Busca un archivo resumen en la tabla de hash por su palabra clave.
     *
     * @param palabra palabra clave
     * @return lista que contiene el archivo resumen encontrado o null si no se
     * encuentra
     */
    public Lista buscar(String palabra) {
        int hash = this.hash(palabra.toLowerCase());
        if (this.archivosResumen[hash].getKey().toLowerCase().equals(palabra.toLowerCase())) {
            return this.archivosResumen[hash];
        } else {
            int count = 0;
            while (!this.archivosResumen[hash].getKey().toLowerCase().equals(palabra.toLowerCase())) {
                if (hash == this.size - 1) {
                    hash = 0;
                } else {
                    hash += 1;
                }
                if (count == this.size) {
                    JOptionPane.showMessageDialog(null, "NO SE HA ENCONTRADO ESA PALABRA CLAVE");
                    return null;
                }
                count++;
            }
            return this.archivosResumen[hash];
        }
    }

    /**
     * Muestra todas las palabras clave almacenadas en la tabla de hash.
     *
     * @return arreglo de strings que contiene las palabras clave
     */
    public String[] mostrar() {
        String llaves = "";
        for (int i = 0; i < this.size; i++) {
            if (!this.archivosResumen[i].getKey().equals("")) {
                llaves += this.archivosResumen[i].getKey() + ";";
            }
        }
        llaves = llaves.replaceAll(".$", "");
        return llaves.split(";");
    }

}
