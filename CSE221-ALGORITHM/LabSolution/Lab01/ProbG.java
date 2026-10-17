import java.util.Scanner;

public class ProbG {
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        int N=input.nextInt();
        int[] id=new int[N],mark=new int[N];
        for(int i=0;i<N;++i){
            id[i]=input.nextInt();
        }
        for(int i=0;i<N;++i){
            mark[i]=input.nextInt();
        }
        int steps=0;
        for(int i=0;i<N-1;++i){
            int idx=i;
            for(int j=i+1;j<N;++j){
                if(mark[idx]<mark[j]){
                    idx=j;
                    
                }else if(mark[j]==mark[idx] && id[idx]>id[j]){
                    idx=j;
                }
            }
            if(idx!=i){
                int temp=mark[i];
                mark[i]=mark[idx];
                mark[idx]=temp;
                temp=id[i];
                id[i]=id[idx];
                id[idx]=temp;
                steps++;
            }
        }
        System.out.println("Minimum swaps: "+steps);
        for(int i=0;i<N;++i){
            System.out.println("ID: "+id[i]+" Mark: "+mark[i]);
        }
    }
}