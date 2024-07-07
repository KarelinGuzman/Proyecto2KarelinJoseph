/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2karelinjoseph;

import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.JOptionPane;

/**
 * Clase que proporciona funciones adicionales para leer archivos de texto y procesar la información.
 * @author joseph
 */
public class FuncionesAdicionales {

    private TablaHash tablaHash;
    private TablaHashPyA tablaPYA;
    private TablaHashPyA tablaAutores;

    /**
     * Constructor de la clase FuncionesAdicionales.
     * 
     * @param tablaHash      tabla hash para almacenar archivos resumen
     * @param tablaPYA       tabla hash para almacenar palabras clave y archivos resumen
     * @param tablaAutores   tabla hash para almacenar autores y archivos resumen
     */
    public FuncionesAdicionales(TablaHash tablaHash, TablaHashPyA tablaPYA, TablaHashPyA tablaAutores) {
        this.tablaHash = tablaHash;
        this.tablaPYA = tablaPYA;
        this.tablaAutores = tablaAutores;
    }

    /**
     * Lee un archivo de texto y procesa la información para insertarla en las tablas hash.
     * 
     * @param path ruta del archivo de texto a leer
     */
    public void leerTXT(String path) {
        String linea;
        String title = "";
        String autors = "";
        String summary = "";
        String keys = "";
        int lecture_mode = 1;
        try {
            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);
            while ((linea = br.readLine()) != null) {
                if (!linea.isEmpty()) {
                    if (linea.toLowerCase().equals("autores")) {
                        lecture_mode = 2;
                    } else if (linea.toLowerCase().equals("resumen")) {
                        lecture_mode = 3;
                    } else if (linea.toLowerCase().contains("palabras claves: ")) {
                        if (String.valueOf(linea.charAt(linea.length() - 1)).equals(".") || String.valueOf(linea.charAt(linea.length() - 1)).equals(".")) {
                            keys += linea.toLowerCase().replace("palabras claves: ", "").replaceAll(".$", "");
                        }else{
                            keys += linea.toLowerCase().replace("palabras claves: ", "");
                        }
                    } else if (lecture_mode == 1) {
                        title += linea;
                    } else if (lecture_mode == 2) {
                        autors += linea.replace("-", " ") + ";";
                    } else if (lecture_mode == 3) {
                        summary += linea + " ";
                    }
                }
            }
            String autores[] = autors.split(";");
            String palabras_clave[] = keys.split(", ");
            ArchivoResumen archivo = new ArchivoResumen(title, autores, summary, palabras_clave);
            this.tablaHash.insertar(archivo);
            for (int i = 0; i < autores.length; i++) {
                this.tablaAutores.insertar(archivo, autores[i]);
            }
            for (int i = 0; i < palabras_clave.length; i++) {
                this.tablaPYA.insertar(archivo, palabras_clave[i]);
            }
            br.close();

//            JOptionPane.showMessageDialog(null, "Se ha leido el archivo");
        } catch (Exception ex) {

            ex.printStackTrace();
        }

    }
}
