package com.co.rpa.ica.logica.steps;

import com.co.rpa.ica.logica.utils.ClsConstantesGlobales;
import com.co.rpa.ica.logica.utils.ClsLeerArchivoExcel;

import java.util.ArrayList;
import java.util.Map;

public class ClsFetilizantesSteps {


    public static void validarExcelFertilizantes() {

        ClsConsolidacionFertilizantesSteps clsConsolidacionFertilizantesSteps = new ClsConsolidacionFertilizantesSteps();
        int numeroRegistros = ClsLeerArchivoExcel.contarFilasExcel(ClsConstantesGlobales.pathArchivoExcelFertilizantes, 0);
        System.out.println("numeroRegistros: " + numeroRegistros);
        ArrayList<Map<String, String>> datosExcelMatriz = ClsLeerArchivoExcel.lecturaExcel(ClsConstantesGlobales.pathArchivoExcelFertilizantes, 0);

        try{
            for (int i = 0; i <= numeroRegistros -1; i++) {
                if (datosExcelMatriz !=null){
                    clsConsolidacionFertilizantesSteps.consolidacion(
                            datosExcelMatriz.get(i).get("NIT"),
                            datosExcelMatriz.get(i).get("EMPRESA"),
                            datosExcelMatriz.get(i).get("NUMREGISTRO"),
                            datosExcelMatriz.get(i).get("NOMBREPRODUCTO"),
                            datosExcelMatriz.get(i).get("COMPGARANTIZADA"),
                            datosExcelMatriz.get(i).get("CLASIFICACION3"),
                            datosExcelMatriz.get(i).get("CLASIFICACION2"),
                            datosExcelMatriz.get(i).get("CLASIFICACION1"),
                            datosExcelMatriz.get(i).get("USO"), i);
                    //System.out.println("Leer Matriz de excel origen" + datosExcelMatriz);

                }else {
                    System.out.println("El NIT es null para el registro en la posición " + i );
                }

            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
