/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto2karelinjoseph;

import proyecto2karelinjoseph.Interfaces.MenuInicial;

/**
 *
 * @author karelin
 */
public class Proyecto2KarelinJoseph {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        TablaHash tablaHash = new TablaHash(20);
        TablaHashPyA tablaAutores = new TablaHashPyA(60);
        TablaHashPyA tablaClaves = new TablaHashPyA (100);
        FuncionesAdicionales funciones = new FuncionesAdicionales(tablaHash, tablaAutores, tablaClaves);
        MenuInicial menu= new MenuInicial(tablaHash, tablaAutores, tablaClaves);
    }
    
}
