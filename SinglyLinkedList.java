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
        System.out.println("+++++"+ref.data+" ");
        n.next = ref.next;    
        ref.next = n;
    }

    //add before is not possibe because singly linked is only one way pointing

    void print(){
        itr = head;    
        while(itr != null){
            System.out.print("   "+itr.data);
            itr = itr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        SinglyLinkedList sl = new SinglyLinkedList();
        sl.addAfter(sl.head, -1);
        sl.push(1);
        sl.append(100);
        sl.append(7);
        sl.addAfter(sl.head.next, 333);
        sl.append(341);
        sl.push(0);
        sl.print();
        // System.out.println(" --"+sl.head.next.next.data);
    }

}