package ir.dsa.patterns;

public class ArraysConcepts {

    public static void main(String args[]) {
        System.out.println("Hello in arrays world!");
     //   System.out.println("span of array: "+ spanOfArray(new int[]{6,15,30,40,4,11,9}));
     //   System.out.println("index of element: "+ findInArray(new int[]{6,15,30,40,4,11,9}, 6));
    //    barChart(new int[]{3,0,4,5});
    //    sumTwoArray(new int[]{3,1,0,7,5},new int[]{9,7,1,1,1,1});
    //    subtractTwoArray(new int[]{1,1,1,1,1,1},new int[]{2,3,4,6,9});
    //    binarySort(new int[]{1,1,1,1,0,0,0,1,0,1,0,0,1,1,0,1,0,1,0});
        ternarySort(new int[]{1,1,2,1,0,0,0,1,2,1,0,0,1,2,0,1,0,2,0});
    }

    private static void ternarySort(int arr[]){

        int i=0;
        int k =0;
        int j = arr.length-1;

        while(k<=j){

            if(arr[k]==0){
                // swap i & k
                int temp = arr[i];
                arr[i] = arr[k];
                arr[k] = temp;

                i++;
                k++;
            } else if(arr[k]==1){
                k++;
            } else{
                // swap k & j
                int temp = arr[k];
                arr[k] = arr[j];
                arr[j] = temp;

                j--;
            }
        }

        // print sorted array
        for(int l: arr){
            System.out.print(l + " ");
        }
    }

    private static void binarySort(int arr[]){
        int i =0;
        int j = arr.length-1;
        while(i<j){
            if(arr[i]==0){
                i++;
            }
            if(arr[j]==1){
                j--;
            }
            if(arr[i]==1){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

                j--;
            }
        }
        for(int k: arr){
            System.out.print(k + " ");
        }
    }

    private static int spanOfArray(int arr[]){

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int i: arr){
            if(i>max){
                max = i;
            }
            if(i<min){
                min = i;
            }
        }

        int diff = max-min;

        return diff;
    }

    private static int findInArray(int arr[], int n){

        int length = arr.length;
        if(length == 0){
            return -1;
        }

        for(int i = 0; i< length; i++){
            if(arr[i] == n){
                return i;
            }
        }
        return -1;
    }

    private static void barChart(int arr[]){

        int max = Integer.MIN_VALUE;
        for(int i: arr) {
            if (i > max) {
                max = i;
            }
        }
            for(int j = 1; j<=max; j++){
            for(int k = 0; k<arr.length;k++){
                if(max-j>=arr[k]){
                    System.out.print("\t");

                }else{
                    System.out.print("*\t");
                }
            }
                System.out.println();

        }

    }

    private static void sumTwoArray(int arr1[], int arr2[]){

        int length1 = arr1.length;
        int length2 = arr2.length;

        int p = 1;

        int carry = 0;
        int result = 0;
        while(length1 > 0 && length2 > 0){

            int temp = arr1[length1-1] + arr2[length2-1] + carry;
            int digit = temp%10;
            carry = temp/10;
            result = result + digit*p;

            p = p*10;

            length1--;
            length2--;
        }

        while(length1 > 0){
            int temp = arr1[length1-1] + carry;
            int digit = temp%10;
            carry = temp/10;
            result = result + digit*p;

            p = p*10;

            length1--;

        }

        while(length2 > 0){
            int temp = arr2[length2-1] + carry;
            int digit = temp%10;
            carry = temp/10;
            result = result + digit*p;

            p = p*10;

            length2--;

        }

        if(carry > 0){
            result = result + carry*p;
        }

        System.out.println(result);

    }

    private static void subtractTwoArray(int arr1[], int arr2[]){

        int result = 0;
        int carry = 0;

        int p = 1;

        int length1 = arr1.length;
        int length2 = arr2.length;
        while(length1 > 0 && length2 > 0){

            int d1 = arr1[length1-1];
            int d2 = arr2[length2-1];

            d1 = d1 + carry;
            int temp = 0;
            if(d1<d2){
                temp = d1+10-d2;
                carry = -1;
            }
             else{
                 temp = d1-d2;
                 carry = 0;
            }

            result = result + temp*p;

             p*=10;

            length1--;
            length2--;
        }

        while(length1 > 0){

            int d1 = arr1[length1-1];

            d1 = d1 + carry;

            result = result + d1*p;

            p*=10;

            length1--;

        }

        System.out.println(result);
    }
}
