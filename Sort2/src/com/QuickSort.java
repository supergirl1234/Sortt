package com;

import java.util.Arrays;

/**
 * Author:Fanleilei
 * Created:2019/5/2 0002
 *
 * 快速排序
 */
public class QuickSort {


    private  static void quickSort(int[] array){

        quickSortInner(array,0,array.length-1);

    }
    private static void quickSortInner(int[] array,int left,int right){
        if(left==right){
            return;

        }
        if(left>right){
            return;

        }
        //先找出来基准值最终所在的位置
        //int splitVaule=partion1(array,left,right);
        //int splitVaule=partion2(array,left,right);
        int splitVaule=partion3(array,left,right);
        quickSortInner(array,left,splitVaule-1);
        quickSortInner(array,splitVaule+1,right);

    }

    //获取基准值下标的方法 hover法
    private static int partion1(int[] array, int left, int right) {
        //以最右边的数为标准，将其它数与其相比较
        int vaule=array[right];
        int begin=left;
        int end=right;
        while(begin<end){
            while(begin<end&&array[begin]<=vaule){

                 begin++;
            }
            while(begin<end&&array[end]>=vaule){

                end--;
            }

            //当begin和end停止继续时，说明不满足左边的比基准值小，右边的比基准值大了
            //则将这两个位置的数互换
            int t=array[begin];
            array[begin]=array[end];
            array[end]=t;

        }

         //将基准值换到begin这个位置

        int temp=array[begin];
        array[begin]=vaule;
        array[right]=temp;


        //返回基准值所在的下标
        return  begin;

    }

    //获取基准值下标的方法 挖坑法
    private static int partion2(int[] array, int left, int right) {
        //以最右边的数为标准，将其它数与其相比较
        int vaule=array[right];
        int begin=left;
        int end=right;
        while(begin<end){
            while(begin<end&&array[begin]<=vaule){

                begin++;
            }
            array[end]=array[begin];
            while(begin<end&&array[end]>=vaule){

                end--;
            }

            array[begin]=array[end];

        }

        //将基准值换到begin这个位置
        array[begin]=vaule;


        //返回基准值所在的下标
        return  begin;


    }

    //获取基准值下标的方法 前后下标法
    //0~d之间是小于基准值的，d~i之间是大于基准值的
    //将最右边的数作为基准值
    private static int partion3(int[] array, int left, int right) {
        int d=left;
        for(int i=left;i<right;i++){
            if(array[i]<array[right]){

                //就将这个数移到array[d]的前面，就保证了下标d前面的数都是小于array[right]的
                //即 将array[i]与array[d]互换位置
                int t=array[d];
                array[d]=array[i];
                array[i]=t;

                //array[d]的位置也后移一位
                d++;
            }

        }

        //最后将array[right]与array[d]换一下位置
        int temp=array[d];
        array[d]=array[right];
        array[right]=temp;

       return  d;
    }


    public static void main(String[] args) {
        int[] array=new int[]{1,3,8,2,0,11,6,7,21,9};

        quickSort(array);
        System.out.println(Arrays.toString(array));
    }
}
