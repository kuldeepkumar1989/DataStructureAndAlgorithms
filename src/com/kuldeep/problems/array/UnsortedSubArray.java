package com.kuldeep.problems.array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class UnsortedSubArray {
    public static void main(String args[]){
        int [][] arr = {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
        //Sort heights in decreasing order
        reconstructQueue(arr);
    }
    public static int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);  // compare (h, k) by h in reverse order; in case of ties compare k
        List<int[]> list = new LinkedList<>();
        for(int[] p: people) {
            list.add(p[1], p);
        }
        System.out.println("k");
        return list.toArray(new int[people.length][2]);
    }
}
