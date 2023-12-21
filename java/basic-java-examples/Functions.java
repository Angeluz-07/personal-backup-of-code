
/**
 * In this example we'll cover how create 
 * simple functions in java. 
 * I assumed that you've already checked the files:
 *  PrintAndVariables.java
 *  UserInput.java
 *  Arithmetic.java
 *  IfElse.java 
 *  ForDoWhile.java
 */
public class Functions {
    /*
        The next code block. That we've named
        as "the safe area" because if we were coding
        here nothing bad could happen, 
        is itself a function. Functions have the
        same format as this but of course there are things
        you need to understand first. Relax, for now 
        we just care about things we need.    
    */
    public static void main(String[] args) {
        /*
           FIRST SKIP THIS CODE BLOCK, AND GO 
           BELOW, OUTSIDE THE BRACES OF THIS WHOLE FUNCTION
           FOR EXPLANATION IN HOW TO CREATE FUNCTIONS.        
         */
        
        /*
            NOW THAT YOU UNDERSTAND HOW TO CREATE FUNCTIONS,
            let's use them. As you saw in averageGrade() 
            function. You can use functions inside other functions.
            Is important that you know that this space(the safe area)
            is "the main function", is the place where you
            use whatever other function, here is where
            everything of your program happens. You can create
            things outside, but you make them works here.
        */
        
        System.out.println("Let's use how we use the functions we created:");       
        
        /*
            When a function returns a value that value is stored
            in a variable with THE SAME DATA TYPE OF THE RETURN.
            So, as addition() returns data type double we use 
            variable of data type double.
        */
        System.out.println("\naddition(double arg1, double arg2)");
        double grade=addition(10,-2);
        System.out.printf("The addition between 10 and -2 is %.2f \n",grade);        
        
        //we can also use directly the return of the function on printing
        System.out.println("\nlogicImplication(boolean p, boolean q)");
        System.out.printf("true->false is : %b\n", logicImplication(true,false));
        
        //use a function that prints something
        System.out.println("\ngoodByeMrStark()");
        goodByeMrStark();
         /*
            Now, a function that returns a string is different from a
            function that just print something. When you just print
            out, the data type of the function is simply void
            and there's no need to store variable because function
            doesn't return anything. But when you return a String, 
            maybe you want to make more things with it than just 
            print it. Of course you can print it, but have to use
            "print java functions" for that purpose.
        */
         
        //you directly print the return of the function as any other string variable
        System.out.println("\nnameAndGrade(String name,double grade)");
        System.out.print( nameAndGrade("The Java Learner",grade) );
        
        System.out.println("\naverageGrade(double grade1, double grade2)");
        averageGrade(5.99,10);
        
        System.out.println();
        //now run this program if you haven't
        goodByeMrStark();
    }    
    
    //you're leaving the safe area, but it's ok because you're well prepared
    //This is where you code functions
    
    /*
        The format of a function starts with two
        words:
            public static...
        Don't try to understand why,just use them.    
        After that, you have to write the
        data type that your function is going to 
        return, could be whatever data type but
        for now we just use those that we've using for
        variables:
            int, double, boolean, String.
        for example:
            public static boolean...
        ATTENTION, If our function doesn't return a value
        we use the word "void":
            public static void...
        Then, we place the name of our function:
            public static void myFunction....
        Finally, between parenthesis we put
        AGAIN THE DATA TYPE  and AN IDENTIFIER OF THE ARGUMENT:
            public static void myFunction1(int arg1)...
            public static boolean myFunction2(double arg2)...
            public static int myFunction3(String arg3)...      
        if there are more than one argument you listed
        them separated by commas or you just put nothing
        if is a function with no arguments:
            public static String myFunction5(int arg1,double arg2, String arg3)...            
            public static double myFunction6()...   
        And finally we just place code between braces.
        One final format might be:
            public static String finalFunction(String arg1,int arg2){
                //code
            }                    
    */
    
    //now some functions
    
    /**
     * Computes the addition of two numers
     * @param arg1 first number
     * @param arg2 second number
     * @return the addition 
     */
    public static double addition(double arg1,double arg2){
        double result= arg1+arg2;
        //use return to return the outcome of the function(really?)
        return result;
    }
    
    /**
     * Function that computes the logic implication
     * of two boolean values.
     * @param p first boolean value
     * @param q second boolean value
     * @return p->q which means ("p then q")
     */    
    public static boolean logicImplication(boolean p, boolean q){
        //p->q is the same as (¬p V q) which in java is...        
        boolean result=(!p)||q ;
        /*
            We always use parenthesis for complex operations
            to avoid unexpected results because of precedence 
            of whichever operator.
        */
        return result;
    }
   
     /**
     * Function to say goodBye to Tony Starks when 
     * the program finishes.
     */
    public static void goodByeMrStark(){
        System.out.println("It was a pleasure to help you. Mr. Stark..."); 
    }
       
    /**
     * Creates a string with the name
     * and the grade.
     * @param name name of the person
     * @param grade the grade obtained
     * @return a message showing
     * the name and the grade
     */
    public static String nameAndGrade(String name,double grade){
        /*
            Do you remember we could mix variables and text 
            suming them up LITERALLY, to print text?. Well, 
            we can also do it to create strings.
         */
        String message="I' am " + name + " and my grade is " + grade + "\n";
        return message;
    }
    
    /**
     * This function computes the average between
     * two grades and print it.
     * @param grade1 first value
     * @param grade2 second value
     */
    public static void averageGrade(double grade1, double grade2){
        //we can also use a funcion insides another one
        double average=addition(grade1,grade2)/2;            
        System.out.printf("The average grade of %.2f and %.2f is %.2f \n",grade1,grade2,average);        
    }   
    //Now you can go up to the "main function"
}
