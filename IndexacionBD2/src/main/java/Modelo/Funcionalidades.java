package Modelo;

import java.io.File;
import java.util.ArrayList;

public class Funcionalidades {

    private LeerArchivo arc = new LeerArchivo();
    EscribirArchivo wrt = new EscribirArchivo();
    private BPlusTree arbol;

    public Funcionalidades() {
    }

    public void llenarArbol(ArrayList<String> claves) {
        for (int i = 0; i < claves.size(); i++) {
            arbol.insert(Integer.parseInt(claves.get(i)), (double) (i));
        }
    }

    public String busquedaIndexada(String clave, String ruta) {
        double pos = arbol.search(Integer.parseInt(clave));
        if (pos == -100) {
            return "No";
        }

        System.out.println("Posición en el arbol" + (int) pos);
        return arc.obtenerDatoIndex((int) (pos), ruta);
    }

    public String busquedaNoindexada(String key, String ruta) {

        return arc.metodo1Busqueda(key, ruta);
    }

    public boolean validarArchivo(String ruta) {
        return arc.validar(ruta);
    }

    public void crearArbol(String ruta) {
        arbol = new BPlusTree(4);
        ArrayList<String> claves = arc.leerArchivo(ruta);
        llenarArbol(claves);
    }

    public boolean generarArchivo(String ruta, int numRegistros) {
        boolean flag = wrt.escribir(numRegistros, ruta);
        crearArbol(ruta);
        wrt.copia(ruta, "copiaArchivo.txt");

        return flag;
    }

    public void limpiar(String ruta) {
        wrt.limpiarArchivo(ruta);
    }

    public boolean agregarNuevoElemento(String ruta, String copiaRuta, String clave, String dato) {
        if (validar(clave)) {
            wrt.nuevoElemento(ruta, copiaRuta, clave, dato);
            arbol.insert(Integer.parseInt(clave), (double) (arc.numLineasArchivo(ruta) - 1));
            return true;
        }
        
        return false;
    }

    public boolean validar(String clave) {
           
        if (arbol.search((Integer.parseInt(clave))) == -100) {
            return true;
        }
        return false;
    }

}
