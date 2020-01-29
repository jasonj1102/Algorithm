package StringToInteger;

import java.util.Scanner;

public class solution1 {        //只需要0-9的数字
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        String x=scanner.nextLine();
        int y=myAtoi(x);
        System.out.println("-----:"+y);
    }

    public static int myAtoi(String str) {
        if(str.isEmpty()) return 0;
        char[] mychar=str.toCharArray();
        long ans=0;
        int i=0,sign=1,n=str.length();
        while(i<n&&mychar[i]==' ') {
            i++;
        }
        if(i < n &&mychar[i]=='+') {
            i++;
        }
        else if(i < n &&mychar[i]=='-') {
            i++;
            sign =-1;
        }
        //重点：只管是数字的时候，其余取0
        while(i<n&&(mychar[i]>='0'&&mychar[i]<='9')) {
            if(ans!=(int)ans) {
                return (sign==1)?Integer.MAX_VALUE:Integer.MIN_VALUE;
            }
            ans=ans*10+mychar[i++]-'0';
        }

        if(ans!=(int)ans) {
            return (sign==1)?Integer.MAX_VALUE:Integer.MIN_VALUE;
        }

        return (int)(ans*sign);

    }
}
