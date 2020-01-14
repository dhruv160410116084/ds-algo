import java.util.LinkedList;
import java.util.Queue;
import java.lang.Math;

class BT {
    Node root;

    public BT() {
        root = null;
    }

    class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }

    }

    Node parent(int key, Node n) {
        Node result=null;
        System.out.println(" " + n.data + "   node discovered");
        if (root == null) {
            System.out.println(" tree is empty");
        }
        if (key == root.data) {
            return null;
        }
        
        if (n.left == null && n.right == null) {
            System.out.println("leaf node  "+n.data);
            return null;
        }
        if (n.left != null && n.left.data == key) {
            System.out.println("parent of " + key + " is " + n.data);
            return n;
        } else if (n.right != null && n.right.data == key) {
            System.out.println("parent of " + key + " is " + n.data);
            return n;
        }
        if (result == null && n.left != null)
            result =  parent(key, n.left);
             if(result == null && n.right != null) 
            result =  parent(key, n.right);
        return result;
        
    }
    Node find(int data,Node n){
        // System.out.println("find in : "+n.data);
        Node result = null;
        // if(n == null)
            // return null;
        if(n.data == data)
            return n;
        if(n.left  != null && result == null){
            result=find(data,n.left);            
            }
            if(n.right != null && result == null)
            result=find(data,n.right);
            return result;

    }

    void insert(int data) {
        if (root == null) {
            root = new Node(data);
            return;
        }
        Queue<Node> q = new LinkedList<Node>();
        Node temp;
        q.add(root);
        while (q.isEmpty() == false) {
            temp = q.poll();
            if (temp.left == null) {
                temp.left = new Node(data);
          
                break;
            } else {
                q.add(temp.left);

            }
            if (temp.right == null) {
                temp.right = new Node(data);
                break;
            } else {
                q.add(temp.right);
            }
        }
    }

    void delete(int data) {
        Node temp=null,parent=null;
        if (root == null) {
            System.out.println("tree is empty");
            return;
        }
        Node n =find(data, root);
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        while(!q.isEmpty()){
             temp = q.poll();
            if(temp.left != null){
                q.add(temp.left);
                parent = temp;
            }
            if(temp.right != null){
                q.add(temp.right);
                parent=temp;
            }
        }
        System.out.println(" Node "+temp.data+" deleted which is parent of "+ parent.data);
        n.data = temp.data;
        if(parent.left != null)
            parent.left = null;
        else
            parent.right = null;
        
    }

    void print() {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        int counter = 0;
        int power = 0;
        int limit = (int) Math.pow((double) 2, (double) power);
        while (!queue.isEmpty()) {
            Node tempNode = queue.poll();

            System.out.print(tempNode.data + "   ");
            counter++;
            if (counter == limit) {
                limit = (int) Math.pow((double) 2, (double) ++power);
                counter = 0;
                System.out.println();
            }
            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }
            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }
        }
        System.out.println();
    }

    void dfs(Node n){
        //inorder traversal
        if(n == null)
            return ;
        dfs(n.left);
        System.out.println(" "+n.data);
        dfs(n.right);
    }

    boolean isMirror(Node n1,Node n2){
      if(n1 == null && n2 == null){
          return true;
      }
      if(n1 != null && n2 != null && n1.data == n2.data)
        return isMirror(n1.left, n2.right) && isMirror(n1.right, n2.left);
    return false;
    }

    public static void main(String[] args) {
        BT t = new BT();
        t.insert(1);
        t.insert(2);
        t.insert(2);
        t.insert(3);
        t.insert(4);
        t.insert(4);
        t.insert(3);
        // t.insert(8);
        // t.insert(9);
        // t.insert(10);
        // t.print();
        // t.delete(1);
         t.print();
        // t.dfs(t.root);
        System.out.println(t.isMirror(t.root.left,t.root.right));
    }

}