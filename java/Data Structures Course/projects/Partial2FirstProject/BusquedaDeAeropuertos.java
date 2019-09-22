/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package structures.Partial2FirstProject;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author User
 */
public class BusquedaDeAeropuertos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String line;
        String [] array;
        List<String> listOfLines;
        
        ArrayList<Node> listOfData=new ArrayList();
        Node n;
        
        Map<String,List<String>> mapOfData=new HashMap();
        try{
            Scanner sc=new Scanner(new File("C:/Users/User/Documents/NetBeansProjects/Estructuras/src/structures/Partial2FirstProject/airports.dat"));
            while(sc.hasNextLine()){
                line=sc.nextLine();
                array=line.split(",");
                /*ID,Nombre,Ciudad,Pais,CodigoIATA/FAA,
                CodigoICAO,Latitud,Longitud,Altitud,
                ZonaHorario,DST,Zona*/
                //System.out.println(array[1]);
                listOfLines=Arrays.asList(array);
                n=new Node(array[0],listOfLines);
                //n is a node which contains the id and a reference to the list
                listOfData.add(n);
                mapOfData.put(array[0],listOfLines);
                //System.out.println(listOfLines);
            }
        }catch(Exception e){e.printStackTrace();}
        
        String l1,l2;
        double ti,tf,t;
        List info1;
        List info2=new ArrayList();
        String idIngresado;
        
        Scanner input= new Scanner(System.in);
        System.out.print("Ingrese un id: ");
        idIngresado=input.nextLine();
        ti=System.currentTimeMillis();
        info1=(List)mapOfData.get(idIngresado);
        //System.out.println(info1);
        tf=System.currentTimeMillis();
        t=(tf-ti);
        System.out.println();
        /*ID,Nombre,Ciudad,Pais,CodigoIATA/FAA,
                CodigoICAO,Latitud,Longitud,Altitud,
                ZonaHorario,DST,Zona*/
        l1="ID: "+info1.get(0)+",Nombre: "+info1.get(1)+
            ",Ciudad: "+info1.get(2) +",Pais: "+info1.get(3)+
            ",CodigoIATA/FAA: "+info1.get(4)+",CodigoICAO: "+info1.get(5) +
            ",Latitud: "+info1.get(6)+",Longitud: "+info1.get(7) +
            ",Altitud: "+info1.get(8)+",ZonaHorario: "+info1.get(9)+
            ",DST: "+info1.get(10)+",Zona: "+info1.get(11);
        
        System.out.println("Los datos de este aeropuerto obtenidos con un HashMap  son : \n"+l1);
        System.out.printf("Con Mapas se tardo %f segundos en encontrar la informacion. \n\n",t);
        
        
        
        ti=System.currentTimeMillis();
        for(Node node:listOfData){
            if(node.getId().equals(idIngresado)){
                info2=node.getList();
                //System.out.println(info2);
                break;
                }     
        }
        tf=System.currentTimeMillis();
        t=(tf-ti)/1000;
        l2="ID: "+info2.get(0)+",Nombre: "+info2.get(1)+
            ",Ciudad: "+info2.get(2) +",Pais: "+info2.get(3)+
            ",CodigoIATA/FAA: "+info2.get(4)+",CodigoICAO: "+info2.get(5) +
            ",Latitud: "+info2.get(6)+",Longitud: "+info2.get(7) +
            ",Altitud: "+info2.get(8)+",ZonaHorario: "+info2.get(9)+
            ",DST: "+info2.get(10)+",Zona: "+info2.get(11);
        
        System.out.println("Los datos de este aeropuerto obtenidos con una Lista son : \n"+l2);
        System.out.printf("Con una lista se tardo %f segundos en encontrar la informacion.\n\n",t);
        
        
        
        String cadenaIngresada;
        System.out.print("Ingrese un cadena de texto para ver que Nombres de Aeropuertos la contienen: ");
        cadenaIngresada=input.nextLine();
        
        System.out.println("Los aeropuertos que contienen la cadena son:");
        
        /*All what i do below it's just to make sure to print
        a message in case the string is not in any of the names.
        Otherwise the code would be simpler*/
        
        boolean contiene=false;
        List<List<String>> values=new ArrayList(mapOfData.values());
        for(List<String> packOfData:values){
            if(packOfData.get(1).contains(cadenaIngresada)){
                System.out.println(packOfData.get(1));
                contiene=true;
            }
            if(packOfData.equals(values.get(values.size()-1))&&contiene==false){
                System.out.println("Ups lo sentimos...la cadena no esta contenida en ningun nombre.");
            }
            
        }
        
        
        
        
    }
    
}
