/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacioncieloslimpios;

/**
 *
 * @author MSI
 */
public class DronRecolector extends UnidadAerea {

    //Atributos
    private double capacidadMaxima;
    private double pesoActual;

    //Constructor
    public DronRecolector(String numeroSerie, int porcentajeBateria, boolean conectadoRed, double capacidadMaxima){
        super(numeroSerie, porcentajeBateria, conectadoRed);
        this.capacidadMaxima = capacidadMaxima;
        this.pesoActual = 0;
    }//Fin Constructor

    //GET
    public double getCapacidadMaxima(){
        return this.capacidadMaxima;
    }

    public double getPesoActual(){
        return this.pesoActual;
    }

    //Metodos
    public boolean evaluarPesoObjeto(double pesoNuevo){
        boolean excedido = false;

        if((this.pesoActual + pesoNuevo) > this.capacidadMaxima){
            excedido = true;
        }

        return excedido;
    }//Fin evaluarPesoObjeto

    public void engancharDesecho(double pesoNuevo){
        System.out.println("Objeto detectado de " + pesoNuevo + " kg. Capacidad: " + this.capacidadMaxima + " kg");

        if(evaluarPesoObjeto(pesoNuevo)){
            System.out.println("Operacion cancelada. Aviso a la base: objeto demasiado pesado");
        }else{
            this.pesoActual = this.pesoActual + pesoNuevo;
            System.out.println("Residuo recogido correctamente. Peso actual: " + this.pesoActual + " kg");
        }
    }//Fin engancharDesecho

    public void descargarContenedorBase(){
        System.out.println("Regresando a la base... compartimiento abierto");
        this.pesoActual = 0;
        System.out.println("Compartimiento vacio. Peso actual: " + this.pesoActual + " kg");
    }//Fin descargarContenedorBase

}//Fin Class DronRecolector
