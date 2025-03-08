/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cap9.ejercicios;

import java.util.Stack;

/**
 *
 * @author enrique
 */
public class Ejercicio92 {
    // O(n)
    public static void main(String[] args) {
        String frase = "casiccc&isacc";
        
        Stack<Character> pila = new Stack<>();
        
        boolean seguir = true;
        int posicion = 0;
        while (seguir) {
            char letra = frase.charAt(posicion++);
            if (letra == '&') {
                break;
            }
            
            pila.push(letra);
        }
        
        while(posicion < frase.length()) {
            if (pila.isEmpty() || pila.pop() != frase.charAt(posicion++) ) {
                System.out.println("Frase erronea");
                return;
            }
        }
        
        if (!pila.isEmpty()) {
            System.out.println("Frase erronea");
        } else {
            System.out.println("Frase correcta");
        }
    }
}
