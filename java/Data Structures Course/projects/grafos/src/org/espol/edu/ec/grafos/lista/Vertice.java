package org.espol.edu.ec.grafos.lista;

import java.util.LinkedList;

/**
 *
 * @author ancalder
 */
public class Vertice<T> implements Comparable<Vertice>{
    private boolean visitado;
    private T contenido;
    private LinkedList<Arco> arcos;
    private double minDistance = Double.POSITIVE_INFINITY;
    private Vertice anterior;

    public Vertice(T contenido) {
        this.contenido = contenido;
        this.arcos = new LinkedList<>();
    }

    public boolean isVisitado() {
        return visitado;
    }

    public void setVisitado(boolean visitado) {
        this.visitado = visitado;
    }

    public T getContenido() {
        return contenido;
    }

    public void setContenido(T contenido) {
        this.contenido = contenido;
    }
    
    public LinkedList<Arco> getArcos() {
        return arcos;
    }

    public void setArcos(LinkedList<Arco> arcos) {
        this.arcos = arcos;
    }
    
    public void agregarArco(Vertice<T> destino) {
        if (buscarArco(destino) != null) {
            return;
        }
        
        this.arcos.add(new Arco(destino));
    }
    
    public void agregarArco(Vertice<T> destino,int peso) {
        if (buscarArco(destino) != null) {
            return;
        }
        
        this.arcos.add(new Arco(destino,peso));
    }
    
    public void removerArco(Vertice<T> destino) {
        Arco<T> arco = buscarArco(destino);
        
        if (arco == null) {
            return;
        }
        
        this.arcos.remove(arco);
    }
    
    public Arco<T> buscarArco(Vertice<T> destino) {
        for (Arco<T> a: this.arcos) {
            if (a.getDestino().equals(destino)) {
                return a;
            }
        }
        return null;
    }

    public void removerTodosArcos() {
        this.arcos.clear();
    }

    @Override
    public String toString() {
        return "Vertice{" + "contenido=" + contenido + '}';
    }
    
    public boolean equals(Vertice<T> v) {
        return this.contenido.equals(v.contenido);
    }


    public double getMinDistance() {
        return minDistance;
    }

    public void setMinDistance(double minDistance) {
        this.minDistance = minDistance;
    }

    public Vertice getAnterior() {
        return anterior;
    }

    public void setAnterior(Vertice anterior) {
        this.anterior = anterior;
    }
    @Override
    public int compareTo(Vertice other)
    {
        return Double.compare(minDistance, other.minDistance);
    }
    
}
