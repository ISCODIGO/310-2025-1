/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.monticulo;

/**
 * Este es nu ejemplo de un montículo binario implementado en Java. Un montículo de tipo Max-Heap
 * donde el valor del nodo raíz es mayor que los valores de sus hijos. El montículo se almacena en un
 * arreglo y se implementan las operaciones de inserción y eliminación.
 * @author enrique
 */
public class Monticulo {
    private int[] lista; // Arreglo para almacenar los elementos del montículo
    private int conteo; // Número de elementos en el montículo

    // Constructor para inicializar el montículo con una capacidad dada
    public Monticulo(int capacidad) {
        lista = new int[capacidad];
        conteo = 0;
    }

    // Devuelve el índice del padre del elemento en la posición pos
    public int padre(int pos) {
        return (pos - 1) / 2;
    }

    // Devuelve el índice del hijo izquierdo del elemento en la posición pos
    public int izquierda(int pos) {
        return 2 * pos + 1;
    }

    // Devuelve el índice del hijo derecho del elemento en la posición pos
    public int derecha(int pos) {
        return 2 * pos + 2;
    }

    // Mueve el elemento en la posición pos hacia arriba en el montículo para mantener la propiedad del montículo
    private int flotar(int pos) {
        int current = pos;
        while (current > 0 && lista[current] > lista[padre(current)]) {
            int temp = lista[current];
            lista[current] = lista[padre(current)];
            lista[padre(current)] = temp;
            current = padre(current);
        }
        return current;
    }

    // Inserta un nuevo elemento en el montículo
    public void insertar(int elemento) {
        lista[conteo++] = elemento;
        flotar(conteo - 1);
    }

    // Verifica si el montículo está vacío
    public boolean estaVacio() {
        return conteo == 0;
    }

    // Elimina y devuelve el elemento raíz del montículo
    public int eliminar() {
        if (estaVacio()) {
            throw new RuntimeException("El montículo está vacío");
        }
        int eliminado = lista[0];
        lista[0] = lista[--conteo];
        hundir(0);
        return eliminado;
    }

    // Mueve el elemento en la posición pos hacia abajo en el montículo para mantener la propiedad del montículo
    private void hundir(int pos) {
        int current = pos;
        while (izquierda(current) < conteo) {
            int mayorHijo = izquierda(current);
            if (derecha(current) < conteo && lista[derecha(current)] > lista[izquierda(current)]) {
                mayorHijo = derecha(current);
            }
            if (lista[current] >= lista[mayorHijo]) {
                break;
            }
            int temp = lista[current];
            lista[current] = lista[mayorHijo];
            lista[mayorHijo] = temp;
            current = mayorHijo;
        }
    }

    // Método principal para demostrar el uso de la clase Monticulo
    public static void main(String[] args) {
        Monticulo monticulo = new Monticulo(10);
        monticulo.insertar(5);
        monticulo.insertar(3);
        monticulo.insertar(8);
        monticulo.insertar(1);
        // Insertar el elemento 6 en el montículo
        monticulo.insertar(6);

        // La estructura del montículo después de insertar 6:
        //         8
        //       /   \
        //      5     6
        //     / \   /
        //    1   3  5

        System.out.println("Eliminado: " + monticulo.eliminar());
        System.out.println("Eliminado: " + monticulo.eliminar());
        System.out.println("Eliminado: " + monticulo.eliminar());
        System.out.println("Eliminado: " + monticulo.eliminar());
        System.out.println("Eliminado: " + monticulo.eliminar());
    }
}
