/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ArbolB;

import Model.Dato;

/**
 *
 * @author angel
 */
public class NodoArbol {

    private int numero; //numero de datos que almacenadas en el nodo
    private boolean hoja;
    private Dato datos[];  
    private NodoArbol hijos[]; 

    public NodoArbol(int t) {
        numero = 0;
        hoja = true;
        datos = new Dato[((2 * t) - 1)];

        hijos = new NodoArbol[(2 * t)];
    }


    

    public int buscar(int k) {
        for (int i = 0; i < numero; i++) {
            if (datos[i].getNum() == k) {
                return i;
            }
        }
        return -1;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public boolean isHoja() {
        return hoja;
    }

    public void setHoja(boolean hoja) {
        this.hoja = hoja;
    }

    public Dato[] getDatos() {
        return datos;
    }

    public void setDatos(Dato[] datos) {
        this.datos = datos;
    }

    public NodoArbol[] getHijos() {
        return hijos;
    }

    public void setHijos(NodoArbol[] hijos) {
        this.hijos = hijos;
    }

    public void setHijo(NodoArbol hijo, int i) {

        this.hijos[i] = hijo;
    }

}
