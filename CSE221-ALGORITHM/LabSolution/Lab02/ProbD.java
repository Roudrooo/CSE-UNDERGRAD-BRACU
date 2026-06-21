import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ProbD {
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);

        StringTokenizer stkr=new StringTokenizer(br.readLine());
        int N=Integer.parseInt(stkr.nextToken());

        int[] A=new int[N];
        stkr=new StringTokenizer(br.readLine());
        for(int i=0;i<N;++i){
            A[i]=Integer.parseInt(stkr.nextToken());
        }

        stkr=new StringTokenizer(br.readLine());
        int M=Integer.parseInt(stkr.nextToken());

        int[] B=new int[M];
        stkr=new StringTokenizer(br.readLine());
        for(int i=0;i<M;++i){
            B[i]=Integer.parseInt(stkr.nextToken());
        }

        int[] AB=new int[N+M];
        int l1=0,l2=0;
        for(int i=0;i<N+M;++i){
            if (l1<N && l2<M){
                if(A[l1]>B[l2]){
                    AB[i]=B[l2++];
                }else{
                    AB[i]=A[l1++];
                }
            }else if(l1==N&&l2<M){
                AB[i]=B[l2++];
            }else{
                AB[i]=A[l1++];
            }
        }
        for(int i=0;i<M+N;++i){
            if(i==M+N-1) pw.print(AB[i]);
            else pw.print(AB[i]+" ");
        }
        pw.println();
        pw.close();
    }
}
