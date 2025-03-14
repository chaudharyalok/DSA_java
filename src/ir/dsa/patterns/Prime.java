package ir.dsa.patterns;

import java.util.Scanner;

public class Prime {

    public static void main(String args[]){
        System.out.println("Hello world!");
        int n = 10;
    //    System.out.println("Prime numbers upto " + n + " are: ");
       // printPrime(n);
     //   Scanner scn = new Scanner(System.in);
     //   fibonacci(scn.nextInt());
    //    digitCount(scn.nextInt());
    //    digits(scn.nextInt());
    //      inverse(scn.nextInt());
    //    rotate(scn.nextInt(), scn.nextInt());
    //    gcdAndlcm(scn.nextInt(), scn.nextInt());
   //     primeFactors(scn.nextInt());
   //     pytTriplet(scn.nextInt(), scn.nextInt(), scn.nextInt());
    //    pattern1();
    //    pattern2();
    //    pattern3(5);
   //     pattern4(5);
    //    pattern5(5);
    //    pattern6(5);
    //    pattern7(5);
    //    pattern8(5);
   //     pattern9(5);
    //    pattern10(5);
    //    pattern11(10);
     //   pattern12(5);
     //   pattern13(5);
     //   pattern14(10);
    //    pattern15(5);
    //    pattern16(4);
    //    pattern16_(5);
    //    pattern17_arrow(9);
   //     pattern18_time_sand(7);

    //    pattern19_square(5);
   //     pattern20_swastik(7);
   //     print_W(3);
    //    digit_frequency(12344599);
    //    decimal_to_octal(634);
   //     decimal_to_base(634,8);
   //     base_to_decimal(1172,8);
   //     same_base_addition(346, 777, 8);
   //     same_base_subtraction(1212, 256, 8);
        multipleNumbersSameBase(234,76,8);
    }

    private static void printPrime(int n){
        for(int i=2; i<=n; i++){
            if(isPrime(i))
                System.out.print(i + " ");
        }
    }

    private static boolean isPrime(int n){
        if(n<=1)
            return false;
        for(int i=2; i<=Math.sqrt(n); i++){
            if(n%i == 0)
                return false;
        }
        return true;
    }

    private static void fibonacci(int n){
        int a = 0;
        int b = 1;

        for(int i=0; i<n; i++){
            System.out.print(a + " ");
            int c = a+b;
            a = b;
            b = c;
        }
    }

    private static int digitCount(int n){
        int count = 0;
        while(n>0){
            n = n/10;
            count++;
        }
        System.out.println("Number of digits: " + count);
        return count;
    }

    private static void digits(int n){
        int lastmod = 0;
        while(n>0){
            int mod = n%10;
            n = n/10;
            System.out.print(mod + " ");
            lastmod = lastmod*10 + mod;
        }
        System.out.println(lastmod + " ");
    }

    private static void inverse(int n){

        int result = 0;
        int inc = 1;
        while(n>0){

            int mod = n%10;
            result = result + (int)Math.pow(10, mod-1)*inc;
            inc++;
            n = n/10;
        }
        System.out.println("inverse is:" + result );

    }


    private static void rotate(int n, int k){

        int digit = digitCount(n);

       if(k>0) {
           while (k > 0) {
               int rem = n % 10;
               n = n / 10;
               n = (int) Math.pow(10, digit - 1) * rem + n;
               k--;
           }
       } else{
             k = Math.abs(k);
              while (k > 0) {
                int rem = n % (int)Math.pow(10, digit-1);
                n = n / (int)Math.pow(10, digit-1);
                n = rem*10 + n;
                k--;
              }
       }
        System.out.println("rotated number is:" + n );
    }

    private static void rotate1(int n, int k){


    }

    private static void gcdAndlcm(int n1, int n2){

        int on1 = n1;
        int on2 = n2;

        while(n1%n2 !=0){

            int rem = n1%n2;
            n1=n2;
            n2=rem;
        }
        int gcd = n2;
        int lcm = (on1*on2)/gcd;

        System.out.println("gcd:" + gcd );
        System.out.println("lcm:" + lcm );
    }

