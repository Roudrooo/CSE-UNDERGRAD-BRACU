import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ProbB{
    public static void main(String[] args) throws IOException {
        InputStreamReader in =new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(in);
        PrintWriter pw=new PrintWriter(System.out);

        StringTokenizer stkn=new StringTokenizer(br.readLine());
        
        
        int N=Integer.parseInt(stkn.nextToken()),M=Integer.parseInt(stkn.nextToken());
        long K=Long.parseLong(stkn.nextToken());

        stkn=new StringTokenizer(br.readLine());
        
        long[] A=new long[N],B=new long[M];
        for(int i=0;i<N;++i){
            A[i]=Long.parseLong(stkn.nextToken());
        }

        stkn=new StringTokenizer(br.readLine());
        
        for(int i=0;i<M;++i){
            B[i]=Long.parseLong(stkn.nextToken());
        }


        int[] pair={1,M};

        int L=0,R=M-1;
        long sum=A[L]+B[R];
        long min=Math.abs(sum-K);
        while(L<N && R>=0){
            sum=A[L]+B[R];
            long calc=Math.abs(sum-K);
            if(calc==0){
                pw.println(++L +" "+ ++R);
                pw.flush();
                return;
            }else if(calc<min){
                min=calc;
                pair[0]=L+1;
                pair[1]=R+1;
            }
            if(sum<K){
                L++;
            }else{
                R--;
            }
        }
        
        pw.println(pair[0]+" "+pair[1]);
        pw.close();
    }
}