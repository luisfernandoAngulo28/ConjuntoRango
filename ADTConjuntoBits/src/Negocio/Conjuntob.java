/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

/**
 *
 * @author ferna
 */
public class Conjuntob {

    Bitwise C[];
    public int cant;

    public Conjuntob(int Nele) {
        int Nbw = Nele / 32;

        if (Nele % 32 != 0) {
            Nbw++;
        }
        //System.out.println(Nbw);
        C = new Bitwise[Nbw];
        cant = Nele;
        for (int i = 0; i <= Nbw - 1; i++) {
            C[i] = new Bitwise();

            // System.out.println(   C[i].toString());
        }

    }

    public void insertar(int elemento) {
        if (elemento <= cant) {
            int NumeroBitWise = calNBW(elemento);
            int Numerobit = CalcNbit(elemento);
            C[NumeroBitWise].set1(Numerobit);
            // System.out.println( C[NumeroBitWise].toString());
        } else {
            System.out.println("Error fuera de rango");
            System.exit(1);
        }
    }

    public void eliminar(int elemento) {
        if (elemento <= cant) {
            int NumeroBitWise = calNBW(elemento);
            int Numerobit = CalcNbit(elemento);
            C[NumeroBitWise].set0(Numerobit);
            //System.out.println( C[NumeroBitWise].toString());
        } else {
            System.out.println("Error fuera de rango");
            System.exit(1);
        }
    }

    //este nos ubica el bitwise
    private int calNBW(int elemento) {
        return ((elemento - 1) / 32);
    }

    //este nos ubica el bits a encender
    private int CalcNbit(int elemento) {
        // int a=((elemento-1)%32)+1;
        //  System.out.println(a);
        return (((elemento - 1) % 32) + 1);
    }

    public boolean Pertence(int elemento) {
        int NumeroBitWise = calNBW(elemento);
        int Numerobit = CalcNbit(elemento);
        return C[NumeroBitWise].getBit(Numerobit) == 1;
    }

    public String toString() {
        String Salida = "{";
        for (int i = 1; i <= cant; i++) {
            // System.out.println("");
            if (Pertence(i)) {
                Salida = Salida + i + ",";
            }
        }
        return Salida + "}";
    }

    public void union(Conjuntob A, Conjuntob B) {

        for (int i = 0; i < ((A.cant - 1) / 32) + 1; i++) {
            System.out.println(A.C[i].toString());
            System.out.println(B.C[i].toString());
            this.C[i].x = A.C[i].x | B.C[i].x;
            System.out.println(C[i].toString());
        }

    }

    public void interseccion(Conjuntob A, Conjuntob B) {

        for (int i = 0; i < ((A.cant - 1) / 32) + 1; i++) {
            System.out.println(A.C[i].toString());
            System.out.println(B.C[i].toString());
            this.C[i].x = A.C[i].x & B.C[i].x;
            System.out.println(C[i].toString());
        }

    }

    public boolean subConjunto(Conjuntob A) {
        int i = 1;
        while (i <= cant) {
            int NBit = CalcNbit(i);
            int NEnt = calNBW(i);
            if (C[NEnt].getBit(NBit) == 1) {
                if (!A.Pertence(i)) {
                    return (false);
                }
            }
            i++;
        }
        return (i > cant);
    }

    public static void main(String[] args) {
        Conjuntob A = new Conjuntob(5);
        A.insertar(2);
        A.insertar(3);
        A.insertar(5);
        A.insertar(2);
        Conjuntob B = new Conjuntob(7);
        B.insertar(1);
        B.insertar(4);
        B.insertar(6);
        B.insertar(2);
        System.out.println(A.toString());
        System.out.println(B.toString());
        Conjuntob C = new Conjuntob(10);
        C.interseccion(A, B);
        System.out.println(C.toString());

    }

}
