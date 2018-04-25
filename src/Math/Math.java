package Math;

import Nqueen.Array;

public class Math {
    //43 Multipy Strings
    //这里的错误在于String长度相加会超出int的范围
    public static String multiply(String num1, String num2) {
        char[] a = num1.toCharArray();
        char[] b = num2.toCharArray();
        int suma = 0;
        int sumb = 0;
        int step = 1;
        for (int i = a.length - 1; i >= 0; i--) {
            suma = suma + ((int) a[i] - 48) * step;
            step *= 10;
        }
        step = 1;
        for (int i = b.length - 1; i >= 0; i--) {
            sumb = sumb + ((int) b[i] - 48) * step;
            step *= 10;
        }
        String str = "" + (suma * sumb);
        return str;
    }

    public static String multiply3(String num00, String num000) {
        char[] num1 = num00.toCharArray();
        char[] num2 = num000.toCharArray();
        if (num1[0] == '0' || num2[0] == '0') return "0";
        int l1 = num1.length;
        int l2 = num2.length;
        char[] res = new char[l1 + l2];
        for (int i = 0; i < res.length; i++) res[i] = '0';
        for (int i = l1 - 1; i >= 0; i--) {
            //c代表进位
            int c = 0;
            int r = i + l2;
            for (int j = l2 - 1; j >= 0; j--, r--) {
                int m = (num1[i] - '0') * (num2[j] - '0') + (res[r] - '0') + c;
                int st = m % 10;
                c = m / 10;
                //printf("|m=%d,c=%d,st=%d|",m,c,st);
                res[r] = (char) (st + '0');
                if (j == 0 && c != 0) res[(r - 1)] = (char) (res[(r - 1)] + c);
            }
        }
        if (res[0] == '0') {
            return String.valueOf(res, 1, res.length - 1);
        }
        return String.valueOf(res);
    }

    public String addStrings(String num1, String num2) {
        //char[]的初始化是'\0';转义0
        StringBuilder re = new StringBuilder();
        int carry = 0;
        for (int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0 || carry == 1; i--, j--) {
            int x = i < 0 ? 0 : num1.charAt(i) - '0';
            int y = j < 0 ? 0 : num2.charAt(j) - '0';
            re.append((x + y + carry) % 10);
            carry = (x + y + carry) / 10;
        }
        return re.reverse().toString();


    }

    public static void main(String[] args) {
        System.out.println(multiply3("250", "52"));
    }
}
