/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Grafo;

import Model.Arista;
import Model.Nodo;
import guru.nidi.graphviz.engine.Format;
import guru.nidi.graphviz.engine.Graphviz;
import guru.nidi.graphviz.model.MutableGraph;
import guru.nidi.graphviz.parse.Parser;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author angel
 */
public class GenerarGrafica {

    public String graficar(List<Nodo> nodos, List<Arista> aristas) {
        return generarGrafico(generarDOT(nodos, aristas))+"/mapa.png";

    }
    
    
    
    
      public String generarDOTRecorrido(List<Nodo> nodos, List<Arista> aristas,List<Nodo> recorrido, Nodo inicio, Nodo Final, Nodo actual) {
        
          String colorRecorrido="blue\"";
          StringBuilder dot = new StringBuilder();
        
    dot.append("digraph Mapa {\n");
    
    // Agregar nodos al DOT con características especiales
      for (Nodo nodo : nodos) {
    
          
           
            String color="black\"";
            if(recorrido.contains(nodo)){
                color=colorRecorrido;
                
                if(nodo.equals(inicio)){
                    color+=" , shape=Mcircle";
                
                }
                
                
                if(nodo.equals(Final)){
                    
                    color+="shape=doublecircle, style=filled, fillcolor=yellow";
                
                }
                
                if(nodo.equals(actual)){
                    if(!actual.equals(inicio)){
                    
                    color+="shape=diamond";
                    }
                    
                
                }
            
            }
            
            
            dot.append("    ").append(nodo.getId()).append(" [label=\"").append(nodo.getNombre()).append("\", color=\"").append(color).append("];\n");
       
      
      }

      
    
    // Agregar aristas al DOT con color y distancia
    for (Arista arista : aristas) {
        int inicioId = arista.getInicio().getId();
        int finId = arista.getFin().getId();
        int distancia = arista.getDistancia(); // Calcular la distancia (puedes tener un método para ello)
        String tipo = arista.isDobleVia() ? "dir=\"both\"" : "dir=\"forward\"";
        String color = recorrido.contains(arista.getInicio()) && recorrido.contains(arista.getFin()) ? colorRecorrido : "black\""; // Color del recorrido o negro
        
        dot.append("    ").append(inicioId).append(" -> ").append(finId)
           .append(" [").append(tipo).append(", color=\"").append(color).append(", label=\"").append(distancia).append("\"];\n");
    }
    
    dot.append("}");
    
    return dot.toString();
    }
    
    
    
    
    
    public String generarDOT(List<Nodo> nodos, List<Arista> aristas) {
    StringBuilder dot = new StringBuilder();
        
        dot.append("digraph Mapa {\n");
        
        // Agregar nodos al DOT
        for (Nodo nodo : nodos) {
            dot.append("    ").append(nodo.getId()).append(" [label=\"").append(nodo.getNombre()).append("\"];\n");
        }
        
        // Agregar aristas al DOT con distancias
        for (Arista arista : aristas) {
            int inicioId = arista.getInicio().getId();
            int finId = arista.getFin().getId();
            int distancia = arista.getDistancia(); // Calcular la distancia (puedes tener un método para ello)
            String tipo = arista.isDobleVia() ? "dir=\"both\"" : "dir=\"forward\"";
            
            dot.append("    ").append(inicioId).append(" -> ").append(finId)
               .append(" [").append(tipo).append(", label=\"").append(distancia).append("\"];\n");
        }
        
        dot.append("}");
        
        return dot.toString();

    }

    public String generarGrafico(String contenidoDot) {
        String Path = System.getProperty("user.dir");

        System.out.println("Path del generar Grafico: "+Path);
        String dotFileName = "mapa";

        File dotFile = new File(dotFileName);
        try {
            java.nio.file.Files.write(dotFile.toPath(), contenidoDot.getBytes());

            System.out.println("Archivo DOT generado con éxito: " + dotFileName);

            MutableGraph g = new Parser().read(dotFile);
            Graphviz.fromGraph(g).height(600).width(600).render(Format.PNG).toFile(new File(Path+"/"+"mapa"));
            System.out.println("Imagen generada con éxito: automata.png");

        } catch (IOException ex) {
            Logger.getLogger(GenerarGrafica.class.getName()).log(Level.SEVERE, null, ex);
        }

        return Path;
    }

}
