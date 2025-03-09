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
        PilaArr<Integer> pila = new PilaArr<>(10);
        
        pila.apilar(10);
        pila.apilar(20);
        pila.apilar(30);  // <- cima
        
        while(!pila.estaVacio()) {
            System.out.println(pila.desapilar());
        }
    }
    
}
