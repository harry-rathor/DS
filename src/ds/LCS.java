package ds;

public class LCS {
    public static void main(String[] args) {
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";
        int dp[][]=new int[s1.length()][s2.length()];

        System.out.print(lcs(s1.toCharArray(),s2.toCharArray(),s1.length(),s2.length(),dp));
    }

    private static int lcs(char[] X, char[] Y, int m, int n,int dp[][]) {
        if(m==0||n==0){
            return  0;
        }
        if(X[m-1]==Y[n-1]){
            int val;
            if(dp[m-1][n-1]!=0){
                val=dp[m-1][n-1];
            } else {
                val=dp[m-1][n-1]=1+lcs(X,Y,m-1,n-1,dp);
            }
            return val;
        } else {
            return Math.max(lcs(X,Y,m,n-1,dp),lcs(X,Y,m-1,n,dp));
        }
    }
}
