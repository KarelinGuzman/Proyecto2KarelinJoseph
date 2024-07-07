/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto2karelinjoseph;

import proyecto2karelinjoseph.Interfaces.MenuInicial;

/**
 * Clase principal del proyecto que inicializa los componentes necesarios para la ejecución del programa.
 * @author karelin
 */
public class Proyecto2KarelinJoseph {

    /**
     * Punto de entrada del programa.
     *
     * @param args argumentos de la línea de comandos
     */
    public static void main(String[] args) {
        // Inicializa la tabla de hash con 20 espacios
        TablaHash tablaHash = new TablaHash(20);

        // Inicializa la tabla de hash para autores con 60 espacios
        TablaHashPyA tablaAutores = new TablaHashPyA(60);

        // Inicializa la tabla de hash para claves con 100 espacios
        TablaHashPyA tablaClaves = new TablaHashPyA(100);

        // Crea un objeto de la clase FuncionesAdicionales que utiliza las tablas de hash
        FuncionesAdicionales funciones = new FuncionesAdicionales(tablaHash, tablaClaves, tablaAutores);

        // Arreglo de nombres de archivos a leer
        String[] archivos = {"resumen.txt", "resumen_2.txt", "resumen_3.txt", "resumen_4.txt"};

        // Lee cada archivo y procesa su contenido
        for (int i = 0; i < archivos.length; i++) {
            funciones.leerTXT(archivos[i]);
        }

        // Crea un objeto de la clase MenuInicial que utiliza las tablas de hash
        MenuInicial menu = new MenuInicial(tablaHash, tablaAutores, tablaClaves);
    }
}
