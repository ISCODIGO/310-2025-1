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
        Queue<Integer> cola = new QueueArray<>(10);
        
        // probar isEmpty()
        System.out.println("Prueba cuando no hay elementos.");
        System.out.print("Esta vacia: ");
        System.out.println(true == cola.isEmpty());
        
        // probar enqueue
        System.out.println("\nPruebas de Enqueue...");
        System.out.println("Encolar 10.");
        cola.enqueue(10);
        System.out.print("Esta vacia: ");
        System.out.println(false == cola.isEmpty());
        System.out.print("Frente: ");
        System.out.println(10 == cola.front());

        System.out.println("Encolar 20.");
        cola.enqueue(20);
        System.out.print("Esta vacia: ");
        System.out.println(false == cola.isEmpty());
        System.out.print("Frente: ");
        System.out.println(10 == cola.front());
        
        // probar dequeue
        System.out.println("\nPruebas de Dequeue...");
        System.out.print("Eliminar 10: ");
        System.out.println(10 == cola.dequeue());
        System.out.print("Frente: ");
        System.out.println(20 == cola.front());
        System.out.print("Eliminar 20: ");
        System.out.println(20 == cola.dequeue());
        System.out.print("Esta vacia: ");
        System.out.println(true == cola.isEmpty());
    }
    
    public static void test_circular()
    {
        QueueArrayCircular<Integer> c = new QueueArrayCircular<>(4);
        c.enqueue(10);
        c.enqueue(20);
        c.enqueue(30);
        c.enqueue(40); // ya esta lleno
        System.out.println("Esta lleno:" + (true == c.isFull()));
        
        c.dequeue();
        c.dequeue();
        c.dequeue();
        
        c.enqueue(50);  // posicion: 0
        System.out.println(Arrays.toString(c.arreglo));
        System.out.println("No esta lleno: " + (false == c.isFull()));
        System.out.println("Frente es 40: " + (40 == c.front()));
        
        c.dequeue();
        System.out.println("Frente es 50: " + (50 == c.front()));
        
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
