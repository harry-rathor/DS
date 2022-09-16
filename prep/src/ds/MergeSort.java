package ds;

import scala.Array;

import java.util.Arrays;

public class MergeSort {

    public static void sort(int arr[],int l,int r){
        if(l<r){
            int m=l+(r-l)/2;
            sort(arr,l,m);
            sort(arr,m+1,r);
            merge(arr,l,m,r);
        }
    }

    private static void merge(int arr[], int l, int m, int r) {
        int n1=m-l+1;
        int n2=r-m;
        int L[]=new int[n1];
        int R[]=new int[n2];

        for (int i = 0; i < n1; i++) {
            L[i]=arr[l+i];
        }
        for (int i = 0; i < n2; i++) {
            R[i]=arr[m+1+i];
        }
        int i=0,j=0,k=l;
        while (i<n1&&j<n2){
            if(L[i]<=R[j]){
                arr[k++]=L[i++];
            } else {
                arr[k++]=R[j++];
            }
        }
        while (i<n1){
            arr[k++]=L[i++];
        }

        while (j<n2){
            arr[k++]=R[j++];
        }

    }

    public static void main(String[] args) {
        int arr[] = { 12, 11, 13, 5, 6, 7 };
        sort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
