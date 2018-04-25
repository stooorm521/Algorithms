package JavaBase;

public class breakOut {
    public static void main(String[] args) {
        out:
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                if(j>=3)
                    break out;
                System.out.println(j);
            }
        }
        System.out.println("breakout");

        int n=9;
        try {
            Thread.sleep(n);
            System.out.println(n);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
