package ir.dsa.trees;

import org.omg.CORBA.INTERNAL;

import java.util.*;

public class BST {

    public static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
    public static class BSTPair{
        boolean isBST;
        int min;
        int max;

        Node root;
        int size;

    }

    public static class Pair{
        Node node;
        int state;

        public Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    public static void main(String[] args) {
        System.out.println("welcome to binary search trees");
        int[] array = {1,2,3,4,5};
        Node node = createBST(array);
        levelTraversalLinewise(node);
        System.out.println();
   //     System.out.println("size:" + size(node));
   //     System.out.println("height:" + height(node));
   //     System.out.println("min:" + min(node));
          System.out.println("max:" + max(node));

        Node newNode = add(node, 6);
        levelTraversalLinewise(newNode);
        System.out.println();

/*        Node newNode2 = remove(newNode,5);
        levelTraversalLinewise(newNode2);*/

  //      System.out.println();
   //     replaceSumOfLarger(newNode2);
   //     levelTraversalLinewise(newNode2);

    //    System.out.println(lowestCommonAncestor(newNode,2,5));
  //      printInRange(newNode,5,6);
  //      System.out.println(find(newNode,7));
  //      targetSumPair(newNode, newNode, 6);

  //      List<Integer> list = new ArrayList<>();
   //     targetSumPair3(newNode,6);
        int[] preOrder = {3,9,20,15,7};
        int[] inOrder = {9,3,15,20,7};

        Node root = createBSTFromPreInOrder(preOrder,inOrder);
        levelTraversalLinewise(root);

    }

    private static void targetSumPair3(Node node, int sum){

        Stack<Pair> ls = new Stack<>();
        Stack<Pair> rs = new Stack<>();

        ls.push(new Pair(node,0));
        rs.push(new Pair(node,0));

        Node left = getNextFromNormalInorder(ls);
        Node right = getNextFromReverseInorder(rs);

        while(left.data < right.data){
            if(left.data + right.data < sum){
                left = getNextFromNormalInorder(ls);
            } else if(left.data + right.data > sum){
                right = getNextFromReverseInorder(rs);
            } else{
                System.out.println(left.data + "-" + right.data);
                left = getNextFromNormalInorder(ls);
                right = getNextFromReverseInorder(rs);
            }
        }

    }

    private static Node getNextFromNormalInorder(Stack<Pair> st){

        while(!st.isEmpty()){
            Pair top = st.peek();

            if(top.state == 0){
                if(top.node.left != null){
                    st.push(new Pair(top.node.left, 0));
                }
                top.state++;
            } else if(top.state == 1){
                if(top.node.right != null){
                    st.push(new Pair(top.node.right, 0));
                }
                top.state++;
                return top.node;
            } else{
                st.pop();
            }
        }
        return null;
    }

    private static Node getNextFromReverseInorder(Stack<Pair> st){

        while(!st.isEmpty()){
            Pair top = st.peek();

            if(top.state == 0){
                if(top.node.right != null){
                    st.push(new Pair(top.node.right, 0));
                }
                top.state++;
            } else if(top.state == 1){
                if(top.node.left != null){
                    st.push(new Pair(top.node.left, 0));
                }
                top.state++;
                return top.node;
            } else{
                st.pop();
            }
        }
        return null;
    }


    private static void targetSumPair2(Node node, List<Integer> list, int sum){
        travelAndFill(node,list);

        int i = 0;
        int j = list.size()-1;

        while(i<j){
            if(list.get(i)+list.get(j) < sum){
                i++;
            } else if(list.get(i)+list.get(j) > sum){
                j--;
            } else{
                System.out.println(list.get(i) + "-" + list.get(j));
                i++;
                j--;
            }
        }


    }

    private static void travelAndFill(Node node, List<Integer> list){
        if(node == null){
            return;
        }

        travelAndFill(node.left, list);
        list.add(node.data);
        travelAndFill(node.right, list);
    }

    private static void targetSumPair(Node root, Node node, int sum){

        if(node == null){
            return;
        }
        targetSumPair(root, node.left, sum);

        int compliment = sum - node.data;
        if(node.data < compliment) {
            if (find(root, compliment) == true) {
                System.out.println(node.data + "-" + compliment);
            }
        }

        targetSumPair(root, node.right, sum);
    }

    private static boolean find(Node node, int target){
        if(node == null){
            return false;
        }
        if(node.data == target){
            return true;
        } else if(node.data > target){
            return find(node.left,target);
        } else{
            return find(node.right,target);
        }

    }

    private static void printInRange(Node node, int d1, int d2){
        if(node == null){
            return;
        }
        if(d1 > node.data && d2 > node.data){
            printInRange(node.right, d1, d2);
        } else if(d1 < node.data && d2 < node.data){
            printInRange(node.left, d1, d2);
        } else{
            printInRange(node.left, d1, d2);
            System.out.println(node.data);
            printInRange(node.right, d1, d2);
        }


    }

    private static int lowestCommonAncestor(Node node, int d1, int d2){

        if(d1 > node.data && d2 > node.data){
            return lowestCommonAncestor(node.right,d1,d2);
        } else if(d1 < node.data && d2 < node.data){
            return lowestCommonAncestor(node.left,d1,d2);
        } else{
            return node.data;
        }
    }

    static int sum = 0;
    private static void replaceSumOfLarger(Node node){

        if(node == null){
            return;
        }
        replaceSumOfLarger(node.right);

        int originalValue = node.data;
        node.data = sum;
        sum+= originalValue;
        replaceSumOfLarger(node.left);
    }

