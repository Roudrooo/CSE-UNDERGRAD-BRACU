import java.util.Scanner;

public class ProbD {
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        int T=input.nextInt();
        for(int i=0;i<T;++i){
            int N=input.nextInt();
            int[] arr=new int[N];
            for(int j=0;j<N;++j){
                arr[j]=input.nextInt();
            }
            boolean flag=true;
            for(int j=0;j<N-1-i;++j){
                if(arr[j]>arr[j+1]){
                    flag=false;
                    break;
                }
            }
            if(flag) System.out.println("YES");
            else System.out.println("NO");
        }
        input.close();
    }
}