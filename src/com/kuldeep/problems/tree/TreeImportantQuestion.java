package com.kuldeep.problems.tree;

import java.util.LinkedList;
import java.util.Queue;

public class TreeImportantQuestion {

    public static void main(String args[]){

        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(2);

        root.right.right = new TreeNode(20);

        root.right.right.right = new TreeNode(5);

        root.right.left = new TreeNode(11);
        TreeImportantQuestion treeImportantQuestion = new TreeImportantQuestion();

        System.out.println(treeImportantQuestion.getTreeHeight(root));
        System.out.println("========PreOrder Traversal=========");
        treeImportantQuestion.printPreOrderTraversal(root);
        System.out.println("========Inorder Traversal=========");
        treeImportantQuestion.printInorderTraversal(root);
        System.out.println("========PostOrder Traversal=========");
        treeImportantQuestion.printPostOrderTraversal(root);

        System.out.println("========LevelOrder Traversal=========");
        treeImportantQuestion.printLevelOrderTraversal(root);

        System.out.println("Mirror Image");
        System.out.println("Is mirror Image "+ treeImportantQuestion.isMirrorImage(root, root));

        TreeNode mirrorImage = new TreeNode(20);
        mirrorImage.left = new TreeNode(10);
        mirrorImage.right = new TreeNode(10);
        mirrorImage.left.left = new TreeNode(2);
        mirrorImage.left.right = new TreeNode(1);

        mirrorImage.right.left = new TreeNode(1);
        mirrorImage.right.right = new TreeNode(2);

        System.out.println("Is Mirror Image "+ treeImportantQuestion.isMirrorImage(mirrorImage, mirrorImage));

        System.out.println("Revert Tree");

        treeImportantQuestion.revert(root);

        System.out.println("Level order after revert");
        treeImportantQuestion.printLevelOrderTraversal(root);


        System.out.println();
        System.out.println("Merge two tree");
        //Merge Two tree
        root = treeImportantQuestion.mergeTwoTree(root, mirrorImage);

        System.out.println("Level order after merge");
        //root tree after merge
        treeImportantQuestion.printLevelOrderTraversal(root);


    }

    private void revert(TreeNode root) {

        if(root == null){
            return;
        }

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        revert(root.left);
        revert(root.right);
    }

    private TreeNode mergeTwoTree(TreeNode root, TreeNode other) {
        if(root==null){
            return other;
        }
        if(other== null){
            return root;
        }

        root.value = root.value + other.value;

        if(root.left == null){
            root.left = other.left;
        } else {
            mergeTwoTree(root.left, other.left);
        }

        if(root.right == null){
            root.right = other.right;
        } else {
            mergeTwoTree(root.right, other.right);
        }

        return root;
    }

    private void printLevelOrderTraversal(TreeNode node) {
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(node);

        while(!queue.isEmpty()){
            TreeNode temp = queue.poll();

            System.out.print(temp.value +" ");
            if(temp.left!=null){
                queue.add(temp.left);
            }
            if(temp.right!=null){
                queue.add(temp.right);
            }
        }
    }

    int getTreeHeight(TreeNode node){
        if(node==null) return 0;
        int left = 1+ getTreeHeight(node.left);
        int right = 1+getTreeHeight(node.right);

        return Math.max(left, right);
        /**
         * using queue we can get height of tree without recursion
         */

    }

    void printInorderTraversal(TreeNode node){
        if(node==null) return;
        printInorderTraversal(node.left);
        System.out.print(node.value + " ");
        printInorderTraversal(node.right);
    }

    void printPreOrderTraversal(TreeNode node){
        if(node==null) return;
        System.out.print(node.value+ " ");
        printPreOrderTraversal(node.left);
        printPreOrderTraversal(node.right);
    }

    void printPostOrderTraversal(TreeNode node){
        if(node==null) return;
        printPostOrderTraversal(node.left);
        printPostOrderTraversal(node.right);
        System.out.print(node.value+" ");
    }

    boolean isMirrorImage(TreeNode node1, TreeNode node2){
        if(node1 == null && node2==null){
            return true;
        }
        if(node1 ==null || node2 == null){
            return false;
        }

        return (node1.value == node2.value) && isMirrorImage(node1.left, node2.right) && isMirrorImage(node1.right,
        node2.left);
    }

}
