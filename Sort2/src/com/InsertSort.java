package com;

import java.util.Arrays;

/**
 * Author:Fanleilei
 * Created:2019/5/2 0002
 *
 * 插入排序  默认排成从小到大
 */
public class InsertSort {

    private static void insertSort1(int[] array){
        //将一个数插入到有序部分中
        //有序部分[0,i) 无序部[i,array.length)
        for(int i=0;i<array.length;i++){
            //将要插入的数与有序部分中的数依次从后面进行比较，看其应该插在哪里
            int j;
            for( j=i-1;j>=0;j--){
                if(array[j]<array[i]){
                    //array[j]<array[i] 说明array[i]所在的位置就是正确的，也不用再与前面的数进行比较了
                   break;
                }

            }
            //一直到array[i]不小于array[j]了，将（j,i）中间的数后移，然后将array[i]换到array[j]位置的后一个位置array[j+1]处，
            int t=array[i];
            int k;
            //将（j,i）中间的数后移
            for( k=i-1;k>j;k--){
                array[k+1]=array[k];

            }
            array[k+1]=t;

        }



    }

    //边找边插入
    private static void insertSort2(int[] array){
        for(int i=0;i<array.length;i++){
            //将要插入的数与有序部分中的数依次从后面进行比较，看其应该插在哪里
            int j;
            int t=array[i];
            for( j=i-1;j>=0;j--){
                if(array[j]<t){
                    //array[j]<array[i] 说明array[i]所在的位置就是正确的，也不用再与前面的数进行比较了
                    break;
                }else{
                    //将前面的数后移
                    array[j+1]=array[j];


                }
            }

            array[j+1]=t;
        }

    }

    public static void main(String[] args) {
        int[] array=new int[]{1,3,8,2,0,11,6,7,21,9};

        //insertSort1(array);
        insertSort2(array);
        System.out.println(Arrays.toString(array));
    }
}
