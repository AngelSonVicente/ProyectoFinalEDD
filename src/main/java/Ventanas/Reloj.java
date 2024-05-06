/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ventanas;

import java.util.Calendar;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JTextPane;

/**
 *
 * @author angel
 */
public class Reloj extends Thread {

    private JTextPane reloj;
    private Calendar horaInicial = null;
    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();

    private boolean seguir = true;
    private int hora;

    public Reloj(JTextPane reloj) {
        this.reloj = reloj;
    }

    @Override
    public void run() {
        while (true) {

            while (seguir) {
                try {

                    Calendar calendar = Calendar.getInstance();
                    if (horaInicial != null) {
                        calendar = horaInicial;
                        horaInicial = null; // Solo usamos la hora inicial una vez
                    }
                    int hora = calendar.get(Calendar.HOUR_OF_DAY);
                    int minutos = calendar.get(Calendar.MINUTE);
                    int segundos = calendar.get(Calendar.SECOND);

                    String tiempo = hora + ":" + minutos + ":" + segundos;
                    reloj.setText(tiempo);
                    Thread.sleep(1000);

                } catch (InterruptedException ex) {
                    System.out.println("Error con el reloj " + ex);
                }
            }

            System.out.print("");

        }
    }

    public float getHoraActual() {
        if (this.hora == 0) {

            Calendar calendar = Calendar.getInstance();

            return calendar.get(Calendar.HOUR_OF_DAY);

        } else {

            return this.hora;
        }
    }

    public void pararReloj() {

        seguir = false;

    }

    public void seguirReloj() {

        seguir = true;

        this.hora = 0;

    }

    public void setearHoraInicial(int hora) {

        horaInicial = Calendar.getInstance();

        horaInicial.set(Calendar.HOUR_OF_DAY, hora);

        this.hora = hora;
        reloj.setText(hora + ":00:00");

    }

}
