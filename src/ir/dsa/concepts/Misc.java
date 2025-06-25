package ir.dsa.concepts;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Misc {

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd MMM yyyy");
    public static void main(String[] args)
    {

     //   dateTOLocalDate();
     //   nullCheck();

        int[] arr = {2,4,12,10,6,45};

        int smallest = Integer.MAX_VALUE;
        int sec_smallest = Integer.MAX_VALUE;
        for(int a: arr){
            if(a < smallest){
                sec_smallest = smallest;
                smallest = a;
            } else if(a < sec_smallest){
                sec_smallest = a;
            }
        }
        System.out.println("smallest:" + smallest + " sec smallest:"+sec_smallest);
    }

    private static void availableDateLogic(){
        System.out.println("Hello world!");
        ArrayList<String> dates = new ArrayList<>(Arrays.asList("3","6","9","12","18","24","27"));
        //  dates.remove("6");
        String currentBill = "6";


        LocalDate localDate = LocalDate.now();
        for(String date : dates) {
            boolean isCurrentBill = false;
            LocalDate startLocalDate = localDate.withDayOfMonth(Integer.valueOf(date));
            LocalDate endLocalDate = startLocalDate.plusMonths(1).minusDays(1);
            String startDate = startLocalDate.format(DATE_FORMATTER);
            String endDate = endLocalDate.format(DATE_FORMATTER);

            System.out.println("billday:"+date +" startDate: " + startDate + " endDate: " + endDate + "isCurrentBill" + currentBill.equals(date));
        }
    }

    private static void dateTOLocalDate(){

         DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
         LocalDate dt = LocalDate.parse("12/10/2024", dtf);
        System.out.println("date:"+dt.toString());

    }

    private static void nullCheck(){
        Person person = new Person();
        person.age = 10;

        List<String> list = new ArrayList<>();
        list.add("abc");
        person.friends = list;

        boolean isFriend = Optional.ofNullable(person.friends).orElse(Collections.emptyList()).contains("abc");

        System.out.println(isFriend);

    }

    private static class Person{
        int age;
        List<String> friends;
    }
}
