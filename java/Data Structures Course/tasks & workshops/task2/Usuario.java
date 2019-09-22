/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package structures.task2;

/**
 *
 * @author User
 */
public class Usuario {
    private String clave;
    private String nombre;
    
    public Usuario(String nombre,String clave){
        this.nombre=nombre;
        this.clave=clave;
    }
    public Usuario(){
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public String getClave(){
        return this.clave;
    }
    
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    
    public void setClave(String clave){
        this.clave=clave;
    }
    
}
