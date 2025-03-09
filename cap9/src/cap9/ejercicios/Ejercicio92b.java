/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cap9.ejercicios;

import cap9.IPila;
import cap9.PilaArr;
import cap9.PilaLL;

/**
 *
 * @author enrique
 */
public class Ejercicio92b {    
    public static void main(String[] args) {
        String frase = "abcd&dcba";
        System.out.println(probar(frase));
        
    }
    
    // O(n)
    public static boolean probar(String s) {
        IPila<Character> pila1 = new PilaLL<>();
        IPila<Character> pila2 = new PilaArr<>(s.length());
        if (!s.contains("&")) return false;
        
        // desde el inicio hasta & ----->
        int i = 0;
        char letra;
        
        while(true) {
            letra = s.charAt(i);
            if (letra == '&') {
                break;
            }
            pila1.apilar(letra);
            i++;
        }        
        
        // desde el final hasta &  <------
        int j = s.length() - 1;
        while (true) {
            letra = s.charAt(j);
            if (letra == '&') break;
            pila2.apilar(letra);
            j--;
        }
        
        // comparar cada elemento para saber si hay diferencias
        while (!pila1.estaVacio()&& !pila2.estaVacio()) {
            char c1 = pila1.desapilar();
            char c2 = pila2.desapilar();
            if (c1 != c2) {
                return false;
            }
        }
        
        if (!pila1.estaVacio()|| !pila2.estaVacio()) return false;
        return true;       
    }
    
}
