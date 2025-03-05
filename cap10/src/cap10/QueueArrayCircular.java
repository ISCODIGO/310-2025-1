/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cap10;

/**
 *
 * @author enrique
 */
public class QueueArrayCircular<T> extends QueueArray<T> {
    
    public QueueArrayCircular(int capacidad) {
        super(capacidad);
    }

    @Override
    protected int adelantar(int pos) {
        return (pos + 1) % super.arreglo.length;
    }
    
    
    public static void main(String[] args) {
        QueueArrayCircular<Integer> c = new QueueArrayCircular<>(5);
        System.out.println(true == c.isEmpty());
        
        c.enqueue(10);
        System.out.println(false == c.isEmpty());
        System.out.println(10 == c.front());
        
        c.enqueue(20);
        System.out.println(10 == c.front());
        
        c.enqueue(30);
        c.enqueue(40);
        
        System.out.println(10 == c.dequeue());
        System.out.println("Probar 20:" + (20 == c.front()));
        
        c.dequeue();
        c.dequeue();
        
        c.enqueue(50);
        c.enqueue(60);
        
        c.dequeue();
        c.dequeue();
        
        System.out.println("Probar 60: " + (60 == c.front()));
        c.enqueue(70);
        c.enqueue(80);
        c.enqueue(90);
        c.enqueue(99);
        System.out.println(true == c.isFull());
    }
    
    
}
