/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package structures.Partial2Task1;

import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;


/**
 *
 * @author CltControl
 */
public class MapsTask {
    public static void main(String[] args){
    String line;
    Map<String,String> subjects=new HashMap();
    try{
        Scanner sc= new Scanner(new File("C:/Users/User/Documents/NetBeansProjects/Estructuras/src/structures/Partial2Task1/Materias.txt"));
        while(sc.hasNextLine()){
            line=sc.nextLine();
            //"Calculo Diferencial,ICM01941"
            String array[]=line.split(",");
            //array=["Calculo Diferencial","ICM01941"]
            subjects.put(array[1], array[0]);
        }
    }catch (Exception e) {
            e.printStackTrace();
        }
    //System.out.println(subjects);
    String subjectName,code,confirmation; 
    Scanner input= new Scanner(System.in);

    for(int i=0; i<3;i++){
        System.out.print("Ingrese el nombre de una Materia: ");
        subjectName=input.nextLine();
       
        System.out.print("Ingrese el codigo de la Materia: ");
        code=input.nextLine();
        code=code.toUpperCase();
        if(subjects.containsKey(code)){
            System.out.println("La materia con codigo " +code+ ", ya existe ");
            System.out.println("y se llama: " +subjects.get(code));
            System.out.print("Esta Seguro que desea sobreescribirla? ingrese si o no:");
            confirmation=input.nextLine();
            if(confirmation.equals("si")){
                subjects.put(code, subjectName);
                System.out.printf("La materia %s fue ingresada \n",subjectName);}
        }else{
            subjects.put(code,subjectName);
            System.out.printf("La materia %s fue ingresada \n",subjectName);
        } 
    }  
    /*{     FIEC04341=Fundamentos de Programacion, 
            FIEC05321=Fundamentos de Programacion, 
        ICF01099=Fisica A, 
            ICM02400=Calculo Diferencial, 
            ICM01941=Calculo Diferencial,  
        ICF01131=Fisica C, 
        ICM00166=Estadistica,
            ICM01966=Calculo de Varias Variables, 
            ICM01956=Calculo de Varias Variables}*/
    
    System.out.println("Materias Repetidas: ");
    Set<String> repeatedSubjects=new HashSet();
    for(String s:subjects.values()){
        if(Collections.frequency(subjects.values(),s)>1){
            repeatedSubjects.add(s);
        }
    }
    for(String s:repeatedSubjects){
        System.out.println(s);
    }
    /*
    System.out.println("Codigo \t\t Materia");
    for(String key : subjects.keySet()) {
        System.out.print(key +" ");
        System.out.println(subjects.get(key));
    } 
    */  
    }
}
