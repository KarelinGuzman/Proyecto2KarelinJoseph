/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2karelinjoseph;

/**
 *
 * @author karelin
 */
public class ArchivoResumen {
    public String titulo;
    public String[] autores;
    public String resumen;
    public String[] palabras_clave;

    public ArchivoResumen( String titulo, String[] autores, String resumen, String[] palabras_clave){
        this.titulo = titulo;
        this.autores = autores;
        this.resumen = resumen;
        this.palabras_clave = palabras_clave;
    }

    @Override
    public String toString(){
        String mostrar = "Titulo: " + this.titulo + "\nAutores: ";
        for(int i=0; i < this.autores.length; i++){
            mostrar += this.autores[i]+ "\n";
        }
        mostrar += this.resumen + "\nPalabras clave: ";
        for(int i=0; i < this.palabras_clave.length; i++){
            mostrar += this.palabras_clave[i] + ", ";
        }
        return mostrar;
    
    }
}
