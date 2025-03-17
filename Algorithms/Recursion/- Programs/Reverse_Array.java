import java.util.Arrays;

public class Reverse_Array{
    static void reverseArray(int arr[],int start, int end){
        if(start>=end-1){
            return;
        }
        int temp=arr[start];
        arr[start]=arr[end-1];
        arr[end-1]=temp;
        reverseArray(arr, start+1, end-1);
    }
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,7,8,9,10};
        reverseArray(arr,0,arr.length);
        System.out.println(Arrays.toString(arr));
    }
}