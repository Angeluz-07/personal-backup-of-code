/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise_tuttoringForExam;

import java.util.ArrayList;

/**
 *
 * @author User
 */
public class TablasPoo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Tabla1D t1 = new Tabla1D();
        Tabla1D t2= new Tabla1D();
        t1.setOrientacion(Orientacion.HORIZONTAL);        
        t2.setOrientacion(Orientacion.HORIZONTAL);
        
        Celda c1=new ClaseCelda();
        Celda c2=new ClaseCelda();
        Celda c3=new ClaseCelda();
        Celda c4=new ClaseCelda();
        t1.setC1(c1);
        t1.setC2(c2);
        
        t2.setC1(c3);
        t2.setC2(c4);
        
        
        Tabla2D table=new Tabla2D();
        
        table.setT1(t1);
        table.setT2(t2);
        
        
        
        
    }
    
}
