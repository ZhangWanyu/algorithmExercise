package com.example.myapp.function;

/**
 * Created by zhangwanyu on 17-10-24.
 */
public class ArrayUtility {

    private static final String ERROR = "error";

    private static int mArray[] = {1,3,5,8,11,13,16,25};


    //查找连续连续正数序列和为value的所有序列(最少连个连续的数字组成)
    public static StringBuffer findContinueSequence() {
        int find = 15;
        StringBuffer sb = new StringBuffer();
        boolean have = false;
        int low=1,hight=2;
        int count=3;
        sb.append("find is " + find + "\n");
        while (low <= find/2 && hight < find) {
            if (count == find) {
                addResulr(low, hight, sb);
                have = true;
                count -= low++;
            } else if (count < find) {
                count += ++hight;
            } else {
                count -= low++;
            }
        }

        if (!have) {
            sb.append("no find");
        }
        return sb;
    }

    private static void addResulr(int start, int end, StringBuffer sb) {
        for (int i=start; i<=end; i++) {
            sb.append(i + " , ");
        }
        sb.append("\n");
    }

    //查找数组中和为find的两个数字
    public static StringBuffer findNumberWithSum() {
        if (mArray == null || mArray.length <= 1) {
            return new StringBuffer(ERROR);
        }
        StringBuffer sb = new StringBuffer();
        int end = mArray.length-1;
        int start=0;
        int find = 21; int count = 0;
        sb.append("find value is " + find + "\n");
        while (end > start) {
            count = mArray[start] + mArray[end];
            if (count == find) {
                return sb.append("number is " +mArray[start] + " + " + mArray[end]);
            }
            if (count < find) {
                start++;
            } else {
                end--;
            }
        }
        sb.append("not find");
        return sb;
    }


    //数组中的逆须对
    public static StringBuffer arrayInversePairsCore() {
        if (mArray == null || mArray.length <= 0) {
            return new StringBuffer(ERROR);
        }
        StringBuffer sb = new StringBuffer();
        int length = mArray.length-1;
        int count = arrayInversePairsCoreFunc(mArray, 0, length, 0);
        sb.append("count is " + count);
        return sb;
    }

    private static int arrayInversePairsCoreFunc(int[] array, int start, int end, int count) {
        if (start < end) {
            int mid = start + (end-start)/2;
            int count1 = arrayInversePairsCoreFunc(array, start, mid, count);
            int count2 = arrayInversePairsCoreFunc(array, mid+1, end, count);
            int count3 = arrayInversePairsCoreCombineFunc(array, start, mid, end, count);
            return count + count1 + count2 + count3;
        }
        return 0;
    }

    private static int arrayInversePairsCoreCombineFunc(int[] array, int start, int mid, int end, int count) {
        int lenght = end-start+1;
        int[] temp = new int[lenght];
        int tempMid = mid;
        mid = mid+1;
        int index=0;
        int originStart = start;
        while (start <= tempMid && mid <= end) {
            if (array[start] <= array[mid]) {
                temp[index++] = array[start++];
            } else {
                temp[index++] = array[mid++];
                count += tempMid-start+1;
            }
        }

        while (start<=tempMid) {
            temp[index++]=array[start++];
        }
        while (mid<=end) {
            temp[index++]=array[mid++];
        }

        for (int i=0; i<lenght; i++) {
            array[originStart++] = temp[i];
        }
        return count;
    }

    //数组中超过一半的数
    public static StringBuffer arrayMoreThanHalfValue() {
        if (mArray == null || mArray.length <= 0) {
            return new StringBuffer(ERROR);
        }
        StringBuffer sb = new StringBuffer();
        int length = mArray.length;
        int value=0, time=0, count=0;
        for (int i=0; i<length; i++) {
            if (time == 0) {
                value = mArray[i];
                time++;
                continue;
            }

            if (value == mArray[i]) {
                time++;
            } else {
                time--;
            }
        }
        //检验是否超过一半
        for (int i=0; i<length; i++) {
            if (value == mArray[i]) {
                count++;
            }
        }
        if (count*2 > length) {
            sb.append("value is " + value);
        } else {
            sb.append("no vlaue");
        }
        return sb;
    }

    //旋转数组的最小值
    public static StringBuffer rotateArrayMinValue() {
        if (mArray == null || mArray.length <= 0) {
            return new StringBuffer(ERROR);
        }
        StringBuffer sb = new StringBuffer();

        int length = mArray.length;
        int start = 0, end = length-1;
        int mid  ;
        boolean haveDouble = false;
        while (start < end) {
            mid = (start + end)/2 ;
            if (mid > start && mid < end) {
                if (mArray[mid] == mArray[mid+1] || mArray[mid] == mArray[mid-1]){
                    haveDouble = true;
                    break;
                }
                if (mArray[mid] < mArray[mid+1] && mArray[mid] < mArray[mid-1]){
                    sb.append(mArray[mid]);
                    return sb;
                } else {
                    if (mArray[mid] < mArray[mid+1]) {
                        end = mid - 1;
                    } else {
                        start = mid + 1;
                    }
                }
            } else {
                sb.append(mArray[mid]);
                return sb;
            }
        }
        if (haveDouble) {
            int value=mArray[0];
            for (int i=1; i<length; i++) {
                if (mArray[i] < value) {
                    value = mArray[i];
                }
            }
            sb.append(value);
        } else {
            sb.append(mArray[(start + end) / 2]);
        }


        return sb;
    }



    public static StringBuffer selectValuelessThanX(int value) {
        if (mArray == null || mArray.length <= 0) {
            return new StringBuffer(ERROR);
        }
        StringBuffer sb = new StringBuffer();
        int length = mArray.length;
        int start = 0, end = length - 1;
        while (start < end) {
            while (mArray[start] <= value && start < end) {
                start++;
            }
            while (mArray[end] > value && start < end) {
                end--;
            }

            if (start >= end) {
                break;
            }

            swap(mArray, start, end);
            start++;
            end--;
        }

        for (int i=0; i<length; i++) {
            sb.append(mArray[i] + " , ");
        }

        return sb;
    }

    private static void swap(int array[], int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    public static StringBuffer clockwiseOupArray(int mArray[][]) {

        /**
         *
         private int mArray[][] = {
         {1,2,3,4,5,6},
         {7,8,9,10,11,12},
         {13,14,15,16,17,18}
         };
         */


        if (mArray == null || mArray.length <= 0) {
            return new StringBuffer(ERROR);
        }

        StringBuffer result = new StringBuffer();

        int heng = mArray.length;
        int lie = mArray[0].length;

        int top = 0, bottom = heng-1, left = 0, right = lie-1;
        int x;

        while (top <= bottom && left <= right) {
            for (x = left; x <= right; x++) {
                result.append(mArray[top][x] + ", ");
            }
            top++;

            if (top <= bottom && left <= right) {
                for (x = top; x <= bottom; x++) {
                    result.append(mArray[x][right] + ", ");
                }
                right--;
            }

            if (top <= bottom && left <= right) {
                for (x = right; x >= left; x--) {
                    result.append(mArray[bottom][x] + ", ");
                }
                bottom--;
            }

            if (top <= bottom && left <= right) {
                for (x = bottom; x >= top; x--) {
                    result.append(mArray[x][left] + ", ");
                }
                left++;
            }
        }

        return result;
    }
}
