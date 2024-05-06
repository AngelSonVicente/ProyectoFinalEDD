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
public class ArbolB {

    private NodoArbol root;
    private int t;

    public ArbolB(int t) {
        this.t = t;
        root = new NodoArbol(t);
    }

    public Dato getDatoMayor() {

        return getClaveMayor(this.root);
    }

    private Dato getClaveMayor(NodoArbol actual) {
        if (actual == null) {
            return null;
        }

        //Mientras no sea una hoja
        while (!actual.isHoja()) {
   
            actual = actual.getHijos()[actual.getNumero()];
        }

        return claveMayorPorNodo(actual);
    }

    public Dato getDatoMenor() {
        NodoArbol temp = buscarNodoMinimo(root);

        if (temp == null) {
            return null;

        }

        return temp.getDatos()[0];

    }

    private Dato claveMayorPorNodo(NodoArbol actual) {
        //Devuelve el valor mayor, el que esta mas a la derecha
        return actual.getDatos()[actual.getNumero() - 1];
    }

    public NodoArbol buscarNodoMinimo(NodoArbol actual) {
        if (root == null) {
            return null;
        }

        NodoArbol aux = root;

        while (!aux.isHoja()) {

            aux = aux.getHijos()[0];
        }

        return aux;
    }

    public void insertar(Dato key) {
        NodoArbol raiz = root;

        if (raiz.getNumero() == ((2 * t) - 1)) {
            NodoArbol nuevaRaiz = new NodoArbol(t);
            root = nuevaRaiz;
            nuevaRaiz.setHoja(false);
            nuevaRaiz.setNumero(0);
            nuevaRaiz.getHijos()[0] = raiz;
            DividirPagina(nuevaRaiz, 0, raiz);
            ingresarAHojas(nuevaRaiz, key);
        } else {
            ingresarAHojas(raiz, key);
        }
    }

    private void DividirPagina(NodoArbol raiz, int i, NodoArbol paginaLlena) {
        //Nodo temporal que sera el hijo i + 1 de x

        NodoArbol primeraMitad = new NodoArbol(t);
        primeraMitad.setHoja(paginaLlena.isHoja());
        primeraMitad.setNumero((t - 1));

        //Copia las ultimas (t - 1) claves del nodo y al inicio del nodo primeraMItad
        for (int j = 0; j < (t - 1); j++) {
            primeraMitad.getDatos()[j] = paginaLlena.getDatos()[(j + t)];
        }

        //Si no es hoja hay que reasignar los nodos hijos
        if (!paginaLlena.isHoja()) {
            for (int k = 0; k < t; k++) {

                primeraMitad.setHijo(paginaLlena.getHijos()[(k + t)], k);

            }
        }

        paginaLlena.setNumero((t - 1));

        //Mueve los hijos de raiz para darle espacio a primeraMitad
        for (int j = raiz.getNumero(); j > i; j--) {

            raiz.setHijo(raiz.getHijos()[j], (j + 1));
        }

        raiz.setHijo(primeraMitad, i + 1);

        //Mueve las claves de x
        for (int j = raiz.getNumero(); j > i; j--) {
            raiz.getDatos()[(j + 1)] = raiz.getDatos()[j];
        }

        //Agrega la clave situada en la mediana                                
        raiz.getDatos()[i] = paginaLlena.getDatos()[(t - 1)];

        raiz.setNumero(raiz.getNumero() + 1);

    }

    private void ingresarAHojas(NodoArbol x, Dato key) {
        //Si es una hoja
        if (x.isHoja()) {
            int i = x.getNumero();

            //busca la posicion i donde asignar el valor
            while (i >= 1 && key.getNum() < x.getDatos()[i - 1].getNum()) {
                x.getDatos()[i] = x.getDatos()[i - 1];//Desplaza los valores mayores a key
                i--;
            }

            x.getDatos()[i] = key;//asigna el valor al nodo
            x.setNumero(x.getNumero() + 1); //aumenta la cantidad de elementos del nodo

        } else {
            int j = 0;
            //Busca la posicion del hijo
            while (j < x.getNumero() && key.getNum() > x.getDatos()[j].getNum()) {
                j++;
            }

            //Si el nodo hijo esta lleno lo separa
            if (x.getHijos()[j].getNumero() == (2 * t - 1)) {
                DividirPagina(x, j, x.getHijos()[j]);

                if (key.getNum() > x.getDatos()[j].getNum()) {
                    j++;
                }
            }

            ingresarAHojas(x.getHijos()[j], key);
        }
    }

    public String generarDOT() {
        StringBuilder dotBuilder = new StringBuilder();
        dotBuilder.append("digraph ArbolB {\n");
        generarDOT(root, dotBuilder);
        dotBuilder.append("}\n");
        return dotBuilder.toString();
    }

    private void generarDOT(NodoArbol nodo, StringBuilder dotBuilder) {
        if (nodo == null) {
            return;
        }

    
        dotBuilder.append(nodo.hashCode()).append(" [shape=plaintext label=<<TABLE BORDER=\"1\" CELLPADDING=\"5\" CELLSPACING=\"0\">");

        
        dotBuilder.append("<TR>");
        for (int i = 0; i < nodo.getNumero(); i++) {
            dotBuilder.append("<TD>").append(nodo.getDatos()[i]).append("</TD>");
        }
        dotBuilder.append("</TR>");

        dotBuilder.append("</TABLE>>];\n");

        if (!nodo.isHoja()) {
            // Conecta el nodo padre con sus hijos
            for (int j = 0; j <= nodo.getNumero(); j++) {
                if (nodo.getHijos()[j] != null) {
                    dotBuilder.append(nodo.hashCode()).append(" -> ");
                    dotBuilder.append(nodo.getHijos()[j].hashCode()).append(";\n");
                    generarDOT(nodo.getHijos()[j], dotBuilder);
                }
            }
        }
    }

}
