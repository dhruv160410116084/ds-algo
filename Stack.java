class Stack{

    int size=-1,arr[],top=-1;

    public Stack(int size){
        arr = new int[size];
        this.size = size;
    }

    void push(int data){
        if(top < size-1){
            arr[++top] = data;
        }
        return;
    }

    void pop(){
        if(top != -1){
            top--;
        }
    }

    void peek(){
        if(top > -1)
            System.out.println("top is :"+arr[top]);
    }

    void print(){
        System.out.println("called");
        for(int i=0;i<=top;i++){
            System.out.print(" "+arr[i]);

        }
        System.out.println();
    }

    public static void main(String[] args) {
        Stack s = new Stack(7);
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        s.push(6);
        s.push(7);
         s.push(8);
         s.push(9);
        s.print();
        s.pop();
        s.pop();
        s.print();
        s.peek();
    }
}