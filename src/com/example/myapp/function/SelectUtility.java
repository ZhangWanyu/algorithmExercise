package com.example.myapp.function;

/**
 * Created by zhangwanyu on 17-10-31.
 */
public class SelectUtility {

    private static int[] mArray = {1,2,3,4,5,6,7,8,9,10};

    public static StringBuffer binarySearch() {
        if (mArray == null || mArray.length == 0) {
            return new StringBuffer("error");
        }
        StringBuffer sb = new StringBuffer();

        int value = 3;
        int end = mArray.length-1;
        int start = 0;
        int mid;
        while (start <= end) {
            mid = start + (end-start)/2;
            if (mArray[mid] == value) {
                return sb.append("position is " + mid+1);
            }
            if (mArray[mid] > value) {
                end = mid-1;
            } else {
                start = mid+1;
            }
        }
        sb.append("no find");
        return sb;
    }
}
