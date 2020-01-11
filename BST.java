import java.util.Queue;
import java.util.LinkedList;

class BST{
        Node root=null;
        int node_ctr=0;

    class Node{
        Node parent ,left ,right;
        int data,level;
        public Node(int data){
            this.data = data;
            left = null;
            right=null;
            level = 0;
        }
    }

    void insert (int data){
        if(root == null){
            root = new Node(data);
            root.parent = null;
            return;
        }
        Node itr=root,itr2=root;
        while(itr != null){
            itr2=itr;
            if(  data <itr.data){
                itr = itr.left;
            }
            else if(data >= itr.data){
                itr = itr.right;
            }
        }
        if( data < itr2.data){
                itr2.left = new Node(data);
                itr2.left.parent =itr2;
                itr2.left.level = itr2.level+1;

        }else{
            itr2.right = new Node(data);
            itr2.right.parent =itr2;
            itr2.right.level = itr2.level+1;
        }
        node_ctr++;
    }


    Node getMinimum(Node temp){
        // System.out.println("-->"+temp);
        if(temp == null)
             temp = root;
        while(temp.left != null){
            temp = temp.left;
        }
        return temp;
    }

    Node getMaximum(Node temp){
        if(temp == null)
             temp = root;
        while(temp.right != null){
            temp = temp.right;
        }
        return temp;
    }

    Node getSuccessor(Node n){
        if(n.right != null){
            return getMinimum(n.right);
        }
        Node p = n.parent;
        while(p != null && n == p.right){
            n=p;
            p=p.parent;
        }
        return p;
    }

    Node getPredecessor(Node n){
        if(n.left != null){
            return getMaximum(n.left);
        }
        Node p = n.parent;
        while(p != null && n == p.left){
            n=p;
            p=p.parent;
        }
        return p;
    }

    void print( ){
        // Queue q = new Queue(node_ctr);
        // Node n = root;
        // Node ln,rn;

        // System.out.println(" "+n.data);
        // if(n.left != null){
        //     System.out.println("in left");
        //     ln = n.left;
        //     System.out.println(" "+ln.data);
        // }
        // if(n.right != null){
        //     System.out.println("in right");
        //     rn = n.right;
        //     System.out.println(" "+rn.data);
        // }
        Queue<Node> queue = new LinkedList<Node>(); 
        queue.add(root); 
        int prevLevel=0;
        while (!queue.isEmpty())  
        { 
  
            Node tempNode = queue.poll(); 
           
            if(prevLevel != tempNode.level){
                System.out.println();
                prevLevel = tempNode.level;
            } 
            System.out.print(tempNode.data+ "   ");

            /*Enqueue left child */
            if (tempNode.left != null) { 
                queue.add(tempNode.left); 
            } 
  
            /*Enqueue right child */
            if (tempNode.right != null) { 
                queue.add(tempNode.right); 
            } 
        }
        System.out.println(); 
        
    }

    void log(String s){
        System.out.println(s);
    }
    public static void main(String[] args) {
        BST t = new BST();
        t.insert(10);
        t.insert(7);
        t.insert(1);
        t.insert(45);
        t.insert(56);
        t.insert(7);
        t.insert(9);
        t.insert(3);
        t.print();
        t.log("min: "+t.getMinimum(null).data);
        t.log("max: "+t.getMaximum(null).data);
        t.log("successor: "+t.getSuccessor(t.root).data);
        t.log("predesessor: "+t.getPredecessor(t.root).data);
    }

}