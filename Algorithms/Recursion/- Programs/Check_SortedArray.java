public class Check_SortedArray {
    static void checkArray(int arr[], int Index){
        if(arr.length-1==Index){
            System.out.println("Yes sorted");
            return;
        }

        if(arr[Index]<arr[Index+1])
            checkArray(arr, Index+1);
        else{
            System.out.println("Not sorted");
            return;
        }

    }

    public static void main(String[] args) {
        int arr[]={1,2,3,4,5};
        checkArray(arr, 0);
    }
}
