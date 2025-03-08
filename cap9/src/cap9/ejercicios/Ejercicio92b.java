/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cap9.ejercicios;

import cap9.Stack;
import cap9.StackArray;
import cap9.StackLL;

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
        Stack<Character> pila1 = new StackLL<>();
        Stack<Character> pila2 = new StackArray<>(s.length());
        if (!s.contains("&")) return false;
        
        // desde el inicio hasta & ----->
        int i = 0;
        char letra;
        
        while(true) {
            letra = s.charAt(i);
            if (letra == '&') {
                break;
            }
            pila1.push(letra);
            i++;
        }        
        
        // desde el final hasta &  <------
        int j = s.length() - 1;
        while (true) {
            letra = s.charAt(j);
            if (letra == '&') break;
            pila2.push(letra);
            j--;
        }
        
        while (!pila1.isEmpty() && !pila2.isEmpty()) {
            char c1 = pila1.pop();
            char c2 = pila2.pop();
            if (c1 != c2) {
                return false;
            }
        }
        
        if (!pila1.isEmpty() || !pila2.isEmpty()) return false;
        return true;       
    }
    
}
