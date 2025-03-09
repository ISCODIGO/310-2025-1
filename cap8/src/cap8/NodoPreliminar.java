/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cap8;

/**
 *
 * @author enrique
 */
public class NodoPreliminar {
    int dato;
    NodoPreliminar enlace;

    public NodoPreliminar(int d) {
        dato = d;
    }

    @Override
    public String toString() {
        return String.valueOf(this.dato);
        // return "" + this.dato;
    }

    public static void main(String[] args) {
        String s = "hola";
        String s2 = "hola";
        String s3 = new String("hola");

        System.out.println(s == s3);
        System.out.println(s.equals(s3));

        var n1 = new NodoPreliminar(10);
        var n2 = new NodoPreliminar(20);
        var copia = n1; // n3 referencia a n1 (copia superficial)
        var n3 = new NodoPreliminar(30);

        // copia.dato = 145;
        System.out.println(n1.dato);
        System.out.println(n2.dato);

        n1.enlace = n2; // 10 -> 20
        n1.enlace.dato = 21; // 10 -> 21

        n2.enlace = n3; // 10 -> 21 -> 30
        n1.enlace.enlace.dato = 31; // 10 -> 21 -> 31

        System.out.println("n1=" + n1);
        System.out.println("n2=" + n2);
        System.out.println("n3=" + n3);

    }
}
