import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class ProbGG{
    static int pi=0;
    static class T{
        int v;T l,r;
        T(int v){this.v=v;}
    }
    public static void main(String[]args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
        int n=Integer.parseInt(br.readLine());
        int[]in=new int[n],pre=new int[n];
        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;++i)in[i]=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;++i)pre[i]=Integer.parseInt(st.nextToken());
        T root=build(in,pre,0,n-1);
        post(root,pw);
        pw.println();
        pw.close();
    }
    static T build(int[]in,int[]pre,int l,int r){
        if(l>r)return null;
        T node=new T(pre[pi++]);
        int m=idx(in,l,r,node.v);
        node.l=build(in,pre,l,m-1);
        node.r=build(in,pre,m+1,r);
        return node;
    }
    static int idx(int[]a,int l,int r,int v){
        for(int i=l;i<=r;++i)if(a[i]==v)return i;
        return -1;
    }
    static void post(T t,PrintWriter pw){
        if(t==null)return;
        post(t.l,pw);
        post(t.r,pw);
        pw.print(t.v+" ");
    }
}