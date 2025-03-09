/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cap10;

/**
 *
 * @author enrique
 */
public class ColaArr<T> implements ICola<T> {
    protected T[] arreglo;
    private int conteo;
    private int frente;
    private int fin;
    
    protected int adelantar(int pos) {
        return pos + 1;
    }
    
    public ColaArr(int capacidad) {
        arreglo = (T[]) new Object[capacidad];
        conteo = 0;
        frente = 0;
        fin = -1;
    }
    
    
    @Override
    public boolean encolar(T dato) {
        if (estaLlena()) {
            throw new RuntimeException("Queue esta lleno");
            //return false;
        }
        
        fin = adelantar(fin);
        arreglo[fin] = dato;
        conteo++;
        return true;
    }

    @Override
    public T desencolar() {
        T aux = frente();
        frente = adelantar(frente);
        conteo--;
        return aux;
    }

    @Override
    public boolean estaVacio() {
        return this.conteo == 0;
    }

    @Override
    public T frente() {
        if (this.estaVacio()) {
            throw new RuntimeException("Queue vacio");
        }
        
        return arreglo[frente];
    }
    
    public boolean estaLlena() {
        return fin >= this.arreglo.length - 1;
    }

    @Override
    public void limpiar() {
        conteo = 0;
        frente = 0;
        fin = -1;
    }      
    
    public int getConteo() {
        return this.conteo;
    }
}
