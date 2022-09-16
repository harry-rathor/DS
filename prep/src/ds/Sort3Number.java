package ds;

import java.util.Arrays;

public class Sort3Number {
    public static void main(String[] args) {
        int arr[]={1,1,0,2,1,2,1};


        int red=0,blue=arr.length-1;

        for (int i = 0; i <=blue; i++) {
            if(red<blue){
                if(arr[i]==0){
                    int tmp=arr[i];
                    arr[i]=arr[red];
                    arr[red]=tmp;
                    red++;
                } else  if(arr[i]==2){
                    int tmp=arr[i];
                    arr[i]=arr[blue];
                    arr[blue]=tmp;
                    i--;
                    blue--;
                }
            }

        }
        System.out.print(Arrays.toString(arr));
    }
}
