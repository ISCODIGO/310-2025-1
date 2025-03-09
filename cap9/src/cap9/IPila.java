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
public interface IPila<T> {
    boolean apilar(T dato);  // insertar una nueva cima a la pila
    T desapilar();  // remover la cima actual
    T cima();  // lee el dato de la cima actual
    boolean estaVacio();  // verifica si la pila esta vacia
    void limpiar();  // elimina todos los elementos de la pila
}
