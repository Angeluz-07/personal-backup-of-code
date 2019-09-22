/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project_FirstPartial;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class Habitacion {
    private int noDeHabitacion;
    private int noDeCamas;
    private ArrayList<Paciente> pacientesIngresados=new ArrayList();
    private Medico medicoEncargado;
    
    public Habitacion(){
        
    }

    public Habitacion(int noDeHabitacion, int noDeCamas) {
        this.noDeHabitacion = noDeHabitacion;
        this.noDeCamas = noDeCamas;
    }
    
    public static ArrayList<Habitacion> ingresarHabitaciones(String ruta,ArrayList<Medico> medicos){
        ArrayList<Habitacion> habitaciones=new ArrayList();
        Habitacion habitacion;
        try{
          Scanner sc= new Scanner(new File(ruta));
          String[] tempList1; 
          while(sc.hasNextLine()){
            tempList1=sc.nextLine().split(",");
            //3,2,0926211568
            int cedulaMedicoEncargado=Integer.parseInt(tempList1[2]);
            habitacion=new Habitacion(Integer.parseInt(tempList1[0]),Integer.parseInt(tempList1[1]));
            for(Medico medico:medicos){
              if (medico.getNoDeCedula()==cedulaMedicoEncargado){
                  habitacion.setMedicoEncargado(medico);}}
            habitaciones.add(habitacion);}
          return habitaciones;}catch(Exception e){}
        
      return habitaciones;
    }

    public ArrayList<Paciente> getPacientesIngresados() {
        return pacientesIngresados;
    }

    public void setPacientesIngresados(ArrayList<Paciente> pacientesIngresados) {
        this.pacientesIngresados = pacientesIngresados;
    }

    
    public Medico getMedicoEncargado() {
        return medicoEncargado;
    }

    public void setMedicoEncargado(Medico medicoEncargado) {
        this.medicoEncargado = medicoEncargado;
    }
    
    public int getNoDeHabitacion() {
        return noDeHabitacion;
    }

    public void setNoDeHabitacion(int noDeHabitacion) {
        this.noDeHabitacion = noDeHabitacion;
    }

    public int getNoDeCamas() {
        return noDeCamas;
    }

    public void setNoDeCamas(int noDeCamas) {
        this.noDeCamas = noDeCamas;
    }
    @Override
    public String toString(){
        return "Habitacion No "+this.noDeHabitacion;
    }
    @Override
    public boolean equals(Object o){
        if(o instanceof Habitacion){
            Habitacion h=(Habitacion)o;
            return h.getNoDeHabitacion()==this.noDeHabitacion;
        }
        return false;
        
    }
}
