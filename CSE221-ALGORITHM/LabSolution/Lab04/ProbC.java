import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ProbC{


    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
        StringTokenizer stkr=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(stkr.nextToken());

        int[][] DrcUnWtd=new int[N][N];

        for(int i=0;i<N;++i){
            stkr=new StringTokenizer(br.readLine());

            int k=Integer.parseInt(stkr.nextToken());

            while(k-->0){
                int dest=Integer.parseInt(stkr.nextToken());
                DrcUnWtd[i][dest]=1;
            }
        }
        for(int r=0;r<N;++r){
            for(int c=0;c<N;++c){
                pw.print(DrcUnWtd[r][c]+" ");
            }
            pw.println();
        }
        pw.close();
    }
}