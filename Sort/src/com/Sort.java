package com;

/**
 * Author:Fanleilei
 * Created:2019/4/27 0027
 */
public class Sort {


    //插入排序   遍历查找

    /**
     *
     * 时间复杂度
     * 最坏
     * 最好：
     *  @param array
     */

    //查找和插入是分开的
    public static int[] insertSort1(int[] array){

        for(int i=0;i<array.length;i++){
            //有序[0,i)  无序[i,array.length)  每次让一个数有序
             //array[i]前面的数都是有序的
            int j;
            for(j=i-1;j>0&&array[i]<array[j];j--){ //j、i
                   //通过这个地方可以知道i前面所有大于array[i]的
                   //最后得到的j，（j，i）之间的数都比array[i]大
            }
            //然后将array[i]插入到j+1的位置处
            int pos=j+1;
            int key=array[i];
            for(int k=i;k>pos;k--){
                array[k]=array[k-1];
            }

            array[pos]=key;
        }
        return array;
    }





    //查找和插入是同时的
    public static int[] insertSort2(int[] array){

        //依次查找
        for(int i=0;i<array.length;i++) {
            //有序区间[0,i)  无序区间[i,array.length)
            //将要插入的数array[i]与有序区间的数进行比较
            int j = i - 1;
            int t = array[i];
            for (; j >= 0; j--) {
                if (t>=array[j]) {
                    //啥也不干
                    break;
                } else {
                    //将array[i]插入到有序区间内,将其前面的比他大的数后移

                    array[j + 1] = array[j];
                    array[j] = t;
                }


            }
        }

        return array;
    }

    //插入排序 遍历查找 也可以用二分查找  追求稳定性
    public static int[] insertSort3(int[] array){

      for(int i=0;i<array.length;i++){
          int key=array[i];
          int left=0;
          int right=i;
          while(left<right){
              int mid=left+(right-left)/2;
              if(key==array[mid]){
                  left=mid+1;

              }else if(key<array[mid]){
                  right=mid;

              }else{
                  left=mid+1;
              }

          }
          int pos=left;
          for(int k=i;k>pos;k--){

              array[k] = array[k - 1];
          }
          array[pos] = key;
      }

      return array;
    }


    //希尔排序
    public static int[] xierSort(int[] array){

        int gap=array.length;
        while(true){
            gap=(gap/3)+1;
            insertSortWithGap(array,gap);
            if(gap==1){
                break;
            }
        }
        return array;


    }

    private static void insertSortWithGap(int[] array, int gap) {
        for(int i=0;i<array.length;i++){
            int key=array[i];
            int j=i-gap;
            for(;j>=0&&key<array[j];j=j-gap){
                array[j+gap]=array[j];

            }
            array[j+gap]=key;


        }
    }


    public static void main(String[] args) {
         int[] array=new int[]{2,7,8,3,9,11,2,5};
         //int[] result=insertSort1(array);
         int[] result=insertSort2(array);
         //int[] result=insertSort3(array);
         //int[] result=xierSort(array);
         for(int t:result){
             System.out.print(t+" ");

         }
    }





}
