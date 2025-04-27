package ir.dsa.trees;

import java.util.*;

public class BinaryTree {

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

    public static class Pair{
        Node node;
        int state;

        public Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    public static class DiaPair{
        int he;
        int dia;
    }

    public static class BSTPair{
        boolean isBST;
        int min;
        int max;

        Node root;
        int size;

    }

    public static class BalPair{
        int height;
        boolean isBal;
    }

    public static void main(String[] args) {
        System.out.println("welcome to binary trees");
    //    Node root = createBinaryTree(3);
    //    inOrderTraversal(root);

        Integer[] arr = {50,25,12,null,null,37,30,null,null,null,75,62,null,70,null,null,87,null,null};
        Node root = createBinaryTree(arr);
    //    preOrderTraversal(root);
    //    inOrderTraversalPattern(root);

    //    int size = size(root);
     //   System.out.println("size:" + size);

   //     int max = max(root);
   //     System.out.println("max:" + max);

   //     int sum = sum(root);
  //      System.out.println("sum:" + sum);

   //     int height = height(root);
   //     System.out.println("height:" + height);

   //     levelTraversal(root);
   //     levelTraversalLinewise(root);
  //      iterativePreInPostTraversal(root);


    /*    path = new ArrayList<>();
        findNodeToRoot(root, 37);
        System.out.println(path);*/

    //    printKlevelNodes(root, 1);

   //     Node key = findSpecificNode(root, 37);
   //     System.out.println("key found:"+key + " " + key.data);

    //    kDistanceAway(root, 25, 1);
    //    pathToleafFromRoot(root, "", 0, 80, 90);

  /*      singleChildNodes = new ArrayList<>();
        printSingleChildNode(root);
        System.out.println("single child nodes: "+ singleChildNodes);*/

      /*  Node newRoot = removeLeaves(root);
        levelTraversalLinewise(newRoot);*/

    /*    DiaPair pair = diameter2(root);
        System.out.println("dia:"+pair.dia);*/

    /*    tilt(root);
        System.out.println("tilt:"+tilt);*/

/*        int[] array = {1,2,3,4,5};
        int[] sub = subArray(array, 2,2);

        for (int i=0; i<sub.length; i++){
            System.out.print(sub[i]+" ");
        }*/

        int[] array = {1,2,3,4,5};
        Node node = createBST(array);
        levelTraversalLinewise(node);

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

    private static BalPair isBalPair(Node node){

        if(node == null){
            BalPair pair = new BalPair();
            pair.height = 0;
            pair.isBal = true;
        }

        BalPair lp = isBalPair(node.left);
        BalPair rp = isBalPair(node.right);

        BalPair mp = new BalPair();
        mp.isBal = Math.abs(lp.height - rp.height) <=1
                   && lp.isBal && rp.isBal;
        mp.height = Math.max(lp.height, rp.height) + 1;

        return mp;
    }

    static boolean isBal = true;

    private static int isBal(Node node){
        if(node == null){
            return 0;
        }

        int lh = isBal(node.left);
        int rh = isBal(node.right);

        int gap = Math.abs(lh-rh);
        if(gap>1){
            isBal = false;
        }

        int height = Math.max(lh,rh) + 1;
        return height;
    }

    private static BSTPair isBST(Node node){

        if(node == null){
            BSTPair bSTPair = new BSTPair();
            bSTPair.isBST = true;
            bSTPair.min = Integer.MAX_VALUE;
            bSTPair.max = Integer.MIN_VALUE;
        }

        BSTPair lt = isBST(node.left);
        BSTPair rt = isBST(node.right);

        BSTPair mp = new BSTPair();
        mp.isBST = lt.isBST && rt.isBST &&
                (node.data >= lt.max && node.data <= rt.min);

        mp.max = Math.max(node.data, Math.max(lt.max,rt.max));
        mp.min = Math.min(node.data, Math.min(lt.min,rt.min));

        return mp;
    }

    static int tilt = 0;
    private static int tilt(Node node){

        if(node == null){
            return 0;
        }

        int ls = tilt(node.left);
        int rs = tilt(node.right);

        int ltilt =  Math.abs(ls-rs);
        tilt += ltilt;

        int ts = ls + rs + node.data;
        return ts;
    }

    private static Node createBinaryTree(int x){
        Node left = new Node(x++,null,null);
        Node right = new Node(x++,null,null);

        Node root = new Node(x,left,right);

        return root;
    }

    private static void preOrderTraversal(Node root){

        if(root == null)
            return;
        System.out.print(root.data + " ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);

    }

    private static void inOrderTraversal(Node root){

        if(root == null)
            return;

        inOrderTraversal(root.left);
        System.out.print(root.data + " ");
        inOrderTraversal(root.right);

    }

    private static void postOrderTraversal(Node root){

        if(root == null)
            return;

        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.data + " ");

    }

    private static void inOrderTraversalPattern(Node node){
        if(node == null){
            return;
        }

        String str = node.left == null ? "." : node.left.data + "";
        str+= "->" + node.data + "<-";
        str+= node.right == null ? "." : node.right.data + "";

        System.out.println(str);
        inOrderTraversalPattern(node.left);
        inOrderTraversalPattern(node.right);

    }

    private static Node createBinaryTree(Integer[] arr){

        Stack<Pair> stack = new Stack<>();
        Node root = new Node(arr[0],null,null);
        Pair pair = new Pair(root,1);
        stack.push(pair);

        int idx = 0;
        while(!stack.empty()){
            Pair pair1 = stack.peek();

                if (pair1.state == 1) {
                    idx++;
                    Integer value = arr[idx];
                    if(value != null){
                        pair1.node.left = new Node(value, null, null);
                        Pair pair2 = new Pair(pair1.node.left,1);
                        stack.push(pair2);
                    } else{
                        pair1.node.left = null;
                    }
                    pair1.state++;

                } else if (pair1.state == 2) {
                    idx++;
                    Integer value = arr[idx];
                    if(value != null){
                        pair1.node.right = new Node(value, null, null);
                        Pair pair2 = new Pair(pair1.node.right,1);
                        stack.push(pair2);
                    } else{
                        pair1.node.right = null;
                    }
                    pair1.state++;

                } else {

                    stack.pop();
                }


        }

        return root;

    }

    private static int sum(Node node){
        int sum = 0;
        if(node  == null){
            return 0;
        }
        sum+= node.data +  sum(node.left) +  sum(node.right);
       return sum;
    }

    private static int size(Node node){

        int size = 0;
        if(node  == null){
            return 0;
        }

        int size1  = size(node.left);
        int size2 = size(node.right);
        size = size1 + size2 +1;
        return size;
    }

    private static int max(Node node){
        if(node == null){
            return Integer.MIN_VALUE;
        }

        int leftMax = max(node.left);
        int rightMax = max(node.right);

        int max = Math.max(Math.max(leftMax,rightMax), node.data);
        return max;
    }

    private static int height(Node node){
        if(node == null){
            return -1; // edges -1, nodes 0
        }

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        int height = Math.max(leftHeight,rightHeight) +1;
        return height;
    }

    private static void levelTraversal(Node node){

        Queue<Node> queue = new ArrayDeque<>();
        queue.add(node);

        while(!queue.isEmpty()){
            Node node1 = queue.poll();
            System.out.print(node1.data + " ");
            if(node1.left != null){
                queue.add(node1.left);
            }
            if(node1.right != null){
                queue.add(node1.right);
            }
        }

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

    private static void iterativePreInPostTraversal(Node node){

        String pre = "";
        String in = "";
        String post = "";

        Stack<Pair> stack = new Stack<>();

        stack.add(new Pair(node, 1));

        while(!stack.isEmpty()){

            Pair temp = stack.peek();
            if(temp.state ==1){
                pre+= temp.node.data + " ";
                if(temp.node.left != null){
                    Pair left = new Pair(temp.node.left,1);
                    stack.push(left);
                }
                temp.state++;

            } else if(temp.state ==2){
                in+= temp.node.data + " ";
                if(temp.node.right != null){
                    Pair right = new Pair(temp.node.right,1);
                    stack.push(right);
                }
                temp.state++;

            } else{
                post+= temp.node.data + " ";
                stack.pop();
            }


        }

        System.out.println("preorder: " + pre);
        System.out.println("inorder: " + in);
        System.out.println("postorder: " + post);
    }

    static List<Node> path;
    private static boolean findNodeToRoot(Node node, int value){

        if(node == null){
            return false;
        }

        if(node.data == value){
            path.add(node);
            return true;
        }

        boolean lc = findNodeToRoot(node.left, value);
        if(lc){
            path.add(node);
            return true;
        }

        boolean rc = findNodeToRoot(node.right, value);
        if(rc){
            path.add(node);
            return true;
        }

        return false;
    }

    private static void printKlevelNodes(Node root, int k, Node blocker){

        if(root == null || k<0 || root == blocker){
            return;
        }
        if(k ==0){
            System.out.print(root.data + " ");
        }
        printKlevelNodes(root.left,k-1, blocker);
        printKlevelNodes(root.right,k-1, blocker);

    }

    private static Node findSpecificNode(Node node, int key){

        if(node == null){
            return null;
        }

        if(node.data == key){
            return node;
        }

        Node left = findSpecificNode(node.left,key);
        if(left != null){
            return  left;
        }
        Node right = findSpecificNode(node.right,key);
        if(right != null){
            return  right;
        }

        return null;
    }

    private static void kDistanceAway(Node node, int key, int k){


        // direct k distance way

        Node target = findSpecificNode(node,key);
        printKlevelNodes(target,k,null);

        path = new ArrayList<>();
        findNodeToRoot(node, key);

        for(int i = 0; i< path.size() ;i++){
            printKlevelNodes(path.get(i), k-i, i==0?null: path.get(i-1));

        }

    }

    private static void pathToleafFromRoot(Node node, String path, int sum, int lo, int hi){
        if(node == null){
            return;
        }
        if(node.left == null && node.right == null){
            sum+=node.data;
            if(sum >= lo && sum <=hi){
                System.out.println(path + node.data);
            }
            return;
        }

        pathToleafFromRoot(node.left, path + node.data + " ", sum + node.data, lo, hi);
        pathToleafFromRoot(node.right, path + node.data + " ", sum + node.data, lo, hi);
    }

    private static Node createLeftCloneTree(Node node){

        if(node == null){
            return null;
        }

        Node lcn = createLeftCloneTree(node.left);
        Node rcn = createLeftCloneTree(node.right);

        Node nn = new Node(node.data, lcn, null);

        node.left = nn;
        node.right = rcn;

        return node;
    }

    private static Node restoreLeftCloneTree(Node node){

        if(node == null){
            return null;
        }

        Node rln = restoreLeftCloneTree(node.left.left);
        Node rrn = restoreLeftCloneTree(node.right);

        node.left = rln;
        node.right = rrn;

        return node;
    }

    private static List<Integer> singleChildNodes;
    private static void printSingleChildNode(Node node){

        if(node == null){
            return;
        }

        if((node.left != null && node.right == null) || (node.right != null && node.left == null)){
            singleChildNodes.add(node.data);
        }

        printSingleChildNode(node.left);
        printSingleChildNode(node.right);

    }

    private static Node removeLeaves(Node node){

        if(node == null){
            return null;
        }

        if(node.left == null && node.right == null){
            return null;
        }

        node.left = removeLeaves(node.left);
        node.right = removeLeaves(node.right);

        return node;

    }

    private static DiaPair diameter2(Node node){
        if(node == null){
            DiaPair bp = new DiaPair();
            bp.he = -1;
            bp.dia = 0;
            return  bp;
        }

        DiaPair lp = diameter2(node.left);
        DiaPair rp = diameter2(node.right);

        DiaPair mp = new DiaPair();
        mp.he = Math.max(lp.he,rp.he) + 1;

        int diaWhenNodesOnEitherSide = lp.he + rp.he + 2;
        mp.dia = Math.max(diaWhenNodesOnEitherSide, Math.max(lp.dia,rp.dia));

        return mp;
    }

}
