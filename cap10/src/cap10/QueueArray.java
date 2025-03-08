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
    protected T[] arreglo;
    private int conteo;
    private int frente;
    private int fin;
    
    protected int adelantar(int pos) {
        return pos + 1;
    }
    
    public QueueArray(int capacidad) {
        arreglo = (T[]) new Object[capacidad];
        conteo = 0;
        frente = 0;
        fin = -1;
    }
    
    
    @Override
    public boolean enqueue(T dato) {
        if (isFull()) {
            throw new RuntimeException("Queue esta lleno");
            //return false;
        }
        
        fin = adelantar(fin);
        arreglo[fin] = dato;
        conteo++;
        return true;
    }

    @Override
    public T dequeue() {
        T aux = front();
        frente = adelantar(frente);
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
    
    public boolean isFull() {
        return fin >= this.arreglo.length - 1;
    }

    @Override
    public void clear() {
        conteo = 0;
        frente = 0;
        fin = -1;
    }      
    
    public int getConteo() {
        return this.conteo;
    }
}
