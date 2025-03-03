/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cap9;

import java.util.LinkedList;

/**
 *
 * @author enrique
 */
public class StackLL<T> implements Stack<T> {
    private LinkedList<T> lista;

    public StackLL() {
        lista = new LinkedList<>();
    }
    
    
    
    @Override
    public boolean push(T dato) {
        return lista.add(dato);
        
    }

    @Override
    public T pop() {
        return lista.removeFirst();
    }

    @Override
    public T top() {
        return lista.getFirst();
    }

    @Override
    public boolean isEmpty() {
        return lista.isEmpty();
    }
    
    
}
