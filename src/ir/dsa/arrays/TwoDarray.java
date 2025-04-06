package ir.dsa.arrays;

public class TwoDarray {

    public static void main(String[] args) {
        System.out.println("welcome to 2D arrays:");
        int[] arr = {10,12,15,19,21,25,27,32};
        int[] arr1 = {10,20,20,30,40,40,40,50};
     //   System.out.println("found at:"+ binarySearch(arr, 32));
     //   System.out.println("found at:"+ binarySearch2(arr, 32, 0, arr.length));
     //   ceilFloor(arr, 22);
        firstLastIndex(arr1,40);
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
}
