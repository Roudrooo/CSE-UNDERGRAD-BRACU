import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ProbA{
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
        StringTokenizer stkr=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(stkr.nextToken());
        int M=Integer.parseInt(stkr.nextToken());

        ArrayList<Integer>[] adjoints=new ArrayList[N+1];
        for(int i=0;i<=N;++i) adjoints[i]=new ArrayList<>();
        
        for(int i=0;i<M;++i){
            stkr=new StringTokenizer(br.readLine());
            int u=Integer.parseInt(stkr.nextToken());
            int v=Integer.parseInt(stkr.nextToken());
            adjoints[v].add(u);
            adjoints[u].add(v);
            
        }

        boolean[] visited=new boolean[N+1];
        Queue<Integer> q=new LinkedList();

        q.add(1);
        visited[1]=true;

        while(!q.isEmpty()){
            int u=q.poll();
            pw.print(u+" ");
            for(int v:adjoints[u]){
                if(!visited[v]){
                    visited[v]=true;
                    q.add(v);
                }
            }
        }
        pw.println();
        pw.close();
    }
}