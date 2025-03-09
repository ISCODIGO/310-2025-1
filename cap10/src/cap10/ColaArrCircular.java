/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cap10;

/**
 *
 * @author enrique
 */
public class ColaArrCircular<T> extends ColaArr<T> {
    
    public ColaArrCircular(int capacidad) {
        super(capacidad);
    }

    @Override
    protected int adelantar(int pos) {
        return (pos + 1) % super.arreglo.length;
    }

    @Override
    public boolean estaLlena() {
        return super.getConteo() == super.arreglo.length;
    }
    
    
}
