import java.util.Scanner;

public class ProbF {
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        int N=input.nextInt();
        int[] arr=new int[N];
        for(int i=0;i<N;++i){
            arr[i]=input.nextInt();
        }
        for(int j=0;j<N-1;++j){
            for(int i=0;i<N-1-j;++i){
                if(arr[i]>arr[i+1] && ((arr[i]%2==0 && arr[i+1]%2==0) || (arr[i]%2!=0 && arr[i+1]%2!=0))){
                    int temp=arr[i];
                    arr[i]=arr[i+1];
                    arr[i+1]=temp;
                }
            }
        }
        for(int i=0;i<N;++i){
            if(i==N-1) System.out.print(arr[i]);
            else System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}