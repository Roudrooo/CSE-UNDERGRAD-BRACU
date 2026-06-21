import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
public class ProbA {
    public static long inverseCount;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);

        StringTokenizer stkr=new StringTokenizer(br.readLine());
        int N=Integer.parseInt(stkr.nextToken());

        stkr=new StringTokenizer(br.readLine());
        int[] A=new int[N];
        for(int i=0;i<N;++i){
            A[i]=Integer.parseInt(stkr.nextToken());
        }
        MargeSort(A);
        pw.println(inverseCount);
        for(int i=0;i<N;++i){
            pw.print(A[i]+" ");
        }
        pw.println();
        pw.close();

    }
    
    private static void MargeSort(int[] inputArray){
        int inputLength=inputArray.length;

        if(inputLength < 2) return;

        int midIndex=inputLength/2;

        int[] leftHalf=new int[midIndex];
        int[] rightHalf=new int[inputLength-midIndex];

        for(int i=0;i<midIndex;++i){
            leftHalf[i]=inputArray[i];
        }
        for(int i=midIndex;i<inputLength;++i){
            rightHalf[i-midIndex]=inputArray[i];
        }

        MargeSort(leftHalf);
        MargeSort(rightHalf);

        Marge(inputArray, leftHalf, rightHalf);

    }

    private static void Marge(int[] inputArray, int[] leftHalf, int[] rightHalf){
        int leftSize=leftHalf.length;
        int rightSize=rightHalf.length;

        int i=0,j=0,k=0;

        while(i<leftSize && j<rightSize){
            if(leftHalf[i]<=rightHalf[j]){
                inputArray[k++]=leftHalf[i++];
            }else{
                inputArray[k++]=rightHalf[j++];
                inverseCount+=leftSize-i;
            }
        }
        while(i<leftSize){
            inputArray[k++]=leftHalf[i++];
        }
        while(j<rightSize){
            inputArray[k++]=rightHalf[j++];
        }
    }
}
