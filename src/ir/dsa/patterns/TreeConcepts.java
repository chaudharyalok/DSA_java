package ir.dsa.patterns;

import java.util.*;

public class TreeConcepts {
    private static class Node{

        Node(){

        }

        Node(int data){
            this.data = data;
        }
        int data;
        List<Node> children = new ArrayList<>();
    }

    private static class Pair{
        Node node;
        int level;

        Pair(Node node, int level){
            this.node = node;
            this.level = level;
        }
    }

    static Node root;
    public static void main(String args[]) {
        System.out.println("Hello in Tree world!");
        int[] arr = {10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};
        Node root = constructTree(arr);
   //     display(root);

   //     System.out.println("size of tree->"+size(root));
   //     System.out.println("max in tree->"+max(root));
   //     System.out.println("height in tree->"+height(root));
    //    levelTraversal(root);
     //   levelTraversalLineWise(root);
   //     levelTraversalLineWiseZigzag(root);
   //     levelTraversalLineWise2(root);
   //     levelTraversalLineWise3(root);
  //      levelTraversalLineWise4(root);
    //    mirror(root);
    //    removeLeafs(root);
    //    linearize(root);
    //    linearize2(root);
  //      levelTraversalLineWise4(root);
        List<Node> list = new ArrayList<>();
   //     System.out.println("value present"+ find(root, 80));
     /*   System.out.println("value present"+ nodeToRootPath(root, 80,list));
        for(Node node : list) {
            System.out.print( node.data+" ");
        }*/

    //    System.out.println("path to root " + nodeToRootPath2(root,80));

  //      System.out.println("lowest common ancestor " + lowestCommonAncestor(root,80,100));
          System.out.println("lowest common ancestor " + distanceBw2Nodes(root,50,110));
    }

    private static int distanceBw2Nodes(Node node, int v1, int v2){
        List<Integer> path1 = nodeToRootPath2(node,v1);
        List<Integer> path2 = nodeToRootPath2(node,v2);

        int i = path1.size()-1;
        int j = path2.size()-1;

        while(i>=0 && j>= 0 && path1.get(i) == path2.get(j)){
            i--;
            j--;
        }
        i++;
        j++;

        return i+j;

    }

    private static int lowestCommonAncestor(Node node, int v1, int v2){
        List<Integer> path1 = nodeToRootPath2(node,v1);
        List<Integer> path2 = nodeToRootPath2(node,v2);

        int i = path1.size()-1;
        int j = path2.size()-1;
        while(i>=0 && j>= 0 && path1.get(i) == path2.get(j)){
            i--;
            j--;
        }
        i++;
        j++;

        return path1.get(i);
    }

    private static List<Integer> nodeToRootPath2(Node node, int value){

        if(node.data == value){
            List<Integer> list = new ArrayList<>();
            list.add(node.data);
            return list;
        }

        for(Node child : node.children){
            List<Integer> cnr = nodeToRootPath2(child,value);
            if(cnr.size()>0){
                cnr.add(node.data);
                return cnr;
            }
        }

        return Collections.emptyList();
    }

    private static boolean nodeToRootPath(Node node, int value, List<Node> nodes){

        if(node.data == value){
            nodes.add(node);
            return true;
        }

        for(Node child : node.children){
            System.out.print(child.data + " ");
            boolean temp = nodeToRootPath(child,value,nodes);
            if(temp){
                nodes.add(node);
                return true;
            }
        }
        return false;
    }

    private static boolean find(Node node, int value){
       if(node.data == value){
            return true;
        }
        else{
            boolean flag = false;

            for(Node child: node.children){
                System.out.print(child.data + " ");
                flag = flag || find(child,value);
                if(flag){
                    return true;
                }
            }
            return flag;
        }
    }

    private static boolean find2(Node node, int value){

        if(node.data == value){
            return true;
        }

        for(Node child : node.children){
            System.out.print(child.data + " ");
            boolean temp = find2(child,value);
            if(temp){
                return true;
            }
        }
        return false;
    }

    private static Node linearize2(Node node){

        if(node.children.size() == 0){
            return node;
        }
        Node lkt = linearize2(node.children.get(node.children.size()-1));
        while(node.children.size() > 1){
            Node last = node.children.remove(node.children.size()-1);
            Node sl = node.children.get(node.children.size()-1);
            Node slt = linearize2(sl);
            slt.children.add(last);
        }
        return lkt;
    }

    private static void linearize(Node node){

        for(Node child: node.children){
            linearize(child);
        }

        while(node.children.size() > 1){
            Node lc = node.children.remove(node.children.size()-1);
            Node sc = node.children.get(node.children.size()-1);
            Node tail = getTail(sc);
            tail.children.add(lc);

        }
    }

