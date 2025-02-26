/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author enrique
 */
public class PreRecursion {
    public static void main(String[] args) {
        f();
        System.out.println("** Termino **");
        System.out.println(rec);
    }
        
    static int rec = -1;
    static void f() {
        rec--;
        //System.out.println("Rec " + rec++);
        if (rec > -1000) 
            f();
    }
}
