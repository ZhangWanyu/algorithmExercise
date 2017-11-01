package com.example.myapp.function;

/**
 * Created by zhangwanyu on 17-10-30.
 */
public class StringUtility {

    private static String mString= "abc";

    //字符串排序 如ab, 结果为 ab ba
    public static StringBuffer stringSort() {
        if (mString == null || mString.length() == 0) {
            return new StringBuffer("error");
        }
        StringBuffer sb = new StringBuffer();
        char[] string = mString.toCharArray();
        int length = mString.length();
        stringSortFunc(string, 0, length-1, sb);
        return sb;
    }

    private static void stringSortFunc(char[] temp, int index, int length, StringBuffer sb) {
        if (index == length) {
            addResult(sb, temp);
        } else {
            for (int i = index; i <= length; i++) {
                swap(temp, index, i);
                stringSortFunc(temp, index + 1, length, sb);
                swap(temp, index, i);
            }
        }
    }

    private static void addResult(StringBuffer sb, char[] temp) {
        int length = temp.length;
        for (int i=0; i<length; i++) {
            sb.append(temp[i]);
        }
        sb.append("\n");
    }

    private static void swap(char[] temp, int a, int b) {
        char value = temp[a];
        temp[a] = temp[b];
        temp[b] = value;
    }
}
