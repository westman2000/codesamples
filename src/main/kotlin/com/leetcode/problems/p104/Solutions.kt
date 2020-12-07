package com.leetcode.problems.p104

import kotlin.math.max


/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 */
class Solutions {

    // Definition for a binary tree node.
    class TreeNode(var value: Int? = null, var left : TreeNode? = null, var right : TreeNode? = null)

    fun maxDepth(root: TreeNode?): Int {
        if (root == null) return 0
        val leftMaxDepth = maxDepth(root.left)
        val rightMaxDepth = maxDepth(root.right)
        return max(leftMaxDepth, rightMaxDepth) + 1
    }
}