
/**
 * In this example we'll cover how to use
 * if/else in java. I assumed 
 * that you've already checked the files:
 *  PrintAndVariables.java
 *  UserInput.java
 *  Arithmetic.java
 * Which means that you know the
 * neccesary about how to use variables, print text
 * in java, get user input and perform calculations.
 * As before we'll get user input, so please type 
 * what the program expects.
 */
import java.util.Scanner;
public class IfElse {

    public static void main(String[] args) {        
        // still the safe area...where we code for now
        
        /*
            The syntax to control structures, as calculations,
            is also pretty intuitive. So, as we write the code
            we'll get to it.
        */
        
        //let's start with if statement in java
        /*
            As you know, always we want to execute some code
            "if" some condition is true. In java we work
            like this:
                if(**some condition**){
                    //the code we want to execute
                }   
            The code we want to execute means statements,
            and must be enclosed between braces.            
        */
        
        /* 
            Let's use comparison operators in java. We'll
            make a program to check if you pass or not
            this subject(OOP). We'll get by user input
            the neccesary grade to pass and the grade that 
            you think you'll obtain...and let's see what happens.
        */
        
        //we're going to need our input thing
        Scanner input=new Scanner(System.in);        
        
        //we set up neccesary variables
        double myGrade,neccesaryGradeToPass;
        
        //we ask for the values
        System.out.print("Enter your grade : ");
        myGrade=input.nextDouble();
        
        System.out.print("Enter the grade you need to pass: ");
        neccesaryGradeToPass=input.nextDouble();
        
        //Now the comparison operators in action!
        //equal
        if(myGrade == neccesaryGradeToPass){
            System.out.println("You just did it!!");
        }
        //not equal
        if(myGrade != neccesaryGradeToPass){
            System.out.println("Maybe you pass...");
        }
        //greater than
        if(myGrade > neccesaryGradeToPass){
            System.out.println("It seems that you did well in mejoramiento.");
        }
        //lower than
        if(myGrade < neccesaryGradeToPass){
            System.out.println("You just failed dude. Buuuuuuu.");
        }
        
        //Of course we have...
        //greater or equal than 
        if(myGrade >= neccesaryGradeToPass){
            System.out.println("Either you went to mejoramiento or you didn't have to.");
        }
        //lower or equal than
        if(myGrade <= neccesaryGradeToPass){
            System.out.println("Either you went to mejoramiento or you failed :/");
        }
        
        /*
            Ok ok simple if is pretty easy. What about the if/else.
            To if/else. The word "else" must be exactly after
            the last brace of the if block. For example:
                if(**some condition*){
                    //some code
                } else <--exactly here
            and after the word "else" must be a pair of braces
            that enclose the code you want to execute "else".
            The final format is:
                if(**some condition*){
                    //some code
                }else{
                    //another code
                }
            and that's it.
        */
                   
        /*
            As you know on if or if/else statement;
            Is checked if **some condition** is either
            true or false. At the end the program
            just works with everything that can throw
            a boolean a value. As a comparison, or a function
            that return boolean values or the most simple: a
            boolean variable.
        */        
        
        System.out.println("\nNow let's see if you're understanding.");
        //We use a boolean variable.
        boolean iUnderstand=true;             
        if(iUnderstand){
            System.out.println("You understand because you read the previous examples and this is nothing.");
        }else{
            System.out.println("You're not reading the examples properly");
        }
        System.out.println("What about if You don't understand, even tough you read the previous examples?");
        
        /*
            Well, that's a great chance to use a nested if/else
            and to make that, we just place a new if block
            exactly after the word else. For example:
                if(**some condition*){
                    //some code
                } else if(**another condition**)<--exactly here
             
            The final format is:
                if(**some condition*){
                    //some code
                }else if(**another condition**){
                    //another code
                }
            and that's it. If you need you could also use:
                if(**some condition**){
                    //some code
                }else if(**another condition**){
                    //another code
                }else{
                    //some another code
                }   
            and so on, use nested if/else as many as you need.            
         */
        
        //We change the value of our previous variable and set a new one
        iUnderstand=false;
        boolean iReadPreviousExamples=true;
        if(iUnderstand){
            System.out.println("Everything's good.");
        }else if(iReadPreviousExamples){          
            System.out.println("Let me know in comments what you don't understand.");        
        }else{
            System.out.println("It seems you're not studying :/");
        }        
        /*
            We're almost over. At this point for sure
            you know boolean algebra. In java we have:
                && -> and boolean operator
                || -> or boolean operator
                !  -> negation boolean operator
            And we can use them with comparison
            operator to get more complex boolean
            expression to be tested on our if blocks
        */
        
        //We always group our expressions with parenthesis to avoid ambiguity.               
        if((myGrade>=neccesaryGradeToPass) || (iReadPreviousExamples && iUnderstand)){
            System.out.println(">>I know java!!");
        }else{
            System.out.println(">>I have to study more :@");
        }
         
        
        //now run this program if you haven't
        System.out.println("\nIt was a pleasure to help you. Mr. Stark..."); 
    }
    
}
