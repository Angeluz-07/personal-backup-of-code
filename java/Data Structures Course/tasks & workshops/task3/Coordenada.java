/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package structures.task3;

/**
 *
 * @author User
 */
public class Coordenada {
    private double x,y;
    public Coordenada(){
        this.x=-12.0;
        this.y=12.0;
    }
    public Coordenada(double x, double y){
        this.x=x;
        this.y=y;
    }
    
    public double getX(){
        return this.x;
    }
    public double getY(){
        return this.y;
    }
    public void setX(double x){
        this.x=x;
    }
    public void setY(double y){
        this.y=y;
    }
    
    public static double distanceBetweenCoordinates(Coordenada a,Coordenada b){
        double distanceX,distanceY;
        distanceX=b.getX()-a.getX();
        distanceY=b.getY()-a.getY();
        double squareOfDistanceX,squareOfDistanceY;
        squareOfDistanceX=Math.pow(distanceX,2);
        squareOfDistanceY=Math.pow(distanceY,2);
        double distance;
        distance=Math.pow(squareOfDistanceX+squareOfDistanceY,0.5);
        return distance;
        
    }
    
}
