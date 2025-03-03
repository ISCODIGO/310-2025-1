/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cap10;

/**
 *
 * @author enrique
 */
public class QueueArray<T> implements Queue<T> {
    private T[] arreglo;
    private int conteo;
    private int frente;
    private int fin;
    
    public QueueArray(int capacidad) {
        arreglo = (T[]) new Object[capacidad];
        conteo = 0;
        frente = 0;
        fin = -1;
    }
    
    
    @Override
    public boolean enqueue(T dato) {
        if (fin == arreglo.length - 1) {
            throw new RuntimeException("Queue esta lleno");
            //return false;
        }
        
        arreglo[++fin] = dato;
        conteo++;
        return true;
    }

    @Override
    public T dequeue() {
        T aux = front();
        frente++;
        conteo--;
        return aux;
    }

    @Override
    public boolean isEmpty() {
        return this.conteo == 0;
    }

    @Override
    public T front() {
        if (this.isEmpty()) {
            throw new RuntimeException("Queue vacio");
        }
        
        return arreglo[frente];
    }
    
}
