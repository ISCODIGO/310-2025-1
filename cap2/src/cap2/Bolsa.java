/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cap2;

/**
 *
 * @author enrique
 */
public class Bolsa<T> {
    private T contenido;
    
    
    public void almacenar(T valor) {
        this.contenido = valor;
    }
    
    public T obtener() {
        return this.contenido;
    }
    
    public static void main(String[] args) {
        Bolsa<Double> bolsaDoble = new Bolsa();
        var x = (double)10;
        bolsaDoble.almacenar(x);
        int valor = bolsaDoble.obtener().intValue();
        
        Bolsa<String> bolsaStr = new Bolsa();
        bolsaStr.almacenar("hola");
        String resultado = bolsaStr.obtener();
        System.out.println(resultado);
    }
}
