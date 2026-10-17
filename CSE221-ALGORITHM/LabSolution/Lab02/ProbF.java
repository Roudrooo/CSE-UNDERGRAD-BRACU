import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ProbF {
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
        StringTokenizer stkr=new StringTokenizer(br.readLine());
        int N=Integer.parseInt(stkr.nextToken());
        long K=Long.parseLong(stkr.nextToken());

        int a[]=new int[N];
        
        stkr=new StringTokenizer(br.readLine());
        for(int i=0;i<N;++i){
            a[i]=Integer.parseInt(stkr.nextToken());
        }
    }
}
