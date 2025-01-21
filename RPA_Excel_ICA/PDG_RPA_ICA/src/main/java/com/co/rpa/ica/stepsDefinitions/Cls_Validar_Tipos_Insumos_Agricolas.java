package com.co.rpa.ica.stepsDefinitions;

import com.co.rpa.ica.logica.steps.ClsConsolidacionFertilizantesSteps;
import com.co.rpa.ica.logica.steps.ClsFetilizantesSteps;
import com.co.rpa.ica.logica.utils.ClsArchivoLog;
import com.co.rpa.ica.logica.utils.ClsConstantesGlobales;
import com.co.rpa.ica.logica.utils.ClsSolicitarTipoDeRobot;

/***
 * Esta clase contiene los metodo con lso stpes principales para la ejecución del robot
 * Proyecto de Grado ECCI (Bogota-Colombia)
 * Erika Olivera
 * @version 1.0 05/12/2024
 */
public class Cls_Validar_Tipos_Insumos_Agricolas {
    public static void run(){
        try{
            ClsArchivoLog.crearArchivoTxt_LOG();
            ClsArchivoLog.inciarRegistro();
            ClsSolicitarTipoDeRobot.solicitarOpcionRobot();
            switch (ClsConstantesGlobales.opcionRobot){
                case "1":
                    //Leer MatrizFertilizanteBase
                    ClsFetilizantesSteps.validarExcelFertilizantes();
                    //Consolidar Excel Proveedores

                    break;
                case "2":

                    break;
                case "3":
                    break;

                default:
                    System.out.println("INFO: La opción escogida no es correcta en las opciones propuestas. Intentalo de nuevo");
            }

        }catch (Exception e){
            e.getCause();
            e.printStackTrace();
            System.out.println(e);
        }


    }
}
