/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.algoritmos.cap12;

import java.util.Scanner;

/**
 *
 * @author enrique
 */
public class Cap12 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String frase = sc.nextLine();
        
        int res = 0;
        int m = 1009;
        for (int i = 0; i < frase.length(); i++) {
            res += frase.charAt(i) * Math.pow(31, i);
        }
        System.out.println(res % m);
    }
}
