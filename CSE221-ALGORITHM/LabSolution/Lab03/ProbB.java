import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
public class ProbB {
    public static long PairsCount;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);

        StringTokenizer stkr=new StringTokenizer(br.readLine());
        int N=Integer.parseInt(stkr.nextToken());

        stkr=new StringTokenizer(br.readLine());
        long[] A=new long[N];
        for(int i=0;i<N;++i){
            A[i]=Long.parseLong(stkr.nextToken());
        }
        MargeSort(A);
        pw.println(PairsCount);
        
        pw.close();

    }
    
    private static void MargeSort(long[] inputArray){
        int inputLength=inputArray.length;

        if(inputLength < 2) return;

        int midIndex=inputLength/2;

        long[] leftHalf=new long[midIndex];
        long[] rightHalf=new long[inputLength-midIndex];

        for(int i=0;i<midIndex;++i){
            leftHalf[i]=inputArray[i];
        }
        for(int i=midIndex;i<inputLength;++i){
            rightHalf[i-midIndex]=inputArray[i];
        }

        MargeSort(leftHalf);
        MargeSort(rightHalf);

        MargeAndCount(inputArray, leftHalf, rightHalf);

    }

    private static void MargeAndCount(long[] inputArray, long[] leftHalf, long[] rightHalf){
        int leftSize=leftHalf.length;
        int rightSize=rightHalf.length;


        long[] squaredRightHalf=new long[rightSize];
        for(int i=0;i<rightSize;++i){
            squaredRightHalf[i]=rightHalf[i]*rightHalf[i];
        }
        Arrays.sort(squaredRightHalf);

        for(int i=0;i<leftSize;++i){
            PairsCount+=countBinary(squaredRightHalf, leftHalf[i]);
        }
        


        int i=0,j=0,k=0;
        
        while(i<leftSize && j<rightSize){
            if(leftHalf[i]<=rightHalf[j]){
                inputArray[k++]=leftHalf[i++];
            }else{
                inputArray[k++]=rightHalf[j++];
            }
        }
        while(i<leftSize){
            inputArray[k++]=leftHalf[i++];
        }
        while(j<rightSize){
            inputArray[k++]=rightHalf[j++];
        }
    }

    private static int countBinary(long[] array, long target){
        int low=0;
        int high=array.length;
        while(low<high){
            int mid=(low+high)/2;
            if(target>array[mid]){
                low=mid+1;
            }else{
                high=mid;
            }
        }
        return low;
    }
}
