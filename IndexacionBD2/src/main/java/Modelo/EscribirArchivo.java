package Modelo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class EscribirArchivo {

    private BufferedWriter bw;
    private FileWriter fw;

    public EscribirArchivo() {
    }

    public boolean escribir(int n, String ruta) {
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            File archivo = new File(ruta);
            fichero = new FileWriter(archivo);
            pw = new PrintWriter(fichero);
            ArrayList<String[]> elementos = NumRandom(n);
            for (String[] i : elementos) {
                pw.println(i[0] + " " + i[1]);
            }

            return true;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fichero) {
                    fichero.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        return false;
    }

    public ArrayList<String[]> NumRandom(int numRegistros) {
        ArrayList<String[]> elementos = new ArrayList();
        Random random = new Random();
        HashMap<Integer, Integer> map = new HashMap<>();
        int i = 0;
        int j, k;
        while (i < numRegistros) {
            j = random.nextInt(1000000);
            k = random.nextInt(1000000);
            String key = String.valueOf(j);
            String dato = String.valueOf(k);
            String[] keydato = {key, dato};
            if (!map.isEmpty() && !map.containsKey(j)) {
                map.put(j, k);
                elementos.add(keydato);
                i++;
            } else if (map.isEmpty()) {
                map.put(j, k);
                elementos.add(keydato);
                i++;
            }
        }
        return elementos;
    }

    public void limpiarArchivo(String ruta) {
        try {
            File archivo = new File(ruta);
            BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));
            bw.write("");
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void nuevoElemento(String ruta, String copiaRuta, String key, String value) {
        try {
            File arc = new File(ruta);
            fw = new FileWriter(arc.getAbsoluteFile(), true);
            bw = new BufferedWriter(fw);
            String reg = key + " " + value + "\n";
            bw.write(reg);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (bw != null) {
                    bw.close();
                }
                if (fw != null) {
                    fw.close();
                }
                nuevoelementoEnCopia(copiaRuta, key, value);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    private void nuevoelementoEnCopia(String copiaRuta, String key, String value) {
        try {
            File arc = new File(copiaRuta);
            fw = new FileWriter(arc.getAbsoluteFile(), true);
            bw = new BufferedWriter(fw);
            StringBuffer bs = new StringBuffer(key);
            StringBuffer bs2 = new StringBuffer(value);
            bs.setLength(7);
            bs2.setLength(7);
            bw.write(bs.toString() + "|" + bs2.toString() + "\n");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (bw != null) {
                    bw.close();
                }
                if (fw != null) {
                    fw.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void copia(String ruta, String copiaRuta) {
        LeerArchivo rf = new LeerArchivo();
        ArrayList<String[]> elementos = rf.copiaArchivo(ruta);
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            File archivo = new File(copiaRuta);
            fichero = new FileWriter(archivo);
            pw = new PrintWriter(fichero);
            StringBuffer bs, bs2 = null;
            for (int i = 0; i < elementos.size(); i++) {
                bs = new StringBuffer(elementos.get(i)[0]);
                bs2 = new StringBuffer(elementos.get(i)[1]);
                bs.setLength(7);
                bs2.setLength(7);
                String aux = bs.toString() + "|" + bs2.toString();
                pw.println(aux);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fichero) {
                    fichero.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

}
