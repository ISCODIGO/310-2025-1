package com.mycompany.cap11;

import com.mycompany.colas.ColaLL;
import com.mycompany.colas.ICola;

/**
 *
 * @author enrique
 */
public class ColaPrioridad<T> {
    private ColaLL<T>[] tabla;
    private int cantidad;

    @SuppressWarnings("unchecked")
    public ColaPrioridad(int capacidad) {
        this.tabla = (ColaLL<T>[]) new ColaLL[capacidad];
        for (int i = 0; i < capacidad; i++) {
            tabla[i] = new ColaLL<>();
        }
        this.cantidad = 0;
    }

    private int getPrioridadMaxima() {
        for (int i = 0; i < tabla.length; i++) {
            if (!tabla[i].estaVacio()) {
                return i;
            }
        }
        return -1;
    }

    public boolean encolar(T dato, int prioridad) {
        if (prioridad < 0 || prioridad >= tabla.length) {
            throw new IllegalArgumentException("Prioridad inválida");
        }

        tabla[prioridad].encolar(dato);
        cantidad++;
        return true;
    }

    public T desencolar() {
        if (estaVacio()) {
            throw new RuntimeException("Cola Vacia");
        }
        int prioridad = getPrioridadMaxima();
        cantidad--;
        return tabla[prioridad].desencolar();
    }

    public boolean estaVacio() {
        return cantidad == 0;
    }

    public static void main(String[] args) {
        ColaPrioridad<String> cola = new ColaPrioridad<>(5);

        cola.encolar("1 - Persona con prioridad 1", 1);
        cola.encolar("2 - Persona con prioridad 2", 2);
        cola.encolar("3 - Persona con prioridad 3", 3);
        cola.encolar("4 - Persona con prioridad 4", 4);
        cola.encolar("5 - Persona con prioridad 0", 0);
        cola.encolar("6 - Persona con prioridad 1", 1);
        cola.encolar("7 - Persona con prioridad 2", 2);
        cola.encolar("8 - Persona con prioridad 3", 3);
        cola.encolar("9 - Persona con prioridad 4", 4);
        cola.encolar("10 - Persona con prioridad 0", 0);
        cola.encolar("11 - Persona con prioridad 3", 3);
        cola.encolar("12 - Persona con prioridad 2", 2);
        cola.encolar("13 - Persona con prioridad 0", 0);
        cola.encolar("14 - Persona con prioridad 1", 1);
        cola.encolar("15 - Persona con prioridad 2", 2);
        cola.encolar("16 - Persona con prioridad 3", 3);
        cola.encolar("17 - Persona con prioridad 4", 4);
        cola.encolar("18 - Persona con prioridad 0", 0);
        cola.encolar("19 - Persona con prioridad 1", 1);
        cola.encolar("20 - Persona con prioridad 2", 2);
        cola.encolar("21 - Persona con prioridad 3", 3);
        cola.encolar("22 - Persona con prioridad 4", 4);
        cola.encolar("23 - Persona con prioridad 4", 4);

        while (!cola.estaVacio()) {
            System.out.println(cola.desencolar());
        }
    }
}
