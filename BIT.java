class BIT{
    int arr[],bit[];

    public BIT(int arr[]){
        this.arr = arr;
        bit = new int[arr.length+1];
        constructBIT();
    }

    void constructBIT(){
        for(int i=0;i<arr.length;i++){
                updateBIT(i, arr[i]);
        }
    }

   void updateBIT(int index ,int val){
       index = index+1;
       while(index <= arr.length){
           bit[index] += val;
           index = index +( index&(-index));
       }
   }

   int getRangeSum(int index){
       index++;
       int sum =0;
       while(index > 0){
           sum = sum + bit[index];
           index = index -( index&(-index));
       }
       return sum;
   }
    void print(){
        for(int i=1;i<bit.length;i++){
            System.out.println(bit[i]);
        }
    }

    public static void main(String[] args) {
       int arr[] = {1,2,3,4,5,6};
       BIT t = new BIT(arr);
       System.out.println(" range sum: "+t.getRangeSum(4));
       arr[3] += 6;
       t.updateBIT(3, 6);
       t.print();
       System.out.println(" range sum: "+t.getRangeSum(4));
    }
}