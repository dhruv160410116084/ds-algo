public class SinglyLinkedList{
    Node head = null;
    Node itr = null;

    class Node{
        int data;
         Node next;

         Node(int d){
             data = d;
             next = null;
         }
    }

    void append(int data)
    {       if(head == null){
                head = new Node(data);
                itr = head;
                   
            }else{
                    itr.next = new Node(data);
                    itr = itr.next;
            }
    }

    void push(int data){
        if(head == null){
            System.out.println("IF");
            head = new Node(data);
            itr = head;
        }else{
            System.out.println("else");
            Node tmp = new Node(data);
            tmp.next = head;
            head = tmp;
        }
        System.out.println("head :"+head.data);
    }

    void addAfter(Node ref , int data){
        if(ref == null)
            {
                System.out.println("ref node should not be empty");
                return;
            }    
        Node n = new Node(data);
        n.next = ref.next;    
        ref.next = n;
    }

    //add before is not possibe because singly linked is only one way pointing


    void remove (int data){
        Node pre=null,cur=head;
        
        if(cur.data ==data){
            head = cur.next;
            return;
        }
        
        while(data != cur.data){
            pre = cur;
            cur = cur.next;
        }
        if(pre == null)
            return;
        pre.next = cur.next;
    }

    void removeAtPos(int pos){
        int i=0;
        Node pre=null,cur=head;
        if(head == null)
            return;
        
        if(pos == 0){
            head = cur.next;
            return;
        }
        while(i != pos && cur !=null){
                pre = cur;
                cur = cur.next;
                i++;
        }
        pre.next = cur.next;
    }

int  getLength(){
    int counter = 0;
    Node temp = head;
    while(temp!= null){
        counter++;
        temp = temp.next;
    }
    return counter;
}
boolean search(int data){
    Node ptr = head;
    
    if(head == null){
        System.out.println("list is empty");
        return false;
    }
    while(ptr != null){
        if(ptr.data == data)
        {    
            System.out.println("found ");
            return true;
        }  
        ptr = ptr.next;      
    }
    System.out.println("not found");
    return false;
}

    void print(){
        itr = head;    
        while(itr != null){
            System.out.print("   "+itr.data);
            itr = itr.next;
        }
        System.out.println();
    }
    @Override
    protected void finalize() throws Throwable {
        System.out.println("list garbaged");
    }

    public static void main(String[] args) {
        SinglyLinkedList sl = new SinglyLinkedList();
        sl.addAfter(sl.head, -1);
        sl.push(1);
        sl.append(100);
        sl.append(7);
       // sl.addAfter(sl.head.next, 333);
        sl.append(341);
        sl.push(0);
        sl.print();
        sl.removeAtPos(0);
        sl.print();
        // sl = null;    for delete linked list
        // System.gc();
        System.out.println("length of linked list : "+sl.getLength());
        sl.search(37);
    }

}