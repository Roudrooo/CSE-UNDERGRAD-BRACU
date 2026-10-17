package CSE111LAB01;
import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.print("Multiplication table of: ");
        int n=input.nextInt(),i=0;
        System.out.printf("%d x %d = %d\n",n,++i,n*i);
        System.out.printf("%d x %d = %d\n",n,++i,n*i);
        System.out.printf("%d x %d = %d\n",n,++i,n*i);
        System.out.printf("%d x %d = %d\n",n,++i,n*i);
        System.out.printf("%d x %d = %d\n",n,++i,n*i);
        System.out.printf("%d x %d = %d\n",n,++i,n*i);
        System.out.printf("%d x %d = %d\n",n,++i,n*i);
        System.out.printf("%d x %d = %d\n",n,++i,n*i);
        System.out.printf("%d x %d = %d\n",n,++i,n*i);
        System.out.printf("%d x %d = %d\n",n,++i,n*i);
        input.close();
    }
}
