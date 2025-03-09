/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cap10;

/**
 *
 * @author enrique
 */
public interface ICola<T> {
    boolean encolar(T dato);  // encolar (insertar un nuevo fin)
    T desencolar();  // desencolar (quitar un frente)
    boolean estaVacio();  // verifica si la cola no tiene elementos
    T frente();  // Obtiene el valor del frente
    void limpiar();
}
