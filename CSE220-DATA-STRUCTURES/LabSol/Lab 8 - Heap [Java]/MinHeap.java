public class MinHeap{
    private int heap[];
    private int size;

    public MinHeap(int capacity){
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
        if(index>1&&heap[index]<heap[parent(index)]){
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
        int smallest=index;
        int left=2*index;
        int right=2*index+1;
        if(left<size&&heap[smallest]>heap[left]) smallest=left;
        if(right<size&&heap[smallest]>heap[right]) smallest=right;
        if(smallest!=index){
            swap(index,smallest);
            sink(smallest);
        }
    }

    public int extractMin(){
        if(size==0) throw new IllegalStateException("Heap is full");
        int minValue=heap[1];
        swap(1,size-1);
        size--;
        sink(1);
        return minValue;
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

}