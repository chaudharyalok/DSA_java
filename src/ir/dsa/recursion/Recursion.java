package ir.dsa.recursion;

import sun.lwawt.macosx.CSystemTray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Recursion {
    public static void main(String[] args) {
        System.out.println("welcome to recursion:");
     //   incDesc(5);
    //    towerOfHanoi(3, "A","B","C");
        int[] arr = {10,20,8,30,40,50, 27,81,8};
    //    displayArray(arr, 4);
    //    displayArrayReverse(arr,0);
  //      System.out.println(maxInArray(arr,0));
  //      System.out.println(firstIndexOfOccurance(arr, 8, 0));
    //    System.out.println(lastIndexOfOccurance(arr, 8, 0));


    /*    int[] result = findAllOccurances(arr, 8,0,0);
        for(int i : result){
            System.out.print(i + " ");
        }*/


   //     System.out.println(subsequence("abc"));
   //     System.out.println(getKeypadCombinations("12"));
   //       System.out.println(getStairPath(4));
   //     System.out.println(getMazePath(0,0,2,2));

    //    System.out.println(getMazePathJump(0,0,2,2));
   //     printSubsequence("abc","");
   //       printKeypadCombinations("12","");
   //     printStairPaths(4,"");
   //     printMazePath(0,0,2,2,"");
   //     printMazePathJump(0,0,2,2,"");
   //     printPermutations("abc","");
   //     printEncoding("123", "");

     //   int[] input = {10,20,30,40,50};


       // targetSumSubset(input, 0, "",0,60);
    //    displayBoard(populateChessBoard());
   //     System.out.println(fibonacci(4));

    }

    static String[] array = {"abc","def","ghi","jkl","mn","op"};
    private static void printKnightTour(int[][] chess, int r, int c, int move){

        if(r<0 || c<0 || r >= chess.length|| c >= chess.length || chess[r][c]>0){
            return;
        }
        else if(move == chess.length* chess.length){
            chess[r][c] = move;
            displayBoard(chess);
            chess[r][c] = 0;
            return;
        }
        chess[r][c] = move;
        printKnightTour(chess, r-2, c+1, move+1);
        printKnightTour(chess, r-1, c+2, move+1);
        printKnightTour(chess, r+1, c+2, move+1);
        printKnightTour(chess, r+2, c+1, move+1);
        printKnightTour(chess, r+2, c-1, move+1);
        printKnightTour(chess, r+1, c-2, move+1);
        printKnightTour(chess, r-1, c-2, move+1);
        printKnightTour(chess, r-2, c-1, move+1);

        chess[r][c] = 0;
    }

    private static void displayBoard(int[][] chess){

        for(int i =0; i< chess.length; i++){
            for(int j =0; j<chess[i].length; j++){
                System.out.print(chess[i][j]+"\t");
            }
            System.out.println();
        }
    }

    private static int[][] populateChessBoard(){

        int[][] chess = new int[5][5];
        chess[0] = new int[]{1, 2, 3, 4, 5};
        chess[1] = new int[]{6, 7, 8, 9, 10};
        chess[2] = new int[]{11, 12, 13, 14, 15};
        chess[3] = new int[]{16, 17, 18, 19, 20};
        chess[4] = new int[]{21, 22, 23, 24, 25};

        return chess;
    }
    
    private static void printNqueen(int[][] chess, String asf, int row){

        if(row == chess.length){
            System.out.println(asf+",");
            return;
        }
        for(int col =0; col < chess.length; col++){
            if(isSafePlaceForQueen(chess, row, col)){
                chess[row][col] = 1;
                printNqueen(chess, asf + row + "-" + col + ",", row + 1);
                chess[row][col] = 0;
            }
        }
    }

    private static boolean isSafePlaceForQueen(int[][] chess, int row, int col){

        for(int i =row-1, j = col; i >= 0; i--){
            if(chess[i][j] == 1){
                return false;
            }
        }

        for(int i =row-1, j = col-1; i >= 0 && j>=0; i--, j--){
            if(chess[i][j] == 1){
                return false;
            }
        }

        for(int i =row-1, j = col+1; i >= 0 && j< chess.length; i--, j++){
            if(chess[i][j] == 1){
                return false;
            }
        }

        return true;

    }

    private static void targetSumSubset(int[] input, int idx, String set, int sos, int target){

        if(idx == input.length){
            if(sos == target){
                System.out.println(set);
            }
            return;
        }

        targetSumSubset(input, idx+1, set + input[idx]+ ", ",sos+input[idx], target);
        targetSumSubset(input, idx+1, set, sos, target);


    }

    private static void floodFill(int[][] arr, int row, int col, boolean[][] visited, String asf){

        if(row<0 || col<0 || row == arr.length || col == arr.length
                || arr[row][col] == 1 || visited[row][col] == true){
            return;

        }

        if(row == arr.length-1 && col == arr.length-1){
            System.out.println(asf);
        }
        visited[row][col] = true;
        floodFill(arr, row-1, col, visited, "t");
        floodFill(arr, row, col-1, visited, "l");
        floodFill(arr, row+1, col, visited, "d");
        floodFill(arr, row, col+1, visited, "r");
        visited[row][col] = false;
    }

    private static void printEncoding(String input, String asf){

        if(input.length() == 0){
            System.out.println(asf);
            return;
        } else if(input.length() == 1){
            char ch  = input.charAt(0);
            if(ch == '0'){
                return;
            } else {
                int chv = ch - '0';
                char code = (char)('a' + chv - 1);
                System.out.println(asf+code);
            }
        } else {
            char ch  = input.charAt(0);
            String roq = input.substring(1);
            if(ch == '0'){
                return;
            } else {
                int chv = ch - '0';
                char code = (char)('a' + chv - 1);
                printEncoding(roq, asf+code);
            }

            String ch12 = input.substring(0,2);
            int ch12v = Integer.parseInt(ch12);
            String roq2 = input.substring(2);
            if(ch12v<=26){
                char code = (char)('a' + ch12v - 1);
                printEncoding(roq2, asf+code);
            }
        }
    }

    private static void printPermutations(String input, String ans){

        if(input.isEmpty()){
            System.out.println(ans);
            return;
        }
        for(int i =0; i<input.length(); i++){
            char ch = input.charAt(i);
            String ros = input.substring(0,i) + input.substring(i+1);

            printPermutations(ros, ans+ch);
        }
    }

    private static void printMazePathJump(int sr, int sc, int dr, int dc, String ans){

        if(sr == dr && sc == dc){
            System.out.println(ans);
            return;
        }
        // horizontal move
        for(int ms = 1; ms<= dc-sc;ms++){
            printMazePathJump(sr, sc+ms,dr,dc,ans+"h"+ms);
        }

        // vertical move
        for(int ms = 1; ms<= dr-sr;ms++){
            printMazePathJump(sr+ms, sc,dr,dc,ans+"v"+ms);
        }

        // diagonal move
        for(int ms = 1; ms<= dc-sc && ms<= dr-sr;ms++){
            printMazePathJump(sr+ms, sc+ms,dr,dc,ans+"d"+ms);
        }
    }

    private static void printMazePath(int sr, int sc, int dr, int dc, String ans){

        if(sr>dr || sc > dc){
            return;
        }
        if(sr == dr && sc == dc){
            System.out.println(ans);
        }
        printMazePath(sr, sc+1, dr, dc, ans+"h");
        printMazePath(sr+1, sc, dr, dc, ans+"v");


    }
    private static void printStairPaths(int n, String ans){

        if(n<0){
            return;
        }
        if(n==0){
            System.out.println(ans);
        }
        printStairPaths(n-1, ans+"1");
        printStairPaths(n-2, ans+"2");
        printStairPaths(n-3, ans+"3");

    }
    private static void printKeypadCombinations(String ques, String ans){

        if(ques.isEmpty()){
            System.out.println(ans);
            return;
        }

        char ch = ques.charAt(0);
        String subSeq = ques.substring(1);

        String codeForch = array[ch-'0'];
        for(int i = 0; i<codeForch.length(); i++){
            char chCode = codeForch.charAt(i);
            printKeypadCombinations(subSeq, ans+ chCode);
        }
    }
    private static void printSubsequence(String ques, String ans){

        if(ques.isEmpty()){
            System.out.println("->"+ans);
            return;
        }

        char ch = ques.charAt(0);
        String roq = ques.substring(1);

        printSubsequence(roq,  ans + ch);
        printSubsequence(roq,ans+ "");
    }
    private static List<String> getMazePathJump(int sr, int sc, int dr, int dc){

        if(sr == dr && sc == dc){
            List<String> basePath = new ArrayList<>();
            basePath.add("");
            return basePath;
        }
        List<String> paths = new ArrayList<>();
        // horizontal moves
        for(int ms=1; ms <= dc - sc; ms++){
            List<String> hPaths = getMazePathJump(sr, sc+ms, dr, dc);
            for(String hpath : hPaths){
                paths.add("h" + ms + hpath);
            }
        }
        // vertical move
        for(int ms=1; ms <= dr - sr; ms++){
            List<String> vPaths = getMazePathJump(sr+ms, sc, dr, dc);
            for(String vpath : vPaths){
                paths.add("v" + ms + vpath);
            }
        }
        // diagonal moves
        for(int ms=1; ms <= dr - sr && ms <= dc - sc; ms++){
            List<String> dPaths = getMazePathJump(sr+ms, sc+ms, dr, dc);
            for(String dpath : dPaths){
                paths.add("d" + ms + dpath);
            }
        }
        return paths;

    }

    private static List<String> getMazePath(int sr, int sc, int dr, int dc){


        if(sr == dr && sc == dc){
            List<String> basePath = new ArrayList<>();
            basePath.add("");
            return basePath;
        }

        List<String> paths1 = new ArrayList<>();
        List<String> paths2 = new ArrayList<>();
        if(sc < dc){
            paths1 =  getMazePath(sr, sc+1, dr, dc);
        }
        if(sr < dr)  {
            paths2 = getMazePath(sr+1, sc, dr, dc);
        }



        List<String> paths = new ArrayList<>();

        for(String path1 : paths1){
            paths.add("h"+path1);
        }

        for(String path2 : paths2){
            paths.add("v"+path2);
        }
        return paths;
    }

    private static List<String> getStairPath(int n){

        if(n == 0){
            List<String> basePath = new ArrayList<>();
            basePath.add("");
            return basePath;
        } else if(n<0){
            List<String> basePath = new ArrayList<>();
            return basePath;
        }

        List<String> paths1 = getStairPath(n-1);
        List<String> paths2 = getStairPath(n-2);
        List<String> paths3 = getStairPath(n-3);

        List<String> paths = new ArrayList<>();
        for(String value : paths1){
            paths.add(1+value);
        }

        for(String value : paths2){
            paths.add(2+value);
        }

        for(String value : paths3){
            paths.add(3+value);
        }

        return paths;
    }
    private static List<String> getKeypadCombinations(String input){

            if(input.isEmpty()){
                List<String> baseArrayList = new ArrayList<>();
                baseArrayList.add("");
                return baseArrayList;
            }
            char ch = input.charAt(0);
            List<String> subSeq = getKeypadCombinations(input.substring(1));

            List<String> result = new ArrayList<>();
            String codeForch = array[ch-'0'];
            for(int i = 0; i<codeForch.length(); i++){
                char chCode = codeForch.charAt(i);
                for(String value : subSeq){
                    result.add(chCode+value);
                }
            }
            return result;
    }

    private static List<String> subsequence(String str){

        if(str.isEmpty()){
            List<String> baseArrayList = new ArrayList<>();
            baseArrayList.add("");
            return baseArrayList;
        }
        char firstChar = str.charAt(0);
        List<String> smallSubSeq = subsequence(str.substring(1));

        List<String> finalSubSeq = new ArrayList<>();
        for(String value : smallSubSeq){
            finalSubSeq.add("" + value);
            finalSubSeq.add(firstChar + value);
        }

        return finalSubSeq;
    }

    private static int[] findAllOccurances(int[] arr, int key, int idx, int occ){
        if(idx == arr.length){
            return new int[occ];
        }

        if(arr[idx] == key){
            int[] arr1 = findAllOccurances(arr, key, idx+1, occ+1);
            arr1[occ] = idx;
            return arr1;
        }else {
            int[] arr1 = findAllOccurances(arr, key, idx+1, occ);
            return arr1;
        }
    }

    private static int lastIndexOfOccurance(int[] arr, int key, int idx){
        if(idx == arr.length){
            return -1;
        }

        int occur = lastIndexOfOccurance(arr, key, idx+1);
        if(occur == -1 && arr[idx] == key){
            return idx;
        }

        return occur;

    }

    private static int firstIndexOfOccurance(int[] arr, int key, int idx){

        if(idx == arr.length){
            return -1;
        }

        if(arr[idx] == key){
            return idx;
        }

        return firstIndexOfOccurance(arr, key, idx+1);

    }
    private static int maxInArray(int[] arr, int idx){
        // there are 2 logics here for base case
        if(idx == arr.length-1){
            return arr[idx];
        }
    /*    if(idx == arr.length){
            return -1;
        }*/

        return Math.max(arr[idx], maxInArray(arr,idx+1));
    }

    private static void displayArray(int[] arr, int idx){

        if(idx == -1){
            return;
        }

        displayArray(arr, idx-1);
        System.out.print(arr[idx] + " ");
    }

    private static void displayArrayReverse(int[] arr, int idx){
        if(idx == arr.length){
            return;
        }

        displayArrayReverse(arr, idx+1);
        System.out.print(arr[idx] + " ");
    }

    private static void incDesc(int k){
        if(k == 0){
           return;
        }
        System.out.println(k);
        incDesc(k-1);
        System.out.println(k);
    }

    private static void towerOfHanoi(int n, String t1, String t2, String t3 ){
        if(n==0){
            return;
        }
        towerOfHanoi(n-1, t1, t3, t2);
        System.out.println(n + "["+t1 + " -> " + t2 + "]");
        towerOfHanoi(n-1, t3, t2, t1);
    }
}
