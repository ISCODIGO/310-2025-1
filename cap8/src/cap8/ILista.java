/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cap8;

/**
 * TDA de una lista
 * 
 * @author enrique
 */
public interface ILista<T> {
    // Eliminar todos los elementos de la lista
    void limpiar(); // O(1)

    boolean agregarPrimero(T dato);

    boolean agregarUltimo(T dato);

    // Agregar un nodo en una posicion determinada
    boolean insertar(T dato, int posicion);

    // Devuelva la posicion a traves del dato indicado
    int buscar(T dato);

    boolean eliminar(T dato);

    boolean eliminar(int posicion);

    T eliminarPrimero();

    T eliminarUltimo();

    // Retorna la cantidad de elementos de la lista
    int conteo(); // O(1)

    // true: no hay nodos, false: hay al menos un nodo
    boolean estaVacia();
}
