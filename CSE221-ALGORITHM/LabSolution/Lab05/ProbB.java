import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class ProbB{
    public static ArrayList<Integer>[] adjoints;
    public static boolean[] visited;
    public static PrintWriter pw;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        pw=new PrintWriter(System.out);
        StringTokenizer stkr=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(stkr.nextToken());
        int M=Integer.parseInt(stkr.nextToken());

        adjoints=new ArrayList[N+1];
        for(int i=0;i<=N;++i) adjoints[i]=new ArrayList<>();

        stkr=new StringTokenizer(br.readLine());
        int[] u=new int[M+1];
        for(int i=1;i<=M;++i){
            u[i]=Integer.parseInt(stkr.nextToken());
        }
        stkr=new StringTokenizer(br.readLine());
        int[] v=new int[M+1];
        for(int i=1;i<=M;++i){
            v[i]=Integer.parseInt(stkr.nextToken());
        }

        for(int i=1;i<=M;++i){
            adjoints[u[i]].add(v[i]);
            adjoints[v[i]].add(u[i]);
        }

        visited=new boolean[N+1];

        dfs(1);
        pw.println();
        pw.close();
        
        
    }



    private static void dfs(int start){
        Stack<Integer> stack=new Stack<>();
        stack.push(start);

        while(!stack.isEmpty()){
            int u=stack.pop();
            if(visited[u]) continue;
            visited[u]=true;
            pw.print(u+" ");

            for(int v:adjoints[u]){
                if(!visited[v]){
                    stack.push(v);
                }
            }
        }
    }
}