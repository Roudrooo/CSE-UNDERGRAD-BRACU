import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ProbF {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);

        StringTokenizer stkr=new StringTokenizer(br.readLine());
        int N=Integer.parseInt(stkr.nextToken());

        stkr=new StringTokenizer(br.readLine());
        long[] A=new long[N];
        long[] B=new long[N];
        for(int i=0;i<N;++i){
            A[i]=Long.parseLong(stkr.nextToken());
            B[i]=A[i];
        }
        
        OrderingBinaryTree(A, 0, 0, N-1, B);

        for(int i=0;i<N;++i){
            pw.print(B[i]+" ");
        }
        pw.println();
        pw.close();

    }

    private static void OrderingBinaryTree(long[] A, int i, int l, int r, long[] B){
        int length=A.length;
        if(l>r) return;

        int midIndex=length/2;

        B[i]=midIndex;
        OrderingBinaryTree(A, i+1, 0, midIndex, B);
        OrderingBinaryTree(A, midIndex+1, midIndex, length, B);
    }
}