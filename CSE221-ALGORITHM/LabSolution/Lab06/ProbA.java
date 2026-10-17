import java.io.*;
import java.util.*;

class Vertex{
    int id;
    String color="White";
    int startTime;
    int endTime;
    Vertex parent;
    ArrayList<Vertex> adjacent=new ArrayList<>();
    Vertex(int id){
        this.id=id;
    }
}

public class ProbA{

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
        StringTokenizer stkr=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(stkr.nextToken());
        int M=Integer.parseInt(stkr.nextToken());

        while(M-->0){
            stkr=new StringTokenizer(br.readLine());

            int u=Integer.parseInt(stkr.nextToken());
            int v=Integer.parseInt(stkr.nextToken());

            Vertex A=new Vertex(u);
            Vertex B=new Vertex(v);

            A.adjacent.add(B);

        }
    }

    private static void DFS(int )
}