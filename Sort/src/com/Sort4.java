package com;

/**
 * Author:Fanleilei
 * Created:2019/4/27 0027
 */
public class Sort4 {

    //归并排序
    /**
     * 1.把要排序区间平均分成两部分  mid
     * 2.分治算法，对左右两个区间进行同样方式的排序
     *   直到size==1   已经有序
     *       size==0   区间没有数了
     * 3.合并左右两个有序区间到一个有序区间
     */

    public static  int[] Merge(int[] array){

        mergeSort(array,0,array.length);
        return array;
    }

    public static void mergeSort(int[] array,int low,int high){//左闭右开

        if(low==high-1){
            return;

        }
        if(low>high){

            return;
        }
        int mid=low+(high-low)/2;
        //[0,mid)  [mid,high)

        mergeSort(array,low,mid);
        mergeSort(array,mid,high);

        merge(array,low,mid,high);

    }

    private static void merge(int[] array, int low, int mid, int high) {

        int[] extra=new int[high-low];
        int i=low;
        int j=mid;
        int x=0;
        while(i<mid && j<high) {
            if (array[i] < array[j]) {
                extra[x] = array[i];
                x++;
                i++;
            } else {

                extra[x] = array[j];
                x++;
                j++;
            }
        }

        //当有一个数组的数都搬完时
        while (i<mid) {
            extra[x++]=array[i++];
        }
        while (j<high) {
            extra[x++]=array[j++];
        }
        //再将extra里面的搬回array里
        for (int k=low;k<high;k++){
             array[k]=extra[k-low];
        }
    }

    //归并排序，非递归
    public static int[] Merge2(int[] array) {

        for(int i=1;i<array.length;i*=2){
            for(int j=0;j<array.length;j+=2*i){
             int low=j;
             int mid=low+i;
             if(mid>array.length){
                 continue;
             }

             int high=mid+i;
             if(high>array.length){
                 high=array.length;

             }
                merge(array,low,mid,high);
            }

        }
        return array;

    }
    public static void main(String[] args) {

        int array[]=new int[]{9,3,1,5,2,4,3,8,7,6};
        //int[] result=Merge(array);
        int[] result=Merge2(array);
        for(int t:result){

            System.out.print(t+" ");
        }
    }
}
