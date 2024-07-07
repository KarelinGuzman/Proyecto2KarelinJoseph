/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2karelinjoseph;

/**
 *
 * @author karelin
 */
public class TablaHashPyA {

    public Lista[] archivosResumen;
    public int size;
    public int count;

    public TablaHashPyA(int size) {
        this.size = size;
        this.count = 0;
        this.archivosResumen = new Lista[this.size];
        for (int i = 0; i < this.size; i++) {
            this.archivosResumen[i] = new Lista();
        }
    }

    //Cambiar titulo por PC
    public int hash(String palabra) {
        int hash = 0;
        for (int i = 0; i < palabra.length(); i++) {
            hash += palabra.charAt(i) * (i + 1 + this.size);
        }

        return hash % this.size;
    }

    public void insertar(ArchivoResumen archivo, String palabra) {
        if (this.count == this.size) {
            this.aumentarTabla();
        }
        int hash = this.hash(palabra.toLowerCase());

        if (this.archivosResumen[hash].key.toLowerCase().equals(palabra.toLowerCase()) || this.archivosResumen[hash].key.equals("")) {
            this.archivosResumen[hash].insertar(archivo);
            this.archivosResumen[hash].key = palabra;

        } else {
            while (!this.archivosResumen[hash].key.equals("")) {
                hash += 1;
                if (hash >= this.size) {
                    hash = 0;
                }
            }
            this.archivosResumen[hash].insertar(archivo);
            this.archivosResumen[hash].key = palabra;

        }
        if (this.archivosResumen[hash].key.equals("")) {
            this.count += 1;
        }

    }

    public void aumentarTabla() {
        Lista[] archivosResumenAgrandada = new Lista[this.size * 2];
        this.size *= 2;
        for (int i = 0; i < this.size; i++) {
            archivosResumenAgrandada[i] = null;
        }
        for (int i = 0; i < this.size; i++) {
            if (!this.archivosResumen[i].key.equals("")) {
                int hash = this.hash(this.archivosResumen[i].key.toLowerCase());
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
    
    public Lista buscar(String palabra){
        int hash = this.hash(palabra.toLowerCase());
        if(this.archivosResumen[hash].key.toLowerCase().equals(palabra.toLowerCase())){
            return this.archivosResumen[hash];
        }else{
            while(!this.archivosResumen[hash].key.toLowerCase().equals(palabra.toLowerCase())){
                if(hash == this.size -1){
                    hash = 0;
                }else{
                    hash += 1;
                }           
            }
            return this.archivosResumen[hash];
        }
    }
}
