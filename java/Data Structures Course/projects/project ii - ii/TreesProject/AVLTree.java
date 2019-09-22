/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package structures.TreesProject;

/**
 *
 * @author User
 */
public class AVLTree {
    private AVLNode root;
     
    //AVLNode is a inner class 
    public class AVLNode<Object> { 
      private String key;
      private Object content;
      private AVLNode left,right;
      private int height;
      //constructor for leaves
      public AVLNode (String k, Object obj){
        key=k;
        content = obj;
        left = null;
        right = null;
        height=0;}      
    }
    //this is the constructor of the tree
    public AVLTree(){
    }
    //this is to know the height of the tree
    public int height(){return height(root);}
    //the below method is to update when add nodes
    private static int height(AVLNode n){return n == null ? -1 : n.height;}
    public boolean isEmpty(){ return root == null; }
    //this is to get an object from the tree using the key
    public Object get(String key) {
        AVLNode x = get(root, key);
        if (x == null) return null;
        return x.content;
    }
    private AVLNode get(AVLNode n,String key) {
        if (n == null) return null;
        if (key.compareTo(n.key)<0) return get(n.left, key);
        else if (key.compareTo(n.key)>0) return get(n.right, key);
        else return n;
    }
    public AVLNode getRoot(){return root;}
    
    
    public void removeAllElements(){root=null; }
    
    public static void preOrder(AVLNode ab){
        if (ab==null){return;}
        System.out.println(ab.content);
        preOrder(ab.left);
        preOrder(ab.right);
    }

    public static void inOrder(AVLNode ab){
        if (ab==null){return;}
        inOrder(ab.left);
        System.out.println(ab.content);
        inOrder(ab.right);
    }
    public static void postOrder(AVLNode ab){
        if (ab==null){return;}   
        postOrder(ab.left);
        postOrder(ab.right);
        System.out.println(ab.content);
    }
    
    public void insertNewLeaf(String key, Object content) {
        root = insert(root,key,content);
    }
    //insert recursive method
    private AVLNode insert(AVLNode node,String key, Object content){
        if(node==null){
            return new AVLNode(key,content);
        }
        if(key.compareTo(node.key)>0){
            node.right=insert(node.right,key,content);
        }else if(key.compareTo(node.key)<0){
            node.left=insert(node.left,key,content);
            }else{
              node.content=content;
              return node;
        }
        //once the the node is added, here the height changes
        node.height = Math.max(height(node.left), height(node.right)) + 1;        
        return balance(node);
    } 

    private static int balanceFactor(AVLNode n) {return height(n.right)-height(n.left);}
    /*this method balance the tree if the
      there is balance factor>1 or <-1*/
    private AVLNode balance(AVLNode x) {
        if (balanceFactor(x) > 1) {
            if (balanceFactor(x.right) < 0) {
                x.right = rotateRight(x.right);
            }
            x = rotateLeft(x);
        }
        else if (balanceFactor(x) < -1) {
            if (balanceFactor(x.left) > 0) {
                x.left = rotateLeft(x.left);
            }
            x = rotateRight(x);
        }
        return x;
    }

    /**
     * Rotates the given subtree to the right.
     * 
     * @param n the subtree
     * @return the right rotated subtree
     */
    private AVLNode rotateRight(AVLNode n) {
        AVLNode n1 = n.left;
        n.left = n1.right;
        n1.right = n;
        n.height = 1 + Math.max(height(n.left), height(n.right));
        n1.height = 1 + Math.max(height(n1.left), height(n1.right));
        return n1;
    }

    /**
     * Rotates the given subtree to the left.
     * 
     * @param n the subtree
     * @return the left rotated subtree
     */
    private AVLNode rotateLeft(AVLNode n) {
        AVLNode n1 = n.right;
        n.right = n1.left;
        n1.left = n;
        n.height = 1 + Math.max(height(n.left), height(n.right));
        n1.height = 1 + Math.max(height(n1.left), height(n1.right));
        return n1;
    }
   
}
