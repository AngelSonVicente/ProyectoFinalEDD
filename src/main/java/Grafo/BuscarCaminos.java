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

}
