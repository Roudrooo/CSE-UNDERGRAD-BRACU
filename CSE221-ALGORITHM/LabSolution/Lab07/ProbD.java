import java.io.*;
import java.util.*;

public class ProbD{
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
        StringTokenizer stkr=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(stkr.nextToken());
        int M=Integer.parseInt(stkr.nextToken());
        int S=Integer.parseInt(stkr.nextToken());
        int D=Integer.parseInt(stkr.nextToken());

        ArrayList<Vertex> Graph=new ArrayList<>();
        Graph.add(null);

        stkr=new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++){
            int w=Integer.parseInt(stkr.nextToken());
            Graph.add(new Vertex(i,w));
        }

        for(int i=0;i<M;i++){
            stkr=new StringTokenizer(br.readLine());
            int u=Integer.parseInt(stkr.nextToken());
            int v=Integer.parseInt(stkr.nextToken());

            Graph.get(u).neighbor.add(new Edge(Graph.get(v)));
        }

        pw.println(Dijkstra(Graph, Graph.get(S), Graph.get(D)));
        pw.flush();
    }

    private static int Dijkstra(ArrayList<Vertex> Graph, Vertex source, Vertex destination){

        source.dist=source.weight;
        PriorityQueue<Vertex> priorityQueue=new PriorityQueue<>(Comparator.comparing(v->v.weight));

        priorityQueue.add(source);

        while(!priorityQueue.isEmpty()){
            Vertex u=priorityQueue.poll();

            if(u==destination){
                return u.dist;
            }

            for(Edge edge : u.neighbor){
                Vertex v=edge.destination;

                if(u.dist+v.weight<v.dist){
                    v.dist=u.dist+v.weight;
                    v.parent=u;

                    priorityQueue.add(v);
                }
            }
        }
        return -1;
    }
}

class Vertex{
    int id;
    int weight;
    int dist=Integer.MAX_VALUE;
    Vertex parent;
    ArrayList<Edge> neighbor=new ArrayList<>();
    Vertex(int id,int weight){
        this.id=id;
        this.weight=weight;
    }
}

class Edge{
    Vertex destination;
    Edge(Vertex destination){
        this.destination=destination;
    }
}