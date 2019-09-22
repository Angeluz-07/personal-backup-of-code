package árbol.binario;

import java.util.Scanner;

/**
 * Tarea sobre Árboles Binarios
 *
 * @author Miguel Ángel Murillo Arteaga
 */
public class TareaArboles {

    public static void main(String[] args) {

        Scanner lector = new Scanner(System.in);
        String resp;
        int respNum = 0;
        //Árbol de prueba
        System.out.println("Creación del árbol de prueba en progreso...");
        Nodo raiz = new Nodo(1);
        ArbolBinario a = new ArbolBinario(raiz);
        Nodo n1 = new Nodo(2);
        Nodo n2 = new Nodo(6);
        a.raiz.izquierda = n1;
        a.raiz.derecha = n2;
        Nodo n3 = new Nodo(3);
        Nodo n4 = new Nodo(4);
        n1.izquierda = n3;
        n1.derecha = n4;
        Nodo n5 = new Nodo(5);
        n3.izquierda = n5;
        Nodo n6 = new Nodo(7);
        n2.izquierda = n6;
        Nodo n7 = new Nodo(8);
        n2.derecha = n7;
        Nodo n8 = new Nodo(9);
        n7.derecha = n8;
        System.out.println("¡Árbol de prueba creado con éxito!");
        System.out.println("");
        
        boolean control = true;
        boolean control2 = true;
        while(control){
        System.out.println("----------MENU-----------");
        System.out.println("Elija una opción válida: ");
        System.out.println("1. Vaciar Árbol");
        System.out.println("2. Verificar si el árbol está vacío");
        System.out.println("3. Recorrer el árbol en PreOrden");
        System.out.println("4. Recorrer el árbol en EntreOrden");
        System.out.println("5. Recorrer el árbol en PostOrden");
        System.out.println("6. Salir");

        System.out.println("");
        control2 = true;
        while(control2){
        try{
        System.out.println("Ingrese su respuesta: ");
        resp = lector.nextLine();
        respNum = Integer.parseInt(resp);
        while (respNum < 1 || respNum > 6) {
            System.out.println("Ingrese una respuesta válida: ");
            resp = lector.nextLine();
            respNum = Integer.parseInt(resp);
        }
        control2 = false;
        }
        catch(Exception e){
            System.out.println("Ingrese una respuesta numérica.");
        }
        }
        switch (respNum) {
            case 1:
                if (a.estaVacio() == false) {
                    a.vaciarArbol();
                    System.out.println("¡Árbol vaciado con éxito!");
                } else {
                    System.out.println("El árbol ya está vacío.");
                }
                break;
            case 2:
                if (a.estaVacio() == true) {
                    System.out.println("El árbol está vacío.");
                } else {
                    System.out.println("El árbol no está vacío.");
                }
                break;
            case 3:
                if (a.estaVacio() == true) {
                    System.out.println("El árbol está vacío.");
                } else {
                    System.out.println("Recorrido del Árbol Binario en PreOrden: ");
                    a.preOrden(raiz);
                }
                break;
            case 4:
                if (a.estaVacio() == true) {
                    System.out.println("El árbol está vacío.");
                } else {
                    System.out.println("Recorrido del Árbol Binario en EntreOrden: ");
                    a.enOrden(raiz);
                }
                break;
            case 5:
                if (a.estaVacio() == true) {
                    System.out.println("El árbol está vacío.");
                } else {
                    System.out.println("Recorrido del Árbol Binario en PostOrden: ");
                    a.postOrden(raiz);
                }
                break;
            case 6:
                System.out.println("Programa finalizado.");
                control = false;
                break;
        }

    }
    }
}
