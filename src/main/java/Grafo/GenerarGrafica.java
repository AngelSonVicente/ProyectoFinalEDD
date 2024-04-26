/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Grafo;

import java.util.List;

/**
 *
 * @author angel
 */
public class GenerarGrafica {
    
    
    
    
    
    
    
      public String generarDOT(List<Nodo> nodos, List<Arista> aristas) {
        StringBuilder dot = new StringBuilder();

        dot.append("digraph Mapa {\n");

        // Agregar nodos al DOT
        for (Nodo nodo : nodos) {
            dot.append("    ").append(nodo.getId()).append(" [label=\"").append(nodo.getNombre()).append("\"];\n");
        }

        // Agregar aristas al DOT
        for (Arista arista : aristas) {
            int inicioId = arista.getInicio().getId();
            int finId = arista.getFin().getId();
            String tipo = arista.isDobleVia() ? "dir=\"both\"" : "dir=\"forward\"";

            dot.append("    ").append(inicioId).append(" -> ").append(finId).append(" [").append(tipo).append("];\n");
        }

        dot.append("}");

        return dot.toString();
    }
    
    
}
