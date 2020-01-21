import java.lang.Math;

class ST{
    int st[];
    int size;
    ST(int arr[]){
        int x =(int) Math.ceil(Math.log(arr.length)/Math.log(2));
        size = 2 * (int) Math.pow(2, x) - 1;
        st = new int[size];
        constructST(arr, 0, arr.length-1, 0);
    }

    int constructST(int arr[],int s,int e,int i){
        if(s == e){
            st[i] =arr[s]; 
            return arr[s];
        }
        int mid = (s+e)/2;
        st[i] = constructST(arr, s, mid, i*2+1) + constructST(arr, mid+1, e, 2*i+2);
        return st[i];
    }

    int getSum(int arr[],int start,int end){
            if(start > end || end < start){
                return 0;
            }    
        if(start == end){
                    return arr[start];
            }
            int mid = (start+end)/2;
            return getSum(arr, start, mid) + getSum(arr, mid+1, end);
    }
    void printST(){
        System.out.println();
        for(int i=0;i<st.length;i++){
            System.out.print(" "+st[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6};
        ST t = new ST(arr);
        t.printST();
        System.out.println("sum of range"+t.getSum(arr,2,4));
    }

}