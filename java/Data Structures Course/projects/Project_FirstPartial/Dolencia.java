/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project_FirstPartial;
import java.util.ArrayList;
/**
 *
 * @author User
 */
public class Dolencia {
    String nombreDeDolencia;
    ArrayList<String> sintomas=new ArrayList<>();
    
    public Dolencia(String nombreDeDolencia) {
        this.nombreDeDolencia = nombreDeDolencia;
    }

    public String getNombreDeDolencia() {
        return nombreDeDolencia;
    }

    public void setNombreDeDolencia(String nombreDeDolencia) {
        this.nombreDeDolencia = nombreDeDolencia;
    }

    public ArrayList<String> getSintomas() {
        return sintomas;
    }    
    public static Dolencia dolenciaStringToDolencia(String s){
        Dolencia dol= new Dolencia(s);
        return dol;
    }
    @Override
    public String toString(){
        return this.nombreDeDolencia;
    }
}
