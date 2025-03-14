package ir.dsa.patterns;

import java.util.ArrayList;
import java.util.Stack;

public class StackConcepts {
    public static void main(String args[]) {
        System.out.println("Hello in stacks world!");
     //   duplicateBracket("(a+b)+((c+d))");
     //   balancedBracket("[(a+b)+((c+d))}");
    //    nextGreaterElement(new int[]{2,5,9,3,1,12});
    //    nextGreaterElement_Approach2(new int[]{2,5,9,3,1,12});
    //    stockSpan_greaterLeft(new int[]{2,5,9,3,1,12,6,8,7});
    //    largestRectangleArea(new int[]{6,2,5,4,5,1,6});
    //    infixEvaluation("((2+((6*4)/8))-3)");
    //    infixToPostfixPrefix("a*(b-c)/d+e");
        postfixToValueInfixPrefix("264*8/+3-");
   //     prefixToValueInfixPostfix("-+2/*6483");
   //     smallestNumberSpecificPattern("ddiddidd");
/*        NormalStack stack = new NormalStack(5);
        stack.add(5);
        stack.add(2);
        stack.add(6);
        stack.head();
        stack.add(1);
        stack.add(4);
        stack.add(8);
        stack.head();
        stack.display();
        stack.pop();
        stack.display();*/

    /*    DynamicStack dstack = new DynamicStack(4);
        dstack.add(5);
        dstack.add(2);
        dstack.add(6);
        dstack.add(1);
        dstack.add(9);
        dstack.head();
        dstack.add(1);
        dstack.display(); */


        // question mini stack
        // maintain 2 stacks: 1. alldata 2. mindata
        // for each element push in both(if element < top of mindata, then push it in mindata as well)
        // to pop, if same element on both stacks then pop from both, otherwise from alldata only
        // to return min element, pop from mindata stack

        MinStackConsTimeSize minStack = new MinStackConsTimeSize(6);
         minStack.push(8);
         minStack.push(47);
         minStack.push(7);

         minStack.push(2);
         minStack.size();
         minStack.min();

         minStack.pop();

        minStack.size();
        minStack.min();


    }




    private static class MinStackConsTimeSize{
        int arr[];
        int top;
        int min;
        private MinStackConsTimeSize(int capacity){
            arr = new int[capacity];
            top = -1;
        }

        private void size(){
            System.out.println("size:"+(top+1));
        }

        private void push(int item){
            if(top==arr.length-1) {
                  System.out.println("Stack overflow");
                  return;
            }
            if(top+1 ==0){
                top++;
                arr[top] = item;
                min = item;
            }

          else if(item> arr[top]){
              top++;
              arr[top] = item;
            } else{
                top++;
                int fakeValue = item+item-min;
                arr[top] = fakeValue;
                min = item;
            }

        }

        private void pop(){
            int value;
            if(top<0){
                System.out.println("Stack underflow");
                return;
            }

            if(arr[top]>=min){
              value = arr[top];
              top--;
            } else{

                    int ov = min;
                    min = 2*min - arr[top];
                    value = ov;
                    top--;
            }
            System.out.println("pop value:"+value);
        }

        private void min(){
            System.out.println("mini:"+min);
        }

    }

    private static class DynamicStack{

        int arr[];
        int top;
        private DynamicStack(int capacity){
            arr = new int[capacity];
            top = -1;
        }

        private void add(int item){
            if(top==arr.length-1){
          //  System.out.println("Stack overflow")
                // double the capacity and copy all elements in new
                int[] temp = new int[arr.length*2];
                for(int i=0; i<arr.length; i++){
                    temp[i] = arr[i];
                }
                arr = temp;
           //     return;
            }
            top++;
            arr[top] = item;
        }

        private void display(){
            for(int x=top;x>-1;x--){
                System.out.print(arr[x]+" ");
            }
            System.out.println();
        }

        private void pop(){
            if(top==-1){
                System.out.println("Stack underflow");
                return;
            }
            int item = arr[top];
            //    arr[top] = 0;
            top--;
            System.out.println("top:"+item);
        }

        private void head(){
            if(top==-1){
                System.out.println("Stack underflow");
                return;
            }
            int item = arr[top];
            System.out.println("head:"+item);
        }

    }
    private static class NormalStack{

        int arr[];
        int top;
        private NormalStack(int capacity){
            arr = new int[capacity];
            top = -1;
        }

