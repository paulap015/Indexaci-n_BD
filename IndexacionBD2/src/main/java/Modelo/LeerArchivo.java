package Modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Stream;

public class LeerArchivo {

    private Scanner in = new Scanner(System.in);
    private FileReader archivo;
    private File archivoFuente = null;
    private BufferedReader bf = null;

    public LeerArchivo() {
    }

    public ArrayList<String> leerArchivo(String ruta) {
        ArrayList<String> elementos = new ArrayList<>();
        try {
            archivoFuente = new File(ruta);
            archivo = new FileReader(archivoFuente);
            bf = new BufferedReader(archivo);
            if (bf != null) {
                String linea;
                while ((linea = bf.readLine()) != null) {
                    String[] keyvalue = linea.split(" ");
                    elementos.add(keyvalue[0]);
                }
                return elementos;
            } else {
                System.out.println("EL archivo está vacío");
            }
            bf.close();
        } catch (FileNotFoundException f) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Archivo con información no válida");
        }
        return null;
    }

    public String metodo1Busqueda(String key, String ruta) {
        try {
            archivoFuente = new File(ruta);
            archivo = new FileReader(archivoFuente);
            bf = new BufferedReader(archivo);

            /*Tiempo de ejecución*/
            if (bf != null) {
                String linea;
                long startTime = System.nanoTime();
                while ((linea = bf.readLine()) != null) {
                    String[] keyvalue = linea.split(" ");
                    if (keyvalue[0].compareTo(key) == 0) {
                        long endTime = System.nanoTime() - startTime; // tiempo en que se ejecuta su método
                        System.out.println("T NO INDEX" + endTime);
                        return keyvalue[1];
                    }
                }

            } else {
                System.out.println("EL archivo está vacío");
            }
            bf.close();

        } catch (FileNotFoundException f) {
            System.out.println("File not found");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "No";
    }

    public String obtenerDatoIndex(int pos, String ruta) {
        try {

            RandomAccessFile raf = new RandomAccessFile(ruta, "rw");
            raf.seek(17 * pos);
            String linea = raf.readLine().toString();
            String dato = linea.substring(8);
            return dato;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public boolean validar(String ruta) {
        File file1 = new File(ruta);
        if (file1.exists() && !file1.isDirectory()) {
            return true;
        }
        return false;
    }

    public int numLineasArchivo(String ruta) {
        int num = 0;
        try {
            archivo = new FileReader(ruta);
            bf = new BufferedReader(archivo);
            num = (int) bf.lines().count();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                bf.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return num;
    }

    public ArrayList<String[]> copiaArchivo(String ruta) {
        ArrayList<String[]> elementos = new ArrayList<>();
        try {
            archivoFuente = new File(ruta);
            archivo = new FileReader(archivoFuente);
            bf = new BufferedReader(archivo);
            if (bf != null) {
                String linea;
                while ((linea = bf.readLine()) != null) {
                    String[] keyvalue = linea.split(" ");
                    elementos.add(keyvalue);
                }
                return elementos;
            } else {
                System.out.println("EL archivo está vacío");
            }
            bf.close();
        } catch (FileNotFoundException f) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Archivo con información no válida");
        }
        return null;
    }

}
