


import structures.TreesProject.Node;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;



/**
 *
 * @author Administrador
 */
public class ProjectTree {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String headLine="GlobalRank,TldRank,Domain,TLD,"+
                        "RefSubNets,RefIPs,IDN_Domain,IDN_TLD,"+
                        "PrevGlobalRank,PrevTldRank,PrevRefSubNets,PrevRefIPs";
        String line;
        String [] array;        
        List<String> listOfLines;
        
        ArrayList<Node> listOfData=new ArrayList();
        Node n;
        AVLTree arbolito=new AVLTree();
   
        try{
        Scanner scan=new Scanner(new File("C:/Users/User/Documents/NetBeansProjects/Estructuras/src/structures/TreesProject/topMillion.csv"));
        while(scan.hasNextLine()){
            /*1,1,google.com,com,404953,2618713,
            google.com,com,1,1,405073,2622474*/
            line=scan.nextLine();
            if(!line.equals(headLine)){
                array=line.split(",");
                listOfLines=Arrays.asList(array);
                n=new Node(array[2],listOfLines);
                //n is a node which contains the domain and a reference to the list
                listOfData.add(n);
                arbolito.insertNewLeaf(array[2],(List)listOfLines);
            }}
        }catch(Exception e){
            ;}
        //at this point I have the AVL tree with the info added
        //at this point I have the list of nodes with references to the domain and their data
        //System.out.println(listOfData.get(0).getList());
        //AVLTree.preOrder(arbolito.getRoot());
       
        String l1,l2;
        double ti,tf,t;
        List info1;
        List info2=new ArrayList();
        Scanner input=new Scanner(System.in);
        System.out.print("Ingrese un dominio para buscar los datos esa pagina web en el sistema: ");
        String dominio=input.nextLine();
        System.out.println("");
        ti=System.currentTimeMillis();
        info1=(List)arbolito.get(dominio);
        //System.out.println(info1);
        tf=System.currentTimeMillis();
        t=(tf-ti);
        l1="GlobalRank: "+info1.get(0)+",TldRank: "+info1.get(1)+
            ",Domain: "+info1.get(2) +",TLD: "+info1.get(3)+
            ",RefSubNets: "+info1.get(4)+",RefIPs: "+info1.get(5) +
            ",IDN_Domain: "+info1.get(6)+",IDN_TLD: "+info1.get(7) +
            ",PrevGlobalRank: "+info1.get(8)+",PrevTldRank: "+info1.get(9)+
            ",PrevRefSubNets: "+info1.get(10)+",PrevRefIPs: "+info1.get(11);
        
        System.out.println("Los datos de este sitio web obtenidos con Arboles AVL son : \n"+l1);
        System.out.printf("Con Arboles AVL se tardo %f segundos en encontrar la informacion. \n\n",t);
        
        ti=System.currentTimeMillis();
        for(Node node:listOfData){
            if(node.getDomain().equals(dominio)){
                info2=node.getList();
                //System.out.println(info2);
                break;
                }     
        }
        tf=System.currentTimeMillis();
        t=(tf-ti)/1000;
        l2="GlobalRank: "+info2.get(0)+",TldRank: "+info2.get(1)+
                ",Domain: "+info2.get(2) +",TLD: "+info2.get(3)+
                ",RefSubNets: "+info2.get(4)+",RefIPs: "+info2.get(5) +
                ",IDN_Domain: "+info2.get(6)+",IDN_TLD: "+info2.get(7) +
                ",PrevGlobalRank: "+info2.get(8)+",PrevTldRank: "+info2.get(9)+
                ",PrevRefSubNets: "+info2.get(10)+",PrevRefIPs: "+info2.get(11);
        
        System.out.println("Los datos de este sitio web obtenidos con una Lista son : \n"+l2);
        System.out.printf("Con una lista se tardo %f segundos en encontrar la informacion.",t);
        
                
    }
    
    
    
    
}
