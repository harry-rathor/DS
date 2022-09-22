package ds;

import java.util.ArrayList;

public class SubsetSum {

    public static boolean isSubsetSum(int set[],int n,int sum){
        if(sum==0)
            return true;
        if(n==0)
            return false;
        return  isSubsetSum( set, n-1, sum) || isSubsetSum( set, n-1, sum-set[n-1]);
    }

    public static void main(String[] args) {
        //int set[] = { 3, 34, 4, 12, 5, 2 };
        int sum = 3;
        //System.out.println(isSubsetSum(set,set.length,sum));
        int arr[]={2,1,1,1};

        ArrayList<Integer> result= new ArrayList<Integer>();
        printSubArray(arr,sum, arr.length,result);
        System.out.println(result.toString());
    }

    public static boolean printSubArray(int arr[],int sum,int n,ArrayList<Integer>  result){
        if(sum==0)
            return true;
        if(n==0)
            return false;

        boolean a=printSubArray(arr,sum,n-1,result);
        if(a)
            result.add(arr[n-1]);

        boolean b=printSubArray(arr,sum-arr[n-1],n-1,result);
        System.out.println(sum+"-"+n+a+":"+b);
         if(b)
            result.add(arr[n-1]);



        return a||b;
    }
}
