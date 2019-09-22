/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package structures.task5;
import java.util.Comparator;
/**
 *
 * @author User
 */
public class ComparatorCiudadesPorPuntosDeRAsc implements Comparator<Ciudad>{
    
    @Override
    public int compare(Ciudad c1, Ciudad c2){
        if (c1.puntosR.size()> c2.puntosR.size()) return 1;
        if (c1.puntosR.size()< c2.puntosR.size()) return -1;
        return 0;
        
    }
    
}
