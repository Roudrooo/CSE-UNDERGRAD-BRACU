import java.util.Scanner;

public class ProbC {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int T=input.nextInt();
        for(int i=0;i<T;++i){
            int N=input.nextInt();
            long sum=(long)N*(N+1)/2;
            System.out.println(sum);
        }
        input.close();
    }
}