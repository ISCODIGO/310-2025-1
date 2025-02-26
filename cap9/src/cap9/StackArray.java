/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cap9;

/**
 *
 * @author enrique
 */
public class StackArray<T> implements Stack<T> {
    
    private int cima;
    T[] arreglo;
    
    public StackArray(int capacidad) {
        arreglo = (T[]) new Object[capacidad];
        cima = -1;
    }

    @Override
    public boolean push(T dato) {
        if (isFull()) {
            throw new StackOverflowError();
        }
        
        arreglo[++cima] = dato;
        return true;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException();  // TODO: StackUnderflowError
        }
        
        T aux = arreglo[cima--];
        return aux;
    }

    @Override
    public T top() {
        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException();  // TODO: StackUnderflowError
        }
        
        return arreglo[cima];
    }

    @Override
    public boolean isEmpty() {
        return cima == -1;
    }
    
    public boolean isFull() {
        return cima == arreglo.length - 1;
    }
    
}
