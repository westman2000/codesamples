package com.leetcode.problems.p34

import java.util.*


/**
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
 * If target is not found in the array, return [-1, -1].
 * Follow up: Could you write an algorithm with O(log n) runtime complexity?
 */
class Solutions {

    fun searchRange01(nums: IntArray, target: Int): IntArray {

        val result = intArrayOf(-1,-1)
        if (nums.isEmpty()) return result

        return intArrayOf(
                findLeftMostIndex(nums, target),
                findRightMostIndex(nums, target)
        )
    }

    private fun findLeftMostIndex(nums: IntArray, target: Int) : Int {
        print("findLeftMostIndex(${nums.contentToString()}, $target)")

        var beginIndex = 0
        var endIndex = nums.size - 1
        while (beginIndex + 1 < endIndex) {
            val middleIndex = beginIndex + ((endIndex - beginIndex)/2)
            if (nums[middleIndex] >= target) {
                endIndex = middleIndex
            } else {
                beginIndex = middleIndex
            }
        }
        return when (target) {
            nums[beginIndex] -> {
                println(" = beginIndex->[$beginIndex]")
                beginIndex
            }
            nums[endIndex]   -> {
                println(" = endIndex->[$endIndex]")
                endIndex
            }
            else             -> {
                println("->[-1]")
                -1
            }
        }
    }

    private fun findRightMostIndex(nums: IntArray, target: Int) : Int {
        print("findRightMostIndex(${nums.contentToString()}, $target)")

        var beginIndex = 0
        var endIndex = nums.size - 1
        while (beginIndex + 1 < endIndex) {
            val middleIndex = beginIndex + ((endIndex - beginIndex)/2)
            if (nums[middleIndex] <= target) {
                beginIndex = middleIndex
            } else {
                endIndex = middleIndex
            }
        }
        return when (target) {
            nums[endIndex] -> {
                println(" = endIndex->[$endIndex]")
                endIndex
            }
            nums[beginIndex] -> {
                println(" = beginIndex->[$beginIndex]")
                beginIndex
            }
            else -> {
                println("->[-1]")
                -1
            }
        }
    }

}