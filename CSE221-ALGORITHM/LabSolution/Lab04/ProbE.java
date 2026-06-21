import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ProbE{


    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
        StringTokenizer stkr=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(stkr.nextToken());
        int M=Integer.parseInt(stkr.nextToken());

        stkr=new StringTokenizer(br.readLine());
        int[] source=new int[N+1];

        int tempM=M;

        while(tempM-->0){
            int src=Integer.parseInt(stkr.nextToken());
            source[src]++;
        }

        stkr=new StringTokenizer(br.readLine());
        int[] destination=new int[N+1];

        tempM=M;

        while(tempM-->0){
            int des=Integer.parseInt(stkr.nextToken());
            destination[des]++;
        }
        for(int i=1;i<N+1;++i){
            pw.print(destination[i]-source[i]+" ");
        }
        pw.println();
        pw.close();
    }
}