public class MaxHeap{
    private int heap[];
    private int size;

    public MaxHeap(int capacity){
        heap=new int[capacity];
        size=1;
    }

    public void insert(int value){
        if(size==heap.length) System.out.println("Heap is full.");
        else{
            heap[size]=value;
            swim(size);
            size++;
        }
    }

    public void swim(int index){
        if(index>1&&heap[index]>heap[parent(index)]){
            swap(index,parent(index));
            swim(parent(index));
        }
    }

    public void swap(int i,int j){
        int temp=heap[i];
        heap[i]=heap[j];
        heap[j]=temp;
    }

    public int parent(int index){
        return index/2;
    }

    public void sink(int index){
        int largest=index;
        int left=2*index;
        int right=2*index+1;
        if(left<size&&heap[largest]<heap[left]) largest=left;
        if(right<size&&heap[largest]<heap[right]) largest=right;
        if(largest!=index){
            swap(index,largest);
            sink(largest);
        }
    }

    public int extractMax(){
        if(size==0) throw new IllegalStateException("Heap is full");
        int maxValue=heap[1];
        swap(1,size-1);
        size--;
        sink(1);
        return maxValue;
    }

    public void delete(int key){
        boolean flag=false;
        int i=1;
        while(i<size){
            if(key==heap[i]){
                flag=true;
                break;
            }
            i++;
        }
        if(!flag) System.out.println("Not found");
        swap(i,size-1);
        size--;
        sink(i);
    }

    public void heapSort(){
        int originalSize=size;
        for(int i=size-1;i>1;i--){
            swap(1,i);
            size--;
            sink(1);
        }
        size=originalSize;
    }

    public void printHeap(){
        for(int i=1;i<size-1;i++){
            System.out.print(heap[i]+" ");
        }
        System.out.println();
    }

    public void printSorted(){
        heapSort();
        printHeap();
    }

    public int[] nLargest(int k){
        int[] arr=new int[k];
        heapSort();
        int i=size-1,index=0;
        while(k!=0&&i>=1){
            arr[index]=heap[i--];
            k--;
            index++;
        }
        return arr;
    }

}