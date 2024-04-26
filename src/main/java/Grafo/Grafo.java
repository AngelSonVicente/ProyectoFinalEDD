/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Grafo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author angel
 */
public class Grafo {

    private List<Nodo> nodos;
    private List<Arista> aristas;

    public Grafo() {
        nodos = new ArrayList<>();
        aristas = new ArrayList<>();

    }

    public void borrarDatos() {

        if (nodos != null) {
            nodos.clear();

        }
        if (aristas != null) {
            aristas.clear();
        }

    }

    // Métodos para añadir nodos y aristas
    public void addNodo(Nodo nodo) {
        nodos.add(nodo);
    }

    public void addArista(Nodo inicio, Nodo fin, int tiempoVehiculo, int tiempoPie, int consumoGas, int desgastePersona, int distancia, boolean dobleVia) {

        Arista arista = new Arista(inicio, fin, tiempoVehiculo, tiempoPie, consumoGas, desgastePersona, distancia, dobleVia);
        aristas.add(arista);
    }

    public void cargarDatos(String datosString) {
        String[] lineas = datosString.split("\n");
        for (String linea : lineas) {
            String[] datos = linea.split("\\|");
            String origen = datos[0];
            String destino = datos[1];
            int tiempoVehiculo = Integer.parseInt(datos[2]);
            int tiempoPie = Integer.parseInt(datos[3]);
            int consumoGas = Integer.parseInt(datos[4]);
            int desgastePersona = Integer.parseInt(datos[5]);
            int distancia = Integer.parseInt(datos[6]);

            Nodo nodoOrigen = buscarOcrearNodo(origen);
            Nodo nodoDestino = buscarOcrearNodo(destino);

            // Asumiendo que todas las conexiones son de doble vía
            addArista(nodoOrigen, nodoDestino, tiempoVehiculo, tiempoPie, consumoGas, desgastePersona, distancia, false);

        }
    }

    private Nodo buscarOcrearNodo(String nombre) {
        for (Nodo nodo : nodos) {
            if (nodo.getNombre().equals(nombre)) {
                return nodo;
            }
        }
        Nodo nuevoNodo = new Nodo(nodos.size() + 1, nombre);
        nodos.add(nuevoNodo);
        return nuevoNodo;
    }

    public List<Nodo> getNodos() {
        return nodos;
    }

    public void setNodos(List<Nodo> nodos) {
        this.nodos = nodos;
    }

    public List<Arista> getAristas() {
        return aristas;
    }

    public void setAristas(List<Arista> aristas) {
        this.aristas = aristas;
    }

    
    
  

    @Override
    public String toString() {
        return aristas.toString();
    }

}
