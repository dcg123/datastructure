package SelectionSort;

public class SelectionSort {

    private SelectionSort(){}

    public static void sort(int arr[]){
        for (int i=0;i<arr.length;i++){
            int minIndex=i;
            for (int j=i+1;j<arr.length;j++){
                if (arr[j]<arr[i]){
                    minIndex=j;
                }
            }
            swap(arr,i,minIndex);
        }
    }

    public static void swap(int arr[],int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public static void main(String[] args) {

        int[] arr = {10,9,8,7,6,5,4,3,2,1};
        SelectionSort.sort(arr);
        for( int i = 0 ; i < arr.length ; i ++ ){
            System.out.print(arr[i]);
            System.out.print(' ');
        }
        System.out.println();
    }
}
