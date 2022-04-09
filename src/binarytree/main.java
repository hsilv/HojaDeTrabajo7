/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarytree;

import java.util.ArrayList;
import java.util.Comparator;

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
        for(String[] array: lectura){
            english.insert(array[0].trim(), array[1].trim());
            french.insert(array[2].trim(), array[1].trim());
        }
        System.out.println("----------BIENVENIDO----------");
    }
    
}
