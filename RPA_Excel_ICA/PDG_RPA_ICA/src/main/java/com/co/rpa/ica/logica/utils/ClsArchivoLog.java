package com.co.rpa.ica.logica.utils;
/***
 * Esta clase contiene los metodos para LOGS del proyecto
 * Proyecto de Grado ECCI (Bogota-Colombia)
 * Erika Olivera
 * @version 1.0 05/12/2024
 */

import org.apache.commons.io.output.TeeOutputStream;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;



public class ClsArchivoLog {

    public static void crearArchivoTxt_LOG(){
        try{
            DateFormat dateFormat = new SimpleDateFormat("EEE d MMM yyyy HH-mm");
            DateFormat dateFormat1 = new SimpleDateFormat("EEE d MMM yyyy HH-mm-ss");
            String date = dateFormat.format(new Date());
            String date2 = dateFormat1.format(new Date());
            System.out.println("Inicio de ejecucion: " + date2);
            FileWriter fichero = new FileWriter("" + date + ".txt");
            ClsConstantesGlobales.nombreArchivoLog = "" + date + ".txt";
            System.out.println("Log situado en: " + ClsConstantesGlobales.nombreArchivoLog);
            fichero.write("Ejecucion: " + date);
            fichero.close();
            System.out.println("Inicio Ejecucion: " +date2);
        }catch (Exception e){
            System.out.println("Ocurrio un error al crear el archivo MASIVO TXT");
            e.printStackTrace();
        }
    }
    public static void inciarRegistro() throws IOException {
        File file = new File(ClsConstantesGlobales.nombreArchivoLog);
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        //Crear un duplicado de las salida estanadar (System.out)
        PrintStream consoleStream = System.out;
        //Redirigir la salida estandar al archivo
        PrintStream fileStream = new PrintStream(fileOutputStream);
        System.setOut(new PrintStream(new TeeOutputStream(consoleStream, fileStream)));
    }

}
