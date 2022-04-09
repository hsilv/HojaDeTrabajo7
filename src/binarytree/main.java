/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarytree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author Sebastián
 */
public class main {

    public static void main(String[] args) {
        BinarySearchTree<String, String> english = new BinarySearchTree<>();
        BinarySearchTree<String, String> french = new BinarySearchTree<>();
        ArrayList<String[]> lectura = Lector.leerArchivo("F:\\Programacion\\BinaryTree\\src\\res\\diccionario.txt");
        System.out.println(lectura);
        DictTraversal dictEng = new DictTraversal();
        DictTraversal dictFren = new DictTraversal();
        for (String[] array : lectura) {
            english.insert(array[0].trim(), array[1].trim());
            french.insert(array[2].trim(), array[1].trim());
        }
        english.inOrder(dictEng);
        ArrayList<String> valoresEng = dictEng.getTraducciones();
        french.inOrder(dictFren);
        ArrayList<String> valoresFren = dictFren.getTraducciones();
        System.out.println("----------BIENVENIDO----------");
        int opcion = 0;
        Scanner scan = new Scanner(System.in);
        while (opcion != 8) {
            System.out.println("\n¿Que desea hacer?\n1.Imprimir diccionario In-Order en Ingles\n2.Imprimir diccionario In-Order en Frances\n3.Traducir entrada\n4.Traducir archivo\n5.Anadir entrada\n6.Modificar palabra\n7.Eliminar palabra\n8.Salir");
            opcion = scan.nextInt();
            String temp = "";
            while (opcion <= 0 || opcion > 8) {
                System.out.println("Ingrese una opcion valida");
                opcion = scan.nextInt();
            }
            if (opcion == 1) {
                System.out.println("\n" + diccionario(english, valoresEng) + "\n");
            } else if (opcion == 2) {
                System.out.println("\n" + diccionario(french, valoresFren) + "\n");
            } else if (opcion == 3) {
                if(detectar(english, french, "Oui muijer").equals("Ingles")){
                    System.out.println("\nLa oracion esta en Ingles:");
                    System.out.println(traducir(english, "Oui mujer"));
                } else if(detectar(english, french, "Oui muijer").equals("Frances")){
                    System.out.println("\nLa oracion esta en Frances:");
                    System.out.println(traducir(french, "Oui mujer"));
                } else{
                    System.out.println(traducir(french, "Oui mujer"));
                }
            }
        }

    }

    public static String diccionario(BinarySearchTree<String, String> dict, ArrayList<String> values) {
        String temp = "";
        for (String value : values) {
            temp = temp + "(" + value + "," + dict.find(value) + ")";
        }
        return temp;
    }

    public static String traducir(BinarySearchTree<String, String> dict, String phrase) {
        String[] words = phrase.split(" ");
        String temp = "";
        for (String word : words) {
            word = word.trim().toLowerCase();
            if (dict.find(word) != null) {
                if (temp.equals("")) {
                    temp = temp + dict.find(word);
                } else {
                    temp = temp + " " + dict.find(word);
                }
            } else {
                if (temp.equals("")) {
                    temp = temp + "*" + word + "*";
                } else {
                    temp = temp + " *" + word + "*";
                }
            }
        }
        return temp;
    }

    public static String detectar(BinarySearchTree<String, String> eng, BinarySearchTree<String, String> fren, String phrase) {
        String[] words = phrase.split(" ");
        for (String word : words) {
            word = word.trim().toLowerCase();
            if(eng.find(word) != null){
                return "Ingles";
            } else if(fren.find(word) != null){
                return "Frances";
            }
        }
        return null;
    }

}
