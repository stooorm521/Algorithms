package codeWar;

public class TEst {

    public static int squareDigits(int n) {
        // TODO Implement me
        String a = "";
        String b = String.valueOf(n);
        char[] chars = b.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            a = a + ((int) chars[i]-48) * ((int) chars[i]-48);
        }
        int c = Integer.parseInt(a);
        return c;
    }

    public static void main(String[] args) {
        System.out.println(squareDigits(919));
    }

}
