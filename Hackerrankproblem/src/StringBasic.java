import java.io.*;
import java.util.*;

public class StringBasic {

    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        String B=sc.next();
        /* Enter your code here. Print output to STDOUT. */
        int alen = A.length();
        int blen = B.length();
        int reslen = alen+blen;
        System.out.println(reslen);
        if((A.compareTo(B))>0)
        System.out.println("Yes");
        else
        System.out.println("No");
        
        System.out.println(Character.toUpperCase(A.charAt(0))+A.substring(1,alen)+" "+Character.toUpperCase(B.charAt(0))+B.substring(1,blen));


    
        
    }
}



