/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.algoritmos.cap13;

/**
 *
 * @author enrique
 */
public class Main {
    public static void main(String[] args) {
        ArbolBinario bin = new ArbolBinario(8);
        var n3 = bin.agregarIzq(3);
        var n20 = bin.agregarDer(20);
        var n1 = bin.agregarIzq(n3, 1);
        var n5 = bin.agregarDer(n3, 5);
        var n4 = bin.agregarIzq(n5, 4);
        var n10 = bin.agregarIzq(n20, 10);
        
        bin.enorden(bin.raiz);
    }
}
