/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.priority;

/**
 *
 * @author enrique
 */
public class Nodo<T> implements Comparable<Nodo<T>> {
    private T dato;
    private int prioridad;

    public Nodo(T dato, int prioridad) {
        this.dato = dato;
        this.prioridad = prioridad;
    }

    /**
     * @return the dato
     */
    public T getDato() {
        return dato;
    }

    /**
     * @param dato the dato to set
     */
    public void setDato(T dato) {
        this.dato = dato;
    }

    /**
     * @return the prioridad
     */
    public int getPrioridad() {
        return prioridad;
    }

    /**
     * @param prioridad the prioridad to set
     */
    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    @Override
    public int compareTo(Nodo<T> o) {
        return Integer.compare(this.prioridad, o.prioridad);
    }
}
