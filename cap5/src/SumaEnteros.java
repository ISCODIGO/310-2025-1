/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author enrique
 */
public class SumaEnteros {
    public static void main(String[] args) {
        System.out.println(sumar(5));
    }
    
    static int sumar(int n) {
        if (n == 1) return 1;
         
        return sumar(n-1) + n;
    }
}
