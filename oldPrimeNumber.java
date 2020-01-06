import java.util.Scanner;

public class oldPrimeNumber {

    static void printElapsedTime(long start,long end){
        long taken = end-start;
        System.out.println("time taken: "+taken);
    }
    
     static boolean  isPrime(int i){
        if(i<=1){
            return false;
        } 
        if(i<=3){
            return true;
        }
        if(i%2 == 0 || i%3 == 0){
            return false;
        }
        for(int t =5;t*t<=i;t=t+6){
            System.out.println("t="+t+"i="+i);
            if(i%t == 0    || i%(t+2) == 0){
                return false;
            }
                
        }
        return true;
    }
    public static void main(String[] args) {
         System.out.println("Enter the number:");
        Scanner scanner = new Scanner(System.in);
        int num =scanner.nextInt();
        scanner.close();
       // boolean bool =isPrime(num);
       long start = System.currentTimeMillis();
       boolean bool = isPrime(num);
       long end = System.currentTimeMillis();
        printElapsedTime(start, end);
        System.out.println(num +"is Prime: "+bool);
        
    }
    
    static boolean oldIsPrime(int num){
        if(num <=1) return false;
        for (int i = 2; i < num; i++) {
            System.out.println("i="+i);
            if (num % i == 0) 
                return false; 
        }
        return true; 
    }
    
}
