/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Grafo;

import Model.Arista;
import Model.Camino;
import Model.Nodo;
import Util.Util;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author angel
 */
public class BuscarCaminos {

    private List<Arista> aristas;
    private List<Nodo> nodos;
    private Util util = new Util();

    private float horaActual;

    public BuscarCaminos(List<Arista> aristas, List<Nodo> nodos) {
        this.aristas = aristas;
        this.nodos = nodos;
    }

    public List<Camino> encontrarCaminos(Nodo origen, Nodo destino, float horaActual) {
        this.horaActual = horaActual;
        List<Camino> caminos = new ArrayList<>();
        encontrarCaminosRecursivo(origen, destino, new ArrayList<>(), 0, 0, 0, horaActual, 0, caminos);
        return caminos;
    }

    private void encontrarCaminosRecursivo(Nodo actual, Nodo destino, List<Nodo> caminoActual, float rapidezActual, int Gasolina, int distanciaActual, float horaActual, int tiempoVehiculo, List<Camino> caminos) {
        caminoActual.add(actual);

        //  System.out.println("Hora: "+ horaActual);
        if (actual.equals(destino)) {
            Camino camino = new Camino();
            camino.getNodos().addAll(caminoActual);
            camino.addDistancia(distanciaActual);
            camino.addConsumoGasolina(Gasolina);
            camino.addRapidezTotal(rapidezActual);
            camino.addTiempoVehiculo(tiempoVehiculo);

            caminos.add(camino);
            System.out.println("\n\nTerminamos camino a las: " + horaActual+"\n\n");
            horaActual = this.horaActual;
        } else {
            for (Arista arista : aristas) {
                if (arista.getInicio().equals(actual)) {
                    Nodo siguiente = arista.getFin();
                    int distanciaArista = arista.getDistancia();
                    int consumoGasArista = arista.getConsumoGas();
                    int tiempoArista = arista.getTimepoVehiculo();
                    float rapidezArista = arista.getRapidezVehiculo(horaActual);

                    //    System.out.println("Tiempo arista: "+tiempoArista);
                    if (!caminoActual.contains(siguiente)) {
                        encontrarCaminosRecursivo(siguiente, destino, caminoActual, rapidezArista + rapidezActual, Gasolina + consumoGasArista, distanciaActual + distanciaArista, util.sumarMinutosAHora(horaActual, tiempoArista), tiempoVehiculo + tiempoArista, caminos);
                    }

                }
            }
        }

        caminoActual.remove(caminoActual.size() - 1);
    }
    
    
    
   public List<Camino> encontrarCaminosAPie(Nodo origen, Nodo destino) {
   
    List<Camino> caminos = new ArrayList<>();
    encontrarCaminosAPieRecursivo(origen, destino, new ArrayList<>(), new ArrayList<>(), 0, 0, 0, 0, caminos);
    return caminos;
}

private void encontrarCaminosAPieRecursivo(Nodo actual, Nodo destino, List<Nodo> caminoActual, List<Arista> aristasCamino, float rapidezActual, int desgasteFisico, int distanciaActual, int tiempoPie, List<Camino> caminos) {
    caminoActual.add(actual);

    // Verificamos si el nodo actual es el nodo destino
    if (actual.equals(destino)) {
        // Si el nodo actual es el destino, creamos un nuevo objeto Camino con el camino actual y las aristas correspondientes, y lo agregamos a la lista de caminos
        Camino camino = new Camino();
        camino.getNodos().addAll(caminoActual);
        camino.getAristas().addAll(aristasCamino); // Agregamos las aristas al camino
        camino.addDistancia(distanciaActual);
        camino.addDesgasteFisico(desgasteFisico);
        camino.addRapidezTotal(rapidezActual);
        camino.addTiempoPie(tiempoPie);
        caminos.add(camino);
    } else {
        // Exploramos todas las aristas que salen de este nodo
        for (Arista arista : aristas) {
            if (arista.getInicio().equals(actual)) {
                Nodo siguiente = arista.getFin();
                int distanciaArista = arista.getDistancia();
                int desgasteFisicoArista = arista.getConsumoGas();
                int tiempoArista = arista.getTiempoPie();
                float rapidezArista = arista.getRapidezPie();

                if (!caminoActual.contains(siguiente)) {
                    // Llamamos recursivamente a la función para explorar el siguiente nodo y continuar construyendo el camino
                    List<Arista> nuevasAristasCamino = new ArrayList<>(aristasCamino);
                    nuevasAristasCamino.add(arista); // Agregamos la arista al camino
                    encontrarCaminosAPieRecursivo(siguiente, destino, caminoActual, nuevasAristasCamino, rapidezArista + rapidezActual, desgasteFisico + desgasteFisicoArista, distanciaActual + distanciaArista,  tiempoPie + tiempoArista, caminos);
                }
            } else if (arista.getFin().equals(actual)) {
                // En este caso, invertimos el inicio y el fin de la arista para explorar la conexión en ambas direcciones
                Nodo siguiente = arista.getInicio();
                int distanciaArista = arista.getDistancia();
                int desgasteFisicoArista = arista.getConsumoGas();
                int tiempoArista = arista.getTiempoPie();
                float rapidezArista = arista.getRapidezPie();

                if (!caminoActual.contains(siguiente)) {
                    // Llamamos recursivamente a la función para explorar el siguiente nodo y continuar construyendo el camino
                    List<Arista> nuevasAristasCamino = new ArrayList<>(aristasCamino);
                    nuevasAristasCamino.add(arista); // Agregamos la arista al camino
                    encontrarCaminosAPieRecursivo(siguiente, destino, caminoActual, nuevasAristasCamino, rapidezArista + rapidezActual, desgasteFisico + desgasteFisicoArista, distanciaActual + distanciaArista, tiempoPie + tiempoArista, caminos);
                }
            }
        }
    }

    caminoActual.remove(caminoActual.size() - 1);
}

}
