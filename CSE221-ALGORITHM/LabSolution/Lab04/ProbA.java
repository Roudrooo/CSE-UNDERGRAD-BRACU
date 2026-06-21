import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ProbA{


    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
        StringTokenizer stkr=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(stkr.nextToken());
        int M=Integer.parseInt(stkr.nextToken());

        int[][] DrcWtd=new int[N+1][N+1];

        while(M-->0){
            stkr=new StringTokenizer(br.readLine());

            int source=Integer.parseInt(stkr.nextToken()), destination=Integer.parseInt(stkr.nextToken()), weight=Integer.parseInt(stkr.nextToken());
            DrcWtd[source][destination]=weight;
        }

        for(int r=1;r<N+1;++r){
            for(int c=1;c<N+1;++c){
                pw.print(DrcWtd[r][c]+" ");
            }
            pw.println();
        }
        pw.close();
    }
}