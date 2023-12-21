
/**
 * In this example we'll understand the basic of 
 * static arrays in java, create them and iterate
 * over them. 
 * I assumed that you've already checked the files:
 *  PrintAndVariables.java
 *  UserInput.java
 *  Arithmetic.java
 *  IfElse.java 
 *  ForDoWhile.java
 *  Functions.java
 *  IntroObjects.java
 */
public class Arrays {   
    public static void main(String[] args) {
        /*
            Arrays in java are also objects. We
            are going to create static arrays which
            means it has a DEFINED LENGTH during
            the lifetime of the program. For example
            if the array is set to hold 6 values
            we can change each value as much as we  
            want but we can't add a 7th value or more.
            To make such a thing we would need dynamic arrays
            what is not covered in these examples.
        
            Static arrays has a data type depending on the 
            values that holds and all their elements
            share the data type. Define the data type of
            an array is pretty much similar as variables, just
            add [] wich means is an array:
                int[] array1 = new int[10];
                double[] array2 = new double[15];
                boolean[] array3 = new boolean[5];
                String[] array4 = new String[3];
            after that you equals to keyword new
            followed by the data type and finally, between brackets
            the number of elements you want to hold on that array.
        */
       int[] arrayInt=new int[10];//i'll hold 10 integers AND EXACTLY 10
       double[] arrayDouble=new double[15];//i'll hold 15 numbers with decimal point AND EXACTLY 15
       boolean[] arrayBoolean=new boolean[5];//i'll hold 5 boolean values AND EXACTLY 5
       
       //static arrays can hold objects too
       //i'll hold 3 words or sentences AND EXACTLY 3
       String[] arrayString=new String[3];//NOTIC, THIS IS DIFFERENT FROM new String("string")!!!
       
       /*
            Something you must know is that when we
            defined arrays in this way, each item of the
            array has a default value, which is:
                0 for int and double arrays
                false for boolean arrays
                null for arrays of whichever Object
            null is just a value that means THERE'S NO
            OBJECT on that place.
       */       
        System.out.println("Let's see the default values of our arrays");
        System.out.println("Array of 10 integers: ");
        //let's iterate over them to check                
        //this is the way we iterate over an array
        for(int i=0;i<arrayInt.length;i++){
            /*
                As you reminded arrays are objects. Each one has a
                variable that contains the length of that array.
            */
            //we use the variable i to get each value on the array
            System.out.print(arrayInt[i] + " ");
        }
        System.out.println("\nArray of 15 numbers with decimal point: ");      
        for(int i=0;i<arrayDouble.length;i++){     
            System.out.print(arrayDouble[i] + " ");
        }
        System.out.println("\nArray of 5 boolean values: ");      
        for(int i=0;i<arrayBoolean.length;i++){     
            System.out.print(arrayBoolean[i] + " ");
        }
        System.out.println("\nArray of 3 String: ");      
        for(int i=0;i<arrayString.length;i++){     
            System.out.print(arrayString[i] + " ");
        }
        
        
        System.out.println("\n\nNow let's change those values:");
        System.out.println("Array of 10 integers: ");       
        for(int i=0;i<arrayInt.length;i++){
            /*
                we access to the place in the array by 
                index and we work with it as any other 
                variable(we can change the value)
            */            
            arrayInt[i]=i*10;
            System.out.print(arrayInt[i] + " ");
        }
        System.out.println("\nArray of 15 numbers with decimal point: ");      
        for(int i=0;i<arrayDouble.length;i++){     
            arrayDouble[i]=(i*2)+5;
            System.out.print(arrayDouble[i] + " ");
        }
        System.out.println("\nArray of 5 boolean values: ");      
        for(int i=0;i<arrayBoolean.length;i++){                 
            if(i==0){
                arrayBoolean[i]=true;
            }else{
                //we assign the negation of the previous boolean value
                arrayBoolean[i]= !arrayBoolean[i-1];
            }            
            System.out.print(arrayBoolean[i] + " ");
        }
        System.out.println("\nArray of 3 String: ");      
        for(int i=0;i<arrayString.length;i++){                
            arrayString[i]="Java!";               
            System.out.print(arrayString[i] + " ");
        }
        System.out.println("");
        
        //but there's another way to create them!!
        int[] ages={1,2,3,4,4,3};
        double[] grades={5.99 , 5.8 , 6.0 , 8.9, 6.58 , 7.1234};
        boolean[] binary={true,false,false,false,true};
        String[] message={"I","am","about","to","sleep"};        
       /*
            As was stated before, once you defined the number
            of items that the array will hold, you can't add more
            items than that. Is the same here. Let's see
            the length of these last arrays:
                ages->6 elements
                grades->6 elements
                binary->5 elements
                message->5 elements
            You can change values but you can't 
            add more than that on each array.
       */
       
       //As any variable or object you can use them with functions.       
       System.out.println("Finally a function that takes an array as a parameter:");
       binaryNumber(binary);
    }    
    /**
     * Shows the binary number given
     * an array of boolean values
     * @param values a static array
     * of boolean values
     */
    public static void binaryNumber(boolean[] values){
        /*
            When you are going to construct a string
            summing it up in a iterative manner. You
            must initialize it first with an empty string.            
        */
        String binaryNumber="";
        for(int i=0;i<values.length;i++){
            //if the value is true, writes a one
            if(values[i]){
                binaryNumber+="1";
                //binaryNumber+="1" is translated as binaryNumber = binaryNumber + "1"
            }else{
                binaryNumber+="0";
            }
        }
        System.out.println("The binary number is : "+ binaryNumber);
    }
}
