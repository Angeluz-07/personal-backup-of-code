/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project_FirstPartial;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 
 * @author User
 */
public class Paciente extends Persona implements Comparable<Paciente>{
        private boolean sexo;//if masculino,sexo=true, if femenino,sexo=false
        private String grupoSanguineo;//A-B-AB-O
        private ArrayList<String> alergias=new ArrayList<>();//create a static method to store the elements
        private ArrayList<Dolencia> dolencias=new ArrayList<>();//there's no setters methods
        private int estadoDeEmergencia;//"URGENTE"=3,"MEDIA"=2,"BAJA"=1

    public Paciente(){
    }
    public Paciente(int noDeCedula, String nombre,boolean sexo, String grupoSanguineo, int estadoDeEmergencia) {
        super(noDeCedula, nombre);
        this.sexo = sexo;
        this.grupoSanguineo = grupoSanguineo;
        this.estadoDeEmergencia=estadoDeEmergencia;
    }

    public int getEstadoDeEmergencia() {
        return estadoDeEmergencia;
    }

    public void setEstadoDeEmergencia(int estadoDeEmergencia) {
        this.estadoDeEmergencia = estadoDeEmergencia;
    }
    
    /*i set "URGENTE"=3,"MEDIA"=2,"BAJA"=1
    with this, i just have to compare numbers
    to see which patient is most important :)
    it does from the higher to the lowest
    */

    @Override
    public int compareTo(Paciente p){
        return p.getEstadoDeEmergencia()-this.estadoDeEmergencia;
    }
    
    
            
    public boolean isSexo() {
        return sexo;
    }

    public void setSexo(boolean sexo) {
        this.sexo = sexo;
    }

    public String getGrupoSanguineo() {
        return grupoSanguineo;
    }

    public void setGrupoSanguineo(String grupoSanguineo) {
        this.grupoSanguineo = grupoSanguineo;
    }

    public ArrayList<String> getAlergias() {
        return alergias;
    }

    public ArrayList<Dolencia> getDolencias() {
        return dolencias;
    }
    
    public void setAlergias(ArrayList<String> alergias) {
        this.alergias=alergias;
    }

    public void setDolencias(ArrayList<Dolencia> dolencias) {
        this.dolencias=dolencias;
    }
    
    public static PriorityQueue<Paciente> ingresarPacientes(String ruta){
        PriorityQueue<Paciente> pacientes=new PriorityQueue();
        Paciente paciente;
        try{
            Scanner sc =new Scanner(new File(ruta));
            while(sc.hasNextLine()){
            //sc.nextLine()="0937633248,Alberto,masculino,A,URGENTE,polen-acaros-peluza-camaron,intoxicacion-estres";
            String[] tempList1=sc.nextLine().split(",");
            //tempList1=["0937633248,Alberto,masculino,A,URGENTE,polen-acaros-peluza-camaron,intoxicacion-estres";
            
            int noCedula=Integer.parseInt(tempList1[0]);
            String nombre=tempList1[1];
            boolean sexo=Paciente.sexoStringToBoolean(tempList1[2]);
            String grupoSanguineo=tempList1[3];
            int estadoDeEmergencia=Paciente.estadoDeEmergenciaStringToInt(tempList1[4]);
            
            paciente=new Paciente(noCedula,nombre,sexo,grupoSanguineo,estadoDeEmergencia);
            String[] alergias=tempList1[5].split("-");
            paciente.alergias.addAll(Arrays.asList(alergias));
            String[] dolencias=tempList1[6].split("-");
            for (String dolenciaString:dolencias){
                paciente.dolencias.add(Dolencia.dolenciaStringToDolencia(dolenciaString));
            }
            pacientes.add(paciente);
            }
            return pacientes;
        }catch(Exception e){   
            System.out.println(e.toString());
        }
        return pacientes;//returns an empty list of patients if things go wrong
    }
    public static boolean sexoStringToBoolean(String s){
        return s.equals("masculino");
    }
    public static String sexoBooleanToString(boolean v){
        if (v==true){
            return "masculino";
        }else{
            return "femenino";
        }
    }
    
    public static int estadoDeEmergenciaStringToInt(String s){
        if (s.equals("URGENTE")){
            return 3;
        }
        if (s.equals("MEDIA")){
            return 2;
        }
        if (s.equals("BAJA")){
            return 1;
        }
        return 0;}//returns 0 if s doesn't fit with the three emergency states which is almost imposible
    
    public static String estadoDeEmergenciaIntToString(int i){
        if (i==3){
            return "URGENTE";
        }
        if (i==2){
            return "MEDIA";
        }
        if (i==1){
            return "BAJA";
        }
        return "";}
    
    @Override
    public String toString(){
        return "Nombre: "+this.getNombre()+", "+
               "CI: "+this.getNoDeCedula()+", "+
               "Sexo: "+Paciente.sexoBooleanToString(this.sexo)+", "+
               "Grupo Sanguineo: "+this.getGrupoSanguineo()+"\n"+
               "Alergias: "+ this.alergias + "\n"+
               "Dolencias: "+ this.dolencias +"\n"+
               "Estado De Emergencia: "+ Paciente.estadoDeEmergenciaIntToString(this.estadoDeEmergencia); 
    }
    
    /* Este metodo es para crear una copia del objeto, pero por ahora no lo necesitamos
    public Paciente getNewCopy(){
        Paciente copiaDePaciente=new Paciente();
        copiaDePaciente.setNombre(this.getNombre());
        copiaDePaciente.setNoDeCedula(this.getNoDeCedula());
        copiaDePaciente.setSexo(this.sexo);
        copiaDePaciente.setGrupoSanguineo(this.grupoSanguineo);
        copiaDePaciente.setHabitacion(this.habitacionAsignada);
        copiaDePaciente.setAlergias(this.alergias);
        copiaDePaciente.setDolencias(this.dolencias);
        return copiaDePaciente;  
    }
    */
}
