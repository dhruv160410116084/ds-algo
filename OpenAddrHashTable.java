class OpenAddrHashTable{
    private int totalsize,currentSize;
    private CustomHashTable hashTable;

    public OpenAddrHashTable(int totalsize){
        this.totalsize = totalsize;
        currentSize = 0;
        hashTable = new CustomHashTable(totalsize);
        
    }

    int hash(int data,int i){
        //linear probing with division method
        return ((data % totalsize)+i) % totalsize;
    }

    void put(int data){
        int i=0;
        int key ;
        while(i != totalsize){
            key = hash(data, i);
            if(hashTable.insert(key, data))
                    return;
            else
                i++;
        }
        System.out.println("Hash table is full, Can't able to insert  "+data);
        return;
    }

    void print(){
        System.out.println("called");
        hashTable.print();
    }

    public static void main(String[] args) {
        OpenAddrHashTable ht = new OpenAddrHashTable(11);
        ht.put(123);
        ht.put(78);
        ht.put(29);
        ht.put(99);
        ht.put(563);
        ht.put(100);
        ht.put(98);
        ht.put(26);
        ht.put(456);
        ht.put(12);
        ht.put(32);
        ht.put(777);
        ht.print();
    }

}

class CustomHashTable{
    int dataTable[],infoTable[],size,curSize;
    static int NIL=0,DELETED=1,OK=2;
    CustomHashTable(int size){
        dataTable = new int[size];
        infoTable = new int[size];
        this.size = size;
        curSize = 0;
    }

    boolean insert(int index,int data){
       
       
           if(curSize <= size && infoTable[index] == NIL ){
               dataTable[index] = data;
               infoTable[index] = OK;
               curSize++;
               return true;
           }else{
            
            return false;
           }
    }
    void print(){
        System.out.println("size of hashtable: "+curSize);
        for(int i=0;i<size;i++){
            System.out.println("info: "+infoTable[i]+" data: "+dataTable[i]);;
        }
    }
}