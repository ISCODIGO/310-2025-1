/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */


/**
 *
 * @author enrique
 */
public class Multiplicacion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        long v1, v2;
        int a = 100000000, b = 2;
        
        v1 = System.nanoTime();
        System.out.println(multiplicar(a, b));
        v2 = System.nanoTime();
        System.out.println("Multiplicar tarda: " + (v2-v1) + " ns");
        
        System.out.println("------------------------");
        
        v1 = System.nanoTime();
        System.out.println(repetirSuma(a, b));
        v2 = System.nanoTime();
        System.out.println("Repetir suma tarda: " + (v2-v1) + " ns");
        
        
        
    }
    
    static int multiplicar(int a, int b) {
        int instrucciones = 1;
        System.out.println("Instrucciones: " + instrucciones);
        return a * b;
    }
    
    static int repetirSuma(int a, int b) {
        int instrucciones = 0;
        
        int positivo = Math.abs(a);  instrucciones++;
        int total = 0; instrucciones++;
        
        for (int i = 0; i < positivo; i++) { instrucciones++;
            total += b; instrucciones++;
        }
        
        if (a < 0) { instrucciones++;
            total = -total; instrucciones++;
        }
        
        instrucciones++;
        System.out.println("Instrucciones: " + instrucciones);
        return total;
    }
    
}
