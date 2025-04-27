package ir.java.generics.collection;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArratLists{
    public static void main(String arr[]) {
        System.out.println("welcome to arraylist");
        List<String> lists = new ArrayList<>();

        lists.add("ana");
        lists.add("bob");
        lists.add("marley");

        String[] array = lists.toArray(new String[lists.size()]);
        for(String a: array){
            System.out.println(a);
        }

        List<Integer> list = Arrays.asList(1,2,3,4);
        reverse(list);
        System.out.println(list);

    }

    private static void reverse(List<Integer> list){
        int startIndex = 0;
        int endIndex = list.size()-1;
        while(startIndex < endIndex){
            Integer value1 = list.get(endIndex);
            Integer value2 = list.get(startIndex);
            list.set(startIndex,value1);
            list.set(endIndex,value2);
            startIndex++;
            endIndex--;
        }
    }
}
