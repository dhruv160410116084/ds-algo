import java.util.*;

class Trie{
    TNode master ;
    public Trie(){
        master = new TNode();
    }
    void insert(String str){
        master.insert(str, master);
    }
    void search(String str){
        master.search(str,master);
    }
    public static void main(String[] args) {
        String arr[] = {"apple", "app", "there", "the", "like"};
        Trie t = new Trie();
        for(int i=0;i<arr.length;i++)
            t.insert(arr[i]);
        t.search("there");
        t.search("dvarc");
        
    }
}

class TNode{
    HashMap<Character,TNode> map;
    boolean isEndHere ;
    public TNode(){
        map= new HashMap<Character,TNode>();
        isEndHere=false;
    }

    void insert(String str,TNode itr){
        int i=0;
        while(i<str.length()-1  &&  itr.map.containsKey(str.charAt(i))){
            itr = itr.map.get(str.charAt(i));
            i++;
        }
        while(i<str.length()-1){
            TNode T = new TNode();
            itr.map.put(str.charAt(i),T);
            itr = T;
            i++;
        }
        itr.isEndHere=true;
    }

    void search(String str,TNode itr){
        int i=0;
        while( i < str.length()-1 &&  itr.map.containsKey(str.charAt(i)) ){
            itr = itr.map.get(str.charAt(i));
            i++;
        }
        if(i < str.length() && itr.isEndHere){
            System.out.println("found");
        }
        else
            System.out.println("Not found");
    }

}