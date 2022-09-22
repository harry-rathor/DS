package ds;


import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Collectors;

public class FirstRepeatChar {

    public static void main(String[] args) {
        int cache[]=new int['z'-'A'];
        String str="ABCDAB";
        for (int i = 0; i < str.length(); i++) {
            char ch=str.charAt(i);
            int index=ch-'A';
            if (cache[index]==1){
                System.out.println(ch);
                break;
            } else{
                cache[index]=1;
            }
        }

        System.out.println(String.join(";","harish","pranami"));

        HashMap map=new HashMap();
        map.put("pranami",2);
        map.put("harish",1);

    }
}

