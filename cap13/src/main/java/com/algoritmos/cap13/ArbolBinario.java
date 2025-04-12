/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.algoritmos.cap13;

import com.mycompany.printer.HeapPrinter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author enrique
 */
public class ArbolBinario {

    // Clase interna 
    protected class Nodo {
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
        
        @Override
        public String toString() {
            return String.valueOf(this.dato);
        }
    }
    // Fin clase interna
    
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
    
    public void imprimir() {
        // Convertir a array
        List<Integer> lista = getHeap();
        
        HeapPrinter hp = new HeapPrinter(lista.toArray());
        hp.print();
    }
    
    
    /***************************************************************************
     * 
     *                              RECORRIDOS
     *      
     **************************************************************************/
    
    
    private void preorden(Nodo n, List<Integer> lista) {
        if (n == null) {
            return;
        }
        
        lista.add(n.dato);
        preorden(n.izq, lista);
        preorden(n.der, lista);
    }
    
    public List<Integer> preorden() {
        List<Integer> lista = new ArrayList<>();
        preorden(this.raiz, lista);
        return lista;
    }
    
    private void enorden(Nodo n, List<Integer> lista) {
        if (n == null){
            return;
        }
        enorden(n.izq, lista);
        lista.add(n.dato);
        enorden(n.der, lista);
    }
    
    public List<Integer> enorden() {
        List<Integer> lista = new ArrayList<>();
        enorden(this.raiz, lista);
        return lista;
    }
    
    private void postorden(Nodo n, List<Integer> lista) {
        if (n == null){
            return;
        }
        postorden(n.izq, lista);
        postorden(n.der, lista);
        lista.add(n.dato);
    }
    
    public List<Integer> postorden() {
        List<Integer> lista = new ArrayList<>();
        postorden(this.raiz, lista);
        return lista;
    }
    
    // Recorrido por anchura (Breadth-First Search) 
    public List<Integer> bfs() {
        List<Integer> resultado = new ArrayList<>();
        var n = this.raiz;
        
        if (n == null) return resultado;

        Queue<Nodo> cola = new LinkedList<>();
        cola.add(n);

        while (!cola.isEmpty()) {
            Nodo actual = cola.poll();
            resultado.add(actual.dato);

            if (actual.izq != null) cola.add(actual.izq);
            if (actual.der != null) cola.add(actual.der);
        }

        return resultado;
    }
    
    public List<Integer> getHeap() {
        List<Integer> heap = new ArrayList<>();
        Queue<Pair> queue = new LinkedList<>();

        queue.add(new Pair(this.raiz, 0));

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            Nodo nodo = pair.nodo;
            int index = pair.index;

            // Expand list to fit current index
            while (heap.size() <= index) {
                heap.add(null);
            }

            if (nodo != null) {
                heap.set(index, nodo.dato);
                queue.add(new Pair(nodo.izq, 2 * index + 1));
                queue.add(new Pair(nodo.der, 2 * index + 2));
            }
        }

        return heap;
    }

    // Helper class to track node and its heap index
    private static class Pair {
        Nodo nodo;
        int index;

        Pair(Nodo nodo, int index) {
            this.nodo = nodo;
            this.index = index;
        }
    }



    
    
    /***************************************************************************
     * 
     *                    FUNCIONES RECURSIVAS AUXILIARES
     *      
     **************************************************************************/
    public int conteo() {
        return this.conteo;
    }
    
    public int conteoRecursivo(Nodo n) {
        if (n == null) {
            return 0;
        }
        
        return 1 + conteoRecursivo(n.izq) + conteoRecursivo(n.der);
    }
    
    public int conteoRecursivo() {
        return conteoRecursivo(this.raiz);
    } 
    
    public int altura(Nodo n) {
        if (n == null) {
            return 0;
        }
        
        return 1 + Math.max(altura(n.izq), altura(n.der));
    }
    
    public int altura() {
        return altura(raiz);
    }
    
    public int balance(Nodo n) {
        return conteoRecursivo(n.izq) - conteoRecursivo(n.der);
    }
    
    public int balance() {
        return balance(raiz);
    }
}
