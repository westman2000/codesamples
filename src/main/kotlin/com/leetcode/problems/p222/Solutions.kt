package com.leetcode.problems.p222

import java.util.*

class Solutions {

    class TreeNode(var value: Int = 0, var left : Solutions.TreeNode? = null, var right : Solutions.TreeNode? = null)

    fun countNodes(root: TreeNode?): Int {
        if (root == null) return 0
        return countNodes(root.left) + countNodes(root.right) + 1
    }


    fun countNodes02(root: TreeNode?): Int {
        val h : Int = getTreeHeight(root)
        var summ : Int = 0
        for (i in 0..h) {
            summ += countLevel(root, i)
        }
        return summ
    }

    fun countNodes03(root: TreeNode?): Int {
        if(root == null) return 0
        val leftHeight = leftHeight(root)
        val rightHeight = rightHeight(root)

        if(leftHeight == rightHeight) return (1 shl leftHeight) - 1

        return 1 + countNodes(root.left) + countNodes(root.right)
    }

    fun countNodes04(root: TreeNode?): Int {
        var count = 0
        var height = getHeight(root)

        var cur = root
        while(cur != null){
            if(getHeight(cur.right) == height - 1){
                count += 1 shl height
                cur = cur.right
            }else{
                count += 1 shl (height - 1)
                cur = cur.left
            }

            --height
        }

        return count
    }

    fun countNodes05(root: TreeNode?): Int {
        if(root==null) return 0

        val height = root.height()
        val missing = root.findMissingCount(height)

        return (1 shl (height + 1)) - 1 - missing
    }

    fun countNodes06(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }
        val queue = Stack<TreeNode>()
        queue.add(root)
        var n = 0
        while (!queue.isEmpty()) {
            val item = queue.pop()
            n++
            if (item.left != null) {
                queue.push(item.left)
            }
            if (item.right != null) {
                queue.push(item.right)
            }

        }
        return n
    }

    tailrec fun TreeNode.height() : Int = 1 + (left?.height() ?: -1)

    fun TreeNode.findMissingCount(maxDepth: Int): Int {
        if(maxDepth == 1) {
            if(left == null) return 2
            if(right == null) return 1
            return 0
        }
        val r = right?.findMissingCount(maxDepth - 1) ?: 0
        return when {
            r == 0 -> r
            r and 0x1 == 1 -> r
            else -> r + (left?.findMissingCount(maxDepth - 1) ?: 0)
        }
    }

    private fun getHeight(node: TreeNode?): Int{
        if(node == null) return -1
        return 1 + getHeight(node.left)
    }

    private fun leftHeight(node:TreeNode?):Int{
        var height = 0
        var temp = node
        while(temp!=null) {
            temp = temp.left
            height++
        }
        return height
    }

    private fun rightHeight(node:TreeNode?):Int{
        var height = 0
        var temp = node
        while(temp!=null) {
            temp = temp.right
            height++
        }
        return height
    }

    private fun getTreeHeight(root : TreeNode?) : Int {
        if (root == null) return 0
        return countNodes(root.left) + 1
    }

    private fun countLevel(root:TreeNode?, level:Int) : Int {
        if (root == null) return 0
        if (level == 1) return 1
        return countLevel(root.left, level - 1) + countLevel(root.right, level - 1)
    }

}