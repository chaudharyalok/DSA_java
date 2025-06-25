package ir.dsa.arrays;

public class BubbleSort {

    public static void main(String args[]) {
        System.out.println("welcome to heaps!");
        int[] arr = {7,10,2,1,9,3};
    //    bubblesort(arr);
   //     selectionsort(arr);
   //     insertionsort(arr);
   //     mergeSort(arr, 0, arr.length-1);


        int[] arr1 = {8,5,1,3,7,2,9,6};
  //      System.out.println(arr1[partitioning(arr1, 6, 0, 7)]);


/*        quickSort(arr1, 0, arr1.length-1);
        for(int v : arr1) {
            System.out.print(v + " ");
        }*/
   //     quickSelect(arr1, 0, arr1.length-1, 5-1);
       // System.out.println("kth smallest element:"+r);
    //    int[] arr2 = {9,6,3,5,3,4,3,9,6,4,6,5,8,9,9};
     //   countSort(arr2);
        int[] arr3 = {12,234,7,9875,32};
     //   radixSort(arr3);

        String[] dates = {"12041996","20101996","05061997","12041989","11081987"};
        dateSort(dates);
    }

    private static void bubblesort(int[] arr){
        for(int i =1; i <= arr.length-1; i++){
            for(int j =0; j < arr.length - i; j++){
                if(isSmaller(arr, j+1,j)){
                    swap(arr, j+1, j);
                }
            }
        }
    }

