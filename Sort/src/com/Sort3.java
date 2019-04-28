package com;

/**
 * Author:Fanleilei
 * Created:2019/4/27 0027
 */
public class Sort3 {


    //快速排序  将数组中最后一个数作为基准值
    public static int[] quickSort(int[] array){


        quickSortInner(array,0,array.length-1);

        return array;

    }

    public static void quickSortInner(int[]array,int left,int right){

        if(left==right){
            return;

        }
        if (left > right) {

            return;
        }
        int pivot=parition(array,left,right);//基准值最后所在的下标
        //然后再对基准值左边区间进行快速排序，对基准值右边的区间进行排序
        quickSortInner(array,left,pivot-1);
        quickSortInner(array,pivot+1,right);
    }
    //返回基准值   hover法
    public static int parition(int[] array,int left,int right){
        int begin=left;
        int end=right;
        int pivot=array[right];//基准值
        while(begin<end){
            while(begin<end&&array[begin]<=pivot){
                begin++;
            }
            while(begin<end&&array[end]>=pivot){
                end--;
            }
            swap(array,begin,end);

        }
        //最后将基准值放在中间
        swap(array,begin,right);//基准值左边的数都比基准值小，基准值右边的数都比基准值大
        return  begin;
    }


    //挖坑法
    public static int parition2(int[] array,int left,int right){

        int begin=left;
        int end=right;
        int prvot=array[right];
        while(begin<end){
            while(begin<end &&array[begin]<=prvot){
                       begin++;

            }
            array[end]=array[begin];

            while(begin<end &&array[end]>=prvot){
                end--;

            }
            array[begin]=array[end];


        }
           array[begin]=prvot;

           return begin;

    }

    //前后下标法  6 3 5 4 7 2 6 8 9 1 0 7 5
       //0~d之间是小于基准值的，d~i之间是大于基准值的
    public static int parition3(int[] array,int left,int right){
        int d=left;
        for(int i=left;i<right;i++){

            if(array[i]<array[right]){
                swap(array,d,i);
                d++;

            }
        }

        //将基准值与下标为d的位置的数位置互换
        swap(array,d,right);
        return d;

    }


    public static void swap(int[] array,int left,int right){

        int t=array[left];
        array[left]=array[right];
        array[right]=t;

    }
    public static void main(String[] args) {
        int[] array=new int[]{9,3,1,5,2,4,3,8,7,6};
        int[] result=quickSort(array);

        for(int t:result){

            System.out.print(t+" ");
        }
    }
}