        private void add(int item){
            if(top==arr.length-1){
                System.out.println("Stack overflow");
                return;
            }
            top++;
            arr[top] = item;
        }

        private void display(){
            for(int x=top;x>-1;x--){
                System.out.print(arr[x]+" ");
            }
            System.out.println();
        }

        private void pop(){
            if(top==-1){
                System.out.println("Stack underflow");
                return;
            }
            int item = arr[top];
        //    arr[top] = 0;
            top--;
            System.out.println("top:"+item);
        }

        private void head(){
            if(top==-1){
                System.out.println("Stack underflow");
                return;
            }
            int item = arr[top];
            System.out.println("head:"+item);
        }

    }

    private static void smallestNumberSpecificPattern(String input){

        Stack<Integer> st = new Stack<>();
        int num = 1;

        for(int i=0; i<input.length(); i++){

            if(input.charAt(i) == 'd'){
                st.push(num);
                num++;
            } else{
                st.push(num);
                num++;

                while(st.size()>0){
                    System.out.print(st.pop() + " ");
                }
            }
        }
        st.push(num);

        while(st.size()>0){
            System.out.print(st.pop() + " ");
        }

    }

    private static void prefixToValueInfixPostfix(String prefix){
        Stack<Integer> valueStack = new Stack<>();
        Stack<String> postfixStack = new Stack<>();
        Stack<String> infixStack = new Stack<>();

        for(int i=prefix.length()-1; i>=0; i--){
            if(Character.isDigit(prefix.charAt(i))){
                valueStack.push(Character.getNumericValue(prefix.charAt(i)));
                postfixStack.push(String.valueOf(prefix.charAt(i)));
                infixStack.push(String.valueOf(prefix.charAt(i)));
            } else if(prefix.charAt(i) == '+' || prefix.charAt(i) == '-' || prefix.charAt(i) == '*' || prefix.charAt(i) == '/'){

                // for valueStack
                int a_value = valueStack.pop();
                int b_value = valueStack.pop();
                int value = operation(a_value,b_value,prefix.charAt(i));
                valueStack.push(value);

                // for postfixStack
                String a_post = postfixStack.pop();
                String b_post = postfixStack.pop();
                String value_post = a_post+b_post+prefix.charAt(i);
                postfixStack.push(value_post);

                // for infix
                String a_in = infixStack.pop();
                String b_in = infixStack.pop();
                String value_in = "("+a_in+prefix.charAt(i)+b_in+")";
                infixStack.push(value_in);
            }

        }
        System.out.println("value result:" + valueStack.peek());
        System.out.println("postfix result:" + postfixStack.peek());
        System.out.println("infix result:" + infixStack.peek());

    }

    private static void postfixToValueInfixPrefix(String postfix){
        Stack<Integer> valueStack = new Stack<>();
        Stack<String> prefixStack = new Stack<>();
        Stack<String> infixStack = new Stack<>();

        for(int i=0; i<postfix.length(); i++){
            if(Character.isDigit(postfix.charAt(i))){
                valueStack.push(Character.getNumericValue(postfix.charAt(i)));
                prefixStack.push(String.valueOf(postfix.charAt(i)));
                infixStack.push(String.valueOf(postfix.charAt(i)));
            } else if(postfix.charAt(i) == '+' || postfix.charAt(i) == '-' || postfix.charAt(i) == '*' || postfix.charAt(i) == '/'){

                // for valueStack
                int b = valueStack.pop();
                int a = valueStack.pop();
                int value = operation(a,b,postfix.charAt(i));
                valueStack.push(value);

                // for infixStack
                String b_in = infixStack.pop();
                String a_in = infixStack.pop();
                String value_in = "("+a_in+postfix.charAt(i)+b_in+")";
                infixStack.push(value_in);

                // for prefixStack
                String b_pre = prefixStack.pop();
                String a_pre = prefixStack.pop();
                String value_pre = postfix.charAt(i)+a_pre+b_pre;
                prefixStack.push(value_pre);

            }

        }
        System.out.println("value result:" + valueStack.peek());
        System.out.println("prefix result:" + prefixStack.peek());
        System.out.println("infix result:" + infixStack.peek());

    }

