package árbol.binario;

/**
 * Tarea sobre Árboles Binarios
 *
 * @author Miguel Ángel Murillo Arteaga
 */
public class ArbolBinario {

    public Nodo raiz;

    public ArbolBinario(Nodo raiz) {
        this.raiz = raiz;
    }

    //Vaciar árbol (Un árbol vacío es aquel cuya raíz apunta a null)
    public void vaciarArbol() {
        raiz.izquierda = null;
        raiz.derecha = null;
    }

    //Verificar si el árbol está vacío
    public boolean estaVacio() {
        if (raiz.izquierda == null && raiz.derecha == null) {
            return true;
        } else {
            return false;
        }
    }

    //Recorrido en Preorden (Raiz, SubArbolIzquierdo, SubArbolDerecho)
    public void preOrden(Nodo p) {
        if (p.izquierda == null && p.derecha == null) {
            System.out.println(p.contenido);
        } else {
            System.out.println(p.contenido);
            if (p.izquierda != null) {
                preOrden(p.izquierda);
            }
            if (p.derecha != null) {
                preOrden(p.derecha);
            }
        }
    }

    //Recorrido en EntreOrden (SubArbolIzquierdo, Raiz, SubArbolDerecho)
    public void enOrden(Nodo p) {
        if (p.izquierda == null && p.derecha == null) {
            System.out.println(p.contenido);
        } else {
            if (p.izquierda != null) {
                enOrden(p.izquierda);
            }
            System.out.println(p.contenido);
            if (p.derecha != null) {
                enOrden(p.derecha);
            }
        }
    }

    //Recorrido en PostOrden (SubArbolIzquierdo, SubArbolDerecho, Raiz)
    public void postOrden(Nodo p) {
        if (p.izquierda == null && p.derecha == null) {
            System.out.println(p.contenido);
        } else {
            if (p.izquierda != null) {
                postOrden(p.izquierda);
            }
            if (p.derecha != null) {
                postOrden(p.derecha);
            }
            System.out.println(p.contenido);
        }
    }

}
