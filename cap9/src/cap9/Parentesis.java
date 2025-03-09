/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cap9;

/**
 *
 * @author enrique
 */
public class Parentesis {
    
    public static void main(String[] args) {
        String comando = "(2 + 3) / ((3 + 4) * 3)()(()";
        IPila<Character> pila = new PilaLL<>();

        for (char item : comando.toCharArray()) {
            if (item == '(') {
                pila.apilar(item);
            }

            if (item == ')') {
                if (pila.estaVacio()) {
                    System.out.println("ERROR: Pila con un cierre extra");
                    return;
                }
                pila.desapilar();
            }
        }

        if (!pila.estaVacio()) {
            System.out.println("ERROR: Pila con una apertura extra");
        } else {
            System.out.println("OK");
        }
    }
}
