import java.util.Arrays;

public class Main {
    public static void main(String[] args)
    {
        System.out.println("Hello world!");
        int[] array = {2,4,-1,1};
        System.out.println("missing int is: " +minInt(array));
    }

    private static int minInt(int[] array){

        if(array==null || array.length==0)
            return 1;

        int n = array.length;
        for(int i=0; i<n ; i++){
            if(array[i] > 0 && array[i] <= n && array[i] != array[array[i]-1]){
                int temp = array[array[i]-1];
                array[array[i]-1] = array[i];
                array[i] = temp;

            }

        }

        for(int i=0; i<n ; i++){
            System.out.print(array[i]+ " ");
        }

        for(int i=0; i<n ; i++){
            if(array[i] != i+1)
                return i+1;
        }

        return n+1;
    }
}