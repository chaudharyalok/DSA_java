package ir.dsa.greedy;

import com.sun.org.apache.bcel.internal.generic.LineNumberGen;

public class GreedyApproach {
    public static void main(String args[]) {
        System.out.println("welcome to heaps!");
        int[] arr = {5,10,10,100,5,6};
    //    maxSumNonAdjacent(arr);
        int[] house1 = {1,5,7};
        int[] house2 = {5,8,4};
        int[] house3 = {3,2,9};
        int[] house4 = {1,2,4};

        int[][] houseCost = {house1,house2,house3,house4};
    //    paintHouse(houseCost);
    //    paintHouseManyColors(houseCost);
        paintHouseManyColorsOptimised(houseCost);
        int[] arr1 = {-1,10,10,100,7,0};
   //     leastAnd2ndLeast(arr1);
    }

    private static void maxSumNonAdjacent(int[] arr){

        int inc = arr[0];
        int exc = 0;

        for(int i=1; i< arr.length; i++){
            int temp = exc + arr[i];
            exc = Math.max(inc,exc);
            inc = temp;
        }

        System.out.println("max sum:" + Math.max(inc,exc));
    }

    private static void paintHouse(int[][] houses){

        int[][] dp = new int[houses.length][houses[0].length];

        dp[0][0] = houses[0][0];
        dp[0][1] = houses[0][1];
        dp[0][2] = houses[0][2];

        for(int i =1; i < houses.length; i++){

            dp[i][0] = houses[i][0] + Math.min(dp[i-1][1],dp[i-1][2]);
            dp[i][1] = houses[i][1] + Math.min(dp[i-1][0],dp[i-1][2]);
            dp[i][2] = houses[i][2] + Math.min(dp[i-1][0],dp[i-1][1]);
        }

        System.out.println("min cost:" + Math.min(Math.min(dp[houses.length-1][0],dp[houses.length-1][1]),dp[houses.length-1][2]));
    }

    private static void paintHouseManyColors(int[][] houses){
        int[][] dp = new int[houses.length][houses[0].length];

        for(int j =0; j< houses[0].length; j++){
            dp[0][j] = houses[0][j];
        }

        for(int i = 1; i< houses.length; i++){
            for(int j = 0; j< houses[0].length; j++){
                    int min = Integer.MAX_VALUE;

                    for(int k =0; k < dp[0].length; k++){
                        if(k != j){
                            if(dp[i-1][k] < min){
                                min = dp[i-1][k];
                            }
                        }
                    }
                    dp[i][j] = houses[i][j] + min;
            }
        }

        // min of last row

        int min_result = Integer.MAX_VALUE;
        for(int j = 0; j< houses[0].length; j++){
            if(dp[houses.length-1][j] < min_result){
                min_result = dp[houses.length-1][j];
            }
        }
        System.out.println("min cost: "+min_result);
        // complexity is n^3
        // optimisation while filling first row, find least and 2nd least value
    }

    private static void leastAnd2ndLeast(int[] arr){

        int least = Integer.MAX_VALUE;
        int sLeast = Integer.MAX_VALUE;

        for(int v : arr){
            if(v <= least){
                sLeast = least;
                least = v;
            } else if(v < sLeast){
                    sLeast = v;
            }
        }
        System.out.println("least: "+least + " sleast: " + sLeast);

    }

    private static void paintHouseManyColorsOptimised(int[][] houses){

        int[][] dp = new int[houses.length][houses[0].length];

        int least = Integer.MAX_VALUE;
        int sLeast = Integer.MAX_VALUE;

        for(int j =0; j< houses[0].length; j++){
            dp[0][j] = houses[0][j];

            if( houses[0][j] <= least){
                sLeast = least;
                least =  houses[0][j];
            } else if(houses[0][j] <= sLeast){
                sLeast = houses[0][j];
            }
        }

        for(int i = 1; i< houses.length; i++) {
            int nleast = Integer.MAX_VALUE;
            int nsLeast = Integer.MAX_VALUE;
            for (int j = 0; j < houses[0].length; j++) {
                    if(least == dp[i-1][j]){
                        dp[i][j] = houses[i][j] + sLeast;
                    } else{
                        dp[i][j] = houses[i][j] + least;
                    }

                    if( dp[i][j] <= nleast){
                        nsLeast = nleast;
                        nleast =  dp[i][j];
                    } else if(dp[i][j] <= nsLeast){
                        nsLeast = dp[i][j];
                    }
            }

            least = nleast;
            sLeast = nsLeast;
        }

        System.out.println("min cost: "+least);
    }
}