    private static void primeFactors(int n){

        for(int i = 2; i<=Math.sqrt(n); i++){
            while(n%i == 0){
                System.out.print(i + " ");
                n = n/i;
            }

        }
        if(n!=1){
            System.out.print(n);
        }
    }


    private static void pytTriplet(int a, int b, int c){

        int max = a;
        if(b>max)
            max = b;
        if(c>max)
            max = c;

        if(max == a){
            if(a*a == b*b + c*c)
                System.out.println("Pythagorean Triplet");
            else
                System.out.println("Not a Pythagorean Triplet");
        } else if(max == b){
            if(b*b == a*a + c*c)
                System.out.println("Pythagorean Triplet");
            else
                System.out.println("Not a Pythagorean Triplet");
        } else{
            if(c*c == a*a + b*b)
                System.out.println("Pythagorean Triplet");
            else
                System.out.println("Not a Pythagorean Triplet");
        }
    }

    private static void pattern1(){
        for(int i=0; i<5; i++){
            for(int j=0; j<=i; j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    private static void pattern2(){
        for(int i=5; i>0; i--){
            for(int j=i; j>0; j--){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    private static void pattern3(int n){
         for(int i=0; i<n; i++){
            for(int j=n-1-i; j>0; j--){
                System.out.print("\t");
            }
            for(int k =0; k<=i; k++){
                System.out.print("*\t");
            }
            System.out.println();
        }
    }

    private static void pattern4(int n){
        for(int i=0; i<n; i++){
            for(int j=i; j>0; j--){
                System.out.print("\t");
            }
            for(int k =n-i; k>0; k--){
                System.out.print("*\t");
            }
            System.out.println();
        }

        System.out.println("end");
    }

    private static void pattern5(int n){

        int sp = n/2;
        int st=1;
        for(int i=0; i<n; i++){

            for(int j=0; j<sp;j++){
                System.out.print("\t");
            }

            for(int k=0; k<st;k++){
                System.out.print("*\t");
            }

            if(i<n/2){
                sp--;
                st+=2;
            } else{
                sp++;
                st-=2;
            }
            System.out.println();
        }
    }

    private static void pattern6(int n){

        int st = (n/2)+1;
        int sp = 1;

        for(int i=0; i<n; i++){

            for (int j = 0; j< st; j++) {
                System.out.print("*\t");
            }

            for(int k =0; k<sp; k++){
                System.out.print("\t");
            }

            for (int j = 0; j< st; j++) {
                System.out.print("*\t");
            }

            if(i < n/2){
                st--;
                sp+=2;
            } else{
                st++;
                sp-=2;

            }

            System.out.println();
        }
    }

    private static void pattern7(int n){

        for(int i=0; i<n; i++){

            for(int j =0; j < n; j++){
                if(i==j){
                    System.out.print("*\t");
                }else{
                    System.out.print("\t");
                }
            }
            System.out.println();
        }
    }

    private static void pattern8(int n){

        for(int i=0; i<n; i++){

            for(int j=0; j<n; j++){
                if(i+j == n-1){
                    System.out.print("*\t");
                } else{
                    System.out.print("\t");
                }
            }
            System.out.println();
        }

    }

    private static void pattern9(int n){

        for(int i=0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(i+j == n-1 || i==j){
                    System.out.print("*\t");
                } else{
                    System.out.print("\t");
                }
            }
            System.out.println();
        }
    }

    private static void pattern10(int n){
        int os = n/2;
        int is = -1;
        for(int i=0; i<n; i++){

           for(int j = 1; j<=os; j++){
               System.out.print("\t");
           }
            System.out.print("*\t");

            for(int j = 1; j<=is; j++){
                System.out.print("\t");
            }

            if(i>0 && i<n-1)
                System.out.print("*\t");

            if(i<n/2){
                os--;
                is+=2;

            } else{
                os++;
                is-=2;
            }
            System.out.println();
        }
    }

    private static void pattern11(int n){
         int out_loop = 1;
        for(int i=1; i<=out_loop; i++){
            for(int j = 0; j< i; j++){
                System.out.print(out_loop + " ");
                out_loop++;
            }
            if(out_loop<=n)
                System.out.println();
            else
                break;
        }
    }

    private static void pattern12(int n){

        int a = 0;
        int b = 1;

        for(int i = 0; i<n; i++){
            for(int j =0; j<=i; j++){
                System.out.print(a + "\t");
                int c = a+b;
                a = b;
                b = c;

            }
            System.out.println();
        }
    }

    private static void pattern13(int n){
    // iCj+1 = iCj *(i-j)/ (j+1)
        for(int i=0; i<n; i++){
            int iCj = 1;
            for(int j=0; j<=i; j++){

                System.out.print(iCj+"\t");
                int iCjPlus1 = iCj *(i-j)/ (j+1);
                iCj = iCjPlus1;

            }
            System.out.println();
        }
    }

    private static void pattern14(int n){

        int x = 1;
        int y = 2;

        for(int i = 0; i<n; i++){
            System.out.print(y + " * " + x + " = " + x*y);
            x+=1;
            System.out.println();
        }

    }

    private static void pattern15(int n){
        int sp = n/2;
        int st = 1;
        int p = 1;
        for(int i=0; i<n; i++){
            for(int j=0; j<sp; j++){
                System.out.print("\t");
            }
            int cval = p;
            for(int k =0; k<st;k++){
               System.out.print(cval+"\t");
               if(k<st/2){
                   cval++;
               }else{
                   cval--;
               }
            //   cval++;
            }

            if(i<n/2){
                sp-=1;
                st+=2;
                p++;
            }else{
                sp+=1;
                st-=2;
                p--;
            }
            System.out.println();
        }
    }

    private static void pattern16(int n){

        int p = n+1;
        for(int i =1; i<=n; i++){
            for(int k = 1; k<=i; k++){
                System.out.print(k+"\t");
            }

            for(int j = p; j>0 ; j--){

                System.out.print("\t");

            }

            int m = i;
            if(m==n){
                m--;
            }
            for(int k = m; k>0; k--){
                System.out.print(k+"\t");
            }


            p =p-2;
            System.out.println();
        }
    }

    private static void pattern16_(int n){

        int sp = 2*n-3;
        int st = 1;

        for(int i = 1; i<=n; i++){
            int val =1;
            for(int j=1;j<=st; j++){
                System.out.print(val + "\t");
                val++;

            }

            for(int j = 1; j<=sp; j++){
                System.out.print("\t");

            }

            if(i==n){
                st--;
                val--;
            }
            for(int j=1;j<=st; j++){
                val--;
                System.out.print(val + "\t");

            }

            sp-=2;
            st++;
            System.out.println();
        }

    }

    private static void pattern17_arrow(int n){

        int sp = n/2;
        int st = 1;

        for(int i = 0; i< n; i++){
            for(int j = 0; j< sp; j++){
                if(i==n/2)
                    System.out.print("*\t");
                else
                    System.out.print("\t");

            }

            for(int j = 0; j< st; j++){
                System.out.print("*\t");
            }

            if(i<n/2){
                st+=1;
            } else{
                st-=1;

            }

            System.out.println();
        }
    }

    private static void pattern18_time_sand(int n){

        int sp = 0;
        int st = n;

        for(int i = 0; i<n; i++){

            for(int j = 0; j<sp; j++){
                System.out.print("\t");
            }

            for(int j = 0; j<st; j++){
                if(i>0 && i<n/2 && j>0 && j<st-1){
                    System.out.print("\t");
                } else{
                    System.out.print("*\t");

                }


            }

            if(i<n/2){
                sp++;
                st-=2;
            } else{
                sp--;
                st+=2;
            }
            System.out.println();
        }
    }

    private static void pattern19_square(int n){
        int sp = 0;
        int st = n;
        for(int i=0; i<n; i++){
             for(int j = 0; j<n; j++){
                 if(i ==0 || i == n-1 || j == 0 || j == n-1 || j==n/2 || i==n/2){
                         System.out.print("*\t");

                 } else{
                     System.out.print("\t");

                 }
             }
            System.out.println();
        }
    }

    private static void pattern20_swastik(int n){

        for(int i =1; i<=n ;i++){
            for(int j=1; j<=n;j++){

                if(i == 1 && (j==1 || j>= n/2 +1)){
                    System.out.print("*\t");
                }
                 else if(i < n/2+1 && (j==1 || j == n/2 +1)){
                    System.out.print("*\t");
                }
                  else if(i == n/2 + 1 && (j>=1 || j <=n)){
                    System.out.print("*\t");
                }
                  else if(i > n/2 +1 && (j == n/2 +1 || j ==n)){
                    System.out.print("*\t");
                }
                  else if(i ==n && (j <= n/2 +1 || j ==n)){
                    System.out.print("*\t");
                }
                   else{
                    System.out.print("\t");
                }

            }
            System.out.println();
        }

    }

    private static void print_W(int n){
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(j==0 || j==n-1 || (i==j && i>=n/2) || (i+j == n-1 && i>=n/2)){
                    System.out.print("*\t");
                } else{
                    System.out.print("\t");
                }
            }
            System.out.println();
        }
    }

    private static void digit_frequency(int n){

        int[] freq = new int[10];
        while(n>0){
            int rem = n%10;
            freq[rem]++;
            n = n/10;
        }

        for(int i=0; i<10; i++){
            if(freq[i]>0){
                System.out.println(i + " -> " + freq[i]);
            }
        }

    }

    private static void decimal_to_octal(int n){
        int octal = 0;
        int place = 1;
        while(n>0){
            int rem = n%8;
            octal = octal + rem*place;
            place = place*10;
            n = n/8;
        }
        System.out.println(octal);
    }

    private static void decimal_to_base(int n, int b){

        int result = 0;
        int place = 1;

        while(n>0){
            int rem = n%b;
            result = result + rem*place;
            place = place*10;
            n/=b;
        }

        System.out.println(result);
    }

    private static void base_to_decimal(int n, int b){

        int result = 0;
        int place = 1;

        while(n>0){
          int rem = n%10;
            result = result + rem*place;
            place = place*b;

            n/=10;
        }

        System.out.println(result);
    }

    private static int same_base_addition(int x, int y, int b){

        int result = 0;
        int p = 1;

        int carry = 0;

        while(x>0 || y >0){

            int rem = x%10 + y%10;
            int temp = (carry+rem)%b;


            result = result  + temp*p;

            carry = rem/b;
            p*=10;

            x/=10;
            y/=10;

        }

        if(carry>0){
            result = result + carry*p;
        }

        System.out.println(result);
        return result;
    }

    private static void same_base_subtraction(int n1, int n2, int b){

        int result = 0;
        int p = 1;

        int carry = 0;

        while(n1>0){

            int d1 = n1%10;
            n1/=10;

            int d2 = n2%10;
            n2/=10;

            d1 = d1+carry;
            int d = 0;
            if(d1>=d2){
                d = d1-d2;
                carry = 0;
            }
            else{
                carry = -1;
                d = d1+b-d2;
            }

            result = result + d*p;
            p*=10;

        }

        System.out.println(result);
    }

    private static int multiplyWithSingleDigit(int b, int n1, int d){

        int res = 0;
        int carry = 0;
        int p = 1;

        while(n1 >0 || carry > 0){

            int d1 = n1%10;
            n1/=10;

            int temp = d1*d + carry;
            int rem = temp%b;
            carry = temp/b;

            res = res + rem*p;

            p*=10;

        }
        System.out.println(res);
        return res;
    }

    private static void multipleNumbersSameBase(int n1, int n2, int b){

        int result = 0;
        int p = 1;
        while(n2>0){

            int d1 = n2%10;
            n2/=10;
            int temp = multiplyWithSingleDigit(b,n1, d1);

            result = same_base_addition(result,temp*p, b );

            p*=10;
        }

        System.out.println("multiplication result: " +result);
    }



    private static void patternx(int n){

        int sp = 0;
        int st = n;
        for(int i=0; i<n; i++){

            for(int j=0; j<sp; j++){
                System.out.print("\t");
            }

            for(int k=0; k<st; k++){
                System.out.print("*\t");
            }

            if(i<n/2){
                sp++;
                st-=2;
            } else{
                sp--;
                st+=2;
            }
            System.out.println();
        }

    }
}
