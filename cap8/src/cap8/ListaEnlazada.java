/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cap8;

/**
 *
 * @author enrique
 */
public class ListaEnlazada<T> implements ILista<T> {

    private Nodo<T> primero;
    private Nodo<T> ultimo;
    private int size;

    public ListaEnlazada() {
        limpiar();
    }

    public Nodo<T> get(int posicion) {
        // validar la posicion
        if (posicion < 0 || posicion >= size)
            throw new IndexOutOfBoundsException("Posicion invalida");

        var aux = primero;
        int p = 0;

        while (p < posicion) {
            p++;
            aux = aux.getSiguiente();
        }

        return aux;
    }

    public void print() {
        StringBuilder sb = new StringBuilder(); // permite un String mutable
        var aux = primero;

        while (aux != null) {
            sb.append(aux.getDato());
            sb.append("->");
            aux = aux.getSiguiente();
        }

        System.out.println(sb.toString());
    }

    @Override
    public void limpiar() {
        this.primero = this.ultimo = null;
        this.size = 0;
    }

    @Override
    public boolean agregarPrimero(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);

        if (this.estaVacia()) {
            ultimo = nuevo;
        }

        nuevo.setSiguiente(this.primero);
        primero = nuevo;
        size++;

        return true;
    }

    @Override
    public boolean agregarUltimo(T dato) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
                                                                       // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean insertar(T dato, int posicion) {
        // n1 -> n2 -> n3 -> n4
        // nn
        try {
            var nodoPrevio = this.get(posicion - 1);
            var nodoNuevo = new Nodo<T>(dato);
            nodoNuevo.setSiguiente(nodoPrevio.getSiguiente());
            nodoPrevio.setSiguiente(nodoNuevo);
            size++;
            return true;
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
    }

    @Override
    public int buscar(T dato) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
                                                                       // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean eliminar(T dato) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
                                                                       // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public T eliminarPrimero() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
                                                                       // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public T eliminarUltimo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
                                                                       // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean eliminar(int posicion) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
                                                                       // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int conteo() {
        return this.size;
    }

    @Override
    public boolean estaVacia() {
        return (this.primero == null && this.ultimo == null);
    }

}
