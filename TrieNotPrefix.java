import java.util.*;

public class TrieNotPrefix {
    public static void main(String[] args) {
        MTrie trie = new MTrie();
        String arr[] = {"apple", "app", "the", "there", "like"};
       
      for(int i=0;i<arr.length;i++)
        trie.insert(arr[i]);
    
    for(int i=0;i<arr.length;i++)
        trie.find(arr[i]);
    }
}

class MTrie{
    node master;
    MTrie(){
        master = new node();
    }
    void insert(String str){
        node itr = master;
        int i;
        for(i=0;i<str.length() && itr.map.containsKey(str.charAt(i));i++){
            itr = itr.map.get(str.charAt(i));
            if(itr.isEnd == true){
                itr.isEnd=false;
                // return;
            }
        }
        if(i == str.length() && itr.map.size() > 0){
            // itr.map.clear();
            return;
        }

        for(i=i;i<str.length() && !itr.map.containsKey(str.charAt(i));i++){
            node t = new node();
            itr.map.put(str.charAt(i),t);
            itr = t;
        }
        itr.isEnd=true;
       

    }
    void find(String str){
        node itr = master;
        int i;
        for(i=0;i<str.length() && itr.map.containsKey(str.charAt(i));i++){
            itr = itr.map.get(str.charAt(i));
        }
        if(i==str.length() && itr.isEnd)
            System.out.println( str+ " is  found");
        // else
        //     System.out.println(str + " is not found");

    }
    class node{
        HashMap<Character,node> map;
        boolean isEnd;
        node(){
            map = new HashMap<Character,node>();
            isEnd = false;
        }   
    }
}





