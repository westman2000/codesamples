package com.leetcode.arrays

import java.util.*

class FindKthLargest {

    fun solution01(nums: IntArray, k: Int): Int {

        // check if size > 1
        // check if k > size ?

        for (i in nums.indices) {
            for (j in i until nums.size) {
                if (nums[i] > nums[j]) nums[i] = nums[j].also { nums[j] = nums[i] }
            }
        }

        println(nums.contentToString())

        return nums[nums.size - k]
    }

    fun solution02(nums: IntArray, k: Int): Int {
        nums.sort()
        return nums[nums.size - k]
    }

    fun solution03(nums: IntArray, k: Int): Int {
        nums.sortedArray()
        println(nums.contentToString())
        return nums[nums.size - k]
    }

    fun solution04(nums: IntArray, k: Int): Int {
        println(nums.contentToString())
        return nums[nums.size - k]
    }
}