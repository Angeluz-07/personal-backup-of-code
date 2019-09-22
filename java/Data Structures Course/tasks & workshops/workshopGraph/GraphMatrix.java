

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author 
 */
public class GraphMatrix<T> {
    
    private int[][] matrix;
    private static int maxVertex = 20;
    private ArrayList<T> vertices;
    private boolean aimed = false;
    
    public void printAdjacencyMatrix(){
        for(int i=0; i<matrix.length;i++){
            for(int j=0; j<matrix.length;j++){
                System.out.print(matrix[i][j]);
                System.out.print(" ");
                }
            System.out.println("");
        }
    }

    public GraphMatrix() {this(maxVertex);}
    
    public GraphMatrix(int maxVertices) {
        maxVertex=maxVertices;
        matrix = new int[maxVertices][maxVertices];
        vertices = new ArrayList();
    }
    
    public GraphMatrix(int maxVertices, boolean dirigido) {
        this(maxVertices);
        this.aimed = dirigido;
    }
    
    public int indexOfVertex(T v) {return vertices.indexOf(v);}
    
    public void addVertex(T v) throws Exception{
        if(vertices.size()==maxVertex){throw new Exception("Esta matriz ya tiene el max de vertices");}
        if(indexOfVertex(v)==-1){vertices.add(v);}
        else{System.out.println("Vertice ya existe");}
    }
    
    public void addEdge(T v1, T v2) throws Exception{
        int va,vb;
        va=indexOfVertex(v1);
        vb=indexOfVertex(v2);
        if(va<0||vb<0) throw new Exception("El vertice no existe");
        matrix[va][vb]=1;
        if(aimed) matrix[va][vb]=1;
    }
    public void addEdgeByIndex(int va,int vb) throws Exception{
        if(va<0||vb<0) throw new Exception("El vertice no existe");
        matrix[va][vb]=1;
        if(!aimed){matrix[va][vb]=1;}
    }
    
    public boolean areAdjacent(T v1, T v2) throws Exception {
        int i1 = indexOfVertex(v1);
        int i2 =indexOfVertex(v2);
        return matrix[i1][i2]==1 || matrix[i2][i1]==1;
    }
    
    public boolean areAdjacentByIndex(int i1, int i2) {return matrix[i1][i2] == 1 || matrix[i2][i1] == 1;}
    
    public void removeVertex(T v) {
        int[][] reshapedMatrix= new int[maxVertex-1][maxVertex-1];
        if (vertices.contains(v)){
            int index = indexOfVertex(v);
            for(int i=0;i<matrix.length-1;i++){
                for(int j=0;j<matrix.length-1;j++){
                    if(i<index&&j<index) reshapedMatrix[i][j]=matrix[i][j];                    
                    else if(i<index&&j>=index) reshapedMatrix[i][j]=matrix[i][j+1];
                    else if(i>=index&&j<index) reshapedMatrix[i][j]=matrix[i+1][j];
                    else if(i>=index&&j>=index) reshapedMatrix[i][j]=matrix[i+1][j+1];                                
                }     
            }
        }
        matrix=reshapedMatrix;
        vertices.remove(v);
    }
    /*i'm concerned about how the graph is modified after remove 
    a vertex, because once removed in the list of objects with vertices
    the index of each object changes.
    */
    public void removeVertexByIndex(int index) {
        int[][] reshapedMatrix= new int[maxVertex-1][maxVertex-1];
        for(int i=0;i<matrix.length-1;i++){
            for(int j=0;j<matrix.length-1;j++){
                if(i<index&&j<index) reshapedMatrix[i][j]=matrix[i][j];                    
                else if(i<index&&j>=index) reshapedMatrix[i][j]=matrix[i][j+1];
                else if(i>=index&&j<index) reshapedMatrix[i][j]=matrix[i+1][j];
                else if(i>=index&&j>=index) reshapedMatrix[i][j]=matrix[i+1][j+1];                                
            }     
        }
        matrix=reshapedMatrix;     
        vertices.remove(index);
    }
    
    public void removeEdge(T v1, T v2) throws Exception {
        int i1=indexOfVertex(v1);
        int i2=indexOfVertex(v2);
        if(areAdjacent(v1, v2)){
            matrix[i1][i2] = 0;
            matrix[i2][i1] = 0;
        }
        else{
            throw new Exception("Los vértices no son adyacentes");
        }
    }

    public void removeEdgeByIndex(int i1, int i2) throws Exception {
        if(areAdjacentByIndex(i1, i2)) {
            matrix[i1][i2] = 0;
            matrix[i2][i2] = 0;
        }else{
            throw new Exception("Los vértices no son adyacentes");
        }
    }
    
}
