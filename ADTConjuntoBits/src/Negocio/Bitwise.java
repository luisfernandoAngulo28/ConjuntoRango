/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

/**
 *
 * @author fernando 23
 */
public class Bitwise { // DEFINICION DE LA CLASE

    int x;

    public Bitwise() { // CONSTRUCTOR DE OFICIO
        x = 0;
    }
    //SETTERS

    public void set1(int pos) {
        if (pos > 0) {
            int mask = 1;
            mask = mask << (pos - 1);
            x = x | mask;
        }
    }

    public void set0(int pos) {
        if (pos > 0) {
            int mask = 1;
            mask = mask << (pos - 1);
            mask = ~mask;
            x = x & mask;
        }
    }
    //GETTERS

    public int getBit(int pos) {
        int mask = 1;
        mask = mask << (pos - 1);
        mask = mask & x;
        mask = mask >>> (pos - 1);
        return (mask);
    }
    // METODOS AUXILIARES

    @Override
    public String toString() {
        String s = "X=";
        for (int i = 32; i >= 1; i--) {
            s = s + getBit(i) + " ";
        }
        return (s);
    }
    public static void main(String[] args) {
        Bitwise A=new Bitwise();
        A.set1(10);
           
        System.out.println(A.toString());
        A.set0(10);
         System.out.println(A.toString());
    }
}
