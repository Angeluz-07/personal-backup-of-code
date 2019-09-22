/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package structures.task5;

/**
 *
 * @author User
 */
import java.util.Comparator;

public class ComparatorCiudadesPorNombre implements Comparator<Ciudad> {
    
        @Override
        public int compare(Ciudad c1,Ciudad c2){
            return c1.getNombre().compareTo(c2.getNombre());
        }
}
