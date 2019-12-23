class MaxPriorityQueueHeap{
    private int Heap[];
    private int totalSize;
    private int curSize;

    public MaxPriorityQueueHeap(int size){
        Heap = new int[size+1];
        totalSize = size+1;
        curSize = 0;
    }

    int parent(int i){
        return i/2;
    }

    int left(int i){
        return i*2;
    }

    int right(int i){
        return (i*2)+1;
    }


    void insert(int key){
        if(curSize < totalSize){
            curSize ++;
            Heap[curSize] = Integer.MIN_VALUE;
            increseKey(curSize,key);
        }else{
            System.out.println("Heap is full");
        }
    }

    void increseKey(int i,int key){
        if(key < Heap[i]){
            System.out.println("new key is smaller than current key");
            return;
        }
        Heap[i] = key;
        while (i>1 && Heap[parent(i)] < Heap[i]){
            Heap[i] = Heap[i] + Heap[parent(i)] - (Heap[parent(i)] = Heap[i]);
            i = parent(i);
        }
    }

    int extractMax(){
        if (curSize < 1){
            System.out.println("heap underflow");
            return Integer.MIN_VALUE;
        }
        int max = Heap[0];
        Heap[0] = Heap[curSize];
        curSize--;
        maxHeapify(1);
        return max;
    }

    void maxHeapify(int pos){
        int l = left(pos);
        int r = right(pos);
        int largest;
        if(l<= totalSize && Heap[l] > Heap[pos])
            largest = l;
        else 
            largest = pos;
        if(r <= totalSize && Heap[r] > Heap[largest])
            largest = r;
        if(largest != pos){
            int temp = Heap[pos];
            Heap[pos] = Heap[largest];
            Heap[largest] = temp;
            maxHeapify(largest);
        }
    }

    void print(){
        System.out.println("priority queue: ");
        for(int i=1;i<=curSize;i++){
            System.out.print("  "+Heap[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MaxPriorityQueueHeap q = new MaxPriorityQueueHeap(10);
        q.insert(7);
        q.insert(98);
        q.insert(67);
        q.insert(2);
        q.insert(6);
        q.insert(8);
        q.insert(23);
        q.insert(19);
        q.insert(55);
        q.insert(6);
        q.print();
        q.increseKey(10, 100);
        q.print();
    }
}