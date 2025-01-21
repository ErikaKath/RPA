package com.co.rpa.ica.logica.utils;

import javax.swing.*;

public class ClsSolicitarTipoDeRobot {
    public static String opcion = null;
    private static ImageIcon icon = new ImageIcon(ClsConstantesGlobales.pathIconos);

    public static String solicitarOpcionRobot(){
        opcion = JOptionPane.showInputDialog(null, "<html> Ingresa el tipo de insumo agricula a validar: <br>"
        +"<br>"
        +"1 - Fertilizantes <br>"
        +"<br>"
        +"2 - Plagicidas <br>"
        +"<br>"
        +"3 - Bioinsumos <br>"
        +"<br>"
        +"</html>",
                "Robot Validacion Insumos Agricolas", -1, icon, null, "").toString();
        if(opcion.isEmpty()){
            JOptionPane.showMessageDialog(
                    null,
                    "<html>Dbe ingresar una opcion valida ! <br>"
                    +"<br>"
                    +"</html>",
                    "Opcion no valida",
                    JOptionPane.PLAIN_MESSAGE);
        }else {
            JOptionPane.showMessageDialog(
                    null,
                    "<html> Su opcion de preuba es: <br>"
                    +"<br>"
                    +opcion
                    +"</html>",
                    "Opcion valida",
                    JOptionPane.PLAIN_MESSAGE);
        }
        ClsConstantesGlobales.opcionRobot=opcion;
        System.out.println("INFO: El robot se encuenta en la opcion: " + opcion);
        return opcion;
    }
}
