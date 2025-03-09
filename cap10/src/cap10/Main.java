/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cap10;

import java.util.Arrays;

/**
 *
 * @author enrique
 */
public class Main {
    public static void test() {
        // Probar la funcionalidad de una cola utilizando pruebas unitarias (intento)
        ICola<Integer> cola = new ColaArr<>(10);
        
        // probar isEmpty()
        System.out.println("Prueba cuando no hay elementos.");
        System.out.print("Esta vacia: ");
        System.out.println(true == cola.estaVacio());
        
        // probar enqueue
        System.out.println("\nPruebas de Enqueue...");
        System.out.println("Encolar 10.");
        cola.encolar(10);
        System.out.print("Esta vacia: ");
        System.out.println(false == cola.estaVacio());
        System.out.print("Frente: ");
        System.out.println(10 == cola.frente());

        System.out.println("Encolar 20.");
        cola.encolar(20);
        System.out.print("Esta vacia: ");
        System.out.println(false == cola.estaVacio());
        System.out.print("Frente: ");
        System.out.println(10 == cola.frente());
        
        // probar dequeue
        System.out.println("\nPruebas de Dequeue...");
        System.out.print("Eliminar 10: ");
        System.out.println(10 == cola.desencolar());
        System.out.print("Frente: ");
        System.out.println(20 == cola.frente());
        System.out.print("Eliminar 20: ");
        System.out.println(20 == cola.desencolar());
        System.out.print("Esta vacia: ");
        System.out.println(true == cola.estaVacio());
    }
    
    public static void test_circular()
    {
        ColaArrCircular<Integer> c = new ColaArrCircular<>(4);
        c.encolar(10);
        c.encolar(20);
        c.encolar(30);
        c.encolar(40); // ya esta lleno
        System.out.println("Esta lleno:" + (true == c.estaLlena()));
        
        c.desencolar();
        c.desencolar();
        c.desencolar();
        
        c.encolar(50);  // posicion: 0
        System.out.println(Arrays.toString(c.arreglo));
        System.out.println("No esta lleno: " + (false == c.estaLlena()));
        System.out.println("Frente es 40: " + (40 == c.frente()));
        
        c.desencolar();
        System.out.println("Frente es 50: " + (50 == c.frente()));
        
    }
    
    public static void main(String[] args) {
        test();
        test_circular();
        
        /*int cantidadElementos = 4;
        int posicion = 0;
        
        for (int i = 0; i < 10; i++) {
            int j = i % cantidadElementos;
            System.out.println("i=" + i + ", j=" + j);
            if (j >= cantidadElementos) System.out.println("Excede");
        }
        */
    }
}
