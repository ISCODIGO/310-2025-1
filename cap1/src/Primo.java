/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author enrique
 */
public class Primo {

    /*
    Si tengo un numero n = a * b, donde a y b son enteros y no son 1 ni n.
    */
    
    public static void main(String[] args) {
        //long numero = 51480241427893L;
        //long numero = 1175530613L;  //4s (v1) - 2s (v2)
        long numero = 2045522929L;
        System.out.println("Es primo " + numero + ": " + esPrimoV3(numero));
        System.out.println("Iteraciones: " + iteraciones);
    }
    
    static int iteraciones = 0;
    
    static boolean esPrimo(long n) {
        boolean resultado = true;
        
        for (long i = 2; i < n; i++) {
            iteraciones++;
            if (n % i == 0) {
                return false;
                //resultado = false;
            }
        }
        
        return resultado;
    }
    
    static boolean esPrimoV2(long n) {
        boolean resultado = true;
        
        if (n % 2 == 0) return false;
        
        for (long i = 3; i < n/3; i+=2) {
            iteraciones++;
            if (n % i == 0) {
                return false;
                //resultado = false;
            }
        }
        
        return resultado;
    }
    
    static boolean esPrimoV3(long n) {
        boolean resultado = true;
        
        long limite = (int)Math.sqrt(n);
        for (long i = 2; i < limite; i++) {
            iteraciones++;
            if (n % i == 0) {
                return false;
                //resultado = false;
            }
        }
        
        return resultado;
    }
}
