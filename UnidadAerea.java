/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacioncieloslimpios;

/**
 *
 * @author MSI
 */
public class UnidadAerea {
    
    //Atributos
    private String numeroSerie;
    private int porcentajeBateria;
    private boolean conectadoRed;

    //Constructor
    public UnidadAerea(String numeroSerie, int porcentajeBateria, boolean conectadoRed){
        this.numeroSerie = numeroSerie;
        this.conectadoRed = conectadoRed;
        setPorcentajeBateria(porcentajeBateria);
    }//Fin Constructor

    //GET Y SET
    public String getNumeroSerie(){
        return this.numeroSerie;
    }

    public void setNumeroSerie(String numeroSerie){
        this.numeroSerie = numeroSerie;
    }

    public int getPorcentajeBateria(){
        return this.porcentajeBateria;
    }

    public void setPorcentajeBateria(int porcentajeBateria){
        if(porcentajeBateria < 0){
            System.out.println("Bateria menor a 0. Se ajusta a 0");
            this.porcentajeBateria = 0;
        }else if(porcentajeBateria > 100){
            System.out.println("Bateria mayor a 100. Se ajusta a 100");
            this.porcentajeBateria = 100;
        }else{
            this.porcentajeBateria = porcentajeBateria;
        }

        calibrarGiroscopioInterno();
    }//Fin setPorcentajeBateria

    public boolean getConectadoRed(){
        return this.conectadoRed;
    }

    public void setConectadoRed(boolean conectadoRed){
        this.conectadoRed = conectadoRed;
    }

    //Metodos
    private void calibrarGiroscopioInterno(){
        System.out.println("Unidad " + this.numeroSerie + ": calibrando giroscopio...");
    }//Fin calibrarGiroscopioInterno

    public void transmitirEstadoRed(){
        System.out.println("[ Balizas encendidas ]");
        System.out.println("Numero de serie: " + this.numeroSerie);
        System.out.println("Bateria: " + this.porcentajeBateria + " por ciento");
        System.out.println("Lista para ordenes: " + this.conectadoRed);
        System.out.println("===============================");
    }//Fin transmitirEstadoRed
    
}//Fin Class UnidadAerea