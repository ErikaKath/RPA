package com.co.rpa.ica.runners;

import com.co.rpa.ica.logica.steps.ClsFetilizantesSteps;
import com.co.rpa.ica.stepsDefinitions.Cls_Validar_Tipos_Insumos_Agricolas;

public class Cls_Validar_Tipos_Insumos_Agricola_Runner {
    public static void main(String[] args) {
        // Cls_Validar_Tipos_Insumos_Agricolas.run();
        ClsFetilizantesSteps.validarExcelFertilizantes();
        //System.exit(0);

    }
}