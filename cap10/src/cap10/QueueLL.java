/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cap10;

import java.util.LinkedList;

/**
 *
 * @author enrique
 */
public class QueueLL<T> implements Queue<T> {
    private LinkedList<T> lista;  // frente: ultimo (remover), fin: primero (insertar)
    
    public QueueLL() {
        lista = new LinkedList<>();
    }

    @Override
    public boolean enqueue(T dato) {
        lista.addFirst(dato);
        return true;
    }

    @Override
    public T dequeue() {
        return lista.removeLast();
    }

    @Override
    public boolean isEmpty() {
        return lista.isEmpty();
    }

    @Override
    public T front() {  // O(1)
        return lista.getLast();
    }

    @Override
    public void clear() {
        lista.clear();
    }           
}
