package com.example.myapp.function;

/**
 * Created by zhangwanyu on 17-10-24.
 */
public class OtherUtility {

    //count 个人，第一个将物品分成count,多一个（扔掉），然后拿走一份，后面每个人都将剩下的分成count,多一个（扔掉）
    private int funcGetPointCount(int count){//1-6 2-6*5+1=31 3-31*5+1=156
        if (count < 1) {
            return 1;
        }
        return funcGetPointCount(count - 1) * 5 + 1;
    }

    private static String strOrigin = "abcdefababaeikfj";
    private static String strFind = "ababae";
    public static StringBuffer KMP() {
        if (strOrigin == null || strOrigin.length()==0 || strFind == null || strFind.length() == 0) {
            return new StringBuffer("error");
        }
        int[] next = KMPNext(strFind);
        int result = KMPFunc(strOrigin, strFind, next);

        StringBuffer sb = new StringBuffer();
        sb.append("result is " + result + "\n");
        sb.append("next data is :  ");
        for (int i=0; i<next.length; i++) {
            sb.append(next[i] + " , ");
        }
        return sb;
    }

    private static int[] KMPNext(String find) {
        int length = find.length();
        int[] next = new int[length];
        int j=0;
        next[0]=0;
        for (int i=1; i<length; i++) {
            while (j>0 && find.charAt(i) != find.charAt(j)) {
                j=next[j-1];
            }

            if (find.charAt(i) == find.charAt(j)) {
                j++;
            }
            next[i]=j;
        }

        return next;
    }

    private static int KMPFunc(String origin, String find, int[] next) {
        int length = origin.length();
        int j=0;
        for (int i=0; i<length; i++) {
            while (j>0 && origin.charAt(i) != find.charAt(j)) {
                j = next[j-1];
            }

            if (origin.charAt(i) == find.charAt(j)) {
                j++;
            }
            if (j==find.length()) {
                return i-j+1;
            }
        }
        return -1;
    }
}
