package ir.dsa.concepts;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;

public class Misc {

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd MMM yyyy");
    public static void main(String[] args)
    {

        dateTOLocalDate();

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
}
