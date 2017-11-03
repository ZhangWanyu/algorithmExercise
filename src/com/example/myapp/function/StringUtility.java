package com.example.myapp.function;

import java.util.HashSet;

/**
 * Created by zhangwanyu on 17-10-30.
 */
public class StringUtility {

    private static String mString= "ababcabcbb";




    //查找最长不重复的子数组
    public static StringBuffer lengthOfLongestSubstring() {
        if (mString == null || mString.length() == 0) {
            return new StringBuffer("error");
        }
        StringBuffer sb = new StringBuffer();
        char[] arrat = mString.toCharArray();
        int length = arrat.length;
        int start=0,count=0;
        int tempCount=0,returnStart=0;
        HashSet<Character> set = new HashSet<Character>();
        for (int i=0; i<length; i++) {
            if (set.contains(arrat[i])) {
                if (tempCount >= count) {
                    returnStart = start;
                }
                for (int j=start; j<i; j++) {
                    if (arrat[i] == arrat[j]) {
                        start++;
                        break;
                    } else {
                        set.remove(arrat[j]);
                        start++;
                        tempCount--;
                    }
                }
            } else {
                set.add(arrat[i]);
                count = Math.max(count, i-start+1);
                tempCount++;
            }
        }
        sb.append(" count is " + count + "  start  is " + returnStart);
        return sb;
    }

    public int lengthOfLongestSubstring(String s) {
        if(s==null || s.length()==0){
            return 0;
        }

        int start=0;
        int max = 0;

        HashSet<Character> set = new HashSet<Character>();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);

            if(!set.contains(c)){
                set.add(c);

                max = Math.max(max, i-start+1);
            }else{
                for(int j=start; j<i; j++){
                    set.remove(s.charAt(j));

                    if(s.charAt(j)==c){
                        start=j+1;
                        break;
                    }
                }

                set.add(c);
            }
        }
        return max;
    }

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
