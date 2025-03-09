/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.colas;

import java.util.LinkedList;

/**
 *
 * @author enrique
 */
public class ColaLL<T> implements ICola<T> {
    private LinkedList<T> lista; // frente: ultimo (remover), fin: primero (insertar)

    public ColaLL() {
        lista = new LinkedList<>();
    }

    @Override
    public boolean encolar(T dato) {
        lista.addFirst(dato);
        return true;
    }

    @Override
    public T desencolar() {
        return lista.removeLast();
    }

    @Override
    public boolean estaVacio() {
        return lista.isEmpty();
    }

    @Override
    public T frente() { // O(1)
        return lista.getLast();
    }

    @Override
    public void limpiar() {
        lista.clear();
    }
}
