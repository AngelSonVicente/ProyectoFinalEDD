/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

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

    

    public Camino() {
        this.nodos = new ArrayList<>();
        this.distanciaTotal = 0;
    }
    
      public void addNodo(Nodo nodo) {
        nodos.add(nodo);
    }
 
      
    public void addDistancia(int distancia) {
        distanciaTotal += distancia;
    }
    public void addConsumoGasolina(int gasolina) {
        gasolinaTotal += gasolina;
    }

    public List<Nodo> getNodos() {
        return nodos;
    }

    public void setNodos(List<Nodo> nodos) {
        this.nodos = nodos;
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
    
    
    public float getPromDistanciaGasolina(){
    
    return (gasolinaTotal+distanciaTotal)/2;
    }

    @Override
    public String toString() {
        return "Camino{" + "nodos=" + nodos + ", distanciaTotal=" + distanciaTotal + '}';
    }
    
    
    
    
}
