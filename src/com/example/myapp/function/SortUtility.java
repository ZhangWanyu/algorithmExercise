package com.example.myapp.function;

/**
 * Created by zhangwanyu on 17-10-27.
 */
public class SortUtility {

    private static int array[] = {3,6,1,9,14,5,2,5,9,16,34,8};

    public static StringBuffer sort() {
        if (array == null || array.length <= 0) {
            return new StringBuffer("error");
        }
        StringBuffer sb = new StringBuffer();
        int length = array.length;

        bubbleSort();

        for (int i=0; i<length; i++) {
            sb.append(array[i] + " , ");
        }
        return sb;
    }

    private static void swap(int a[], int a1, int a2) {
        int temp = a[a1];
        a[a1] = a[a2];
        a[a2] = temp;
    }

    private static void bubbleSort() {
        int length = array.length;
        for (int i=0; i<length; i++) {
            for (int j=0; j<length-i-1;j++) {
                if (array[j] > array[j+1]) {
                    swap(array, j, j+1);
                }
            }
        }
    }

    private static void selectSort() {
        int length = array.length;
        for (int i=0; i<length; i++) {
            for (int j=i+1; j<length;j++) {
                if (array[j] < array[i]) {
                    swap(array, i, j);
                }
            }
        }
    }

    private static void quickSort(int start, int end) {
        if (start < end) {
            int index = funcQuickSort(start, end);
            quickSort(index+1, end);
            quickSort(start, index-1);
        }
    }

    private static int  funcQuickSort(int start, int end) {
        int temp = array[start];

        while (start < end) {
            while (array[end] >= temp && start < end) {
                end--;
            }
            array[start] = array[end];

            while (array[start] <= temp && start < end) {
                start++;
            }
            array[end] = array[start];
        }
        array[start] = temp;
        return start;
    }
}
