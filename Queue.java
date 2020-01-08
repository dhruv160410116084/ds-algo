class Queue{
    int arr[],front,rear,size,count;

    public Queue(int size){
        this.size = size;
        front=-1;
        rear=-1;
        arr = new int[size];
        count = 0;
    }

    void enqueue(int data){
        //  System.out.println("enqueue of "+data+"front: "+front+"rear :"+rear);
        if(front == -1){
            front++;
        }
        if(count < size){
            arr[rear = (1+rear)%(size)] = data;
            count++;
            // System.out.println("front : "+front+"rear :"+rear+" for data : "+data);
        }
    }

    void dequeue(){
        if(front > -1){
            System.out.println(arr[front]+"  dequeued \n");
            front = (front +1)%(size);
            count--;
        }
    }

    void print(){
        int i=front;
        int ctr=0;
        System.out.println("fornt: "+front+"rear : "+rear);
        while( count != ctr){
            System.out.println(" "+arr[i]);
            i = (1+i)%(size);
            ctr++;
        }
        // System.out.println(" "+arr[i]);
    }


    public static void main(String[] args) {
        Queue q = new Queue(7);
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);
        q.enqueue(6);
        q.enqueue(7);
        q.enqueue(8);
        q.print();
        q.dequeue();
        q.dequeue();
        q.enqueue(9);
        q.print();
    }


}