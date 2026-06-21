import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class ProbDD {
    static final long MOD=1000000007L;

    public static void main(String[]args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);

        int t=Integer.parseInt(br.readLine());
        while(t-->0){
            StringTokenizer st=new StringTokenizer(br.readLine());
            long a11=Long.parseLong(st.nextToken());
            long a12=Long.parseLong(st.nextToken());
            long a21=Long.parseLong(st.nextToken());
            long a22=Long.parseLong(st.nextToken());
            long x=Long.parseLong(br.readLine());

            long[] res=matPow(a11,a12,a21,a22,x);
            pw.println(res[0]+" "+res[1]);
            pw.println(res[2]+" "+res[3]);
        }
        pw.close();
    }

    static long[] matMul(long a11,long a12,long a21,long a22,long b11,long b12,long b21,long b22){
        long c11=(a11*b11%MOD + a12*b21%MOD)%MOD;
        long c12=(a11*b12%MOD + a12*b22%MOD)%MOD;
        long c21=(a21*b11%MOD + a22*b21%MOD)%MOD;
        long c22=(a21*b12%MOD + a22*b22%MOD)%MOD;
        return new long[]{c11,c12,c21,c22};
    }

    static long[] matPow(long a11,long a12,long a21,long a22,long n){
        long r11=1,r12=0,r21=0,r22=1; // Identity matrix
        long b11=a11,b12=a12,b21=a21,b22=a22;
        while(n>0){
            if((n&1)==1){
                long[] t=matMul(r11,r12,r21,r22,b11,b12,b21,b22);
                r11=t[0]; r12=t[1]; r21=t[2]; r22=t[3];
            }
            long[] t=matMul(b11,b12,b21,b22,b11,b12,b21,b22);
            b11=t[0]; b12=t[1]; b21=t[2]; b22=t[3];
            n>>=1;
        }
        return new long[]{r11,r12,r21,r22};
    }
}