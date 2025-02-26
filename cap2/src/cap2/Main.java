package cap2;

import java.util.Arrays;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author enrique
 */
public class Main {
    public static void main(String[] args) {
        ConjuntoArray c1 = new ConjuntoArray(10);
        c1.agregarElemento(5);
        c1.agregarElemento(4);
        
        ConjuntoArray c2 = new ConjuntoArray(20);
        c2.agregarElemento(6);
        c2.agregarElemento(3);
        c2.agregarElemento(5);
        
        ConjuntoArray c3 = (ConjuntoArray) c1.union(c2);
        ConjuntoArray c4 = (ConjuntoArray) c1.interseccion(c2);
        System.out.println(c3);
        System.out.println(c4);

    }
}
