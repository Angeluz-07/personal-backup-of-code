package structures.task5;

import java.util.LinkedList;
import java.util.ListIterator;

import java.util.Collections;
import java.util.Scanner;
import java.io.File;
/**
 *
 * @author Administrador
 */
public class DataStructures_LinkedList {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Ciudad guayaquil,quito;
        guayaquil=new Ciudad("Guayaquil",3000000,344000,"25 de julio de 1535",new LinkedList());
        quito=new Ciudad("Quito",1290000,324000,"6 de diciembre de 1534",new LinkedList());
        
        
       try
        {
            Scanner sc = new Scanner (new File("C:/Users/User/Documents/NetBeansProjects/Estructuras/src/structures/taller4/Guayaquil.txt"));
            Coordenada cTemp = new Coordenada();
            while(sc.hasNextLine()){
                cTemp.str2Coordenada(sc.nextLine());
                guayaquil.puntosR.add(new Coordenada(cTemp.getLatitud(),cTemp.getLongitud()));
                //System.out.println(guayaquil.puntosR);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
       
       try
        {
            Scanner sc = new Scanner (new File("C:/Users/User/Documents/NetBeansProjects/Estructuras/src/structures/taller4/Quito.txt"));
            Coordenada cTemp = new Coordenada();
            while(sc.hasNextLine()){
                cTemp.str2Coordenada(sc.nextLine());
                quito.puntosR.add(new Coordenada(cTemp.getLatitud(),cTemp.getLongitud()));
                //System.out.println(quito.puntosR);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Los ordeno por valor de latitud
        Collections.sort(guayaquil.puntosR,Collections.reverseOrder());
        Collections.sort(quito.puntosR);
        
        
        Ciudad cuenca, duran, loja;
        cuenca= new Ciudad("Cuenca",700000,70590,"12 de Abril de 1557",new LinkedList());
        duran= new Ciudad("Duran",235769,59000,"16 de October de 1924",new LinkedList());
        loja= new Ciudad("Loja",180019,57000,"8 de Diciembre de 1548",new LinkedList());
        
        Pais ecuador = new Pais("Ecuador",15740000,283560,"10 de Agosto de 1809",new LinkedList());
        ecuador.ciudades.add(guayaquil);
        ecuador.ciudades.add(quito);
        ecuador.ciudades.add(cuenca);
        ecuador.ciudades.add(duran);
        ecuador.ciudades.add(loja);
        
        
        ListIterator<Coordenada> itrA;
        itrA= ecuador.ciudades.get(0).puntosR.listIterator(0);
        System.out.println("Puntos de referencia Guayaquil-Ecuador, ordenados de mayor a menor segun la distancia al origen");
        while(itrA.hasNext()){
            System.out.print(itrA.next().toString()+" ");
            }
        System.out.println();
        
        itrA = ecuador.ciudades.get(1).puntosR.listIterator(0);
        System.out.println("Puntos de referencia Quito-Ecuador, ordenados de mayor a menor segun la distancia al origen");
        while(itrA.hasNext()){
            System.out.print(itrA.next().toString()+" ");
            }
        System.out.println();
        
        
        
        ecuador.ciudades.sort(new ComparatorCiudadesPorNombre());
        ListIterator<Ciudad> itr;
        itr= ecuador.ciudades.listIterator();
        
        
        System.out.println("Atributos de las ciudades en orden descendente");
        System.out.println("Por nombre: ");
        while(itr.hasNext()){
            Ciudad ciuTemp= itr.next();
            System.out.print(ciuTemp +" ");
            }
        System.out.println();
        
        ecuador.ciudades.sort(new ComparatorCiudadesPorPoblacion());
        System.out.println("Por poblacion: ");
        ListIterator<Ciudad> itr2;
        itr2= ecuador.ciudades.listIterator();
        while(itr2.hasNext()){
            Ciudad ciuTemp= itr2.next();
            System.out.print(ciuTemp.getPoblacion() +" ");
            }
        System.out.println();
        
        ecuador.ciudades.sort(new ComparatorCiudadesPorArea());
        System.out.println("Por area: ");
        ListIterator<Ciudad> itr3;
        itr3= ecuador.ciudades.listIterator();
        while(itr3.hasNext()){
            Ciudad ciuTemp= itr3.next();
            System.out.print(ciuTemp.getArea() +" ");
            }
        System.out.println();
        
        ecuador.ciudades.sort(new ComparatorCiudadesPorPuntosDeR());
        System.out.println("Por numero de puntos de referencia: ");
        ListIterator<Ciudad> itr4;
        itr4= ecuador.ciudades.listIterator();
        while(itr4.hasNext()){
            Ciudad ciuTemp= itr4.next();
            System.out.print(ciuTemp.puntosR.size() +" ");
            }
        System.out.println();
        
        
        ecuador.ciudades.sort(new ComparatorCiudadesPorNombreAsc());
        ListIterator<Ciudad> itr5;
        itr5= ecuador.ciudades.listIterator();
        
        System.out.println("\nAtributos de las ciudades en orden ascendente");
        System.out.println("Por nombre: ");
        while(itr5.hasNext()){
            Ciudad ciuTemp= itr5.next();
            System.out.print(ciuTemp +" ");
            }
        System.out.println();
        
        ecuador.ciudades.sort(new ComparatorCiudadesPorPoblacionAsc());
        System.out.println("Por poblacion: ");
        ListIterator<Ciudad> itr6;
        itr6= ecuador.ciudades.listIterator();
        while(itr6.hasNext()){
            Ciudad ciuTemp= itr6.next();
            System.out.print(ciuTemp.getPoblacion() +" ");
            }
        System.out.println();
        
        ecuador.ciudades.sort(new ComparatorCiudadesPorAreaAsc());
        System.out.println("Por area: ");
        ListIterator<Ciudad> itr7;
        itr7= ecuador.ciudades.listIterator();
        while(itr7.hasNext()){
            Ciudad ciuTemp= itr7.next();
            System.out.print(ciuTemp.getArea() +" ");
            }
        System.out.println();
        
        ecuador.ciudades.sort(new ComparatorCiudadesPorPuntosDeRAsc());
        System.out.println("Por numero de puntos de referencia: ");
        ListIterator<Ciudad> itr8;
        itr8= ecuador.ciudades.listIterator();
        while(itr8.hasNext()){
            Ciudad ciuTemp= itr8.next();
            System.out.print(ciuTemp.puntosR.size() +" ");
            }
        System.out.println();
       
    }
}
