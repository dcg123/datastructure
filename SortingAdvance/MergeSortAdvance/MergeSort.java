package MergeSortAdvance;

import java.util.Arrays;

public class MergeSort {
    private MergeSort(){

    }

    //合并arr[1...mid]和[mid+1....r]两部分进行归并
    private static void merge(int[] arr,int left,int mid,int right,int[] temp){
        int i=left;//左序列指针
        int j=mid+1;//右序列指针
        int t=0;//零时指针
        while (i<=mid&&j<=right){//循环比较先把两组中小的数添加到tmep中
            if (arr[i]<arr[j]){
                temp[t++]=arr[i];
                i++;
            }else {
                temp[t++]=arr[j];
                j++;
            }
        }
        while (i<=mid){//将左边剩余元素填充进temp中
            temp[t++]=arr[i++];
        }
        while (j<=right){//将右序列剩余元素填充进temp中
            temp[t++]=arr[j++];
        }
        t=0;
        //将temp中的元素全部拷贝到原数组中
        while(left <= right){
            arr[left++] = temp[t++];
        }
    }

    private static void sort(int[] arr) {
        int []temp = new int[arr.length];//在排序前，先建好一个长度等于原数组长度的临时数组，避免递归中频繁开辟空间
        sort(arr,0,arr.length-1,temp);
    }

    // 递归使用归并排序,对arr[l...r]的范围进行排序
    private static void sort(int[] arr,int left,int right,int []temp){
        // 优化2: 对于小规模数组, 使用插入排序
        if( right - left <= 15 ){
            //直接使用插入排序
            //InsertionSort.sort(arr, l, r);
            return;
        }
        int mid=(left+right)/2;
        sort(arr, left, mid, temp);
        sort(arr,mid+1,right,temp);
        // 优化1: 对于arr[mid] <= arr[mid+1]的情况,不进行merge
        // 对于近乎有序的数组非常有效,但是对于一般情况,有一定的性能损失
        if (arr[mid]>arr[mid+1]) merge(arr,left,mid,right,temp);

    }

    public static void main(String []args){
        int []arr = {9,8,7,6,5,4,3,2,1};
        MergeSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }


}
