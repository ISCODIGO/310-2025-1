/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.algoritmos.cap13;

/**
 *
 * @author enrique
 */
public class ArbolBinarioBusqueda extends ArbolBinario {

    public ArbolBinarioBusqueda(int inicio) {
        super(inicio);
    }

    public void agregarRecursivo(Nodo n, int dato) {
        if (dato <= n.dato) {
            insertarEnSubarbol(n, dato, true);
        } else {
            insertarEnSubarbol(n, dato, false);
        }
    }

    private void insertarEnSubarbol(Nodo n, int dato, boolean aIzquierda) {
        Nodo hijo = aIzquierda ? n.izq : n.der;
        if (hijo == null) {
            if (aIzquierda) {
                n.izq = new Nodo(dato);
            } else {
                n.der = new Nodo(dato);
            }
            this.conteo++;
        } else {
            agregarRecursivo(hijo, dato);
        }
    } 
    
    public void agregar(int dato) {
        agregarRecursivo(raiz, dato);
    }
    
    public static void main(String[] args) {
        // Prueba
        var arbol = new ArbolBinarioBusqueda(32);
        arbol.agregar(25);
        arbol.agregar(44);
        arbol.agregar(1);
        arbol.agregar(20);
        arbol.agregar(5);
        arbol.agregar(19);
        arbol.agregar(50);
        
        arbol.imprimir();
        
        System.out.println(arbol.raiz.dato == 32);
        System.out.println(arbol.raiz.izq.dato == 25);
        System.out.println(arbol.raiz.der.dato == 44);
        System.out.println(arbol.raiz.izq.izq.der.izq.dato == 5);
    }
    
}
