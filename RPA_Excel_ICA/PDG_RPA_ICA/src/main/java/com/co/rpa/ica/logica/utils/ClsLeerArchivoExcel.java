package com.co.rpa.ica.logica.utils;
/***
 * Esta clase contiene los metodos y variables para la lectura y ecritura y creación del excel
 * Proyecto de Grado ECCI (Bogota-Colombia)
 *  Erika Olivera
 *   @version 1.0 05/12/2024
 */

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ClsLeerArchivoExcel {
    public static int contarFilasExcel(String filePath, int numeroPagina){
        int rowCount= 0;
        try(FileInputStream fileInputStream = new FileInputStream(filePath)){
            Workbook workbook = WorkbookFactory.create(fileInputStream);
            Sheet sheet = workbook.getSheetAt(numeroPagina);
            rowCount = sheet.getPhysicalNumberOfRows();
            System.out.println("EL número de filas en las hoja " + numeroPagina + " es: " + rowCount);
        }catch (Exception e){
            e.printStackTrace();
        }
        return rowCount;
    }
    public static ArrayList<Map<String, String>> lecturaExcel(String path, int numHoja){
        ArrayList<Map<String, String>>excelToData = new ArrayList<>();
        Map<String, String>aux = new HashMap<>();
        try{
            File file = new File(path);
            System.out.println("Path desde lectura de excel: " + path);
            InputStream inputStream = new FileInputStream(file);
            System.out.println("Path desde lectua de file: " + file);
            System.out.println("Path desde lectura de inputStream: " + inputStream.toString());
            Workbook workbook = WorkbookFactory.create(inputStream);
            Sheet sheet = workbook.getSheetAt(numHoja);
            Iterator<Row>rowIterator = sheet.rowIterator();
            Row title = rowIterator.next();
            while (rowIterator.hasNext()){
                Row row = rowIterator.next();
                Iterator<Cell>cellIterator = row.cellIterator();
                while (cellIterator.hasNext()){
                    Cell cell = cellIterator.next();
                    cell.getColumnIndex();
                    switch (cell.getCellType()){
                        case STRING:
                            aux.put(
                                    String.valueOf(title.getCell(cell.getColumnIndex())),
                                    cell.getStringCellValue());
                            break;
                        case NUMERIC:
                            aux.put(
                                    String.valueOf(title.getCell(cell.getColumnIndex())),
                                    String.valueOf((long) cell.getNumericCellValue()));
                            break;
                        case FORMULA:
                            switch (cell.getCachedFormulaResultType()){
                                case STRING:
                                    aux.put(
                                            String.valueOf(title.getCell(cell.getColumnIndex())),
                                            cell.getStringCellValue());
                                    break;
                                case NUMERIC:
                                    aux.put(
                                            String.valueOf(title.getCell(cell.getColumnIndex())),
                                            String.valueOf((double) cell.getNumericCellValue()));
                                    break;
                            }
                        case BLANK:
                            aux.put(title.getCell(cell.getColumnIndex()).toString(), " ");
                            break;
                    }
                }
                excelToData.add(aux);
                aux = new HashMap<>();
            }
        }catch (FileNotFoundException ex){
            System.out.println("Excepcion archivo no encontrado: " + ex);
            return  null;
        }catch (NullPointerException ex){
            System.out.println("Excepcion archivo vacio: " + ex);
            return null;
        }catch (Exception e){
            e.printStackTrace();
        }
        return excelToData;
    }
    public static void modificarExcel(String modificarValue, int row, int cell, int hoja){
        try{
            byte[] archivo = FileUtils.readFileToByteArray(new File(ClsConstantesGlobales.pathArchivoExcel));
            InputStream inputStream = new ByteArrayInputStream(archivo);
            //Guardamos el archivo excel
            XSSFWorkbook newWorkbook = new XSSFWorkbook(inputStream);
            XSSFSheet newSheet = newWorkbook.getSheetAt(hoja);
            XSSFRow fila = newSheet.getRow(row);
            if (fila == null){
                fila = newSheet.createRow(row);
            }
            XSSFCell celda = fila.getCell(cell);
            if (celda == null){
                celda = fila.createCell(cell);
            } celda.setCellValue(modificarValue);
            FileOutputStream fileOut = new FileOutputStream(ClsConstantesGlobales.pathArchivoExcel);
            newWorkbook.write(fileOut);
            fileOut.close();
        }catch (Exception e){
            System.out.println("No se leyo correctamente el excel");
            e.printStackTrace();
            e.getCause();
        }
    }

}
