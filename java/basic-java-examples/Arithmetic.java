
/**
 * In this example we'll get two numbers from user input
 * to perform addition, substraction, division
 * an multiplication and print out the result. I assumed 
 * that you've already checked the files PrintAndVariables.java
 * and UserInput.java, that means that you know the
 * neccesary about how to use variables, print text
 * and get user input in java.
 */

import java.util.Scanner;
public class Arithmetic { 
    public static void main(String[] args) {
        // the safe area...where we code for now
        
        /*
            The syntax to Perfom basic calculations is pretty
            intuitive. So, as we write the code we'll 
            get to it.
        */
        
        //First we get prepared to get user input
        Scanner input=new Scanner(System.in);//don't try to understand this for now, just use it
        
        /*
            We first set our two variables. We choose double data type over int
            because we have to perfom division and we don't want to miss
            decimal point.
        */
        double a,b;//if variables share the data type you can set them up in same line
        
        //we ask the user to get the value
        System.out.print("Type the first value : ");
        a=input.nextDouble();
        System.out.print("Type the second value: ");
        b=input.nextDouble();
        
        //perform calculations
        double sum= a+b;
        double difference=a-b;
        double quotient=a/b;
        double remainder=a%b;
        double product=a*b;
        
        //print the result
        System.out.printf("The sum is %.2f \n",sum);        
        System.out.printf("The difference is %.2f \n",difference);        
        System.out.printf("The quotient is %.2f \n",quotient);                    
        System.out.printf("The remainder is %.2f \n",remainder);   
        System.out.printf("The product is %.2f \n",product);        
    }
    
}
