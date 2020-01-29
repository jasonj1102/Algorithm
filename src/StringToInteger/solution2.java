package StringToInteger;

import java.util.Scanner;

public class solution2 {    //使用long类型，如果数超过int32位的最大值，使用long类型较为不错
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String x=scanner.nextLine();
        int y=myAtoi(x);
        System.out.println("yyyyy="+y);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
    }

    public static int myAtoi(String str){
        if(str==null||str.length()==0){
            return 0;
        }
        str=str.trim();         //去掉字符串首尾的空格字符
        char firstChar=str.charAt(0);
        int sign=1;
        int start=0;
        long res=0;
        if(firstChar=='+'){
            sign=1;
            start++;
        }else if(firstChar=='-'){
            sign=-1;
            start++;
        }
        for (int i=start;i<str.length();i++){
            if(!Character.isDigit(str.charAt(i))){
                return (int)res*sign;
            }
            res=res*10+str.charAt(i)-'0';
            if(res>Integer.MAX_VALUE&&sign==1){
                return Integer.MAX_VALUE;
            }
            if (res>Integer.MAX_VALUE&&sign==-1){
                return  Integer.MIN_VALUE;
            }
        }
        return (int) res*sign;
    }
}
