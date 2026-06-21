import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ProbG{


    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
        StringTokenizer stkr=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(stkr.nextToken());
        int M=Integer.parseInt(stkr.nextToken());
        int K=Integer.parseInt(stkr.nextToken());


        boolean[][] HasKnights=new boolean[N+1][M+1];
        int[] X=new int[K+1];
        int[] Y=new int[K+1];

        for(int i=1;i<=K;++i){
            stkr=new StringTokenizer(br.readLine());
            X[i]=Integer.parseInt(stkr.nextToken());
            Y[i]=Integer.parseInt(stkr.nextToken());
            HasKnights[X[i]][Y[i]]=true;
        }
        for(int i=1;i<=K;++i){
            int x=X[i];
            int y=Y[i];

            for(int r=x-2;r<=x+2;++r){
                for(int c=y-2;c<=y+2;++c){
                    boolean invalidMove=!((Math.abs(r-x)==2&&Math.abs(c-y)==1)||(Math.abs(r-x)==1&&Math.abs(c-y)==2));
                    if(invalidMove||r<1||r>N||c<1||c>M) continue;
                    if(HasKnights[r][c]){
                        pw.println("YES");
                        pw.flush();
                        return;
                    }
                }
            }
        }

        pw.println("NO");
        pw.close();

    }
}