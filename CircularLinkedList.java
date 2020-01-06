class CircularLinkedList{
    Node head = null,end=null;

    class Node{
        int data;
        Node next;

        public Node(int data,Node ptr){
            this.data = data;
            next = ptr;
        }
    }


    void insert(int data){
        if(head == null){
            head = new Node(data,head);
            end = head;
            return;
        }
        Node temp = new Node(data,head);
        end.next =temp; 
        end = end.next;
        return ;
    }

    void remove(int data){
        if(head == null){
            System.out.println("list is empty");
            return;
        }
        if(head.data == data){
            head = head.next;
            end.next = head;
            return;
        }
        Node itr = head,prev=null;
        while(itr.data != data){
            prev = itr;
            itr = itr.next;
        }
        prev.next = itr.next;

    }


    void print(){
        Node temp = head;
         if(head != null){
             do{
                 System.out.println(" "+temp.data);
                 temp = temp.next;
             }while(temp != head);
         }
    }

    public static void main(String[] args) {
        CircularLinkedList cll = new CircularLinkedList();
        cll.insert(1);
        cll.insert(2);
        cll.insert(3);
        cll.insert(4);
        cll.insert(5);
        cll.insert(6);
        cll.print();
        System.out.println("----------");
        cll.remove(6);
        
        cll.print();
    }

}