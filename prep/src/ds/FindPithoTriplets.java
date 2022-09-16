package ds;

public class FindPithoTriplets {
    public static void main(String[] args) {
        //int A[] = { 3, 12, 4, 6, 35,37};
        int A[] = { 93,39,80,91,58,59,92,16,89,57,12,3,35,73,56,29,47,63,87};
        for (int i = 0; i < A.length; i++) {
                int m = (int)(A[i] / 2);
                long n = m * m - 1;
                long l = m * m + 1;
                int second = -1;

                for (int j = 0; j < A.length; j++) {
                    if (n == A[j]) {
                        second = A[j];
                        break;
                    }
                }

                for (int j = 0; second > -1 && j < A.length; j++) {
                    if (l == A[j]) {
                        System.out.println(A[i] + ":" + second + ":" + A[j]);
                        break;
                    }
                }
        }
    }
}
