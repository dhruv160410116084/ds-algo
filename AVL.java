import java.lang.Math;

class AVL{
    Node root=null;

    class Node{
        Node left;
        Node right;
        int data;
        int BF;
        Node(int data){
            this.data = data;
            left = null;
            right = null;
            BF=1;
        }    
    }

    void insert(int data){
        // System.out.println(" inserted "+data);
        Node n=null;
        if(root == null){
            root = new Node(data);
            // root.BF =0;
            return;
        }
        // root.BF = 0;
        Node temp = root;
        Node p = root;
        while(temp != null){
            p = temp;
            if(data <temp.data)
                temp = temp.left;
            else    
                temp = temp.right;
        }
        if(data < p.data){
            n =  new Node(data);
            p.left =n;

        }
        else{
            n = new Node(data);
            p.right = n;
        }
        // p.BF = 1+Math.max(height(p.left),height(p.right));
        updataBF(p, data);

    }

    int height(Node N) { 
        if (N == null) 
            return 0; 

        return N.BF;
    } 

    void updataBF(Node p,int data){
        while(p != root){
            System.out.println("update for :"+data);
            p.BF = 1+Math.max(height(p.left),height(p.right));
            if(height(p.left) - height(p.right) < -1 || height(p.left) - height(p.right) > 1){
                System.out.println("found cirtical node :"+p.data);
                LL(p,data);
            }
            p = Parent(p.data);
            
        }
        p.BF = 1+Math.max(height(p.left),height(p.right));
        if(height(p.left) - height(p.right) < -1 || height(p.left) - height(p.right) > 1){
            System.out.println("found cirtical node :"+p.data);
            LL(p,data);
        }
    }

    void LL ( Node n,int data){
            // System.out.println(n.left.data);
            if(n.right != null && n.right.right != null && n.right.right.data == data){
                System.out.println(" it is RR rotation");
            }
            if( n.left != null && n.left.left != null && +n.left.left.data == data ){
                System.out.println(" it is LL rotation");
            }
            if( n.left != null && n.left.right != null && +n.left.right.data == data ){
                System.out.println(" it is LR rotation");
            }
            if( n.right != null && n.right.left != null && +n.right.left.data == data ){
                System.out.println(" it is RL rotation");
            }

    }

    Node Parent(int data){
            Node n=root;
            Node p = root;
            if(data == root.data)
                return null;
            while(true){
                if(data == n.data)
                return   p;
                
                if(data < n.data){
                    p = n;
                    n=n.left;
                }
                if(data > n.data){
                    p = n;
                    n=n.right;
                }
            }
    }
    void print(Node n){
        if(n == null )    
            return;
        print(n.left);
            System.out.println(" "+n.data+" BF="+(height(n.left)- height(n.right)));
         print(n.right);
    }

    public static void main(String[] args) {
        AVL t = new AVL();
        t.insert(10);
        t.insert(5);
        t.insert(8);
        t.insert(1);
        t.insert(2);
        t.insert(6);
        t.insert(16);
        t.insert(18);
        t.insert(0);
        t.insert(-1);
        t.print(t.root);
    }

}