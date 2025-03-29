/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.algoritmos.cap13;

/**
 *
 * @author enrique
 */
public class ArbolBinario {

    class Nodo {
        int dato;
        Nodo izq;
        Nodo der;
        
        public Nodo(int dato) {
            this.dato = dato;
            this.izq = null;
            this.der = null;
        }
        
        public boolean esHoja() {
            return this.izq == null && this.der == null;
        }
    }
    
    Nodo raiz;
    int conteo = 0;
    
    public ArbolBinario(int inicio) {
        raiz = new Nodo(inicio);
        conteo = 1;
    }
    
    public Nodo agregarIzq(Nodo n, int dato) {
        n.izq = new Nodo(dato);
        conteo++;
        return n.izq;
    }
    
    public Nodo agregarDer(Nodo n, int dato) {
        n.der = new Nodo(dato);
        conteo++;
        return n.der;
    }
    
    public Nodo agregarIzq(int dato) {
        return this.agregarIzq(raiz, dato);
    }
    
    public Nodo agregarDer(int dato) {
        return this.agregarDer(raiz, dato);
    }
    
    public void postorden(Nodo n) {
        if (n == null){
            return;
        }
        postorden(n.izq);
        postorden(n.der);
        System.out.println(n.dato);
    }
    
    public void enorden(Nodo n) {
        if (n == null){
            return;
        }
        enorden(n.izq);
        System.out.println(n.dato);
        enorden(n.der);
    }
}
