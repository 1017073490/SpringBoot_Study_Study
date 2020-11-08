package com.zhangxing.springbootweb;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author zhangxing
 * @Description:
 * @date 2020/10/29 11:20
 */
public class LTest {
    public static void main(String[] args) {
        LTest test = new LTest();
        Queue<Integer> queue = new ArrayDeque<>();
        System.out.println();
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);

    }

}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
