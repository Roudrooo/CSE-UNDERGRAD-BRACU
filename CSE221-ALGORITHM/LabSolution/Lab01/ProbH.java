import java.util.Scanner;

public class ProbH{
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        int N=input.nextInt();
        input.nextLine();
        String[] annc=new String[N],name=new String[N];
        double[] time=new double[N];
        for(int i=0;i<N;++i){
            name[i]="";
        }
        for(int i=0;i<N;++i){
            annc[i]=input.nextLine();
            int l=annc[i].length();
            for(int j=0;j<l;++j){
                if(annc[i].charAt(j)==' '){
                    break;
                }
                name[i]+=annc[i].charAt(j);
            }
            int p=1;
            for(int j=l-1;j>-1;--j){
                if(annc[i].charAt(j)==' '){
                    break;
                }
                if(annc[i].charAt(j)==':') continue;
                time[i]+=((int)annc[i].charAt(j)-48)*Math.pow(10,p++);
                if(time[i]==0) time[i]+=24;
            }
        }
        for(int i=0;i<N-1;++i){
            for(int j=0;j<N-1-i;++j){
                int l1=name[j].length(),l2=name[j+1].length();
                int idx=j;
                boolean check=true;
                for(int k=0;k<l1 && k<l2;++k){
                    if(name[j].charAt(k)>name[j+1].charAt(k)){
                        idx=j+1;
                        check=false;
                        break;
                    }else if(name[j].charAt(k)<name[j+1].charAt(k)){
                        check=false;
                        break;
                    }
                }
                
                if(l1>l2 && check) idx=j+1;

                if(idx!=j){
                    String temp=name[j];
                    name[j]=name[idx];
                    name[idx]=temp;
                    double temp2=time[j];
                    time[j]=time[idx];
                    time[idx]=temp2;
                    temp=annc[j];
                    annc[j]=annc[idx];
                    annc[idx]=temp;
                }
            }
        }

        int z=0;
        while(z<N){
            int cnt=z;
            while(cnt<N && name[z].equals(name[cnt])) cnt++;
            for(int j=z;j<cnt-1;++j){
                int idx=j;
                for(int k=j+1;k<cnt;++k){
                    if(time[idx]<time[k]){
                        idx=k;
                    }
                }
                if(idx!=j){
                    String temp=name[j];
                    name[j]=name[idx];
                    name[idx]=temp;
                    double temp2=time[j];
                    time[j]=time[idx];
                    time[idx]=temp2;
                    temp=annc[j];
                    annc[j]=annc[idx];
                    annc[idx]=temp;
                }
            }
            z=cnt;
        }
        for(int i=0;i<N;++i){
            System.out.println(annc[i]);
        }

    }
}