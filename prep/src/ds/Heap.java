package ds;

import java.util.Arrays;

public class Heap {
    private int bucket[] = new int[20];
    private int index = 0;

    public static void main(String[] args) {
        Heap heap = new Heap();
        heap.addElement(19);
        heap.addElement(3);
        heap.addElement(17);
        heap.addElement(2);
        heap.addElement(100);
        heap.addElement(7);
        heap.addElement(36);
        heap.addElement(19);
        heap.addElement(25);
        heap.addElement(1);
        System.out.print(heap.toString());
        int arr[]={ 12, 11, 13, 5, 6, 7 };
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int arr[])
    {
        buildHeap(arr);

        for (int i = arr.length-1; i >=0 ; i--) {
            int swap=arr[0];
            arr[0]=arr[i];
            arr[i]=swap;
            heapify(arr,i,0);
        }
    }

    public static void buildHeap(int arr[]) {
        int n=arr.length;
        for (int i = n/2-1; i >=0; i--) {
            heapify(arr, n, i);
        }

    }


    private static void heapify(int arr[], int n, int i) {
        int largest=i;
        int l=2*i+1;
        int r=2*i+2;
        if(l<n&&arr[l]>arr[largest]){
            largest=l;
        }

        if(r<n&&arr[r]>arr[largest]){
            largest=r;
        }

        if(largest!=i){
            int swap=arr[largest];
            arr[largest]=arr[i];
            arr[i]=swap;
            heapify(arr, n, largest);
        }

    }






    public void addElement(int element) {

        if (index >= bucket.length) {
            throw new Error("heap is full please resize it");
        }

        bucket[index] = element;

        int i = index;
        while (i > 0) {
            int parent = i / 2;
            if (i > 0 && bucket[i] > bucket[parent]) {
                int tmp = bucket[i];
                bucket[i] = bucket[parent];
                bucket[parent] = tmp;
            }
            i = parent;
        }
        index++;
    }

    public void deleteElement(int element) {

    }





    @Override
    public String toString() {
        return "Heap : {" +
                "bucket=" + Arrays.toString(bucket) +
                '}';
    }
}
