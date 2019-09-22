
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/*
 * The MIT License
 *
 * Copyright 2017 User.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

/**
 *
 * @author User
 */
public class Aeropuerto {
        private String ID;
        private String Nombre;
        private String Ciudad;
        private String Pais;
        private String CodigoIATA_FAA;
        private String CodigoICAO;
        private String Latitud;
        private String Longitud;
        private String Altitud;
        private String ZonaHorario;
        private String DST;
        private String Zona;
        private ArrayList<Ruta> rutas=new ArrayList();

    /*There are some constructor, it depends
      how much specific i want to be. for now
      I'll work just with the id and the name*/
    public Aeropuerto(String ID, String Nombre) {
        this.ID = ID;
        this.Nombre = Nombre;
    }

    public Aeropuerto(String ID, String Nombre, String Ciudad, String Pais) {
        this.ID = ID;
        this.Nombre = Nombre;
        this.Ciudad = Ciudad;
        this.Pais = Pais;
    }

    public Aeropuerto(String ID, String Nombre, String Ciudad, String Pais, String CodigoIATA_FAA, String CodigoICAO, String Latitud, String Longitud, String Altitud, String ZonaHorario, String DST, String Zona) {
        this.ID = ID;
        this.Nombre = Nombre;
        this.Ciudad = Ciudad;
        this.Pais = Pais;
        this.CodigoIATA_FAA = CodigoIATA_FAA;
        this.CodigoICAO = CodigoICAO;
        this.Latitud = Latitud;
        this.Longitud = Longitud;
        this.Altitud = Altitud;
        this.ZonaHorario = ZonaHorario;
        this.DST = DST;
        this.Zona = Zona;
    }

    public ArrayList<Ruta> getRutas() {
        return rutas;
    }

    public void setRutas(ArrayList<Ruta> rutas) {
        this.rutas = rutas;
    }
        
    
    public static Map<String,Aeropuerto> cargarAeropuertos(String ruta){
        String line;
        String [] array;
        //List<String> listOfLines;
        Aeropuerto aeropuertoTemp;

        Map<String,Aeropuerto> mapOfData=new HashMap();
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
        return mapOfData;
    }

    @Override
    public String toString() {
        //return "Aeropuerto{" + "ID=" + ID + ", Nombre=" + Nombre + '}';
        return Nombre;
    }
   
    
    

}
