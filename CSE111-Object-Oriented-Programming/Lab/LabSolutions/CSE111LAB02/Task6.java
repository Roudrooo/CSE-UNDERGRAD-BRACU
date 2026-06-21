import java.util.Scanner;

public class Task6 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        double x,w,sum_w=0,sum_w_x=0;
        for(int i=1;i<=5;i++){
            System.out.printf("Number %d = ",i);
            x=input.nextDouble();
            System.out.printf("Weight %d = ",i);
            w=input.nextDouble();
            sum_w_x+=(w*x);
            sum_w+=w;
        }
        double W=sum_w_x/sum_w;
        System.out.println("Weighted Average = "+W);
        input.close();
    }
}