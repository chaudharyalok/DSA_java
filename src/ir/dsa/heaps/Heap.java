package ir.dsa.heaps;

import java.util.*;

public class Heap {

    public static void main(String args[]) {
        System.out.println("welcome to heaps!");
/*        int[] input = {2,14,7,8,1,11,24,21};
        select(input, 4);*/

 /*       int[] input1 = {2,3,1,4,6,7,5,8,9};
        kSorted(input1,2);*/

/*        int[] inputMedianPQ = {5,10,20,30,40,50};
        for(int v : inputMedianPQ){
            add(v);
        }

        System.out.println(remove());
        System.out.println(peek());*/

/*        int[] input = {10,20,30,40,50,5,7,9,11,19,55,57,1,2,3,32,39};
        int[] index = {5,7,3,2};
        int[] final_array = mergeSortedList(input,index);

        for(int value : final_array){
            System.out.println(value);
        }*/

/*        List<List<Integer>> listOfList = new ArrayList<>();
        List<Integer> list1 = Arrays.asList(10,20,30,40,50);
        List<Integer> list2 = Arrays.asList(5,7,9,11,19,55,57);
        List<Integer> list3 = Arrays.asList(1,2,3);
        List<Integer> list4 = Arrays.asList(32,39);

        listOfList.add(list1);
        listOfList.add(list2);
        listOfList.add(list3);
        listOfList.add(list4);

        mergeKsortedList(listOfList);*/

        int[] heap_array = {3,1,7,2,4,0};
        heapSort(heap_array);
    }

    // k largest element in an array
    private static void select(int[] input, int k){

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i=0; i< input.length; i++){
            if(i<k){
                queue.add(input[i]);
            }
            else{
                if(input[i] > queue.peek()){
                    queue.poll();
                    queue.add(input[i]);
                }
            }
        }

