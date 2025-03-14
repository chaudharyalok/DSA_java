package ir.dsa.patterns;

import java.util.ArrayList;

public class SlidingWindow {
    public static void main(String args[]) {
        System.out.println("Hello in sliding window world!");
        JJJ(new int[]{2,9,3,8,1,7},3);
   //     HHH();
    }

    public static void HHH(){
        System.out.println(128 == 128);
    }

    private static void JJJ(int arr[], int k){

        ArrayList<Integer> result = new ArrayList<>();

        int i=0;
        int j=k;

        while(i+k<=arr.length){
            int max = Integer.MIN_VALUE;
            for(int l=i; l<j; l++){
                if(arr[l]>max){
                    max = arr[l];
                }
            }
            result.add(max);
            i++;
            j++;

        }

        System.out.println(result);
    }
}
