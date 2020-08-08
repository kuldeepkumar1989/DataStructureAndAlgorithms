package com.kuldeep.problems.tree;

public class BSTValidation {
    public static void main(String args[]){

        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(10);
        root.right = new TreeNode(30);
        root.left.left = new TreeNode(5);

        root.right.right = new TreeNode(50);

        root.right.right.right = new TreeNode(60);

       // root.right.left = new TreeNode(40); // to make false
        root.right.left = new TreeNode(25);


        BSTValidation bstValidation = new BSTValidation();

        System.out.println("Is Binary Search Tree " +bstValidation.checkIsBST(root));
    }

    private boolean checkIsBST(TreeNode root) {
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        return isBstUtil(root, max, min);
    }

    private boolean isBstUtil(TreeNode node, int max, int min) {
        if(node==null) return true;

        if(node.value>max || node.value<min){
            return false;
        }
        return isBstUtil(node.left, node.value-1, min) && isBstUtil(node.right, max, node.value+1);
    }
}
