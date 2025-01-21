package com.co.rpa.ica.logica.utils;

import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class ClsDriver {
    public static WebDriver driver;
    public static WebDriver getDriver(){
        return driver;
    }
    public static WebDriver setDriver(WebDriver driver2){
        return driver = driver2;
    }

    public static void inicarNavegador(String url){
        String tipoNavegador = ClsEpecialMetodos.properties.getProperty("opcionTipoNavegador");
        String segundoPlano = ClsEpecialMetodos.properties.getProperty("opcionSegundoPlano");
        System.out.println("INFO: Iniciar Navegador url: " + url);

        String segundoPlanoHeadless = segundoPlano.equals("1") ? "--headless ": "--test-type";
        WebDriver driver = null;
        if(tipoNavegador.equals("1")){//Chrome
            try{
                System.out.println("INFO: Inicia Chrome ..." + ClsConstantesGlobales.pathRutaDriverChromeDR);
                System.setProperty("webdriver.chrome.driver", ClsConstantesGlobales.pathRutaDriverChromeDR);
                ChromeOptions options = new ChromeOptions();
                options.setBinary(ClsConstantesGlobales.pathRutaDriverChrome);
                options.addArguments(
                        segundoPlanoHeadless,
                        "--disable-popup-bloking",
                        "--start-maximized",
                        "--test-type",
                        "--ignore-certificate-errors",
                        "--always-authorize-plugins",
                        "--disable-extensions",
                        "--disable-dev-shm-usage",
                        "--safebrowsing-disable-download-protection",
                        "safebrowsing-disable-extension-blacklist"
                        );
                Map<String, Object> prefs = new HashMap<>();
                prefs.put("download.default_directory", ClsConstantesGlobales.pathDescargas);
                prefs.put("profile.default_content_setting.popups", 0);
                prefs.put("download.prompt_for_download", false);
                prefs.put("safebrowsing.enabled", true);
                options.setExperimentalOption("prefs", prefs);
                driver = new ChromeDriver(options);

            }catch(SessionNotCreatedException e){
                handleSessionNotCreatedException(e,"Chrome");

            }
        }else { //edge
            try{
                System.out.println("INFO: Inicia Navegador Edge ..." + ClsConstantesGlobales.pathRutaDriverEdge);
                System.setProperty("webdriver.edge.driver", ClsConstantesGlobales.pathRutaDriverEdge);
                EdgeOptions options = new EdgeOptions();
                Map<String, Object> edgeOptions = new HashMap<>();
                List<String> arg = new ArrayList<>();
                arg.add("--disable-popup-bloking"); /**/
                arg.add(segundoPlano.equals("1")?"--start-minimized":"--start-maximized");
                arg.add("--test-type");
                arg.add("--ignore-certificate-errors");
                arg.add("--always-authorize-plugins");
                arg.add("--disable-extensions");
                arg.add("--disable-dev-shm-usage");
                arg.add("--safebrowing-disable-download-protection");
                arg.add("safebrowing-disable-extension-blacklist");
                edgeOptions.put("arg", arg);
                Map<String, Object> prefs = new HashMap<>();
                prefs.put("download.default_directory", ClsConstantesGlobales.pathDescargas);
                prefs.put("profile.default_content_settings.popups", 0);
                prefs.put("download.prompt_for_download", false);
                prefs.put("safebrowsing.enable", true);
                edgeOptions.put("prefs", prefs);
                options.setCapability("ms:edgeOptions", edgeOptions);
                driver = new EdgeDriver(options);
            }catch (SessionNotCreatedException e){
                handleSessionNotCreatedException(e, "Edge");
            }catch (Exception e){
                excepcion(e, url);
            }
        }if(driver != null){
            driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
            driver.get(url);
            System.out.println("INFO: Finaliza iniciar Navegador");
            System.out.println("...................................");
            ClsDriver.setDriver(driver);
        }
    }
    private static void handleSessionNotCreatedException(SessionNotCreatedException e, String browser){
        if (e.getMessage().contains("This version of " + browser + "Driver only supports " + browser + "verison")){
            System.out.println("*******************************************************************************************************************************************************");
            System.out.println("ERROR: El controlador de " + browser + "esta desactualizado. Actualiza" + browser + "Driver a la version compatible con tu navegador" + browser + ".");
            System.out.println("********************************************************************************************************************************************************");
        }else {
            ClsConstantesGlobales.intentosNavegador++;
            if (ClsConstantesGlobales.intentosNavegador <3){
                e.printStackTrace();
                System.out.println("Error: Inicia Nuevamente el Navegador Chrome intentos Navegador: " + ClsConstantesGlobales.intentosNavegador);
                ClsDriver.eleiminarProcesos();
                inicarNavegador(browser);
            }
        }
    }
    public static void excepcion(Exception e, String url){
        if (e.getMessage().contains("Exception in thread main org.selenium.WebDriverException: Timed out waiting for driver server to start.")){
            System.out.println("*************************************************************************************************************************");
            System.out.println("ERROR: Exeption in thread \"main\" org.openga.selenium.WebDriverException: Timed out waiting for driver server to start.");
            System.out.println("*************************************************************************************************************************");
            ClsDriver.eleiminarProcesos();
            inicarNavegador(url);
        }else {
            System.out.println("ERROR: Error Al Iniciar el Driver");
            ClsDriver.eleiminarProcesos();
            inicarNavegador(url);
        }
    }
    public static void eleiminarProcesos(){
        try{
            ClsKillProcess.kProcess("iexplore.exe");
            ClsKillProcess.kProcess("chromedriver.exe");
            ClsKillProcess.kProcess("Winium.Desktop.Driver.exe");
            ClsKillProcess.kProcess("webdriver.chrome.driver");
            ClsKillProcess.kProcess("msedgedriver.exe");
            ProcessBuilder processBuilder = new ProcessBuilder("D:\\WebDrivers\\CerrarProceso.bat");
            Process proceso =processBuilder.start();
        }catch (Exception ignored){
            System.out.println("Error: Al eliminar Procesos");
        }
    }
    public static class ClsKillProcess{
        public static void kProcess(String archivo){
            //kill process Winium
            String osName = System.getProperty("os.name");
            System.out.println("Eliminar procesos " + osName.toUpperCase());
            if(osName.toUpperCase().contains("WIN")){
                try{
                    String comando = "taskkill /F /IM" + archivo;
                    Process proceso = Runtime.getRuntime().exec(comando);
                    proceso.waitFor();
                }catch (Exception e){
                    System.out.println("No" + e);
                }
            }
        }
    }

}
