package LongestEchoSubstring;

import java.util.Scanner;

public class solution2 {    //动态规划
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String x=scanner.nextLine();
        String y=longestPalindrome(x);
        System.out.println("yyyyyy="+y);
    }
    public static String longestPalindrome(String str){
        int len=str.length();
        if(len<2){
            return str;
        }

        boolean[][] dp=new boolean[len][len];
        //初始化
        for(int i=0;i<len;i++){
            dp[i][i]=true;
        }

        int maxLen=1;
        int start=0;

        for (int j=1;j<len;j++){
            for (int i=0;i<j;i++){
                if (str.charAt(i)==str.charAt(j)){
                    if(j-i<3){
                        dp[i][j]=true;
                    }else {
                        dp[i][j]=dp[i+1][j-1];
                    }
                }else {
                    dp[i][j]=false;
                }

                //只有dp[i][j]是true，证明str[i,j]是回文
                if (dp[i][j]){
                    int curLen=j-i+1;
                    if(curLen>maxLen){
                        maxLen=curLen;
                        start=i;
                    }
                }
            }
        }
        return str.substring(start,start+maxLen);
    }
}
