
/**
 * In this example we'll cover how to use
 * loops: for ,while and do/while loop in java. 
 * I assumed that you've already checked the files:
 *  PrintAndVariables.java
 *  UserInput.java
 *  Arithmetic.java
 *  IfElse.java 
 */
public class ForDoWhile {
    
    public static void main(String[] args) {
        //still the safe area. The place where we code for now.        
        /*
            As you have noticed Java works with
            blocks of code that are enclosed with braces
            as "the safe area" that we've been mentioning
            and the if/else statements. Is not different    
            with for, while and do-while loops.
        */
        
        /*
            First, the control of a for loop has three components
            each separated by a semicolon:
                for( comp1 ; comp2 ; comp3){
                    //some code
                }
            comp1-> contains the creation of a control variable                 
                to the loop. The control variable is the variable
                that's going to change its value on each iteration.
            comp2-> a condition that is tested after each
                iteration. If is true the iteration continues,
                otherwise the loop finishes right there.
            comp3-> contains how increment the control variable                 
            
            Always remember that the control variable has a different
            value on each iteration.
        */                
        System.out.println("Now numbers from 0 to 10 with for loop: ");
        for(int i=0;i<=10;i++){
            //the piece of code i++ is translated as i=i+1
            System.out.print(i+" ");
        }
        System.out.println();
        
                 
        /*
            The while loop just test a boolean condition
            in the same way as the if statement:
                "while that condition is true, keeps executing the code"            
        */
        System.out.println("Now numbers from 0 to 10 with while loop: ");
        int k=0;
        while(k<=10){
            System.out.print(k+" ");
            k++;//the piece of code k++ is translated as k=k+1
        }
        System.out.println();
        
        /*
            Finally let's meet the do-while loop.
            If we have a simple while loop, the while first
            check if the condition if true. If from the first
            time the condition is false, it doesn't
            even get inside of the while body. Sometimes
            we want that the program executes the body of the 
            while for at least one time, the first one.
            That's one of the main reasons to use do-while loop.
            The format is:
                do{
                    //some code
                }while(**condition**);
        */
        System.out.println("The code in do-while is executed at least once: ");        
        //we reuse our k variable
        k=11;
        do{
            System.out.print(k+" ");
            k++;
        }while(k<=10);                
        System.out.println();        
        
        //now run this program if you haven't
        System.out.println("\nIt was a pleasure to help you. Mr. Stark...");  
    }    
}