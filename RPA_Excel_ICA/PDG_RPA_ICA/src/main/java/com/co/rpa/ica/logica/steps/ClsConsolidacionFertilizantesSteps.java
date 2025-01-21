package com.co.rpa.ica.logica.steps;

import com.co.rpa.ica.logica.utils.ClsConstantesGlobales;
import com.co.rpa.ica.logica.utils.ClsLeerArchivoExcel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.co.rpa.ica.logica.utils.ClsConstantesGlobales.*;

public class ClsConsolidacionFertilizantesSteps {

//    public List<String> datosExcelProveedores() {
//
//        int numeroRegistros = ClsLeerArchivoExcel.contarFilasExcel(ClsConstantesGlobales.pathArchivoExcelFertilizantes, 1);
//        ArrayList<Map<String, String>> datosExcelProveedores = ClsLeerArchivoExcel.lecturaExcel(ClsConstantesGlobales.pathArchivoExcelFertilizantes, 1);
//        ClsConstantesGlobales clsConstantesGlobales = new ClsConstantesGlobales();
//        //Leer matrizFertilizante
//        try{
//            System.out.println("Leer Archivo");
//            for (int i = 1; i <= numeroRegistros - 1; i++) {
//                datosExcelProveedores.get(i).get("NIT EMPRESA TITULAR DEL REGISTRO");
//                datosExcelProveedores.get(i).get("NOMBRE DE LA EMPRESA TITULAR DEL REGISTRO");
//                datosExcelProveedores.get(i).get("REGISTRO DE VENTA No.");
//                datosExcelProveedores.get(i).get("NOMBRE COMERCIAL DEL PRODUCTO");
//                datosExcelProveedores.get(i).get("COMPOSICIÓN GARANTIZADA ");
//                datosExcelProveedores.get(i).get("FORMULACIÓN");
//                datosExcelProveedores.get(i).get("TIPO");
//                datosExcelProveedores.get(i).get("CLASE");
//                datosExcelProveedores.get(i).get("USO");
//                System.out.println("Leer Matriz de excel origen" + datosExcelProveedores);
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return datosExcelProveedores();
//
//    }
//                for(int j=1; j<=numeroRegistros1 -1; j++{
//                    nit = obtenerDatos.get("NIT EMPRESA TITULAR DEL REGISTRO");
//
//                    System.out.println("Robot entro a Comparar EXCEL");
//                    if (obtenerDatos.get("NIT EMPRESA TITULAR DEL REGISTRO") != NIT){
//                        System.out.println("El registro es correcto");
//                        ClsLeerArchivoExcel.modificarExcel("Registro Correcto", i, 9, 1);
//                    } else {
//                        System.out.println("El nit es incorrecto, el correcto es: " + NIT);
//                        ClsLeerArchivoExcel.modificarExcel(NIT, i, 9, 1);
//
//                    }
//                }
//                if((ClsConstantesGlobales.empresa=datosExcel.get(i).get("NOMBRE DE LA EMPRESA TITULAR DEL REGISTRO "))!=EMPRESA){
//                    ClsLeerArchivoExcel.modificarExcel(EMPRESA, 9, 10, 2);
//                }if((ClsConstantesGlobales.numRegistro=datosExcel.get(i).get("REGISTRO DE VENTA No."))!=NUMREGISTRO){
//                    ClsLeerArchivoExcel.modificarExcel(NUMREGISTRO, 9, 11, 2);
//                }if((ClsConstantesGlobales.nombreProduct=datosExcel.get(i).get("NOMBRE COMERCIAL DEL PRODUCTO"))!=NOMBREPRODUCTO){
//                    ClsLeerArchivoExcel.modificarExcel(NOMBREPRODUCTO, 9, 12, 2);
//                }
//    public void consolidacion(String NIT, String EMPRESA, String NUMREGISTRO, String NOMBREPRODUCTO, String COMPGARANTIZADA,
//                              String CLASIFICACION3, String CLASIFICACION2, String CLASIFICACION1,
//                              String USO, int numeroRegistros){
//
//        //Crear lista para ExcelProveedores
//        int numeroRegistrosProveedores = ClsLeerArchivoExcel.contarFilasExcel(ClsConstantesGlobales.pathArchivoExcelFertilizantes, 1);
//        ArrayList<Map<String, String>> datosExcelProveedores = ClsLeerArchivoExcel.lecturaExcel(ClsConstantesGlobales.pathArchivoExcelFertilizantes, 1);
//
//        try{
//            //Bucle para recorrer la Matriz BD
//            for (int i= 0; i < numeroRegistros; i++){
//                //Bucle para recorrer ExcelProveedores
//                for(int j=0; j< datosExcelProveedores.size(); j++){
//
//                    if(datosExcelProveedores.get(j).containsKey("NIT EMPRESA TITULAR DEL REGISTRO")){
//                        nit=datosExcelProveedores.get(j).get("NIT EMPRESA TITULAR DEL REGISTRO");
//                        if((nit != null && nit.equals(NIT)){
//                            System.out.println("El Nit es correcto");
//                            ClsLeerArchivoExcel.modificarExcel("Correcto", j,9,1);
//                        }
//                    }else {
//                        System.out.println("Clave no encontrada en: " +j);
//                        //ClsLeerArchivoExcel.modificarExcel(NIT, j,9,1);
//                    }
//
//                }
//
//            }
//
//
//        }catch (Exception e){
//            System.err.println("Error de índice: " + e.getMessage());
//            e.printStackTrace();
//            System.out.println(e);
//        }
//
//    }
//    public void consolidacion(String NIT, String EMPRESA, String NUMREGISTRO, String NOMBREPRODUCTO, String COMPGARANTIZADA,
//                              String CLASIFICACION3, String CLASIFICACION2, String CLASIFICACION1,
//                              String USO, int numeroRegistros) {
//
//        // Crear lista para ExcelProveedores
//        System.out.println("El numero de registros de matriz BD es: " + numeroRegistros);
//        int numeroRegistrosProveedores = ClsLeerArchivoExcel.contarFilasExcel(ClsConstantesGlobales.pathArchivoExcelFertilizantes, 1);
//        ArrayList<Map<String, String>> datosExcelProveedores = ClsLeerArchivoExcel.lecturaExcel(ClsConstantesGlobales.pathArchivoExcelFertilizantes, 1);
//
//        try {
//            // Validar que la lista no esté vacía Excel Proveedores
//            if (datosExcelProveedores == null || datosExcelProveedores.isEmpty()) {
//                System.err.println("La lista de datos está vacía o no se cargó correctamente.");
//                return;
//            }
//
//            // Bucle para recorrer la matriz BD
//            for (int i = 1; i < numeroRegistros ; i++) {
//                System.out.println("Procesando registro de la BD en índice: " + i);
//                // Bucle para recorrer ExcelProveedores
//                for (int j = 0; j < numeroRegistrosProveedores -1; j++) {
//                    System.out.println("Comparando con registro del Excel en índice: " + j);
//                    //Map<String, String> filaProveedor = datosExcelProveedores.get(j);
//
//                    if (datosExcelProveedores.get(j).containsKey("NIT EMPRESA TITULAR DEL REGISTRO")) {
//                        nit=datosExcelProveedores.get(j).get("NIT EMPRESA TITULAR DEL REGISTRO");
//
//                        if (nit != null && nit.equals(NIT)) {
//                            System.out.println("El NIT es correcto");
//                            ClsLeerArchivoExcel.modificarExcel("Correcto", j, 9, 1);
//                        } else {
//                            System.out.println("El NIT no coincide para la fila: " + j);
//                            ClsLeerArchivoExcel.modificarExcel(NIT, j, 9, 1);
//                        }
//                    } else {
//                        System.out.println("Clave 'NIT EMPRESA TITULAR DEL REGISTRO' no encontrada en la fila: " + j);
//                    }
//                }
//            }
//        } catch (Exception e) {
//            System.err.println("Error en el método consolidacion: " + e.getMessage());
//            e.printStackTrace();
//        }
//    }
public void consolidacion(String NIT, String EMPRESA, String NUMREGISTRO, String NOMBREPRODUCTO, String COMPGARANTIZADA,
                          String CLASIFICACION3, String CLASIFICACION2, String CLASIFICACION1,
                          String USO, int numeroRegistros) {

    System.out.println("El numero de registros es: " +numeroRegistros);

    int numeroRegistrosProveedores = ClsLeerArchivoExcel.contarFilasExcel(ClsConstantesGlobales.pathArchivoExcelFertilizantes, 1);
    ArrayList<Map<String, String>> datosExcelProveedores = ClsLeerArchivoExcel.lecturaExcel(ClsConstantesGlobales.pathArchivoExcelFertilizantes, 1);

    try {
        if (datosExcelProveedores == null || datosExcelProveedores.isEmpty()) {
            System.err.println("La lista de datos está vacía o no se cargó correctamente.");
            return;
        }

        // Bucle para recorrer la matriz BD
        for (int i = 0; i < numeroRegistros; i++) {
            System.out.println("Procesando registro de la BD en índice: " + i);

            // Bucle para recorrer ExcelProveedores
            for (int j = 0; j < numeroRegistrosProveedores; j++) {
                System.out.println("Comparando con registro del Excel en índice: " + j);
                nit = datosExcelProveedores.get(j).get("NIT EMPRESA TITULAR DEL REGISTRO");
                if (nit != null && nit.equals(NIT)) {
                    System.out.println("El NIT es correcto");
                    ClsLeerArchivoExcel.modificarExcel("Correcto", j, 9, 1);
                } else {
                    System.out.println("El NIT no coincide para la fila: " + j);
                    ClsLeerArchivoExcel.modificarExcel(NIT, j, 9, 1);
                }

            }
        }
    } catch (Exception e) {
        System.err.println("Error en el método consolidacion: " + e.getMessage());
        e.printStackTrace();
    }
}


}

