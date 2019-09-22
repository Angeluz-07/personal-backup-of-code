/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project_FirstPartial;

/**
 *
 * @author User
 */
public class Persona {
    private int noDeCedula;
    private String nombre;
    
    public Persona(){
    }
    public Persona(int noDeCedula,String nombre){
        this.noDeCedula=noDeCedula;
        this.nombre=nombre;
    }
    public void setNoDeCedula(int noDeCedula){
        this.noDeCedula=noDeCedula;
    }
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    
    public int getNoDeCedula(){
        return this.noDeCedula;
    }
   
    public String getNombre(){
        return this.nombre;
    }
    
   
    
}
