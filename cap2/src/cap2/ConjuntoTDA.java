/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cap2;

/**
 *
 * @author enrique
 */
public interface ConjuntoTDA {

    void crear(int inicio, int fin);
    ConjuntoTDA union(ConjuntoTDA otro);
    ConjuntoTDA interseccion(ConjuntoTDA otro);
    ConjuntoTDA complemento(ConjuntoTDA otro);
    int contarElementos();
    void agregarElemento(int elemento);
    boolean estaVacia();
    int capacidad();
}
