//Find Last Digit Of a^b for Large Numbers https://www.geeksforgeeks.org/problems/find-last-digit-of-ab-for-large-numbers1936/1
//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.math.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            
            String a = S[0];
            String b = S[1];

            Solution ob = new Solution();
            System.out.println(ob.getLastDigit(a,b));
        }
    }
}
// } Driver Code Ends

//User function Template for Java
class Solution {
    
    static int getLastDigit(String a, String b) {
     return new BigInteger(a).modPow(new BigInteger(b), BigInteger.TEN).intValue(); // Return the last digit as an int
    }
}
/*Solution2*/
    class Solution {    
    static int getLastDigit(String a, String b) {               
        //boundary cases        
        if(b.length() == 1 && b.equals("0"))
        return 1;        
        if(a.equals("1"))
        return 1;        
        int exponent = (Modulo(4 , b) == 0 ? 4 : Modulo(4 , b));        
        int result  = (int)(Math.pow(a.charAt(a.length()-1)-'0' , exponent));                
        return result%10;      
        
    }    
      private static int Modulo (int a , String b){        
            int res = 0;
            for(int i = 0 ; i < b.length() ; i++) {
                res = (res*10 +b.charAt(i)-'0') %a;
            }
              return res;            
        }
};
