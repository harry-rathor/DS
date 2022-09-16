package ds;

import java.util.Arrays;

public class PrintFabonacci {
    private static int cache[];
    public static int fabonacci(int n){
        if(cache==null){
            cache=new int[n];
            Arrays.fill(cache,-1);
        }

        if(n<=1) return n;

        int fibo1=cache[n-1];
        if(fibo1==-1){
            cache[n-1]=fabonacci(n-1);
        }

        int fibo2=cache[n-2];
        if(fibo2==-1){
           cache[n-2]=fabonacci(n-2);
        }
        System.out.print(cache[n-1]+cache[n-2]+",");
        return cache[n-1]+cache[n-2];
    }

    private static int fibo(int n){


        int first=0;
        int next=1;
        int nth=1;
        for (int i = 2; i <=n; i++) {
            nth=first+next;
            first=next;
            next=nth;
        }
        return nth;
    }

    public static void main(String[] args) {
        System.out.println(fibo(9));
    }
}
