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
        ArrayList<String> valoresEng;
        ArrayList<String> valoresFren;
        System.out.println("----------BIENVENIDO----------");
        int opcion = 0;
        Scanner scan = new Scanner(System.in);
        Scanner scanstring = new Scanner(System.in);
        while (opcion != 8) {
            System.out.println("\n¿Que desea hacer?\n1.Imprimir diccionario In-Order en Ingles\n2.Imprimir diccionario In-Order en Frances\n3.Traducir entrada\n4.Traducir archivo\n5.Anadir palabra\n6.Modificar palabra\n7.Eliminar palabra\n8.Salir");
            opcion = scan.nextInt();
            String temp = "";
            while (opcion <= 0 || opcion > 8) {
                System.out.println("Ingrese una opcion valida");
                opcion = scan.nextInt();
            }
            if (opcion == 1) {
                english.inOrder(dictEng);
                valoresEng = dictEng.getTraducciones();
                System.out.println("\n--------DICCIONARIO EN INGLES----------");
                System.out.println(diccionario(english, valoresEng) + "\n");
            } else if (opcion == 2) {
                french.inOrder(dictFren);
                valoresFren = dictFren.getTraducciones();
                System.out.println("\n--------DICCIONARIO EN FRANCES---------");
                System.out.println(diccionario(french, valoresFren) + "\n");
            } else if (opcion == 3) {
                System.out.println("\nIngrese su oracion");
                temp = scanstring.nextLine();
                if (detectar(english, french, temp) == null) {
                    System.out.println(traducir(french, temp));
                } else if (detectar(english, french, temp).equals("Ingles")) {
                    System.out.println("\nLa oracion esta en Ingles:");
                    System.out.println(traducir(english, temp));
                } else if (detectar(english, french, temp).equals("Frances")) {
                    System.out.println("\nLa oracion esta en Frances:");
                    System.out.println(traducir(french, temp));
                }
            } else if (opcion == 4) {

            } else if (opcion == 5) {
                temp = "";
                System.out.println("Ingrese la palabra en espanol");
                temp = temp + scanstring.nextLine();
                System.out.println("Ingrese la palabra en ingles");
                temp = temp + "," + scanstring.nextLine();
                System.out.println("Ingrese la palabra en frances");
                temp = temp + "," + scanstring.nextLine();
                String[] palabras = temp.split(",");
                english.insert(palabras[1].trim().toLowerCase(), palabras[0].trim().toLowerCase());
                french.insert(palabras[2].trim().toLowerCase(), palabras[0].trim().toLowerCase());
            } else if (opcion == 6) {
                System.out.println("\nIngrese la palabra que desea modificar en idioma extranjero");
                temp = scanstring.nextLine();
                if (detectar(english, french, temp) == null) {
                    System.out.println("No se encontro la palabra a modificar");
                } else if (detectar(english, french, temp).equals("Ingles")) {
                    System.out.println("\nIngrese la nueva palabra en idioma ingles");
                    temp = temp+","+scanstring.nextLine();
                    System.out.println("\nIngrese la nueva palabra en idioma espanol");
                    temp = temp+","+scanstring.nextLine();
                    String[] temp2 = temp.split(",");
                    modificar(english, temp2[0], temp2[1], temp2[2]);
                } else if (detectar(english, french, temp).equals("Frances")) {
                    System.out.println("\nIngrese la nueva palabra en idioma frances");
                    temp = temp+","+scanstring.nextLine();
                    System.out.println("\nIngrese la nueva palabra en idioma espanol");
                    temp = temp+","+scanstring.nextLine();
                    String[] temp2 = temp.split(",");
                    modificar(french, temp2[0], temp2[1], temp2[2]);
                }
            } else if(opcion == 7){
                System.out.println("\nIngrese la palabra que desea elimiar en idioma extranjero");
                temp = scanstring.nextLine();
                if (detectar(english, french, temp) == null) {
                    System.out.println("No se encontro la palabra a modificar");
                } else if (detectar(english, french, temp).equals("Ingles")) {
                    english.delete(temp);
                } else if (detectar(english, french, temp).equals("Frances")) {
                    french.delete(temp);
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
            if (eng.find(word) != null) {
                return "Ingles";
            } else if (fren.find(word) != null) {
                return "Frances";
            }
        }
        return null;
    }

    public static void modificar(BinarySearchTree<String, String> dict, String target, String key, String value) {
        if (dict.find(target) == null) {
            System.out.println("No se encontró la palabra");
        } else {
            dict.delete(target);
            dict.insert(key, value);
        }
    }

}