    private static void infixToPostfixPrefix(String infix){

        Stack<String> prefixStack = new Stack<>();
        Stack<Character> operatorStack = new Stack<>();
        Stack<String> postfixStack = new Stack<>();

        for(int i=0; i<infix.length(); i++){

            if(infix.charAt(i) == '('){
                operatorStack.push(infix.charAt(i));

            } else if(infix.charAt(i) >= 'a' && infix.charAt(i) <= 'z'){
                prefixStack.push(String.valueOf(infix.charAt(i)));
                postfixStack.push(String.valueOf(infix.charAt(i)));
            } else if(infix.charAt(i) == ')'){
                while(operatorStack.peek() != '('){
                    String op = String.valueOf(operatorStack.pop());
                    // for prefix
                    String v2_pre = prefixStack.pop();
                    String v1_pre = prefixStack.pop();
                    String exp_prefix = op+v1_pre+v2_pre;
                    prefixStack.push(exp_prefix);

                    //for postfix
                    String v2_post = postfixStack.pop();
                    String v1_post = postfixStack.pop();
                    String exp_postfix = v1_post+v2_post+op;
                    postfixStack.push(exp_postfix);

                }
                operatorStack.pop();
            } else if(infix.charAt(i) == '+' || infix.charAt(i) == '-' || infix.charAt(i) == '*' || infix.charAt(i) == '/'){

                while(operatorStack.size()>0 && operatorStack.peek() != '(' && precedense(infix.charAt(i)) <= precedense(operatorStack.peek())) {
                    String op = String.valueOf(operatorStack.pop());
                    // for prefix
                    String v2_pre = prefixStack.pop();
                    String v1_pre = prefixStack.pop();
                    String exp_prefix = op+v1_pre+v2_pre;
                    prefixStack.push(exp_prefix);

                    //for postfix
                    String v2_post = postfixStack.pop();
                    String v1_post = postfixStack.pop();
                    String exp_postfix = v1_post+v2_post+op;
                    postfixStack.push(exp_postfix);

                }
                operatorStack.push(infix.charAt(i));
            }

        }

        while(operatorStack.size()>0){

            String op = String.valueOf(operatorStack.pop());
            // for prefix
            String v2_pre = prefixStack.pop();
            String v1_pre = prefixStack.pop();
            String exp_prefix = op+v1_pre+v2_pre;
            prefixStack.push(exp_prefix);

            //for postfix
            String v2_post = postfixStack.pop();
            String v1_post = postfixStack.pop();
            String exp_postfix = v1_post+v2_post+op;
            postfixStack.push(exp_postfix);
        }

        System.out.println("prefix result:" + prefixStack.peek());
        System.out.println("postfix result:" + postfixStack.peek());
    }

    private static void infixEvaluation(String exp){

        Stack<Character> operators = new Stack<>();
        Stack<Integer> operents = new Stack<>();

        for(int i=0; i<exp.length(); i++){

            if(exp.charAt(i) == '('){
                operators.push(exp.charAt(i));
            } else if(Character.isDigit(exp.charAt(i))){
                operents.push(exp.charAt(i) - '0');
            } else if(exp.charAt(i) == ')'){
                while(operators.peek() != '('){
                    char op = operators.pop();
                    int v2 = operents.pop();
                    int v1 = operents.pop();

                    int temp = operation(v1,v2,op);
                    operents.push(temp);
                }
                operators.pop();
            } else if(exp.charAt(i) == '+' || exp.charAt(i) == '-' || exp.charAt(i) == '*' || exp.charAt(i) == '/'){

                while(operators.size()>0 && operators.peek() != '(' && precedense(exp.charAt(i)) <= precedense(operators.peek())){

                    char op = operators.pop();
                    int v2 = operents.pop();
                    int v1 = operents.pop();

                    int temp = operation(v1,v2,op);
                    operents.push(temp);
                }
                operators.push(exp.charAt(i));
            }
        }

        while(operators.size()>0){
            char op = operators.pop();
            int v2 = operents.pop();
            int v1 = operents.pop();

            int temp = operation(v1,v2,op);
            operents.push(temp);
        }

        System.out.println("infix result:" + operents.peek());
    }

    private static int operation(int v1, int v2, char op){
        if(op == '+'){
            return v1+v2;
        } else if(op == '-'){
            return v1-v2;
        } else if(op == '*'){
            return v1*v2;
        } else{
            return v1/v2;
        }
    }

    private static int precedense(char opt){
        if(opt == '+' || opt == '-'){
            return 1;
        } else if(opt == '*'){
            return 2;
        } else{
            return 2;
        }
    }

