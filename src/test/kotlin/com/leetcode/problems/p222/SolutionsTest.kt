package com.leetcode.problems.p222

import org.junit.Test

import org.junit.Assert.*
import java.util.*

class SolutionsTest {

    val sol = Solutions()

    @Test
    fun countNodes() {
        val tree = createTree(arrayOf(1,2,3,4,5,6))
        assertEquals(6, sol.countNodes(tree))
    }

    @Test
    fun countNodes_02() {
        val tree = createTree(arrayOf(1,2,3,4,5,6))
        assertEquals(6, sol.countNodes02(tree))
    }

    @Test
    fun countNodes_03() {
        val tree = createTree(arrayOf(1,2,3,4,5,6))
        assertEquals(6, sol.countNodes03(tree))
    }

    @Test
    fun countNodes_04() {
        val tree = createTree(arrayOf(1,2,3,4,5,6))
        assertEquals(6, sol.countNodes04(tree))
    }

    @Test
    fun countNodes_05() {
        val tree = createTree(arrayOf(1,2,3,4,5,6))
        assertEquals(6, sol.countNodes05(tree))
    }


    private fun createTree(array: Array<Int>): Solutions.TreeNode? {
        if (array == null || array.size == 0) {
            return null
        }
        val treeNodeQueue: Queue<Solutions.TreeNode> = LinkedList<Solutions.TreeNode>()
        val integerQueue: Queue<Int> = LinkedList()
        for (i in 1 until array.size) {
            integerQueue.offer(array[i])
        }
        val treeNode = Solutions.TreeNode(array[0])
        treeNodeQueue.offer(treeNode)
        while (!integerQueue.isEmpty()) {
            val leftVal = if (integerQueue.isEmpty()) null else integerQueue.poll()
            val rightVal = if (integerQueue.isEmpty()) null else integerQueue.poll()
            val current: Solutions.TreeNode = treeNodeQueue.poll()
            if (leftVal != null) {
                val left = Solutions.TreeNode(leftVal)
                current.left = left
                treeNodeQueue.offer(left)
            }
            if (rightVal != null) {
                val right = Solutions.TreeNode(rightVal)
                current.right = right
                treeNodeQueue.offer(right)
            }
        }
        return treeNode
    }
}