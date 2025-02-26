/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cap9;

/**
 *
 * @author enrique
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        StackArray<Integer> pila = new StackArray<>(10);
        
        pila.push(10);
        pila.push(20);
        pila.push(30);  // <- cima
        
        while(!pila.isEmpty()) {
            System.out.println(pila.pop());
        }
    }
    
}
