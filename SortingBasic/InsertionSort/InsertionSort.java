package InsertionSort;

import SelectionSortDetectPerformance.SortTestHelper;

public class InsertionSort {

    private InsertionSort(){

    }

    public static void sort(Comparable[]  arr){
        for(int i=0;i<arr.length;i++){
            for (int j=i;j>0;j--){
                if (arr[j].compareTo(arr[j-1])<0){
                    swap(arr,j,j-1);
                }
                else {
                    break;
                }
            }
//            for (int j=i;j>0&&arr[j].compareTo(arr[j-1])>0;j--){
//                swap(arr,j,j-1);
//            }
        }
    }

    private static void swap(Comparable[] arr, int j, int i) {
        Object t = arr[j];
        arr[j] = arr[i];
        arr[i] = (Comparable) t;
    }


    public static void main(String[] args) {
        int N = 20000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("InsertionSort", arr);
        return;
    }
}
