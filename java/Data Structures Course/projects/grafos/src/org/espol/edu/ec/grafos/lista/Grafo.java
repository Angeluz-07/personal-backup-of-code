/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.espol.edu.ec.grafos.lista;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;



/**
 *
 * @author ancalder
 */
public class Grafo<T> implements TDAGrafo<T> {

    private LinkedList<Vertice<T>> vertices;
    private boolean dirigido;

    public Grafo(boolean dirigido) {
        this.dirigido = dirigido;
        this.vertices = new LinkedList<>();
    }

    public LinkedList<Vertice<T>> getVertices() {
        return vertices;
    }

    public boolean isDirigido() {
        return dirigido;
    }

    public void setVertices(LinkedList<Vertice<T>> vertices) {
        this.vertices = vertices;
    }

    public void setDirigido(boolean dirigido) {
        this.dirigido = dirigido;
    }
    
    @Override
    public void agregarVertice(T elem) {
        if (buscarVertice(elem) != null) {
            return;
        }
        
        Vertice<T> v = new Vertice<>(elem);
        this.vertices.add(v);
    }
    
    

    @Override
    public void removerVertice(T elem) {
        Vertice<T> v = buscarVertice(elem);
        
        if (v == null) {
            return;
        }
        
        v.removerTodosArcos();
        
        for (Vertice iter: this.vertices) {
            this.removerArco((T) iter.getContenido(), elem);
        }
        
        this.vertices.remove(v);
    }

    @Override
    public void agregarArco(T elem1, T elem2) {
        
        Vertice<T> v1 = buscarVertice(elem1);
        Vertice<T> v2 = buscarVertice(elem2);
        
        if (v1 == null || v2 == null) {
            return;
        }
        
        v1.agregarArco(v2);
        if (!dirigido) {
            v2.agregarArco(v1);
        }
    }
    public void agregarArco(T elem1, T elem2,int peso) {
        
        Vertice<T> v1 = buscarVertice(elem1);
        Vertice<T> v2 = buscarVertice(elem2);
        
        if (v1 == null || v2 == null) {
            return;
        }
        
        v1.agregarArco(v2,peso);
        if (!dirigido) {
            v2.agregarArco(v1,peso);
        }
    }
    @Override
    public void removerArco(T elem1, T elem2) {
        Vertice<T> v1 = buscarVertice(elem1);
        Vertice<T> v2 = buscarVertice(elem2);
        
        if (v1 == null || v2 == null) {
            return;
        }
        
        v1.removerArco(v2);
        if (!dirigido) {
            v2.removerArco(v1);
        }
    }
    
    @Override
    public Vertice<T> buscarVertice(T elem) {
        for (Vertice<T> v : this.vertices) {
            if (v.getContenido().equals(elem)){
                return v;
            }
        }
        return null;
    }
    
    
    
    @Override
    public void resetearVisitados() {
        for(Vertice<T> v: this.vertices) {
            v.setVisitado(false);
        }
    }

    @Override
    public String toString() {
        String s = "{\n";
        for (Vertice<T> v : this.vertices) {
            s+= "\t" + v.getContenido() + ":" + v.getArcos() + "\n";
        }
        s+="}\n";
        return s;
    }
    
    public LinkedList<Vertice> getPadres(T elem1) {
        LinkedList<Vertice> padres= new LinkedList<> ();
        for (Vertice<T> v1: this.getVertices()) {
            Vertice<T> v2 =  new Vertice<>(elem1);
            Arco<T> arco = v1.buscarArco(v2);
            if(arco != null) {
                padres.add(v1);
                }
            }
        return padres;
    }

    public LinkedList<Vertice> getPadres(T elem1, int peso) {
        LinkedList<Vertice> padres= new LinkedList<> ();
        for (Vertice<T> v1: this.getVertices()) {
            Vertice<T> v2 =  new Vertice<>(elem1);
            Arco<T> arco = v1.buscarArco(v2);
            if(arco != null) {
                if(arco.getPeso()== peso)
                    padres.add(v1);
                }
            }
        return padres;
    }    
    
    public void dijkstra(Vertice vInicial) {
        vInicial.setMinDistance(0);
        PriorityQueue<Vertice> vertexQueue = new PriorityQueue();
        vertexQueue.add(vInicial);
        LinkedList<Arco> arcos;
        while (!vertexQueue.isEmpty()) {
            Vertice u = vertexQueue.poll();            
            // Visit each edge exiting u
            arcos=u.getArcos();
            for (Arco arc:arcos){
                Vertice v =arc.getDestino();
                double weight = arc.getPeso();
                double distanceThroughU = u.getMinDistance() + weight;
                if (distanceThroughU < v.getMinDistance()) {
                    vertexQueue.remove(u);
                    v.setMinDistance(distanceThroughU);
                    v.setAnterior(u);
                    vertexQueue.add(v);
                }   
            }
        }
    }        
    public ArrayList<Vertice> getShortestPathTo(Vertice destino){
        ArrayList<Vertice> path = new ArrayList();
        for (Vertice v=destino; v!=null; v=v.getAnterior())
            path.add(v);
        Collections.reverse(path);
        return path;
    }
}