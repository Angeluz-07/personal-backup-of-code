/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package structures.TreesFirstTask;

/**
 *
 * @author User
 */
public class Node {
    public int data;
    public Node left;
    public Node right;
    
    public Node(int data) {
        this.data= data;
        this.left = null;
        this.right = null;
    }
    
    //Agregar hoja a la derecha
    public void addLeafRight(Node leaf) {
        if (right != null) {
            System.out.println("Esta raíz ya tiene una hoja derecha");
        } else {
            right = leaf;
        }
    }

}
