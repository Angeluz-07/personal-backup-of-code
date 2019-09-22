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
public class BinaryTree {
    public Node root;
    
    public BinaryTree(Node root){
        this.root=root;
    }
    
    public void vaciarArbol() {
        root.left = null;
        root.right = null;
    }
    
    public boolean estaVacio() {
        if (root.left == null && root.right == null) {
            return true;
        } else {
            return false;
        }
    }
    
    public void preOrden(BinaryTree bTree) {
        if (bTree.estaVacio()) {
            return;
        System.out.println(bTree.root.data);
            if (p.izquierda != null) {
                preOrden(p.izquierda);
            }
            if (p.derecha != null) {
                preOrden(p.derecha);
            }
        }
    }
}
