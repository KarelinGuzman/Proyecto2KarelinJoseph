/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2karelinjoseph;

/**
 * Representa un archivo resumen con título, autores, resumen y palabras clave.
 * @author karelin
 */
/**
 * Representa un archivo resumen con título, autores, resumen y palabras clave.
 * 
 * @author [Tu nombre]
 * @version 1.0
 */
public class ArchivoResumen {

    private String titulo;
    private String[] autores;
    private String resumen;
    private String[] palabras_clave;

    /**
     * Constructor de la clase ArchivoResumen.
     * 
     * @param titulo      título del archivo resumen
     * @param autores     arreglo de autores del archivo resumen
     * @param resumen     resumen del archivo resumen
     * @param palabras_clave arreglo de palabras clave del archivo resumen
     */
    public ArchivoResumen(String titulo, String[] autores, String resumen, String[] palabras_clave) {
        this.titulo = titulo;
        this.autores = autores;
        this.resumen = resumen;
        this.palabras_clave = palabras_clave;
    }

    /**
     * Devuelve una representación de cadena del archivo resumen.
     * 
     * @return cadena que representa el archivo resumen
     */
    @Override
    public String toString() {
        String mostrar = "Titulo: " + this.getTitulo() + "\nAutores: ";
        for (int i = 0; i < this.getAutores().length; i++) {
            mostrar += this.getAutores()[i] + "\n";
        }
        mostrar += this.getResumen() + "\nPalabras clave: ";
        for (int i = 0; i < this.getPalabras_clave().length; i++) {
            mostrar += this.getPalabras_clave()[i] + ", ";
        }
        return mostrar;
    }

    /**
     * Analiza el archivo resumen y devuelve una cadena con la frecuencia de aparición de cada palabra clave.
     * 
     * @return cadena que representa el análisis del archivo resumen
     */
    public String analizarArchivo() {
        String mostrar = "Titulo: " + this.getTitulo() + "\nAutores: ";
        for (int i = 0; i < this.getAutores().length; i++) {
            mostrar += this.getAutores()[i] + "\n";
        }
        for (int i = 0; i < this.getPalabras_clave().length; i++) {
            int apariciones = 0;
            int letraActual = 0;
            for (int j = 0; j < this.getResumen().length(); j++) {
                String letra = String.valueOf(this.getPalabras_clave()[i].charAt(letraActual)).toLowerCase();
                String letraResumen = String.valueOf(getResumen().charAt(j)).toLowerCase();
                if (!letra.equals(letraResumen)) {
                    letraActual = 0;
                }
                if (letraResumen.equals(letra)) {
                    letraActual += 1;
                }
                if (letraActual == this.getPalabras_clave()[i].length()) {
                    apariciones += 1;
                    letraActual = 0;
                }
                
            }
            mostrar += this.getPalabras_clave()[i] + ": " + apariciones + " apariciones\n";
        }
        return mostrar;
    }

    /**
     * Devuelve el título del archivo resumen.
     * 
     * @return título del archivo resumen
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Establece el título del archivo resumen.
     * 
     * @param titulo título del archivo resumen
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Devuelve el arreglo de autores del archivo resumen.
     * 
     * @return arreglo de autores del archivo resumen
     */
    public String[] getAutores() {
        return autores;
    }

    /**
     * Establece el arreglo de autores del archivo resumen.
     * 
     * @param autores arreglo de autores del archivo resumen
     */
    public void setAutores(String[] autores) {
        this.autores = autores;
    }

    /**
     * Devuelve el resumen del archivo resumen.
     * 
     * @return resumen del archivo resumen
     */
    public String getResumen() {
        return resumen;
    }

    /**
     * Establece el resumen del archivo resumen.
     * 
     * @param resumen resumen del archivo resumen
     */
    public void setResumen(String resumen) {
        this.resumen = resumen;
    }

    /**
     * Devuelve el arreglo de palabras clave del archivo resumen.

    /**
     * @return the palabras_clave
     */
    public String[] getPalabras_clave() {
        return palabras_clave;
    }
    /**
     * Establece el arreglo de palabras clave del archivo resumen.
     
    /**
     * @param palabras_clave the palabras_clave to set
     */
    public void setPalabras_clave(String[] palabras_clave) {
        this.palabras_clave = palabras_clave;
    }
}
