/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2karelinjoseph;

/**
 *
 * @author karelin
 */
public class TablaHashPC {
    public Lista[] archivosResumen;
    public int size;
    public int count;

    public TablaHashPC(int size){
        this.size = size;
        this.count = 0;
        this.archivosResumen = new Lista[this.size];
        for(int i=0; i < this.size; i++){
            this.archivosResumen[i] = new Lista();
        }
    }
    //Cambiar titulo por PC
    public int hash(String titulo){
        int hash = 0;
        for(int i=0; i < titulo.length(); i++){
            hash += titulo.charAt(i)*(i+1+this.size);
        }

        return hash % this.size;
    }
    
    public void insertar(ArchivoResumen archivo){
        int hash = this.hash(archivo.titulo);
        //VALIDAMOS QUE EL ARCHIVO NO SE ENCUENTRE YA EN EL HASHTABLE
        if(this.archivosResumen[hash].buscar(archivo.titulo) != null){
            return;
        }
        //Que count sea igual al contador no necesariamente significa que todos los espacios del arreglo esten ocupados, pero si deberia. Por ende, para evitar que se produzcan demasiadas colisiones
        //creamos un nuevo arreglo mas grande al haber insertado la misma cantidad de elementos que se supone soporta el arreglo (Evidentemente el arreglo soporta infinitos archivos, ya que estos
        //se insertan dentro de las listas, pero lo ideal seria que cada lista contenga solo un archivo)
        if(this.count == this.size){
            this.aumentarTabla(archivo);
        }else{
            
            this.archivosResumen[hash].insertar(archivo);
            this.count ++;
        }
    }

    public void aumentarTabla(ArchivoResumen archivo){
        Lista[] archivosResumenAgrandada = new Lista[this.size*2];
        for(int i=0; i < this.size; i++){
            archivosResumenAgrandada[i] = new Lista();
        }
        int tamaño = this.size;
        this.size *= 2;
        //Lo que haremos, en vez de copiar tal cual el arreglo viejo, será volver a calcularle un indice a cada uno de los archivos para el nuevo arreglo con mayor capacidad.
        //De esta manera, podremos deshacer algunas colisiones que se hayan producido en el anterior;
        for(int i=0; i < tamaño; i++){
            Nodo aux = this.archivosResumen[i].pFirst;
            while(aux != null){
                int hash = this.hash(aux.dato.titulo);
                archivosResumenAgrandada[hash].insertar(aux.dato);
                aux = aux.pNext;
            }
        }

        int hash = this.hash(archivo.titulo);
        archivosResumenAgrandada[hash].insertar(archivo);
        this.archivosResumen = archivosResumenAgrandada;
    
    }
}
