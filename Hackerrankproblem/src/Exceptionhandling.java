import java.io.*;
import java.util.*;

public class Exceptionhandling {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        int x,y;
        Scanner scan = new Scanner(System.in);
        
        try{
            x = scan.nextInt();
            y = scan.nextInt();
            int res = x/y;
            System.out.println(""+res);
        }
        catch(InputMismatchException e)
        {
            System.out.println("java.util.InputMismatchException");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}

