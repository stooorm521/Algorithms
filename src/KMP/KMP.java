package KMP;

public class KMP {
    //1. next 数组的编写
   static void GenNext(String mod, int[] result){
        int len=mod.length();
        char[] p=mod.toCharArray();
        result[0]=-1;
        int k=-1;
        int j=0;
        while (j<len-1){
            //p[k]表示前缀，p[j]表示后缀
            if(k==-1||p[j]==p[k]){
                k++;
                j++;
                result[j]=k;
            }
            else{
                k=result[k];
            }
        }
    }

    //2. next数组的改进
    static void GenNext2(String mod, int[] result){
        int len=mod.length();
        char[] p=mod.toCharArray();
        result[0]=-1;
        int k=-1;
        int j=0;
        while (j<len-1){
            //p[k]表示前缀，p[j]表示后缀
            if(k==-1||p[j]==p[k]){
                k++;
                j++;
                if(p[j]!=p[k])
                    //之前只有这一行
                result[j]=k;
                else
                    //因为不能出现p[j] = p[ next[j ]]，所以当出现时需要继续递归，k = next[k] = next[next[k]]
                    result[j]=result[k];
            }
            else{
                k=result[k];
            }
        }
    }

    public static void main(String[] args) {
       String c="DABCDABDE";
        int[] a=new int[c.length()];
        GenNext(c, a);
        System.out.println(a.toString());
    }
}
