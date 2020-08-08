package com.kuldeep.problems.array;

public class SubArraySum {
    /**
     * Kadane's Algorithm
     * @param args
     * @author Kuldeep
     */
    public static void main(String args[]){
       // int [] arr = { -2, -3, 4, -1, -2, 1, 5, -3 };
        int [] arr = { -2, -1 };
        printIndexOfMaxSum(arr);
    }
    private static void printIndexOfMaxSum(int arr[]) {

//        if(arr==null){
//            return 0;
//        }
//        if(arr.length==1){
//            return nums[0];
//        }
        int maxSoFar =  arr[0];
        int maxEndingHere = arr[0];
        int end=0,start=0;

        for(int i=1; i<arr.length;i++){
            if(arr[i]>arr[i]+maxEndingHere){
                maxEndingHere=arr[i];
                start=i;
            } else {
                maxEndingHere = arr[i]+maxEndingHere;
            }
            if(maxSoFar<maxEndingHere){
                maxSoFar=maxEndingHere;
                end=i;
            }
        }
        System.out.println(maxSoFar);
        System.out.println(start+" "+end);
    }
}
