package ir.dsa.patterns;

import java.util.*;

public class MiscProblems {
    public static void main(String args[]) {
        System.out.println("Hello in MiscProblems world!");
    //    celebrity(new int[][]{{0,0,0,1,0},{0,0,0,1,0},{1,1,0,1,1},{0,0,0,0,0},{0,0,0,1,0}});
    //    mergeOverlapping();
        getUniqueItems();
    }

    private static void mergeOverlapping(){
        List<Interval> intervalList = new ArrayList<>();
        Interval one  = new Interval(22,28);
        Interval two  = new Interval(1,8);
        Interval three  = new Interval(25,27);
        Interval four  = new Interval(14,19);
        Interval five  = new Interval(27,30);
        Interval six  = new Interval(5,12);
        intervalList.add(one);
        intervalList.add(two);
        intervalList.add(three);
        intervalList.add(four);
        intervalList.add(five);
        intervalList.add(six);
        Collections.sort(intervalList);

        Stack<Interval> stack = new Stack<>();

        stack.push(intervalList.get(0));
        for(int i=1; i<intervalList.size(); i++){

            Interval temp = stack.peek();
            Interval itr = intervalList.get(i);

            if(itr.start <= temp.end){
                // merge with end of bigger
                if(temp.end <= itr.end){
                    temp.end = itr.end;
                }
            } else {
                stack.push(itr);
            }

        }

        Stack<Interval> result = new Stack<>();
       while(stack.size()>0){
           result.push(stack.pop());
       }

        while(result.size()>0){
            Interval res = result.pop();
            System.out.println("merged intervals: "+res.start + "-"+res.end);
        }





    }
    private static void celebrity(int arr[][]){

        Stack<Integer> st = new Stack<>();
        for(int i=0; i< arr.length;i++){
            st.push(i);
        }

        while(st.size()>=2){

            int i = st.pop();
            int j = st.pop();
            if(arr[i][j] == 1){
                // if i knows j, i is not celebrity
                st.push(j);
            } else{
                // if i doesn't know j, j is not celebrity
                st.push(i);
            }
        }

        int pot = st.pop();
        for(int j = 0; j<arr.length; j++){

            if(j != pot){

                if(arr[j][pot] == 0 || arr[pot][j] == 1){
                    System.out.println("none");
                    return;
                }
            }
        }
        System.out.println("celebrity is: "+ pot);
    }

    private static class Interval implements Comparable<Interval> {
        private int start;
        private int end;

        private Interval(int start, int end){
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Interval o) {
            return this.start - o.start;
        }
    }


    private static void getUniqueItems(){

        String[] arr = {
                "10101011343472",
                "10101013317826",
                "10101013518148",
                "10101013599826",
                "10101014030504",
                "10101014030504",
                "10101014030504",
                "10101014030504",
                "10101014084880",
                "10101014780438",
                "10101014780438",
                "10101014780438",
                "10101014780438",
                "10101014780438",
                "10101014780438",
                "10101015973794",
                "10101015973794",
                "10101015973794",
                "10101016775386",
                "10101016908840",
                "10101016908840",
                "10101017724918",
                "10101017724918",
                "10101019434488",
                "10101019434488",
                "10101019434488",
                "10101019434488",
                "10101019486270",
                "10101019486270",
                "10101019527698",
                "10101019778138",
                "10101019778138",
                "10101019843750",
                "10101019843750",
                "10101019843750",
                "10101019843750",
                "10101019913918",
                "10101019985944",
                "10101019985944",
                "10101019994120",
                "10101019994120",
                "10101020247642",
                "10101020247642",
                "10101020272762",
                "10101020272762",
                "10101020272762",
                "10101020282006",
                "10101020282006",
                "10101020282006",
                "10101020408566",
                "10101020408566",
                "10101020408566",
                "10101020546532",
                "10101020546532",
                "10101021061092",
                "10101021694386",
                "10101021694386",
                "10101021821274",
                "10101021821274",
                "10101021821274",
                "10101021821446",
                "10101021821446",
                "10101021821446",
                "10101021821446",
                "10101021821446",
                "10101022199106",
                "10101022437832",
                "10101022549548",
                "10101022572032",
                "10101022716514"
        };
        Set<String> set = new HashSet<>();
        for(String x : arr){
            set.add(x);
        }
        System.out.println("array size: "+ arr.length + "unique items: " +set.size() );

        set.stream().forEach(x->  System.out.println(x));
    ;
    }

}
