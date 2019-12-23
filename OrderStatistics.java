import java.lang.Math;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;



class OrderStatistics{
    
        int getMinimum(int arr[]){  //O(n)
            int min = arr[0];
            for(int i=1;i<arr.length;i++){
                if(arr[i]<min)
                    min = arr[i];
            }
            return min;
        }

        int getMaximum(int arr[]){  //O(n)
            int max = arr[0];
            for(int i =1;i<arr.length;i++)
                if(arr[i]>max)
                    max = arr[i];
            return max;
        }

        int[] getMinAndMax(int arr[]){
            int min = arr[0];
            int max = arr[0];
            System.out.println(arr.length);
            for(int i=1;i<(arr.length);i=i+2){
                System.out.println(" i="+i+" arr["+i+"] ="+arr[i]+" arr["+(i+1)+"] ="+arr[i+1]);
                if(arr[i] < arr[i+1]){
                    if(arr[i] < min)
                        min = arr[i];
                    if(arr[i+1] > max)
                        max = arr[i]+1;
                    
                }
                if(arr[i] > arr[i+1]){
                    if(arr[i] > max)
                        max = arr[i];
                    if(arr[i+1] < min)
                        min = arr[i+1];
                 }
            }
            int[] minMax = {min,max};
            return  minMax;
        }


    

    public static void main(String[] args) {
        OrderStatistics o = new OrderStatistics();
        int arr[] = {34,56,8,12,3,90,23,56,77,44,22};
        int a[] = o.getMinAndMax(arr);
        System.out.println("min : "+o.getMinimum(arr)+"  : "+o.getMaximum(arr)+"  both: "+a[0]+" "+a[1]);
        
    }

}