// it has three function create-set , find,union

class DisjointSet{
    int parent[];

    DisjointSet(int arr[]){
        this.parent = new int[arr.length];
        makeSet();
    }

    void makeSet(){
        for(int i=0;i<parent.length;i++){
            parent[i] = i;
        }
    }

    int find(int x){
        if(parent[x] == x)
            return x;
        else    
            return find(parent[x]);
    }

    void  union(int x,int y){
        if(find(x) != find(y)){
            // System.out.println("  parent["+parent[y]+"]"+" = "+x);
            parent[x] = y;
        }
    }

    void print(){
        for(int i=0;i<parent.length;i++){
            System.out.println(" "+i+" parent :"+parent[i]);
        }
    }

    public static void main(String[] args) {
        int arr[] = {0,1,2,3,4,5,6,7};

        DisjointSet d = new DisjointSet(arr);
        //before union
        System.out.println(" parent of 3 :"+d.find(3));
        System.out.println(" parent of 6 :"+d.find(6));
        d.union(1, 4);
        d.union(0,1);
        d.union(6, 7);
        d.union(3, 7);
        d.print();
        if(d.find(0) == d.find(6)){
            System.out.println("true");
        }
    }

}