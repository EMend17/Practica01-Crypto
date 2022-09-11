/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.practica01;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author EMend17
 */
public class fileHandler {

    public fileHandler() {
    }
    

    public static String modFileName(String path, char c) {
        int index = path.lastIndexOf(".txt");
        StringBuffer sb = new StringBuffer(path);
        sb.insert(index, "_"+c);
        return sb.toString();
    }

    public static String readFile(String path) throws IOException {
        String contenido = null;
        try {
            BufferedReader lector = new BufferedReader(new FileReader(path));
            StringBuilder cadena = new StringBuilder();
            String line = null;

            while ((line = lector.readLine()) != null) {
                cadena.append(line);

            }
            lector.close();
            contenido = cadena.toString();
            // System.out.println(contenido);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return contenido;
    }

    public static void writeFile(String filePath, String fileContent) throws IOException {

        Path path = Paths.get(filePath);
        byte[] strToBytes = fileContent.getBytes(StandardCharsets.UTF_8);

        Files.write(path, strToBytes);
    }

}
