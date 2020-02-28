import java.util.Scanner;

public class SubstringCompare {

    public static String getSmallestAndLargest(String s, int k) {
        String smallest = "";
        String largest = "";
        
        // Complete the function
        // 'smallest' must be the lexicographically smallest substring of length 'k'
        // 'largest' must be the lexicographically largest substring of length 'k'
        int len = s.length();
        for(int i=0;i<=len-k;i++)
        {
            String substr = s.substring(i,i+k);
            if(i==0){
            smallest = substr;
            largest=substr;}
            if(substr.compareTo(largest)>0)
            {
                largest = substr;
            }
             if(substr.compareTo(smallest)<0)
            {
                smallest = substr;
            }
        }
        
        return smallest + "\n" + largest;
    }
}

