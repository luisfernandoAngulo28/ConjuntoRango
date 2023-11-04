/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

/**
 *
 * @author fernando
 */
public class ConjuntoRango {
     Bitwise C[];
    public int cant;
    int rangoInicio;
    int rangoFin;
                       //10                     100
     public ConjuntoRango(int rangoInicioo,int rangofinn) {
        this.rangoInicio=rangoInicioo;
        this.rangoFin=rangofinn;
        int Nele=rangoFin-rangoInicio+1;//100-10+1=91
        int Nbw = Nele / 32;//2 R 27

        if (Nele % 32 != 0) {
            Nbw++;
        }
       // /[10, 11, 12, 13, ..., 99, 100] (91 elementos)
          //1.........................91
        //System.out.println(Nbw);
        C = new Bitwise[Nbw];
        cant = Nele;
        for (int i = 0; i < Nbw ; i++) {
            C[i] = new Bitwise();

            // System.out.println(   C[i].toString());
        }
        

    }
         // /[10, 11, 12, 13, ..., 99, 100] (91 elementos)
          //1.....13....................91
                         // 23
    public void insertar(int elemento) {
        if (elemento >=rangoInicio && elemento<=rangoFin) {
           // int a=elemento-rangoInicio;//13
           // System.out.println(a);
            int NumeroBitWise = calNBW(elemento-rangoInicio);
            int Numerobit = CalcNbit(elemento-rangoInicio);
            C[NumeroBitWise].set1(Numerobit);
             //System.out.println( C[NumeroBitWise].toString());
        } else {
            System.out.println("Error fuera de rango");
          //  System.exit(1);
        }
    }

    public void eliminar(int elemento) {
        if (elemento >=rangoInicio && elemento<=rangoFin) {
            int NumeroBitWise = calNBW(elemento-rangoInicio);
            int Numerobit = CalcNbit(elemento-rangoInicio);
            C[NumeroBitWise].set0(Numerobit);
            //System.out.println( C[NumeroBitWise].toString());
        } else {
            System.out.println("Error fuera de rango");
            //System.exit(1);
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
        int NumeroBitWise = calNBW(elemento-rangoInicio);
        int Numerobit = CalcNbit(elemento-rangoInicio);
        return C[NumeroBitWise].getBit(Numerobit) == 1;
    }

    public String toString() {
        String Salida = "{";
        for (int i = rangoInicio; i <= rangoFin; i++) {
            // System.out.println("");
            if (Pertence(i)) {
                Salida = Salida + i + ",";
            }
        }
        return Salida + "}";
    }
    public static void main(String[] args) {
        ConjuntoRango conjunto=new ConjuntoRango(10, 100);
        conjunto.insertar(5);
        conjunto.insertar(15);
        conjunto.insertar(35);
        conjunto.insertar(21);
        System.out.println(conjunto.toString());
    }
}
