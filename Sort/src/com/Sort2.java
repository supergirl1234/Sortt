package com;

/**
 * Author:Fanleilei
 * Created:2019/4/27 0027
 */
public class Sort2 {


    //选择排序    每次在无序区间选择一个最大的数放在后面

    public static  int[] selectSort(int[] array){

     for(int i=0;i<array.length;i++){
         //无序区间[0,i)  有序区间 [i,array.length)
         int max=0;
         //在无序区间找出最大的
         for(int j=1;j<array.length-i;j++){
             if(array[j]>array[max]){
                 max=j;

             }

         }
         //将最大的放在有序区间
         int t=array[max];
         array[max]=array[array.length-i-1];
         array[array.length-i-1]=t;
     }

     return array;

    }

    //冒泡排序   把大的往上冒  最后排成  小...大
    public static  int[] bubbleSort(int[] array){

        for(int i=0;i<array.length;i++){

            for(int j=0;j<array.length-i-1;j++){

                if(array[j]>array[j+1]){
                //互换位置
                    int temp=array[j+1];
                    array[j+1]=array[j];
                    array[j]=temp;
                }

            }
        }

      return array;
    }
    //冒泡排序   把小的往下冒  最后排成  小...大
    public static  int[] bubbleSort2(int[] array){

        for(int i=0;i<array.length;i++){
            for(int j=array.length-1;j>i;j--){
                if(array[j]<array[j-1]){
                    int t=array[j];
                    array[j]=array[j-1];
                    array[j-1]=t;

                }

            }


        }

        return array;
    }

    //堆排序  已经成为大堆后，把最大的array[0]和最后一个互换位置，然后又继续堆化，再将最大的array[0]和最后一个（不包括前面换下来的那个最大的数）互换位置，
    public static  int[] heapSort(int[] array){
        //1.先建堆
         createHeap(array);
         //2.把最大的array[0]和最后一个互换位置，然后又继续堆化，再将最大的array[0]和最后一个（不包括前面换下来的那个最大的数）互换位置，

        for(int i=0;i<array.length;i++) {
            //最大得数为array[0],
            swap(array, 0, array.length - 1-i);
            //size:剩余无序部分的长度
            heapify(array,array.length-1-i,0);
        }

         return array;

    }

    //建堆
    //   从最后一个非叶子结点一直到0，不断向下调整。
    public static void createHeap(int[] array){
      for (int i=(array.length-2)/2;i>=0;i--) {

           heapify(array,array.length,i);
       }
    }
    //向下调整（堆化）  堆化的前提是对于一个完全二叉树，除了一个位置之外，其他位置都已经满足了堆的性质
    public static  void heapify(int[] array,int size,int index){
        //判断index是不是叶子
        while(2*index+1<size){
            //找到最大孩子的下标
               int max=2*index+1;
               if(max+1<size&&array[max+1]>array[max]){
                   max=2*index+2;
               }

               //判断最大孩子和跟的值
            if(array[index]<array[max]){
                   swap(array,index,max);
                   index=max;
            }else {
                   //根的值比较大，可以直接结束了
                   break;
            }

        }

    }

    public  static void swap(int[] array,int i,int j){
        int t=array[i];
        array[i]=array[j];
        array[j]=t;

    }
    public static void main(String[] args) {
     int[] array=new int[]{9,10,3,5,7,2,1,4};
        //int[] result=bubbleSort1(array);
        //int[] result=bubbleSort2(array);
        //int[] result=heapSort(array);
        int[] result=selectSort(array);

        for(int t:result){

            System.out.print(t+" ");
        }
    }
}
