package intro;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author enrique
 */
public class Recursion1 {
    public static int rec = 0;
    
    public static void f() {
        System.out.println(rec++);
        
        if (rec < 1000) f();
    }
    
    public static void seudoBucle(int ini, int fin) {
        System.out.println(ini);
        if (ini < fin){
            seudoBucle(++ini, fin);
        }
    }
    
    public static int sumaEntero(int n) {
        if (n == 1) return 1;
        
        return sumaEntero(n-1) + n;
    }
    
    public static void main(String[] args) {
        //seudoBucle(0, 100);
        System.out.println(sumaEntero(5));
    }
}
