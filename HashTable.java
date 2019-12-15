import java.lang.Math;

class HashTable{
    private SinglyLinkedList  table[];
    private int m ;
    private String method;

    
    public HashTable(int m , String method){   
        table = new SinglyLinkedList[m];
        this.m = m;
        this.method = method;
        for(int i=0;i<m;i++){
            table[i] = new SinglyLinkedList();
        }
    }
    int hash(int data){
        if(method.equals("division"))
            return data % m; //division method
        else if(method.equals("universal")){ // UNIVERsal method under developement
            int p = 23;
            int b= (int)Math.floor(p*Math.random());
            int a = (int)Math.floor(p*Math.random());
            while(a == 0){
                a = (int)Math.floor(p*Math.random());
            }
            return (((a*data)+b)%p) % m;
        
        }
        
        
            else {
            double tmp = 0.618 * (double)data; //multiplication
            double frac =   tmp % 1;
            double key = Math.floor((double)10*frac);
            return (int)key;
        }
    }

    void put(int data){
        int key = hash(data);
        table[key].add(data);
    }

    void print(){
        for(int i = 0;i<m;i++){
            System.out.print("key="+i +"  size="+table[i].listSize +"    " );
            table[i].print();
        }
    }

    boolean search(int data){
        int key = hash(data);
        return table[key].search(data);
    }

    public static void main(String[] args){
        HashTable ht = new HashTable(10,"universal");
        ht.put(123);
        ht.put(78);
        ht.put(29);
        ht.put(99);
        ht.put(563);
        ht.put(100);
        ht.put(98);
        ht.put(26);
        ht.put(456);
        ht.put(12);
        ht.put(32);
        ht.put(777);
        ht.print();
        
        System.out.println("is 100 in ht="+ht.search(100));
        System.out.println("is 33 in ht="+ht.search(33));
    }
}

 class Node{
            Node ref;
            int data;
            public Node(int data){
                this.data = data;
            }
        }

class SinglyLinkedList{
    int listSize = 0;
    Node current = null;
    Node head = null;

    void add(int data){
        listSize++;
        Node n = new Node(data);
        if(listSize == 1){
            head = n;
        }
        if(listSize > 1){
            current.ref = n;
        }
        current = n;    
    }

    void print(){
        Node visitor=head;
        for(int i=1;i<=listSize;i++ ){
            System.out.print(visitor.data+"->");
            visitor = visitor.ref;
        }
        System.out.println();
    }

    boolean search(int data){
        Node visitor = head;
        for(int i=1;i<=listSize;i++){
            if(data == visitor.data)
                return true;
            else
                visitor = visitor.ref;
        }
        return false;
    }
}

