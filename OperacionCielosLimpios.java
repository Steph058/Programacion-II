/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package operacioncieloslimpios;

import java.util.Random;

/**
 *
 * @author MSI
 */
public class OperacionCielosLimpios {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Random generador = new Random();

        //Flota de patrulla (3 unidades de reconocimiento tactico)
        DronPatrulla[] flotaPatrulla = new DronPatrulla[3];

        flotaPatrulla[0] = new DronPatrulla("PT-101", 95, true);
        flotaPatrulla[1] = new DronPatrulla("PT-102", 80, true);
        flotaPatrulla[2] = new DronPatrulla("PT-103", 65, true);

        //Flota recolectora (2 unidades de carga ambiental)
        DronRecolector[] flotaRecolectora = new DronRecolector[2];

        flotaRecolectora[0] = new DronRecolector("RC-201", 88, true, 45);
        flotaRecolectora[1] = new DronRecolector("RC-202", 72, true, 25);

        //Ciclo de supervision de la flota de patrulla
        System.out.println("\nSUPERVISION FLOTA DE PATRULLA");

        for (int p = 0; p < flotaPatrulla.length; p++) {
            System.out.println("\nUnidad en mision: " + flotaPatrulla[p].getNumeroSerie());
            flotaPatrulla[p].generarMapeoEstocastico();
            flotaPatrulla[p].analizarAmenazas();
        }//Fin ciclo flota patrulla

        //Ciclo de supervision de la flota recolectora
        System.out.println("\n SUPERVISION FLOTA RECOLECTORA");

        for (int r = 0; r < flotaRecolectora.length; r++) {
            System.out.println("\nUnidad en mision: " + flotaRecolectora[r].getNumeroSerie());

            double pesoResiduo = 5 + generador.nextInt(46);

            flotaRecolectora[r].engancharDesecho(pesoResiduo);
            flotaRecolectora[r].descargarContenedorBase();
        }//Fin ciclo flota recolectora

        //Consumo de bateria despues de la mision
        System.out.println("\nCONSUMO DE BATERIA POST-MISION");

        flotaPatrulla[0].setPorcentajeBateria(flotaPatrulla[0].getPorcentajeBateria() - 40);
        flotaPatrulla[1].setPorcentajeBateria(-60);
        flotaPatrulla[2].setPorcentajeBateria(180);

        flotaRecolectora[0].setPorcentajeBateria(flotaRecolectora[0].getPorcentajeBateria() - 150);
        flotaRecolectora[1].setPorcentajeBateria(flotaRecolectora[1].getPorcentajeBateria() - 12);

        //Reporte final de telemetria
        System.out.println("\nREPORTE FINAL DE TELEMETRIA");

        for (int p = 0; p < flotaPatrulla.length; p++) {
            flotaPatrulla[p].transmitirEstadoRed();
        }

        for (int r = 0; r < flotaRecolectora.length; r++) {
            flotaRecolectora[r].transmitirEstadoRed();
        }


    }//Fin de Main
    
}//Fin de Class
