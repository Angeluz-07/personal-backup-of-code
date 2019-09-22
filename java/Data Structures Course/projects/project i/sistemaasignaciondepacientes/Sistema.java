package sistemaasignacionpacientes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 *
 * @author Miguel Murillo, Alejandro Mena
 */
public class Sistema {

    private ArrayList<Habitacion> listaHabitaciones;
    private ArrayList<Medico> listaMedicos;
    private PriorityQueue<Paciente> listaPacientes = new PriorityQueue();
    private ArrayList<Dolencia> listaDolencias;
    private ArrayList<Paciente> listaPacientesInternados = new ArrayList();
    private PriorityQueue<Paciente> listaEspera = new PriorityQueue();

    public Sistema() {

    }

    public void cargarListaHabitaciones() throws FileNotFoundException {
        int numero = 0;
        int num_camas = 0;
        String ced_medico;
        String[] datos_hab;
        listaHabitaciones = new ArrayList();
        File hab = new File("Habitaciones.txt");
        Scanner lector = new Scanner(hab);
        while (lector.hasNextLine()) {
            datos_hab = lector.nextLine().split(",");
            numero = Integer.parseInt(datos_hab[0]);
            num_camas = Integer.parseInt(datos_hab[1]);
            ced_medico = datos_hab[2];
            listaHabitaciones.add(new Habitacion(numero, num_camas, ced_medico));
        }
        lector.close();
    }

    public void cargarListaMedicos() throws FileNotFoundException {
        String cedula;
        String nombre;
        int telefono = 0;
        String especialidad;
        String[] datos_medico;
        listaMedicos = new ArrayList();
        File med = new File("Medicos.txt");
        Scanner lector = new Scanner(med);
        while (lector.hasNextLine()) {
            datos_medico = lector.nextLine().split(",");
            cedula = datos_medico[0];
            nombre = datos_medico[1];
            telefono = Integer.parseInt(datos_medico[2]);
            especialidad = datos_medico[3];
            listaMedicos.add(new Medico(cedula, nombre, telefono, especialidad));
        }
        lector.close();
    }

    public void cargarListaPacientes() throws FileNotFoundException {
        String ced;
        String nombre;
        String sexo;
        String grupo_sanguineo;
        String estado_emergencia;
        String alergias;
        String dolencias;
        String[] datos_pac;
        File pac = new File("Pacientes.txt");
        Scanner lector = new Scanner(pac);
        while (lector.hasNextLine()) {
            datos_pac = lector.nextLine().split(",");
            ced = datos_pac[0];
            nombre = datos_pac[1];
            sexo = datos_pac[2];
            grupo_sanguineo = datos_pac[3];
            estado_emergencia = datos_pac[4];
            alergias = datos_pac[5];
            dolencias = datos_pac[6];
            listaPacientes.add(new Paciente(ced, nombre, sexo, grupo_sanguineo, alergias, dolencias,Paciente.estadoEmergenciaStringToInt(estado_emergencia)));
        }
        lector.close();
    }

    public void cargarListaDolencias() throws FileNotFoundException {
        String nombre;
        String sintomas;
        String[] datos_dolencia;
        listaDolencias = new ArrayList();
        File d = new File("Dolencias.txt");
        Scanner lector = new Scanner(d);
        while (lector.hasNextLine()) {
            datos_dolencia = lector.nextLine().split(",");
            nombre = datos_dolencia[0];
            sintomas = datos_dolencia[1];
            listaDolencias.add(new Dolencia(nombre, sintomas));
        }
        lector.close();
    }

    public void asignarHabitaciones(Paciente p, ArrayList<Habitacion> l) {
        int control = 0;
        for (Habitacion habitacion : l) {
            if (habitacion.getNum_camas() > 0) {
                p.setHabitacion_asignada(habitacion.getNumero());
                p.setCedula_medico_encargado(habitacion.getCedula_medico_encargado());
                habitacion.setNum_camas(habitacion.getNum_camas() - 1);
                control = 1;
                listaPacientesInternados.add(p);
                break;
            }
        }
        if(control == 0){
        listaEspera.add(p);
        }
    }

    
    public void buscarHabitacion(String cedula, ArrayList<Paciente> pac) {
        int control = 0;
        for (Paciente paciente : pac) {
            if (paciente.getCedula().equals(cedula)) {
                System.out.println("La habitación asignada al paciente es: " + paciente.getHabitacion_asignada());
                control = 1;
                break;
            }
        }
        if (control == 0) {
            System.out.println("El paciente no existe o no ha sido ingresado!");
        }
    }

    public void imprimirPacientes(String cedula,ArrayList<Paciente> p) {
        for (Paciente paciente : p) {
            if(paciente.getCedula_medico_encargado()==null){
                System.out.println("Este paciente no tiene un médico encargado!");
            }
            else{
            if (paciente.getCedula_medico_encargado().equals(cedula)) {
                System.out.println("Nombre del paciente: " + paciente.getNombre());
                String[] alergias = paciente.getAlergias().split("-");
                System.out.println("Alergias del paciente:");
                for (String alergia : alergias) {
                    System.out.println(alergia);
                }
            }
        }
        }
    }
    
    public boolean darDeAltaPaciente(String cedula, ArrayList<Paciente> p, PriorityQueue<Paciente> espera, ArrayList<Habitacion> h) {
        int control = 0;
        int temp = 0;
        //Dar de alta un paciente
        if(p.isEmpty()==false){
        for (Paciente paciente : p) {
            if (paciente.getCedula().equals(cedula)) {
                temp = paciente.getHabitacion_asignada();
                paciente.setCedula_medico_encargado("");
                paciente.setHabitacion_asignada(0);
                p.remove(paciente);
                control = 1;
                break;
            }
        }
        }
        //Liberar una cama de esa habitación
        for (Habitacion habitacion : h) {
            if (habitacion.getNumero() == temp) {
                habitacion.setNum_camas(habitacion.getNum_camas() + 1);
                break;
            }
        }
        //Asignar paciente de la lista de espera a una habitación libre
        if(espera.isEmpty()==false){
        Paciente pac;
         for (Habitacion habitacion : h) {
                if (habitacion.getNum_camas() > 0) {
                    pac = espera.poll();
                    pac.setHabitacion_asignada(habitacion.getNumero());
                    pac.setCedula_medico_encargado(habitacion.getCedula_medico_encargado());
                    p.add(pac);
                    habitacion.setNum_camas(habitacion.getNum_camas() - 1);
                    break;
            }
            }
        }
        if(control == 0){
            return false;
        }
        else{
            return true;
        }
    }


    public ArrayList<Habitacion> getListaHabitaciones() {
        return listaHabitaciones;
    }

    public ArrayList<Medico> getListaMedicos() {
        return listaMedicos;
    }

    public PriorityQueue<Paciente> getListaPacientes() {
        return listaPacientes;
    }

    public ArrayList<Dolencia> getListaDolencias() {
        return listaDolencias;
    }

    public PriorityQueue<Paciente> getListaEspera() {
        return listaEspera;
    }

    public ArrayList<Paciente> getListaPacientesInternados() {
        return listaPacientesInternados;
    }

    
}
