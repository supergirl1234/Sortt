package com;

import java.util.Arrays;

/**
 * Author:Fanleilei
 * Created:2019/5/2 0002
 *
 * 归并排序
 *
 */
/**
 * 1.把要排序区间平均分成两部分  mid
 * 2.分治算法，对左右两个区间进行同样方式的排序
 *   直到size==1   已经有序
 *       size==0   区间没有数了
 * 3.合并左右两个有序区间到一个有序区间
 */
public class MergeSort {

    private static void mergeSort(int[] array){

         mergeSortInner(array,0,array.length);

    }

    private static void mergeSortInner(int[] array, int left, int right) {
        if(left+1==right){
            return;

        }
        if(left==right){
            return;
        }
        //分成两个区间，对其分别进行排序
        int mid=left+(right-left)/2;
        mergeSortInner(array,left,mid);
        mergeSortInner(array,mid,right);
        //将其左右两个有序区间到一个有序区间
        merge(array,left,mid,right);


    }

    private static void merge(int[] array, int left, int mid, int right) {

        int i=left;
        int j=mid;
        int k=0;
        int[] extra=new int[right-left];
        while(i<mid&&j<right){
            if(array[i]<=array[j]){
                extra[k]=array[i];
                k++;
                i++;
            }else{

                extra[k++]=array[j++];
            }


        }

        //当还剩下没比较完时
        while(i<mid){
            extra[k++]=array[i++];

        }
        while(j<right){
            extra[k++]=array[j++];

        }

        //再将其搬回原数组中
        for(int x=left;x<right;x++){
            array[x]=extra[x-left];
        }
    }

    public static void main(String[] args) {
        int[] array=new int[]{1,3,8,2,0,11,6,7,21,9};

        mergeSort(array);
        System.out.println(Arrays.toString(array));
    }

}
