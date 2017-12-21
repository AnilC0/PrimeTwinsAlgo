package twinprimes;

import java.io.IOException;
import java.util.Scanner;

public class TwinPrimes {
    public static void main(String args[]){
        //TWWriter();
        //TWGaps();
        //System.out.println(FLTPrimeTest(108883,5));        //some prime numbers for test 108883,100361,100363
        BrunEstimator();
                }
    public static boolean isPrime(long n){     //trial division
        int count=0;
        for(int i=1; i<=n; i++)
            if(n%i == 0) count++;

        if(count == 2)
            return true;
        else
            return false;
    }
    public static void TWWriter(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the lower range : ");
        long p = Long.parseLong(sc.nextLine());
        System.out.print("Enter the upper range : ");
        long q = Long.parseLong(sc.nextLine());
        int lc= 0;
        if(p>q)
            System.out.println("Invalid Range !");
        else{
            System.out.println("nThe Twin Prime Numbers within the given range are : ");
            for(long i=p; i<=(q-2); i++){
                    if(isPrime(i)&& isPrime(i+2)){
                        System.out.print("("+i+","+(i+2)+") ");
                        lc++;
                    }
                    if(lc==20){
                        System.out.println("");
                        lc=0;
                }
            }
            System.out.println("");
        }
    }
    public static void TWGaps(){
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the lower range : ");
        long p = Long.parseLong(sc.nextLine());
        System.out.print("Enter the upper range : ");
        long q = Long.parseLong(sc.nextLine());
        long[] ardAsal=new long[2];
        int lineC=0;
        for(long i=p; i!=q; i++){
            if(ardAsal[0]==0){
                if(isPrime(i))ardAsal[0]=i;
            }
            else{   //ardAsal[0]!=0
                if(isPrime(i)){
                    ardAsal[1]=i;
                    System.out.print(ardAsal[1]-ardAsal[0]+"\t");
                    ardAsal[0]=ardAsal[1];
                    ardAsal[1]=0;
                    lineC++;
                }
            }
            if(lineC==15){
                System.out.println("");
                lineC=0;
            }
        }
            System.out.println("");
        }
    public static boolean FLTPrimeTest(int n,int k){
    // If n is prime, then always returns true, If n is
    // composite than returns false with high probability
    // Higher value of k increases probability of correct
    // result.     
        if(n <= 1 || n == 4) return false;
        if(n<=3) return true;
        while (k>0){
            // Pick a random number in [2..n-2]        
            // Above corner cases make sure that n > 4
            int a = (int)(2 + Math.random()*(n-4));  
            // Fermat's little theorem
            if (Math.pow(a, n-1)%n != 1)
            return false;
            k--;
        }
        return true;
    }
    public static void BrunEstimator(){
        double Brun=0;
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter the upper range : ");
        long q = sc.nextInt();
        System.out.println("Estimated Brun Number is ");
        for(long i=2; i<=q-2; i++){
            if(isPrime(i)&& isPrime(i+2)){
                Brun+= (double)1/i + (double)1/(i+2);
            }
        }
        System.out.println(Brun);
    }
}
