package com.leetcode.arrays

import org.junit.Test

import org.junit.Assert.*

class FindKthLargestTest {

    //
    val solutions = FindKthLargest()


    @Test
    fun testSolution01() {
        assertEquals(4, solutions.solution01(intArrayOf(3,2,3,1,2,4,5,5,6), 4))
        assertEquals(5, solutions.solution01(intArrayOf(3,2,1,5,6,4), 2))
    }

    @Test
    fun testSolution02() {
        assertEquals(4, solutions.solution02(intArrayOf(3,2,3,1,2,4,5,5,6), 4))
        assertEquals(5, solutions.solution02(intArrayOf(3,2,1,5,6,4), 2))
    }

    @Test
    fun testSolution03() {
        assertEquals(4, solutions.solution03(intArrayOf(3,2,3,1,2,4,5,5,6), 4))
        assertEquals(5, solutions.solution03(intArrayOf(3,2,1,5,6,4), 2))
    }
}