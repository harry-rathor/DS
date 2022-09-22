package ds;

import scala.collection.AbstractMap;

import java.util.*;

public class TreeDemo {

    private static class Node{
        int data;
        Node left,right;
        Node(int data){
            this.data=data;
        }
    }

    static void printLeftView(Node node, int level, ArrayList<Integer> ds){
        if(node==null){
            return;
        }

        if(level>=ds.size()){
            ds.add(node.data);
        }

        printLeftView(node.left,level+1,ds);
        printLeftView(node.right,level+1,ds);

   }



    static void printRightView(Node node, int level, ArrayList<Integer> ds){
        if(node==null){
            return;
        }

        if(level>=ds.size()){
            ds.add(node.data);
        }
        printRightView(node.right,level+1,ds);
        printRightView(node.left,level+1,ds);
    }
    static class Pair{
        int line;
        Node node;
        public Pair(int _line,Node _node){
            line=_line;
            node=_node;
        }
    }
    static void printTopView(Node node){
        if(node==null){
            return;
        }

        Queue<Pair> queue=new ArrayDeque<>();
        Map<Integer,Integer> map=new TreeMap<>();
        queue.add(new Pair(0,node));
        while (!queue.isEmpty()){
            Pair pair=queue.remove();
            map.putIfAbsent(pair.line,pair.node.data);

            if(pair.node.left!=null){
                queue.add(new Pair(pair.line-1,pair.node.left));
            }
            if(pair.node.right!=null){
                queue.add(new Pair(pair.line+1,pair.node.right));
            }
        }
        map.forEach((k,v)->System.out.print(v+" "));
    }
    public static void printTree(Node node){
        if(node!=null){
            System.out.print(node.data+" ");
            printTree( node.left);
            printTree( node.right);
        }
    }

    public  void printMirror(){
        root=mirror(root);
    }


    private static  Node mirror(Node node){
        if(node==null){
          return  node;
        }

        Node left=mirror(node.left);
        Node right=mirror(node.right);

        node.left=right;
        node.right=left;
        return node;

    }

    private   void mirrorBFS(){
        if (root==null) return;

        Queue<Node> queue=new ArrayDeque<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node node1=queue.remove();

            Node swap=node1.left;
            node1.left=node1.right;
            node1.right=swap;

            if(node1.left!=null){
                queue.add(node1.left);

            }
            if(node1.right!=null){
                queue.add(node1.right);
            }

        }


    }


    Node root;
    public static void main(String[] args) {
        TreeDemo tree = new TreeDemo();
        tree.root = new Node(10);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(7);
        tree.root.left.right = new Node(8);
        tree.root.right.right = new Node(15);
        tree.root.right.left = new Node(12);
        tree.root.right.right.left = new Node(14);

        printTree(tree.root);
        System.out.println();
        tree.mirrorBFS();
        tree.printMirror();
        printTree(tree.root);

//        ArrayList<Integer> ds=new ArrayList<>();
//        printLeftView(tree.root,0,ds);
//        ds.forEach(x->System.out.print(x+" "));
//        ds.clear();
//        System.out.println();
//        printRightView(tree.root,0,ds);
//        ds.forEach(x->System.out.print(x+" "));
//        System.out.println();
//        printTopView(tree.root);
    }
}


