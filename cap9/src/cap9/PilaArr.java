/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cap9;

/**
 *
 * @author enrique
 */
public class PilaArr<T> implements IPila<T> {

    private int cima;
    private int conteo;
    T[] arreglo;

    public PilaArr(int capacidad) {
        arreglo = (T[]) new Object[capacidad];
        cima = -1;
    }

    @Override
    public boolean apilar(T dato) {
        if (estaLleno()) {
            throw new StackOverflowError();
        }

        arreglo[++cima] = dato;
        conteo++;
        return true;
    }

    @Override
    public T desapilar() {
        if (estaVacio()) {
            throw new ArrayIndexOutOfBoundsException(); // TODO: StackUnderflowError
        }

        T aux = arreglo[cima--];
        conteo--;
        return aux;
    }

    @Override
    public T cima() {
        if (estaVacio()) {
            throw new ArrayIndexOutOfBoundsException(); // TODO: StackUnderflowError
        }

        return arreglo[cima];
    }

    @Override
    public boolean estaVacio() {
        return cima == -1;
    }

    public boolean estaLleno() {
        return cima == arreglo.length - 1;
    }

    @Override
    public void limpiar() {
        cima = -1;
        conteo = 0;
    }
}
