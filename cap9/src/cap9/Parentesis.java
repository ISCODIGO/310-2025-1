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
    /*
    
    (2 + 3) / ((3 + 4) * 3))
    
    
    */
    
    public static void main(String[] args) {
        String comando = "(2 + 3) / ((3 + 4) * 3)()(()";
        Stack<Character> pila = new StackLL<>();
        
        for(char item : comando.toCharArray()) {
            if (item == '(') {
                pila.push(item);
            }
            
            if (item == ')') {
                if (pila.isEmpty()) {
                    System.out.println("ERROR: Pila con un cierre extra");
                    return;
                }
                pila.pop();
            }
        }
        
        if (!pila.isEmpty()) {
            System.out.println("ERROR: Pila con una apertura extra");
        } else {
            System.out.println("OK");
        }
    }
}
