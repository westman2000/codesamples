package com.leetcode.problems.p104


import org.junit.Assert.*
import org.junit.Test
import java.util.*


class SolutionsTest {

    //
    val sol = Solutions()

    @Test
    fun maxDepth_Test01() {
        val tree = createTree(arrayOf<Int?>(3, 9, 20, null, null, 15, 7))

        assertEquals(3, sol.maxDepth(tree))
    }

    @Test
    fun maxDepth_Test02() {
        val tree = createTree(arrayOf(1, null, 2))

        assertEquals(2, sol.maxDepth(tree))
    }

    @Test
    fun maxDepth_Test03() {
        val tree = createTree(arrayOf())
        assertEquals(0, sol.maxDepth(tree))
    }

    @Test
    fun maxDepth_Test04() {
        val tree = createTree(arrayOf(0))
        assertEquals(1, sol.maxDepth(tree))
    }

    private fun createTree(array: Array<Int?>?): Solutions.TreeNode? {
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