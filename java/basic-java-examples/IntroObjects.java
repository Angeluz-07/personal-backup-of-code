
/**
 * In this example we'll understand the basic of 
 * how objects work in java. 
 * I assumed that you've already checked the files:
 *  PrintAndVariables.java
 *  UserInput.java
 *  Arithmetic.java
 *  IfElse.java 
 *  ForDoWhile.java
 *  Functions.java
 */
import java.util.Scanner;
public class IntroObjects {
    public static void main(String[] args) {
        /*        
            On UserInput.java, Do you remember when I said...Let's 
            get some user input. Many ways to do this. We'll use three
            basic functions. Don't worry if you don't understand them 
            now, just use them:
                input.nextInt()
                input.nextDouble()
                input.nextLine()   
            But this looks like the printing functions we've used
            before, eh?:
                System.out.print()
                System.out.println()
                System.out.printf()
                    
            Do you see the pattern?...let me help you:
                System.out  .print()
                System.out  .println()
                System.out  .printf()
                
                input       .nextInt()
                input       .nextDouble()
                input       .nextLine()        
        
            As you see input and System.out are like "entities" 
            that we can use in order to call different functions.
            They are known as OBJECTS. When we call functions 
            trough them "we are making those objects to do something"
            and I don't mean the fact of calling a function but 
            the specific task:            
                print without enter
                print with enter
                print with format
                get integers from user input
                get double from user input
                get text from user input
            Ok,ok they're objects and they "do things" which
            means we call functions trough them but...why all 
            this stuff of "objects"?. Well, it happens
            that simple data types like int, double or boolean 
            can't make things by themselves. They just store
            values and we operate with them and that's ok
            if we're making pretty simple stupid programs. But
            we want more, maybe we want build Facebook or 
            SnapChat, maybe we want to develop Pokemon Go.
            And to make that for sure we need hundreds of variables
            and thousands of validations, loops, functions and so
            on. I would like you to imagine what would be
            the neccesary code to build those big things just
            with variables,if/else's, loops and printing by the 
            console and everything in just one file!.
            Is for all this that we need to model objects
            trough code, make them to store variables and making
            them to execute functions. Create them in separate
            files and call them whenever we need. It would seem
            i'm talking about build robots and make them work for 
            you jajaja, we're too far from that but this is a nice
            beggining.
            To sum up:
                Simple data types like int, double or boolean 
                can't make things by themselves. We need to 
                build structures that holds variables and can 
                execute functions.
            It's a shame the fact that in these examples we're not going
            to build our own objects. But we'll learn how to use
            those pretty basic that we need to handle java as
            a begginer. And one 
            last thing, functions are not functions anymore, from
            now on we'll call them METHODS. Why? well, you must
            already know the answer.
         */            
        
        //An object of type Scanner                  
        Scanner input=new Scanner(System.in); 
        
        /*
            When we create a variable with the data types
            that we've been using so far:
                int, double, char, boolean
            for example:
                int number=10;
            number is not object. The same goes for variables
            of double, char and boolean data type. You
            recognize that we're creating an object with
            some data type if the name of the data type starts
            with uppercase...wait Strings are objects!!!
            But we didn't see any "new #!?@.." stuff when we
            worked with strings. Well, it was just because
            we wanted keep things simple.
        */        
        //two ways to create strings, use the simpler...        
        String s1="String one";//because with strings is possible do it so, is different for every other object!
        String s2=new String("String two");
        
        //but that means a string has methods!!!!        
        System.out.println("String s1: " + s1);
        System.out.println("Character at position 0 of s1 : "+s1.charAt(0));        
        System.out.println("Length of s1 : "+s1.length());                
        System.out.println("UpperCase of s1 : "+s1.toUpperCase());                           
    }    
}
