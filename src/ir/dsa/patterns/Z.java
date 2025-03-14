package ir.dsa.patterns;

import java.util.Stack;

public class Z {

    public static void main(String[] args){

      //  System.out.println("*****\n    *\n   * \n  *  \n *    \n*****\n");
      //  printZ(5);
        int i = 27391/10000;
        System.out.println(i);
    }

    private static void printZ(int n){
         for(int i=0; i<n; i++){
             System.out.print("*");
         }

System.out.println();

         for(int i=0; i<n-1; i++){
             for(int j=0; j<n-i-1; j++){
                 if(j==n-i-2)
                 System.out.print("*");
                 else
                     System.out.print(" ");
             }

             System.out.println();
         }

        for(int i=0; i<n; i++){
            System.out.print("*");
        }


    }


    private static void JJJ(int arr[]){

        int rb[] = new int[arr.length]; // nse on the right
        Stack<Integer> stack = new Stack<>();
        stack.push(arr.length-1);
        rb[arr.length-1] = arr.length;

        for(int i = arr.length-2; i>=0; i--){

            while(!stack.isEmpty() && arr[i] < arr[stack.peek()]){
                stack.pop();
            }

            if(stack.isEmpty()){
                rb[i] = arr.length;
            } else{
                rb[i] = stack.peek();
            }
            stack.push(i);
        }

        stack.empty();

        int lb[] = new int[arr.length]; // nse on the left

        rb[0] = -1;
        stack.push(0);

            for(int j = 0; j<arr.length; j++) {
                {
                    while (!stack.isEmpty() && arr[j] < arr[stack.peek()]) {
                        stack.pop();

                    }

                    if (stack.isEmpty()) {
                        lb[j] = -1;
                    } else {
                        lb[j] = stack.peek();
                    }
                }

                int max = Integer.MAX_VALUE;

                for (int k = 0; k < arr.length; k++) {

                    int width = rb[k] - lb[k] - 1;
                    int area = width * arr[k];
                    if (area > max) {
                        max = area;
                    }
                }

                System.out.println("max area:" + max);

            }
    }
}

