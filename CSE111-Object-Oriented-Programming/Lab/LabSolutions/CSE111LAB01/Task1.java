package CSE111LAB01;
import java.util.Scanner;


public class Task1 {
    public static void main(String[] args) {
        //A
        int i1=10;
        System.out.println(i1);
        
        //B
        int i2=5;
        System.out.println(i1+i2);
        
        //C
        System.out.println((i1*i2)+"\n"+(i1/i2));
        
        //D
        //D(A)
        double d1=10.5;
        System.out.println(d1);
        //D(B)
        double d2=5.6;
        System.out.println(d1+d2);
        //D(C)
        System.out.printf("%.1f\n%.1f\n",(d1*d2),(d1/d2));
        
        //E
        //E(A)
        double d=10.5;
        System.out.println(d);
        //E(B)
        int i=5;
        System.out.println(d+i);
        //E(C)
        System.out.printf("%.1f\n%.1f\n",(d*i),(d/i));
        
        //F
        //F(A)
        String s1="Mehedi Hasan ";
        System.out.println(s1);
        //F(B)
        String s2="Roudro";
        System.out.println(s1+s2);
        //F
        int f=1;
        System.out.println(f+s2);
        System.out.println(s1+f);
        
        //G
        Scanner input=new Scanner(System.in);
        //G(A)
        int in1=input.nextInt();
        System.out.println(in1);
        int in2=input.nextInt();
        System.out.println(in1+in2);
        input.close();
    }
}
