import java.util.Scanner;
public class Gcd {
    static int findGcd(int a,int b){
        if(a == 0)  return b;
        if(b ==0) return a;
        if(a == b ) return a;
        if(a >b)  return findGcd(a-b, b);
        return findGcd(a, b-a);
    }
    //Euclid alogrithm
    static int OfindGcd(int a,int b){
            if(b == 0)
                    return a;
            return OfindGcd(b, a%b);
    }
    
    
    public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter num1:");
            int num1 = scan.nextInt();
            System.out.println("Enter num2:");
            int num2 = scan.nextInt();
           int ans = OfindGcd(num1,num2);
           System.out.println("ans is "+ans);
            scan.close();
    }
    
}
