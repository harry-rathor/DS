package ds;

public class Search {

    public static void main(String[] args) {
        int arr[] = {6, 7, 8, 9, 10, 11, 12};
        System.out.println(binarySearch(arr, 6, 0, arr.length - 1));
    }

    private static boolean binarySearch(int[] arr, int key, int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;
            if (key < arr[m]) {
                return binarySearch(arr, key, l, m);
            } else if (key > arr[m]) {
                return binarySearch(arr, key, m + 1, r);
            } else {
                return key == arr[m];
            }
        }
        return false;
    }
}
