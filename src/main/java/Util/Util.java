/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Util;

import Model.Arista;
import Model.Camino;
import Model.Nodo;
import java.util.ArrayList;
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

            if (camino.getGasolinaTotal() < menor.getGasolinaTotal()) {
                menor = camino;
            }

        }

        return menor;
    }

    public Camino getPeorCaminoGasolina(List<Camino> caminos) {

        Camino mayor = caminos.get(0);

        for (Camino camino : caminos) {

            if (camino.getGasolinaTotal() > mayor.getGasolinaTotal()) {
                mayor = camino;
            }

        }

        return mayor;
    }
    public Camino getMejorDesgasteFisico(List<Camino> caminos) {

        Camino menor = caminos.get(0);

        for (Camino camino : caminos) {

            if (camino.getDesgasteFisico()< menor.getDesgasteFisico()) {
                menor = camino;
            }

        }

        return menor;
    }

    public Camino getPeorDesgasteFisico(List<Camino> caminos) {

        Camino mayor = caminos.get(0);

        for (Camino camino : caminos) {

            if (camino.getDesgasteFisico()> mayor.getDesgasteFisico()) {
                mayor = camino;
            }

        }

        return mayor;
    }

    public Camino getMejorCaminoGasolinaDistancia(List<Camino> caminos) {

        Camino menor = caminos.get(0);

        for (Camino camino : caminos) {

            if (camino.getPromDistanciaGasolina() < menor.getPromDistanciaGasolina()) {
                menor = camino;
            }

        }

        return menor;
    }

    public Camino getPeorCaminoGasolinaDistancia(List<Camino> caminos) {

        Camino mayor = caminos.get(0);

        for (Camino camino : caminos) {

            if (camino.getPromDistanciaGasolina() > mayor.getPromDistanciaGasolina()) {
                mayor = camino;
            }

        }

        return mayor;
    }

    public Camino getMejorCaminoDistanciaDesgaste(List<Camino> caminos) {

        Camino menor = caminos.get(0);

        for (Camino camino : caminos) {

            if (camino.getPromDistanciaDesgaste()< menor.getPromDistanciaDesgaste()) {
                menor = camino;
            }

        }

        return menor;
    }

    public Camino getPeorCaminoDistanciaDesgaste(List<Camino> caminos) {

        Camino mayor = caminos.get(0);

        for (Camino camino : caminos) {

            if (camino.getPromDistanciaDesgaste()> mayor.getPromDistanciaDesgaste()) {
                mayor = camino;
            }

        }

        return mayor;
    }
    public Camino getMejorCaminoRapidez(List<Camino> caminos) {

        Camino menor = caminos.get(0);

        for (Camino camino : caminos) {

            if (camino.getTiempoTotalVehiculo()< menor.getTiempoTotalVehiculo()) {
                menor = camino;
            }

        }

        return menor;
    }

    public Camino getPeorCaminoRapidez(List<Camino> caminos) {

        Camino mayor = caminos.get(0);

        for (Camino camino : caminos) {

            if (camino.getTiempoTotalVehiculo()>mayor.getTiempoTotalVehiculo()) {
                mayor = camino;
            }

        }

        return mayor;
    }
    public Camino getMejorCaminoRapidezPie(List<Camino> caminos) {

        Camino menor = caminos.get(0);

        for (Camino camino : caminos) {

            if (camino.getTiemporTotalPie()< menor.getTiemporTotalPie()) {
                menor = camino;
            }

        }

        return menor;
    }

    public Camino getPeorCaminoRapidezPie(List<Camino> caminos) {

        Camino mayor = caminos.get(0);

        for (Camino camino : caminos) {

            if (camino.getTiemporTotalPie()>mayor.getTiemporTotalPie()) {
                mayor = camino;
            }

        }

        return mayor;
    }

    
    public List<Nodo> getTodosNodosVecinos(List<Arista> aristas, Nodo nodo) {
        List<Nodo> nodosVecinos = new ArrayList<>();
        
        for (Arista arista : aristas) {
            if (arista.getInicio().equals(nodo)) {
                nodosVecinos.add(arista.getFin());
            } else if (arista.getFin().equals(nodo)) {
                nodosVecinos.add(arista.getInicio());
            }
        }
        
        return nodosVecinos;
    }
    
    
    
    
    
    public List<Nodo> getNodosVecinos(List<Arista> aristas, Nodo nodo) {
        List<Nodo> nodosVecinos = new ArrayList<>();

        for (Arista arista : aristas) {

            if (arista.getInicio().equals(nodo)) {

                nodosVecinos.add(arista.getFin());
            }

        }
        return nodosVecinos;
    }
    
    
    
    
       public float sumarMinutosAHora(float horaActual, float minutosASumar) {
        // Extraer las horas y los minutos de la hora actual
        
//           System.out.println("horaActual:" +horaActual+ " Minutos a Sumar:   " + minutosASumar);

        
        // Calcular la nueva hora
        float nuevaHora = horaActual+(minutosASumar/60);
        
        
  //         System.out.println("\n Hora Nueva:   " +nuevaHora);
        
        return nuevaHora;
    }
    

}
