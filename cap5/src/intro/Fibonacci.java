/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package intro;

/**
 *
 * @author enrique
 */
public class Fibonacci {
    static int recursiones = 0;
    static int recursionesMem = 0;
    
    static long fibo(int n) {
        // Casos base
        if (n == 0) return 0;
        if (n == 1) return 1;
        
        recursiones++;
        
        // Caso recursivo
        return fibo(n-1) + fibo(n-2);
    }
    
    static long fiboMem(int n, long[] memoria) {
        if (memoria == null) {
            memoria = new long[n + 1];
            memoria[1] = 1; // [0, 1, 0, 0, 0, ..., 0]
        }
                
        // Caso base: primer elemento de Fibonacci
        if (n == 0) return 0;

        // Caso base: si hay un valor valido en la memoria
        // [0, 1, 1, 2, 0, 0...]
        if (memoria[n] > 0) {
            return memoria[n];
        }
        
        recursionesMem++;
        
        // Caso recursivo
        memoria[n] = fiboMem(n-1, memoria) + fiboMem(n-2, memoria);
        return memoria[n];
    }
    
    public static void main(String[] args) {
        int posicion = 50;
        long t1, t2;
        
        /*t1 = System.currentTimeMillis();
        System.out.println(fibo(posicion));
        t2 = System.currentTimeMillis();
        System.out.println("Transcurrido: " + (t2 - t1) + " ms");
        System.out.println("Recursiones: " + recursiones);*/
        
        
        System.out.println("Solucion mejorada...");        
        t1 = System.currentTimeMillis();
        System.out.println(fiboMem(posicion, null));
        t2 = System.currentTimeMillis();
        System.out.println("Transcurrido: " + (t2 - t1) + " ms");
        System.out.println("Recursiones: " + recursionesMem);
        
    }
}