        while(!queue.isEmpty()){
            System.out.print(queue.poll()+" ");
        }

    }

    // sort nearly sorted array
    private static void kSorted(int[] input, int k){
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for(int i=0; i<=k; i++){
            queue.add(input[i]);
        }

        for(int j=k+1; j<input.length; j++){
            queue.add(input[j]);
            System.out.print(queue.poll() + ",");
        }

        while(!queue.isEmpty()){
            System.out.print(queue.poll()+",");
        }

    }

    public static PriorityQueue<Integer> leftQ = new PriorityQueue<>(Collections.reverseOrder());
    public static PriorityQueue<Integer> rightQ = new PriorityQueue<>();

    public static void add(int element){

        if(rightQ.size()>0 && element > rightQ.peek()){
            rightQ.add(element);
        } else{
            leftQ.add(element);
        }

        if(leftQ.size() - rightQ.size() == 2){
            rightQ.add(leftQ.remove());
        } else if (rightQ.size() - leftQ.size() == 2) {
            leftQ.add(rightQ.remove());
        }
    }

    public static int peek(){
        if(size() == 0){
            System.out.print("underflow");
            return -1;
        } else if(leftQ.size() >= rightQ.size()){
            return leftQ.peek();
        } else{
            return rightQ.peek();
        }
    }

    public static int remove(){
        if(size() == 0){
            System.out.print("underflow");
            return -1;
        } else if(leftQ.size() >= rightQ.size()){
            return leftQ.remove();
        } else{
            return leftQ.remove();
        }
    }

    public static int size(){
        return leftQ.size() + rightQ.size();
    }

    public static int[] mergeSortedList(int[] array, int[] listSize){

        int[] X = new int[listSize[0]];
        // fill X array
        for(int j = 0; j< listSize[0];j++){
            X[j] = array[j];
        }
        int nextIndex = listSize[0];

        for(int i = 1; i<listSize.length; i++){
            int tempArrayLength = listSize[i];
            int[] tempArray = new int[tempArrayLength];
            for(int k = 0; k< tempArrayLength; k++){
                tempArray[k] = array[nextIndex+k];

            }
            int[] final_array = merge(X,tempArray);
            X = final_array;


            nextIndex+=tempArrayLength;
        }


        return X;
    }

    public static int[] merge(int[] array1, int[] array2){

        int[] output = new int[array1.length+ array2.length];
        int i=0;
        int j=0;
        int k=0;

        while(i<array1.length && j<array2.length) {
            if(array1[i] < array2[j]) {
                output[k] = array1[i];
                i++;
                k++;
            } else{
                output[k] = array2[j];
                j++;
                k++;
            }
        }

        while(i<array1.length){
            output[k] = array1[i];
            i++;
            k++;
        }

        while(j<array2.length){
            output[k] = array2[j];
            j++;
            k++;
        }

        return output;
    }

    public static class Pair implements Comparable<Pair>{
        int li;
        int di;
        int val;

        public Pair(int li, int di, int val){
            this.di = di;
            this.li = li;
            this.val = val;
        }

        @Override
        public int compareTo(Pair o) {
            return this.val - o.val;
        }
    }

    public static void mergeKsortedList(List<List<Integer>> list){
        PriorityQueue<Pair> queue = new PriorityQueue<>();
        List<Integer> rv = new ArrayList<>();
        for(int i = 0; i< list.size(); i++){
            Pair pair = new Pair(i, 0, list.get(i).get(0));
            queue.add(pair);
        }

        while(queue.size()>0){
            Pair p = queue.remove();
            rv.add(p.val);
            p.di++;

            if(p.di < list.get(p.li).size()){
                p.val = list.get(p.li).get(p.di);
                queue.add(p);
            }
        }
        System.out.print(rv);
    }

    public static void heapSort(int[] input){
        int n = input.length;
        for(int i = input.length/2 -1;i >=0; i--){
            heapify(input,n,i);
        }


        for(int j =input.length-1; j>0; j--){
           swap(input,0, j);
           heapify(input,j,0);
        }

        for(int v : input){
            System.out.print(v+",");
        }
    }

    public static void heapify(int[] input,int n,  int i){

       int largest = i;
       int l = 2*i+1;
       int r = 2*i+2;

       if(l<n && input[l]>input[largest]){
            largest = l;
       }

        if(r<n && input[r]>input[largest]){
            largest = r;
        }

        if(largest != i){
            swap(input, i, largest);
            heapify(input, n, largest);
        }

    }

    public static void swap(int[] input, int i , int j){
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }

    // priority queue using heap

    public static List<Integer> data = new ArrayList<>();

    public static int sizeOp(){
        return data.size();
    }
    public static int peekOp(){
        if(sizeOp() == 0){
            System.out.print("underflow");
            return -1;
        }

        return data.get(0);
    }

    public static int removeOp(){
        if(sizeOp() == 0){
            System.out.print("underflow");
            return -1;
        }


        swap(0, data.size()-1);
        int val = data.remove(sizeOp()-1);
        downheapify(0);
        return val;

    }

    public static void addOp(int val){
        data.add(val);
        upheapify(data.size()-1);
    }

    public static void upheapify(int i){
        if(i==0){
            return;
        }
        int parent = (i-1)/2;
        if(data.get(i) < data.get(parent)){
            swap(i, parent);
            upheapify(parent);
        }
    }

    public static void downheapify(int i){

        int min = i;
        int l = 2*i+1;
        int r = 2*i+2;

        if(l<sizeOp() && data.get(l) < data.get(min)){
            min = l;
        }

        if(r<sizeOp() && data.get(r) < data.get(min)){
            min = r;
        }

        if(min != i){
            swap(min, i);
            downheapify(min);
        }
    }

    public static void swap(int i, int j){
        int tempi = data.get(i);
        int tempj = data.get(j);

        data.set(i,tempj );
        data.set(j, tempi);
    }


}
