import java.io.*;
import java.util.*;

public class ProbA {
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
        StringTokenizer stkr=new StringTokenizer(br.readLine());
        int N=Integer.parseInt(stkr.nextToken());
        int K=Integer.parseInt(stkr.nextToken());
        DSU dsu=new DSU(N);
        for(int i=1;i<=K;++i){
            stkr=new StringTokenizer(br.readLine());
            int u=Integer.parseInt(stkr.nextToken());
            int v=Integer.parseInt(stkr.nextToken());
            dsu.UnionBySize(u, v);
            pw.println(dsu.size.get(dsu.findUpar(u)));
        }
        pw.flush();
    }
    
}

class DSU{
    List<Integer> size=new ArrayList<>(), parent=new ArrayList<>();
    public DSU(int N){
        for(int i=0;i<=N;++i){
            size.add(1);
            parent.add(i);
        }
    }
    public int findUpar(int Node){
        if(Node==parent.get(Node)){
            return Node;
        }
        int ulp=findUpar(parent.get(Node));
        parent.set(Node, ulp);
        return parent.get(Node);
    }
    public void UnionBySize(int u, int v){
        int ulp_u=findUpar(u);
        int ulp_v=findUpar(v);

        if(ulp_u==ulp_v){
            return;
        }
        if(size.get(ulp_u)<size.get(ulp_v)){
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_u)+size.get(ulp_v));
        }else{
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u)+size.get(ulp_v));
        }
    }
}
