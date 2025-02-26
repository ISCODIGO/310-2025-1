/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cap2;

/**
 *
 * @author enrique
 */
public class BolsaNumerica<T extends Comparable> {
    private T contenido;
    
    
    public void almacenar(T valor) {
        this.contenido = valor;
    }
    
    public T obtener() {
        return this.contenido;
    }
    
    public int compareTo(BolsaNumerica otra) {
        return this.contenido.compareTo(otra.contenido);
    }
    
    public static void main(String[] args) {
        BolsaNumerica<Double> b1 = new BolsaNumerica<>();
        b1.almacenar(10.0);
        
        BolsaNumerica<Double> b11 = new BolsaNumerica<>();
        b11.almacenar(11.0);
        
        BolsaNumerica<Integer> b2 = new BolsaNumerica<>();
        b2.almacenar((int)'a');
        
        var b3 = new BolsaNumerica<String>();
        b3.almacenar("10");
        
        var b4 = new BolsaNumerica<String>();
        b4.almacenar("2");
        
        int comp = b4.compareTo(b3);
        System.out.println(comp);
    }
}
