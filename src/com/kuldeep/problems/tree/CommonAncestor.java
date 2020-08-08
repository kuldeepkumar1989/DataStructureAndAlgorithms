package com.kuldeep.problems.tree;


public class CommonAncestor {
    static boolean v1=false;
    static boolean v2=false;
    public static void main(String args[]){

        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(2);

        root.right.right = new TreeNode(20);

        root.right.right.right = new TreeNode(5);

        root.right.left = new TreeNode(11);

        CommonAncestor commonAncestor = new CommonAncestor();

        System.out.println("Common 5, 15 "+ commonAncestor.findCommonAncestor(root,5, 15).value);

        System.out.println("Common 2, 11 "+ commonAncestor.findCommonAncestor(root,2, 11).value);

        System.out.println("Common 15, 15 "+ commonAncestor.findCommonAncestor(root,15, 15).value);

        System.out.println("Common 11, 5 "+ commonAncestor.findCommonAncestor(root,11, 5).value);
        System.out.println("Common 10, 10 "+ commonAncestor.findCommonAncestor(root,10, 10).value);

        System.out.println("Common 11, 20 "+ commonAncestor.findCommonAncestor(root,11, 20).value);
    }

    private TreeNode findCommonAncestor(TreeNode node, int n1, int n2) {
        if(node == null){
            return null;
        }

        /**
         * if(node.value==n1 || node.value==n2){
         * return node;
         * }
         *
         */
        //below logic to check both keys are present in tree
        TreeNode temp=null;

        if(node.value== n1){
            temp = node;
            v1=true;
        }
        if(node.value==n2){
            temp = node;
            v2=true;
        }
        if(temp!=null) return temp;

        TreeNode leftChild = findCommonAncestor(node.left, n1, n2);
        TreeNode rightChild = findCommonAncestor(node.right, n1, n2);

        if(leftChild != null && rightChild != null){
            return node;
        }


        return leftChild == null ? rightChild : leftChild;
    }
}
