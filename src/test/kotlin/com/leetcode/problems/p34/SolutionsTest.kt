package com.leetcode.problems.p34

import org.junit.Test

import org.junit.Assert.*

class SolutionsTest {

    val sol =  Solutions()

    @Test
    fun searchRange01_test01() {
        assertArrayEquals(intArrayOf(-1,-1), sol.searchRange01(intArrayOf(), 0) )
    }

    @Test
    fun searchRange01_test02() {
        assertArrayEquals(intArrayOf(-1,-1), sol.searchRange01(intArrayOf(5,7,7,8,8,10), 6) )
    }

    @Test
    fun searchRange01_test03() {
        assertArrayEquals(intArrayOf(3,4), sol.searchRange01(intArrayOf(5,7,7,8,8,10), 8) )
    }
}