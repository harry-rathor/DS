package ds;

public class FindGDC {
    public static int gdc(int a , int b){
        if(b==a) return a;
        return gdc(b,a%b);
    }

    public static void main(String[] args) {
        int a = 112, b = 543;
        System.out.print(gdc( a ,  b));
    }
}
