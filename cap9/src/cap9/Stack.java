/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cap9;

/**
 * Una pila es una estructura LIFO
 * Last-in first-out (ultimo en entrar es el primero en salir)
 * @author enrique
 */
public interface Stack<T> {
    boolean push(T dato);  // insertar una nueva cima a la pila
    T pop();  // remover la cima actual
    T top();  // lee el dato de la cima actual
    boolean isEmpty();  // verifica si la pila esta vacia
}
