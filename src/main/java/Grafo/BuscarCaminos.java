/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Grafo;

import Model.Arista;
import Model.Camino;
import Model.Nodo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author angel
 */
public class BuscarCaminos {
   private  List<Arista> aristas;
   private List<Nodo> nodos;

    public BuscarCaminos(List<Arista> aristas, List<Nodo> nodos) {
        this.aristas = aristas;
        this.nodos = nodos;
    }
   
   
   
   
    
      public List<Camino> encontrarCaminos(Nodo origen, Nodo destino) {
        List<Camino> caminos = new ArrayList<>();
        encontrarCaminosRecursivo(origen, destino, new ArrayList<>(), 0, caminos);
        return caminos;
    }

    private void encontrarCaminosRecursivo(Nodo actual, Nodo destino, List<Nodo> caminoActual, int distanciaActual, List<Camino> caminos) {
        caminoActual.add(actual);

        if (actual.equals(destino)) {
            Camino camino = new Camino();
            camino.getNodos().addAll(caminoActual);
            camino.addDistancia(distanciaActual);
            caminos.add(camino);
        } else {
            for (Arista arista : aristas) {
                if (arista.getInicio().equals(actual)) {
                    Nodo siguiente = arista.getFin();
                    int distanciaArista = arista.getDistancia();

                    if (!caminoActual.contains(siguiente)) {
                        encontrarCaminosRecursivo(siguiente, destino, caminoActual, distanciaActual + distanciaArista, caminos);
                    }
                }
            }
        }

        caminoActual.remove(caminoActual.size() - 1);
    }

   
    
    
    
    
    
    
    
}
