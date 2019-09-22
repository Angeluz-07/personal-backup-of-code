import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Map;
import java.util.Scanner;
//import org.espol.edu.ec.grafos.algoritmos.GrafosAlgoritmos;
import org.espol.edu.ec.ui.GrafoUI;
import org.espol.edu.ec.grafos.lista.Grafo;
import org.espol.edu.ec.grafos.lista.Vertice;


/**
 *
 * @author ancalder
 */
public class Main {
    
    public static void main(String[] args) {
        
        Map<String,Aeropuerto> mapOfAirports=Aeropuerto.cargarAeropuertos("C:/Users/User/Documents/NetBeansProjects/grafos/src/airports.dat");
        Grafo grafoAeropuertos=new Grafo(false);
        
        String line;
        String[] array;
        try{
            Scanner sc=new Scanner(new File("C:/Users/User/Documents/NetBeansProjects/grafos/src/routes.dat"));
            while(sc.hasNextLine()){
                line=sc.nextLine();
                array=line.split(",");
                /*Aerolinea,AerolineaID,AeropuertoPartida,
                AeropuertoPartidaID,AeropuertoDestino,
                AeropuertoDestinoID,CodigoCompartido,
                Paradas,Flota*/
                
                /*si la ruta es de uno de los 50 aeropuertos 
                con los que estoy trabajando, alli la agrego*/
                /*la ruta debe contener a dos de los aeropuertos
                con los que estoy trabajando*/
                if(mapOfAirports.containsKey(array[3])&&mapOfAirports.containsKey(array[5])){                    
                    Ruta r=new Ruta(array[0],array[1],mapOfAirports.get(array[3]),mapOfAirports.get(array[5]),array[3],array[5],array[6],array[7],array[8]); 
                    /*no se si hay ruta de regreso, asi que 
                    solo hago la de ida*/
                    mapOfAirports.get(array[3]).getRutas().add(r);                            
                }
                /* esto es solo para ver porque las rutas que contenian
                   uno de los 50 aeropuertos, no fueron agregadas
                   la razon es porque incluyen aeropuertos que no estan
                   entre los 50
                else if(mapOfAirports.containsKey(array[3])||mapOfAirports.containsKey(array[5])){
                    System.out.println(array[3]+" "+array[5]);
                }*/
            }   
        }catch(Exception e){
            e.printStackTrace(); }
        
        //Genero los vertices
        for(Aeropuerto a:mapOfAirports.values()){
            grafoAeropuertos.agregarVertice(a);
        }
        for(String k:mapOfAirports.keySet()){            
            for(Ruta r:mapOfAirports.get(k).getRutas()){
                /*Si hay mas de una aerolinea que conecta 
                dos aeropuertos(y las hay) no importa. El metodo
                agregar arco, verifica que el arco no exista. Si 
                el arco existe no hace nada.*/
                grafoAeropuertos.agregarArco(r.getAeropuertoPartida(),r.getAeropuertoDestino(),0);
            }
        }
        
        //esto es para ver las rutas por cada aeropuerto
        System.out.println("Aeropuertos y sus respectivas rutas:");
        for(String k:mapOfAirports.keySet()){
            System.out.println(mapOfAirports.get(k));            
            for(Ruta r:mapOfAirports.get(k).getRutas()){
                System.out.println(r);
            }   
        }
        
        //System.out.println(grafoAeropuertos);
        
        GrafoUI<String> grafoUI = new GrafoUI(grafoAeropuertos);
        grafoUI.mostrarGrafo();
        
        
        Scanner input=new Scanner(System.in);
        System.out.print("Ingrese el Id del Aeropuerto de partida: ");
        String idIngresado=input.nextLine();
        Vertice vPartida=grafoAeropuertos.buscarVertice(mapOfAirports.get(idIngresado));
        grafoAeropuertos.dijkstra(vPartida);
        System.out.print("Ingrese el Id del Aeropuerto de destino: ");
        idIngresado=input.nextLine();
        Vertice vDestino=grafoAeropuertos.buscarVertice(mapOfAirports.get(idIngresado));
        
        //System.out.println("Distance to " + mapOfAirports.get(idIngresado) + ": " + vDestino.getMinDistance());
        ArrayList<Vertice> path = grafoAeropuertos.getShortestPathTo(vDestino);
        //System.out.println("Path: " + path);
        if(path.size()==1){
            System.out.println("No existe un camino entre estos aeropuertos.");
        }else{
            Grafo grafoRutaCorta=new Grafo(true);
            for(int i=0;i<path.size();i++){
                grafoRutaCorta.agregarVertice(path.get(i));                                
            }
            for(int i=0;i<path.size()-1;i++){
                grafoRutaCorta.agregarArco(path.get(i),path.get(i+1));
            }
            GrafoUI<String> grafoUI2 = new GrafoUI(grafoRutaCorta);
            grafoUI2.mostrarGrafo();
        }
        
        
        
       
        /*
        Grafo<String> grafo = new Grafo(true);
        grafo.agregarVertice("A");
        grafo.agregarVertice("B");
        grafo.agregarVertice("C");
        grafo.agregarVertice("D");
        grafo.agregarVertice("H");
        grafo.agregarVertice("R");
        grafo.agregarVertice("T");
        
        grafo.agregarArco("D", "B");
        grafo.agregarArco("D", "C");
        grafo.agregarArco("B", "H",3);
        grafo.agregarArco("B", "D",2);
        grafo.agregarArco("H", "A");
        grafo.agregarArco("H", "T",20);
        grafo.agregarArco("H", "D");
        grafo.agregarArco("C", "R",25);
        grafo.agregarArco("R", "H",5);
        grafo.agregarArco("T", "D");
        
        
        System.out.println(grafo);
        
        GrafoUI<String> grafoUI = new GrafoUI(grafo);
        grafoUI.mostrarGrafo();
        
        //alert with these methods
        LinkedList<String> recorrido= new LinkedList<>();

        //GrafosAlgoritmos algoritmos = new GrafosAlgoritmos();
        //recorrido = algoritmos.recorridoEnAnchura(grafo, "D");
        recorrido.add("D");
        recorrido.add("B");
        recorrido.add("H");
        recorrido.add("A");
        grafoUI.mostrarRecorrido(recorrido);
        
        
        LinkedList<Vertice> padres= grafo.getPadres("D");
        ListIterator<Vertice> it = padres.listIterator();
        System.out.println("Padres de D:");
        while (it.hasNext()) {
            Vertice v = it.next();
            System.out.println(v+" -> "+  v.getArcos());
        }
        System.out.println("");
        
        System.out.println("Padres de D (con peso 2):");
        padres= grafo.getPadres("D",2);
        it = padres.listIterator();
        while (it.hasNext()) {
            Vertice v = it.next();
            System.out.println(v.getContenido()+" -> "+  v.getArcos());
        }
        */
        
    }
    /*
    public static void generarGrafo(Map<String,Aeropuerto> mapaDeAeropuertos){
    try{
            Scanner sc=new Scanner(new File(ruta));
            int n=0;
            while(sc.hasNextLine()&&n<50){
                line=sc.nextLine();
                array=line.split(",");
                //System.out.println(array[1]);
                //listOfLines=Arrays.asList(array);
                
                //here i create the airport just with ID and the name
                aeropuertoTemp=new Aeropuerto(array[0],array[1]);
                mapOfData.put(array[0],aeropuertoTemp);
                //System.out.println(listOfLines);
                n+=1;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }*/
    
}

