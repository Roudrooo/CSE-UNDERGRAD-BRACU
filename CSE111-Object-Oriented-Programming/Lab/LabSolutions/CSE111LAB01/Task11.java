package CSE111LAB01;
import java.util.Scanner;

public class Task11 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.print("Enter the value of x:");
        double x=input.nextDouble();
        double fx;
        if(x<0){
            fx=2d*x;
        }else if(0<=x&&x<2){
            fx=x+1d;
        }else if(2<=x&&x<5){
            fx=(x*x)-1d;
        }else{
            fx=(3*(x*x))+2d;
        }
        System.out.printf("%.2f\n",fx);
        input.close();
    }
}
