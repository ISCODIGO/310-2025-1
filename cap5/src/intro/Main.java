/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package intro;

/**
 *
 * @author enrique
 */
public class Main {
    
    public static void a() {
        b();
        System.out.println("a");
    }
    
    public static void b() {
        c();
        System.out.println("b");
    }
    
    public static void c() {
        System.out.println("c");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        a();
    }
    
}
