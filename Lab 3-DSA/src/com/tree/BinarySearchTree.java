package com.tree;

import java.util.HashSet;

public class BinarySearchTree {
    Node root;

    public BinarySearchTree (Node root) {
        this.root = root;
    }

    public static void isSum(int sum, Node root) {
        HashSet<Integer> set = new HashSet<>();
        isSum(set, root, sum);
    }

    public static boolean isSum(HashSet set, Node root, int sum) {
        if (root == null) {
            return false;
        }
        if (isSum(set, root.left, sum)) {
            return true;
        }
        if (set.contains(sum - root.data)) {
            System.out.println("Pair is there between "+ root.data+" and "+ (sum-root.data));
            return true;
        } else {
            set.add(root.data);

        }
        return isSum(set, root.right, sum);
    }


    public static void main(String[] args) {
        Node root = new Node(10);
        BinarySearchTree binaryTree = new BinarySearchTree (root);
        binaryTree.root.left = new Node(20);
        binaryTree.root.right = new Node(30);
        root.left.left=new Node(40);
        root.left.right=new Node(50);
        root.right.left=new Node(60);
        root.right.right=new Node(70);
        isSum(130, root);
    }
}