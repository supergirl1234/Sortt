package com;

import java.util.Arrays;

/**
 * Author:Fanleilei
 * Created:2019/5/2 0002
 */
public class BubbleSort {

    private static void bubbleSort(int[] array){

        //将最大的数往后冒
        //外层循环控制循环的次数
        for (int i=0;i<array.length;i++){
            //内层循环，每两个相邻的数进行比较
            for(int j=0;j<array.length-1;j++){

                //如果前面的数大于后面的数，就进行交换
                if(array[j]>array[j+1]){
                    //交换位置
                    int t=array[j];
                    array[j]=array[j+1];
                    array[j+1]=t;
                }
            }
        }


    }

    public static void main(String[] args) {

        int[] array=new int[]{1,3,8,2,0,11,6,7,21,9};

        bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }
}
