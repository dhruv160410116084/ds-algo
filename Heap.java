class Heap{
    int heapSize,curSize,heapArr[];
    int front = 1;
    public Heap(int size){
        heapSize = size+1;
        curSize = 0;
        heapArr = new int[heapSize];
        heapArr[0]=Integer.MIN_VALUE;// because 0th indexing not work for finding parent of elements
    }
    int left(int i){
        return  (2*i);
    }

    int right(int i){
        return (2*i)+1;
    }

    int parent(int i){
        return i/2;
    }

    void insert(int ele){
        if(curSize < heapSize){
            curSize++;
            heapArr[curSize] = ele;
        } 
        else
                System.out.println("Heap is full");
    }



    void print(){
            System.out.println();
        for(int i=1;i<=curSize;i++){
            System.out.print(" "+heapArr[i]);
        }
           System.out.println();
    }

    int get(){
        return heapArr[1];
    }
}

class MinHeap extends Heap{
    
    MinHeap(int heapSize){
        super(heapSize);
    }
    
    void minHeapify(int i){

            int min,temp;
            int l = super.left(i);
            int r = super.right(i);
            //System.out.println("l="+l+" r="+r);
            if(l < heapSize && super.heapArr[i] > super.heapArr[l])
                min=l;
            else 
                min = i;
            if( r < heapSize && super.heapArr[r] < super.heapArr[min] )
                min = r;
            if(min != i){
           // System.out.println("min="+min);
                temp = super.heapArr[i];
                super.heapArr[i] = super.heapArr[min];
                super.heapArr[min] = temp;
                minHeapify(min);  //to reflect heap property through leaf
            }            
        
    }
        void buildHeap(){
            
        for(int i=(super.curSize/2);i>=1;i--){   // only non-leaf needs to heapify 
                minHeapify(i);
        }
    }

    int extractMin(){
        int min = super.heapArr[super.front];
        super.heapArr[super.front] = super.heapArr[super.curSize--];
        minHeapify(super.front);
        return min;
    }
    

    public static void main(String args[]){
        MinHeap min_heap = new MinHeap(11);
        min_heap.insert(32);
        min_heap.insert(2);
        min_heap.insert(4);
        min_heap.insert(66);
        min_heap.insert(8);
        min_heap.insert(9);
        min_heap.insert(10);
        min_heap.insert(45);
        min_heap.insert(65);
        min_heap.insert(23);
        min_heap.insert(1);
        
        System.out.println("intital arr:");
        min_heap.print();

        min_heap.buildHeap();
        System.out.println("\nfinal min:");
        min_heap.print();
        System.out.println("\nget min="+min_heap.get()+"\n");
        min_heap.extractMin();
        System.out.println("extracted min="+min_heap.extractMin());
        min_heap.print();

    }
}

class MaxHeap extends Heap{

public MaxHeap(int heapSize){
    super(heapSize);
}

void maxHeapify(int i){
        int max,temp;
        int l = super.left(i);
        int r = super.right(i);
        if(l < heapSize && super.heapArr[l] >super.heapArr[i])
            max=l;
        else 
            max = i;
        if(r < heapSize && super.heapArr[r] > super.heapArr[max])
            max=r;
        if(max != i){
            temp = super.heapArr[i];
            super.heapArr[i] = super.heapArr[max];
            super.heapArr[max]=temp;
            maxHeapify(max);
        }
    }

    void buildHeap(){
    
        for(int i=(super.curSize/2);i>=1;i--){   // only non-leaf needs to heapify 
                maxHeapify(i);
             }
    }

    int extractMax(){
        int max = super.heapArr[super.front];
        super.heapArr[super.front] = super.heapArr[super.curSize--];
        maxHeapify(super.front);
        return max;
    }

public static void main(String args[]){
        MaxHeap max_heap = new MaxHeap(11);
        max_heap.insert(32);
        max_heap.insert(2);
        max_heap.insert(4);
        max_heap.insert(66);
        max_heap.insert(8);
        max_heap.insert(9);
        max_heap.insert(10);
        max_heap.insert(45);
        max_heap.insert(65);
        max_heap.insert(23);
        max_heap.insert(1);
        System.out.println("intital arr:");
        max_heap.print();

        max_heap.buildHeap();
        System.out.println("\nfinal max:");
        max_heap.print();
        System.out.println("\nget max="+max_heap.get()+"\n");
        System.out.println("extracted max="+max_heap.extractMax());
        max_heap.print();

    }
}