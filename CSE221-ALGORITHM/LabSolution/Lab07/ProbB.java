
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;



public class ProbB{
    public static void main(String[] args)throws IOException{
        PrintWriter pw=new PrintWriter(System.out);
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stkr=new StringTokenizer(br.readLine());

        ArrayList<Vertex> Graph=new ArrayList<>();

        

        int N=Integer.parseInt(stkr.nextToken());
        int M=Integer.parseInt(stkr.nextToken());
        int S=Integer.parseInt(stkr.nextToken());
        int T=Integer.parseInt(stkr.nextToken());

        Graph.add(null);
        for(int i=1;i<=N;++i){
            Graph.add(new Vertex(i));
        }

        for (int i=0;i<M;i++){
            stkr=new StringTokenizer(br.readLine());
            int u=Integer.parseInt(stkr.nextToken());
            int v=Integer.parseInt(stkr.nextToken());
            int w=Integer.parseInt(stkr.nextToken());

            Graph.get(u).neighbor.add(new Edge(Graph.get(v), w));
        }



        int[] distAlice=Dijkstra(Graph, Graph.get(S), N);
        int[] distBob=Dijkstra(Graph, Graph.get(T), N);

        int minTime=Integer.MAX_VALUE;
        int meetNode=-1;

        for(int i=1;i<=N;++i){
            if(distAlice[i]!=Integer.MAX_VALUE && distBob[i]!=Integer.MAX_VALUE){
                int meetTime=Math.max(distAlice[i], distBob[i]);
                if(meetTime<minTime){
                    minTime=meetTime;
                    meetNode=i;
                }else if(meetTime==minTime && i<meetNode){
                    meetNode=i;
                }
            }
        }

        if(meetNode==-1){
            pw.println(-1);
        }else{
            pw.println(minTime+" "+meetNode);
        }
        

        
        pw.flush();


    }

    private static int[] Dijkstra(ArrayList<Vertex> Graph, Vertex source, int N){

        int[] dist=new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source.id]=0;
        source.distance=0;
        PriorityQueue<Vertex> priorityQueue=new PriorityQueue<>(Comparator.comparing(v->v.distance));

        priorityQueue.add(source);

        while(!priorityQueue.isEmpty()){
            Vertex u=priorityQueue.poll();


            for(Edge edge : u.neighbor){
                Vertex v=edge.destination;

                if(u.distance+edge.weight<v.distance){
                    v.distance=u.distance+edge.weight;
                    v.parent=u;
                    dist[v.id]=v.distance;
                    priorityQueue.add(v);
                }
            }
        }
        for(Vertex v : Graph){
            if(v!=null) v.distance=Integer.MAX_VALUE;
        }

        return dist;
    }
}

class Vertex{
    int id;
    int distance=Integer.MAX_VALUE;
    Vertex parent;
    ArrayList<Edge> neighbor=new ArrayList<>();
    Vertex(int id){
        this.id=id;
    }
}

class Edge{
    Vertex destination;
    int weight;
    Edge(Vertex destination, int weight){
        this.destination=destination;
        this.weight=weight;
    }
}