    private static void selectionsort(int[] arr){
        for(int i = 0; i< arr.length-1; i++){
            int minIndex = i;
            for(int j = i+1; j< arr.length; j++){
                if(isSmaller(arr, j, minIndex)){
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }

    private static void insertionsort(int[] arr){
        for(int i=1; i< arr.length; i++){
            for(int j = i-1; j>=0;j--){
                if(isSmaller(arr, j+1,j)){
                    swap(arr, j+1,j);
                } else{
                    break;
                }
            }
        }
    }

    private static boolean isSmaller(int[] arr, int i, int j){
        return arr[i] < arr[j];
    }

    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void mergeSort(int[] arr,int l, int r){

        if(l<r) {
            int m = l + (r - l) / 2;

            mergeSort(arr, l,m);
            mergeSort(arr, m+1,r);

            merge(arr, l, m, r);

        }
    }

    private static void merge(int[] arr, int l, int m, int r){

        int n1 = m-l+1;
        int n2 = r-m;

        int[] arr1 = new int[n1];
        int[] arr2 = new int[n2];

        // fill small arrays
        for(int i = 0; i< n1 ;i++){
            arr1[i] = arr[l+i];
        }

        for(int i = 0; i< n2 ;i++){
            arr2[i] = arr[i+m+1];
        }

        int i = 0;
        int j = 0;
        int k = l;

        while(i < n1 && j < n2){
            if(arr1[i] < arr2[j]){
                arr[k] = arr1[i];
                i++;
                k++;
            } else{
                arr[k] = arr2[j];
                j++;
                k++;
            }
        }

        while(i < n1){
            arr[k] = arr1[i];
            i++;
            k++;
        }

        while(j < n2){
            arr[k] = arr2[j];
            j++;
            k++;
        }
    }

    // quick sort
    private static void quickSort(int[] arr, int lo, int hi){
        if(lo>=hi){
            return;
        }
        int pivot = arr[hi];
        int pi = partitioning(arr, pivot, lo, hi);
        quickSort(arr, lo, pi-1);
        quickSort(arr, pi+1, hi);
    }

    // partitioning an array, pivot, used in quick sort
    // 0 to j-1 -> <= pivot
    // j to i-1 -> > pivot
    // i to end -> unknown
     private static int partitioning(int[] arr, int pivot, int lo, int hi){
        System.out.println("pivot ->" + pivot);
        int i = lo;
        int j = lo;

        while(i <= hi){
            if(arr[i] > pivot){
                i++;
            } else if(arr[i] <= pivot){
                swap(arr, i,j);
                i++;
                j++;
            }
        }
        System.out.println("pivot index ->" + (j-1));
        return (j-1);
     }

     // find kth largest element
     private static void quickSelect(int[] arr, int lo, int hi, int k){

        int pivot = arr[hi];
        int pi = partitioning(arr,pivot, lo, hi);

        if(k < pi){
             quickSelect(arr, lo, pi-1, k);
        } else if(k > pi){
             quickSelect(arr, pi+1, hi, k);
        } else{
            System.out.println(k+1 + "th largest element ->" + arr[pi]);
            System.out.println(k+1 + "th largest element ->" + pivot);
        }
     }

     private static void countSort(int[] arr){
        // calculate min and max value in array
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int val : arr){
            if(val > max){
                max = val;
            }
            if(val < min){
                min = val;
            }
        }
         System.out.println("min:" + min + "max:"+max);

        // create an array of size max-min+1
        int[] freArray = new int[max-min+1];

        // populate frequency array with element occurance
        for(int val : arr){
            freArray[val-min]+=1;
        }


        // fill each index(+min=element) with last position fill, considering start pos at 0
        freArray[0]-=1;
        for(int i=1; i<freArray.length; i++){
            freArray[i] = freArray[i-1] +  freArray[i];
        }

         for(int i = 0; i< freArray.length; i++){
             System.out.println("["+i+"]" + freArray[i]);
         }

         // create result array with same size as input array
         int[] result = new int[arr.length];

         // loop from end and fill result array with index from freArray array and decrement index in freArray
         for(int i = arr.length-1; i>=0; i--){
             result[freArray[arr[i]-min]] = arr[i];
             freArray[arr[i]-min]-=1;
         }

         for(int a: result){
             System.out.print(a+" ");
         }

     }

     private static void radixSort(int[] arr){

        int max = Integer.MIN_VALUE;
        for(int val : arr){
            if(val > max){
                max = val;
            }
        }

        int exp = 1;
        while(exp<= max){
            countSortForRadix(arr, exp);
            exp = exp*10;
            System.out.println();
        }
     }

    private static void countSortForRadix(int[] arr, int exp){

        // create an array of size 10, 0->9 digits
        int[] freArray = new int[10];

        // populate frequency array with element occurrence
        for(int val : arr){
            freArray[val/exp%10]+=1;
        }

        // fill each index(+min=element) with last position fill, considering start pos at 0
        freArray[0]-=1;
        for(int i=1; i<freArray.length; i++){
            freArray[i] = freArray[i-1] +  freArray[i];
        }

        for(int i = 0; i< freArray.length; i++){
            System.out.println("["+i+"]" + freArray[i]);
        }

        // create result array with same size as input array
        int[] result = new int[arr.length];

        // loop from end and fill result array with index from freArray array and decrement index in freArray
        for(int i = arr.length-1; i>=0; i--){
            result[freArray[arr[i]/exp%10]] = arr[i];
            freArray[arr[i]/exp%10]-=1;
        }



        for(int i = 0; i< result.length; i++){
            arr[i] = result[i];
        }
        System.out.print("after sorting on "+exp +": ");
        for(int a: arr){
            System.out.print(a+" ");
        }
    }

    /** sort dates using radix sort
     *  12041996
     *  20101996
     *  05061997
     *  12041989
     *  11081987
     */


    private static void dateSort(String[] dates){

        // sort by days
        countSortDates(dates,1000000, 100,32);
        // sort by months
        countSortDates(dates,10000, 100,13);
        // sort by year
        countSortDates(dates,1, 10000,2501);

        System.out.print( "sorted dates are:");
        for(String date: dates){
            System.out.println( date);
        }
    }

    private static void countSortDates(String[] dates, int div, int mod, int range){

        // create an array of size 10, 0->9 digits
        int[] freArray = new int[range];

        // populate frequency array with element occurrence
        for(int i=0; i< dates.length; i++){
            freArray[Integer.parseInt(dates[i],10)/div%mod]+=1;
        }

        // fill each index(+min=element) with last position fill, considering start pos at 0
        freArray[0]-=1;
        for(int i=1; i<freArray.length; i++){
            freArray[i] = freArray[i-1] +  freArray[i];
        }

        for(int i = 0; i< freArray.length; i++){
            System.out.println("["+i+"]" + freArray[i]);
        }

        // create result array with same size as input array
        String[] result = new String[dates.length];

        // loop from end and fill result array with index from freArray array and decrement index in freArray
        for(int i = dates.length-1; i>=0; i--){
            result[freArray[Integer.parseInt(dates[i],10)/div%mod]] = dates[i];
            freArray[Integer.parseInt(dates[i],10)/div%mod]-=1;
        }



        for(int i = 0; i< result.length; i++){
            dates[i] = result[i];
        }
        System.out.print("after sorting on "+div +": ");
        for(String a: dates){
            System.out.print(a+" ");
        }
    }
}
