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
public class PilaLL<T> implements IPila<T> {
    private LinkedList<T> lista;

    public PilaLL() {
        lista = new LinkedList<>();
    }       
    
    @Override
    public boolean apilar(T dato) {
        lista.addFirst(dato);
        return true;        
    }

    @Override
    public T desapilar() {
        return lista.removeFirst();
    }

    @Override
    public T cima() {
        return lista.getFirst();
    }

    @Override
    public boolean estaVacio() {
        return lista.isEmpty();
    }

    @Override
    public void limpiar() {
        lista.clear();
    }
}
