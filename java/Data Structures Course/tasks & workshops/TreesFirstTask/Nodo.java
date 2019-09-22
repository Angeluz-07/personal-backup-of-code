package árbol.binario;

/**
 * Tarea sobre Árboles Binarios
 *
 * @author Miguel Ángel Murillo Arteaga
 */
public class Nodo {

    public int contenido;
    public Nodo izquierda;
    public Nodo derecha;

    //Crear nodo
    public Nodo(int contenido) {
        this.contenido = contenido;
        this.izquierda = null;
        this.derecha = null;
    }

    //Agregar hoja a la izquierda
    public void addHojaI(Nodo hojaI) {
        if (izquierda != null) {
            System.out.println("Esta raíz ya tiene una hoja izquierda");
        } else {
            izquierda = hojaI;
        }
    }

    //Agregar hoja a la derecha
    public void addHojaD(Nodo hojaD) {
        if (derecha != null) {
            System.out.println("Esta raíz ya tiene una hoja derecha");
        } else {
            derecha = hojaD;
        }
    }

}
