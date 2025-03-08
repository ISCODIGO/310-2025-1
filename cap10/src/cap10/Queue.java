/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cap10;

/**
 *
 * @author enrique
 */
public interface Queue<T> {
    boolean enqueue(T dato);  // encolar (insertar un nuevo fin)
    T dequeue();  // desencolar (quitar un frente)
    boolean isEmpty();  // verifica si la cola no tiene elementos
    T front();  // Obtiene el valor del frente
    void clear();
}
