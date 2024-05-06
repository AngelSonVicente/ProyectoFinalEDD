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
    private int desgasteFisico;
    private float tiemporTotalPie;
    private List<Arista> aristas; // Lista de aristas que se tomaron en el camino


    public Camino() {
        this.nodos = new ArrayList<>();
        this.distanciaTotal = 0;
        this.tiempoTotalVehiculo = 0;
        this.rapidezTotal = 0;
        this.desgasteFisico=0;
        this.tiemporTotalPie=0;
        this.aristas = new ArrayList<>();
    }
    
    

    public void addNodo(Nodo nodo) {
        nodos.add(nodo);
    }
    
      public void addArista(Arista arista) {
        aristas.add(arista);
    }

    public void addDistancia(int distancia) {
        distanciaTotal += distancia;
    }

    public void addRapidezTotal(float rapidez) {
        rapidezTotal += rapidez;

    }

    public void addDesgasteFisico(int desgaste){
        desgasteFisico+=desgaste;
    
    }
    
    
    public void addConsumoGasolina(int gasolina) {
        gasolinaTotal += gasolina;
    }

    public void addTiempoVehiculo(float tiempo) {
        tiempoTotalVehiculo += tiempo;
    }
    public void addTiempoPie(float tiempo){
        tiemporTotalPie+=tiempo;
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

    public float getTiemporTotalPie() {
        return tiemporTotalPie;
    }

    public void setTiemporTotalPie(float tiemporTotalPie) {
        this.tiemporTotalPie = tiemporTotalPie;
    }
    

    public void setGasolinaTotal(int gasolinaTotal) {
        this.gasolinaTotal = gasolinaTotal;
    }

    public float getPromDistanciaGasolina() {

        return distanciaTotal/gasolinaTotal;
    }
    
    public float getPromDistanciaDesgaste(){
    
    return distanciaTotal/desgasteFisico;
    }

    public float getRapidezTotal() {
        return rapidezTotal/nodos.size();
    }

    public void setRapidezTotal(float rapidezTotal) {
        this.rapidezTotal = rapidezTotal;
    }

    public List<Arista> getAristas() {
        return aristas;
    }

    public void setAristas(List<Arista> aristas) {
        this.aristas = aristas;
    }

    public int getDesgasteFisico() {
        return desgasteFisico;
    }

    public void setDesgasteFisico(int desgasteFisico) {
        this.desgasteFisico = desgasteFisico;
    }

    @Override
    public String toString() {
        return "\nCamino{" + "nodos=" + nodos + ", distanciaTotal=" + distanciaTotal + ", gasolinaTotal=" + gasolinaTotal + ", tiempoTotalVehiculo=" + tiempoTotalVehiculo + ", rapidezTotal=" + rapidezTotal + ", desgasteFisico=" + desgasteFisico + ", tiemporTotalPie=" + tiemporTotalPie + "Aristas: " + aristas + '}';
    }
    

    
    
    

  
    

 

}
