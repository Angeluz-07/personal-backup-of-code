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
public class ComparatorCiudadesPorPoblacion implements Comparator<Ciudad>{
    
    @Override
    public int compare(Ciudad c1,Ciudad c2){
        return c2.getPoblacion()-c1.getPoblacion();
    }
    
    
}
