package ds;

public class BasicCompression {
    public static void main(String[] args) {
        char str[] = "wwwwaaadexxxxxxywww".toCharArray();
        String res="";
        int n=str.length-1;
        for (int i = 0; i <n ; i++) {
            int count=1;
            while(i<n&&str[i]==str[i+1]){
                count++;i++;
            }
            res=str[i]+String.valueOf(count);
            System.out.print(res);
        }

    }
}
