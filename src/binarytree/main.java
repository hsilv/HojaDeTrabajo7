/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarytree;

import java.util.Comparator;

/**
 *
 * @author Sebastián
 */
public class main {
    public static void main(String[] args) {
        BinarySearchTree<String, String> arbol = new BinarySearchTree<>();
        arbol.insert("Hola", "Hello");
        arbol.insert("Gato", "Cat");
        arbol.insert("Xilofono", "Xilophone");
        arbol.insert("Parque", "Park");
        System.out.println(arbol);
    }
}
