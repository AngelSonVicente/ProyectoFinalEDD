/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.proyectofinaledd;

import ArbolB.ArbolB;
import Grafo.Grafo;
import Model.Dato;
import Model.Nodo;
import Ventanas.Principal;

/**
 *
 * @author angel
 */
public class ProyectoFinalEDD {

    public static void main(String[] args) {
        
        
        
        int t = 3;
        /*


        System.out.println("Hello World!");

        String datos = "AltaVerapaz|SantaMaríadeJesús|24|51|24|456|85\n"
                + "Petén|CiudadVieja|24|42|24|453|24\n"
                + "Quetzaltenango|Retalhuleu|25|50|56|54|100\n"
                + "Retalhuleu|Quetzaltenango|36|45|60|80|100\n"
                + "SanMarcos|Quetzaltenango|30|35|62|15|250\n"
                + "Suchitepequez|Guatemala|70|250|60|2500|70\n"
                + "SanMarcos|SanBartoloméMilpasAltas|24|425|62|63|55\n"
                + "Huehuetenango|SanLucasSacatepéquez|24|123|32|47|62\n"
                + "Quiché|SantaLucíaMilpasAltas|24|62|42|46|32";
        Grafo mapa = new Grafo();

 
        mapa.cargarDatos(datos);

        System.out.println(mapa.toString());
        
        
        System.out.println("\n-------------------------------------------------------------------------------------\n");
        
        System.out.println("Grafica: ");
        
        System.out.println(mapa.generarDOT());
           

         */

        
       
        ArbolB arbolB = new ArbolB(t);

        
        Dato dato1 = new Dato(20, "dato20");
        Dato dato2 = new Dato(10, "dato110");
        Dato dato3 = new Dato(50, "dato50");
        Dato dato4 = new Dato(30, "dato30");
        Dato dato5 = new Dato(30, "dato40");

        Dato dato6 = new Dato(60, "dato60");

        Dato dato7 = new Dato(80, "dato80");
        Dato dato8 = new Dato(70, "dato70");

        arbolB.insertar(dato1);
        arbolB.insertar(dato2);
        arbolB.insertar(dato3);
        arbolB.insertar(dato4);
        arbolB.insertar(dato5);
        arbolB.insertar(dato6);
        arbolB.insertar(dato7);
        arbolB.insertar(dato8);

        System.out.println("");

        System.out.println("\n\n\n" + arbolB.generarDOT());

        arbolB.getDatoMenor();
        arbolB.getDatoMayor();
    
        
        
        
        Principal principal = new Principal();

        principal.setVisible(true);

    }

}
