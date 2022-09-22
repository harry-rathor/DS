package ds;

public class MaxSumSubArray {
    public static void main(String[] args) {
        int arr[]={4, -9, 3, -2, 4, -12};

        int current_sum=arr[0];
        int max_sum=current_sum;
        for (int i = 1; i < arr.length; i++) {
            current_sum=Math.max(arr[i],arr[i]+current_sum);
            max_sum=Math.max(current_sum,max_sum);
        }
        System.out.println(max_sum);
    }
}
