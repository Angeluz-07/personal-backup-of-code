
/**
 * In this example we'll learn the basic of
 * user input. When we're getting user input at this point
 * the program crash if you don't type what the 
 * program expects. So, always type what the programs
 * asks. For example if programs asks for an integer don't
 * type text.
 */

/*
    THE NEXT LINE IS NECCESARY ALWAYS YOU WANT TO GET
    USER INPUT. Don't care about neither what nor why 
    for now, just write it.
*/
import java.util.Scanner;

public class UserInput{

    public static void main(String[] args) {
        /*
            Again, we remains here. For now this is the safe area.
            This is where we code now.  
        */
        
        /*
            First let's create a variable that's gonna help us
            to get user input. Remember to create variables 
            FIRST the data type, then the name and finally we give it
            a value. You should know that there is a lot of data types
            not just int, double, boolean, char and String. In this case
            we use a special data type called "Scanner"
        */
        Scanner input;
        input=new Scanner(System.in);//you could also have done all in one line                
        /*
            We see that first we set the variable with no value, and then
            we assign it a value. But what is that?. It turns out that
            the variable is going to store some value of type "Scanner"
            but that value is something more structured than a simple word 
            or a number. Because of that, we use that "new S.." thing
            that you don't need to understand now. For now just, let's use 
            this variable.
        */
        
        /*
            With our recent variable let's get some user input. 
            Many ways to do this. We'll use three basic functions. 
            Don't worry if you don't understand them now, just use them:
                input.nextInt()
                input.nextDouble()
                input.nextLine()           
        */
        
        //We first must ask for user input
        System.out.print("Welcome Mr. Stark, type an integer : ");
        
        //We use this one to get integers from the user
        input.nextInt();        
        
        System.out.println("You entered....wait, where is the value!");
        
        //when you get user input you want to store that in a variable
        System.out.print("Sorry. Please, type an integer again : ");
        
        /*
            YOU USE THE "input function" AND ASSIGN IT TO THE VARIABLE.
            The function is like a tunnel, where the input of the user
            travels from the keyboard to the variable.
        */                
        int integerFromUser=input.nextInt();//Again, we use this one to get integers from the user
        System.out.printf("You entered %d\n",integerFromUser);
        
        
        System.out.print("Now, type a double(here must express decimal with comma, no with point): ");
        
        //we use this one to get numbers with decimal point
        double doubleFromUser=input.nextDouble();
        System.out.printf("You entered %.2f\n",doubleFromUser);
        
        
        System.out.println("Now, type a word or a sentence : ");        
        
        //and we use this one to get strings    
        String stringFromUser=input.nextLine();
        System.out.printf("You entered : %s",stringFromUser);
        System.out.println("nothing, because you couldn't. So...what happens?");        
        
        /*
            It happens that if i have:
                int n=input.nextDouble();
            and I type 12,1 and then I press Enter, what
            the programs indeed receives is:
                12,1\n
            where \n is the new line character and is read 
            by the program. The function input.nextDouble()
            just gets the value 12,1. So, the character \n REMAINS THERE.
            If after that I have:
                String word=input.nextLine();
            Program will see the new line character and will act
            as if the user already pressed enter.It'll store the
            value, which is nothing because the user couldn't type
            anything. To get rid of that \n character, we must 
            place the line of code:
                input.nextLine();
            wich just serves to kind of "consume" that \n .
            
            And why there's no problem using input.nextInt()
            and then input.nextDouble()? Because If i have:
                int n1=input.nextInt();                
                double n2=input.nextDouble();
            and I type 12, the program receives:
                12\n
            input.nextInt() gets the 12, \n remains there
            and the funcion input.nextDouble() sees:
                \n
            It can't work because is waiting for a number, empty 
            space is not a number. Is going to wait to user
            for a number. No problem here.
            
            
            TO SUM UP,ALWAYS THAT YOU HAVE:
                int var1=input.nextInt(); 
                or
                double var2=input.nextDouble();
            AND THEN YOU HAVE:
                String var3=input.nextLine();
            YOU MUST PLACE A:
                input.nextLine();
            BEFORE STORE THE STRING.
        */
        
        //let's try get a double and then a string again        
        System.out.print("Please, type a double again : ");
        double otherDouble=input.nextDouble();
        System.out.printf("You entered %.2f\n",otherDouble);
                
        System.out.println("Now, type a word or a sentence : ");
        
        input.nextLine();//WE PLACE THIS LINE TO CONSUME THE \n 
        
        String otherString=input.nextLine();
        System.out.printf("You entered : %s \n",otherString);
        System.out.println("Now, you could do it.");
        
        /*
            May seems tedious all that we covered until here, and just for 
            getting user input. But it's just to not get frustated
            latter when our code doesn't work as expected and 
            just by stupid things. In the next example we'll make 
            something more interesting, applying all this stuff...with no 
            errors.
        */
        
        //now run this program if you haven't
        System.out.println("\nIt was a pleasure to help you. Mr. Stark...");        
    }
    
}