/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project_FirstPartial;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.PriorityQueue;
import java.util.Scanner;
/**
 *
 * @author User
 */
public class AssignationOfPatients {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PriorityQueue<Paciente> pacientes;
        pacientes=Paciente.ingresarPacientes("C:/Users/User/Documents/NetBeansProjects/Estructuras/src/Project_FirstPartial/pacientes.txt");
        //for(Paciente paciente:pacientes){System.out.println(paciente);}
        ArrayList<Medico> medicos=Medico.ingresarMedicos("C:/Users/User/Documents/NetBeansProjects/Estructuras/src/Project_FirstPartial/medicos.txt");
        //for(Medico medico:medicos){System.out.println(medico);}
        ArrayList<Habitacion> habitaciones=Habitacion.ingresarHabitaciones("C:/Users/User/Documents/NetBeansProjects/Estructuras/src/Project_FirstPartial/habitaciones.txt", medicos);
        //for(Habitacion h:habitaciones){System.out.println(h);}
       
        ArrayList<Paciente> listaDeIngresados=new ArrayList();
        PriorityQueue<Paciente> listaDeEspera=new PriorityQueue();
        
        Paciente pTemp;
        for (Habitacion h:habitaciones){
            while(h.getNoDeCamas()>0){
                pTemp=pacientes.remove();
                h.getPacientesIngresados().add(pTemp);
                listaDeIngresados.add(pTemp);
                h.setNoDeCamas(h.getNoDeCamas()-1);
                h.getMedicoEncargado().getPacientes().add(pTemp);//esta linea agrega el paciente a la lista del medico encargado de la habitacion
        }}
        //The elements that remain in the queue go to listaDeEspera
        listaDeEspera.addAll(pacientes);
        
        /**
        Esto es solo para ver como quedaron los pacientes con respecto a sus habitaciones asignadas
        for(Habitacion h:habitaciones){System.out.println(h+" "+ h.getPacientesIngresados());}
        System.out.println("List of patients with rooms");
        for(Paciente p:listaDeIngresados){System.out.println(p.getNombre());}
        System.out.println("List of patients waiting a room");
        for(Paciente p:listaDeEspera){System.out.println(p.getNombre());}
        */
        
        Scanner input= new Scanner(System.in);
        boolean estaEnElPrograma=true;
        int option;
        int noDeCedulaIngresado;
        Paciente pacienteAIngresar=new Paciente();
        System.out.println("Bienvenido al programa de asignacion de pacientes del hospital");
        while(estaEnElPrograma){
            System.out.println("--Menu--");
            System.out.println("1. Buscar Habitacion");
            System.out.println("2. Ver Datos de Pacientes");
            System.out.println("3. Dar De Alta A Un Paciente");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opcion por favor:");
            option=input.nextInt();
            switch(option){
                case 1:
                    System.out.println("Ingrese la cedula del paciente: ");
                    //aqui hay que validar
                    noDeCedulaIngresado=input.nextInt();
                    System.out.print("El paciente esta ingresado en la ");
                    ListIterator<Habitacion> iter2=habitaciones.listIterator();
                    while(iter2.hasNext()){
                        Habitacion hTemp=iter2.next();
                        for(Paciente p:hTemp.getPacientesIngresados()){
                            if(p.getNoDeCedula()==noDeCedulaIngresado){
                                System.out.println(hTemp);//the string method prints the number of the room
                            }}}
                    break;
                case 2:
                    System.out.println("Ingrese la cedula del Medico para ver los pacientes y sus alergias: ");
                    //aqui hay que validar
                    noDeCedulaIngresado=input.nextInt();
                    ListIterator<Habitacion> iter3=habitaciones.listIterator();
                    while(iter3.hasNext()){
                        Habitacion hTemp=iter3.next();
                        if(hTemp.getMedicoEncargado().getNoDeCedula()==noDeCedulaIngresado){
                            for(Paciente p:hTemp.getPacientesIngresados()){
                                System.out.println("Nombre: "+p.getNombre()+", Alergias: "+p.getAlergias());
                            }}}
                    break;
                case 3:
                    System.out.println("Ingrese la cedula del paciente para darle de alta: ");
                    //aqui hay que validar and show a message if that patient isn't in the room
                    noDeCedulaIngresado=input.nextInt();
                    ListIterator<Habitacion> iter1=habitaciones.listIterator();
                    boolean pacienteEsta=false;
                    while(iter1.hasNext()){
                        Habitacion hTemp=iter1.next();
                        ListIterator<Paciente> subIter1=hTemp.getPacientesIngresados().listIterator();
                        while(subIter1.hasNext()) {
                            pTemp=subIter1.next();
                            if(pTemp.getNoDeCedula()==noDeCedulaIngresado){
                                int i1,i2;
                                i1=listaDeIngresados.indexOf(pTemp);
                                i2=hTemp.getPacientesIngresados().indexOf(pTemp);
                                //.remove() will throw an exception if listaDeEspera is empty()
                                pacienteAIngresar=listaDeEspera.remove();
                                listaDeIngresados.set(i1,pacienteAIngresar);
                                hTemp.getPacientesIngresados().set(i2,pacienteAIngresar);
                                pacienteEsta=true;
                            }}
                        if(hTemp.equals(habitaciones.get(habitaciones.size()-1))&&!pacienteEsta){
                            System.out.println("El paciente no esta ingresado");}
                        
                        }
                        /**
                        Esto es solo para ver como quedaron los pacientes con respecto a sus habitaciones asignadas
                        for(Habitacion h:habitaciones){System.out.println(h+" "+ h.getPacientesIngresados());}
                        System.out.println("List of patients with rooms");
                        for(Paciente p:listaDeIngresados){System.out.println(p.getNombre());}
                        System.out.println("List of patients waiting a room");
                        for(Paciente p:listaDeEspera){System.out.println(p.getNombre());}
                        */
                    break;
                    
                case 4:
                    estaEnElPrograma=false;
                    break;
                 }
        }
        System.out.print("Fue un Placer Atenderlo :)");
        
 }
}

   

