/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarytree;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Sebastián
 */
public class Lector {
    public static ArrayList<String[]> leerArchivo(String path) {
        ArrayList<String[]> array = new ArrayList<>();
        String temp;
        try {
            File doc = new File(path);
            Scanner obj = new Scanner(doc);
            while (obj.hasNextLine()) {
                temp = obj.nextLine().trim();
                array.add(temp.split(","));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return array;
    }
}
