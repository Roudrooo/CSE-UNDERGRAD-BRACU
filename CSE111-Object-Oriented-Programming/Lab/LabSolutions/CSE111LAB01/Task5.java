package CSE111LAB01;
import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.println("Enter three numbers:");
        int a=input.nextInt(),b=input.nextInt(),c=input.nextInt();
        if(a>b&&a>c){
            System.out.println("Largest number: "+a);
        } else if(b>a&&b>c){
            System.out.println("Largest number: "+b);
        } else{
            System.out.println("Largest number: "+c);
        }
        input.close();
    }
}