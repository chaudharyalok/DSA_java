package ir.dsa.dp;

import java.util.Arrays;

public class DP {
    /** DP problem solving strategy:
     *  1. storage & meaning
     *  2. direction
     *  3. travel & solve
     */
    public static void main(String[] args) {
        System.out.println("welcome to recursion:");

        int n = 10;
        int[] ans = new int[n+1];
        //    System.out.println(fibonacciMemoised(4, ans));

        //   System.out.println(findStairPaths(n, ans));
    //    System.out.println(countStairPathsTab(10));
        //     int[] coins = {2,3,5};
     //   System.out.println(coinCombination(coins,10));
   //     System.out.println(coinPermutations(coins,7));

            int[] ele = {2,5,1,3,4};
            int[] wt = {15,14,10,45,30};
        //    knapsack(ele,wt,7);
     //       unBoundedKnapsack(ele,wt,7);
     //   countBinaryStringNoCons0approach1(6);
     //   countBinaryStringNoCons0approach2(6);
     //   arrangeBuildings(6);
     //   decodeWaysCount("21123");
     //   countSubSeq("abcabc");
   //     paintFence(8,3);

        int[] arr = {7,15,3,18,6,4,19,2,12,11,9};
    //    targetSumPair(arr,15);
     //   tiling(4);
    //    tilingMN(8,3);
    //    friendsPairing(5);
   //     partitionSubset(4,3);
        int[] stocksPrice = {2,4,0,4,2};
    //    maxProfitStock1(stocksPrice);
        int[] stocksPrice1 = {10,20,30};
     //   maxProfitStock2(stocksPrice1,2);

        int[] stocksPrice3 = {10,15,17,20,16,18,22,20,22,20,23,25};
     //   maxProfitStock3(stocksPrice3,1);

        int[] stocksPrice4 = {30,40,43,50,45,20,26,40,80,50,30,15,10,20,40,45,71,50,55};
      //  maxProfitStock4(stocksPrice4);
        int[] stocksPrice5 = {9,6,7,6,3,8};
    //    maxProfitStock5(stocksPrice5,3);
        maxProfitStock5_Optimised(stocksPrice5,3);
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

    // DP target sum subset

    private static boolean targetSumSubset(int[] arr, int tar){

        boolean[][] dp = new boolean[arr.length+1][tar+1];

        for(int i=0; i< dp.length; i++){
            for(int j=0; j< dp[0].length; j++){

                if(i ==0 && j == 0){
                    dp[i][j] = true;
                } else if(i ==0){
                    dp[i][j] = false;
                } else if(j ==0){
                    dp[i][j] = true;
                } else {
                    if (dp[i - 1][j] == true) { // when i not involved & target is achieved
                        dp[i][j] = true;
                    }
                    else{    // i in involved & j-arr[i-1] is checked by previous member
                    int val = arr[i - 1];  // when i is involved and i points to arr[i - 1]
                    if (j >= val) {
                        if (dp[i - 1][j - val] == true) {
                            dp[i][j] = true;
                        }
                    }
                    }
                }
            }
        }

        return dp[arr.length][tar];
    }

    // DP coin change combinations
    // coins [2,3,5], amount -> 7, ans: 223, 25
    private static int coinCombination(int[] coins, int amount){

        int[] dp = new int[amount+1];
        dp[0] = 1;
        for(int i = 0; i< coins.length; i++){
            for(int j = coins[i]; j< dp.length; j++){
                dp[j] += dp[j-coins[i]];
            }
        }
        return dp[amount];
    }

    // DP coin change permutations
    private static int coinPermutations(int[] coins, int amount){

        int[] dp = new int[amount+1];
        dp[0] = 1;

        for(int i = 1; i<= amount; i++){
            for(int j = 0; j < coins.length; j++){
                if(coins[j] <= i){
                        dp[i] += dp[i-coins[j]];
                }
            }
        }

        return dp[amount];
    }

    // DP 0-1 knapsack problem

    private static void knapsack(int[] ele, int[] wt, int cap){

        int[][] dp = new int[ele.length+1][cap+1];

        for(int i = 1; i< dp.length; i++){
            for(int j =1; j< dp[0].length; j++){

                // logic 1
              /*  if(j>= ele[i-1]){
                    int remCap = j - ele[i-1];
                    if(dp[i-1][remCap] + wt[i-1] > dp[i-1][j]){
                        dp[i][j] = dp[i-1][remCap] + wt[i-1];
                    } else{
                        dp[i][j] = dp[i-1][j];
                    }

                } else{
                    dp[i][j] = dp[i-1][j];
                }*/

                    // logic 2
                   int temp = dp[i-1][j];  // i don't involve
                    int temp2 = 0;
                    int val = ele[i-1];
                    if(j>=val){  // when i is involved
                        int wt1 = wt[i-1]; // i's weight
                        int wt2 = dp[i-1][j-val];  // weight of remaining capacity
                        temp2 = wt1+wt2;
                    }
                    dp[i][j] = Math.max(temp,temp2);


            }
        }
        System.out.println(dp[ele.length][cap]);
    }


    // unbounded knapsack
    private static void unBoundedKnapsack(int[] ele, int[] wt, int cap){

        int[] dp = new int[cap+1];
        dp[0] = 0;

        for(int bagC = 1; bagC <=cap; bagC++){
            int max = 0;
            for(int j =0; j< ele.length; j++){
                if(ele[j] <= bagC){
                    int remCap = bagC - ele[j];
                    int remVal = dp[remCap];
                    int totalBagVal = remVal + wt[j];

                    if(totalBagVal>max){
                        max = totalBagVal;
                    }

                }
            }
            dp[bagC] = max;
        }
        System.out.println(dp[cap]);
    }

    // count binary string with no consecutive zeros
    private static void countBinaryStringNoCons0approach1(int n){

        int[] dp0 = new int[n+1];
        int[] dp1 = new int[n+1];

        dp0[1] = 1;
        dp1[1] = 1;

        for(int i =2; i<= n; i++){
            dp0[i] = dp1[i-1];
            dp1[i] = dp0[i-1] + dp1[i-1];
        }

        System.out.println(dp0[n]+dp1[n]);
    }

    private static void countBinaryStringNoCons0approach2(int n){


        int oldCount0 = 1;
        int oldCount1 = 1;

        for(int i = 2; i <=n; i++){
            int newCount0 = oldCount1;
            int newCount1 = oldCount0 + oldCount1;

            oldCount0 = newCount0;
            oldCount1 = newCount1;
        }

        System.out.println(oldCount0+oldCount1);
    }

    // arrange building on both side of road where there is no 2 or more consecutive buildings
    private static void arrangeBuildings(int n){

        // here we take ref of previous ques: building <-> space
        int oldCountB = 1;
        int oldCountS = 1;

        for(int i = 2; i <=n; i++){
            int newCountB = oldCountS;
            int newCountS = oldCountB + oldCountS;

            oldCountB = newCountB;
            oldCountS = newCountS;
        }
     //   total no of ways is such arrangement on 1 side of road = oldCountB + oldCountS
        int oneSideArrangement = oldCountB + oldCountS;
        //  total no of ways of arrangement on both side = oneSideArrangement * oneSideArrangement
        System.out.println(oneSideArrangement * oneSideArrangement);
    }

    // decode ways, count encoding
    // ex 21123 -> 8
    private static void decodeWaysCount(String str){

        int[] dp = new int[str.length()];
        dp[0] = 1;

        for(int i=1; i < dp.length; i++){
            if(str.charAt(i-1) == '0' && str.charAt(i) == '0'){
                dp[i] = 0;
            } else if(str.charAt(i-1) == '0' && str.charAt(i) != '0'){
                dp[i] = dp[i-1];
            } else if(str.charAt(i-1) != '0' && str.charAt(i) == '0'){
                    if(str.charAt(i-1) == '1' || str.charAt(i-1) == '2'){
                        dp[i] = (i>=2 ? dp[i-2]:1);
                    } else{
                        dp[i] = 0;
                    }
            } else{
                    if(Integer.parseInt(str.substring(i-1, i+1)) <= 26){
                        dp[i] = dp[i-1] + (i>=2 ? dp[i-2]:1);
                    } else{
                        dp[i] = dp[i-1];
                    }
            }
        }

        System.out.println(dp[str.length()-1]);
    }


    // count subsequence
    private static void countSubSeq(String str){

        int a = 0;
        int ab = 0;
        int abc = 0;

        for(int i=0; i< str.length(); i++){
            char ch = str.charAt(i);
            if(ch == 'a'){
                a = 2*a+1;
            } else if(ch == 'b'){
                ab = 2*ab+a;
            } else{
                abc = 2*abc+ab;
            }

        }
        System.out.println(abc);
    }

    // paint fence, n is no of fences, k is no of colors
    private static void paintFence(int n, int k){

        // compute for first 2 fences
        int same = k*1;
        int diff = k*(k-1);
        int total = same+diff;

        for(int i = 3; i<=n; i++){
            same  = diff*1;
            diff = total*(k-1);
            total = same+diff;
        }
        System.out.println(total);
    }

    // target sum pair, in nlog(n)

    private static void targetSumPair(int[] arr, int tar){
        // first sort the array, nlogn
        Arrays.sort(arr);
        int l = 0;
        int r = arr.length-1;

        while(l<=r){
            if(arr[l]+arr[r] < tar){
                l++;
            } else if(arr[l]+arr[r] > tar){
                r--;
            } else{
                System.out.println("pair["+arr[l]+"-"+arr[r]+"]");
                l++;
                r--;
            }
        }
    }

    /**  tiling with 2*1 tiles where floor is 2*n
     *   initially tile can be placed either vertically or horizontally
     *   when placed vertically we are left with n-1 area
     *   when placed horizontally, another tile can be placed only horizontally above or below it + tiles
     *   in n-2 area, so total ways are (n-2)*1
     *   for f(n) = f(n-1) + f(n-2)
     *
     *   base cases:
     *   for n=1, only 1 way -> place tile vertically
     *   for n=2, 2 ways either both tiles vertically or horizontally
      */

    private static void tiling(int n){

        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;

        for(int i = 3; i<=n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        System.out.println("total ways:"+dp[n]);
    }

    /** tile size is m*1, floor size is m*n
     * when placed vertically: 1*(m,n-1) floor
     * when placed horizontally: 1 way of placing m tiles + (m, n-m) floor
     * base cases:
     * when n<m: only 1 way
     * when n=m: 2 ways, all horizontally or vertically
     */
    private static void tilingMN(int n, int m){

        int[] dp = new int[n+1];

        for(int i=1; i<=n; i++){
            if(i<m){
                dp[i] = 1;
            } else if(i==m){
                dp[i] = 2;
            } else{
                dp[i] = dp[i-1] + dp[i-m];
            }
        }
        System.out.println("total ways:"+dp[n]);
    }

    /** there are 2 choices:
     * 1. he remains single, total ways = f(n-1)
     * 2. he pairs up with someone, remaining friends (n-2), and he can pair up in (n-1) ways
     */
    private static void friendsPairing(int n){

        int[] dp = new int[n+1];

        dp[1] = 1;
        dp[2] = 2;

        for(int i=3; i<=n;i++){
            dp[i] = dp[i-1] + dp[i-2] * (i-1);
        }
        System.out.println("total ways:"+dp[n]);
    }

    /**
     * n friends k teams, such that no team is empty
     *
     *
     */
    private static void partitionSubset(int n, int k){

        if(n==0 || k==0 || n<k){
            System.out.println("total ways:"+0);
            return;
        }

        long[][] dp = new long[k+1][n+1];

        for(int team = 1; team<= k; team++){
            for(int player = 1; player<=n; player++){
                    if(player < team){
                        dp[team][player] = 0;
                    } else if(player == team){
                        dp[team][player] = 1;
                    } else{
                        dp[team][player] =  dp[team-1][player-1] +  dp[team][player-1]* team;
                    }
            }
        }
        System.out.println("total ways:"+dp[k][n]);
    }

    /** buy and sell stocks, 1 transaction allowed
     * we have to find single transaction when profit is max
     *
     *
     */

    private static void maxProfitStock(int[] input){

        int min_so_far = Integer.MAX_VALUE;
        int max_profit = 0;
        int current_profit = 0;

        for(int i = 0; i< input.length; i++){

            if(input[i] < min_so_far){
                min_so_far = input[i];
            }

            current_profit = input[i] - min_so_far;
            if(current_profit > max_profit){
                max_profit = current_profit;
            }
        }
        System.out.println("max profit:"+max_profit);
    }

    /**
     * we can have many transactions without overlapping
     * BSBS allowed, BBSS not allowed, no overlapping transaction allowed
     */
    private static void maxProfitStock1(int[] input){

        int total_profit = 0;

        int buy_price = input[0];
        int sell_price = input[0];

        for(int i = 1; i < input.length; i++){
           if(input[i] >= sell_price){
               sell_price = input[i];
           } else{
               // make profit
               int profit = sell_price - buy_price;
               total_profit+=profit;

               buy_price = input[i];
               sell_price = input[i];
           }
        }
        int profit = sell_price - buy_price;
        total_profit+=profit;
        System.out.println("total profit:"+total_profit);
    }

    /** we can have many transactions without overlapping, with a price paid on each sell
     *
     */
    private static void maxProfitStock2(int[] input, int sellCost){

        int obsp = -input[0];
        int ossp = 0;

        for(int i = 1; i<input.length; i++){

            int nbsp = 0;
            int nssp = 0;

            if(ossp-input[i] > obsp){
                nbsp = ossp-input[i];
            } else{
                nbsp = obsp;
            }

            if(input[i]-sellCost + obsp > ossp){
                nssp = input[i]-sellCost+ obsp;
            } else{
                nssp = ossp;
            }

            obsp = nbsp;
            ossp = nssp;
        }

        System.out.println("max profit:"+ossp);
    }

    /** we can have many transactions without overlapping, with cool down

     */
    private static void maxProfitStock3(int[] input, int coolDownPeriod){

        int obsp = -input[0];
        int ossp = 0;
        int ocsp = 0;

        for(int i = 1; i< input.length; i++){

            int nbsp = 0;
            int nssp = 0;
            int ncsp = 0;

            if(ocsp - input[i] > obsp){
                nbsp = ocsp - input[i];
            } else{
                nbsp = obsp;
            }

            if(input[i] + obsp > ossp){
                nssp = input[i] + obsp;
            } else{
                nssp = ossp;
            }

            if(ossp > ocsp){
                ncsp = ossp;
            } else{
                ncsp = ocsp;
            }

            obsp = nbsp;
            ossp = nssp;
            ocsp = ncsp;
        }

        System.out.println("max profit:"+ossp);
    }

    /** we can have 2 transactions without overlapping

     */

    private static void maxProfitStock4(int[] input){

        int max_pro_if_sold_today = 0;
        int least_so_far = input[0];

        int[] dp_max_pro_if_sold_upto_today = new int[input.length];

        for(int i=1; i< input.length; i++){

            if(input[i] < least_so_far){
                least_so_far = input[i];
            }

            max_pro_if_sold_today = input[i] - least_so_far;

            if(max_pro_if_sold_today > dp_max_pro_if_sold_upto_today[i-1]){
                dp_max_pro_if_sold_upto_today[i] = max_pro_if_sold_today;
            } else{
                dp_max_pro_if_sold_upto_today[i] = dp_max_pro_if_sold_upto_today[i-1];
            }

        }

        int max_pro_if_bought_today = 0;
        int max_after_today = input[input.length-1];

        int[] dp_max_pro_on_right = new int[input.length];
        for(int i =input.length-2; i>=0; i--){

            if(input[i] > max_after_today){
                max_after_today = input[i];
            }

            max_pro_if_bought_today = max_after_today - input[i];

            if(max_pro_if_bought_today > dp_max_pro_on_right[i+1] ){
                dp_max_pro_on_right[i] = max_pro_if_bought_today;
            } else{
                dp_max_pro_on_right[i] =  dp_max_pro_on_right[i+1];
            }
        }

        int over_all_pro = 0;

        for(int i=0; i< input.length; i++){
            if(dp_max_pro_if_sold_upto_today[i] + dp_max_pro_on_right[i] > over_all_pro){
                over_all_pro = dp_max_pro_if_sold_upto_today[i] + dp_max_pro_on_right[i];
            }
        }

        System.out.println("max profit:"+over_all_pro);

    }

    /**
     * max profit if k transactions allowed
     */
    private static void maxProfitStock5(int[] input, int k){

        int[][] dp = new int[k+1][input.length];

        for(int i = 1; i<dp.length;i++){
            for(int j= 1; j<dp[0].length;j++){
                int max = dp[i][j-1];
                for(int l = j-1; l>=0; l--){
                    if(dp[i-1][l] + (input[j]-input[l]) >max){
                        max = dp[i-1][l] + (input[j]-input[l]);
                    }
                }
                dp[i][j] = max;
            }
        }
        System.out.println("max profit:"+ dp[k][input.length-1]);
    }

    private static void maxProfitStock5_Optimised(int[] input, int k){

        int[][] dp = new int[k+1][input.length];

        for(int i = 1; i<dp.length;i++){
            int max = Integer.MIN_VALUE;
            for(int j= 1; j<dp[0].length;j++){
              if(dp[i-1][j-1] - input[j-1] > max){
                    max = dp[i-1][j-1] - input[j-1];
              }

              if(max + input[j] > dp[i][j-1]){
                dp[i][j] = max + input[j];
              } else{
                  dp[i][j] = dp[i][j-1];
              }
            }
        }
        System.out.println("max profit:"+ dp[k][input.length-1]);
    }

}
