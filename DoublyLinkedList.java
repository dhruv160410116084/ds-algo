class DoublyLinkedList{

    Node head=null,end=null;

    class Node{
        int data;
        Node prev=null;
        Node next = null;

        public Node(int data){
            this.data = data;
 
        }

        @Override
        protected void finalize() throws Throwable {
            System.out.println(this.data+" node deleted");
        }

    }

    void insert(int data){
        if(head == null){
            head = new Node(data);
            head.prev=null;
            head.next = null;
            end = head;
            return;
        }
        Node temp = new Node(data);
        temp.prev = end;
        end.next = temp;
        end = temp;
        return;

    }

    void remove(int data){
        if(head == null){
            System.out.println("list is empyt");
            return;
        }
        if(head.data == data){
            head = head.next;
            head.prev.next = null;
            head.prev = null;
        }
        if(end.data == data){
           end = end.prev;
            end.next.prev = null;
            end.next = null;

        }
        for(Node itr=head ; itr!= null;itr = itr.next){
            if(itr.data == data){
                // System.out.println("fonund ! "+itr.prev.data);
                 if(itr.prev != null && itr.next != null){
                    itr.prev.next = itr.next;
                    itr.next.prev = itr.prev;
                    itr.next = null;
                    itr.prev = null;
                 }
              
              
                break;
            }
        }

    }



    void print(){
        if(head != null){
            for(Node itr=head ; itr!=null;itr=itr.next){
                System.out.println(" "+itr.data);
            }
        }

    }

    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.insert(1);
        dll.insert(2);
        dll.insert(3);
        dll.insert(4);
        dll.insert(5);
        dll.print();
        dll.remove(5);
        System.gc();
        dll.print();
    }

}