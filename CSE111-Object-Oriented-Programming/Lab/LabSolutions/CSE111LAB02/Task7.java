import java.util.Scanner;

public class Task7{
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        //a
        int n=input.nextInt(),f=1,s=1,sum=0;
        if(f<=n){
            System.out.print(f+" ");
            sum+=f;
        }
        if(s<=n) {
            System.out.print(s+" ");
            sum+=s;
        }
        int next=f+s;
        while (next<=n) {
            System.out.print(next+" ");
            sum+= next;
            f=s;
            s=next;
            next =f+s;
        }
        //b
        System.out.println("\nSum of the Fibonacci numbers: " + sum);
        input.close();
    }
}