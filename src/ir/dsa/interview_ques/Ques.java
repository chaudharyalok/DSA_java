package ir.dsa.interview_ques;

import java.util.Arrays;

public class Ques {
    public static void main(String[] args) {
        System.out.println("welcome to questions:");
        int[] arr = {10, 10, 2, 2};
    //    System.out.println(winners(arr));

        char[][] grid = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";
        match(grid,word);
    }

    /**
     * no of players win
     * array of power of each player,
     * a player can win if power is more and gain the opponents power
     * how many players can win the tournament
     * [2,3,4] -> only 3,4 can win, ans is 2
     * [1,1,1] -> all 3 can win, ans is 3
     * [2,2,10,10] -> only players with 10 power can win, ans -> 2
     */

    private static int winners(int[] arr) {

        int winners = 0;
        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            int currentPower = arr[i];
            for (int j = 0; j < arr.length; j++) {
                if (i != j) {
                    if (currentPower >= arr[j]) {
                        currentPower += arr[j];
                    } else {
                        break;
                    }
                }
                if (j == arr.length - 1) {
                    winners++;
                }
            }
        }
        return winners;
    }

    private static int winner2(int[] arr) {

        int winners = 0;
        int n = arr.length;
        Arrays.sort(arr);

        for (int i = 0; i < n; i++) {
            int currentPower = arr[i];
            boolean allWin = true;
            for (int j = 0; j < n; j++) {
                if (i == j)
                    continue;
                if (currentPower >= arr[j]) {
                    currentPower += arr[j];
                } else {
                    allWin = false;
                    break;
                }
            }
            if (allWin) {
                winners++;
            }
        }
        return winners;
    }

    /** word match in grid of alphabets
     *
      */

    private static void match(char[][] grid, String word){

        int n = grid.length;
        int m = grid[0].length;
        boolean found = false;
        for(int i=0; i< n; i++){
            for(int j=0; j< m; j++){
                found = searchDFS(grid,i,j,0,word);
                if(found) {
                    System.out.println(word + " found");
                    return;
                }
            }
        }
        System.out.println(word + " not found");
    }

    private static boolean searchDFS(char[][] grid,int i, int j, int k, String word){
        int n = grid.length;
        int m = grid[0].length;

        if(k == word.length()-1){
            return true;
        }

        if(i>=n || j>=m || i<0 || j<0 || grid[i][j] != word.charAt(k)){
            return false;
        }

        char temp = grid[i][j];
        grid[i][j] = '#';

        boolean result = searchDFS(grid, i,j+1, k+1, word) ||
                         searchDFS(grid, i,j-1, k+1, word) ||
                         searchDFS(grid, i+1,j, k+1, word) ||
                         searchDFS(grid, i-1,j, k+1, word);

        grid[i][j] = temp;
        return result;
    }

    /**
     *
     *
     */
}
