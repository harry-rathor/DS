package ds;

import java.util.Arrays;

public class ReverseWords {
    public static void main(String[] args) {
        char str[] = "Be a game changer the world is already full of players".toCharArray();
        int i = 0, j = 0, n = str.length;


        while (j < n) {
            while (j < n&&str[j] != ' ') {
                j++;
            }

            int index = j;
            while (i < j) {
                char tmp = str[i];
                str[i] = str[j-1];
                str[j-1] = tmp;
                i++;
                j--;
            }

            i=j=index+1;

            //System.out.println(Arrays.toString(str));
        }

        i=0;j=n;
        while(i<j){
            char tmp = str[i];
            str[i] = str[j-1];
            str[j-1] = tmp;
            i++;
            j--;
        }

        System.out.println(String.copyValueOf(str));
    }
}
