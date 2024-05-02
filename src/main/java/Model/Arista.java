/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Model.Nodo;

/**
 *
 * @author angel
 */
public class Arista {

    private Nodo inicio;
    private Nodo fin;
    private int timepoVehiculo;
    private int tiempoPie;
    private int consumoGas;
    private int desgastePersona;
    private int distancia;

    private float traficoInicio;
    private float traficoFin;
    private int probabilidadTrafico;

    //si es doble via no se podria regresar por lo que la conexion ni existiria luego fumarnos un metodo para los que van a pie
    private boolean dobleVia;

    public Arista() {
    }

    public Arista(Nodo inicio, Nodo fin, int timepoVehiculo, int tiempoPie, int consumoGas, int desgastePersona, int distancia, boolean dobleVia) {
        this.inicio = inicio;
        this.fin = fin;
        this.timepoVehiculo = timepoVehiculo;
        this.tiempoPie = tiempoPie;
        this.consumoGas = consumoGas;
        this.desgastePersona = desgastePersona;
        this.distancia = distancia;
        this.dobleVia = dobleVia;
    }

    public Nodo getInicio() {
        return inicio;
    }

    public void setInicio(Nodo inicio) {
        this.inicio = inicio;
    }

    public Nodo getFin() {
        return fin;
    }

    public void setFin(Nodo fin) {
        this.fin = fin;
    }

    public int getTimepoVehiculo() {
        return timepoVehiculo;
    }

    public void setTimepoVehiculo(int timepoVehiculo) {
        this.timepoVehiculo = timepoVehiculo;
    }

    public int getTiempoPie() {
        return tiempoPie;
    }

    public void setTiempoPie(int tiempoPie) {
        this.tiempoPie = tiempoPie;
    }

    public int getConsumoGas() {
        return consumoGas;
    }

    public void setConsumoGas(int consumoGas) {
        this.consumoGas = consumoGas;
    }

    public int getDesgastePersona() {
        return desgastePersona;
    }

    public void setDesgastePersona(int desgastePersona) {
        this.desgastePersona = desgastePersona;
    }

    public int getDistancia() {
        return distancia;
    }

    public float getRapidezVehiculo(float horaActual) {
        if (horaActual >= traficoInicio && horaActual <= traficoFin) {

            return (distancia / (timepoVehiculo * (1 + (probabilidadTrafico / 100))));
        }
        return (distancia / (timepoVehiculo));
        

    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    public boolean isDobleVia() {
        return dobleVia;
    }

    public void setDobleVia(boolean dobleVia) {
        this.dobleVia = dobleVia;
    }

    public float getTraficoInicio() {
        return traficoInicio;
    }

    public void setTraficoInicio(float traficoInicio) {
        this.traficoInicio = traficoInicio;
    }

    public float getTraficoFin() {
        return traficoFin;
    }

    public void setTraficoFin(float traficoFin) {
        this.traficoFin = traficoFin;
    }

   
    
    
    
    public int getProbabilidadTrafico() {
        return probabilidadTrafico;
    }

    public void setProbabilidadTrafico(int probabilidadTrafico) {
        this.probabilidadTrafico = probabilidadTrafico;
    }

    @Override
    public String toString() {
        return "\n Arista{" + "inicio=" + inicio + ", fin=" + fin + ", timepoVehiculo=" + timepoVehiculo + ", tiempoPie=" + tiempoPie + ", consumoGas=" + consumoGas + ", desgastePersona=" + desgastePersona + ", distancia=" + distancia + ", traficoInicio=" + traficoInicio + ", traficoFin=" + traficoFin + ", probabilidadTrafico=" + probabilidadTrafico + ", dobleVia=" + dobleVia + '}';
    }

}
