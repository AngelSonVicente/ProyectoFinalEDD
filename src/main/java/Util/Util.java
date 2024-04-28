/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Util;

import Model.Camino;
import java.util.List;

/**
 *
 * @author angel
 */
public class Util {

    public Camino getMejorCaminoDistancia(List<Camino> caminos) {

        Camino menor = caminos.get(0);

        for (Camino camino : caminos) {

            if (camino.getDistanciaTotal() < menor.getDistanciaTotal()) {
                menor = camino;
            }

        }

        return menor;
    }
    public Camino getPeorCaminoDistancia(List<Camino> caminos) {

        Camino mayor = caminos.get(0);

        for (Camino camino : caminos) {

            if (camino.getDistanciaTotal() > mayor.getDistanciaTotal()) {
                mayor = camino;
            }

        }

        return mayor;
    }
    
    public Camino getMejorCaminoGasolina(List<Camino> caminos) {

        Camino menor = caminos.get(0);

        for (Camino camino : caminos) {

            if (camino.getGasolinaTotal()< menor.getGasolinaTotal()) {
                menor = camino;
            }

        }

        return menor;
    }
    public Camino getPeorCaminoGasolina(List<Camino> caminos) {

        Camino mayor = caminos.get(0);

        for (Camino camino : caminos) {

            if (camino.getGasolinaTotal()> mayor.getGasolinaTotal()) {
                mayor = camino;
            }

        }

        return mayor;
    }
    
    
    public Camino getMejorCaminoGasolinaDistancia(List<Camino> caminos) {

        Camino menor = caminos.get(0);

        for (Camino camino : caminos) {

            if (camino.getPromDistanciaGasolina()< menor.getPromDistanciaGasolina()) {
                menor = camino;
            }

        }

        return menor;
    }
    public Camino getPeorCaminoGasolinaDistancia(List<Camino> caminos) {

        Camino mayor = caminos.get(0);

        for (Camino camino : caminos) {

            if (camino.getPromDistanciaGasolina()> mayor.getPromDistanciaGasolina()) {
                mayor = camino;
            }

        }

        return mayor;
    }
    
    
    
    
    
    

}