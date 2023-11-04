package com.example.myapplication

interface SortStrategy {
    fun sort(arr: IntArray): IntArray;
};

class BubbleSortStrategy : SortStrategy {
    override fun sort(arr: IntArray): IntArray {
        println("Bubble Sort");
        return arr;
    };
};

class QuickSortStrategy : SortStrategy {
    override fun sort(arr: IntArray): IntArray {
        println("Quick Sort");
        return arr;
    };
};

class SortContext(var strategy: SortStrategy) {
    fun sortArray(arr: IntArray): IntArray {
        return strategy.sort(arr);
    };
};

fun main() {
    val arr = intArrayOf(5, 2, 8, 1, 3);

    val bubbleSort = BubbleSortStrategy();
    val quickSort = QuickSortStrategy();

    val context = SortContext(bubbleSort);
    val sortedArray = context.sortArray(arr);

    println("Sorted Array using Bubble Sort: ${sortedArray.joinToString()}");

    context.strategy = quickSort;
    val sortedArrayQuickSort = context.sortArray(arr);

    println("Sorted Array using Quick Sort: ${sortedArrayQuickSort.joinToString()}");
};