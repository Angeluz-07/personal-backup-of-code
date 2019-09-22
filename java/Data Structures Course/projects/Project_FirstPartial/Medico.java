/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project_FirstPartial;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class Medico extends Persona{
    private int telefono;
    private String especialidad;
    private ArrayList<Paciente> pacientes= new ArrayList<>();

    public Medico(int noDeCedula,String nombre,int telefono, String especialidad) {
        super(noDeCedula, nombre);
        this.telefono = telefono;
        this.especialidad = especialidad;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public ArrayList<Paciente> getPacientes() {
        return pacientes;
    }
    
    public static ArrayList<Medico> ingresarMedicos(String ruta){
        ArrayList<Medico> medicos=new ArrayList();
        Medico medico;
        try{
            Scanner sc =new Scanner(new File(ruta));
            while(sc.hasNextLine()){
            //sc.nextLine()="0926211568,Ricardo,2472309,Otorrinologia";
            String[] tempList1=sc.nextLine().split(",");
            //tempList1=["0926211568,Ricardo,2472309,Otorrinologia"];
            int noCedula=Integer.parseInt(tempList1[0]);
            String nombre=tempList1[1];
            int telefono=Integer.parseInt(tempList1[2]);
            String especialidad=tempList1[3];
            medico=new Medico(noCedula,nombre,telefono,especialidad);
            medicos.add(medico);
            }
            return medicos;
        }catch(Exception e){   
            System.out.println(e.toString());
        }
        return medicos;
    }
    
    @Override
    public String toString(){
        return "Nombre: "+this.getNombre()+", "+
               "CI: "+this.getNoDeCedula()+", "+
               "Telefono: "+this.telefono+", "+
               "Especialidad: "+this.especialidad;
    }
}