    private static Node getTail(Node node){
        while(node.children.size() ==1){
            node = node.children.get(0);
        }
        return node;
    }


    private static void removeLeafs(Node node){

        for(int i = node.children.size()-1; i>=0; i--){
             Node child = node.children.get(i);
             if(child.children.size() == 0){
                    node.children.remove(child);
             }
        }

        for(Node child : node.children){
            removeLeafs(child);
        }
    }

    private static void mirror(Node node){
        for(Node child : node.children){
            mirror(child);
        }
        Collections.reverse(node.children);
    }

    private static void levelTraversalLineWiseZigzag(Node node){

        Stack<Node> ms = new Stack<>();
        Stack<Node> cs = new Stack<>();

        ms.push(node);
        boolean right = true;
        while(!ms.isEmpty()){
            Node temp = ms.pop();
            System.out.print(temp.data + " ");

             if(right){
                 for(int i = 0; i< temp.children.size(); i++){
                     cs.add(temp.children.get(i));
                 }
             }else {
                 for (int i = temp.children.size() - 1; i >= 0; i--) {
                     cs.add(temp.children.get(i));
                 }
             }

             if(ms.isEmpty()){
                 ms = cs;
                 cs = new Stack<>();
                 System.out.println();
                 right = ! right;
             }
        }
    }

    private static void levelTraversalLineWise(Node node){
        Queue<Node> queue = new ArrayDeque<>();
        Queue<Node> child_queue = new ArrayDeque<>();
        queue.add(node);

        while(!queue.isEmpty()){
            Node temp = queue.poll();
            System.out.print(temp.data + " ");
            for(Node child : temp.children){
                child_queue.add(child);
            }

            if(queue.isEmpty()){
                queue = child_queue;
                child_queue = new ArrayDeque<>();
                System.out.println();
            }


        }

    }

    private static void levelTraversalLineWise2(Node node){
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(node);
        queue.add(new Node(-1));

        while(!queue.isEmpty()){

            Node temp = queue.poll();
            if(temp.data != -1) {
                System.out.print(temp.data + " ");
                for (Node child : temp.children) {
                    queue.add(child);
                }
            } else {
                if(!queue.isEmpty()){
                    queue.add(new Node(-1));
                    System.out.println();
                }
            }
        }
    }

    private static void levelTraversalLineWise3(Node node){
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(node);

        while(!queue.isEmpty()) {

            int cl = queue.size();
            for (int i = 0; i < cl; i++) {
                Node temp = queue.poll();
                System.out.print(temp.data + " ");
                for (Node child : temp.children) {
                    queue.add(child);
                }

            }
            System.out.println();

        }
    }

    private static void levelTraversalLineWise4(Node node){
        Queue<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(node,1));

        int level = 1;
        while(!queue.isEmpty()){
            Pair temp = queue.poll();
            if(temp.level > level){
                level = temp.level;
                System.out.println();
            }
            System.out.print(temp.node.data + " ");
            for (Node child : temp.node.children) {
                queue.add(new Pair(child,level+1));
            }

        }

    }

    private static void levelTraversal(Node node){

        Queue<Node> queue = new ArrayDeque<>();
        queue.add(node);

        while(!queue.isEmpty()){
            Node temp = queue.poll();
            System.out.print(temp.data + " ");
            for(Node child : temp.children){
                queue.add(child);
            }
        }
        System.out.print(".");
    }

    private static int height(Node node){
        int he = 0; // for nodes 0, for edges -1
        for(Node child : node.children){
            int ch = height(child);
            he = Math.max(he,ch);
        }
        he+=1;
        return he;

    }

    private static int max(Node node){

        int max = Integer.MIN_VALUE;

        for(Node child : node.children){
            int cm = max(child);
            max = Math.max(max, cm);
        }
        max = Math.max(max, node.data);
        return max;
    }

    private static int size(Node node){
        int s = 0;
        for(Node child : node.children){
           int cs = size(child);
           s = s + cs;
        }
        s = s+1;
        return s;
    }

    private static void display(Node node){

        String s = node.data + " :-> ";
        for(Node child : node.children){
            s+= child.data + ", ";
        }
        System.out.println(s);

        for(Node child : node.children){
            display(child);
        }


    }

    private static Node constructTree(int arr[]){

    //    Node root;
        Stack<Node> stack = new Stack<>();
        for(int i=0; i< arr.length; i++){
            if(arr[i] == -1){
                stack.pop();
            } else{
                Node n = new Node();
                n.data = arr[i];

                if(stack.size() == 0){
                    root = n;
                } else{
                    stack.peek().children.add(n);
                }
                stack.push(n);
            }
        }
        return root;
    }


}
