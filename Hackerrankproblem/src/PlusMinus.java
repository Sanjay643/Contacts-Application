import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class PlusMinus {

    // Complete the plusMinus function below.
    static void plusMinus(int[] arr) {
        float p=0,n=0,z=0;
        double res1,res2,res3;
        int length = arr.length;
        for(int i=0;i<length;i++)
        {
            if(arr[i]>0)
            {
                p++;
            }
           else if(arr[i]<0)
            {
                n++;
            }
            else if(arr[i]==0)
            {
                z++;
            }
            
        }
        //System.out.println(p+" "+n+" "+z);
        res1= p/length;
       res2 = n/length;
       res3 = z/length;
       
       System.out.println(res1+"\n"+res2+"\n"+res3);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        plusMinus(arr);

        scanner.close();
    }
}
