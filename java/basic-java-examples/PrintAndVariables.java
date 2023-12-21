
/**
 * This is our first Java program, In this example
 * we'll go directly to use variables and printing 
 * functions.
 */
public class PrintAndVariables {
    
    public static void main(String[] args) {
        /*
            Don't worry about the lines above. We'll cover them
            after. For now this is the safe area. This is where
            we code now.            
        */
                
        /*
          Java instructions are given by statements, which is
          an instruction using the sintax of the language and ENDS
          WITH SEMICOLON. for example:        
            System.out.print("Hi dude");                
        */
        
        /*
          First, let's print something out. Many ways to do this.
          We'll use three basic functions. Don't worry if you don't 
          understand them now, just use them:
            System.out.print()
            System.out.println()
            System.out.printf()          
        */
        
        /*
          With all this functions, text must always be 
          between DOUBLE QUOTATION MARKS, otherwise is an error. The first 
          one prints something and remains in the line
        */
        System.out.print("Use System.out.print() and the next printing will appear->");            
        System.out.print(" right here!");
        
        /*
          As the last statement remains in the same line we'll use
          the next function with no message to print a new line.
          To make a kind of "Enter"...
        */        
        System.out.println();
        
        /*
          Of course we can write something with this one, but it 
          appears a new line at the end          
        */        
        System.out.println("Use System.out.println() and the next printing will appear->");
        System.out.println("below...");
        
        /*
          Before use the third "printing java function". We must
          cover the basic of variables in java. For variables
          is neccesary to choose a data type to our variable
          DEPENDING ON the data type that we're going to store on our
          variable. The most common data types in Java are:
            int -> to store integers (really?)
            double -> to store numbers with decimal points
            boolean -> to store boolean values 
            char -> to store simple characters (just one letter)
            String -> to store words or sentences                     
        */
        
        /*
          We always write first the data type(int, double, String,...)
          after the name of the variable and finally equals to a value.        
          Don't forget to check out the list of not valid names for variables.
        */    
        
        int age=21;
        double money=0.50;//use point for decimal points, no comma
        boolean lier=true;//use either true or false
        char grade='C';//always use single quotes for characters        
        String name="the Java learner";//always use double quotes for strings
        
        /*
            With variables you can set the variable with no value        
            and assign it a value latter. This happens when you are
            going to store something, but don't know what's the value
            yet.        
        */
        
        String msg;              
        msg="ok";
        
        int a; 
        a=123;                       
        
        /*
            Of course, you can use the same variable and change
            its value as much as you can. 
            REMEMBER: NOT NECCESARY PUT THE DATA TYPE AGAIN THAT
            IS ONLY FOR THE FIRST TIME, JUST GIVE A NEW VALUE 
            TO THE VARIABLE.
        */      
        msg="no, I'm not ok";        
        a=345;        
        msg="sorry. Now, everything is ok";
        a=678;
        /*
            REMEMBER: TO USE A VARIABLE YOU FIRST MUST 
            DECLARE IT, EITHER WITH INITIAL VALUE OR 
            WITHOUT IT.
        */       
        
        /*
            We can print text with variables, summing 
            everything up...LITERALLY
        */       
        System.out.println();
        System.out.println("Now, introduce yourself: ");
        System.out.println("I am " + name + " and probably I am " + age);
        System.out.println("I finished the semester with a " + grade + " and just " + money + "$ in my pocket");
        System.out.println("Java, Is true that i am a lier? : " + lier);
        
        /*          
          As you see, it's kind of hard printing text with variables. 
          So, we have our third "printing java function".
          We use this one to get a formatted printing.
        */
        
        /*
            With this function we place identifiers of the 
            variables in the text, and at the end, we list the
            variables separated by commas. We use it like this:
                System.out.printf("Hi %s the number is %d" , var1, var2);
            and is translated as:
                System.out.print("Hi " + var1 + " the number is " + var2);
            So, the value of the variable will appear in the place where
            the identifier is, of course the variables at the end must be
            in order.
        
            The identifiers are :
                %s for a string variable
                %d for a integer variable
                %b for a boolean variable
                %f for a double variable
            The use of %f is a little bit more deep. But for now
            just know that you can use:        
                %.nf
            where n means the numbers of decimal points we want
            to show on printing. 
            As you noticed this function REMAINS IN THE LINE
            after printing. Now we can write '\n' in the text 
            which is a better way to get an "Enter".            
        */
        System.out.println();
        System.out.println("Excuse me, can you repeat please?");
        
        //Our new print function
        System.out.printf("I am %s and probably I am %d\n",name,age);
        System.out.printf("I finished the semester with a %c and just %.2f in my pocket\n",grade,money);
        System.out.printf("Java, am I a Lier? : %b\n",lier);

        
        //now run this program if you haven't
        System.out.println("\nIt was a pleasure to help you. Mr. Stark...");        
    }    
}
