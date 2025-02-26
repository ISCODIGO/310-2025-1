/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cap8;

/**
 *
 * @author enrique
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Nodo<Integer> n1 = new Nodo<>(10);
        Nodo<Integer> n2 = new Nodo<>(20);
        var n3 = new Nodo<Integer>(30);
        var copia = n3;  // referencia a n3
        copia.setDato(300);
        System.out.println(n3.getDato());
        n1.setSiguiente(n2);  // n1 -> n2
        n2.setSiguiente(n3);  // n1 -> n2 -> n3 -> null
        n1.getSiguiente().getSiguiente().setDato(500);
        System.out.println(n3.getDato());
        
        
        
        
        
        
        
        ListaEnlazada<Integer> numeros = new ListaEnlazada<>();
        numeros.agregarPrimero(10);  // 2
        numeros.agregarPrimero(20);  // 1
        numeros.agregarPrimero(30);  // 0
        
        // 30 -> 20 -> 10
        
        System.out.println("20=" + numeros.get(1).getDato());
        System.out.println("10=" + numeros.get(2).getDato());
        
        numeros.print();
        
        numeros.insertar(25, 1);
        // 30 -> 25 -> 20 -> 10
        
        System.out.println("25=" + numeros.get(1).getDato());
        System.out.println("20=" + numeros.get(2).getDato());
        
        numeros.print();
        
    }
    
}
