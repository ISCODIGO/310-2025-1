/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author enrique
 */
public class ForRecursivo {
    public static void main(String[] args) {
        forRecursivo(0, 5, 3);
    }
    
    static void forRecursivo(int inicio, int termino, int pasos) {        
        // Caso base
        if (inicio > termino)
            return;
                
        System.out.println(inicio);
        inicio += pasos;
        
        // Caso progresivo
        forRecursivo(inicio, termino, pasos);
    }
}
