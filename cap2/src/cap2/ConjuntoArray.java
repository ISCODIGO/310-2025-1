package cap2;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author enrique
 */
public class ConjuntoArray implements ConjuntoTDA {

    boolean[] arreglo;

    public ConjuntoArray(int fin) {
        this.crear(0, fin);
    }

    @Override
    public void crear(int inicio, int fin) {
        if (inicio < 0 || fin < 0) {
            throw new ArrayIndexOutOfBoundsException("Limite no definido");
        }

        arreglo = new boolean[Math.max(inicio, fin) + 1];
    }

    @Override
    public ConjuntoTDA union(ConjuntoTDA otro) {
        int capacidad = Math.max(this.capacidad(), otro.capacidad());

        ConjuntoArray resultado = new ConjuntoArray(capacidad);

        // llenar los elementos del primer conjunto
        for (int i = 0; i < this.arreglo.length; i++) {
            if (this.arreglo[i]) {
                resultado.arreglo[i] = true;

            }
        }

        // llenar los elementos del segundo conjunto
        for (int i = 0; i < otro.capacidad(); i++) {
            if (((ConjuntoArray) otro).arreglo[i]) {
                resultado.arreglo[i] = true;
            }
        }

        return resultado;

    }

    @Override
    public ConjuntoTDA interseccion(ConjuntoTDA otro) {
        int capacidad = Math.min(this.capacidad(), otro.capacidad());

        ConjuntoArray resultado = new ConjuntoArray(capacidad);
        var elOtro = (ConjuntoArray) otro;

        // llenar los elementos del primer conjunto
        for (int i = 0; i < resultado.capacidad()-1; i++) {
            if (this.arreglo[i] && elOtro.arreglo[i]) {
                resultado.arreglo[i] = true;
            }
        }
        
        return resultado;
    }

    @Override
    public ConjuntoTDA complemento(ConjuntoTDA otro) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int contarElementos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean estaVacia() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void agregarElemento(int elemento) {
        this.arreglo[elemento] = true;
    }

    @Override
    public int capacidad() {
        return this.arreglo.length;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < this.arreglo.length; i++) {
            if (this.arreglo[i]) {
                sb.append(i);
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }

}
