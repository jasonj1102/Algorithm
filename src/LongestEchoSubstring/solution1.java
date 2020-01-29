package LongestEchoSubstring;
    //最长回文子串
public class solution1 {    //暴力匹配
    public static void main(String[] args) {
        String x="aaffaba";
        System.out.println("回文数="+longestPalindrome(x));
    }
    public static String longestPalindrome(String s){
        int len=s.length();
        if(len<2){
            return s;
        }
        int maxLen=1;
        String res=s.substring(0,1);
        //枚举所有长度大于等于2的子串

        for (int i=0;i<len;i++){
            for (int j=i+1;j<len;j++){
                if(j-i+1>maxLen&&valid(s,i,j)){
                    maxLen=j-i+1;
                    res=s.substring(i,j+1);
                }
            }
        }
        return res;
    }

    public static boolean valid(String s,int left,int right){
        //验证子串是否为回文串
        while (left<right){
            if(s.charAt(left)!=s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
