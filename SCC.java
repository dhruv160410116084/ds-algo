import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

class SCC{
    int V;
    LinkedList adjList[];
    Stack stack ;

    SCC(int v){
        V = v;
        adjList = new LinkedList[V];
        stack = new Stack();
        for(int i=0;i<V;i++){
            adjList[i] = new LinkedList();
        }
    }

    void addEdge(int u,int v){
        adjList[u].add(v);

    }

    void print(){
        for(int i=0;i<V;i++){
            System.out.print(i+" -->");
            for(int j=0;j<adjList[i].size();j++){
                System.out.print(" "+adjList[i].get(j)+" |");
            }
            System.out.println();
        }
    }

    void DFS(){
        boolean visited[] = new boolean[V];
        DFSutil(0,visited,false);
    }

    void DFSutil(int v , boolean visited[],boolean isGCC){
        // System.out.println("dfs called");
        visited[v] = true;
        if(isGCC)
            System.out.print(" "+v);
        Iterator<Integer> itr = adjList[v].listIterator();
        while(itr.hasNext()){
            int n = itr.next();
            if(!visited[n])
                DFSutil(n, visited,isGCC);
        }
        if(!isGCC)
            stack.push(v);
    }

    void transpose(){
        // System.out.println("transpose");
        SCC s = new SCC(V);
        for(int v=0;v<V;v++){
            Iterator<Integer> itr = adjList[v].listIterator();
            while(itr.hasNext()){
                s.adjList[itr.next()].add(v);
            }
        }
        
        adjList = s.adjList;
    }

    void getSCC(){
        // System.out.println("gcc called");
        boolean visited[] = new boolean[V];
        while(stack.empty() == false){
            int n = (int)stack.pop();
            if(visited[n] == false){
                System.out.println("called dfs");
                DFSutil(n, visited,true);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        SCC s = new SCC(9);
        // s.addEdge(1, 0);
        // s.addEdge( 0,2);
        // s.addEdge(2, 1);
        // s.addEdge(0,3);
        // s.addEdge(3,4);

        s.addEdge(0, 1);
        s.addEdge(1, 2);
        s.addEdge(2, 3);
        s.addEdge(3, 2);
        s.addEdge(1, 4);
        s.addEdge(4, 5);
        s.addEdge(4, 0);
        s.addEdge(5, 6);
        s.addEdge(6, 5);
        s.addEdge(6, 7);
        s.addEdge(3, 7);
        s.addEdge(7, 7);
        s.addEdge(1, 5);
        s.addEdge(2, 6);



        s.DFS();
        
        s.transpose();
        
        s.getSCC();


    }
   
}