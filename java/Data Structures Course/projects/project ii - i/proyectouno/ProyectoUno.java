package proyectouno;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * Proyecto Uno - Segundo Parcial Estructuras de Datos
 *
 * @author Miguel Murillo, Roberto Mena
 */
public class ProyectoUno {

    public static void main(String[] args) throws FileNotFoundException {

        //Mapa de Aeropuertos
        Map<Integer, Aeropuerto> aeropuertos = new HashMap();

        //Lista de Aeropuertos
        ArrayList<Aeropuerto> aeropuertosLista = new ArrayList();

        //Cargando elementos al Mapa y a la Lista
        String temp;
        String[] datosAeropuerto;
        Scanner lector = new Scanner(new File("airports.dat"));
        while (lector.hasNextLine()) {
            temp = lector.nextLine();
            datosAeropuerto = temp.split(",");
            Aeropuerto a = new Aeropuerto(Integer.parseInt(datosAeropuerto[0]), datosAeropuerto[1], datosAeropuerto[2], datosAeropuerto[3], datosAeropuerto[4], datosAeropuerto[5], datosAeropuerto[6], datosAeropuerto[7], datosAeropuerto[8], datosAeropuerto[9], datosAeropuerto[10], datosAeropuerto[11]);
            aeropuertos.put(a.getID(), a);
            aeropuertosLista.add(a);
        }
        lector.close();

        //Mostrar Menú
        boolean bandera = true;
        int respuesta;
        Scanner resp = new Scanner(System.in);
        Scanner lector2 = new Scanner(System.in);
        int IDbuscar;
        int control;
        String cadena;
        Set<Integer> IDS = new HashSet();
        ArrayList<Aeropuerto> aeropuertosCoincidentes = new ArrayList();
        int resultadoIndex;
        while (bandera) {
            System.out.println("");
            System.out.println("MENÚ");
            System.out.println("1. Buscar por ID");
            System.out.println("2. Buscar por nombre");
            System.out.println("3. Salir");
            System.out.println("Por favor seleccione una opción del menú: ");
            respuesta = resp.nextInt();
            while (respuesta < 1 || respuesta > 3) {
                System.out.println("Por favor seleccione una opción válida: ");
                respuesta = resp.nextInt();
            }
            switch (respuesta) {
                case 1:
                    control = 0;
                    System.out.println("Por favor ingrese el ID del Aeropuerto que desea buscar: ");
                    IDbuscar = resp.nextInt();
                    //Búsqueda en la Lista
                    double tiempoInicio = System.currentTimeMillis();
                    for (Aeropuerto a : aeropuertosLista) {
                        if (a.getID() == IDbuscar) {
                            double tiempoFin = System.currentTimeMillis();
                            System.out.println("Los datos del Aeropuerto son: ");
                            System.out.println("Nombre: " + a.getNombre() + ",Ciudad: " + a.getNombreCiudad() + ",País: " + a.getNombrePais() + ",CodigoIATA/FAA: " + a.getCodigoIATAFAA() + ",CodigoICAO: " + a.getCodigoICAO() + ",Latitud: " + a.getLatitud() + ",Longitud: " + a.getLongitud() + ",Altitud: " + a.getAltitud() + ",Zona Horaria: " + a.getZonaHorario() + ",DTS: " + a.getDTS() + ",Zona: " + a.getZona());
                            double tiempo = tiempoFin - tiempoInicio;
                            System.out.println("El tiempo de búsqueda de datos en la Lista fue de " + tiempo / 1000 + " segundos");
                            control = 1;
                            break;
                        }
                    }
                    IDS = aeropuertos.keySet();
                    double tiempoInicio2 = System.currentTimeMillis();
                    for (Integer integer : IDS) {
                        if (integer == IDbuscar) {
                            double tiempoFin2 = System.currentTimeMillis();
                            Aeropuerto a = aeropuertos.get(integer);
                            System.out.println("Los datos del Aeropuerto son: ");
                            System.out.println("Nombre: " + a.getNombre() + ",Ciudad: " + a.getNombreCiudad() + ",País: " + a.getNombrePais() + ",CodigoIATA/FAA: " + a.getCodigoIATAFAA() + ",CodigoICAO: " + a.getCodigoICAO() + ",Latitud: " + a.getLatitud() + ",Longitud: " + a.getLongitud() + ",Altitud: " + a.getAltitud() + ",Zona Horaria: " + a.getZonaHorario() + ",DTS: " + a.getDTS() + ",Zona: " + a.getZona());
                            double tiempo = tiempoFin2 - tiempoInicio2;
                            System.out.println("El tiempo de búsqueda de datos en el Mapa fue de " + tiempo / 1000 + " segundos");
                            control = 1;
                            break;
                        }
                    }

                    if (control == 0) {
                        System.out.println("El Aeropuerto no existe!");
                    }
                    break;
                case 2:
                    System.out.println("Por favor, ingrese la cadena a buscar: ");
                    cadena = lector2.nextLine();
                    for (Aeropuerto a : aeropuertosLista) {
                        resultadoIndex = a.getNombre().indexOf(cadena);
                        if (resultadoIndex != -1) {
                            aeropuertosCoincidentes.add(a);
                        }
                    }
                    if (aeropuertosCoincidentes.size() > 0) {
                        System.out.println(aeropuertosCoincidentes.size() + " aeropuertos contienen la cadena de caracteres.");
                        System.out.println("A continuación se muestra la lista de ellos:");
                        for (Aeropuerto aer : aeropuertosCoincidentes) {
                            System.out.println(aer.getNombre());
                        }
                    } else {
                        System.out.println("Ningún aeropuerto contiene la cadena!");
                    }
                    break;

                case 3:
                    bandera = false;
                    System.out.println("Gracias por utilizar nuestros servicios.");
                    System.out.println("Realizado por Miguel Murillo y Roberto Mena.");
                    break;

            }
        }

    }
}