    private static Node remove(Node node, int data){

        if(node == null){
            return null;
        }
        if(data > node.data){
            node.right = remove(node.right,data);
        } else if(data < node.data){
            node.left = remove(node.left,data);
        } else{
            // work
            if(node.left != null && node.right != null){

                int lmax = max2(node.left);
                node.data = lmax;
                node.left = remove(node.left, lmax);
            } else if(node.left != null){
                return node.left;
            } else if(node.right != null){
                return node.right;
            } else{
                return null;
            }
        }

        return node;
    }

    private static Node add(Node node, int data){
        if(node == null){
            return new Node(data, null, null);
        }
        if(data > node.data){
            node.right = add(node.right, data);
        } else if(data < node.data){
            node.left = add(node.left, data);
        } else{
            // do nothing
        }

        return node;
    }

    private static BSTPair largestBSTSubTree(Node node){
        if(node == null){
            BSTPair bSTPair = new BSTPair();
            bSTPair.isBST = true;
            bSTPair.min = Integer.MAX_VALUE;
            bSTPair.max = Integer.MIN_VALUE;
            bSTPair.root = null;
            bSTPair.size = 0;
        }

        BSTPair lt = largestBSTSubTree(node.left);
        BSTPair rt = largestBSTSubTree(node.right);

        BSTPair mp = new BSTPair();
        mp.isBST = lt.isBST && rt.isBST &&
                (node.data >= lt.max && node.data <= rt.min);

        mp.max = Math.max(node.data, Math.max(lt.max,rt.max));
        mp.min = Math.min(node.data, Math.min(lt.min,rt.min));

        if(mp.isBST){
            mp.root = node;
            mp.size = lt.size + rt.size + 1;
        } else if(lt.size > rt.size){
            mp.root = lt.root;
            mp.size = lt.size;
        } else{
            mp.root = rt.root;
            mp.size = rt.size;
        }

        return mp;

    }

    private static int size(Node node){

        if(node == null){
            return 0;
        }

        int ls = size(node.left);
        int rs = size(node.right);
        return ls+rs+1;
    }

    private static int height(Node node){

        if(node == null){
            return 0;
        }
        int lh = height(node.left);
        int rh = height(node.right);

        return Math.max(lh,rh)+1;
    }

    private static int min2(Node node){
        if(node.left != null){
            return min2(node.left);
        } else{
            return node.data;
        }
    }
    private static int min(Node node){

        if(node == null){
            return Integer.MAX_VALUE;
        }

        int ml = min(node.left);
        int mr = min(node.right);

        return Math.min(Math.min(ml,mr),node.data);
    }

    private static int max2(Node node){

        if(node.right != null){
            return max2(node.right);
        } else{
            return node.data;
        }
    }
    private static int max(Node node){

        if(node == null){
            return Integer.MIN_VALUE;
        }

        int ml = max(node.left);
        int mr = max(node.right);

        return Math.max(Math.max(ml,mr),node.data);
    }


    private static Node createBSTFromPreInOrder(int[] preOrder, int[] inOrder){

        Map<Integer, Integer> map = new HashMap<>();
        int i =0;
        for(int x : inOrder){
            map.put(x,i++);
        }

        return helper(map, preOrder, inOrder, 0, preOrder.length-1, 0, inOrder.length-1);
    }

    private static Node helper(Map<Integer, Integer> map, int[] preOrder, int[] inOrder, int preStart, int preEnd, int inStart, int inEnd){

        if(preStart > preEnd){
            return null;
        }

        int rootData = preOrder[preStart];
        int rootInx = map.get(rootData);
        int leftTreeSize = rootInx - inStart;

        Node node = new Node(rootData, null, null);

        node.left = helper(map, preOrder, inOrder, preStart+1, preStart+leftTreeSize,
                            inStart, rootInx-1);

        node.right = helper(map, preOrder, inOrder, preStart+leftTreeSize+1,
                preEnd, rootInx+1, inEnd);

        return node;

    }

    private static Node createBST2(int[] arr, int low, int high){

        if(low>high){
            return null;
        }
        int mid = (low+high)/2;

        Node node = new Node(arr[mid], null, null);
        node.left = createBST2(arr, low, mid-1);
        node.right = createBST2(arr, mid+1, high);

        return node;
    }

    private static Node createBST(int[] arr){
        if(arr.length == 0){
            return null;
        }
        int size = arr.length;
        int mid = size/2;
        Node node = new Node(arr[mid],null,null);

        node.left = createBST(subArray(arr,0,mid-1));
        node.right = createBST(subArray(arr,mid+1,size-1));

        return node;
    }

    private static int[] subArray(int[] input, int start, int end){

        int size = end-start+1;
        int[] subArray = new int[size];

        for(int i=0; i<size;i++){
            subArray[i] = input[start+i];
        }

        return subArray;
    }

    private static void levelTraversalLinewise(Node node){

        Queue<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(node,1));

        int level =1;
        while(!queue.isEmpty()){
            Pair node1 = queue.poll();
            if(node1.state > level){
                level = node1.state;
                System.out.println();
            }
            System.out.print(node1.node.data + " ");
            if(node1.node.left != null){
                queue.add(new Pair(node1.node.left, level+1));
            }
            if(node1.node.right != null){
                queue.add(new Pair(node1.node.right, level+1));
            }
        }

    }
}
