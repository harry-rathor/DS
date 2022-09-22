public class array {




    public static void main(String[] args) {
        //Move 0s to the right end of the array
        int arr[]={10,3,0,5,0,0,-1,0};
          //arr[]={10,3,5,0,0,0,-1,0};
        //arr[]={10,3,5,0,0,0,-1,0}
        //i=2,
        //j=3;
        //arr[]={10,3,5,-1,0,0,0,0}

        int n=arr.length-1,i=0,j;

        while(i<n){
            while(arr[i]!=0){
                i++;
            }

            j=i+1;

            while(j<n&&arr[j]==0){
                j++;
            }
            //swap
            if(j!=i){
                int swap=arr[i];
                arr[i]=arr[j];
                arr[j]=swap;
            }

            i++;
            for (int k = 0; k < arr.length; k++) {
                System.out.print(arr[k]+",");
            }
            System.out.println();
        }



    }


}
