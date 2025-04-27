package ir.dsa.dp;

public class DP {
    public static void main(String[] args) {
        System.out.println("welcome to recursion:");

        int n = 10;
        int[] ans = new int[n+1];
        //    System.out.println(fibonacciMemoised(4, ans));

        //   System.out.println(findStairPaths(n, ans));
        System.out.println(countStairPathsTab(10));
    }

    private static void pathMaxGold(int[][] array){
        int[][] dp = new int[array.length][array[0].length];

        for(int j = array[0].length-1; j>=0; j--){
            for(int i = array.length-1; i>=0; i--){

                if(j == array[0].length-1){
                    dp[i][i] = array[i][j];
                } else if(i == array.length-1){
                    dp[i][j] = array[i][j] + Math.max(array[i][j+1], array[i-1][j+1]);
                } else if(i == 0){
                    dp[i][j] = array[i][j] + Math.max(array[i][j+1], array[i+1][j+1]);
                } else{
                    dp[i][j] = array[i][j] + Math.max(Math.max(array[i][j+1], array[i+1][j+1]), array[i-1][j+1]);
                }

            }
        }

        // get max from first column
        int max = dp[0][0];
        for(int i = 1; i <= array.length-1; i++){
            if(array[i][0] > max){
                max = array[i][0];
            }
        }
        System.out.println(max);

    }

    private static void minCostPath(int[][] array){
        int[][] dp = new int[array.length][array[0].length];

        for(int i = dp.length-1; i>=0; i--){
            for(int j = dp[0].length-1; j>=0; j--){

                if( i == dp.length-1 && j == dp[0].length-1){
                    dp[i][j] = array[i][j];
                } else if(i == dp.length-1){
                    dp[i][j] = array[i][j+1] + array[i][j];
                } else if(j == dp[0].length-1){
                    dp[i][j] = array[i+1][j] + array[i][j];
                } else{
                    dp[i][j] = Math.min(array[i][j+1],array[i+1][j]) + array[i][j];
                }
            }
        }

        System.out.println(dp[0][0]);
    }

    private static int climbStairsMinMoves(int[] jumps, int n){

        Integer[] dp = new Integer[n+1];

        dp[n]=0;

        for(int i = n-1; i>=0; i--){
            if(jumps[i] > 0){
                int min = Integer.MAX_VALUE;
                for(int j=1;j <=jumps[i] && i+j < dp.length; j++){
                    if(dp[i + j] != null) {
                        min = Math.min(dp[i + j], min);
                    }
                }

                if(min != Integer.MAX_VALUE){
                    dp[i] = min+1;
                } else{
                    dp[i] = null;
                }
            }
        }
        return dp[0];
    }

    private static int climbStairsJump(int[] jumps, int n){

        int[] dp = new int[n+1];
        dp[n]=1;

        for(int i= n-1; i>=0; i--){
            for(int j =1; j<=jumps[i] && i+j < dp.length; j++){
                dp[i] +=dp[i+j];
            }
        }
        return dp[0];
    }

    private static int countStairPathsTab(int n){

        int[] dp = new int[n+1];
        dp[0] = 1;

        for(int i = 1; i<=n; i++){
            if(i == 1){
                dp[i] = dp[i-1];
            } else if(i ==2){
                dp[i] = dp[i-1] + dp[i-2];
            } else {
                dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
            }

        }
        return dp[n];
    }

    private static int findStairPaths(int n, int[] qb){

        if(n==0){
            return 1;
        } else if(n<0){
            return 0;
        }

        if(qb[n] > 0){
            return qb[n];
        }
        int c1 = findStairPaths(n-1, qb);
        int c2 = findStairPaths(n-2, qb);
        int c3 = findStairPaths(n-3, qb);

        int count = c1 + c2 + c3;
        qb[n] = count;

        return count;
    }

    private static int fibonacciMemoised(int n, int[] ans){
        if(n ==0 || n==1){
            return n;
        }
        if(ans[n] != 0){
            return ans[n];
        }
        int fibon_1 = fibonacci(n-1);
        int fibon_2 = fibonacci(n-2);
        int fibo = fibon_1+fibon_2;
        ans[n] = fibo;
        return fibo;
    }

    private static int fibonacci(int n){

        if(n ==0 || n==1){
            return n;
        }
        int fibon_1 = fibonacci(n-1);
        int fibon_2 = fibonacci(n-2);

        return  fibon_1+fibon_2;
    }
}
