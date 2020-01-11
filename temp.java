//min heap practice
class temp{
    int[] heap;
    int size,curSize;
    public temp(int size){
        this.size = size;
        heap = new int[size];
        curSize=0;
    }

    int parent(int i){
          return i%2 !=0? i/2:(i/2)-1;
    }
    int left(int i){
        return (i*2)+1;
    }
    int right(int i){
        return (i*2)+2;
    }

    void insert(int data){
        if(curSize < size){
            heap[curSize]=data;
            curSize++;
        }
    }


    void heapify(int i){
            int l=left(i);
            int r = right(i);
            System.out.print("parent : "+i+"  left :"+l+"  right :"+r);
            if(i == 1){
                System.out.println("left "+heap[left(i)]+" right "+heap[right(i)]);
            }
            int min=i;
            if(l<curSize && heap[l] < heap[i]){
                System.out.print("in l min");
                min = l;
            }
            if(r<curSize && heap[r] < heap[min]){
                System.out.print("in r min");
                min = r;
            }
         
            if(min != i){
                int temp = heap[min];
                System.out.print("  in recur  ");
                heap[min]=heap[i];
                heap[i]=temp;
                heapify(min);
            }
            System.out.println();
        
    }

    void buildHeap(){
            System.out.println("curSize :"+curSize);
        for(int i=(curSize/2)-1;i>=0;i--){   // only non-leaf needs to heapify 
                heapify(i);
        }
    }


    void print(){
        System.out.println();
    for(int i=0;i<curSize;i++){
        System.out.print(" "+heap[i]);
    }
       System.out.println();
}


public static void main(String[] args) {
    temp min_heap = new temp(11);
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
    min_heap.buildHeap();

    min_heap.print();
}
}