package com;

import java.util.Arrays;

/**
 * Author:Fanleilei
 * Created:2019/5/2 0002
 *
 * 选择排序
 */
public class SelectSort {

    private static void selectSort(int[] array){

        //从无序的所有的数里面选择一个最大的数放在无序部分中最后一个位置
        //无序部分[0,array.length-i)  有序部分[array.length-i,array.length)
        for(int i=0;i<array.length;i++){
            int max=0;
            for(int j=1;j<array.length-i;j++){
                if(array[j]>array[max]){
                    max=j;//通过内部循环，找出最大的数的坐标
                }
            }
            //将最大的数放在数组中无序部分的的最后一个位置
            //即 无序部分中将最大的数与最后一个数互换位置
            int t=array[array.length-i-1];
            array[array.length-i-1]=array[max];
            array[max]=t;
        }

    }

    public static void main(String[] args) {

     int[] array=new int[]{1,3,8,2,0,11,6,7,21,9};

     selectSort(array);
        System.out.println(Arrays.toString(array));
    }
}
