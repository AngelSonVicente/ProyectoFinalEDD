/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Util.Util;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author angel
 */
public class Camino {

    private List<Nodo> nodos;
    private int distanciaTotal;
    private int gasolinaTotal;
    private float tiempoTotalVehiculo;
    private float rapidezTotal;

    public Camino() {
        this.nodos = new ArrayList<>();
        this.distanciaTotal = 0;
        this.tiempoTotalVehiculo = 0;
        this.rapidezTotal = 0;
    }

    public void addNodo(Nodo nodo) {
        nodos.add(nodo);
    }

    public void addDistancia(int distancia) {
        distanciaTotal += distancia;
    }

    public void addRapidezTotal(float rapidez) {
        rapidezTotal += rapidez;

    }

    public void addConsumoGasolina(int gasolina) {
        gasolinaTotal += gasolina;
    }

    public void addTiempoVehiculo(float tiempo) {
        tiempoTotalVehiculo += tiempo;
    }

    public List<Nodo> getNodos() {
        return nodos;
    }

    public void setNodos(List<Nodo> nodos) {
        this.nodos = nodos;
    }

    public float getTiempoTotalVehiculo() {
        return tiempoTotalVehiculo;
    }

    public void setTiempoTotalVehiculo(float tiempoTotalVehiculo) {
        this.tiempoTotalVehiculo = tiempoTotalVehiculo;
    }

    public int getDistanciaTotal() {
        return distanciaTotal;
    }

    public void setDistanciaTotal(int distanciaTotal) {
        this.distanciaTotal = distanciaTotal;
    }

    public int getGasolinaTotal() {
        return gasolinaTotal;
    }

    public void setGasolinaTotal(int gasolinaTotal) {
        this.gasolinaTotal = gasolinaTotal;
    }

    public float getPromDistanciaGasolina() {

        return (gasolinaTotal + distanciaTotal) / 2;
    }

    public float getRapidezTotal() {
        return rapidezTotal/nodos.size();
    }

    public void setRapidezTotal(float rapidezTotal) {
        this.rapidezTotal = rapidezTotal;
    }

    @Override
    public String toString() {
        return "\nCamino{" + "nodos=" + nodos + ", distanciaTotal=" + distanciaTotal + ", gasolinaTotal=" + gasolinaTotal + ", tiempoTotalVehiculo=" + tiempoTotalVehiculo + ", rapidezTotal=" + rapidezTotal + '}';
    }
    

 

}
