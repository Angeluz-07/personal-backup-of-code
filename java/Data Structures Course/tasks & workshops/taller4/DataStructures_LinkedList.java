
import java.util.LinkedList;
import java.util.ListIterator;

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
       
        Pais ecuador = new Pais("Ecuador",15740000,283560,"10 de Agosto de 1809",new LinkedList());
        ecuador.ciudades.add(guayaquil);
        ecuador.ciudades.add(quito);
        
        ListIterator<Coordenada> itr;
        itr= ecuador.ciudades.get(0).puntosR.listIterator(0);
        System.out.println("Puntos de referencia Guayaquil-Ecuador");
        while(itr.hasNext()){
            System.out.println(itr.next().toString());
            }
        
        itr = ecuador.ciudades.get(1).puntosR.listIterator(0);
        System.out.println("Puntos de referencia Quito-Ecuador");
        while(itr.hasNext()){
            System.out.println(itr.next().toString());
            }
    }
}
