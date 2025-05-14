package ir.dsa.arrays;

import java.util.*;

public class TwoDarray {

    public static void main(String[] args) {
        System.out.println("welcome to 2D arrays:");
        int[] arr = {10,12,15,19,21,25,27,32};
        int[] arr1 = {10,20,20,30,40,40,40,50};
     //   System.out.println("found at:"+ binarySearch(arr, 32));
     //   System.out.println("found at:"+ binarySearch2(arr, 32, 0, arr.length));
     //   ceilFloor(arr, 22);
     //   firstLastIndex(arr1,40);

        int[] arr2 = {1,1,2,2,2,3,5};
        int[] arr3 = {1,1,1,2,2,4,5};
    //    commonEle(arr2, arr3);
        int[] arr4 = {10,5,9,1,11,8,6,15,3,12,2};
    //    longConsSeq(arr4);
        int[] arr5 = {20,30,40,50,10};
        find(arr5);
    }

    private static int binarySearch(int[] arr, int key){

        int l = 0;
        int r = arr.length-1;


        while(l<=r){
            int mid = (r+l)/2;
            if(arr[mid] == key){
                return mid;
            }
            else if(arr[mid] > key){
                r = mid-1;
            } else{
                l = mid+1;
            }
        }
        return -1;
    }

    private static int binarySearch2(int[] arr, int key, int l, int r){

        if(l>r){
            return -1;
        }
        int mid = (r+l)/2;
        if(arr[mid] == key){
            return mid;
        } else if(arr[mid] > key){
            return binarySearch2(arr, key, l, mid-1);
        } else{
            return binarySearch2(arr, key, mid+1, r);
        }

    }

    private static void ceilFloor(int[] arr, int key){

        int ceil = 0;
        int floor = 0;

        int l = 0;
        int r = arr.length-1;

        while(l<=r){
            int mid = (r+l)/2;
            if(arr[mid] == key) {
                ceil = arr[mid];
                floor = arr[mid];
                break;
            }
            else if(arr[mid] > key){
                r = mid-1;
                ceil = arr[mid];
            } else{
                l = mid+1;
                floor = arr[mid];
            }
        }

        System.out.println("floor:" + floor);
        System.out.println("ceiling:" + ceil);
    }

    private static void firstLastIndex(int arr[], int key){
        int l = 0;
        int r = arr.length-1;
        int fi = -1;
        int li = -1;


        // for first index
        while(l<=r){
            int mid = (r+l)/2;
            if(arr[mid] == key){
               fi = mid;
               r = mid-1;
            }
            else if(arr[mid] > key){
                r = mid-1;
            } else{
                l = mid+1;
            }
        }

        l = 0;
        r = arr.length-1;

        // for last index
        while(l<=r){
            int mid = (r+l)/2;
            if(arr[mid] == key){
                li = mid;
                l = mid+1;
            }
            else if(arr[mid] > key){
                r = mid-1;
            } else{
                l = mid+1;
            }
        }

        System.out.println("1st index:" + fi);
        System.out.println("Last index:" + li);
    }

    // get common element in 2 arrays
    // ex: a1 = {1,1,2,2,2,3,5} a2 = {1,1,1,2,2,4,5}

    private static void commonEle(int[] arr1,  int[] arr2){

        Map<Integer,Integer> freMap = new HashMap<>();
        for(int val : arr1){
            if(freMap.containsKey(val)){
                int fre = freMap.get(val);
                fre++;
                freMap.put(val,fre);
            } else{
                freMap.put(val,1);
            }
        }

        for(int val2 : arr2){
            if(freMap.containsKey(val2)){
                System.out.print(val2 + " ");
                freMap.remove(val2);
            }
        }
    }

    // longest consecutive sequence using hashmap

    private static void longConsSeq(int[] arr){

        Map<Integer,Boolean> map = new HashMap<>();
        for(int val : arr){
            map.put(val,true);
        }

        for(int val : arr){
            if(map.containsKey(val-1)){
                map.put(val,false);
            }
        }


        List<Integer> seq = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        Set<Integer> keys = map.keySet();
        for(int key : keys){
            if(map.get(key) == true){
                int temp = key;
                while(map.containsKey(temp)){
                    seq.add(temp);
                    temp++;
                }
                if(seq.size() > max){
                    max = seq.size();
                }
                seq = new ArrayList<>();
            }
        }

        System.out.println("long seq size:" + max);
    }

    // pivot of sorted rotated array in logn
    private static void find(int[] arr){

        int lo = 0;
        int hi = arr.length-1;

        while(lo<hi){
            int mid = lo + (hi-lo)/2;
            if(arr[mid] < arr[hi]){
                hi  = mid;
            } else{
                lo = mid+1;
            }
        }
        System.out.println("pivot is:" + arr[hi]);

    }
}