    private static void largestRectangleArea(int arr[]){

        int rb[] = new int[arr.length]; // nse on the right
        Stack<Integer> stack = new Stack<>();
        stack.push(arr.length-1);
        rb[arr.length-1] = arr.length;

        for(int i = arr.length-2; i>=0; i--){

            while(!stack.isEmpty() && arr[i] < arr[stack.peek()]){
                stack.pop();
            }

            if(stack.isEmpty()){
                rb[i] = arr.length;
            } else{
                rb[i] = stack.peek();
            }
            stack.push(i);
        }

        stack.clear();

        int lb[] = new int[arr.length]; // nse on the left

        lb[0] = -1;
        stack.push(0);

        for(int j = 1; j<arr.length; j++) {
            {
                while (!stack.isEmpty() && arr[j] < arr[stack.peek()]) {
                    stack.pop();

                }

                if (stack.isEmpty()) {
                    lb[j] = -1;
                } else {
                    lb[j] = stack.peek();
                }

                stack.push(j);
            }



        }
        int max = Integer.MIN_VALUE;

        for (int k = 0; k < arr.length; k++) {

            int width = rb[k] - lb[k] - 1;
            int area = width * arr[k];
            if (area > max) {
                max = area;
            }
        }

        System.out.println("max area:" + max);
    }

    private static void stockSpan_greaterLeft(int arr[]){
        Stack<Integer> stack = new Stack<>();
        int result[] = new int[arr.length];
        for(int j= 0;j<arr.length;j++){
            result[j] = 1;
        }
        stack.push(0);
        for(int i= 1;i<arr.length;i++){
            while(!stack.empty() && arr[i] >arr[stack.peek()]){
                stack.pop();
            }

            if(stack.empty())  {
                result[i] = i+1;
            } else{
                result[i] = i-stack.peek();
            }
            stack.push(i);
        }

        for(int k= 0;k<arr.length;k++){
            System.out.println(arr[k] + "->" + result[k]);
        }

    }

    private static void nextGreaterElement(int arr[]){
        Stack<Integer> stack = new Stack<>();
        int length = arr.length;
        ArrayList<Integer> result = new ArrayList<>();
        for(int i : arr){
            result.add(-1);
        }
        for(int i=length-1; i>=0; i--){
            while(!stack.isEmpty() && stack.peek() <= arr[i]){
                stack.pop();
            }
            if(!stack.isEmpty()){
                result.set(i, stack.peek());
            }
            stack.push(arr[i]);
        }
        for(int i=0; i<length; i++){
            System.out.println(arr[i] + "->" + result.get(i));
        }
    }

    private static void nextGreaterElement_Approach2(int arr[]){
        int result[] = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for(int i=1; i<arr.length; i++){
            while(stack.size()>0 && arr[i]>= arr[stack.peek()]){
                int pos = stack.peek();
                result[pos] = arr[i];
                stack.pop();
            }
            stack.push(i);
        }
        while(stack.size()>0 ){
            result[stack.pop()] = -1;
        }
        for(int i=0; i<arr.length; i++){
            System.out.println(arr[i] + "->" + result[i]);
        }
    }

    private static void balancedBracket(String input){

        Stack<Character> stack = new Stack<>();
        int length = input.length();
        for(int i = 0; i< length; i++){
            char c = input.charAt(i);

            if(c == '(' || c == '{' || c == '['){
                stack.push(c);
            } else if(c == ')' || c == '}' || c == ']'){
                if(stack.isEmpty()){
                    System.out.println("Not balanced");
                    return;
                }
                char top = stack.pop();
                if(c == ')' && top != '('){
                    System.out.println("Not balanced");
                    return;
                }
                if(c == '}' && top != '{'){
                    System.out.println("Not balanced");
                    return;
                }
                if(c == ']' && top != '['){
                    System.out.println("Not balanced");
                    return;
                }
            }

        }
    }

    private static void duplicateBracket(String input){

        Stack<Character> stack = new Stack<>();
        int length = input.length();
        for(int i = 0; i< length; i++){
            char c = input.charAt(i);

            if(c == ')'){

                if(stack.peek() == '('){
                    System.out.println("Duplicate found");
                    return;
                } else{
                    while(stack.peek() != '('){
                        stack.pop();
                    }
                    stack.pop();
                }
            } else{
                stack.push(c);
            }

        }
    }
}
