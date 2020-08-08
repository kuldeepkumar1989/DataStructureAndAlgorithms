package com.kuldeep.problems.tree;

import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectSameLevelNode {

    public static void main(String args[]){
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(2);

        root.right.right = new TreeNode(20);

        root.right.right.right = new TreeNode(5);

        root.right.left = new TreeNode(11);

        ConnectSameLevelNode connectSameLevelNode = new ConnectSameLevelNode();
        connectSameLevelNode.connect(root);

        //Level order traversal of connected node
        connectSameLevelNode.printLevelOrderTraversal(root);
    }

    private void printLevelOrderTraversal(TreeNode node) {
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(node);

        while(!queue.isEmpty()){
            TreeNode temp = queue.poll();

            Integer tt = temp.next == null ? null : temp.next.value;
            System.out.println(temp.value +" "+ " next "+tt);
            if(temp.left!=null){
                queue.add(temp.left);
            }
            if(temp.right!=null){
                queue.add(temp.right);
            }
        }
    }

    private void connect(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode temp = null;
        while(!queue.isEmpty()){
            int n = queue.size();
            for(int i=0; i<n; i++){
                TreeNode prev = temp;
                temp = queue.poll();

                if(i>0)
                    prev.next=temp;

                if(temp.left!=null){
                    queue.add(temp.left);
                }
                if(temp.right!=null){
                    queue.add(temp.right);
                }
            }
            temp.next = null;
        }
    }
}
