import java.util.concurrent.ThreadLocalRandom;

class OrderStatistics{
    int randomizedPartition(int arr[],int p,int r){
        // System.out.println("p :"+p+"r :"+r);
        int rand = ThreadLocalRandom.current().nextInt(p,r+1);
         System.out.println("rand ="+rand+"   "+"p ="+p+"r ="+r);
        arr[r] = arr[r]+arr[rand]-(arr[rand]=arr[r]);
        return partition(arr,p,r);

    }

    int partition(int arr[],int p,int r){
        int x = arr[r];
        int i = p-1;
        for(int j=p ;j<r;j++){
            if(arr[j] <= x){
                i++;
                arr[i]=arr[i]+arr[j]-(arr[j]=arr[i]);

            }
        }
        arr[i+1] = arr[i+1]+arr[r]-(arr[r]=arr[i+1]);
        return i+1;
    }

    int randomizedSelect(int arr[],int p,int r,int i){
        // System.out.println("-----------------------");
        if(p == r)
            return arr[p];
        int q=randomizedPartition(arr, p, r);
        //  pirnt(arr,p,r);
        int k=q-p+1;
        if(i==k)
            return arr[q];
        else if(i < k)
            return randomizedSelect(arr, p, q-1, i);
        else 
            return randomizedSelect(arr, q+1, r, i-k);

    }

    void pirnt(int arr[],int p,int r){
        System.out.println();
        for(int i=p;i<=r;i++){
            System.out.print(" "+arr[i]);
        }
        System.out.println();
    }
    

    public static void main(String[] args) {
        OrderStatistics o = new OrderStatistics();
        int arr[] = {34,8,12,3,90,23,56,77,44,22};
        
        for(int i=0;i<arr.length;i++){
           
            System.out.print(arr[i]+" ");
        }
        // Arrays.sort(arr);
        // o.pirnt(arr,0,arr.length-1);
        System.out.println();
        // for(int i=0;i<arr.length;i++){
            // System.out.println(" for "+i);
            int ans = o.randomizedSelect(arr,0,arr.length-1,8);
            System.out.print(ans+" ");
        // }
        System.out.println();
       
    }

}