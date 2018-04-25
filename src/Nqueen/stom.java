package Nqueen;

import java.util.ArrayList;
import java.util.List;

public class stom {
    public List<String> generatePath(int m) {
        List<String> res = new ArrayList<>();
        backtrade("", res, m, m);
        return res;
    }

    public void backtrade(String a, List<String> s, int left, int right) {
        if (left == 0 && right == 0) {
            s.add(a);
            return;
        }
        if (left > 0) {
            backtrade(a + "(", s, left - 1, right);
        }
        if (left < right) {
            backtrade(a + ")", s, left, right - 1);
        }
    }

    //col for row[5]=2 means at the row:5, col:2 there is a Queen
    public boolean checkValidQueen(int row, int colForrow[]) {
        for (int i = 0; i < row; i++) {
            /*
            check valid, if at the same col
            the row means the row we need to verify , we should verify all the row less than the current row.
            so there is no need to verify the queen a then same row, because it cannot be possible.
            if c[i]-c[row]==i-row, which mean the diagonal cannot be fulfilled.
            */
            if (colForrow[row] == colForrow[i] || Math.abs(colForrow[i] - colForrow[row]) == Math.abs(i - row))
                return false;
        }
return true;
    }

    //    int c=0;
    public void helper(int n, int row, int colForrow[], List<List<String>> a) {
        //Assumping all the row<n are valid, so we just need to check the last row
        // the need a reccursion
        if (row == n) {
            List<String> o = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                List<Character> record = new ArrayList<>();
                for (int j = 0; j < n; j++) {
                    //colForrow means it has be a queen in this place
                    if (colForrow[i] == j) record.add('Q');
                    else record.add('.');
                }
                String tmp = record.toString();
                o.add(tmp);
            }
//            System.out.print(c++);
            a.add(o);
            return;
        }

        for (int i = 0; i < n; i++) {
            colForrow[row] = i;
            if (checkValidQueen(row, colForrow))
                helper(n, row + 1, colForrow, a);
        }
    }

    public List<List<String>> solvenQueens(int n) {
        List<List<String>> re = new ArrayList<>();
        int[] colForrow = new int[n];
//        for(int i=1;i<colForrow.length;i++){
//            colForrow[i]=-1;
//        }
        helper(n, 0, colForrow, re);
        return re;
    }
    public int totalNQueens(int n) {
        List<List<String>> re = new ArrayList<>();
        int[] colForrow = new int[n];
        helper(n, 0, colForrow, re);
     return re.size();
    }
    public static void main(String[] args) {
        stom a = new stom();
        System.out.println(a.generatePath(3));
        System.out.println(a.solvenQueens(4));
    }
}
