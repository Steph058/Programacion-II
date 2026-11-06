/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacioncieloslimpios;

import java.util.Random;

/**
 *
 * @author MSI
 */
public class DronPatrulla extends UnidadAerea {
    
    //Atributos
    private int[] sensoresTermicos = new int[7];

    //Constructor
    public DronPatrulla(String numeroSerie, int porcentajeBateria, boolean conectadoRed){
        super(numeroSerie, porcentajeBateria, conectadoRed);
    }//Fin Constructor

    //Metodos
    public void generarMapeoEstocastico(){
        Random aleatorio = new Random();

        System.out.println("Escaneando los 7 cuadrantes forestales...");

        for (int c = 0; c < sensoresTermicos.length; c++) {
            sensoresTermicos[c] = aleatorio.nextInt(51);
            System.out.println("Sector " + (c + 1) + " -> lectura: " + sensoresTermicos[c]);
        }
    }//Fin generarMapeoEstocastico

    public void analizarAmenazas(){
        boolean riesgoEncontrado = false;
        int c = 0;

        while(c < sensoresTermicos.length){
            if(sensoresTermicos[c] > 35){
                riesgoEncontrado = true;
                System.out.println("Lectura critica en el sector " + (c + 1) + ": " + sensoresTermicos[c]);
                emitirAlertaIncendio();
                break;
            }
            c++;
        }

        if(!riesgoEncontrado){
            System.out.println("Todos los sectores estan en rango normal.");
        }
    }//Fin analizarAmenazas

    private void emitirAlertaIncendio(){
        System.out.println("ALERTA ROJA! Posible incendio en el sector");
    }//Fin emitirAlertaIncendio 

}//Fin Class DronPatrulla
