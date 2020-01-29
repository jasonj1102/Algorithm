package noRepeatString;


//在暴力法中，我们会反复检查一个子字符串是否含有有重复的字符，但这是没有必要的。如果从索引i到j−1 之间的子字符串 s_{ij}
//已经被检查为没有重复字符。我们只需要检查 s[j]对应的字符是否已经存在于子字符串 s_{ij}
//中。要检查一个字符是否已经在子字符串中，我们可以检查整个子字符串，这将产生一个复杂度为 O(n^2)的算法，但我们可以做得更好。
//通过使用 HashSet 作为滑动窗口，我们可以用 O(1)的时间来完成对字符是否在当前的子字符串中的检查。
//滑动窗口是数组/字符串问题中常用的抽象概念。 窗口通常是在数组/字符串中由开始和结束索引定义的一系列元素的集合，即[i,j)（左闭，右开）。
// 而滑动窗口是可以将两个边界向某一方向“滑动”的窗口。例如，我们将 [i, j)向右滑动 11 个元素，则它将变为[i+1,j+1)（左闭，右开）。
//回到我们的问题，我们使用 HashSet 将字符存储在当前窗口 [i, j)（最初j=i）中。 然后我们向右侧滑动索引 jj，如果它不在 HashSet 中，
//我们会继续滑动 j。直到 s[j] 已经存在于 HashSet 中。
//此时，我们找到的没有重复字符的最长子字符串将会以索引 ii 开头。如果我们对所有的 ii 这样做，就可以得到答案。

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class solution2 {    //滑动窗口
    public static void main(String[] args) {
        String s="ssfhsjkdf";
        int x=lengthOfLongestSubstring(s);
        System.out.println("最长子串长度为："+x);
    }


    public static int lengthOfLongestSubstring(String s){
        int n=s.length();
        Set<Character> set=new HashSet<>();
        int ans=0,i=0,j=0;
        while (i<n&&j<n){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                System.out.println("-----:"+j);
                    ans=Math.max(ans,j-i);
            }else {
                set.remove(s.charAt(i++));
            }
        }
        Iterator iterator=set.iterator();
        while (iterator.hasNext()){
            System.out.println("xxx="+iterator.next());
        }
        return ans;
    }
}
