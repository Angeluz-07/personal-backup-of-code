package sistemaasignacionpacientes;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 *
 * @author Miguel Murillo, Alejandro Mena
 */
public class SistemaAsignacionPacientes {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner lector = new Scanner(System.in);
        Scanner lector2 = new Scanner(System.in);
        int respuesta = 0;
        String resp;
        String r;
        boolean control1;

        System.out.println("SISTEMA DE ASIGNACIÓN DE PACIENTES");

        Sistema sistema = new Sistema();
        System.out.println("Se cargará la lista de habitaciones");
        sistema.cargarListaHabitaciones();
        ArrayList<Habitacion> habitaciones = sistema.getListaHabitaciones();
        System.out.println("Lista de habitaciones cargada!");
        System.out.println("Se cargará la lista de médicos");
        sistema.cargarListaMedicos();
        ArrayList<Medico> medicos = sistema.getListaMedicos();
        System.out.println("Lista de médicos cargada!");
        System.out.println("Se cargará la lista de pacientes");
        sistema.cargarListaPacientes();
        PriorityQueue<Paciente> pacientes = sistema.getListaPacientes();
        System.out.println("Lista de pacientes cargada!");
        System.out.println("Se cargará la lista de dolencias");
        sistema.cargarListaDolencias();
        ArrayList<Dolencia> dolencias = sistema.getListaDolencias();
        System.out.println("Lista de dolencias cargada!");
        System.out.println("El sistema está a punto de asignar las habitaciones:");
        ArrayList<Paciente> listaPacientesInternados = sistema.getListaPacientesInternados();
        while (pacientes.isEmpty() == false) {
            sistema.asignarHabitaciones(pacientes.poll(), habitaciones);
        }
        System.out.println("Habitaciones asignadas y lista de pacientes internados creada!");
        System.out.println("Se cargará la lista de espera");
        PriorityQueue<Paciente> listaEspera = sistema.getListaEspera();
        System.out.println("Lista de espera cargada!");
       
        System.out.println("");

        boolean control = true;
        while (control) {
            System.out.println("MENÚ DE OPCIONES");
            System.out.println("¿Qué desea hacer?");
            System.out.println("1. Buscar habitación en la cual se encuentra ingresado un paciente");
            System.out.println("2. Imprimir nombres y alergias de los pacientes asignados por un médico determinado");
            System.out.println("3. Dar de alta");
            System.out.println("4. Salir");
            System.out.println("");
            while (true) {
                System.out.println("Escoja una opción:");
                try {
                    resp = lector.nextLine();
                    respuesta = Integer.parseInt(resp);
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Ingrese un dato numérico entero");
                }
            }
            while (respuesta < 1 || respuesta > 4) {
                System.out.println("Ingrese un número entre 1, 2, 3 y 4!");
                while (true) {
                System.out.println("Escoja una opción:");
                try {
                    resp = lector.nextLine();
                    respuesta = Integer.parseInt(resp);
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Ingrese un dato numérico entero");
                }
            }
            }
            switch (respuesta) {
                case 1:
                        System.out.println("Ingrese la cédula del paciente: ");
                        r = lector2.nextLine();
                        sistema.buscarHabitacion(r, listaPacientesInternados);
                    break;
                case 2:
                        System.out.println("Ingrese la cédula del médico: ");
                        r = lector2.nextLine();
                    break;
                case 3:
                        System.out.println("Ingrese la cédula del paciente: ");
                        r = lector2.nextLine();
                        control1 = sistema.darDeAltaPaciente(r, listaPacientesInternados, listaEspera, habitaciones);  
                        if(control1==true){
                            System.out.println("Paciente dado de alta con éxito!");
                        }
                        else{
                            System.out.println("El paciente no existe o ya no hay pacientes para remover!");
                        }
                    break;
                case 4:
                    control = false;
                    System.out.println("Gracias por utilizar nuestros servicios");
                    System.out.println("Desarrollado por Alejandro Mena y Miguel Murillo");
                    break;
            }
        }

    }

    }

